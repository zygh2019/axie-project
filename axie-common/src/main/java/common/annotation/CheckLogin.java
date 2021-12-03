package common.annotation;

import java.lang.annotation.*;

/**
 * 检查登陆
 * @author shengbinliu
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CheckLogin {
}