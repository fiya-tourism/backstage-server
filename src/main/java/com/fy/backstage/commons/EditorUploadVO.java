package com.fy.backstage.commons;

import java.util.Arrays;

/**
 * @ProjectName: backstage-server
 * @Package: com.fy.backstage.commons
 * @ClassName: EditorUploadVO
 * @Author: 彭志新
 * @Description: 富文本编辑器用
 * @Date: 2019/7/17 16:33
 * @Version: 1.0
 */
public class EditorUploadVO {
    private Integer errno;
    private  String[] data;

    public EditorUploadVO(Integer i, String[] data) {
    }

    public Integer getErrno() {
        return errno;
    }

    public void setErrno(Integer errno) {
        this.errno = errno;
    }

    public String[] getData() {
        return data;
    }

    public void setData(String[] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "EditorUploadVO{" +
                "errno=" + errno +
                ", data=" + Arrays.toString(data) +
                '}';
    }
}
