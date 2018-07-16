package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.Clazz;
import com.briup.app02.service.IClazzService;
import com.briup.app02.util.MsgResponse;

@RestController
@RequestMapping("/clazz")
public class ClazzController {
	//注入studentService的实例
		@Autowired
		private IClazzService clazzService;
		
		@PostMapping("saveClazz")
		public MsgResponse saveClazz(Clazz clazz){
			try {
				clazzService.save(clazz);
				return MsgResponse.success("添加学生信息成功！", null);
			} catch (Exception e) {
				e.printStackTrace();
				return MsgResponse.error(e.getMessage());
			}
		}
		
		
		@PostMapping("updateClazz")
		public MsgResponse updateClazz(Clazz clazz){
			try {
				clazzService.update(clazz);
				return MsgResponse.success("修改成功！", null);
			} catch (Exception e) {
				e.printStackTrace();
				return MsgResponse.error(e.getMessage());
			}
			
		}	
		
		@GetMapping("deleteClazzById")
		public MsgResponse deleteClazzById(long id){
			try {
				// 调用service层代码删除学生信息
				clazzService.deleteById(id);
				// 如果删除成功返回成功信息
				return MsgResponse.success("删除成功！", null);
			} catch (Exception e) {
				// 先打印错误信息，让后台开发者知道问题所在；返回错误信息，让前端开发者知道错误所在
				e.printStackTrace();
				return MsgResponse.error(e.getMessage());
			}
		}
		
		//http://127.0.0.1:8080/student/findAllClazz
		@GetMapping("findAllClazz")
		public List<Clazz> findAllClazz(){
			
			try {
				List<Clazz> list = clazzService.findAll();
				return list;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}
		@GetMapping("findClazzById")
		public Clazz findClazzById(long id){
			try {
				Clazz clazz = clazzService.findById(id);
				return clazz;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
}
