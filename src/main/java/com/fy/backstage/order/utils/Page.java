package com.fy.backstage.order.utils;

public class Page {
	//下一页(页数) 
	private Integer page;
	
	//每页条数
	private Integer rows;
	
	//排序字段
	private String sort;
	
	//asc & desc 
	private String order = "desc";
	
	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}
	
	
}
