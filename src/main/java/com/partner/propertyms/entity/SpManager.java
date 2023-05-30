package com.partner.propertyms.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sp_manager")
public class SpManager implements Serializable {
    private static final long serialVersionUID = -40356785423868312L;

    @TableId
    private long mgId;
    private String mgName;
    private String mgPwd;
    private long mgTime;
    private int roleId;
    private String mgMobile;
    private String mgEmail;
    private long mgState;
    private String mgUrl;

    public String getMgUrl() {
        return mgUrl;
    }

    public void setMgUrl(String mgUrl) {
        this.mgUrl = mgUrl;
    }

    public long getMgId() {
        return mgId;
    }

    public void setMgId(long mgId) {
        this.mgId = mgId;
    }


    public String getMgName() {
        return mgName;
    }

    public void setMgName(String mgName) {
        this.mgName = mgName;
    }

    public String getMgPwd() {
        return mgPwd;
    }

    public void setMgPwd(String mgPwd) {
        this.mgPwd = mgPwd;
    }


    public long getMgTime() {
        return mgTime;
    }

    public void setMgTime(long mgTime) {
        this.mgTime = mgTime;
    }


    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }


    public String getMgMobile() {
        return mgMobile;
    }

    public void setMgMobile(String mgMobile) {
        this.mgMobile = mgMobile;
    }


    public String getMgEmail() {
        return mgEmail;
    }

    public void setMgEmail(String mgEmail) {
        this.mgEmail = mgEmail;
    }


    public long getMgState() {
        return mgState;
    }

    public void setMgState(long mgState) {
        this.mgState = mgState;
    }

    @Override
    public String toString() {
        return "SpManager{" +
                "mgId=" + mgId +
                ", mgName='" + mgName + '\'' +
                ", mgPwd='" + mgPwd + '\'' +
                ", mgTime=" + mgTime +
                ", roleId=" + roleId +
                ", mgMobile='" + mgMobile + '\'' +
                ", mgEmail='" + mgEmail + '\'' +
                ", mgState=" + mgState +
                '}';
    }
}
