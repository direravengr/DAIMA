package com.springboot.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.springboot.project.entity.Role;
import com.springboot.project.entity.User;

import java.util.Set;

public interface IUserService extends IService<User> {
    Set<Role> getUserRoles(String userId);
}
