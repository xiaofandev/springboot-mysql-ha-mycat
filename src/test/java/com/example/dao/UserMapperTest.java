package com.example.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.dao.entity.User;
import com.example.dao.mapper.UserMapper;

@SpringBootTest
@ActiveProfiles("dev")
public class UserMapperTest {

	@Autowired
	private UserMapper userMapper;
	
	@Test
	public void testInsert() {
		User user = User.builder().name("frank").age(11).email("frank@xx.com").build();
		int count = userMapper.insert(user);
		Assert.assertEquals(1, count);
	}
	
	@Test
	public void testUpdate() {
		String name = "frank";
		Integer age = 11;
		String email = "frank@xx.com";
		User user = User.builder().id(1L).name(name).age(age).email(email).build();
		int count = userMapper.updateById(user);
		Assert.assertEquals(1, count);
		
		User updatedUser = userMapper.selectById(user.getId());
		Assert.assertEquals(name, updatedUser.getName());
		Assert.assertEquals(age, updatedUser.getAge());
		Assert.assertEquals(email, updatedUser.getEmail());
	}
	
	@Test
	public void testDelete() {
		Assert.assertEquals(1, userMapper.deleteById(1L));
	}
	
	@Test
	public void findPage() {
		// 第2页
		int currentPage = 2;
		// 每页大小为3
		int pageSize = 3;
		
		Page<User> page = new Page<>(currentPage, pageSize);
		userMapper.selectPage(page, null);
		// 总数
		Assert.assertEquals(5, page.getTotal());
		List<User> list = page.getRecords();
		// 当前页结果总数
		Assert.assertEquals(2, list.size());
		// 当前页第一条记录的id
		Assert.assertEquals("4", list.get(0).getId().toString());
		Assert.assertEquals("5", list.get(1).getId().toString());
	}
	
}
