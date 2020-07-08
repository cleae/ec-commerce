package com.tl.eccommercecommon.service.impl;

import com.tl.service.domain.User;
import com.tl.service.mapper.UserMapper;
import com.tl.eccommercecommon.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;

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
//
    @Override
    public User findAllByLoginName(String loginName) {
        return userMapper.findAllByLoginName(loginName);
    }
}
