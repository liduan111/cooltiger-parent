package com.kyj.cooltiger.product.handler;

import com.kyj.cooltiger.common.excep.MyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;


/**
 * @author liduan
 * Description: 自定义异常处理
 * date: 2020/8/11 9:56
 */
@RestControllerAdvice
public class MyExceptionHandler {

    /**
     * 自定义业务异常处理
     * @param e
     * @return ErrorInfo
     */
    @ExceptionHandler(value = MyException.class)
    public Map myExceptionHandler(MyException e){
        Map map = new HashMap();
        map.put("code", e.getCode());
        map.put("msg", e.getMsg());
        return map;
    }

    /**
     * 全局异常处理
     * @param ex
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public Map errorHandler(Exception ex) {
        Map map = new HashMap();
        map.put("code", "ERROR");
        map.put("msg", ex.getMessage());
        return map;
    }
}
