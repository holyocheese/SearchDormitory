package org.searching.service.impl;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SearchingQuatzJob implements Job{

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		log.info(" =====> SearchingQuatzJob 任务启动");
		try {
			ScheduledService.searching();
		} catch (Exception e) {
			log.error(" =====> SearchingQuatzJob 任务开始失败");
			log.error(e.getMessage());
		}
		log.info(" =====> SearchingQuatzJob 任务开始运行");
	}

}
