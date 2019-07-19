package com.fy.backstage.travels.domain;

import java.io.Serializable;
import java.util.Date;

public class Comments implements Serializable {

    private Integer comTravelsId;

    private Integer userId;

    private Integer travelsId;

    private String comTravelsContent;

    private Date comTravelsRelease;

    private Date comTravelsCreate;

    private Date comTravelsUpdate;

    private Integer comTravelsYn;

    public Integer getComTravelsId() {
        return comTravelsId;
    }

    public void setComTravelsId(Integer comTravelsId) {
        this.comTravelsId = comTravelsId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getTravelsId() {
        return travelsId;
    }

    public void setTravelsId(Integer travelsId) {
        this.travelsId = travelsId;
    }

    public String getComTravelsContent() {
        return comTravelsContent;
    }

    public void setComTravelsContent(String comTravelsContent) {
        this.comTravelsContent = comTravelsContent;
    }

    public Date getComTravelsRelease() {
        return comTravelsRelease;
    }

    public void setComTravelsRelease(Date comTravelsRelease) {
        this.comTravelsRelease = comTravelsRelease;
    }

    public Date getComTravelsCreate() {
        return comTravelsCreate;
    }

    public void setComTravelsCreate(Date comTravelsCreate) {
        this.comTravelsCreate = comTravelsCreate;
    }

    public Date getComTravelsUpdate() {
        return comTravelsUpdate;
    }

    public void setComTravelsUpdate(Date comTravelsUpdate) {
        this.comTravelsUpdate = comTravelsUpdate;
    }

    public Integer getComTravelsYn() {
        return comTravelsYn;
    }

    public void setComTravelsYn(Integer comTravelsYn) {
        this.comTravelsYn = comTravelsYn;
    }
}