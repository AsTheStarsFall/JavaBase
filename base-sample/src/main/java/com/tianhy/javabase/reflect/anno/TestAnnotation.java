package com.tianhy.javabase.reflect.anno;

import java.lang.annotation.*;

/**
 * @Desc:
 * @Author: thy
 * @CreateTime: 2019/3/31
 **/
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TestAnnotation {
    String value()default "";
}
