package com.xykj.base.util;

import java.util.List;

public class Page <T>{
	private int pageNum = 1;
    private int pageSize = 20;
    private int totalRecord;
    private int totalPage;
    private List<T> results;
    private int rows;
    private int page;

    public Page() {
    }

    public int getPageNum() {
        return this.pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalRecord() {
        return this.totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
        int totalPage = totalRecord % this.pageSize == 0 ? totalRecord / this.pageSize : totalRecord / this.pageSize + 1;
        this.setTotalPage(totalPage);
    }

    public int getTotalPage() {
        return this.totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getResults() {
        return null != this.results && this.results.size() == 0 ? null : this.results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Page [pageNum=").append(this.pageNum).append(", pageSize=").append(this.pageSize).append(", results=").append(this.results).append(", totalPage=").append(this.totalPage).append(", totalRecord=").append(this.totalRecord).append("]");
        return builder.toString();
    }

    public int getRows() {
        return this.rows;
    }

    public void setRows(int rows) {
        this.pageSize = rows;
    }

    public int getPage() {
        return this.page;
    }

    public void setPage(int page) {
        this.pageNum = page;
    }
}
