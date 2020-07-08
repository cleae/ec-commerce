package com.tl.eccommercecommon.service;

import com.tl.service.domain.User;

import java.util.List;

public interface UserService {

    int insert(User user);

    List<User> getUserOrder();

    User findAllByLoginName(String loginName);


}
