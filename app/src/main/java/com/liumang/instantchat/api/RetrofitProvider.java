package com.liumang.instantchat.api;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Retrofit网络请求设置
 * Created by Geek_LiuLi on 17/6/30
 */
public class RetrofitProvider {

    private static Retrofit retrofit;

    private RetrofitProvider() {
    }

    // Retrofit是基于OkHttpClient的，可以创建一个OkHttpClient进行一些配置
    private static OkHttpClient httpClient = new OkHttpClient.Builder()
            // 添加通用的Header
            .addInterceptor(chain -> {
                Request.Builder builder = chain.request().newBuilder();
                // 替换为自己的token
                builder.addHeader("token", "123");
                return chain.proceed(builder.build());
            })
            /*
            这里可以添加一个HttpLoggingInterceptor，因为Retrofit封装好了从Http请求到解析，
            出了bug很难找出来问题，添加HttpLoggingInterceptor拦截器方便调试接口
             */
            .addInterceptor(new HttpLoggingInterceptor(message -> Log.e("====okHtt3===", message))
                    .setLevel(HttpLoggingInterceptor.Level.BASIC))
            .connectTimeout(APIs.TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(APIs.TIMEOUT, TimeUnit.SECONDS)
            .build();

    public static Retrofit getInstance() {
        if (retrofit == null) {
            // 服务器返回的code统一处理
            Gson gson = new GsonBuilder()
                    .registerTypeAdapterFactory(new ApiTypeAdapterFactory("data"))
                    .create();
            retrofit = new Retrofit.Builder()
                    .baseUrl(APIs.Base.BASE_URL)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(httpClient)
                    .build();
        }
        return retrofit;

    }
}
