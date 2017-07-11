package com.liumang.instantchat;

import android.app.Application;

import org.greenrobot.greendao.AbstractDaoMaster;
import org.greenrobot.greendao.AbstractDaoSession;

import io.rong.imkit.RongIM;

/**
 * 初始化融云
 * Created by LiuLi on 2017/7/5.
 */
public class MyApplication extends Application {

//    public AbstractDaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        RongIM.init(this);
    }
}
