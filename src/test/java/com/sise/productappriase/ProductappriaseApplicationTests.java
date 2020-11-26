package com.sise.productappriase;

import com.sise.productappriase.dao.UserMapper;
import com.sise.productappriase.entity.User;
import com.sise.productappriase.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.ws.Action;
import java.util.List;

@SpringBootTest
class ProductappriaseApplicationTests {

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
