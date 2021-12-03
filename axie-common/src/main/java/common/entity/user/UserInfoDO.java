package common.entity.user;

import cn.hutool.system.UserInfo;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import lombok.*;

/**
 * <p>
 * 
 * </p>
 *
 * @author liushengbin
 * @since 2021-12-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoDO  {

    private static final long serialVersionUID = 1L;

    /**
     * 名字
     */
    private String name;

    /**
     * 密码
     */
    private String password;
    /**
     * 令牌
     */
    private String token;
    /**
     * 密钥
     */
    private String sessionKey;
}
