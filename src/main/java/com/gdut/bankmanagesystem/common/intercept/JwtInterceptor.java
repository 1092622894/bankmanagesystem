package com.gdut.bankmanagesystem.common.intercept;

import com.gdut.bankmanagesystem.common.Constants;
import com.gdut.bankmanagesystem.common.anno.JwtTokenIgnore;
import com.gdut.bankmanagesystem.common.anno.Role;
import com.gdut.bankmanagesystem.entity.dto.JwtTokenDTO;
import com.gdut.bankmanagesystem.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author honzooban
 * @version 1.0.0
 * @ClassName JwtInterceptor.java
 * @Description
 * @createTime 2021年01月03日 19:59:00
 */
public class JwtInterceptor implements HandlerInterceptor {

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        if (!method.isAnnotationPresent(JwtTokenIgnore.class)) {
            Assert.notNull(token, "无token，请重新登录");
            jwtUtil.checkSign(token);
            JwtTokenDTO message = jwtUtil.getMessage(token, new JwtTokenDTO());
            String role = method.getAnnotation(Role.class).value();
            Assert.isTrue(role.equals(String.valueOf(message.getRole())), "当前身份没有权限访问此接口，请重试");
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
