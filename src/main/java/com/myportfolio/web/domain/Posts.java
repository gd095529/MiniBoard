package com.myportfolio.web.domain;

import java.time.LocalDateTime;

public class Posts {
    private Integer id;
    private String title;
    private String content;
    private Integer view;
    private LocalDateTime created_date;
    private LocalDateTime updated_date;
    private Integer user_id;

    @Override
    public String toString() {
        return "Posts{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", view=" + view +
                ", created_date=" + created_date +
                ", updated_date=" + updated_date +
                ", user_id=" + user_id +
                '}';
    }

    public Posts(){}
    public Posts(Integer id, String title, String content, Integer view, LocalDateTime created_date, LocalDateTime updated_date, Integer user_id) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.view = view;
        this.created_date = created_date;
        this.updated_date = updated_date;
        this.user_id = user_id;
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

    public Integer getView() {
        return view;
    }

    public void setView(Integer view) {
        this.view = view;
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
}
