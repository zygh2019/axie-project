package com.example.business.service.user.impl;

import com.example.business.entity.user.UserInfo;
import com.example.business.daos.user.UserInfoMapper;
import com.example.business.service.user.UserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liushengbin
 * @since 2021-12-02
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

}
