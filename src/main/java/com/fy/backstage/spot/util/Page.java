package com.fy.backstage.spot.util;

public class Page {
	private Integer page =1;
	private Integer rows=3;
	private String sort;
	private String order = "desc";
	
	
	
	
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	
	
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
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
	@Override
	public String toString() {
		return "Page [page=" + page + ", rows=" + rows + ", sort=" + sort + ", order=" + order + "]";
	}
	
	
	

}
