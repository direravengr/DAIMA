package com.springboot.project.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.shiro.mgt.SecurityManager;
import java.util.LinkedHashMap;
import java.util.Map;

@Slf4j
@Configuration
public class ShiroConfig {

    @Bean
    public UserRealm userRealm(){
        return new UserRealm();
    }

    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager=new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm());
        return securityManager;
    }

    @Bean
    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // 必须设置 SecurityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // 设置登录页面的url；如果不设置值，默认会自动寻找Web工程根目录下的"/login.jsp"页面 或 "/login" 映射
        shiroFilterFactoryBean.setLoginUrl("/login");
        // 设置授权失败时应该跳转的页面（即：访问了权限不足的页面时，需要跳转到/role对应的url）
        shiroFilterFactoryBean.setUnauthorizedUrl("/login");
        shiroFilterFactoryBean.setSuccessUrl("/success");

        // 设置拦截器
        Map<String, String> filterMap = new LinkedHashMap<>();
        // anon：表示可以匿名访问（不需要认证）
        filterMap.put("/guest/**", "anon");
        // 用户，需要角色权限 user
        filterMap.put("/user/**", "roles[user]");
        filterMap.put("/admin/**", "roles[admin]");
        // 开放登陆接口
        filterMap.put("/doLogin", "anon");
        filterMap.put("/login", "anon");
        // 其余接口一律拦截
        // 主要这行代码必须放在所有权限设置的最后，不然会导致所有 url 都被拦截
        filterMap.put("/**", "authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        log.info("Shiro拦截器工厂类注入成功");

        return shiroFilterFactoryBean;
    }
}
