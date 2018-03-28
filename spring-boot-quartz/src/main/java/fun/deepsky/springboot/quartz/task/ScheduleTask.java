package fun.deepsky.springboot.quartz.task;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

@Component
@Configuration
@EnableScheduling
public class ScheduleTask {
	
	public void sayHello() {
		System.out.println("Hello Now Time:"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
	}

	 
}
