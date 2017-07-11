package com.liumang.instantchat.base;

public interface DataRequestListener<T> {

    void success(T data);
    void fail();


}