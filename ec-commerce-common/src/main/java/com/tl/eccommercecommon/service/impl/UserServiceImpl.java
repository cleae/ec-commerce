package com.tl.eccommercecommon.service.impl;

import com.tl.service.domain.User;
import com.tl.service.mapper.UserMapper;
import com.tl.eccommercecommon.service.UserService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
@CacheConfig(cacheNames = "userInfoCache")
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;

    /**
     * 用户注册刷到缓存
     * @param user
     * @return
     */
//    @CachePut(key = "#p0.loginname")
    @Override
    public int insert(User user) {
        return userMapper.insertUser(user);
    }


    /**
     * 获取用户所有订单
     * @return
     */
    @Override
    public List<User> getUserOrder() {
        return userMapper.getUserOrder();
    }


    /**
     * 登陆
     * @param loginName
     * @return
     */
    @Cacheable(key = "#p0",unless="#result == null")
    @Override
    public User findAllByLoginName(String loginName) {
        System.out.println("called in ...");
        return userMapper.findAllByLoginName(loginName);
    }
}
