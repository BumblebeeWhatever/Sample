package com.android.sample.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by hexiaolei on 2017/7/16.
 * 记录在coding或reading the fucking source时的技巧点
 */

@Target({ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.PARAMETER,ElementType.PACKAGE,
        ElementType.FIELD, ElementType.LOCAL_VARIABLE, ElementType.ANNOTATION_TYPE, ElementType.TYPE})
@Retention(RetentionPolicy.SOURCE)
public @interface Skill {

    String value() default "";

}
