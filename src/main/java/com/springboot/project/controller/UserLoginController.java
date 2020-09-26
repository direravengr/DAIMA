package com.springboot.project.controller;

import cn.hutool.core.date.DateTime;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.springboot.project.Util.Result;
import com.springboot.project.entity.User;
import com.springboot.project.service.IUserService;
import cn.hutool.core.util.IdUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Wrapper;

@Slf4j
@RestController
@Api(tags = "1.0.0", description = "用户登录注册模块", value = "用户登陆注册模块")
@RequestMapping("/user")
public class UserLoginController {
    @Autowired
    private IUserService iUserService;

    @ApiOperation("注册")
    @PostMapping("/register")
    public Result register(@RequestBody User user){
        String salt = IdUtil.fastSimpleUUID();
        user.setUserPassword(SecureUtil.md5(user.getUserPassword()+salt));
        user.setSalt(salt);
        user.setStatus(0);
        user.setLastLoginTime(new DateTime());
        iUserService.save(user);
        return  Result.Success(user);
    }

    @ApiOperation("登录")
    @GetMapping("/login")
    public Result login(@RequestBody User user){

        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        User user1=iUserService.getOne(queryWrapper.eq("userCode",user.getUserCode()));
        if(user1!=null){
            return  Result.Success();
        }
        return Result.Error(404,null,user1);
    }
}
