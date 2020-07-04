package com.tl.service.service.impl;

import com.tl.service.domain.User;
import com.tl.service.mapper.OrderMapper;
import com.tl.service.mapper.UserMapper;
import com.tl.service.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;

    @Override
    public int insert() {
        return 0;
    }

    @Override
    public List<User> getUserOrder() {
        return null;
    }

    /**
     * 登陆
     * @param loginName
     * @return
     */
//    @Transactional
    @Override
    public User findAllByLoginName(String loginName) {
        return userMapper.findAllByLoginName(loginName);
    }
}
