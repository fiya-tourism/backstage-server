package com.fy.backstage.order.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/*
* 订单主类
* */
public class Order implements Serializable {
    //编号
    private Long orderId;
    //订单编号
    private String orderConId;
    //用户关联Id
    private Integer userId;
    //订单总金额
    private Double orderTotalPrices;
    //旅游交易状态
    private Integer orderSpotsStatus;
    //商品交易状态
    private Integer orderTradeStatus;
    //收货地址
    private String orderAddress;
    //总数量
    private Integer orederCount;
    //备注
    private String orderRemark;
    //创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" ,timezone = "GTM")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date orderCreateDate;
    //修改时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" ,timezone = "GTM")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date orderUpdate;
    //逻辑状态
    private Integer orderYh;
    //收货人
    private String orderUserName;
    //收货人电话
    private String orderUserPhone;
    //收货人邮编
    private Integer orderPust;
    //子类编号
    private Long orderChildId;
    //商品关联id
    private Integer itemId;
    //订单关联id
    private Long orderIdPk;
    //商品名称
    private String orderChildTradeName;
    //单位
    private Integer orderChildCount;
    //单价
    private Double orderChildPrice;
    //单项总金额 (留给购物车使用)
    private Double orderChildAmout;
    //创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" ,timezone = "GTM")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createChildDate;
    //修改时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" ,timezone = "GTM")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date orderChildUpdate;
    //支付时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" ,timezone = "GTM")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date orderChildShop;
    //商品类型
    private Integer  orderChildItemType;
    //商品产地
    private String orderChildItemAddress;
    //商品属性
    private String orderChildItemAttrkey;
    //商品属性值
    private String orderChildItemAttrvalue;

    public Integer getOrderChildItemType() {
        return orderChildItemType;
    }

    public void setOrderChildItemType(Integer orderChildItemType) {
        this.orderChildItemType = orderChildItemType;
    }

    public String getOrderChildItemAddress() {
        return orderChildItemAddress;
    }

    public void setOrderChildItemAddress(String orderChildItemAddress) {
        this.orderChildItemAddress = orderChildItemAddress;
    }

    public String getOrderChildItemAttrkey() {
        return orderChildItemAttrkey;
    }

    public void setOrderChildItemAttrkey(String orderChildItemAttrkey) {
        this.orderChildItemAttrkey = orderChildItemAttrkey;
    }

    public String getOrderChildItemAttrvalue() {
        return orderChildItemAttrvalue;
    }

    public void setOrderChildItemAttrvalue(String orderChildItemAttrvalue) {
        this.orderChildItemAttrvalue = orderChildItemAttrvalue;
    }

    public Long getOrderChildId() {
        return orderChildId;
    }

    public void setOrderChildId(Long orderChildId) {
        this.orderChildId = orderChildId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Long getOrderIdPk() {
        return orderIdPk;
    }

    public void setOrderIdPk(Long orderIdPk) {
        this.orderIdPk = orderIdPk;
    }

    public String getOrderChildTradeName() {
        return orderChildTradeName;
    }

    public void setOrderChildTradeName(String orderChildTradeName) {
        this.orderChildTradeName = orderChildTradeName == null ? null : orderChildTradeName.trim();
    }

    public Integer getOrderChildCount() {
        return orderChildCount;
    }

    public void setOrderChildCount(Integer orderChildCount) {
        this.orderChildCount = orderChildCount;
    }

    public Double getOrderChildPrice() {
        return orderChildPrice;
    }

    public void setOrderChildPrice(Double orderChildPrice) {
        this.orderChildPrice = orderChildPrice;
    }

    public Double getOrderChildAmout() {
        return orderChildAmout;
    }

    public void setOrderChildAmout(Double orderChildAmout) {
        this.orderChildAmout = orderChildAmout;
    }

    public Date getCreateChildDate() {
        return createChildDate;
    }

    public void setCreateChildDate(Date createChildDate) {
        this.createChildDate = createChildDate;
    }

    public Date getOrderChildUpdate() {
        return orderChildUpdate;
    }

    public void setOrderChildUpdate(Date orderChildUpdate) {
        this.orderChildUpdate = orderChildUpdate;
    }

    public Date getOrderChildShop() {
        return orderChildShop;
    }

    public void setOrderChildShop(Date orderChildShop) {
        this.orderChildShop = orderChildShop;
    }


    public String getOrderConId() {
        return orderConId;
    }

    public void setOrderConId(String orderConId) {
        this.orderConId = orderConId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Double getOrderTotalPrices() {
        return orderTotalPrices;
    }

    public void setOrderTotalPrices(Double orderTotalPrices) {
        this.orderTotalPrices = orderTotalPrices;
    }

    public Integer getOrderSpotsStatus() {
        return orderSpotsStatus;
    }

    public void setOrderSpotsStatus(Integer orderSpotsStatus) {
        this.orderSpotsStatus = orderSpotsStatus;
    }

    public Integer getOrderTradeStatus() {
        return orderTradeStatus;
    }

    public void setOrderTradeStatus(Integer orderTradeStatus) {
        this.orderTradeStatus = orderTradeStatus;
    }

    public String getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress == null ? null : orderAddress.trim();
    }

    public Integer getOrederCount() {
        return orederCount;
    }

    public void setOrederCount(Integer orederCount) {
        this.orederCount = orederCount;
    }

    public String getOrderRemark() {
        return orderRemark;
    }

    public void setOrderRemark(String orderRemark) {
        this.orderRemark = orderRemark == null ? null : orderRemark.trim();
    }

    public Date getOrderCreateDate() {
        return orderCreateDate;
    }

    public void setOrderCreateDate(Date orderCreateDate) {
        this.orderCreateDate = orderCreateDate;
    }

    public Date getOrderUpdate() {
        return orderUpdate;
    }

    public void setOrderUpdate(Date orderUpdate) {
        this.orderUpdate = orderUpdate;
    }

    public Integer getOrderYh() {
        return orderYh;
    }

    public void setOrderYh(Integer orderYh) {
        this.orderYh = orderYh;
    }

    public String getOrderUserName() {
        return orderUserName;
    }

    public void setOrderUserName(String orderUserName) {
        this.orderUserName = orderUserName == null ? null : orderUserName.trim();
    }

    public String getOrderUserPhone() {
        return orderUserPhone;
    }

    public void setOrderUserPhone(String orderUserPhone) {
        this.orderUserPhone = orderUserPhone == null ? null : orderUserPhone.trim();
    }

    public Integer getOrderPust() {
        return orderPust;
    }

    public void setOrderPust(Integer orderPust) {
        this.orderPust = orderPust;
    }
}