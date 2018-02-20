package com.bootdo.rent.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.velocity.app.event.ReferenceInsertionEventHandler.referenceInsertExecutor;
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
import com.bootdo.rent.vo.ContractVO;

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
    
    private String prefix="rent/contract";
    
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
    	if(params.get("houseNumber")!=null&&params.get("houseNumber")!=""){
    		map.put("houseNumber", params.get("houseNumber").toString());
    	}
    	if(params.get("address")!=null&&params.get("address")!=""){
    		map.put("address", params.get("address").toString());
    	}
    	if(params.get("number")!=null&&params.get("number")!=""){
    		map.put("number", params.get("number").toString());
    	}
    	if(params.get("contractNumber")!=null&&params.get("contractNumber")!=""){
    		map.put("contractNumber", params.get("contractNumber").toString());
    	}
    	List<ContractDO> contractList = contractService.list(map);
        int total = contractService.count();
        PageUtils pageUtil = new PageUtils(contractList, total);
  		return pageUtil;
    }
    
    @Log("编辑合同")
    @GetMapping("/detail/{contractNumber}")
    String  detail(Model model, @PathVariable("contractNumber")String contractNumber) {
    	ContractVO contract = contractService.detail(contractNumber);
    	model.addAttribute("contract", contract);
  		return prefix+"/contractDetail";
    }
    
    @PostMapping("/exit")
	@ResponseBody
	boolean exit(@RequestParam Map<String, Object> params) {
    	String contractNumber = params.get("contractNumber").toString();
		// 存在，不通过，false
		if(contractService.get(contractNumber)==null){
			return true;
		}else{
			return false;
		}
	}
    
   	@PostMapping("/save")
   	@ResponseBody
   	R save(ContractVO contract) {
   		if(contractService.getByContractNumber(contract.getContractNumber())!=null){
   			return R.error("该合同已存在");
   		}
   		Long houseId = Long.parseLong(contract.getHouseId().toString());
    	Long customerId = Long.parseLong(contract.getCustomerId().toString());
    	Map<String, Object> map = new HashMap<>();
    	map.put("houseId", houseId);
    	map.put("customerId", customerId);
    	HouseContractCustomerDO houseContractCustomerDO =new HouseContractCustomerDO();
		houseContractCustomerDO.setContractNumber(contract.getContractNumber());
		houseContractCustomerDO.setCustomerId(contract.getCustomerId());
		houseContractCustomerDO.setHouseId(contract.getHouseId());
		houseContractCustomerDO.setNumber(contract.getNumber());
		if(houseContractCustomerService.selectNumber(map)!=null){
			HouseContractCustomerDO houseContractCustomerDO2 = houseContractCustomerService.selectNumber(map);
    		if(houseContractCustomerDO2.getContractNumber()!=null&&!houseContractCustomerDO2.getContractNumber().equals("")){
    			if(!houseContractCustomerDO2.getContractNumber().equals(contract.getContractNumber())){
    				return R.error("业务号重复,请重新选择");
    			}
    		}else{
    			houseContractCustomerDO.setHouseContractCustomerId(houseContractCustomerDO2.getHouseContractCustomerId());
    			houseContractCustomerService.update(houseContractCustomerDO);
    		}
		}else{
			if(houseContractCustomerService.getNumber(contract.getNumber())!=null){
				return R.error("业务号重复,请重新输入业务号");
			}
    		houseContractCustomerService.save(houseContractCustomerDO);
    	}
   		Date now = new Date(); 
   		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");//可以方便地修改日期格式
   		contract.setCreateTime(dateFormat.format(now));
   		System.out.println(contract.getCreateTime());
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
    	HouseContractCustomerDO houseContractCustomerDO =new HouseContractCustomerDO();
		houseContractCustomerDO.setContractNumber(contract.getContractNumber());
		houseContractCustomerDO.setCustomerId(contract.getCustomerId());
		houseContractCustomerDO.setHouseId(contract.getHouseId());
		houseContractCustomerDO.setNumber(contract.getNumber());
    	if(houseContractCustomerService.selectNumber(map)!=null){
    		HouseContractCustomerDO houseContractCustomerDO2 = houseContractCustomerService.selectNumber(map);
    		if(houseContractCustomerDO2.getContractNumber()!=null&&!houseContractCustomerDO2.getContractNumber().equals("")){
    			if(!houseContractCustomerDO2.getContractNumber().equals(contract.getContractNumber())){
    				return R.error("业务号重复,请重新选择");
    			}
    		}
    		houseContractCustomerDO.setHouseContractCustomerId(houseContractCustomerDO2.getHouseContractCustomerId());
        	HouseContractCustomerDO houseContractCustomerDO3 = houseContractCustomerService.selectByContractNumber(contract.getContractNumber());
            houseContractCustomerDO3.setContractNumber("");
            houseContractCustomerService.update(houseContractCustomerDO3);
    		houseContractCustomerService.update(houseContractCustomerDO);
    	}else{
    		HouseContractCustomerDO houseContractCustomerDO3 = houseContractCustomerService.selectByContractNumber(contract.getContractNumber());
        	houseContractCustomerDO3.setContractNumber("");
        	houseContractCustomerService.update(houseContractCustomerDO3);
    		if(houseContractCustomerService.getNumber(contract.getNumber())!=null){
				return R.error("业务号重复,请重新输入业务号");
			}
    		houseContractCustomerService.save(houseContractCustomerDO);
    	}
		if (contractService.update(contract) > 0) {
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
    		if(houseContractCustomerService.selectByContractNumber(contractNumber)!=null){
    			HouseContractCustomerDO houseContractCustomerDO = houseContractCustomerService.selectByContractNumber(contractNumber);
            	houseContractCustomerDO.setContractNumber("");
            	houseContractCustomerService.update(houseContractCustomerDO);
    		}
    		int r = contractService.remove(id);
    		if(r<0){
    			return R.error();
    		}
		}	
		return R.ok();
	}
 
}