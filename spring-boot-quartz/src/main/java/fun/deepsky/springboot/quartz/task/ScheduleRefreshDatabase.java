package fun.deepsky.springboot.quartz.task;

import javax.annotation.Resource;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import fun.deepsky.springboot.quartz.repository.ConfigRepository;

/**
 * 定时查库
 * @author deepsky
 *
 */
@EnableScheduling
@Configuration
@Component
public class ScheduleRefreshDatabase {

	@Autowired
	private ConfigRepository configRepository;
	
	@Resource(name="jobDetail")
	private JobDetail jobDetail;
	
	@Resource(name="jobTrigger")
	private CronTrigger cronTrigger;
	
	@Resource(name = "scheduler")  
    private Scheduler scheduler;
	
	@Scheduled(fixedRate=10000)
	public void scheduleUpdateCronTrigger() throws SchedulerException {
		//从调度工厂中获取触发器
		CronTrigger trigger = (CronTrigger) scheduler.getTrigger(cronTrigger.getKey());
		String currentCron = trigger.getCronExpression();
		String dbCron = configRepository.findOne(1L).getCron();
		if(currentCron.equals(dbCron)) {
			//不处理
		}else {
			CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(dbCron);
			trigger = trigger.getTriggerBuilder().withIdentity(cronTrigger.getKey())  
                    .withSchedule(scheduleBuilder).build();  
			scheduler.rescheduleJob(cronTrigger.getKey(), trigger);
			currentCron = dbCron;
		}
	}
}
