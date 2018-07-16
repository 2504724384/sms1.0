package com.briup.app02.dao;

import java.util.List;

import com.briup.app02.bean.Answer;

public interface AnswerMapper {
	//查询所有学校信息
	List<Answer> findAll();
		
	//通过id查询学校信息
	Answer findById(long id);
			
	//保存学校信息
	void save(Answer answer);
			
	//修改学校信息
	void update(Answer answer);
			
	//删除学校信息
	void deleteById(long id);
}
