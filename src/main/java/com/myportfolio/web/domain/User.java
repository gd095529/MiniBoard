package com.myportfolio.web.domain;

import java.time.LocalDateTime;
import java.util.Date;

public class User {
    private String uid;
    private String pwd;
    private String name;
    private String email;
    private Date created_date;
    private Date updated_date;

    public User(){};

    @Override
    public String toString() {
        return "User{" +
                "uid='" + uid + '\'' +
                ", pwd='" + pwd + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", created_date=" + created_date +
                ", updated_date=" + updated_date +
                '}';
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
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

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public Date getUpdated_date() {
        return updated_date;
    }

    public void setUpdated_date(Date updated_date) {
        this.updated_date = updated_date;
    }

    public User(String uid, String pwd, String name, String email, Date created_date, Date updated_date) {
        this.uid = uid;
        this.pwd = pwd;
        this.name = name;
        this.email = email;
        this.created_date = created_date;
        this.updated_date = updated_date;
    }
}