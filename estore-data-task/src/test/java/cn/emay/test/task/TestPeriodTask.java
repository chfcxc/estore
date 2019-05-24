package cn.emay.test.task;

import java.util.Map;

import org.apache.log4j.Logger;

import cn.emay.task.core.common.TaskResult;
import cn.emay.task.core.define.PeriodTask;

public class TestPeriodTask implements PeriodTask {

	Logger log = Logger.getLogger(getClass());

	@Override
	public TaskResult exec(Map<String, String> initParams) {
		log.info(Thread.currentThread().getName() + (initParams.get("url") == null ? "do" : initParams.get("url")));
		return TaskResult.doBusinessSuccessResult();
	}

	@Override
	public long period() {
		return 1000l;
	}

}