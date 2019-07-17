package com.fy.backstage.order.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/*
* 订单主类
* */
public class Order extends OrderChild  implements Serializable {
    //编号
    private Long orderId;
    //订单编号
    private Long orderConId;
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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date orderCreateDate;
    //修改时间
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

    public Long getOrderConId() {
        return orderConId;
    }

    public void setOrderConId(Long orderConId) {
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