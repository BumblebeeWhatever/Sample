package com.android.sample.module.java;

import com.android.sample.annotation.Skill;

/**
 * Created by hexiaolei on 2017/7/16.
 * 泛型验证
 */

public class GenericType {

    static class DefineGenericType {

        //    T getGenericData(T data) {//compile error
        //        return data;
        //    }

        @Skill("对于泛型的数据类型，需要这样定义<T>，否则编译不过")
        <T> T getGenericData(T data) {
            return data;
        }
    }


}
