package com.myportfolio.web.domain;

import java.util.Date;
import java.util.Objects;

public class CommentDto {
    private Integer cid;
    private Integer pcid;
    private String comment;
    private String commenter;
    private Date create_date;
    private Date update_date;
    private Integer bid;

    public CommentDto() {
    }

    @Override
    public String toString() {
        return "CommentDto{" +
                "cid=" + cid +
                ", pcid=" + pcid +
                ", comment='" + comment + '\'' +
                ", commenter='" + commenter + '\'' +
                ", create_date=" + create_date +
                ", update_date=" + update_date +
                ", bid=" + bid +
                '}';
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getPcid() {
        return pcid;
    }

    public void setPcid(Integer pcid) {
        this.pcid = pcid;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCommenter() {
        return commenter;
    }

    public void setCommenter(String commenter) {
        this.commenter = commenter;
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

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public CommentDto(Integer cid, Integer pcid, String comment, String commenter, Date create_date, Date update_date, Integer bid) {
        this.cid = cid;
        this.pcid = pcid;
        this.comment = comment;
        this.commenter = commenter;
        this.create_date = create_date;
        this.update_date = update_date;
        this.bid = bid;
    }
}
