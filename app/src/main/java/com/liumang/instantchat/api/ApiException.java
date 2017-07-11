package com.liumang.instantchat.api;

import java.io.IOException;

/**
 * 服务器端返回的异常处理
 */
public class ApiException extends IOException {

    public final int code;
    public final String msg;

    public ApiException(int code) {
        this.code = code;
        this.msg = null;
    }

    public ApiException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
