package fun.deepsky.springboot.mybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fun.deepsky.springboot.mybatis.bean.FileLog;
import fun.deepsky.springboot.mybatis.mapper.FileLogMapper;

@Service
public class FileLogService {

	@Autowired
	private FileLogMapper fileLogMapper;
	
	public void save(FileLog log){
		fileLogMapper.save(log);
    }
}
