package fun.deepsky.springboot.mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	public void save(Grade grade){
        gradeMapper.save(grade);
    }
	
	public List<Grade> getAll(int pageNum,int pageSize)throws Exception{
		PageHelper.startPage(pageNum,pageSize);
		return gradeMapper.getAll();
	}
}
