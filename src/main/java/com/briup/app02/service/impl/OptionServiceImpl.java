package com.briup.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.app02.bean.Option;
import com.briup.app02.dao.OptionMapper;
import com.briup.app02.service.IOptionService;

@Service
public class OptionServiceImpl implements IOptionService{
	@Autowired
	private OptionMapper optionMapper;
	

	@Override
	public List<Option> findAll() throws Exception {
		//调用studnetMapper查询所有学生
		List<Option> list = optionMapper.findAll();
		return list;
	}


	@Override
	public Option findById(long id) throws Exception{
		//通过id查询某个学生
		return optionMapper.findById(id);
	}
	
	@Override
	public void save(Option option) throws Exception{
		//插入学生信息
		optionMapper.save(option);
	}
	
	
	@Override
	public void update(Option option) throws Exception{
		//修改学生信息
		optionMapper.update(option);
	}

	@Override
	public void deleteById(long id) throws Exception {
		//1. 通过id查找
		Option option = optionMapper.findById(id);
		//2. 如果该学生存在，执行删除操作，如果该学生不存在，抛出异常
		if(option!=null){
			optionMapper.deleteById(id);
		} else {
			throw new Exception("要删除的 不存在");
		}
	}
}
