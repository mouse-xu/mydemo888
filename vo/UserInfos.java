package com.njbdqn.mydemo888.vo;

import java.util.Date;

public class UserInfos {
    private Integer userId;
    private  String userName;
    private Date birthday;
    private String userPhoto;
    private  Float money;

    public UserInfos() {
    }

    public UserInfos(String userName, Date birthday, String userPhoto) {
        this.userName = userName;
        this.birthday = birthday;
        this.userPhoto = userPhoto;
    }

    public UserInfos(Integer userId, String userName, Date birthday, String userPhoto) {
        this.userId = userId;
        this.userName = userName;
        this.birthday = birthday;
        this.userPhoto = userPhoto;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }
}
