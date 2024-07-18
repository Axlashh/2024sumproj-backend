package edu.njust.back_end.modules.shiro;

import ch.qos.logback.core.status.WarnStatus;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import edu.njust.back_end.modules.users.dao.SysUserDao;
import edu.njust.back_end.modules.users.entity.SysUserEntity;
import edu.njust.back_end.modules.users.service.SysUserService;
import edu.njust.back_end.modules.utils.LoginEnum;
import edu.njust.back_end.modules.utils.ShiroUtil;
import jakarta.annotation.Resource;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

/**
 * 登录认证用的Realm
 */
public class WebRealm extends AuthorizingRealm {

    @Autowired
    SysUserDao sysUserDao;


    /**
     * 授权(验证权限时调用)
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //todo 授权模块
        return null;
    }

    /**
     * 认证(登录时调用)
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        LoginToken loginToken = (LoginToken) authenticationToken;
        if (loginToken.getLoginType() == LoginEnum.PASSWORD.getValue()) {
            //密码登录
            SysUserEntity user = sysUserDao.selectOne(new QueryWrapper<SysUserEntity>().eq("user_name", loginToken.getUsername()));
            if (user == null) {
                throw new UnknownAccountException("帐号或密码不正确！");
            }
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), ByteSource.Util.bytes(user.getSalt()), getName());
            String password = String.valueOf(loginToken.getPassword());
            String realPassword = ShiroUtil.sha256(password, user.getSalt());
            //密码错误
            if (!user.getPassword().equals(realPassword)) {
                throw new UnknownAccountException("帐号或密码不正确！");
            }
            return info;
        } else if (loginToken.getLoginType() == LoginEnum.PHONE_CAPTCHA.getValue()) {
            //手机验证码登录
            //todo 待完成，写完获取验证码的逻辑后再来写
        }
        return null;
    }

    /**
     * 设置shiro验证用户与密码的方法
     * @param credentialsMatcher
     */
    @Override
    public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
        HashedCredentialsMatcher shaCredentialsMatcher = new HashedCredentialsMatcher();
        shaCredentialsMatcher.setHashAlgorithmName(ShiroUtil.hashAlgorithmName);
        shaCredentialsMatcher.setHashIterations(ShiroUtil.hashIterations);
        super.setCredentialsMatcher(shaCredentialsMatcher);
    }
}
