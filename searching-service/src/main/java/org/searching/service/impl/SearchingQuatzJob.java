package org.searching.service.impl;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.searching.util.DateUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SearchingQuatzJob implements Job{

	@Override
	public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
		log.info(" =====> SearchingQuatzJob "+DateUtil.dateFmtToString(new Date())+"任务启动");
		try {
			JobKey key = jobExecutionContext.getJobDetail().getKey();
		    JobDataMap dataMap = jobExecutionContext.getJobDetail().getJobDataMap();
		    log.info("定时任务key : " + key);
		    log.info("定时任务key : " + key);
			ScheduledService.searching(dataMap);
		} catch (Exception e) {
			log.error(" =====> SearchingQuatzJob"+DateUtil.dateFmtToString(new Date())+" 任务开始失败");
			log.error(e.toString());
		}
		log.info(" =====> SearchingQuatzJob"+DateUtil.dateFmtToString(new Date())+" 任务开始运行");
	}

}
