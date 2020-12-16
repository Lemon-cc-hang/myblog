package com.myblog.common.lang;

import com.myblog.common.dto.IStatus;
import com.myblog.common.dto.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author lemoncc
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RspData implements Serializable {

    /**
     * success
     */
    public static final int RSP_CODE__OK = 200;

    /**
     * 增删改失败
     */
    public static final int RSP_CODE__ERROR = 400;

    /**
     * 状态码
     */
    private int rspCode;

    /**
     * 消息
     */
    private String rspMsg;

    /**
     * 传到前端的数据
     */
    private Object rspData;

    /**
     * 构造器
     * @param rspCode 状态码
     * @param rspMsg 消息
     */
    public RspData(int rspCode, String rspMsg) {
        this(rspCode, rspMsg, null);
    }

    public RspData(IStatus status, Object data) {
        this(status.getCode(), status.getMessage(), data);
    }

    public RspData(IStatus status) {
        this(status.getCode(), status.getMessage());
    }

    public static RspData success() {
        return success(null);
    }

    public static RspData success(Object data) {
        return success(RSP_CODE__OK, "success", data);
    }

    public static RspData success(int code, String msg, Object data) {
        return new RspData(code, msg, data);
    }

    public static RspData noPermissions() {
        return new RspData(Status.ACCESS_DENIED);
    }

    public static RspData error(int errCode) {
        return new RspData(errCode, "error");
    }

    public static RspData error(int errCode, String msg) {
        switch (msg) {
            case "113":
                errCode = 113;
                msg = "token cannot be empty.";
                break;
            case "114":
                errCode = 114;
                msg = "The account in Token is empty.";
                break;
            case "115":
                errCode = 115;
                msg = "The account does not exist.";
                break;
            case "116":
                errCode = 116;
                msg = "token expired or incorrect.";
                break;
            default:
                break;
        }
        return new RspData(errCode, msg, null);
    }

    public static RspData invalidParameter() {
        return new RspData(Status.PARAM_NOT_MATCH);
    }

    public static RspData error(String msg) {
        return error(RSP_CODE__ERROR, msg, null);
    }

    public static RspData error(String msg, Object data) {
        return error(400, msg, data);
    }

    public static RspData error(int code, String msg, Object data) {
        return new RspData(code, msg, data);
    }
}
