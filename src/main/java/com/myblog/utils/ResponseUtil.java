package com.myblog.utils;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.myblog.common.lang.RspData;
import com.myblog.controller.BlogsController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lemoncc
 */
public class ResponseUtil {

    static Logger logger = LoggerFactory.getLogger(BlogsController.class);
    /**
     * 往 response 写出 json
     *
     * @param response 响应
     * @param code     状态码
     * @param msg      信息
     * @param data     返回数据
     */
    public static void renderJson(HttpServletResponse response, int code, String msg, Object data) {
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Allow-Methods", "*");
            response.setContentType("application/json;charset=UTF-8");
            response.setStatus(200);

            response.getWriter().write(JSONUtil.toJsonStr(new JSONObject(RspData.success(code, msg, data), false)));
        } catch (IOException e) {
            logger.error("Response写出JSON异常，", e);
        }
    }

    /**
     * 往 response 写出 json
     *  @param response  响应
     * @param exception 异常
     */
    public static void renderJson(HttpServletResponse response, Exception exception) {
        try {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Allow-Methods", "*");
            response.setContentType("application/json;charset=UTF-8");
            response.setStatus(200);

            response.getWriter().write(JSONUtil.toJsonStr(new JSONObject(RspData.error(exception.getMessage()), false)));
        } catch (IOException e) {
            logger.error("Response写出JSON异常，", e);
        }
    }
}
