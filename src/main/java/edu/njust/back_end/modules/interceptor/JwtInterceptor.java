package edu.njust.back_end.modules.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import edu.njust.back_end.modules.utils.JwtTokenUtil;
import edu.njust.back_end.modules.utils.R;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.HashMap;
import java.util.Map;

@Component
public class JwtInterceptor implements HandlerInterceptor {
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        System.out.println("Request URI: " + uri);
        String header = request.getHeader(tokenHeader);
        if (header != null && header.startsWith(tokenHead)) {
            String token = header.substring(tokenHead.length());
            String userName = jwtTokenUtil.getUserNameFromToken(token);
            //如果jwt没问题且没过期则放行
            if (userName != null && !jwtTokenUtil.isTokenExpired(token)) {
                return true;
            }
        }
        Map<String, Object> map = new HashMap<>();
        map.put("status", R.Status.ERROR);
        map.put("message", "请先登录!");
        String json = new ObjectMapper().writeValueAsString(map);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(json);
        return false;
    }
}
