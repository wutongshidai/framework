package com.wutong.framework.core.web.auth.aop.intercept;

import com.wutong.framework.core.web.auth.aop.annotation.AuthLogin;
import com.wutong.framework.core.web.common.http.HttpStatus;
import com.wutong.framework.core.web.common.http.ResponseResult;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Component
@Aspect
public class AuthIntercept {


    @Around("@annotation(authLogin)")
    public ResponseResult<?> auth(ProceedingJoinPoint proceedingJoinPoint, AuthLogin authLogin) {
        if (authLogin.validate()) {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            HttpSession session = request.getSession();
            Object user = session.getAttribute("user");
            if (user == null) {
                ResponseResult<?> responseResult = new ResponseResult<>();
                responseResult.setCode(HttpStatus.CODE202);
                return responseResult;
            }
        }
        try {
            ResponseResult<?> responseResult = (ResponseResult<?>) proceedingJoinPoint.proceed();
            return responseResult;
        } catch (Throwable ex) {
            ex.printStackTrace();
            return new ResponseResult(HttpStatus.CODE500);
        }
    }
}
