package com.myblog.mapper;

import com.myblog.entity.SetBlogSort;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *     Mapper 接口
 * </p>
 *
 * @author lemoncc
 * @since 2020-12-15
 */
@Mapper
@Repository
public interface SetBlogSortMapper extends BaseMapper<SetBlogSort>{
}