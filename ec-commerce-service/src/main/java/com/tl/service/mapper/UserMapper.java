package com.tl.service.mapper;

import com.tl.service.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {


    int insertUser(User user);

    int updateUser(Integer status,Integer id);


    int deleteUser(Integer id);

    User findAllByLoginName (@Param("loginName") String loginname);


    List<User> findUserBySubQuery(@Param("ids") List<Integer> ids);


    List<User> findUserOrder();


    List<User> findAllDelay();

    List<User> getUserOrder();
}
