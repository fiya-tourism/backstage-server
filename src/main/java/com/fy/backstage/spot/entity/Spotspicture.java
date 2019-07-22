package com.fy.backstage.spot.entity;

import java.util.Date;

public class Spotspicture {
    //图片主键
    private Integer pictureId;
    //旅游主键(外键)
    private Integer spotsId;
    //图片路径
    private String pictureUrl;
    //图片次序
    private Integer pictureSequence;
    //创建时间
    private Date pictureCreate;
    //修改时间
    private Date pictureUpdate;
    //状态
    private Integer pictureYn;

    public Integer getPictureId() {
        return pictureId;
    }

    public void setPictureId(Integer pictureId) {
        this.pictureId = pictureId;
    }

    public Integer getSpotsId() {
        return spotsId;
    }

    public void setSpotsId(Integer spotsId) {
        this.spotsId = spotsId;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl == null ? null : pictureUrl.trim();
    }

    public Integer getPictureSequence() {
        return pictureSequence;
    }

    public void setPictureSequence(Integer pictureSequence) {
        this.pictureSequence = pictureSequence;
    }

    public Date getPictureCreate() {
        return pictureCreate;
    }

    public void setPictureCreate(Date pictureCreate) {
        this.pictureCreate = pictureCreate;
    }

    public Date getPictureUpdate() {
        return pictureUpdate;
    }

    public void setPictureUpdate(Date pictureUpdate) {
        this.pictureUpdate = pictureUpdate;
    }

    public Integer getPictureYn() {
        return pictureYn;
    }

    public void setPictureYn(Integer pictureYn) {
        this.pictureYn = pictureYn;
    }
}