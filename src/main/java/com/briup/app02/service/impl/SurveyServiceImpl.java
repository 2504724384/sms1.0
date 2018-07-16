package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app02.bean.Survey;
import com.briup.app02.dao.SurveyMapper;
import com.briup.app02.service.ISurveyService;

@Service
public class SurveyServiceImpl implements ISurveyService{
	@Autowired
	private SurveyMapper surveyMapper;
	

	@Override
	public List<Survey> findAll() throws Exception {
		//调用studnetMapper查询所有学生
		List<Survey> list = surveyMapper.findAll();
		return list;
	}


	@Override
	public Survey findById(long id) throws Exception{
		//通过id查询某个学生
		return surveyMapper.findById(id);
	}
	
	@Override
	public void save(Survey survey) throws Exception{
		//插入学生信息
		surveyMapper.save(survey);
	}
	
	
	@Override
	public void update(Survey survey) throws Exception{
		//修改学生信息
		surveyMapper.update(survey);
	}

	@Override
	public void deleteById(long id) throws Exception {
		//1. 通过id查找
		Survey survey = surveyMapper.findById(id);
		//2. 如果该学生存在，执行删除操作，如果该学生不存在，抛出异常
		if(survey!=null){
			surveyMapper.deleteById(id);
		} else {
			throw new Exception("要删除的答卷 不存在");
		}
	}
}


