package common.aspects;

import common.annotation.CheckLogin;
import common.utils.LoginAxieUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Aspect
@Component
public class ChectLoginInterceptor {
    @Before(value = "@within(common.annotation.CheckLogin) || @annotation(common.annotation.CheckLogin)")
    public void permissionCheck(JoinPoint jointPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature)jointPoint.getSignature();
        // 优先取方法上的注解
        CheckLogin annotation = methodSignature.getMethod().getAnnotation(CheckLogin.class);
        if (Objects.isNull(annotation)) {
            annotation = jointPoint.getTarget().getClass().getAnnotation(CheckLogin.class);
        }
        LoginAxieUtil.login();
    }
}
