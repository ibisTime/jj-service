package com.xnjr.mall.bo.base;

import java.util.List;

/**
 * 
 * @author joe.chen
 * 
 */
public class Page<T> implements Paginable<T> {

    private int pageNO;

    private int start;

    private int pageSize = DEFAULT_PAGE_SIZE;

    private long totalCount;

    private long totalPage;

    /**
     * 当前页的数据
     */
    private List<T> list;

    public Page(int pageNO, int pageSize, long totalCount) {
        this.pageNO = pageNO <= 0 ? 1 : pageNO;
        this.pageSize = pageSize <= 0 ? DEFAULT_PAGE_SIZE : pageSize;
        this.totalCount = totalCount < 0 ? 0 : totalCount;

        this.start = (this.pageNO - 1) * this.pageSize;
        this.totalPage = (this.totalCount + this.pageSize - 1) / this.pageSize;
    }

    public Page(int pageNO, long totalCount) {
        this(pageNO, DEFAULT_PAGE_SIZE, totalCount);
    }

    public int getPageNO() {
        return pageNO;
    }

    public int getStart() {
        return start;
    }

    @Override
    public long getTotalCount() {
        return this.totalCount;
    }

    @Override
    public long getTotalPage() {
        return this.totalPage;
    }

    @Override
    public int getPageSize() {
        return this.pageSize;
    }

    @Override
    public int getPageNo() {
        return this.pageNO;
    }

    @Override
    public boolean isFirstPage() {
        return this.pageNO == 1 ? true : false;
    }

    @Override
    public boolean isLastPage() {
        return this.pageNO == this.totalPage ? true : false;
    }

    @Override
    public int getNextPage() {
        return this.pageNO == this.totalPage ? this.pageNO : (this.pageNO + 1);
    }

    @Override
    public int getPrePage() {
        return this.pageNO == 1 ? this.pageNO : (this.pageNO - 1);
    }

    @Override
    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public List<T> getList() {
        return this.list;
    }

}
