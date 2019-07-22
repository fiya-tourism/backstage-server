package com.fy.backstage.spot.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @ProjectName: reception-server
 * @Package: com.fy.receptionserver.spot.entity
 * @ClassName: SpotVO
 * @Author: 彭志新
 * @Description: 图片集合
 * @Date: 2019/7/22 11:17
 * @Version: 1.0
 */
public class SpotVO {

    //旅游主键
    private Integer spotsId;
    //员工外键
    private Integer staffId;
    //景点名称
    private String spotsName;
    //园区类型
    private Integer spotsType;
    //景点介绍 存 mongodb
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
    //开放时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:dd" ,timezone = "GTM")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:dd")
    private Date spotsOpenTime;
    //景点门票库存
    private Integer spotsRepertory;
    //景点活动
    private String spotsActivity;
    //集合地点
    private String spotsVenue;
    //图片路径
    private String pictureUrl;

    //景区状态  1 上架/0 未上架
    // private Integer spotsGrounding;
    //出发时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:dd" ,timezone = "GTM")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:dd")
    private Date spotsGotime;
    //发布时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:dd" ,timezone = "GTM")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:dd")
    private Date spotsRelease;
    //创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:dd" ,timezone = "GTM")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:dd")
    private Date spotsCreate;
    //修改时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:dd" ,timezone = "GTM")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:dd")
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

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
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

    @Override
    public String toString() {
        return "SpotVO{" +
                "spotsId=" + spotsId +
                ", staffId=" + staffId +
                ", spotsName='" + spotsName + '\'' +
                ", spotsType=" + spotsType +
                ", spotsIntroduceId='" + spotsIntroduceId + '\'' +
                ", easintroduce='" + easintroduce + '\'' +
                ", conentisert='" + conentisert + '\'' +
                ", spotsAddress='" + spotsAddress + '\'' +
                ", spotsPrice=" + spotsPrice +
                ", spotsPhone='" + spotsPhone + '\'' +
                ", spotsOpenTime=" + spotsOpenTime +
                ", spotsRepertory=" + spotsRepertory +
                ", spotsActivity='" + spotsActivity + '\'' +
                ", spotsVenue='" + spotsVenue + '\'' +
                ", pictureUrl='" + pictureUrl + '\'' +
                ", spotsGotime=" + spotsGotime +
                ", spotsRelease=" + spotsRelease +
                ", spotsCreate=" + spotsCreate +
                ", spotsUpdate=" + spotsUpdate +
                ", spotsYn=" + spotsYn +
                '}';
    }
}
