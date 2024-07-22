package edu.njust.back_end.modules.users.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import edu.njust.back_end.modules.shiro.LoginToken;
import edu.njust.back_end.modules.users.dao.DoctorDao;
import edu.njust.back_end.modules.users.dao.PatientDao;
import edu.njust.back_end.modules.users.dao.SysUserDao;
import edu.njust.back_end.modules.users.entity.DoctorEntity;
import edu.njust.back_end.modules.users.entity.LoginForm;
import edu.njust.back_end.modules.users.entity.PatientEntity;
import edu.njust.back_end.modules.users.entity.SysUserEntity;
import edu.njust.back_end.modules.utils.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Slf4j
@RestController
public class SysUserController {

    @Autowired
    SysUserDao sysUserDao;

    @Autowired
    PatientDao patientDao;

    @Autowired
    DoctorDao doctorDao;

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @Value("${jwt.tokenHead}")
    String tokenHead;

    @PostMapping("/login")
    public R<?> login(@RequestBody LoginForm loginForm, HttpServletRequest request) {
        Subject subject = ShiroUtil.getSubject();
        try {
            if (loginForm.getPhone() == null || loginForm.getPhone().isEmpty()) {
                //账号密码登录
                subject.login(new LoginToken(loginForm.getUserName(), loginForm.getPassword(), LoginEnum.PASSWORD.getValue()));
            } else {
                subject.login(new LoginToken(loginForm.getUserName(), loginForm.getPhone(), loginForm.getPassword(), LoginEnum.PHONE_CAPTCHA.getValue()));
            }
        } catch (UnknownAccountException e) {
            return R.error("账号或密码错误");
        } catch (Exception e) {
            return R.error("未知错误");
        }
        //登录成功，发放一个jwt
        String token = tokenHead + jwtTokenUtil.generateToken((SysUserEntity) subject.getPrincipal());
        return R.ok(token);
    }

    /**
     * 注册
     * @param loginForm
     * @return
     */
    @PostMapping("/signIn")
    public R<?> signIn(@RequestBody LoginForm loginForm) {
        SysUserEntity user;
        user = sysUserDao.selectOne(new QueryWrapper<SysUserEntity>().eq("user_name", loginForm.getUserName()));
        if (user != null) {
            return R.error("用户名已被注册");
        }
        user = sysUserDao.selectOne(new QueryWrapper<SysUserEntity>().eq("phone", loginForm.getPhone()));
        if (user != null) {
            return R.error("手机号已被注册");
        }
        user = new SysUserEntity();
        user.setUserId(UuidUtil.randomUUID());
        user.setSalt(UuidUtil.randomUUID());
        BeanUtils.copyProperties(loginForm, user);
        user.setPassword(ShiroUtil.sha256(user.getPassword(), user.getSalt()));
        sysUserDao.insert(user);
        if (loginForm.getIdentity().equals(IdentityEnum.DOCTOR.getValue())) {
            //身份为医生
            DoctorEntity doctor = new DoctorEntity();
            doctor.setDoctorId(UuidUtil.randomUUID());
            doctor.setUserId(user.getUserId());
            BeanUtils.copyProperties(loginForm, doctor);
            doctorDao.insert(doctor);

        } else if (loginForm.getIdentity().equals(IdentityEnum.PATIENT.getValue())) {
            //身份为患者
            PatientEntity patient = new PatientEntity();
            patient.setPatientId(UuidUtil.randomUUID());
            patient.setUserId(user.getUserId());
            BeanUtils.copyProperties(loginForm, patient);
            patientDao.insert(patient);
        }
        return R.ok();
    }

    @GetMapping("/33")
    public R<?> ii() {
        return R.ok();
    }

}
