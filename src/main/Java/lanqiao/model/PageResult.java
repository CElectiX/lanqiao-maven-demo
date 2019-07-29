package lanqiao.model;

import java.util.List;

public class PageResult {
	private int PageNum;
	private int PageSize;
	private List list;
	private int Pages;
	private int Total;
	public int getPageNum() {
		return PageNum;
	}
	public void setPageNum(int pageNum) {
		PageNum = pageNum;
	}
	public int getPageSize() {
		return PageSize;
	}
	public void setPageSize(int pageSize) {
		PageSize = pageSize;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public int getPages() {
		return Pages;
	}
	public void setPages(int pages) {
		Pages = pages;
	}
	public int getTotal() {
		return Total;
	}
	public void setTotal(int total) {
		Total = total;
	}
	
}
