package fun.deepsky.springboot.mybatis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fun.deepsky.springboot.mybatis.bean.Grade;
import fun.deepsky.springboot.mybatis.service.GradeService;

@RestController
@RequestMapping("/test")
public class GradeController {

	@Autowired
	private GradeService gradeService;
	
	@RequestMapping(value="/getName",method=RequestMethod.GET)
	public List<Grade> getByGradeName(@RequestParam("name") String name){
		return gradeService.getByGradeNm(name);
	}
	
}
