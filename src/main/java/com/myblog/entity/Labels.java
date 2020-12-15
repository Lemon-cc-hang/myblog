package com.myblog.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;
import java.lang.Long;
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
@ApiModel(description = "Labels",value = "Labels")
public class Labels implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "标签ID")
    @TableId(type = IdType.ASSIGN_ID)
    private Long labelId;

    @ApiModelProperty(value = "标签名称")
    private String labelName;

    @ApiModelProperty(value = "标签别名")
    private String labelAlias;

    @ApiModelProperty(value = "标签描述")
    private String labelDescription;

}