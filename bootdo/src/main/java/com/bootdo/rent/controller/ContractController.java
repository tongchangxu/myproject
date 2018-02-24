package com.bootdo.rent.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootdo.common.annotation.Log;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.R;
import com.bootdo.rent.domain.ContractDO;
import com.bootdo.rent.domain.HouseContractCustomerDO;
import com.bootdo.rent.service.ContractService;
import com.bootdo.rent.service.HouseContractCustomerService;
import com.bootdo.rent.service.ReceivableService;
import com.bootdo.rent.vo.ContractVO;
import com.bootdo.rent.vo.HouseContractCustomerVO;

/**
 * 
 * @author lzh
 *
 */

@Controller
@RequestMapping("/rent/contract")
public class ContractController {
	@Autowired
	private ContractService contractService;
	@Autowired
	private HouseContractCustomerService houseContractCustomerService;
	@Autowired
	private ReceivableService receivableService;

	private String prefix = "rent/contract";

	@GetMapping("")
	String contract(Model model) {
		return prefix + "/contract";
	}

	@GetMapping("/add")
	String add(Model model) {
		return prefix + "/add";
	}

	@ResponseBody
	@GetMapping("/list")
	public PageUtils list(@RequestParam Map<String, Object> params) {
		Integer offset = Integer.parseInt(params.get("offset").toString());
		Integer limit = Integer.parseInt(params.get("limit").toString());
		Map<String, Object> map = new HashMap<>();
		map.put("limit", limit);
		map.put("offset", offset);
		if (params.get("houseNumber") != null && params.get("houseNumber") != "") {
			map.put("houseNumber", params.get("houseNumber").toString());
		}
		if (params.get("address") != null && params.get("address") != "") {
			map.put("address", params.get("address").toString());
		}
		if (params.get("number") != null && params.get("number") != "") {
			map.put("number", params.get("number").toString());
		}
		if (params.get("contractNumber") != null && params.get("contractNumber") != "") {
			map.put("contractNumber", params.get("contractNumber").toString());
		}
		List<ContractDO> contractList = contractService.list(map);
		int total = contractService.count();
		PageUtils pageUtil = new PageUtils(contractList, total);
		return pageUtil;
	}

	@Log("编辑合同")
	@GetMapping("/detail/{contractNumber}")
	String detail(Model model, @PathVariable("contractNumber") String contractNumber) {
		ContractVO contract = contractService.detail(contractNumber);
		HouseContractCustomerVO houseContractCustomerVO = houseContractCustomerService.getDetail(contract.getNumber());
		model.addAttribute("contract", contract);
		model.addAttribute("houseCustomer", houseContractCustomerVO);
		return prefix + "/contractDetail";
	}

	@PostMapping("/exit")
	@ResponseBody
	boolean exit(@RequestParam Map<String, Object> params) {
		String contractNumber = params.get("contractNumber").toString();
		// 存在，不通过，false
		if (contractService.get(contractNumber) == null) {
			return true;
		} else {
			return false;
		}
	}

	@PostMapping("/save")
	@ResponseBody
	R save(ContractVO contract) {
		if (contractService.getByContractNumber(contract.getContractNumber()) != null) {
			return R.error("该合同已存在");
		}
		Long houseId = Long.parseLong(contract.getHouseId().toString());
		Long customerId = Long.parseLong(contract.getCustomerId().toString());
		Map<String, Object> map = new HashMap<>();
		map.put("houseId", houseId);
		map.put("customerId", customerId);
		HouseContractCustomerDO houseContractCustomerDO = new HouseContractCustomerDO();
		houseContractCustomerDO.setContractNumber(contract.getContractNumber());
		houseContractCustomerDO.setCustomerId(contract.getCustomerId());
		houseContractCustomerDO.setHouseId(contract.getHouseId());
		houseContractCustomerDO.setNumber(contract.getNumber());
		//对所选择的客户和房屋信息与业务号之间的关系进行判断和修改
		if (houseContractCustomerService.selectNumber(map) != null) {
			HouseContractCustomerDO houseContractCustomerDO2 = houseContractCustomerService.selectNumber(map);
			if (houseContractCustomerDO2.getContractNumber() != null
					&& !houseContractCustomerDO2.getContractNumber().equals("")) {
				if (!houseContractCustomerDO2.getContractNumber().equals(contract.getContractNumber())) {
					return R.error("业务号重复,请重新选择");
				}
			} else {
				houseContractCustomerDO
						.setHouseContractCustomerId(houseContractCustomerDO2.getHouseContractCustomerId());
				houseContractCustomerService.update(houseContractCustomerDO);
			}
		} else {
			if (houseContractCustomerService.getNumber(contract.getNumber()) != null) {
				return R.error("业务号重复,请重新输入业务号");
			}
			houseContractCustomerService.save(houseContractCustomerDO);
		}
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 可以方便地修改日期格式
		contract.setCreateTime(dateFormat.format(now));
		//新建合同
		if (contractService.save(contract) > 0) {
			return R.ok();
		}
		return R.error();
	}

	@PostMapping("/update")
	@ResponseBody
	R update(ContractVO contract) {
		Long houseId = Long.parseLong(contract.getHouseId().toString());
		Long customerId = Long.parseLong(contract.getCustomerId().toString());
		Map<String, Object> map = new HashMap<>();
		map.put("houseId", houseId);
		map.put("customerId", customerId);
		HouseContractCustomerDO houseContractCustomerDO = new HouseContractCustomerDO();
		houseContractCustomerDO.setContractNumber(contract.getContractNumber());
		houseContractCustomerDO.setCustomerId(contract.getCustomerId());
		houseContractCustomerDO.setHouseId(contract.getHouseId());
		houseContractCustomerDO.setNumber(contract.getNumber());
		//对所选择的客户和房屋信息与业务号之间的关系进行判断和修改
		if (houseContractCustomerService.selectNumber(map) != null) {
			HouseContractCustomerDO houseContractCustomerDO2 = houseContractCustomerService.selectNumber(map);
			if (houseContractCustomerDO2.getContractNumber() != null
					&& !houseContractCustomerDO2.getContractNumber().equals("")) {
				if (!houseContractCustomerDO2.getContractNumber().equals(contract.getContractNumber())) {
					return R.error("业务号重复,请重新选择");
				}
			}
			houseContractCustomerDO.setHouseContractCustomerId(houseContractCustomerDO2.getHouseContractCustomerId());
			if (houseContractCustomerService.selectByContractNumber(contract.getContractNumber()) != null) {
				HouseContractCustomerDO houseContractCustomerDO3 = houseContractCustomerService
						.selectByContractNumber(contract.getContractNumber());
				houseContractCustomerDO3.setContractNumber("");
				houseContractCustomerService.update(houseContractCustomerDO3);
			}
			houseContractCustomerService.update(houseContractCustomerDO);
		} else {
			if (houseContractCustomerService.selectByContractNumber(contract.getContractNumber()) != null) {
				HouseContractCustomerDO houseContractCustomerDO3 = houseContractCustomerService
						.selectByContractNumber(contract.getContractNumber());
				houseContractCustomerDO3.setContractNumber("");
				houseContractCustomerService.update(houseContractCustomerDO3);
			}
			if (houseContractCustomerService.getNumber(contract.getNumber()) != null) {
				return R.error("业务号重复,请重新输入业务号");
			}
			houseContractCustomerService.save(houseContractCustomerDO);
		}
		//在执行更新操作前，执行下列代码将修改前数据插入到合同修改记录表
		ContractDO contractHandle = contractService.getId(contract.getContractId());
		contractHandle.setHandle("修改");
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 可以方便地修改日期格式
		contractHandle.setHandleTime(dateFormat.format(now));
		contractService.updateHandle(contractHandle);
		//更新合同信息
		if (contractService.update(contract) > 0) {
			// 判断合同状态，如果合同状态被修改为退租、合同到期、终止协议其中一种，就执行下列代码删除关联表中对应业务号下的合同id。
			if (contract.getContractStatus().equals("退租") || contract.getContractStatus().equals("合同到期")
					|| contract.getContractStatus().equals("终止协议")) {
				HouseContractCustomerDO houseContractCustomerDO3 = houseContractCustomerService
						.selectByContractNumber(contract.getContractNumber());
				houseContractCustomerDO3.setContractNumber("");
				houseContractCustomerService.update(houseContractCustomerDO3);
			}
			// 当业务号被修改时，执行下列代码修改应收记录表里对应合同id的业务号。
			Map<String, Object> receivable = new HashMap<>();
			receivable.put("number", contract.getNumber());
			receivable.put("contractId", contract.getContractId());
			receivableService.update(receivable);
			return R.ok();
		}
		return R.error();
	}

	@Log("批量删除合同")
	@PostMapping("/batchRemove")
	@ResponseBody
	R batchRemove(@RequestParam("ids[]") Long[] ids) {
		for (Long id : ids) {
			String contractNumber = contractService.getId(id).getContractNumber();
			if (houseContractCustomerService.selectByContractNumber(contractNumber) != null) {
				HouseContractCustomerDO houseContractCustomerDO = houseContractCustomerService
						.selectByContractNumber(contractNumber);
				houseContractCustomerDO.setContractNumber("");
				houseContractCustomerService.update(houseContractCustomerDO);
			}
			//在执行删除操作前，执行下列代码将修改前数据插入到合同修改记录表
			ContractDO contractHandle = contractService.getId(id);
			Date now = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 可以方便地修改日期格式
			contractHandle.setHandle("刪除");
			contractHandle.setHandleTime(dateFormat.format(now));
			contractService.updateHandle(contractHandle);
			int r = contractService.remove(id);
			if (r < 0) {
				return R.error();
			}
		}
		return R.ok();
	}
	
	
	@GetMapping("/contractHandle")
	String contractHandle(Model model) {
		return prefix + "/contractHandle";
	}
	//合同操作记录列表
	@ResponseBody
	@GetMapping("/handleList")
	public PageUtils handleList(@RequestParam Map<String, Object> params) {
		Integer offset = Integer.parseInt(params.get("offset").toString());
		Integer limit = Integer.parseInt(params.get("limit").toString());
		Map<String, Object> map = new HashMap<>();
		map.put("limit", limit);
		map.put("offset", offset);
		if (params.get("houseNumber") != null && params.get("houseNumber") != "") {
			map.put("houseNumber", params.get("houseNumber").toString());
		}
		if (params.get("address") != null && params.get("address") != "") {
			map.put("address", params.get("address").toString());
		}
		if (params.get("number") != null && params.get("number") != "") {
			map.put("number", params.get("number").toString());
		}
		if (params.get("contractNumber") != null && params.get("contractNumber") != "") {
			map.put("contractNumber", params.get("contractNumber").toString());
		}
		List<ContractDO> contractList = contractService.handleList(map);
		int total = contractService.countForHandle();
		PageUtils pageUtil = new PageUtils(contractList, total);
		return pageUtil;
	}
}