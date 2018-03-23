package fun.deepsky.springboot.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import fun.deepsky.springboot.mybatis.bean.Grade;

public interface GradeMapper {

	@Select("select * from grade where gradename=#{name}")
	public List<Grade> getByGradeNm(String name);
	
	@Insert("insert into grade(gradename,teacherid) values(#{gradeName},#{teacherId})")
	@Options(useGeneratedKeys=true,keyColumn="id",keyProperty="id")
	public void save(Grade grade);
	
	@Select("select * from grade")
	public List<Grade> getAll();
}

