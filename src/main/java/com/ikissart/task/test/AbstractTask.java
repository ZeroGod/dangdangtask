package com.ikissart.task.test;

import com.dangdang.ddframe.job.api.JobExecutionMultipleShardingContext;
import com.dangdang.ddframe.job.plugin.job.type.simple.AbstractSimpleElasticJob;

public abstract class AbstractTask extends AbstractSimpleElasticJob{

	protected ThreadLocal<JobExecutionMultipleShardingContext> jobContext = new ThreadLocal<JobExecutionMultipleShardingContext>();

	public void process(JobExecutionMultipleShardingContext shardingContext) {
		
		boolean isRun = true;
		if (isRun) {
			
			long start = System.currentTimeMillis();
			try {
			
				jobContext.set(shardingContext);
			
				this.doExecute();
			} catch (Exception e) {
		
			} finally {
			
				long end = System.currentTimeMillis();

				jobContext.remove();

			}
		}
	}


	public abstract String getTaskName();


	public abstract void doExecute();
}
