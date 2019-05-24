package cn.emay.test.task;

import java.util.Map;

import org.apache.log4j.Logger;

import cn.emay.task.core.common.TaskResult;
import cn.emay.task.core.define.CronTask;

public class TestCronTask implements CronTask {

	Logger log = Logger.getLogger(getClass());

	@Override
	public TaskResult exec(Map<String, String> initParams) {
		log.info(Thread.currentThread().getName() + " do");
		try {
			Thread.sleep(7000l);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		log.info(Thread.currentThread().getName() + " done");
		return TaskResult.doBusinessSuccessResult();
	}

}