package fun.deepsky.springboot.quartz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling //启用定时
public class ScheduleApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ScheduleApplication.class, args);
	}
}
