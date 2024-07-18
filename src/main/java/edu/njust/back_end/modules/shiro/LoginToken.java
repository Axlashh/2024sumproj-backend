package edu.njust.back_end.modules.shiro;

import edu.njust.back_end.modules.utils.LoginEnum;
import lombok.Getter;
import lombok.Setter;
import org.apache.shiro.authc.UsernamePasswordToken;

@Getter
@Setter
public class LoginToken extends UsernamePasswordToken {
    /**
     * 登录类型
     */
    private int loginType;
    /**
     * 手机号
     */
    private String phone;

    /**
     * 验证码
     */
    private String captcha;

    public LoginToken(String username, String password, int loginType) {
        super(username, password);
        this.loginType = loginType;
    }

    public LoginToken(String username, String phone, String captcha, int loginType) {
        super(username, "");
        this.loginType = loginType;
        this.phone = phone;
        this.captcha = captcha;
    }
}
