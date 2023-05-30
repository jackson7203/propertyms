package com.partner.propertyms.mapper;

import com.partner.propertyms.entity.SpManager;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ManagerMapper {

    @Select("select * from sp_manager")
    List<SpManager> getAllManagers();

    @Select("select * from sp_manager where mg_name like \"%\"#{query}\"%\"")
    List<SpManager> fuzzySearchManagers(String query);

    @Select("select * from sp_manager where mg_id=#{mg_id}")
    SpManager getManager(int mg_id);

    @Select("select * from sp_manager where mg_name=#{mgName} and mg_pwd=#{mgPwd}")
    SpManager findManagerByunamepwd(SpManager spManager);

    @Select("select * from sp_manager where mg_name=#{mgName} ")
    SpManager findManagerByuname(String username);

    @Insert("insert into sp_manager (mg_name,mg_pwd,mg_time,role_id,mg_mobile,mg_email,mg_state)" +
            " values(#{mgName},#{mgPwd},#{mgTime},30,#{mgMobile},#{mgEmail},1)")
    int createManager(SpManager manger);

    @Update("update sp_manager set mg_mobile=#{mgMobile},mg_email=#{mgEmail} where mg_id=#{mgId}")
    int updateManager(SpManager manger);

    //这是真删除
    @Delete("delete from sp_manager where mg_id=#{mg_id}")
    int deleteManager(int mg_id);

    //更新用户角色
    @Update("update sp_manager set role_id=#{roleId} where mg_id=#{mgId}")
    int setRole(SpManager mg);

    //这是假删除（改变状态mg_state=0,1互换）
    @Update("update sp_manager set mg_state=(mg_state+1)%2 where mg_id=#{mg_id}")
    int updateMgrState(int mg_id);


    @Select("select mg_url from sp_manager")
    List<String> getAllUrl();

    @Select("select * from sp_manager where mg_url=#{mgUrl}")
    SpManager getManagerByUrl(String mgUrl);
}
