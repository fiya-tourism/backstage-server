package com.fy.backstage.spot.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @ProjectName: backstage-server
 * @Package: com.fy.backstage.spot.entity
 * @ClassName: Spot
 * @Author: 彭志新
 * @Description: 旅游实体
 * @Date: 2019/7/16 15:20
 * @Version: 1.0
 */
public class Spot implements Serializable {

    //旅游主键
    private Integer spotsId;
    //员工外键
    private Integer staffId;
    //景点名称
    private String spotsName;
    //园区类型
    private Integer spotsType;
    //景点介绍主键 存 mongodb
    private String spotsIntroduceId;
    //景点简介（短介绍）  后加
    private String easintroduce;
    //景点具体介绍  后加
    private String conentisert;
    //景点地址
    private String spotsAddress;
    //门票价格
    private Double spotsPrice;
    //资讯电话
    private String spotsPhone;
    //景区状态  1 上架/0 未上架
    private Integer spotsGrounding;
    //开放时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" ,timezone = "GTM")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date spotsOpenTime;
    //景点门票库存
    private Integer spotsRepertory;
    //景点简介
    private String spotsActivity;
    //集合地点
    private String spotsVenue;
    //出发时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" ,timezone = "GTM")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date spotsGotime;
    //发布时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" ,timezone = "GTM")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date spotsRelease;
    //创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" ,timezone = "GTM")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date spotsCreate;
    //修改时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" ,timezone = "GTM")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date spotsUpdate;
    //状态
    private Integer spotsYn;


    public Integer getSpotsId() {
        return spotsId;
    }

    public void setSpotsId(Integer spotsId) {
        this.spotsId = spotsId;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public String getSpotsName() {
        return spotsName;
    }

    public void setSpotsName(String spotsName) {
        this.spotsName = spotsName;
    }

    public Integer getSpotsType() {
        return spotsType;
    }

    public void setSpotsType(Integer spotsType) {
        this.spotsType = spotsType;
    }

    public String getSpotsIntroduceId() {
        return spotsIntroduceId;
    }

    public void setSpotsIntroduceId(String spotsIntroduceId) {
        this.spotsIntroduceId = spotsIntroduceId;
    }

    public String getEasintroduce() {
        return easintroduce;
    }

    public void setEasintroduce(String easintroduce) {
        this.easintroduce = easintroduce;
    }

    public String getConentisert() {
        return conentisert;
    }

    public void setConentisert(String conentisert) {
        this.conentisert = conentisert;
    }

    public String getSpotsAddress() {
        return spotsAddress;
    }

    public void setSpotsAddress(String spotsAddress) {
        this.spotsAddress = spotsAddress;
    }

    public Double getSpotsPrice() {
        return spotsPrice;
    }

    public void setSpotsPrice(Double spotsPrice) {
        this.spotsPrice = spotsPrice;
    }

    public String getSpotsPhone() {
        return spotsPhone;
    }

    public void setSpotsPhone(String spotsPhone) {
        this.spotsPhone = spotsPhone;
    }

    public Date getSpotsOpenTime() {
        return spotsOpenTime;
    }

    public void setSpotsOpenTime(Date spotsOpenTime) {
        this.spotsOpenTime = spotsOpenTime;
    }

    public Integer getSpotsRepertory() {
        return spotsRepertory;
    }

    public void setSpotsRepertory(Integer spotsRepertory) {
        this.spotsRepertory = spotsRepertory;
    }

    public String getSpotsActivity() {
        return spotsActivity;
    }

    public void setSpotsActivity(String spotsActivity) {
        this.spotsActivity = spotsActivity;
    }

    public String getSpotsVenue() {
        return spotsVenue;
    }

    public void setSpotsVenue(String spotsVenue) {
        this.spotsVenue = spotsVenue;
    }

    public Date getSpotsGotime() {
        return spotsGotime;
    }

    public void setSpotsGotime(Date spotsGotime) {
        this.spotsGotime = spotsGotime;
    }

    public Date getSpotsRelease() {
        return spotsRelease;
    }

    public void setSpotsRelease(Date spotsRelease) {
        this.spotsRelease = spotsRelease;
    }

    public Date getSpotsCreate() {
        return spotsCreate;
    }

    public void setSpotsCreate(Date spotsCreate) {
        this.spotsCreate = spotsCreate;
    }

    public Date getSpotsUpdate() {
        return spotsUpdate;
    }

    public void setSpotsUpdate(Date spotsUpdate) {
        this.spotsUpdate = spotsUpdate;
    }

    public Integer getSpotsYn() {
        return spotsYn;
    }

    public void setSpotsYn(Integer spotsYn) {
        this.spotsYn = spotsYn;
    }
}
