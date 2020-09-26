package com.springboot.project.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springboot.project.entity.Role;
import com.springboot.project.entity.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public interface IUserMapper extends BaseMapper<User> {
    @Select("select * from role where role_id in(select role_id from user_role where u_id = #{userId})")
    Set<Role> getUserRoles(String userId);
}
