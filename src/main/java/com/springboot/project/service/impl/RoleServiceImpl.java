package com.springboot.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springboot.project.entity.Role;
import com.springboot.project.mapper.IRoleMapper;
import com.springboot.project.service.IRoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends ServiceImpl<IRoleMapper, Role> implements IRoleService {
}
