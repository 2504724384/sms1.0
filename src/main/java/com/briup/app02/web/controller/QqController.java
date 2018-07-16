package com.briup.app02.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app02.bean.Qq;
import com.briup.app02.service.IQqService;
import com.briup.app02.util.MsgResponse;

@RestController
@RequestMapping("/qq")
public class QqController {
	//注入studentService的实例
	@Autowired
	private IQqService qqService;
	
	@PostMapping("saveQq")
	public MsgResponse saveQq(Qq qq){
		try {
			qqService.save(qq);
			return MsgResponse.success("添加学生信息成功！", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	
	@PostMapping("updateQq")
	public MsgResponse updateQq(Qq qq){
		try {
			qqService.update(qq);
			return MsgResponse.success("修改成功！", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
		
	}	
	
	@GetMapping("deleteQqById")
	public MsgResponse deleteQqById(long id){
		try {
			// 调用service层代码删除学生信息
			qqService.deleteById(id);
			// 如果删除成功返回成功信息
			return MsgResponse.success("删除成功！", null);
		} catch (Exception e) {
			// 先打印错误信息，让后台开发者知道问题所在；返回错误信息，让前端开发者知道错误所在
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	
	//http://127.0.0.1:8080/student/findAllStudent
	@GetMapping("findAllQq")
	public List<Qq> findAllQq(){
		
		try {
			List<Qq> list = qqService.findAll();
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	@GetMapping("findQqById")
	public Qq findQqById(long id){
		try {
			Qq qq = qqService.findById(id);
			return qq;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
