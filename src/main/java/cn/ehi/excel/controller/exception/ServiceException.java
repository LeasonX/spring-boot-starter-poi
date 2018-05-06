package cn.ehi.excel.controller.exception;

import cn.ehi.excel.controller.annotation.ErrorCode;
import cn.ehi.excel.controller.annotation.ErrorMessage;

public class ServiceException extends RuntimeException {

    private int code;

    private String message;

    public ServiceException(@ErrorCode int code,@ErrorMessage String message){
        super(message);
        this.message = message;
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }
}
