package com.liumang.instantchat.api;

/**
 * 接口Url地址，Http请求调用
 */
public interface APIs {
    /**
     * 测试环境与生产环境切换
     */
    boolean RELEASE_VERSION = true;

    long TIMEOUT = 30;

    interface Base {

        /**
         * -------服务器地址-------
         */
        String IP = RELEASE_VERSION ? "api.sealtalk.im" : "";

        /**
         * -------服务器端口号-------
         */
        String PORT = RELEASE_VERSION ? "" : "";

        /**
         * ------- -------
         */
        String BASE_PROJECT = RELEASE_VERSION ? "" : "";

        /**
         * -------服务器版本号-------
         */
        String VERSION = RELEASE_VERSION ? "" : "";

        String BASE_URL = "http://" + IP + PORT + BASE_PROJECT;
    }

}
