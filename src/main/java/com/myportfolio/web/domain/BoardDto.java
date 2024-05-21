package com.myportfolio.web.domain;

import java.util.Date;

public class BoardDto {
    private Integer bid;
    private String title;
    private String content;
    private String writer;
    private int view_cnt;
    private int comment_cnt;
    private Date create_date;
    private Date update_date;

    public BoardDto() {
    }

    @Override
    public String toString() {
        return "BoardDto{" +
                "bid=" + bid +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                ", view_cnt=" + view_cnt +
                ", comment_cnt=" + comment_cnt +
                ", create_date=" + create_date +
                ", update_date=" + update_date +
                '}';
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
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

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public int getView_cnt() {
        return view_cnt;
    }

    public void setView_cnt(int view_cnt) {
        this.view_cnt = view_cnt;
    }

    public int getComment_cnt() {
        return comment_cnt;
    }

    public void setComment_cnt(int comment_cnt) {
        this.comment_cnt = comment_cnt;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public Date getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(Date update_date) {
        this.update_date = update_date;
    }

    public BoardDto(Integer bid, String title, String content, String writer, int view_cnt, int comment_cnt, Date create_date, Date update_date) {
        this.bid = bid;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.view_cnt = view_cnt;
        this.comment_cnt = comment_cnt;
        this.create_date = create_date;
        this.update_date = update_date;
    }
}
