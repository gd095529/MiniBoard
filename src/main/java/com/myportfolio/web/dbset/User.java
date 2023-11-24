package com.myportfolio.web.dbset;

import java.util.Date;

public class User {
    private String id;
    private String pwd;
    private Date birth;
    private String name;
    private String email;

    public User(){}
    public User(String id, String pwd, Date birth, String name, String email) {
        this.id = id;
        this.pwd = pwd;
        this.birth = birth;
        this.name = name;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", pwd='" + pwd + '\'' +
                ", birth=" + birth +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
