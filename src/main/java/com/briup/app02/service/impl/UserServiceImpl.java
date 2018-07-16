package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app02.bean.User;
import com.briup.app02.dao.UserMapper;
import com.briup.app02.service.IUserService;

@Service
public class UserServiceImpl implements IUserService{
	@Autowired
	private UserMapper userMapper;
	

	@Override
	public List<User> findAll() throws Exception {
		//调用studnetMapper查询所有学生
		List<User> list = userMapper.findAll();
		return list;
	}


	@Override
	public User findById(long id) throws Exception{
		//通过id查询某个学生
		return userMapper.findById(id);
	}
	
	@Override
	public void save(User user) throws Exception{
		//插入学生信息
		userMapper.save(user);
	}
	
	
	@Override
	public void update(User user) throws Exception{
		//修改学生信息
		userMapper.update(user);
	}

	@Override
	public void deleteById(long id) throws Exception {
		//1. 通过id查找
		User user = userMapper.findById(id);
		//2. 如果该学生存在，执行删除操作，如果该学生不存在，抛出异常
		if(user!=null){
			userMapper.deleteById(id);
		} else {
			throw new Exception("要删除的用户不存在");
		}
	}
}
