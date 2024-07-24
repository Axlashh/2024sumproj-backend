package edu.njust.back_end.config;

import edu.njust.back_end.modules.shiro.MyWebSessionManager;
import edu.njust.back_end.modules.shiro.WebRealm;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.util.ThreadContext;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.*;

@Configuration
public class ShiroConfig {
    /**
     * 配置 securityManager中使用的Realm，更换成自己的Realm
     * @param webRealm
     * @return
     */
    @Bean
    public DefaultWebSecurityManager securityManager(@Qualifier("webRealm") WebRealm webRealm, @Qualifier("sessionManager")SessionManager sessionManager) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(webRealm);
        securityManager.setSessionManager(sessionManager);
        ThreadContext.bind(securityManager);
        return securityManager;
    }

    /**
     * 设置url过滤机制
     * a
     * @param securityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(securityManager);
//        //权限设置
//        Map<String,String> map = new Hashtable<>();
//
//        map.put("/login", "anon");
//
//        factoryBean.setFilterChainDefinitionMap(map);
//        //设置登录页面
//        factoryBean.setLoginUrl("/login");
//        //设置未授权页面
//        factoryBean.setUnauthorizedUrl("/login");
        return factoryBean;
    }

    @Bean
    public SessionManager sessionManager(){
        return new MyWebSessionManager();
    }

    @Bean
    public WebRealm webRealm() {
        return new WebRealm();
    }

    private static ThreadLocal<String> threadLocalVariable = new ThreadLocal<>();

    public static void setUserName(String value) {
        threadLocalVariable.set(value);
    }

    public static String getUserName() {
        return threadLocalVariable.get();
    }
}
