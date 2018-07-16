package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.Question;
import com.briup.app02.service.IQuestionService;
import com.briup.app02.util.MsgResponse;

@RestController
@RequestMapping("/question")
public class QuestionController {
	//注入studentService的实例
		@Autowired
		private IQuestionService questionService;
		
		@PostMapping("saveQuestion")
		public MsgResponse saveQuestion(Question question){
			try {
				questionService.save(question);
				return MsgResponse.success("添加学生信息成功！", null);
			} catch (Exception e) {
				e.printStackTrace();
				return MsgResponse.error(e.getMessage());
			}
		}
		
		
		@PostMapping("updateQuestion")
		public MsgResponse updateQuestion(Question question){
			try {
				questionService.update(question);
				return MsgResponse.success("修改成功！", null);
			} catch (Exception e) {
				e.printStackTrace();
				return MsgResponse.error(e.getMessage());
			}
			
		}	
		
		@GetMapping("deleteQuestionById")
		public MsgResponse deleteStudentById(long id){
			try {
				// 调用service层代码删除学生信息
				questionService.deleteById(id);
				// 如果删除成功返回成功信息
				return MsgResponse.success("删除成功！", null);
			} catch (Exception e) {
				// 先打印错误信息，让后台开发者知道问题所在；返回错误信息，让前端开发者知道错误所在
				e.printStackTrace();
				return MsgResponse.error(e.getMessage());
			}
		}
		
		//http://127.0.0.1:8080/question/findAllQuestion
		@GetMapping("findAllQuestion")
		public List<Question> findAllQuestion(){
			
			try {
				List<Question> list = questionService.findAll();
				return list;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}
		@GetMapping("findQuestionById")
		public Question findQuestionById(long id){
			try {
				Question question = questionService.findById(id);
				return question;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
}
