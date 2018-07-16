package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app02.bean.School;
import com.briup.app02.dao.SchoolMapper;
import com.briup.app02.service.ISchoolService;


@Service
public class SchoolServiceImpl implements ISchoolService{
	@Autowired
	private SchoolMapper schoolMapper;
	

	@Override
	public List<School> findAll() throws Exception {
		//调用studnetMapper查询所有学生
		List<School> list = schoolMapper.findAll();
		return list;
	}


	@Override
	public School findById(long id) throws Exception{
		//通过id查询某个学生
		return schoolMapper.findById(id);
	}
	
	@Override
	public void save(School school) throws Exception{
		//插入学生信息
		schoolMapper.save(school);
	}
	
	
	@Override
	public void update(School school) throws Exception{
		//修改学生信息
		schoolMapper.update(school);
	}

	@Override
	public void deleteById(long id) throws Exception {
		//1. 通过id查找
		School school = schoolMapper.findById(id);
		//2. 如果该学生存在，执行删除操作，如果该学生不存在，抛出异常
		if(school!=null){
			schoolMapper.deleteById(id);
		} else {
			throw new Exception("要删除的 不存在");
		}
	}
}
