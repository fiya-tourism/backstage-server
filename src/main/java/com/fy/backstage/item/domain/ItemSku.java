package com.fy.backstage.item.domain;

import java.util.List;

public class ItemSku {
    //商品详情主键
    private Integer iskuId;
    //商品主键
    private Integer itemId;
    //商品销售价格
    private Double iskuSalePrice;
    //商品库存   --预留
    private Integer iskuKeepCount;
    //商品规格集合
    private List<ItemAttr> itemAttrList;

    public Integer getIskuId() {
        return iskuId;
    }

    public void setIskuId(Integer iskuId) {
        this.iskuId = iskuId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Double getIskuSalePrice() {
        return iskuSalePrice;
    }

    public void setIskuSalePrice(Double iskuSalePrice) {
        this.iskuSalePrice = iskuSalePrice;
    }

    public Integer getIskuKeepCount() {
        return iskuKeepCount;
    }

    public void setIskuKeepCount(Integer iskuKeepCount) {
        this.iskuKeepCount = iskuKeepCount;
    }

    public List<ItemAttr> getItemAttrList() {
        return itemAttrList;
    }

    public void setItemAttrList(List<ItemAttr> itemAttrList) {
        this.itemAttrList = itemAttrList;
    }

    public ItemSku() {
    }

    public ItemSku(Integer itemId,Double iskuSalePrice, Integer iskuKeepCount) {
        this.itemId = itemId;
        this.iskuSalePrice = iskuSalePrice;
        this.iskuKeepCount = iskuKeepCount;
    }
}