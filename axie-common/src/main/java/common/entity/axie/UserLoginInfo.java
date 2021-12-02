package common.entity.axie;

import lombok.Data;

@Data
public class UserLoginInfo {
    /**
     * 令牌
     */
    String token;
    /**
     * 账户
     */
    String account;
    /**
     * 用户类型
     */
    String user_type;
}