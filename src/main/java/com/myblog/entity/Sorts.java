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
@ApiModel(description = "Sorts",value = "Sorts")
public class Sorts implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "分类ID")
    @TableId(type = IdType.ASSIGN_ID)
    private Long sortId;

    @ApiModelProperty(value = "分类名称")
    private String sortName;

    @ApiModelProperty(value = "分类别名")
    private String sortAlias;

    @ApiModelProperty(value = "分类描述")
    private String sortDescription;

    @ApiModelProperty(value = "父分类ID")
    private Long parentSortId;

}