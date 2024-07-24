package edu.njust.back_end.modules.shiro;

import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.Serializable;

public class MyWebSessionManager extends DefaultWebSessionManager {
//    @Value("${jwt.tokenHeader}")
    public String HEADER_TOKEN_NAME = "ooo";
    private static final String REFERENCED_SESSION_ID_SOURCE = "Stateless request";

    /**
     * 逻辑:
     * 如果请求头中有 JSessionId，就分析它；
     * 没有就调用父类的方法
     */
    @Override
    protected Serializable getSessionId(ServletRequest request, ServletResponse response) {
        String JSessionId = WebUtils.toHttp(request).getHeader(HEADER_TOKEN_NAME);

        if (JSessionId == null) {
            return super.getSessionId(request, response);
        } else {
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_SOURCE, REFERENCED_SESSION_ID_SOURCE);
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID, JSessionId);
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_IS_VALID, Boolean.TRUE);
            return JSessionId;
        }
    }
}
