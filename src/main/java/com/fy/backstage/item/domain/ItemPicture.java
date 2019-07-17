package com.fy.backstage.item.domain;

import java.util.Date;

public class ItemPicture {
    //图片主键
    private Integer pictureId;
    //商品主键
    private Integer itemId;
    //图片路径
    private String pictureUrl;
    //图片次序
    private Integer pictureSequence;
    //创建时间
    private Date pictureCreate;
    //修改时间
    private Date pictureUpdate;
    //状态码
    private Integer pictureYn;

    public Integer getPictureId() {
        return pictureId;
    }

    public void setPictureId(Integer pictureId) {
        this.pictureId = pictureId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
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

    public ItemPicture() {
    }

    public ItemPicture(Integer itemId, String pictureUrl, Integer pictureSequence, Date pictureCreate, Integer pictureYn) {
        this.itemId = itemId;
        this.pictureUrl = pictureUrl;
        this.pictureSequence = pictureSequence;
        this.pictureCreate = pictureCreate;
        this.pictureYn = pictureYn;
    }
}