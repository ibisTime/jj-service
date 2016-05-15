/**
 * @Title ServiceModule.java 
 * @Package com.ibis.account.common.annotation 
 * @Description 
 * @author miyb  
 * @date 2015-5-6 上午9:36:09 
 * @version V1.0   
 */
package com.xnjr.mall.spring;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/** 
 * @author: miyb 
 * @since: 2015-5-6 上午9:36:09 
 * @history:
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ServiceModule {

}
