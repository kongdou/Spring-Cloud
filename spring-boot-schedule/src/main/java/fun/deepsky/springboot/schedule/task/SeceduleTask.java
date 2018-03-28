package fun.deepsky.springboot.schedule.task;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SeceduleTask {

	 private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	 
	 @Scheduled(fixedRate=5000)
	 public void showCurrentTime() {
		 System.out.println("Now Time:"+dateFormat.format(new Date()));
	 }

}
