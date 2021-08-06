package com.cuisf.shiro.realm;

import com.cuisf.entity.Perms;
import com.cuisf.entity.User;
import com.cuisf.service.UserService;
import com.cuisf.utils.ApplicationContextUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.context.ApplicationContext;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.Collections;
import java.util.List;

public class CustomerRealm extends AuthorizingRealm {

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取主身份信息
        String primaryPrincipal = (String) principalCollection.getPrimaryPrincipal();
        //根据主身份信息 获取角色和权限
        //在工厂中获取service 对象
        UserService userService = (UserService) ApplicationContextUtils.getBean("userService");
        User user =userService.findRolesByUsername(primaryPrincipal);
        //授权角色信息
        if(!CollectionUtils.isEmpty(user.getRoles())){
            SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
            user.getRoles().forEach(role -> {
                simpleAuthorizationInfo.addRole(role.getName());
                //权限信息
                List<Perms> perms =userService.findPermsByRoleId(role.getId());
                if(!CollectionUtils.isEmpty(perms)){
                    perms.forEach(perm -> {
                        simpleAuthorizationInfo.addStringPermission(perm.getName());
                    });
                }

            });
            return simpleAuthorizationInfo;
        }

        return null;
    }
    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        System.out.println("===================");

        String  principal = (String) authenticationToken.getPrincipal();


        //在工厂中获取service 对象
        UserService userService = (UserService) ApplicationContextUtils.getBean("userService");

        User user = userService.findByUserName(principal);

        if(!ObjectUtils.isEmpty(user)){
            ByteSource bytes = ByteSource.Util.bytes(user.getSalt());
            return new SimpleAuthenticationInfo(user.getUsername(),user.getPassword(),bytes,this.getName());
        }
        return null;
    }
}
