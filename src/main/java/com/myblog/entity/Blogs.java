package com.myblog.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;
import java.lang.Long;
import java.util.Date;
import java.lang.String;
import java.lang.Integer;
/**
 * <p>
 *     实体类
 * </p>
 *
 * @author lemoncc
 * @since 2020-12-15
 */
@Data
@EqualsAndHashCode
@ApiModel(description = "Blogs",value = "Blogs")
public class Blogs implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "博客ID")
    @TableId(type = IdType.ASSIGN_ID)
    private Long blogId;

    @ApiModelProperty(value = "发表用户ID")
    private Long userId;

    @ApiModelProperty(value = "博文标题")
    private String blogTitle;

    @ApiModelProperty(value = "博文子标题")
    private String blogSubtitle;

    @ApiModelProperty(value = "博文图片")
    private String blogImage;

    @ApiModelProperty(value = "博文描述")
    private String blogDescription;

    @ApiModelProperty(value = "博文内容")
    private String blogContent;

    @ApiModelProperty(value = "浏览量")
    private Long blogViews;

    @ApiModelProperty(value = "评论总数")
    private Long blogCommentCount;

    @ApiModelProperty(value = "点赞数")
    private Long blogLikeCount;

    @ApiModelProperty(value = "创建时间")
    private Date gmtCreate;

    @ApiModelProperty(value = "更新时间")
    private Date gmtModified;

    @ApiModelProperty(value = "是否删除")
    private Integer deleted;

    @ApiModelProperty(value = "当前版本")
    private Integer version;

}