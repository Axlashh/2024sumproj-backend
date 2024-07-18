package edu.njust.back_end.modules.users.entity;

import lombok.Data;

@Data
public class LoginForm {
    private String userName;
    private String password;
    private String phone;
    private String captcha;
    private String newPassword;
    private String secondPassword;
    private String imageCaptcha;
    private String email;
    private Integer identity;
    private String idCardNumber;
    private Integer gender;
    private Integer title;
    private String name;
    private Integer department;
    private String staffId;
    private String description;
}
