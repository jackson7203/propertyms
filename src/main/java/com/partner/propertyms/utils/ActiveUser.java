package com.partner.propertyms.utils;

import com.partner.propertyms.entity.SpManager;

import java.io.Serializable;
import java.util.List;

/**
 * @author Orange
 * @date 2022/8/22 -20:10
 */
public class ActiveUser implements Serializable {

    private SpManager user;

    private List<String> roles;

    private List<String> permissions;

    public ActiveUser() {

    }
    public ActiveUser(SpManager user, List<String> roles, List<String> permissions) {
        this.user = user;
        this.roles = roles;
        this.permissions = permissions;
    }

    public SpManager getUser() {
        return user;
    }

    public void setUser(SpManager user) {
        this.user = user;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }
}
