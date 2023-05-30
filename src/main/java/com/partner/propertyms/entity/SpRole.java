package com.partner.propertyms.entity;


import java.io.Serializable;

public class SpRole implements Serializable {

    private long roleId;
    private String roleName;
    private String psIds;
    private String psCa;
    private String roleDesc;


    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }


    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }


    public String getPsIds() {
        return psIds;
    }

    public void setPsIds(String psIds) {
        this.psIds = psIds;
    }


    public String getPsCa() {
        return psCa;
    }

    public void setPsCa(String psCa) {
        this.psCa = psCa;
    }


    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    @Override
    public String toString() {
        return "SpRole{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", psIds='" + psIds + '\'' +
                ", psCa='" + psCa + '\'' +
                ", roleDesc='" + roleDesc + '\'' +
                '}';
    }
}
