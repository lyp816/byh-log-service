package com.ebaiyihui.log.annotation;

import com.ebaiyihui.log.enums.LogActionType;

import java.lang.annotation.*;

/**
 * @author lyp
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Log {
    String value() default "";

    /**
     * 是否启用
     *
     * @return
     */
    boolean enable() default true;

    LogActionType type() default LogActionType.SELECT;
}
