package org.fenrir.mybatis.domain;

/**
 *
 */
public class PageUtils {
    public static PageInfoQuery getPageInfo(Integer pageIndex, Integer pageSize, int total) {
        PageInfoQuery pageInfo = new PageInfoQuery();
        if (total == 0) {
            pageInfo.setPageIndex(pageIndex);
            pageInfo.setPageSize(pageSize);
            pageInfo.setPageNum(0);
            pageInfo.setTotalNum(0);
            return pageInfo;
        }

        //总数据条数就是列表大小
        //总页数
        int pageNum = (total + pageSize - 1) / pageSize;
        //开始索引
        int startIndex = (pageIndex - 1) * pageSize;
        //截止索引。考虑到是最后一页，页内数据量的情况
        int endIndex = pageNum == pageIndex ? startIndex + (total % pageSize == 0 ?
                pageSize : total % pageSize) : startIndex + pageSize;
        pageInfo.setPageIndex(pageIndex);
        pageInfo.setPageSize(pageSize);
        pageInfo.setPageNum(pageNum);
        pageInfo.setTotalNum(total);
        return pageInfo;

    }
}