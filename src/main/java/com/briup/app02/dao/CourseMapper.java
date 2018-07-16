package com.briup.app02.dao;

import java.util.List;

import com.briup.app02.bean.Course;

public interface CourseMapper {
	//查询所有学校信息
	List<Course> findAll();
				
	//通过id查询学校信息
	Course findById(long id);
			
	//保存学校信息
	void save(Course course);
				
	//修改学校信息
	void update(Course course);
				
	//删除学校信息
	void deleteById(long id);
}
