package com.myblog.common.lang;

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
    public static final int RSP_CODE__ERROR = 201;

    /**
     * 查询为空
     */
    public static final int RSP_CODE__SELECT_NULL = 202;

    /**
     * 用户名密码错误
     */
    public static final int RSP_CODE__CHECK_ERROR = 301;

    /**
     * 用户不存在
     */
    public static final int RSP_CODE__USER_NOT_FOUND = 307;

    /**
     * 已存在
     */
    public static final int RSP_CODE_IS_EXIST = 313;

    /**
     * 规则不正确
     */
    public static final int RSP_CODE_RULE_IS_ERROR = 314;

    /**
     * 不可用
     */
    public static final int RSP_CODE_NOT_AVAILABLE = 315;

    /**
     * 参数为空
     */
    public static final int RSP_CODE_ISEMPTY_PARAMETER = 701;

    /**
     * 无效参数
     */
    public static final int RSP_CODE_INVALID_PARAMETER = 702;

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

    public static RspData success() {
        return success(null);
    }

    public static RspData success(Object data) {
        return success(RSP_CODE__OK, "success", data);
    }

    public static RspData success(int code, String msg, Object data) {
        return new RspData(code, msg, data);
    }

    /**
     * meiyou quanxian 
     * @param msg
     * @return
     */
    public static RspData noPermissions(String msg) {
        return error(401, msg, null);
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

    public static RspData unknown() {
        return new RspData(101, null, null);
    }

    public static RspData invalidParameter() {
        return new RspData(102, null, null);
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
