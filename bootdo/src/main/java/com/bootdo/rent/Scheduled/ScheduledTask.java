package com.bootdo.rent.Scheduled;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.bootdo.rent.domain.ContractDO;
import com.bootdo.rent.service.ContractService;

// 计时器，每天执行一次，校验合同期限和当前系统时间的关系，并修改合同的状态。
@Component
public class ScheduledTask {
	@Autowired
	private ContractService contractService;

	@Scheduled(fixedRate = 1000 * 60 * 60 * 24, initialDelay = 10000)
	public void scheduledTask() {
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");// 可以方便地修改日期格式
		String today = dateFormat.format(now);
		List<ContractDO> contractList = contractService.contractList();
		System.out.println(contractList.toString());
		for (ContractDO contract : contractList) {
			String startDate = contract.getStartTime();
			String stopDate = contract.getStopTime();
			Map<String, Object> map = new HashMap<>();
			if (today.compareTo(startDate) < 0) {
				map.put("contractStatus", "新增");
			}
			if (today.compareTo(stopDate) > 0) {
				map.put("contractStatus", "合同到期");
			}
			if (today.compareTo(startDate) > 0 && today.compareTo(stopDate) < 0) {
				map.put("contractStatus", "在用");
			}
			map.put("contractId", contract.getContractId());
			if (contractService.updateStatus(map) < 0) {
				System.out.println("updateStatus ERROR!!!");
			}
		}
	}
}
