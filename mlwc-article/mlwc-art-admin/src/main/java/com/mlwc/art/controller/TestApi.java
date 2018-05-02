package com.mlwc.art.controller;

import com.mlwc.common.rest.JsonResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: by simple on 2018/4/27.
 */
@Controller
@RequestMapping("/api")
public class TestApi {
    @RequestMapping("/test")
    @ResponseBody
    public JsonResponse test1(
            @RequestParam(value = "username",required = false) String username,
            @RequestParam(value = "password",required = false) String password) {
        Map<String, String> map = new HashMap<>();
        map.put("username", "123");
        map.put("password", password);
        return new JsonResponse().success(map);
    }
}
