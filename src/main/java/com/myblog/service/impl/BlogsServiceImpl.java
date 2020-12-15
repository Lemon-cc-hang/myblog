package com.myblog.service.impl;

import com.myblog.entity.Blogs;
import com.myblog.mapper.BlogsMapper;
import com.myblog.service.BlogsService;
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
public class BlogsServiceImpl extends ServiceImpl<BlogsMapper, Blogs> implements BlogsService {

}
