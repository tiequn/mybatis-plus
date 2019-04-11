package com.gz.xuezi.util;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PageResultSet<T> {

    public static int DEFAULT_PAGE_SIZE = 10;

    /**
     * 当前页码（值从 1 开始）
     */
    private int currentPageNo;

    /**
     * 总页数
     */
    private int totalPageNum;

    /**
     * 总记录数
     */
    private int allRow;

    /**
     * 当前页起始游标
     */
    private int pageStartRow;

    /**
     * 每页记录数
     */
    private int pageSize = DEFAULT_PAGE_SIZE;

    /**
     * 当前页结果集
     */
    private List<T> list;

    /**
     * 其他额外信息
     */
    private Map<String, Object> extraData;

    public PageResultSet() {
        list = new ArrayList<T>();
        extraData = new HashMap<String, Object>();
    }

    public PageResultSet(int currentPageNo, int pageSize) {
        this.currentPageNo = currentPageNo;
        this.pageSize = pageSize;
        this.pageStartRow = (currentPageNo - 1) * pageSize;
    }

    public PageResultSet<T> addExtraData(String key, Object value) {
        if(null == extraData) {
            extraData = new HashMap<String, Object>();
        }
        extraData.put(key, value);
        return this;
    }

    public Map<String, Object> getExtraData() {
        return extraData;
    }

    public void setExtraData(Map<String, Object> extraData) {
        this.extraData = extraData;
    }

    public int getPageStartRow() {
        return pageStartRow;
    }

    public void setPageStartRow(int pageStartRow) {
        this.pageStartRow = pageStartRow;
    }

    public int getCurrentPageNo() {
        return currentPageNo;
    }

    public void setCurrentPageNo(int currentPageNo) {
        this.currentPageNo = currentPageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getTotalPageNum() {
        return totalPageNum;
    }

    public int getAllRow() {
        return allRow;
    }

    public void setAllRow(int allRow) {
        int size = allRow / pageSize;
        int mod = allRow % pageSize;
        if (mod != 0) {
            size++;
        }

        this.totalPageNum = (allRow == 0 ? 1 : size);
        this.allRow = allRow;
    }

}

