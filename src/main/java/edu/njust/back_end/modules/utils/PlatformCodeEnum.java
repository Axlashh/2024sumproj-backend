package edu.njust.back_end.modules.utils;

/**
 * 包装类用的枚举量
 */
public enum PlatformCodeEnum {
    SUCCESS(0, "成功响应"),
    PARAM_IS_NULL(10001, "参数为空"),
    PARAM_IS_ILLEGAL(10002, "参数不合法"),
    TOKEN_INVALID(80001, "token失效"),
    UNAUTHORIZED(80002, "未经授权"),
    ERROR(90000, "系统错误");

    private Integer code;

    private String msg;

    public Integer getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    PlatformCodeEnum(int code, String msg) {
        this.code = Integer.valueOf(code);
        this.msg = msg;
    }
}

