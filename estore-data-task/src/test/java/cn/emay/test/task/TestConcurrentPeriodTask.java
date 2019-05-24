package cn.emay.test.task;

import java.util.Map;

import org.apache.log4j.Logger;

import cn.emay.task.core.common.TaskResult;
import cn.emay.task.core.define.ConcurrentPeriodTask;

public class TestConcurrentPeriodTask implements ConcurrentPeriodTask {

	Logger log = Logger.getLogger(getClass());
	
	boolean isAdd = true;


	@Override
	public TaskResult exec(Map<String, String> initParams) {
		log.info(Thread.currentThread().getName() + " do");
		return TaskResult.doBusinessSuccessResult();
	}

	@Override
	public int needConcurrent(int alive, int min, int max) {
		if(alive == 8){
			isAdd = false;
		}
		if(alive == 1){
			isAdd = true;
		}
		int av = 0;
		if(isAdd){
			av = alive + 1;
		}else{
			av = alive - 1;
		}
		log.info("alive = " + alive + ", isAdd =  " + isAdd + ", av = " + av);
		return av;
	}

	@Override
	public long period() {
		return 1000l;
	}

}