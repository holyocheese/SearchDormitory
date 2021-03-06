package org.searching.service.impl;

import java.util.Date;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.searching.service.entity.CronRequest;
import org.searching.service.entity.SearchOsakaRequest;
import org.searching.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

/**
 * 任务调度处理
 *
 */
@Configuration
public class QuartzScheduler {
    // 任务调度
    @Autowired
    private Scheduler scheduler;

    /**
     * 开始执行所有任务
     * 
     * @throws SchedulerException
     */
    public void startJob(String cron,SearchOsakaRequest searchOsakaRequest) throws SchedulerException {
    	//默认十五分钟
    	if(StringUtils.isEmpty(cron)){
    		cron =  "0 0/15 * * * *";
    	}
        startJob1(scheduler,cron,searchOsakaRequest);
        scheduler.start();
    }

    /**
     * 获取Job信息
     * 
     * @param name
     * @param group
     * @return
     * @throws SchedulerException
     */
    public CronRequest getJobInfo(String name, String group) throws SchedulerException {
        TriggerKey triggerKey = new TriggerKey(name, group);
        CronTrigger cronTrigger = (CronTrigger) scheduler.getTrigger(triggerKey);
        if(cronTrigger!=null){
        	CronRequest cronRequest = new CronRequest();
        	cronRequest.setCron(cronTrigger.getCronExpression());
        	cronRequest.setName(name);
        	cronRequest.setGroup(group);
        	return cronRequest;
        }else{
        	return null;
        }
    }

    /**
     * 修改某个任务的执行时间
     * 
     * @param name
     * @param group
     * @param time
     * @return
     * @throws SchedulerException
     */
    public boolean modifyJob(String name, String group, String cron) throws SchedulerException {
        Date date = null;
        TriggerKey triggerKey = new TriggerKey(name, group);
        CronTrigger cronTrigger = (CronTrigger) scheduler.getTrigger(triggerKey);
        String oldTime = cronTrigger.getCronExpression();
        if (!oldTime.equalsIgnoreCase(cron)) {
            CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(cron);
            CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(name, group)
                    .withSchedule(cronScheduleBuilder).build();
            date = scheduler.rescheduleJob(triggerKey, trigger);
        }
        return date != null;
    }

    /**
     * 暂停所有任务
     * 
     * @throws SchedulerException
     */
    public void pauseAllJob() throws SchedulerException {
        scheduler.pauseAll();
    }

    /**
     * 暂停某个任务
     * 
     * @param name
     * @param group
     * @throws SchedulerException
     */
    public void pauseJob(String name, String group) throws SchedulerException {
        JobKey jobKey = new JobKey(name, group);
        JobDetail jobDetail = scheduler.getJobDetail(jobKey);
        if (jobDetail == null)
            return;
        scheduler.pauseJob(jobKey);
    }

    /**
     * 恢复所有任务
     * 
     * @throws SchedulerException
     */
    public void resumeAllJob() throws SchedulerException {
        scheduler.resumeAll();
    }

    /**
     * 恢复某个任务
     * 
     * @param name
     * @param group
     * @throws SchedulerException
     */
    public void resumeJob(String name, String group) throws SchedulerException {
        JobKey jobKey = new JobKey(name, group);
        JobDetail jobDetail = scheduler.getJobDetail(jobKey);
        if (jobDetail == null)
            return;
        scheduler.resumeJob(jobKey);
    }

    /**
     * 删除某个任务
     * 
     * @param name
     * @param group
     * @throws SchedulerException
     */
    public void deleteJob(String name, String group) throws SchedulerException {
        JobKey jobKey = new JobKey(name, group);
        JobDetail jobDetail = scheduler.getJobDetail(jobKey);
        if (jobDetail == null)
            return;
        scheduler.deleteJob(jobKey);
    }

    private void startJob1(Scheduler scheduler,String cron,SearchOsakaRequest searchOsakaRequest) throws SchedulerException {
        // 通过JobBuilder构建JobDetail实例，JobDetail规定只能是实现Job接口的实例
        // JobDetail 是具体Job实例
        JobDetail jobDetail = JobBuilder.newJob(SearchingQuatzJob.class)
        		.withIdentity("job1", "group1")
        		.usingJobData("start_date", DateUtil.dateFmtToString(searchOsakaRequest.getStartDate(),"yyyy-MM-dd"))
        		.usingJobData("end_date", DateUtil.dateFmtToString(searchOsakaRequest.getEndDate(),"yyyy-MM-dd"))
        		.usingJobData("check_suita", searchOsakaRequest.getCheckSuita())
        		.usingJobData("sex", searchOsakaRequest.getSex())
        		.usingJobData("number_of_people_capacity", searchOsakaRequest.getNumber())
        		.build();
        // 基于表达式构建触发器
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(cron);
        // CronTrigger表达式触发器 继承于Trigger
        // TriggerBuilder 用于构建触发器实例
        CronTrigger cronTrigger = TriggerBuilder.newTrigger()
        		.withIdentity("job1", "group1")
                .withSchedule(cronScheduleBuilder)
                .build();
        scheduler.scheduleJob(jobDetail, cronTrigger);
    }

}