package com.gdut.bankmanagesystem.common.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author honzooban
 * @version 1.0.0
 * @Description
 * @createTime 2021年01月04日 15:32:00
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Role {

    String value() ;
}
