package com.fy.backstage.commons;

import java.io.Serializable;
import java.util.List;

/**
 * 提供返回前台信息
 */
public class ResultVo<T> implements Serializable {
    private Integer code;
    private String msg;
    private List<T> list;

    @Override
    public String toString() {
        return "ResultVo{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", list=" + list +
                '}';
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public ResultVo() {
    }
    public ResultVo(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
