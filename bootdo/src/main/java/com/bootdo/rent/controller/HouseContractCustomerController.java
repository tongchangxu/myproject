package com.bootdo.rent.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootdo.common.utils.R;
import com.bootdo.rent.domain.HouseContractCustomerDO;
import com.bootdo.rent.service.HouseContractCustomerService;

/**
 * 
 * @author lzh
 *
 */

@Controller
@RequestMapping("/rent/houseContractCustomer")
public class HouseContractCustomerController {
    @Autowired
    private HouseContractCustomerService houseContractCustomerService;
    private String prefix="rent/houseContractCustomer";
    
    @PostMapping("/selectNumber")
	@ResponseBody
	HouseContractCustomerDO selectNumber(@RequestParam Map<String, Object> params) {
    	Long houseId = Long.parseLong(params.get("houseId").toString());
    	Long customerId = Long.parseLong(params.get("customerId").toString());
    	Map<String, Object> map = new HashMap<>();
    	map.put("houseId", houseId);
    	map.put("customerId", customerId);
    	if(houseContractCustomerService.selectNumber(map)!=null){
    		return houseContractCustomerService.selectNumber(map);
    	}else{
    		return null;
    	}
	}
    
    @PostMapping("/getNumber")
	@ResponseBody
	HouseContractCustomerDO getNumber(@RequestParam Map<String, Object> params) {
    	String number = params.get("number").toString();
    	return houseContractCustomerService.getNumber(number);
	}
    
	@PostMapping("/save")
	@ResponseBody
	R save(HouseContractCustomerDO houseContractCustomerDO) {
		if (houseContractCustomerService.save(houseContractCustomerDO) > 0) {
			return R.ok();
		}
		return R.error();
	}
	
	@PostMapping("/update")
	@ResponseBody
	R update(HouseContractCustomerDO houseContractCustomerDO) {
		if (houseContractCustomerService.update(houseContractCustomerDO) > 0) {
			return R.ok();
		}
		return R.error();
	}
	
}