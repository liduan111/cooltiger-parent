package com.kyj.cooltiger.common.enums;

/**
 * @author liduan
 * Description:
 * date: 2020/7/30 17:00
 */
public enum StatusCode {
    SUCCESS("OK", "成功"),
    ERROR("ERROR", "失败");


    private String code;
    private String msg;

    StatusCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }


    public String getMsg() {
        return msg;
    }
}
