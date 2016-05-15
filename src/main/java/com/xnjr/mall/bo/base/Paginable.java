package com.xnjr.mall.bo.base;

import java.util.List;

/**
 * 分页接口
 * 
 * @author liufang
 * 
 */
public interface Paginable<T> {

	int DEFAULT_PAGE_SIZE = 20;

	/**
	 * 总记录数
	 * 
	 * @return
	 */
	public long getTotalCount();

	/**
	 * 总页数
	 * 
	 * @return
	 */
	public long getTotalPage();

	/**
	 * 每页记录数
	 * 
	 * @return
	 */
	public int getPageSize();

	/**
	 * 当前页号
	 * 
	 * @return
	 */
	public int getPageNo();

	/**
	 * 是否第一页
	 * 
	 * @return
	 */
	public boolean isFirstPage();

	/**
	 * 是否最后一页
	 * 
	 * @return
	 */
	public boolean isLastPage();

	/**
	 * 返回下页的页号
	 */
	public int getNextPage();

	/**
	 * 返回上页的页号
	 */
	public int getPrePage();

	/**
	 * 返回起始条数
	 * 
	 * @return
	 */
	public int getStart();

	/**
	 * 返回数据列表
	 * 
	 * @return
	 */
	public List<T> getList();

	/**
	 * 设置数据列表
	 * 
	 * @return
	 */
	public void setList(List<T> list);
}
