package com.mlwc.common.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mlwc.common.rest.JsonResponse;

/**
 * @Author: by simple on 2018/4/17.
 */
public class MyTest {
    public static void main(String[] args) throws JsonProcessingException {
        JsonResponse jsonResponse = new JsonResponse().success("123");
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(jsonResponse);
        System.out.println(s);
    }
}
