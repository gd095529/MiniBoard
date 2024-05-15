package com.myportfolio.web.domain;

import org.springframework.web.util.UriComponentsBuilder;

public class SearchCondition {
    private Integer page =1;
    private Integer pageSize = 10;
    private Integer offset = (page-1)*pageSize;
    private String keyword = "";
    private String option = "";

    @Override
    public String toString() {
        return "SearchCondition{" +
                "page=" + page +
                ", pageSize=" + pageSize +
                ", offset=" + offset +
                ", keyword='" + keyword + '\'' +
                ", option='" + option + '\'' +
                '}';
    }

    public String getQueryString(){
        return getQueryString(page);
    }

    public String getQueryString(Integer page){
        // ?page=1&pageSize=10&option="T"&keyword="title"

        return UriComponentsBuilder.newInstance()
                .queryParam("page",page)
                .queryParam("pageSize",pageSize)
                .queryParam("option",option)
                .queryParam("keyword",keyword)
                .build().toString();
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public SearchCondition(){}
    public SearchCondition(Integer page, Integer pageSize){
        this(page, pageSize, "","");
    }
    public SearchCondition(Integer page, Integer pageSize, String keyword, String option) {
        this.page = page;
        this.pageSize = pageSize;
        this.offset = (page-1)*pageSize;
        this.keyword = keyword;
        this.option = option;
    }
}
