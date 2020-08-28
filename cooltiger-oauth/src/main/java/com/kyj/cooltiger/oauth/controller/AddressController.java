package com.kyj.cooltiger.oauth.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.kyj.cooltiger.common.excep.MyException;
import com.kyj.cooltiger.common.utils.CharUtil;
import com.kyj.cooltiger.common.utils.FileTypeUtil;
import com.kyj.cooltiger.common.utils.FtpUtil;
import com.kyj.cooltiger.feign.oauth.client.AddressClient;
import com.kyj.cooltiger.oauth.config.FtpConfig;
import com.kyj.cooltiger.oauth.entity.AddressVo;
import com.kyj.cooltiger.oauth.service.AddressService;
import com.kyj.cooltiger.oauth.utils.ApiBaseAction;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/8/6 15:33
 */
@Api("收货地址接口")
@RestController
@RequestMapping("/api/address")
public class AddressController extends ApiBaseAction  implements AddressClient {

    @Autowired
    private AddressService addressService;

    @Autowired
    private FtpConfig ftpConfig;

    /**
     * 收货地址列表
     * @return
     */
    @ApiOperation("收货地址列表")
    @RequestMapping(value = "/addresslist",method = RequestMethod.GET)
    public  Object Addresslist(@RequestBody Map<String,Object> map){
        List<AddressVo>  addressVoList=addressService.addresslist(map);

        return toResponsSuccess(addressVoList);
    }


    /**
     * 根据用户名id查询收货地址
     * @param code
     * @return
     */
    @ApiOperation("根据用户名查询收货地址")
    @RequestMapping(value = "/queryaddress",method = RequestMethod.GET)
    public Object queryaddress(@RequestBody String code){
        JSONObject object= JSON.parseObject(code);
        Long   userId=Long.valueOf(object.getString("userId").toString());
        if (userId!=null||userId!=0) {
            AddressVo addressVo = addressService.queryByuserCode(userId);
            return toResponsSuccess(addressVo);
        }else {
            return  toResponsFail("用户名为空");
        }
    }

    /**
     * 添加收货人地址
     * @param userCode
     * @param userName
     * @param mobile
     * @param provinceName
     * @param cityName
     * @param countryName
     * @param addressDetail
     * @param isDefaul
     * @param idcardz
     * @param idcardf
     * @return
     */
    @ApiOperation("添加收货人地址")
    @RequestMapping(value = "/addressadd",method = RequestMethod.POST)
    public  Object  addressave(@RequestParam(value = "userCode", required = false) Long userCode,
                               @RequestParam(value = "userName", required = false) String userName,
                               @RequestParam(value = "mobile", required = false) String  mobile,
                               @RequestParam(value = "provinceName", required = false) String  provinceName,
                               @RequestParam(value = "cityName", required = false) String cityName,
                               @RequestParam(value = "countryName", required = false) String countryName,
                               @RequestParam(value = "addressDetail", required = false) String addressDetail,
                               @RequestParam(value = "isDefaul", required = false) Integer isDefaul,
                               @RequestParam(value = "idcardz", required = false) MultipartFile idcardz,
                               @RequestParam(value = "idcardf", required = false) MultipartFile idcardf){
       Map<String,Object>  map=new HashMap<String,Object>();
        map.put("userCode",userCode);
        map.put("userName",userName);
        map.put("mobile",mobile);
        map.put("provinceName",provinceName);
        map.put("cityName",cityName);
        map.put("countryName",countryName);
        map.put("addressDetail",addressDetail);
        map.put("isDefaul",isDefaul);
        if (map.isEmpty()||map.size()==0) {
           return new MyException("500","传参为空");
       }
        if (idcardz == null || idcardz.isEmpty()||idcardf==null||idcardf.isEmpty()) {
           return new MyException("500","身份证不能为空");
        }
        //1、给上传的图片生成新的文件名
        //1.1获取原始文件名
        String filenamez = idcardz.getOriginalFilename();
        String filenamef = idcardf.getOriginalFilename();
        //1.1.1根据文件名字判断是否为图片，支持（jpg png gif bmp）
        if(!FileTypeUtil.isImageByName(filenamez)){
            return   new MyException("PICTURE_FORMAT_ERROR","图片格式错误");
        }
        if(!FileTypeUtil.isImageByName(filenamef)){
            return   new MyException("PICTURE_FORMAT_ERROR","图片格式错误");
        }
        //1.2使用CharUtil工具类生成新图片名（时间戳+随机字符串）+ 后缀名
        String shenZ = CharUtil.getImageName(25) + filenamez.substring(filenamez.lastIndexOf("."));
        String shenF = CharUtil.getImageName(25) + filenamef.substring(filenamef.lastIndexOf("."));
        //1.3生成文件在服务器端存储的子目录
        String filePath = "/idcards";
        String filePath1 = "/idcardsf";
       /* String   idcardzUrl=ftpConfig.getImageBaseUrl() + filePath + "/" +shenZ;
        String   idcardfUrl=ftpConfig.getImageBaseUrl() + filePath + "/" +shenF;*/
        boolean flag = addressService.addresssave(map,ftpConfig.getImageBaseUrl() + filePath + "/" +shenZ,ftpConfig.getImageBaseUrl() + filePath1 + "/" +shenF);
        if (flag) {
            //3、调用FtpUtil工具类上传图片
            FtpUtil ftpUtil = new FtpUtil();
            boolean result = ftpUtil.uploadFile(ftpConfig.getHost(), ftpConfig.getPort(), ftpConfig.getUserName(),
                    ftpConfig.getPassWord(), ftpConfig.getBasePath(), filePath, shenZ, idcardz);
            boolean res = ftpUtil.uploadFile(ftpConfig.getHost(), ftpConfig.getPort(), ftpConfig.getUserName(),
                    ftpConfig.getPassWord(), ftpConfig.getBasePath(), filePath1, shenF, idcardf);
            if (!result) {
                return new MyException("PICTURE_UPLOAD_ERROR", "身份证正面上传失败");
            }
            if (!res) {
                return new MyException("PICTURE_UPLOAD_ERROR", "身份证反面上传失败");
            }
            return toResponsMsgSuccess("添加成功");
        }
        return toResponsFail("添加失败");
    }

    /**
     * 修改收货人地址
     * @param userCode
     * @param Id
     * @param userName
     * @param mobile
     * @param provinceName
     * @param cityName
     * @param countryName
     * @param addressDetail
     * @param isDefaul
     * @param idcardz
     * @param idcardf
     * @return
     */
    @ApiOperation("修改收货人地址")
    @RequestMapping(value = "/addressupdate",method = RequestMethod.PUT)
    public  Object  addressupdate(@RequestParam(value = "userCode", required = false) Long userCode,
                                  @RequestParam(value = "Id", required = false) Long Id,
                                  @RequestParam(value = "userName", required = false) String userName,
                                  @RequestParam(value = "mobile", required = false) String  mobile,
                                  @RequestParam(value = "provinceName", required = false) String  provinceName,
                                  @RequestParam(value = "cityName", required = false) String cityName,
                                  @RequestParam(value = "countryName", required = false) String countryName,
                                  @RequestParam(value = "addressDetail", required = false) String addressDetail,
                                  @RequestParam(value = "isDefaul", required = false) Integer isDefaul,
                                  @RequestParam(value = "idcardz", required = false) MultipartFile idcardz,
                                  @RequestParam(value = "idcardf", required = false) MultipartFile idcardf){

        Map<String,Object>  map=new HashMap<String,Object>();
        map.put("Id",Id);
        map.put("userCode",userCode);
        map.put("userName",userName);
        map.put("mobile",mobile);
        map.put("provinceName",provinceName);
        map.put("cityName",cityName);
        map.put("countryName",countryName);
        map.put("addressDetail",addressDetail);
        map.put("isDefaul",isDefaul);
        if (map.isEmpty()||map.size()==0) {
            return new MyException("500","传参为空");
        }
        if (idcardz == null || idcardz.isEmpty()||idcardf==null||idcardf.isEmpty()) {
            return new MyException("500","身份证不能为空");
        }
        //1、给上传的图片生成新的文件名
        //1.1获取原始文件名
        String filenamez = idcardz.getOriginalFilename();
        String filenamef = idcardf.getOriginalFilename();
        //1.1.1根据文件名字判断是否为图片，支持（jpg png gif bmp）
        if(!FileTypeUtil.isImageByName(filenamez)){
            return   new MyException("PICTURE_FORMAT_ERROR","图片格式错误");
        }
        if(!FileTypeUtil.isImageByName(filenamef)){
            return   new MyException("PICTURE_FORMAT_ERROR","图片格式错误");
        }
        //1.2使用CharUtil工具类生成新图片名（时间戳+随机字符串）+ 后缀名
        String shenZ = CharUtil.getImageName(25) + filenamez.substring(filenamez.lastIndexOf("."));
        String shenF = CharUtil.getImageName(25) + filenamef.substring(filenamef.lastIndexOf("."));
        //1.3生成文件在服务器端存储的子目录
        String filePath = "/idcards";
        String filePath1 = "/idcardsf";
       /* String   idcardzUrl=ftpConfig.getImageBaseUrl() + filePath + "/" +shenZ;
        String   idcardfUrl=ftpConfig.getImageBaseUrl() + filePath + "/" +shenF;*/
        boolean flag = addressService.addressupdate(map,ftpConfig.getImageBaseUrl() + filePath + "/" +shenZ,ftpConfig.getImageBaseUrl() + filePath1 + "/" +shenF);
        if (flag) {
            //3、调用FtpUtil工具类上传图片
            FtpUtil ftpUtil = new FtpUtil();
            boolean result = ftpUtil.uploadFile(ftpConfig.getHost(), ftpConfig.getPort(), ftpConfig.getUserName(),
                    ftpConfig.getPassWord(), ftpConfig.getBasePath(), filePath, shenZ, idcardz);
            boolean res = ftpUtil.uploadFile(ftpConfig.getHost(), ftpConfig.getPort(), ftpConfig.getUserName(),
                    ftpConfig.getPassWord(), ftpConfig.getBasePath(), filePath1, shenF, idcardf);
            if (!result) {
                return new MyException("PICTURE_UPLOAD_ERROR", "身份证正面上传失败");
            }
            if (!res) {
                return new MyException("PICTURE_UPLOAD_ERROR", "身份证反面上传失败");
            }
            return toResponsMsgSuccess("修改成功");
        }
        return toResponsFail("修改失败");
    }
}
