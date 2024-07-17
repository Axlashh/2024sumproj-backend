package edu.njust.back_end.modules.users.controller;

import edu.njust.back_end.modules.users.entity.SysUserEntity;
import edu.njust.back_end.modules.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LoginController {

    @PostMapping("/login")
    public R<?> login(@RequestBody SysUserEntity user) {
        return R.ok();
    }

    @GetMapping("/")
    public R<?> ii() {
        return R.ok();
    }

}
