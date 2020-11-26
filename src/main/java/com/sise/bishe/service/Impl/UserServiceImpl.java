package com.sise.bishe.service.Impl;

import com.sise.bishe.dao.UserMapper;
import com.sise.bishe.entity.User;
import com.sise.bishe.service.UserService;
import org.apache.commons.codec.digest.Md5Crypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Date;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public int save(User user) {
        int i = 0;
        User sqlUser = userMapper.findUserByUsername(user.getUsername());
        if (StringUtils.isEmpty(sqlUser)){
            //MD5加密加盐
            String password = Md5Crypt.apr1Crypt(user.getPassword().getBytes(), user.getUsername());
            user.setPassword(password);
            user.setCreateTime(new Date());
            i =  userMapper.insert(user);
        }
        return i;
    }

    @Override
    public User findUserByEmailAndUsername(String email, String username) {
        return userMapper.findUserByEmailAndUsername(username,email);
    }

    @Override
    public User findUserByUsername(String username) {
        return userMapper.findUserByUsername(username);
    }

    @Override
    public int updateUser(User user) {
        //MD5加密加盐
        String password = Md5Crypt.apr1Crypt(user.getPassword().getBytes(), user.getUsername());
        user.setPassword(password);
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public User findUserByUsernameAndPwd(String username, String password) {
        String MD5Password = Md5Crypt.apr1Crypt(password.getBytes(), username);
        return userMapper.findUserByUsernameAndPwd(username,MD5Password);
    }

    @Override
    public User findUserById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
