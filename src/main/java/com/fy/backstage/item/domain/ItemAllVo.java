package com.fy.backstage.item.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author monst
 * 接收页面传来的全部数据
 */
public class ItemAllVo implements Serializable {
    //商品主键
    private Integer itemId;
    //员工主键
    private Integer staffId;
    //类目主键 --预留
    private Integer itemCategoryId;
    //品牌主键 --预留
    private Integer itemBrandId;
    //商品名称
    private String itemName;
    //商品标题 (提供seo优化用)
    private String itemTitle;
    //商品类型   1.农产品 2.水果 3.工艺品
    private Integer itemType;
    //商品介绍 (存放mongodb唯一标识)
    private String itemIntroduceId;
    //商品介绍 (真正内容)
    private String itemIntroduceValue;
    //是否上架 0.已上架   1.未上架
    private Integer itemIsActive;
    //商品产地
    private String itemAddress;
    //商品发布时间
    private Date itemRelease;
    //创建时间
    private Date itemCreate;
    //修改时间
    private Date itemUpdate;
    //状态码   0.显示   1.隐藏
    private Integer itemYn;
//商品详情 (sku)
    //商品销售价格
    private Double iskuSalePrice;
    //商品库存
    private Integer iskuKeepCount;
//商品规格 (Attr)
    //商品规格属性名
    private String attrAttrKey;
    private String attrAttrKey2;
    //商品规格属性值
    private String attrAttrValue;
    private String attrAttrValue2;
//商品图片
    private String picPath;

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public String getAttrAttrKey2() {
        return attrAttrKey2;
    }

    public void setAttrAttrKey2(String attrAttrKey2) {
        this.attrAttrKey2 = attrAttrKey2;
    }

    public String getAttrAttrValue2() {
        return attrAttrValue2;
    }

    public void setAttrAttrValue2(String attrAttrValue2) {
        this.attrAttrValue2 = attrAttrValue2;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public Integer getItemCategoryId() {
        return itemCategoryId;
    }

    public void setItemCategoryId(Integer itemCategoryId) {
        this.itemCategoryId = itemCategoryId;
    }

    public Integer getItemBrandId() {
        return itemBrandId;
    }

    public void setItemBrandId(Integer itemBrandId) {
        this.itemBrandId = itemBrandId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public Integer getItemType() {
        return itemType;
    }

    public void setItemType(Integer itemType) {
        this.itemType = itemType;
    }

    public String getItemIntroduceId() {
        return itemIntroduceId;
    }

    public void setItemIntroduceId(String itemIntroduceId) {
        this.itemIntroduceId = itemIntroduceId;
    }

    public String getItemIntroduceValue() {
        return itemIntroduceValue;
    }

    public void setItemIntroduceValue(String itemIntroduceValue) {
        this.itemIntroduceValue = itemIntroduceValue;
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

    public Date getItemRelease() {
        return itemRelease;
    }

    public void setItemRelease(Date itemRelease) {
        this.itemRelease = itemRelease;
    }

    public Date getItemCreate() {
        return itemCreate;
    }

    public void setItemCreate(Date itemCreate) {
        this.itemCreate = itemCreate;
    }

    public Date getItemUpdate() {
        return itemUpdate;
    }

    public void setItemUpdate(Date itemUpdate) {
        this.itemUpdate = itemUpdate;
    }

    public Integer getItemYn() {
        return itemYn;
    }

    public void setItemYn(Integer itemYn) {
        this.itemYn = itemYn;
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

    public String getAttrAttrKey() {
        return attrAttrKey;
    }

    public void setAttrAttrKey(String attrAttrKey) {
        this.attrAttrKey = attrAttrKey;
    }

    public String getAttrAttrValue() {
        return attrAttrValue;
    }

    public void setAttrAttrValue(String attrAttrValue) {
        this.attrAttrValue = attrAttrValue;
    }
}