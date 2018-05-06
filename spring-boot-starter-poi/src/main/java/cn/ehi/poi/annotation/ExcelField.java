package cn.ehi.poi.annotation;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface ExcelField {

    String name() default "";

    String dateformat() default "yyyy/m/d h:mm:ss";

}
