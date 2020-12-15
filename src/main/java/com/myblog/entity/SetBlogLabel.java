package com.myblog.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;
import java.lang.Long;
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
@ApiModel(description = "SetBlogLabel",value = "SetBlogLabel")
public class SetBlogLabel implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "文章ID")
    @TableId(type = IdType.ASSIGN_ID)
    private Long blogId;

    @ApiModelProperty(value = "")
    private Long labelId;

}