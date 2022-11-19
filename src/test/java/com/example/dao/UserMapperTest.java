package com.example.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.example.dao.entity.User;
import com.example.dao.mapper.UserMapper;

@SpringBootTest
@ActiveProfiles("dev")
public class UserMapperTest {

	@Autowired
	private UserMapper userMapper;
	
	@Test
	public void testSelect() {
		List<User> userList = userMapper.selectList(null);
		Assert.assertEquals(5, userList.size());
	}
	
}
