package com.mlwc.common.test;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @Author: by Administrator on 2018/4/9.
 */
public class BaseHibernateDao<T,id extends Serializable> {
    private Class<T> clazz;

    public BaseHibernateDao(){
        //当前对象的直接超类的type
        Type genericSuperclass = getClass().getGenericSuperclass();
        if (genericSuperclass instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
            Type[] types = parameterizedType.getActualTypeArguments();
            this.clazz = (Class<T>) types[0];
        }else {
            this.clazz = (Class<T>) genericSuperclass;
        }
    }

    public Class<T> getClazz() {
        return clazz;
    }
}
