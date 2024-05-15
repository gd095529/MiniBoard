package com.myportfolio.web.domain;

public class PageHandler {
    //    private int pageSize; //한 페이지의 크기
//    private int page; //현제 페이지
//    private String option;
//    private String keyword;
    private SearchCondition sc;

    private int naviSize = 10; //페이지 네비 크기
    private int totalPage; //전체 페이지의 갯수
    private int totalCnt; //총 게시물 개수
    private int beginPage; //네비의 첫번째 페이지
    private int endPage; //네비의 마지막 페이지
    private boolean showPrev; //이전 페이지 이동 링크 보여줄것인지
    private boolean showNext; //다음 페이지 이동 링크 보여줄것인지

    public PageHandler(int totalCnt, SearchCondition sc){
        this.totalCnt = totalCnt;
        this.sc = sc;

        doPaging(totalCnt, sc);
    }

//    public PageHandler(int totalCnt, int page){
//        this(totalCnt, page, 10);
//    }

    public void doPaging(int totalCnt,SearchCondition sc){
        this.totalCnt = totalCnt;

        totalPage = (int)Math.ceil(totalCnt/(double)sc.getPageSize());
        beginPage = (sc.getPage()-1) / naviSize * naviSize +1;
        endPage = Math.min(beginPage+naviSize-1, totalPage);
        showPrev = beginPage!=1;
        showNext = endPage!=totalPage;
    }

    public SearchCondition getSc() {
        return sc;
    }

    public void setSc(SearchCondition sc) {
        this.sc = sc;
    }

    public int getTotalCnt() {
        return totalCnt;
    }

    public void setTotalCnt(int totalCnt) {
        this.totalCnt = totalCnt;
    }

//    public int getPageSize() {
//        return pageSize;
//    }
//
//    public void setPageSize(int pageSize) {
//        this.pageSize = pageSize;
//    }

    public int getNaviSize() {
        return naviSize;
    }

    public void setNaviSize(int naviSize) {
        this.naviSize = naviSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

//    public int getPage() {
//        return page;
//    }
//
//    public void setPage(int page) {
//        this.page = page;
//    }

    public int getBeginPage() {
        return beginPage;
    }

    public void setBeginPage(int beginPage) {
        this.beginPage = beginPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    public boolean isShowPrev() {
        return showPrev;
    }

    public void setShowPrev(boolean showPrev) {
        this.showPrev = showPrev;
    }

    public boolean isShowNext() {
        return showNext;
    }

    public void setShowNext(boolean showNext) {
        this.showNext = showNext;
    }

    void print(){
        System.out.println("page = " + sc.getPage());
        System.out.print(showPrev? "[prev] " : "");
        for(int i = beginPage; i<=endPage; i++){
            System.out.print(i+" ");
        }
        System.out.println(showNext ? " [next]": "");
    }

    @Override
    public String toString() {
        return "PageHandler{" +
                "sc=" + sc +
                ", naviSize=" + naviSize +
                ", totalPage=" + totalPage +
                ", totalCnt=" + totalCnt +
                ", beginPage=" + beginPage +
                ", endPage=" + endPage +
                ", showPrev=" + showPrev +
                ", showNext=" + showNext +
                '}';
    }
}
