package com.myblog.common.exception;

import com.myblog.common.dto.Status;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 全局异常
 * </p>
 *
 * @author lemoncc
 */
@EqualsAndHashCode(callSuper = true)
public class SecurityException extends BaseException {
    public SecurityException(Status status) {
        super(status);
    }

    public SecurityException(Status status, Object data) {
        super(status, data);
    }

    public SecurityException(int code, String message) {
        super(code, message);
    }

    public SecurityException(int code, String message, Object data) {
        super(code, message, data);
    }
}
