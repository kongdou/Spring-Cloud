package fun.deepsky.springboot.mybatis.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;

import fun.deepsky.springboot.mybatis.bean.Grade;
import fun.deepsky.springboot.mybatis.mapper.GradeMapper;

@Service
public class GradeService{
	
	@Autowired
	private GradeMapper gradeMapper;
	
	public List<Grade> getByGradeNm(String name){
        return gradeMapper.getByGradeNm(name);
    }
	
	//@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void save(Grade grade){
        gradeMapper.save(grade);
    }
	
	public List<Grade> getAll(int pageNum,int pageSize)throws Exception{
		PageHelper.startPage(pageNum,pageSize);
		return gradeMapper.getAll();
	}
	
	//@Transactional
	public void deleteAll() {
		//删除
		Grade grade = new Grade();
		grade.setGradeName("测试440");
		grade.setTeacherId(1000);
		this.save(grade);
		//gradeMapper.deleteAll();
		//throw new RuntimeException("事务测试");
	}
}
