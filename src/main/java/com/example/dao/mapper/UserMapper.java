package com.example.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.dao.entity.User;

@Mapper
public interface UserMapper {
	
	@Select("select * from user;")
	List<User> findAll();
	
}
