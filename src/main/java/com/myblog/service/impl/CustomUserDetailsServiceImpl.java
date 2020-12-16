package com.myblog.service.impl;

import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.myblog.common.dto.UserPrincipal;
import com.myblog.entity.Users;
import com.myblog.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lemoncc
 */
@Service
public class CustomUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 查询用户, 通过用户名, 手机或者邮箱
        Users user = usersMapper.selectOne(new QueryChainWrapper<>(usersMapper).eq("user_name", username).or().eq("user_email", username).or().eq("user_telephone_number", username));
        // 查询用户的权限
        String permission = String.valueOf(user.getUserId());
        List<String> list = new ArrayList<>();
        list.add(permission);

        return UserPrincipal.create(user, list);
    }
}
