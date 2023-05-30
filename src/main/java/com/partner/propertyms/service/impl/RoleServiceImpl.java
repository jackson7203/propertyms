package com.partner.propertyms.service.impl;

import com.partner.propertyms.entity.SpRole;
import com.partner.propertyms.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("RoleService")
public class RoleServiceImpl implements com.partner.propertyms.service.RoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<SpRole> getAllRoles() {
        return roleMapper.getAllRoles();
    }

    @Override
    public int createRole(SpRole spRole) {
        return roleMapper.createRole(spRole);
    }

    @Override
    public SpRole getRoleById(int roleId) {
        return roleMapper.getRoleById(roleId);
    }

    @Override
    public int updateRoleRight(SpRole spRole) {

        return roleMapper.updateRoleRight(spRole);
    }

    @Override
    public int deleteRoleRight(int roleId) {

        return roleMapper.deleteRoleRight(roleId);
    }

    @Override
    public int updateRole(SpRole spRole) {

        return roleMapper.updateRole(spRole);
    }

    @Override
    public int deleteRole(int roleId) {

        return roleMapper.deleteRole(roleId);
    }
}
