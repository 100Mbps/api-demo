package com.dgyt.demo.entity;


public class User {

    private String userName;

    private String passWord;

    private Integer age;

    private String status;

    public User(String userName, Integer age) {
        this.userName = userName;
        this.age = age;
    }

    public User(){}

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
