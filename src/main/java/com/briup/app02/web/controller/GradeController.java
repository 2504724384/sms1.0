package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.Grade;
import com.briup.app02.service.IGradeService;
import com.briup.app02.util.MsgResponse;

@RestController
@RequestMapping("/grade")
public class GradeController {
	//注入studentService的实例
		@Autowired
		private IGradeService gradeService;
		
		@PostMapping("saveGrade")
		public MsgResponse saveStudent(Grade grade){
			try {
				gradeService.save(grade);
				return MsgResponse.success("添加学生信息成功！", null);
			} catch (Exception e) {
				e.printStackTrace();
				return MsgResponse.error(e.getMessage());
			}
		}
		
		
		@PostMapping("updateGrade")
		public MsgResponse updateGrade(Grade grade){
			try {
				gradeService.update(grade);
				return MsgResponse.success("修改成功！", null);
			} catch (Exception e) {
				e.printStackTrace();
				return MsgResponse.error(e.getMessage());
			}
			
		}	
		
		@GetMapping("deleteGradeById")
		public MsgResponse deleteGradeById(long id){
			try {
				// 调用service层代码删除学生信息
				gradeService.deleteById(id);
				// 如果删除成功返回成功信息
				return MsgResponse.success("删除成功！", null);
			} catch (Exception e) {
				// 先打印错误信息，让后台开发者知道问题所在；返回错误信息，让前端开发者知道错误所在
				e.printStackTrace();
				return MsgResponse.error(e.getMessage());
			}
		}
		
		//http://127.0.0.1:8080/student/findAllStudent
		@GetMapping("findAllGrade")
		public List<Grade> findAllStudent(){
			
			try {
				List<Grade> list = gradeService.findAll();
				return list;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}
		@GetMapping("findGradeById")
		public Grade findGradeById(long id){
			try {
				Grade grade = gradeService.findById(id);
				return grade;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
}
