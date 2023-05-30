package com.partner.propertyms.service;


import com.partner.propertyms.entity.SpPermission;

import java.util.List;


public interface PermissionService {
    List<SpPermission> getMenuTree(String mark);
}
