package org.searching.service.controller;

import org.quartz.ObjectAlreadyExistsException;
import org.quartz.SchedulerException;
import org.searching.service.entity.SearchOsakaRequest;
import org.searching.service.impl.QuartzScheduler;
import org.searching.util.MessageCodeUtil;
import org.searching.util.MsgVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {
	
	@Autowired
	private QuartzScheduler quartzScheduler;

	//启动定时任务
	@RequestMapping(value="/start",method = RequestMethod.POST)
	public MsgVo<String> startSearch(@RequestBody SearchOsakaRequest searchOsakaRequest){
		MsgVo<String> msgVo = new MsgVo<String>();
		try {
			if(!StringUtils.isEmpty(searchOsakaRequest.getCron())){
				quartzScheduler.startJob(searchOsakaRequest.getCron(),searchOsakaRequest);
			}else{
				quartzScheduler.startJob("",searchOsakaRequest);
			}
			msgVo.setMessage(MessageCodeUtil.MESSAGE_OK);
			msgVo.setStatus(MessageCodeUtil.SUCCESS);
		}catch (ObjectAlreadyExistsException e) {
			msgVo.setMessage("已经启动或者启动失败");
			msgVo.setStatus(MessageCodeUtil.SERVER_500);
			e.printStackTrace();
		}catch (SchedulerException e) {
			msgVo.setMessage(MessageCodeUtil.MESSAGE_500);
			msgVo.setStatus(MessageCodeUtil.SERVER_500);
			e.printStackTrace();
		}
		return msgVo;
	}
	
	//获取某个定时任务的详情
	@RequestMapping(value="/quartzInfo",method = RequestMethod.GET)
	public MsgVo<String> quartzInfo(@RequestParam(value="name")String name,@RequestParam(value="group")String group){
		MsgVo<String> msgVo = new MsgVo<String>();
		try {
			msgVo.setData(quartzScheduler.getJobInfo(name, group));
			msgVo.setMessage(MessageCodeUtil.MESSAGE_OK);
			msgVo.setStatus(MessageCodeUtil.SUCCESS);
		} catch (SchedulerException e) {
			msgVo.setMessage(MessageCodeUtil.MESSAGE_500);
			msgVo.setStatus(MessageCodeUtil.SERVER_500);
			e.printStackTrace();
		}
		return msgVo;
	}
}
