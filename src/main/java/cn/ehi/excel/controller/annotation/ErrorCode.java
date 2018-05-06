package cn.ehi.excel.controller.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface ErrorCode {

    int BAD_REQUEST = 400;
    int ILLEGAL_PARAMS = 503;
    int PAGE_NOT_FOUND = 404;
    int SERVER_ERROR = 500;

}
