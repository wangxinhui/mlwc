package com.mlwc.upms;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MlwcUpmsRpcServiceApplication {
    public static void main(String[] args) {
        System.out.println(">>>> starting");
        new ClassPathXmlApplicationContext("classpath:META-INF/spring/*.xml");
        System.out.println(">>>> started");
    }
}
