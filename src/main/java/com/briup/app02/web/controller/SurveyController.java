package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.Survey;
import com.briup.app02.service.ISurveyService;
import com.briup.app02.util.MsgResponse;

@RestController
@RequestMapping("/survey")
public class SurveyController {
	//注入studentService的实例
		@Autowired
		private ISurveyService surveyService;
		
		@PostMapping("saveSurvey")
		public MsgResponse saveSurvey(Survey survey){
			try {
				surveyService.save(survey);
				return MsgResponse.success("添加学生信息成功！", null);
			} catch (Exception e) {
				e.printStackTrace();
				return MsgResponse.error(e.getMessage());
			}
		}
		
		
		@PostMapping("updateSurvey")
		public MsgResponse updateSurvey(Survey survey){
			try {
				surveyService.update(survey);
				return MsgResponse.success("修改成功！", null);
			} catch (Exception e) {
				e.printStackTrace();
				return MsgResponse.error(e.getMessage());
			}
			
		}	
		
		@GetMapping("deleteSurveyById")
		public MsgResponse deleteSurveyById(long id){
			try {
				// 调用service层代码删除学生信息
				surveyService.deleteById(id);
				// 如果删除成功返回成功信息
				return MsgResponse.success("删除成功！", null);
			} catch (Exception e) {
				// 先打印错误信息，让后台开发者知道问题所在；返回错误信息，让前端开发者知道错误所在
				e.printStackTrace();
				return MsgResponse.error(e.getMessage());
			}
		}
		
		//http://127.0.0.1:8080/student/findAllStudent
		@GetMapping("findAllSurvey")
		public List<Survey> findAllSurvey(){
			
			try {
				List<Survey> list = surveyService.findAll();
				return list;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}
		@GetMapping("findSurveyById")
		public Survey findSurveyById(long id){
			try {
				Survey survey = surveyService.findById(id);
				return survey;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
	}
