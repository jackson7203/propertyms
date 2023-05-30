package com.partner.propertyms.service.impl;

import com.partner.propertyms.entity.SpPermission;
import com.partner.propertyms.mapper.PermissionMapper;
import com.partner.propertyms.service.PermissionService;
import com.partner.propertyms.utils.Id2TreePerm;
import com.partner.propertyms.entity.SpPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("UserService")
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public List<SpPermission> getMenuTree(String mark) {
        Id2TreePerm menu = new Id2TreePerm(permissionMapper.findAllPermission(), mark);
        List<SpPermission> treeMenu = menu.buildTree();
        return treeMenu;
    }

}