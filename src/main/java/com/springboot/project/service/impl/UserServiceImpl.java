package com.springboot.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springboot.project.entity.Role;
import com.springboot.project.entity.User;
import com.springboot.project.mapper.IUserMapper;
import com.springboot.project.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl extends ServiceImpl<IUserMapper, User> implements IUserService{
    @Autowired
    private IUserMapper iUserMapper;

    @Override
    public Set<Role> getUserRoles(String userId) {
        return iUserMapper.getUserRoles(userId);
    }
}
