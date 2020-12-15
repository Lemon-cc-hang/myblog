package com.myblog.common.dto;

import lombok.Data;
import javax.validation.constraints.NotBlank;

/**
 * @author lemoncc
 */
@Data
public class LoginDto {

    @NotBlank(message = "用户昵称不能为空")
    private String username;
    @NotBlank(message = "密码不能为空")
    private String password;
}
