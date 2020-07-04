package com.tl.service.service;

import com.tl.service.domain.User;

import java.util.List;

public interface UserService {

    int insert();

    List<User> getUserOrder();

    User findAllByLoginName(String loginName);


}
