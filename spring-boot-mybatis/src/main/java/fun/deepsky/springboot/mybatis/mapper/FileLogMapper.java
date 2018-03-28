package fun.deepsky.springboot.mybatis.mapper;


import org.apache.ibatis.annotations.Insert;

import fun.deepsky.springboot.mybatis.bean.FileLog;

public interface FileLogMapper {

	@Insert("insert into filelog(node,date,ExecuteThreadId,content) values(#{node},#{date},#{ExecuteThreadId},#{content})")
	public void save(FileLog fileLog);
}
