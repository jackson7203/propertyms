package com.partner.propertyms.mapper;

import com.partner.propertyms.entity.SpRole;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RoleMapper {

    //角色列表
    @Select("select * from sp_role")
    List<SpRole> getAllRoles();

    //添加角色
    @Insert("insert into sp_role(role_name,role_desc) " +
            "values(#{roleName},#{roleDesc})")
    int createRole(SpRole spRole);

    //获取角色详情
    @Select("select * from sp_role where role_id=#{roleId} ")
    SpRole getRoleById(int roleId);

    //角色授权
    @Update("update sp_role set ps_ids=#{psIds} where role_id=#{roleId}")
    int updateRoleRight(SpRole spRole);

    //取消角色授权
    @Update("update sp_role set ps_ids=\'0\' where role_id=#{roleId}")
    int deleteRoleRight(int roleId);

    //更新角色信息
    @Update("update sp_role set role_name=#{roleName},role_desc=#{roleDesc} where role_id=#{roleId}")
    int updateRole(SpRole spRole);

    //删除角色
    @Delete("delete from sp_role where role_id=#{roleId}")
    int deleteRole(int roleId);

    @Select("SELECT \n" +
            "\t\tDISTINCT sr.ps_ids\n" +
            "FROM \n" +
            "\t\tsp_manager sm\n" +
            "LEFT JOIN sp_role sr ON sm.role_id =sr.role_id\n" +
            "WHERE sm.mg_id=#{mgId} AND sm.mg_state=1")
    List<String> selectRoleById(long mgId);
//
//    @Select("SELECT \n" +
//            "\t\tDISTINCT sr.ps_ids\n" +
//            "FROM \n" +
//            "\t\tsp_manager sm\n" +
//            "LEFT JOIN sp_role sr ON sm.role_id =sr.role_id\n" +
//            "WHERE sm.mg_id=#{mgId} AND sm.mg_state=1")
//    List<Integer> selectRoleIntById(long mgId);

}
