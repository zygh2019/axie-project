package com.example.business.service.user;

import com.example.business.entity.user.UserInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import common.entity.user.UserInfoDO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liushengbin
 * @since 2021-12-02
 */
public interface UserInfoService extends IService<UserInfo> {
    /**
     * 查询用户信息
     * @return
     */
    UserInfo getUserInfo(UserInfoDO userInfoDO);

    /**
     * 登陆
     * @return
     */
    UserInfo login(String sessionKey);

}
