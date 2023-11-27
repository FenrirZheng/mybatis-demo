package org.fenrir.mybatis.domain;

import java.io.Serializable;
import java.util.List;


public class PageInfoQuery implements Serializable {
    /**
     * 页索引
     */
    Integer offset;
    /**
     * 页大小
     */
    Integer pageSize;

    /**
     * 总页数
     */
    Integer pageNum;
    /**
     * 总数据条数
     */
    Integer totalNum;


    public void setPageIndex(Integer pageIndex) {
        this.offset = pageIndex;
    }


    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }


    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }


    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }


    public PageInfoQuery() {
        super();
    }

    public PageInfoQuery(Integer pageIndex, Integer pageSize, Integer pageNum, Integer totalNum, List list) {
        super();
        this.offset = pageIndex;
        this.pageSize = pageSize;
        this.pageNum = pageNum;
        this.totalNum = totalNum;
    }

    @Override
    public String toString() {
        return "PageInfo{" +
                "pageIndex=" + offset +
                ", pageSize=" + pageSize +
                ", pageNum=" + pageNum +
                ", totalNum=" + totalNum +
                '}';
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public Integer getTotalNum() {
        return totalNum;
    }
}