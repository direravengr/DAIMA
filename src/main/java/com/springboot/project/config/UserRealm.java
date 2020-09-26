package com.springboot.project.config;

import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.springboot.project.entity.User;
import com.springboot.project.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    private IUserService iUserService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        User user=(User)principalCollection.iterator().next();
        SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
        authorizationInfo.addRole(user.getRole());
        return authorizationInfo;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        UsernamePasswordToken token=(UsernamePasswordToken)authenticationToken;
        String username=token.getUsername();
        String password=String.valueOf(token.getPassword());
        queryWrapper.eq("userName",username);
        queryWrapper.eq("status","0");
        User user=iUserService.getOne(queryWrapper);
        if(null==user){
            throw new UnknownAccountException("用户名不存在！");
        }else if (!SecureUtil.md5(password+user.getSalt()).equals(user.getUserPassword())){
            throw new IncorrectCredentialsException("密码不正确！");
        }
        SecurityUtils.getSubject().getSession().setAttribute("user",user);
        return new SimpleAuthenticationInfo(user,password,getName());
    }
}
