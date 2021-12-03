package com.example.business.aspects;

import com.example.business.CheckLogin;
import com.example.business.entity.user.UserInfo;
import com.example.business.service.user.UserInfoService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Aspect
@Component
public class ChectLoginInterceptor {
    @Autowired
    private UserInfoService userInfoService;

    @Before(value = "@within(com.example.business.CheckLogin) || @annotation(com.example.business.CheckLogin)")
    public void permissionCheck(JoinPoint jointPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) jointPoint.getSignature();
        // 优先取方法上的注解
        CheckLogin annotation = methodSignature.getMethod().getAnnotation(CheckLogin.class);
        if (Objects.isNull(annotation)) {
            annotation = jointPoint.getTarget().getClass().getAnnotation(CheckLogin.class);
        }
        UserInfo userInfo = userInfoService.login("123456");
        if (Objects.isNull(userInfo)){
            throw new IllegalArgumentException("用户不存在");
        }
    }
}
