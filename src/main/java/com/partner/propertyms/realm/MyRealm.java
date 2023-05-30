package com.partner.propertyms.realm;

import com.partner.propertyms.entity.SpManager;
import com.partner.propertyms.entity.SpRole;
import com.partner.propertyms.mapper.ManagerMapper;
import com.partner.propertyms.mapper.ManagerMapper;
import com.partner.propertyms.service.PermissionService;
import com.partner.propertyms.service.RoleService;
import com.partner.propertyms.utils.ActiveUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Orange
 * @date 2022/8/12 -13:35
 */
public class MyRealm extends AuthorizingRealm {
    @Autowired
    private PermissionService permissionService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private ManagerMapper managerMapper;
    @Override
    //该方法用于完成认证的功能
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        Subject subject = SecurityUtils.getSubject();

        //1.根据token获取账号
        String username = (String) token.getPrincipal();
        /**
         * 以前登陆的逻辑是  把用户和密码全部发到数据库  去匹配
         * 在shrio里面是先根据用户名把用户对象查询出来，再来做密码匹配
         */
        Object credentials = token.getCredentials();// 用户登陆时传过来的
        System.out.println(Arrays.toString((char[]) credentials));
        //2.根据账号查询用户信息
        SpManager user = managerMapper.findManagerByuname(username);
        //表示该用户名在数据库中存在
        if(user!=null){

            // 根据用户名去查询用户拥有哪些角色
            SpRole role = roleService.getRoleById(user.getRoleId());
            List<String> roles = new ArrayList<>();
            roles.add(role.getRoleName());
            // 根据用户名查询用户拥有哪些权限
            String[] temp = role.getPsIds().split(",");
            List<String> permissions = new ArrayList<>();
            for(String elem: temp) permissions.add(elem);

            ActiveUser activeUser = new ActiveUser(user,roles,permissions);
            /**
             * 参数说明
             * 参数1:可以传到任意对象
             * 参数2:从数据库里面查询出来的密码
             * 参数3:盐
             * 参数4:当前类名
             */
            ByteSource credentialsSalt = ByteSource.Util.bytes("iflytek");
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(activeUser, user.getMgPwd(),credentialsSalt,this.getName());
            return info;
        }
        //用户不存在  shiro会抛 UnknowAccountException
        return null;
    }



    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        Subject subject = SecurityUtils.getSubject();

        ActiveUser activeUser = (ActiveUser) principalCollection.getPrimaryPrincipal();

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        // 根据用户名去查询用户拥有哪些角色
        List<String> roles = activeUser.getRoles();
        System.out.println("role:------------------- "+roles.get(0));
        if (null != roles && roles.size() > 0) {
            // 添加角色
            info.addRoles(roles);
        }
        // 根据用户名查询用户拥有哪些权限
        List<String> permissions = activeUser.getPermissions();
        // 添加权限
        if (null != permissions && permissions.size() > 0) {
            // 添加角色
            info.addStringPermissions(permissions);

        }
        return info;

    }


}
