package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app02.bean.Course;
import com.briup.app02.dao.CourseMapper;
import com.briup.app02.service.ICourseService;

@Service
public class CourseServiceImpl implements ICourseService{
	@Autowired
	private CourseMapper courseMapper;
	

	@Override
	public List<Course> findAll() throws Exception {
		//调用studnetMapper查询所有学生
		List<Course> list = courseMapper.findAll();
		return list;
	}


	@Override
	public Course findById(long id) throws Exception{
		//通过id查询某个学生
		return courseMapper.findById(id);
	}
	
	@Override
	public void save(Course course) throws Exception{
		//插入学生信息
		courseMapper.save(course);
	}
	
	
	@Override
	public void update(Course course) throws Exception{
		//修改学生信息
		courseMapper.update(course);
	}

	@Override
	public void deleteById(long id) throws Exception {
		//1. 通过id查找
		Course course = courseMapper.findById(id);
		//2. 如果该学生存在，执行删除操作，如果该学生不存在，抛出异常
		if(course!=null){
			courseMapper.deleteById(id);
		} else {
			throw new Exception("要删除的课程不存在");
		}
	}
}
