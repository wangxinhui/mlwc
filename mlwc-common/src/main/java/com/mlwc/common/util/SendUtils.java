package com.mlwc.common.util;

import com.alibaba.dubbo.common.json.JSONObject;
import com.google.gson.Gson;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author: by simple on 2018/5/9.
 */
public class SendUtils {
    public static void sendHtml(HttpServletResponse response,String str) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter printWriter = response.getWriter();
        printWriter.print(str);
        printWriter.close();
        response.flushBuffer();
    }

    public static void sendJson(HttpServletResponse response, Object o) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.print(new Gson().toJson(o));
        writer.close();
        response.flushBuffer();
    }
}
