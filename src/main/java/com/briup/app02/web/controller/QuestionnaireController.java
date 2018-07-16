package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.Questionnaire;
import com.briup.app02.service.IQuestionnaireService;
import com.briup.app02.util.MsgResponse;

@RestController
@RequestMapping("/questionnaire")
public class QuestionnaireController {
	//注入studentService的实例
	@Autowired
	private IQuestionnaireService questionnaireService;
	
	@PostMapping("saveQuestionnaire")
	public MsgResponse saveQuestionnaire(Questionnaire questionnaire){
		try {
			questionnaireService.save(questionnaire);
			return MsgResponse.success("添加学生信息成功！", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	
	@PostMapping("updateQuestionnaire")
	public MsgResponse updateQuestionnaire(Questionnaire questionnaire){
		try {
			questionnaireService.update(questionnaire);
			return MsgResponse.success("修改成功！", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
		
	}	
	
	@GetMapping("deleteQuestionnaireById")
	public MsgResponse deleteQuestionnaireById(long id){
		try {
			// 调用service层代码删除学生信息
			questionnaireService.deleteById(id);
			// 如果删除成功返回成功信息
			return MsgResponse.success("删除成功！", null);
		} catch (Exception e) {
			// 先打印错误信息，让后台开发者知道问题所在；返回错误信息，让前端开发者知道错误所在
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	//http://127.0.0.1:8080/questionnaire/findAllQuestionnaire
	@GetMapping("findAllQuestionnaire")
	public List<Questionnaire> findAllQuestionnaire(){
		
		try {
			List<Questionnaire> list = questionnaireService.findAll();
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	@GetMapping("findQuestionnaireById")
	public Questionnaire findQuestionnaireById(long id){
		try {
			Questionnaire questionnaire = questionnaireService.findById(id);
			return questionnaire;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
