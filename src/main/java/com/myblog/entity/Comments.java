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
@ApiModel(description = "Comments",value = "Comments")
public class Comments implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "评论ID")
    @TableId(type = IdType.ASSIGN_ID)
    private Long commentId;

    @ApiModelProperty(value = "发表用户ID")
    private Long userId;

    @ApiModelProperty(value = "评论博文ID")
    private Long blogId;

    @ApiModelProperty(value = "点赞数")
    private Long commentLikeCount;

    @ApiModelProperty(value = "评论日期")
    private Date commentDate;

    @ApiModelProperty(value = "评论内容")
    private String commentContent;

    @ApiModelProperty(value = "父评论ID")
    private Long parentCommentId;

}