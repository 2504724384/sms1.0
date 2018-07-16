package com.briup.app02.dao;

import java.util.List;

import com.briup.app02.bean.Clazz;

public interface ClazzMapper {
	//查询所有学校信息
	List<Clazz> findAll();
			
	//通过id查询学校信息
	Clazz findById(long id);
			
	//保存学校信息
	void save(Clazz clazz);
			
	//修改学校信息
	void update(Clazz clazz);
			
	//删除学校信息
	void deleteById(long id);
}
