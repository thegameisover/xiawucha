package com.example.tea.JavaClass;

public class user {
    private int id;
    private String account;
    private String password;
    private String username;
    private String picture;
    private String birthday;
    private int manager;

    public user()
    {

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setManager(int manager) {
        this.manager = manager;
    }

    public int getId() {
        return id;
    }

    public String getAccount() {
        return account;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public String getPicture() {
        return picture;
    }

    public String getBirthday() {
        return birthday;
    }

    public int getManager() {
        return manager;
    }


}
