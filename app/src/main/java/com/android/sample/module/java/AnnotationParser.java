package com.android.sample.module.java;

import com.android.sample.annotation.Table;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by hexiaolei on 2017/7/4.
 * Class Function:
 */

public class AnnotationParser {

    private static void parseAnnotation(Class<?> cls) {
        Field[] fields = cls.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Table.class)) {
                Table table = field.getAnnotation(Table.class);
                System.out.println("data:" + table.data() + ",num:" + table.num());
            }
        }
        Method[] methods = cls.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Table.class)) {
                Table table = method.getAnnotation(Table.class);
                System.out.println("data:" + table.data() + ",num:" + table.num());
            }
        }
    }


}
