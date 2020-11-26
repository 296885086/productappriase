package com.sise.productappriase.service;

import com.sise.productappriase.entity.User;

public interface UserService {

    int save(User user);

    User findUserByEmailAndUsername(String email, String username);

    User findUserByUsername(String username);

    int updateUser(User user);

    User findUserByUsernameAndPwd(String username, String password);

    User findUserById(Integer id);
}
