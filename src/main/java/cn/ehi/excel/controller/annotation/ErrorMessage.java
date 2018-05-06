package cn.ehi.excel.controller.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface ErrorMessage {

    String ILLEGAL_PARAMS = "非法参数";
    String PAGE_NOT_FOUND = "接口不存在";
    String SERVER_ERROR = "服务器内部错误";

}
