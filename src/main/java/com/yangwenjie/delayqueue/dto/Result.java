package com.yangwenjie.delayqueue.dto;

import java.util.HashMap;
import java.util.Map;

/**
 * Create By IntelliJ IDEA
 * 返回数据定义
 * @author Yang WenJie
 * @date 2017/8/28 10:32
 */
public class Result extends HashMap<String,Object> {
    /**
     * 成功编码
     */
    private static final int SUCCESS_CODE = 0;
    /**
     * 失败编码
     *
     */
    private static final int ERROR_CODE = 1;

    public Result() {
        put("code", SUCCESS_CODE);
        put("msg","操作成功！");
    }

    public static Result error() {
        return error(ERROR_CODE, "系统异常，请联系管理员");
    }

    public static Result error(String msg) {
        return error(ERROR_CODE, msg);
    }

    public static Result error(int code, String msg) {
        Result result = new Result();
        result.put("code", code);
        result.put("msg", msg);
        return result;
    }

    public static Result sucess(String msg) {
        Result result = new Result();
        result.put("msg", msg);
        return result;
    }

    public static Result sucess(Map<String, Object> map) {
        Result result = new Result();
        result.putAll(map);
        return result;
    }

    public static Result sucess() {
        return new Result();
    }

    @Override
    public Result put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    public Result putMap(Map<String, Object> map) {
        super.putAll(map);
        return this;
    }
}
