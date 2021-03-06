package com.kyj.cooltiger.common.utils;

import com.kyj.cooltiger.common.excep.MyException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Pattern;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/7/28 16:42
 * 获取字符串，生成字符串工具类
 */
public class CharUtil {

    private static Logger log = LoggerFactory.getLogger(CharUtil.class);

    private static final long EPOCH = 1479533469598L; //开始时间,固定一个小于当前时间的毫秒数
    private static final int max12bit = 4095;
    private static final long max41bit= 1099511627775L;
    private static String machineId = "" ; // 机器id

    private static final long LIMIT = 10000000000L;
    private static long last = 0;

    /**
     * 获取随机字符串（字母加数字）
     *
     * @param num
     * @return
     */
    public static String getRandomString(Integer num) {
        String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < num; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    /**
     * 获取随机字符串（数字）
     *
     * @param num
     * @return
     */
    public static String getRandomNum(Integer num) {
        String base = "0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < num; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    /**
     * 获取随机字符串（字母加数字加%&=）
     *
     * @param num
     * @return
     */
    public static String getRandom(Integer num) {
        String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789%&=";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < num; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    /**
     * 生成图片随机名字
     *
     * @param num
     * @return
     */
    public static String getImageName(Integer num){
        //取当前时间的长整形值包含毫秒
        long millis = System.currentTimeMillis();
        String str = millis + getRandomString(num);
        return str;
    }

    /**
     * 生成时间戳+随机数字字符串
     * @param num
     * @return
     */
    public static String getTimeStampRandom(Integer num){
        //取当前时间的长整形值包含毫秒
        long millis = System.currentTimeMillis();
        String str = millis + getRandomNum(num);
        return str;
    }



    /**
     * 右补位，左对齐
     *
     * @param oriStr   原字符串
     * @param len      目标字符串长度
     * @param fillChar 补位字符
     * @return 目标字符串
     */
    public static String padRight(String oriStr, int len, char fillChar) {
        String str = "";
        int strlen = oriStr.length();
        if (strlen < len) {
            for (int i = 0; i < len - strlen; i++) {
                str = str + fillChar;
            }
        }
        str = str + oriStr;
        return str;
    }

    /**
     * 左补位，右对齐
     *
     * @param oriStr   原字符串
     * @param len      目标字符串长度
     * @param fillChar 补位字符
     * @return 目标字符串
     */
    public static String padLeft(String oriStr, int len, char fillChar) {
        int strlen = oriStr.length();
        String str = "";
        if (strlen < len) {
            for (int i = 0; i < len - strlen; i++) {
                str = str + fillChar;
            }
        }
        str = oriStr + str;
        return str;
    }


    /**
     * 生成用户id
     * @return
     */
    public static  String getNewUserId() {
        String ipAddress = "";
     try {
         //获取服务器IP地址
        ipAddress = InetAddress.getLocalHost().getHostAddress();
         System.out.println("ipAddress"+ipAddress);
     }catch (Exception e){
         log.error("getNewUserId=" + e.getMessage());
     }
        //获取UUID
         String uuid = ipAddress + "$" + UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
        //生成后缀
        long suffix = Math.abs(uuid.hashCode() % 100000000);
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
        String time = sdf.format(new Date(System.currentTimeMillis()));
        //生成前缀
        long prefix = Long.parseLong(time) * 100000000;
        String userId = String.valueOf(prefix + suffix);
        return  userId;
    }

    /**
     * 生成用户唯一标识
     * @return
     */
    public  static long createOnlyId(){
        long time = System.currentTimeMillis() - EPOCH  + max41bit;
        System.out.println("time"+String.valueOf(time));
        // 二进制的 毫秒级时间戳
        String base = Long.toBinaryString(time);
        // 序列数
        String randomStr = StringUtils.leftPad(Integer.toBinaryString(new Random().nextInt(max12bit)),12,'0');
        if(StringUtils.isNotEmpty(machineId)){
            machineId = StringUtils.leftPad(machineId, 10, '0');
        }
        //拼接
        String appendStr = base + machineId + randomStr;
        // 转化为十进制 返回
        BigInteger bi = new BigInteger(appendStr, 2);
        return  Long.valueOf(bi.toString());
    }

    /**
     * 生成唯一id
     * @return
     */
    public static long getID() {
        // 10 digits.
        long id = System.currentTimeMillis() % LIMIT;
        if ( id <= last ) {
            id = (last + 1) % LIMIT;
        }
        last = id;
        System.out.println("last*******"+last);
        return last;
    }
   public  static  boolean regexphone(String mobile){
       if (mobile.isEmpty()){
           new MyException("null  mobile","请确认手机号");
       }
       if (mobile.length()!=11){
           new MyException("手机号位数不够","请确认手机号");
       }
       String regex = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$";
       if (Pattern.matches(regex, mobile)) {
           System.out.println("校验成功");
           return  true;
       } else {
           log.error("手机号校验失败");
           new MyException("bushishoujihao","手机号校验失败请确认手机号");
       }

       return false;
   }
    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(getRandomNum(11));
        System.out.println("args = [" + getRandomString(32) + "]");
        System.out.println("userid = [" + getNewUserId() + "]");
        System.out.println("id = [" + createOnlyId() + "]");
        //20072953490030   [4980655978204483]6434911072  6434929313
        String mobile = "15712467832";

        System.out.println("args = [" + regexphone(mobile) + "]");

    }

}
