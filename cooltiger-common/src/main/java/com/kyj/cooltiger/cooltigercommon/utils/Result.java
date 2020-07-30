package com.kyj.cooltiger.cooltigercommon.utils;

/**
 * @author liduan
 * Description:  返回类型
 * date: 2020/7/30 16:31
 */
public class Result {
    //返回结果
    private Boolean flag;
    //返回码
    private Integer code;
    //返回信息
    private String msg;
    //返回数据
    private Object data;

    public Result(Boolean flag, Integer code, String msg, Object data) {
        this.flag = flag;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
