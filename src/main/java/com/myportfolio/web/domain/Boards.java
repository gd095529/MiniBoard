package com.myportfolio.web.domain;

import java.time.LocalDateTime;

public class Boards {
    private Integer id;
    private String title;
    private String content;
    private Integer view_cnt;
    private LocalDateTime created_date;
    private LocalDateTime updated_date;
    private Integer user_id;
    private Integer comment_cnt;

    public Boards(){}

    @Override
    public String toString() {
        return "Posts{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", view_cnt=" + view_cnt +
                ", created_date=" + created_date +
                ", updated_date=" + updated_date +
                ", user_id=" + user_id +
                ", comment_cnt=" + comment_cnt +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getView_cnt() {
        return view_cnt;
    }

    public void setView_cnt(Integer view_cnt) {
        this.view_cnt = view_cnt;
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

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getComment_cnt() {
        return comment_cnt;
    }

    public void setComment_cnt(Integer comment_cnt) {
        this.comment_cnt = comment_cnt;
    }

    public Boards(Integer id, String title, String content, Integer view_cnt, LocalDateTime created_date, LocalDateTime updated_date, Integer user_id, Integer comment_cnt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.view_cnt = view_cnt;
        this.created_date = created_date;
        this.updated_date = updated_date;
        this.user_id = user_id;
        this.comment_cnt = comment_cnt;
    }
}
