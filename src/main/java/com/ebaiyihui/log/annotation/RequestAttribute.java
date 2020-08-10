/**
 * 
 */
package com.ebaiyihui.log.annotation;

import com.ebaiyihui.log.util.StringUtil;

import java.lang.annotation.*;


/**
 * @author threenoodles
 *
 */
@Target(ElementType.PARAMETER)  
@Retention(RetentionPolicy.RUNTIME)  
@Documented  
public @interface RequestAttribute {  
  
    /** 
     * The request attribute parameter to bind to. 
     */  
    String value() default StringUtil.EMPTY_STRING;
      
}  
