package com.fy.backstage.travels.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
@JsonDeserialize(as = Travel.class)
public class Travel implements Serializable {
    private Integer travelsId;

    private Integer travelsUserId;

    private String travelsContentId;

    private String travelsTitle;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date travelsRelease;

    private String travelsPicture;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date travelsCreate;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date travelsUpdate;

    private Integer travelsYn;

    private String travelsText;

    public Integer getTravelsId() {
        return travelsId;
    }

    public void setTravelsId(Integer travelsId) {
        this.travelsId = travelsId;
    }

    public Integer getTravelsUserId() {
        return travelsUserId;
    }

    public void setTravelsUserId(Integer travelsUserId) {
        this.travelsUserId = travelsUserId;
    }

    public String getTravelsContentId() {
        return travelsContentId;
    }

    public void setTravelsContentId(String travelsContentId) {
        this.travelsContentId = travelsContentId;
    }

    public String getTravelsTitle() {
        return travelsTitle;
    }

    public void setTravelsTitle(String travelsTitle) {
        this.travelsTitle = travelsTitle;
    }

    public Date getTravelsRelease() {
        return travelsRelease;
    }

    public void setTravelsRelease(Date travelsRelease) {
        this.travelsRelease = travelsRelease;
    }

    public String getTravelsPicture() {
        return travelsPicture;
    }

    public void setTravelsPicture(String travelsPicture) {
        this.travelsPicture = travelsPicture;
    }

    public Date getTravelsCreate() {
        return travelsCreate;
    }

    public void setTravelsCreate(Date travelsCreate) {
        this.travelsCreate = travelsCreate;
    }

    public Date getTravelsUpdate() {
        return travelsUpdate;
    }

    public void setTravelsUpdate(Date travelsUpdate) {
        this.travelsUpdate = travelsUpdate;
    }

    public Integer getTravelsYn() {
        return travelsYn;
    }

    public void setTravelsYn(Integer travelsYn) {
        this.travelsYn = travelsYn;
    }

    public String getTravelsText() {
        return travelsText;
    }

    public void setTravelsText(String travelsText) {
        this.travelsText = travelsText;
    }

    @Override
    public String toString() {
        return "Travel{" +
                "travelsId=" + travelsId +
                ", travelsUserId=" + travelsUserId +
                ", travelsContentId='" + travelsContentId + '\'' +
                ", travelsTitle='" + travelsTitle + '\'' +
                ", travelsRelease=" + travelsRelease +
                ", travelsPicture='" + travelsPicture + '\'' +
                ", travelsCreate=" + travelsCreate +
                ", travelsUpdate=" + travelsUpdate +
                ", travelsYn=" + travelsYn +
                ", travelsText='" + travelsText + '\'' +
                '}';
    }
}