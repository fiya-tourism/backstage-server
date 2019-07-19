package com.fy.backstage.item.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * 商品详情
 * Created by monst on 2019/7/18.
 */
public class ItemReShow {
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
    //商品类型  1.农产品 2.水果 3.工艺品
    private Integer itemType;
    //商品介绍 (存放mongodb唯一标识)
    private String itemIntroduceId;
    //是否上架 0.已上架   1.未上架
    private Integer itemIsActive;
    //商品产地
    private String itemAddress;
    //商品发布时间
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date itemRelease;
    //创建时间
    private Date itemCreate;
    //修改时间
    private Date itemUpdate;
    //状态码   0.显示   1.隐藏
    private Integer itemYn;
    //商品详情主键
    private Integer iskuId;
    //商品销售价格
    private Double iskuSalePrice;
    //商品库存   --预留
    private Integer iskuKeepCount;
    //商品规格集合
    private List<ItemAttr> itemAttrList;
    //图片集合
    private List<ItemPicture> itemPictureList;
    //商品介绍 (真正内容)
    private String itemIntroduceValue;

    public List<ItemAttr> getItemAttrList() {
        return itemAttrList;
    }

    public void setItemAttrList(List<ItemAttr> itemAttrList) {
        this.itemAttrList = itemAttrList;
    }

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

    public List<ItemPicture> getItemPictureList() {
        return itemPictureList;
    }

    public void setItemPictureList(List<ItemPicture> itemPictureList) {
        this.itemPictureList = itemPictureList;
    }

    public String getItemIntroduceValue() {
        return itemIntroduceValue;
    }

    public void setItemIntroduceValue(String itemIntroduceValue) {
        this.itemIntroduceValue = itemIntroduceValue;
    }
}
