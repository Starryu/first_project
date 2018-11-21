package com.yu.example.first_project.vo;

/**
 * 用户实体类
 */
public class UserVO {

    private Integer userId;

    private String userName;


    private String userPassword;


    private String email;


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


    public String getUserPassword() {
        return userPassword;
    }


    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}