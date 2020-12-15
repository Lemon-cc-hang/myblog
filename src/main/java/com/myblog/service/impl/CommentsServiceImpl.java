package com.myblog.service.impl;

import com.myblog.entity.Comments;
import com.myblog.mapper.CommentsMapper;
import com.myblog.service.CommentsService;
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
public class CommentsServiceImpl extends ServiceImpl<CommentsMapper, Comments> implements CommentsService {

}
