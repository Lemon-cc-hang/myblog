package com.myblog.service.impl;

import com.myblog.entity.Users;
import com.myblog.mapper.UsersMapper;
import com.myblog.service.UsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lemoncc
 * @since 2020-12-15
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements UsersService {

}
