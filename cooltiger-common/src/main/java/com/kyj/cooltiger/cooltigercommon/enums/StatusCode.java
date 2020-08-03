package com.kyj.cooltiger.cooltigercommon.enums;

/**
 * @author liduan
 * Description:
 * date: 2020/7/30 17:00
 */
public enum StatusCode {
    SUCCESS(200, "成功"),
    ERROR(202, "失败");


    private Integer code;
    private String msg;

    StatusCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }


    public String getMsg() {
        return msg;
    }
}
