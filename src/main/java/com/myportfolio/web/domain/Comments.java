package com.myportfolio.web.domain;

import java.time.LocalDateTime;

public class Comments {
    private Integer id;
    private String comment;
    private LocalDateTime created_date;
    private LocalDateTime updated_date;
    private Integer post_id;
    private Integer user_id;

    public Comments(){}
    public Comments(Integer id, String comment, LocalDateTime created_date, LocalDateTime updated_date, Integer post_id, Integer user_id) {
        this.id = id;
        this.comment = comment;
        this.created_date = created_date;
        this.updated_date = updated_date;
        this.post_id = post_id;
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Comments{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                ", created_date=" + created_date +
                ", updated_date=" + updated_date +
                ", post_id=" + post_id +
                ", user_id=" + user_id +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getCreated_date() {
        return created_date;
    }

    public void setCreated_date(LocalDateTime created_date) {
        this.created_date = created_date;
    }

    public LocalDateTime getUpdated_date() {
        return updated_date;
    }

    public void setUpdated_date(LocalDateTime updated_date) {
        this.updated_date = updated_date;
    }

    public Integer getPost_id() {
        return post_id;
    }

    public void setPost_id(Integer post_id) {
        this.post_id = post_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
}
