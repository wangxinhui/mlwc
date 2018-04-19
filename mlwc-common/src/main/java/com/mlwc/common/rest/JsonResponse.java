package com.mlwc.common.rest;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;

/**
 * @Author: by simple on 2018/4/16.
 */

public class JsonResponse implements Serializable{



    private static final String OK = "ok";
    private static final String ERROR = "error";
    private static final long serialVersionUID = 4150440941715450188L;

    public Meta meta;
    public Object data;

    public JsonResponse success(){
        this.meta = new Meta(true, OK);
        return this;
    }

    public JsonResponse success(Object data){
        this.meta = new Meta(true,OK);
        this.data = data;
        return this;
    }

    public JsonResponse failure(){
        this.meta = new Meta(false,ERROR);
        return this;

    }

    public JsonResponse failure(Object data){
        this.meta = new Meta(false,ERROR);
        this.data = data;
        return this;
    }

    public class Meta implements Serializable{
        private static final long serialVersionUID = -6663171259879929699L;
        private boolean success;
        private String message;

        public Meta(boolean success) {
            this.success = success;
        }

        public Meta(boolean success, String message) {
            this.success = success;
            this.message = message;
        }

        public boolean isSuccess() {
            return success;
        }

        public void setSuccess(boolean success) {
            this.success = success;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
