package com.example.business.service.user.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.business.entity.user.UserInfo;
import com.example.business.daos.user.UserInfoMapper;
import com.example.business.service.user.UserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import common.entity.user.UserInfoDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author liushengbin
 * @since 2021-12-02
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    /**
     * 得到用户信息
     *
     * @param userInfoDO
     * @return
     */
    @Override
    public UserInfo getUserInfo(UserInfoDO userInfoDO) {
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", userInfoDO.getName());
        queryWrapper.eq("password", userInfoDO.getPassword());
        queryWrapper.eq("is_delete", 0);
        return userInfoMapper.selectOne(queryWrapper);
    }
}
