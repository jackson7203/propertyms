package com.partner.propertyms.mapper;

import com.partner.propertyms.entity.SpPermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PermissionMapper {

    @Select("select * from sp_permission")
    List<SpPermission> findAllPermission();
}
