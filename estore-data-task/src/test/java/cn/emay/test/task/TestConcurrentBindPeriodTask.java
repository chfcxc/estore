package cn.emay.test.task;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import cn.emay.task.core.common.TaskResult;
import cn.emay.task.core.define.ConcurrentBindPeriodTask;

public class TestConcurrentBindPeriodTask implements ConcurrentBindPeriodTask {

	Logger log = Logger.getLogger(getClass());
	
	boolean isAdd = false;
	
	private String bind = null;
	
	private static int is = 0;

	@Override
	public TaskResult exec(Map<String, String> initParams) {
		log.info(Thread.currentThread().getName() + " do ---- " + bind);
		return TaskResult.doBusinessSuccessResult();
	}


	@Override
	public long period() {
		return 1000l;
	}


	@Override
	public Map<String, Integer> needConcurrent(Map<String, Integer> aliveBindsNumber, int everyMax) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		String[] binds = {"1","2"};
		if(is >= 5 && is <= 10){
			binds =  new String[]{"1","2","3"};
		}
		if(is >= 11 && is <= 15){
			binds =  new String[]{"2","3"};
		}
		for(String bind : binds){
			Integer alive = aliveBindsNumber.get(bind);
			if(alive == null){
				alive = 0;
			}
			if(alive == 8){
				isAdd = false;
			}
			if(alive == 0){
				isAdd = true;
			}
			int av = 0;
			if(isAdd){
				av = alive + 1;
			}else{
				av = alive - 1;
			}
			log.info(" alive : " + alive + " , need : " + av);
			map.put(bind, av);
		}
		is++;
		return map;
	}

	@Override
	public void setBind(String bind) {
		this.bind = bind;
	}

}