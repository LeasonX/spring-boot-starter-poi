package cn.ehi.excel.controller;

import cn.ehi.excel.controller.annotation.ErrorCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class RestResultGenerator {

    private static final Logger LOGGER =LoggerFactory.getLogger(RestResultGenerator.class);

    private static final int SUCCESS_CODE = 200;
    private static final String SUCCESS_MESSAGE = "SUCCESS";

    private RestResultGenerator(){
        throw new UnsupportedOperationException("工具类不可实例化");
    }

    public static <T> ResponseResult<T> genSuccess(T data){
        return genSuccess(SUCCESS_MESSAGE,data);
    }

    public static <T> ResponseResult<T> genSuccess(String message,T data){
        ResponseResult<T> result = new ResponseResult<>();
        result.setCode(SUCCESS_CODE);
        result.setMessage(message);
        result.setData(data);
//        if(LOGGER.isDebugEnabled()){
//            LOGGER.debug("-----> result:{}", );
//        }
        return result;
    }

    public static <T> ResponseResult<T> genError(@ErrorCode int errorCode,String errorMessage){
        ResponseResult<T> result = new ResponseResult<>();
        result.setCode(errorCode);
        result.setMessage(errorMessage);
//        if(LOGGER.isDebugEnabled()){
//
//        }
        return result;
    }

}
