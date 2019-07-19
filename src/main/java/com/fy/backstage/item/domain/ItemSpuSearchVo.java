package com.fy.backstage.item.domain;

/**
 * @author monst
 * 查询条件的
 */
public class ItemSpuSearchVo {
    //商品类型  1.农产品 2.水果 3.工艺品
    private Integer itemType;
    //是否上架 0.已上架   1.未上架
    private Integer itemIsActive;
    //商品产地
    private String itemAddress;
    //开始的时间
    private String timeB;
    //结束的时间
    private String timeE;

    public Integer getItemType() {
        return itemType;
    }

    public void setItemType(Integer itemType) {
        this.itemType = itemType;
    }

    public Integer getItemIsActive() {
        return itemIsActive;
    }

    public void setItemIsActive(Integer itemIsActive) {
        this.itemIsActive = itemIsActive;
    }

    public String getItemAddress() {
        return itemAddress;
    }

    public void setItemAddress(String itemAddress) {
        this.itemAddress = itemAddress;
    }

    public String getTimeB() {
        return timeB;
    }

    public void setTimeB(String timeB) {
        this.timeB = timeB;
    }

    public String getTimeE() {
        return timeE;
    }

    public void setTimeE(String timeE) {
        this.timeE = timeE;
    }
}