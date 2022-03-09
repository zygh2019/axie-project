package com.example.business.service.user.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.business.entity.user.UserInfo;
import com.example.business.daos.user.UserInfoMapper;
import com.example.business.service.user.UserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import common.entity.axie.TokenDTO;
import common.entity.user.UserInfoDO;
import common.utils.HttpClientUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.rmi.runtime.Log;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author liushengbin
 * @since 2021-12-02
 */
@Service
@Slf4j
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;
    public static String TOKEN = null;
    public static boolean INIT = false;
    /**
     * 得到用户信息
     *
     * @param userInfoDO
     * @return
     */
    @Override
    public UserInfo getUserInfo(UserInfoDO userInfoDO) {
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();

     if(userInfoDO.getSessionKey()!=null){
         queryWrapper.eq("session_key", userInfoDO.getSessionKey());
     }
        queryWrapper.eq("is_delete", 0);

        return userInfoMapper.selectOne(queryWrapper);
    }

    /**
     * 登陆
     *
     * @param sessionKey
     * @return
     */
    @Override
    public UserInfo login(String sessionKey) {


        UserInfo userInfo = getUserInfo(UserInfoDO.builder().sessionKey(sessionKey).build());
        if(Objects.isNull(userInfo)){
            return null;
        }
        if (!INIT) {


            log.info("查出得用户{}",userInfo);
            String url = "https://api.hhwguild.com/index.php/user/login";
            Map<String, String> map = new HashMap<>();
            map.put("account", userInfo.getName());
            map.put("password", userInfo.getPassword());

            String httpOrgCreateTestRtn = HttpClientUtil.doPost(url, map);
            TokenDTO tokenDTO = JSON.parseObject(httpOrgCreateTestRtn, TokenDTO.class);
            if (!Objects.isNull(tokenDTO.getData())) {
                TOKEN = tokenDTO.getData().getToken();
                INIT = true;

            }
        }

        return userInfo;
    }
}
