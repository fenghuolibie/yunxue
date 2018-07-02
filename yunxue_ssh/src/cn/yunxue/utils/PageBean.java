package cn.yunxue.utils;

import java.util.List;

public class PageBean<T> {

	private List<T> pageList; // 分页后的记录信息
	private int pageSize = 4; // 一页显示的记录数，默认为4条
	private int rowCount; // 要分页的记录的总数
	private int pageCount; // 记录的总页数
	private int currentPage = 1; // 当前页
	private boolean firstPage; // 是否是第一页
	private boolean lastPage; // 是否是最后一页
	private int previousPageCount;// 上一页
	private int nextPageCount; // 下一页
	private int start;
	private int end;

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public void setPageList(List<T> pageList) {
		this.pageList = pageList;
	}

	public List<T> getPageList() {
		return pageList;

	}

	public int getRowCount() {
		return rowCount;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
		// 计算总的页数
		if (rowCount <= 4) {
			pageCount = 1;
		} else {
			pageCount = rowCount % pageSize == 0 ? rowCount / pageSize : rowCount / pageSize + 1;
		}
	}

	public int getPreviousPageCount() {
		return previousPageCount;
	}

	public int getNextPageCount() {
		return nextPageCount;
	}

	public void setCurrentPage(int currentPage) {

		this.currentPage = currentPage;

		if (currentPage > pageCount) {
			this.currentPage = pageCount;
		}
		if (currentPage < 1) {
			this.currentPage = 1;
		}

		// 上一页
		previousPageCount = currentPage - 1;
		// 下一页
		nextPageCount = currentPage + 1;
		// 判断是否为第一页

		if (this.currentPage == 1) {
			firstPage = true;
		} else {
			firstPage = false;
		}
		// 判断是否为最后一页
		if (this.currentPage == pageCount) {
			lastPage = true;
		} else {
			lastPage = false;
		}

		// 数字页码
		start = 1;
		end = 5;
		if (pageCount <= 5) {
			end = this.pageCount;
		} else {
			start = this.currentPage - 2;
			end = this.currentPage + 2;
			if (start <= 0) {
				start = 1;
				end = 5;
			}
			if (end >= pageCount) {
				end = pageCount;
				start = end - 4;
			}
		}
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageCount() {
		return pageCount;
	}

	public boolean isFirstPage() {
		return firstPage;
	}

	public boolean isLastPage() {
		return lastPage;
	}
}
