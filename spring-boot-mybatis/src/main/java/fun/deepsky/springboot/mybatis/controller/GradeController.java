package fun.deepsky.springboot.mybatis.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fun.deepsky.springboot.mybatis.bean.FileLog;
import fun.deepsky.springboot.mybatis.bean.Grade;
import fun.deepsky.springboot.mybatis.service.FileLogService;
import fun.deepsky.springboot.mybatis.service.GradeService;

@RestController
@RequestMapping("/test")
public class GradeController {

	@Autowired
	private GradeService gradeService;
	
	@Autowired
	private FileLogService fileLogService;
	
	@RequestMapping(value="/getName",method=RequestMethod.GET)
	public List<Grade> getByGradeName(@RequestParam("name") String name){
		return gradeService.getByGradeNm(name);
	}
	
	@RequestMapping(value="/add")
	public String add() {
		Grade grade = new Grade();
		grade.setGradeName("测试5");
		grade.setTeacherId(16);
		gradeService.save(grade);
		return "success";
	}
	
	@RequestMapping(value="/addlog")
	public String addlog() {
		LineIterator it = null;
		try {
			File file = new File("C:\\Users\\deepsky\\Documents\\我接收到的文件\\重庆mobile日志\\重庆mobile日志\\7002mobileMessage_2018-03-21.log.filter");
			it = FileUtils.lineIterator(file);
			while (it.hasNext()) {
				String line = it.nextLine();
				if (line.contains("<request_type>01010052</request_type>")) {
					System.out.println(line.substring(1, 20));
					Date time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(line.substring(1, 20));
					int index_ = line.indexOf("ExecuteThread");
					String threadid = line.substring(index_+16,index_+17);
					int index_content = line.indexOf("<request_type>01010052</request_type>");
					String content = line.substring(index_content);
					FileLog log = new FileLog();
					log.setNode("7002");
					log.setDate(time);
					log.setExecuteThreadId(Integer.parseInt(threadid));
					log.setContent(content);
					System.out.println(time+"===="+threadid+"===="+content);
					fileLogService.save(log);
				}
				// System.out.println(line);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			LineIterator.closeQuietly(it);
		}
		return "success";
	}
	
	@RequestMapping(value="/getAll",method=RequestMethod.GET)
	public List<Grade> getAll(@RequestParam("num") int pageNum,@RequestParam("size") int pageSize) {
		try {
			return gradeService.getAll(pageNum, pageSize);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value="/testTrans",method=RequestMethod.GET)
	public String delete() {
		try {
		 gradeService.deleteAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}
	
}
