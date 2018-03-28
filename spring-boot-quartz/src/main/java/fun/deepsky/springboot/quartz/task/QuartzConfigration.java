package fun.deepsky.springboot.quartz.task;

import org.quartz.Trigger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

@Configuration
public class QuartzConfigration {

	@Bean(name = "jobDetail")
	public MethodInvokingJobDetailFactoryBean detailFactoryBean(ScheduleTask task) {
		
		MethodInvokingJobDetailFactoryBean jobDetail = new MethodInvokingJobDetailFactoryBean();
		//是否并发执行，如果并发执行，在执行周期内上一个任务未完成，下个任务会开始执行
		//如果设置为false，下一个任务会等待上一个任务完成
		jobDetail.setConcurrent(false);
		//设置定时任务名字
		jobDetail.setName("log-reins");
		//设置定时任务分组
		jobDetail.setGroup("log");
		//为需要执行的实体类对应的对象
		jobDetail.setTargetObject(task);
		//设置调用方法
		jobDetail.setTargetMethod("sayHello");
		
		return jobDetail;
	}
	
	/**
	 * 配置定时任务的触发器，也就是什么时候触发执行定时任务 
	 * @param jobDetail
	 * @return
	 */
	@Bean(name="jobTrigger")
	public CronTriggerFactoryBean cronJobTrigger(MethodInvokingJobDetailFactoryBean jobDetail) {
		
		CronTriggerFactoryBean trigger = new CronTriggerFactoryBean();
		trigger.setJobDetail(jobDetail.getObject());
		trigger.setCronExpression("0/5 * * * * ?");
		trigger.setName("log-tigger");
		return trigger;
	}
	
	/**
	 * quartz调度工厂
	 * @param cronJobTrigger
	 * @return
	 */
	@Bean(name="scheduler")
	public SchedulerFactoryBean schedulerFactory(Trigger cronJobTrigger){
		SchedulerFactoryBean bean = new SchedulerFactoryBean();
		//用于quartz集群,QuartzScheduler 启动时更新己存在的Job 
		bean.setOverwriteExistingJobs(true);
		//延时1秒启动
		bean.setStartupDelay(1);
		//注册触发器
		bean.setTriggers(cronJobTrigger);
		return bean;
	}
	
}
