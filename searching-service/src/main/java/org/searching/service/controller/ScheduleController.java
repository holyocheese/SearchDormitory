package org.searching.service.controller;

import org.quartz.SchedulerException;
import org.searching.service.impl.QuartzScheduler;
import org.searching.util.MessageCodeUtil;
import org.searching.util.MsgVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {
	
	@Autowired
	private QuartzScheduler quartzScheduler;

	@RequestMapping(value="/start",method = RequestMethod.POST)
	public MsgVo<String> startSearch(){
		MsgVo<String> msgVo = new MsgVo<String>();
		try {
			quartzScheduler.startJob("");
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
