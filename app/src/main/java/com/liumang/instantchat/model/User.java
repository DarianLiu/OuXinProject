package com.liumang.instantchat.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 用户信息
 */
@Entity
public class User {

    @Id(autoincrement = true)
    private Long id;

    @NotNull
    private String userName;

    private String userNickName;

    private Long phone;

    @Generated(hash = 1557265233)
    public User(Long id, @NotNull String userName, String userNickName,
            Long phone) {
        this.id = id;
        this.userName = userName;
        this.userNickName = userNickName;
        this.phone = phone;
    }

    @Generated(hash = 586692638)
    public User() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserNickName() {
        return this.userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    public Long getPhone() {
        return this.phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }
}
