package fun.deepsky.springboot.schedule.task;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduleTask {

	 private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	 
	 @Scheduled(fixedRate=5000)
	 public void showCurrentTime() {
		 System.out.println("Now Time:"+dateFormat.format(new Date()));
	 }

	 @Scheduled(cron="0/5 * * * * ?")
	 public void showCurrentTimeCron() {
		 System.out.println("Now Time Cron:"+dateFormat.format(new Date()));
	 }

	 @Scheduled(fixedDelay=3000)
	 public void showCurrentTimeDelay() {
		 System.out.println("Now Time Delay:"+dateFormat.format(new Date()));
	 }
	 
}
