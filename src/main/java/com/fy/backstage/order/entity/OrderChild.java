package com.fy.backstage.order.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/*
* 订单子类
* */
public class OrderChild  implements Serializable {
    //子类编号
    private Long orderChildId;
    //商品关联id
    private Integer itemId;
    //订单关联id
    private Long orderId;
    //商品名称
    private String orderChildTradeName;
    //单位
    private Integer orderChildCount;
    //单价
    private Double orderChildPrice;
    //单项总金额 (留给购物车使用)
    private Double orderChildAmout;
    //创建时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createChildDate;
    //修改时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date orderChildUpdate;
    //支付时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date orderChildShop;

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

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
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
}