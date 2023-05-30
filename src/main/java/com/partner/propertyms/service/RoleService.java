package com.partner.propertyms.service;

import com.partner.propertyms.entity.SpRole;

import java.util.List;

public interface RoleService {
    List<SpRole> getAllRoles();

    int createRole(SpRole spRole);

    SpRole getRoleById(int roleId);

    int updateRoleRight(SpRole spRole);

    int deleteRoleRight(int roleId);

    int updateRole(SpRole spRole);

    int deleteRole(int roleId);
}
