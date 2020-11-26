package com.sise.bishe;

import com.sise.bishe.dao.UserMapper;
import com.sise.bishe.entity.User;
import com.sise.bishe.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.ws.Action;
import java.util.List;

@SpringBootTest
class BisheApplicationTests {

	@Autowired
	UserMapper userMapper;

	@Autowired
	UserService userService;

	@Test
	void contextLoads() {

		User mlz = userMapper.findUserByUsernameAndPwd("mlz", "$apr1$mlz$.9DYx7szmYqBJrdepYGC11");
		System.out.println(mlz);
	}

}
