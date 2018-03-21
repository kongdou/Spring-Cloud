package fun.deepsky.springboot.batch;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class CsvJobListener implements JobExecutionListener {

	long startTime;
	long endTime;

	@Override
	public void afterJob(JobExecution arg0) {
		// TODO Auto-generated method stub
		endTime = System.currentTimeMillis();
		System.out.println("任务结束，耗时：" + (endTime - startTime) + " ms");
	}

	@Override
	public void beforeJob(JobExecution arg0) {
		// TODO Auto-generated method stub
		startTime = System.currentTimeMillis();
		System.out.println("任务开始");
	}

}
