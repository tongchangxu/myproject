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
    /*@GetMapping("")
	String houseContractCustomer(Model model) {
		return prefix + "/houseContractCustomer";
	}
    
    @GetMapping("/selectCustomer")
	String selectCustomer(Model model) {
		return "rent/contract/selectCustomer";
	}
    @PostMapping("/getId")
	@ResponseBody
	CustomerDO getId(@RequestParam Map<String, Object> params) {
    	Long customerId = Long.parseLong(params.get("customerId").toString());
    	return customerService.getId(customerId);
	}
    
    @ResponseBody
    @GetMapping("/list")
    public PageUtils list(@RequestParam Map<String, Object> params) {
    	Integer offset = Integer.parseInt(params.get("offset").toString());
    	Integer limit = Integer.parseInt(params.get("limit").toString());
    	Map<String, Object> map = new HashMap<>();
    	map.put("limit", limit);
    	map.put("offset", offset);
    	if(params.get("customerId")!=null&&params.get("customerId")!=""){
    		map.put("customerId", params.get("customerId").toString());
    	}
    	if(params.get("customerName")!=null&&params.get("customerName")!=""){
    		map.put("customerName", params.get("customerName").toString());
    	}
    	
    	List<CustomerDO> customerList = customerService.list(map);
        int total = customerService.count();
        PageUtils pageUtil = new PageUtils(customerList, total);
  		return pageUtil;
    }
   
    @Log("添加客户")
	@GetMapping("/add")
	String add(Model model) {
		return prefix + "/add";
	}
    
    @PostMapping("/exit")
	@ResponseBody
	boolean exit(@RequestParam Map<String, Object> params) {
    	String number = params.get("number").toString();
		// 存在，不通过，false
		if(customerService.get(number)==null){
			return true;
		}else{
			return false;
		}
	}
    
    @Log("保存客户")
	@PostMapping("/save")
	@ResponseBody
	R save(CustomerDO customer) {
		if (customerService.save(customer) > 0) {
			return R.ok();
		}
		return R.error();
	}
    
    @Log("批量删除客户")
	@PostMapping("/batchRemove")
	@ResponseBody
	R batchRemove(@RequestParam("ids[]") Long[] ids) {
    	for (Long id : ids) {
    		int r = customerService.remove(id);
    		if(r<0){
    			return R.error();
    		}
		}	
		return R.ok();
	}
    
	@Log("编辑客户")
	@GetMapping("/edit/{customerId}")
	String edit(Model model, @PathVariable("customerId") Long customerId) {
		System.out.println("customerId:"+customerId);
		CustomerDO customerDO = customerService.getId(customerId);
		model.addAttribute("customer",customerDO);
		return prefix+"/edit";
	}
    
	@Log("更新客户")
	@PostMapping("/update")
	@ResponseBody
	R update(CustomerDO customer) {
		if (customerService.update(customer) > 0) {
			return R.ok();
		}
		return R.error();
	}*/
	
}