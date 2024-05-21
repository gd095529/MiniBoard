package com.myportfolio.web.domain;

import java.util.Date;

public class CommentDto {
    private Integer cid;
    private Integer pcid;
    private String comment;
    private String commenter;
    private Date created_date;
    private Date updated_date;
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
                ", created_date=" + created_date +
                ", updated_date=" + updated_date +
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

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public CommentDto(Integer cid, Integer pcid, String comment, String commenter, Date created_date, Date updated_date, Integer bid) {
        this.cid = cid;
        this.pcid = pcid;
        this.comment = comment;
        this.commenter = commenter;
        this.created_date = created_date;
        this.updated_date = updated_date;
        this.bid = bid;
    }
}
