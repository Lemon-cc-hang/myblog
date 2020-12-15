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
@ApiModel(description = "UserFriends",value = "UserFriends")
public class UserFriends implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "标识ID")
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty(value = "用户ID")
    private Long userId;

    @ApiModelProperty(value = "好友ID")
    private Long userFriendsId;

    @ApiModelProperty(value = "好友备注")
    private String userNote;

    @ApiModelProperty(value = "好友状态")
    private String userStatus;

}