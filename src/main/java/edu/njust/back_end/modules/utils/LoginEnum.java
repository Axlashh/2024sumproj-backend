package edu.njust.back_end.modules.utils;

import lombok.Getter;

/**
 * 登陆时用的枚举量
 */
@Getter
public enum LoginEnum {
    PASSWORD(0, "密码登录"), PHONE_CAPTCHA(1, "手机号登陆");
    private final int value;
    private final String name;

    private LoginEnum(int value, String name) {
        this.value = value;
        this.name = name;
    }
}
