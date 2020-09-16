package com.example.miaosha.daomai;

import java.io.Serializable;
import java.util.List;

/**
 * @program: miaosha
 * @description
 * @author: 冷阳光
 **/
public class PageBean<T> implements Serializable {
    private int totalCount;//一共记录数
    private int totalPage;//总页数
    private int currentPage=1;//当前页数
    private int pageSize=5;//每页显示数据条数
    private List<T> list;//每页数据

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
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

    @Override
    public String toString() {
        return "PageBean{" +
                "totalCount=" + totalCount +
                ", totalPage=" + totalPage +
                ", currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", list=" + list +
                '}';
    }
}
