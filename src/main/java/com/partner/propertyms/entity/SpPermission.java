package com.partner.propertyms.entity;


import java.io.Serializable;
import java.util.List;

public class SpPermission implements Serializable {

    private long psId;
    private String psName;
    private long psPid;
    private String psC;
    private String psA;
    private String psLevel;
    private List<SpPermission> children;


    public long getPsId() {
        return psId;
    }

    public void setPsId(long psId) {
        this.psId = psId;
    }


    public String getPsName() {
        return psName;
    }

    public void setPsName(String psName) {
        this.psName = psName;
    }


    public long getPsPid() {
        return psPid;
    }

    public void setPsPid(long psPid) {
        this.psPid = psPid;
    }


    public String getPsC() {
        return psC;
    }

    public void setPsC(String psC) {
        this.psC = psC;
    }


    public String getPsA() {
        return psA;
    }

    public void setPsA(String psA) {
        this.psA = psA;
    }


    public String getPsLevel() {
        return psLevel;
    }

    public void setPsLevel(String psLevel) {
        this.psLevel = psLevel;
    }

    public List<SpPermission> getChildren() {
        return children;
    }

    public void setChildren(List<SpPermission> children) {
        this.children = children;
    }


}
