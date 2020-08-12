package com.kyj.cooltiger.common.utils;

import com.kyj.cooltiger.common.enums.StatusCode;

/**
 * @author liduan
 * Description:  返回类型
 * date: 2020/7/30 16:31
 */
public class Result {
    //返回码
    private String code;
    //返回信息
    private String msg;
    //返回数据
    private Object data;

    public Result(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 成功响应（带返回数据）
     *
     * @param data
     * @return Result
     */
    public static Result success(Object data) {
        return new Result(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMsg(), data);
    }

    /**
     * 成功响应（不带返回数据）
     *
     * @return Result
     */
    public static Result success() {
        return new Result(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMsg(), null);
    }

    /**
     * 失败响应（固定响应类型）
     *
     * @return Result
     */
    public static Result error() {
        return new Result(StatusCode.ERROR.getCode(), StatusCode.ERROR.getMsg(), null);
    }

    /**
     * 失败响应（自定义响应类型）
     *
     * @return Result
     */
    public static Result error(String code, String msg) {
        return new Result(code, msg, null);
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
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
