package com.android.sample.module.java;

import android.view.View;

import java.lang.reflect.Method;

/**
 * Created by hexiaolei on 2017/7/16.
 */

public class JavaClassUtils {

    public static void main(String[] args) {
        method_getDeclaringClass();
    }

    /**
     * 返回这个方法是哪个类声明的
     * 其实就是返回编译出的class文件中的某个方法(包含静态和非静态方法)所归属的类，如果重写了就是本类而不是父类{@link JavaClassUtils#hashCode()}
     */
    static void method_getDeclaringClass() {
        JavaClassUtils javaClassUtils = new JavaClassUtils();
        Method[] methods = javaClassUtils.getClass().getMethods();
        for (int i = 0; i < methods.length; i++) {
            System.out.println("method name:" + methods[i].getName() + ", " + methods[i].getDeclaringClass());
            System.out.println();
        }

        System.out.println("-----------------------");

        Class<?>[] classes = new ChildClass().getClass().getDeclaredClasses();
        for (int i = 0; i < classes.length; i++) {
            System.out.println("name:" + classes[i]);
        }

    }

    public void objectRun() {

    }

    public static void staticRun() {

    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    static class ChildClass extends JavaClassUtils implements View.OnClickListener{

        @Override
        public void onClick(View v) {

        }
    }
}
