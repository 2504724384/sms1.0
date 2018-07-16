package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.Course;
import com.briup.app02.service.ICourseService;
import com.briup.app02.util.MsgResponse;

@RestController
@RequestMapping("/course")
public class CourseController {
	//注入studentService的实例
		@Autowired
		private ICourseService courseService;
		
		@PostMapping("saveCourse")
		public MsgResponse saveCourse(Course course){
			try {
				courseService.save(course);
				return MsgResponse.success("添加学生信息成功！", null);
			} catch (Exception e) {
				e.printStackTrace();
				return MsgResponse.error(e.getMessage());
			}
		}
		
		
		@PostMapping("updateCourse")
		public MsgResponse updateCourse(Course course){
			try {
				courseService.update(course);
				return MsgResponse.success("修改成功！", null);
			} catch (Exception e) {
				e.printStackTrace();
				return MsgResponse.error(e.getMessage());
			}
			
		}	
		
		@GetMapping("deleteCourseById")
		public MsgResponse deleteCourseById(long id){
			try {
				// 调用service层代码删除学生信息
				courseService.deleteById(id);
				// 如果删除成功返回成功信息
				return MsgResponse.success("删除成功！", null);
			} catch (Exception e) {
				// 先打印错误信息，让后台开发者知道问题所在；返回错误信息，让前端开发者知道错误所在
				e.printStackTrace();
				return MsgResponse.error(e.getMessage());
			}
		}
		
		//http://127.0.0.1:8080/course/findAllCourse
		@GetMapping("findAllCourse")
		public List<Course> findAllCourse(){
			
			try {
				List<Course> list = courseService.findAll();
				return list;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}
		@GetMapping("findCourseById")
		public Course findCourseById(long id){
			try {
				Course course = courseService.findById(id);
				return course;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
}
