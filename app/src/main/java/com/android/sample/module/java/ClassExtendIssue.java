package com.android.sample.module.java;

import com.android.sample.annotation.Skill;

/**
 * Created by hexiaolei on 2017/7/16.
 * 对于ChildClas extend ParentClass，编译时父类会包含所有的代码，而子类不会包含从父类继承属性的字节码，这就是为什么反射需要找到父类取属性的原因；
 * 非静态内部类编译出的字节码中构造器会默认把外部类的实例作为参数引入，o,my god!~； 静态内部类就不会
 * 得多多自己编class呀，胸弟
 */

public class ClassExtendIssue {

    public static void main(String[] args) {
    }

    public void run() {
        FatherClass classExtendIssue = new FatherClass();
//        FatherClass.ObjectChildClass objectChildClass = new FatherClass.ObjectChildClass();//compile error

    }

    static class FatherClass {

        private static String staticStr = "123";
        private String objectStr = "345";

        //FIXME  子继承外部类，那么new外部类时，是否会初始化这个类？如果初始化这个类，这个类是否会继承从外部类继承的“自己”，循环？
        //FIXME 貌似在初始化实例时，子类并没有直接初始化从父类继承到的各类属性，只是能表现出对应的能力，字节码什么的并没有再次初始化，这样也对，否则得多多少无用的字节码
        //FIXME 需要编译出class，然后查看字节码是否符合自己的理解
        @Skill("外部类无法创建这个类的实例")
        //对于宿主类，只是拥有了一个class级别的属性，而不是Object级别，所以没有重复初始化的什么事儿
        class ObjectChildClass extends FatherClass {
            public ObjectChildClass(String arg) {

            }
        }

        static class StaticChildClass extends FatherClass {

        }

        static void run() {
//            @Skill("宿主类中只有非静态类才能访问非静态内部类")
//            ObjectChildClass objectChildClass = new ObjectChildClass();//compile error
        }


    }

}
