package com.mlwc.art.controller;

import com.mlwc.common.rest.JsonResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: by simple on 2018/4/27.
 */
@Controller
@RequestMapping("/api")
public class TestApi {
    @RequestMapping("/test")
    public JsonResponse test1(
            @RequestParam(value = "username") String username,
            @RequestParam(value = "password") String password) {
        Map<String, String> map = new HashMap<>();
        map.put("username", username);
        map.put("password", password);
        return new JsonResponse().success(map);
    }
}
