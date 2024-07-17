package edu.njust.back_end.config;

import edu.njust.back_end.modules.shiro.WebRealm;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

public class ShiroConfig {
    @Bean
    public DefaultWebSecurityManager securityManager(WebRealm webRealm, SessionManager sessionManager, ModularRealmAuthenticator authenticator) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setAuthenticator(authenticator);
        securityManager.setSessionManager(sessionManager);
        List<Realm> realmList = new ArrayList<>();
        realmList.add(webRealm);
        securityManager.setRealms(realmList);
        return securityManager;
    }
}
