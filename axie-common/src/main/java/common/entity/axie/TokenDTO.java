package common.entity.axie;

import lombok.Data;

@Data
public class TokenDTO {
    /**
     * 代码
     */
    String code;
    /**
     * 用户
     */
    String message;

    UserLoginInfo data;
}


