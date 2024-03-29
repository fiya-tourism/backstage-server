package com.fy.backstage.commons;

public class ResultVo {

	private Boolean success=true;
	private String msg;
	private Object data;
	private Integer code;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public void setSuccessFalse() {
		success=false;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public ResultVo() {
	}

	public ResultVo(Object data) {
		this.data = data;
	}

	public ResultVo(Boolean success, String msg, Object data, Integer code) {
		this.success = success;
		this.msg = msg;
		this.data = data;
		this.code = code;
	}
}
