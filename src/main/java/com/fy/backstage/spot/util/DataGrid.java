package com.fy.backstage.spot.util;

import java.util.List;

public class DataGrid<T> {
	private List<T> rows;
	private long total;
	private String content;
	
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "DataGrid{" +
				"rows=" + rows +
				", total=" + total +
				", content='" + content + '\'' +
				'}';
	}
}
