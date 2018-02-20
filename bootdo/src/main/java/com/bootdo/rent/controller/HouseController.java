package com.bootdo.rent.controller;

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
import com.bootdo.rent.domain.CustomerDO;
import com.bootdo.rent.domain.HouseDO;
import com.bootdo.rent.service.HouseService;

/**
 * 
 * @author lzh
 *
 */

@Controller
@RequestMapping("/rent/house")
public class HouseController {
    @Autowired
    private HouseService houseService;
    private String prefix="rent/house";
    
    @GetMapping("")
	String house(Model model) {
		return prefix + "/house";
	}
    @PostMapping("/getId")
	@ResponseBody
	HouseDO getId(@RequestParam Map<String, Object> params) {
    	Long houseId = Long.parseLong(params.get("houseId").toString());
    	return houseService.getId(houseId);
	}
    
    @GetMapping("/selectHouse")
	String selectHouse(Model model) {
		return "rent/contract/selectHouse";
	}
    
    @ResponseBody
    @GetMapping("/list")
    public PageUtils list(@RequestParam Map<String, Object> params) {
    	Integer offset = Integer.parseInt(params.get("offset").toString());
    	Integer limit = Integer.parseInt(params.get("limit").toString());
    	Map<String, Object> map = new HashMap<>();
    	map.put("limit", limit);
    	map.put("offset", offset);
    	if(params.get("houseId")!=null&&params.get("houseId")!=""){
    		map.put("houseId", Integer.parseInt(params.get("houseId").toString()));
    	}
    	if(params.get("houseNumber")!=null&&params.get("houseNumber")!=""){
    		map.put("houseNumber", params.get("houseNumber").toString());
    	}
    	if(params.get("address")!=null&&params.get("address")!=""){
    		map.put("address", params.get("address").toString());
    	}
    	List<HouseDO> houseList = houseService.list(map);
        int total = houseService.count();
        PageUtils pageUtil = new PageUtils(houseList, total);
  		return pageUtil;
    }
   
    @Log("添加房屋")
	@GetMapping("/add")
	String add(Model model) {
		return prefix + "/add";
	}
    
    @PostMapping("/exit")
	@ResponseBody
	boolean exit(@RequestParam Map<String, Object> params) {
    	String name = params.get("name").toString();
		// 存在，不通过，false
		if(houseService.get(name)==null){
			return true;
		}else{
			return false;
		}
	}
    
    @Log("保存房屋")
	@PostMapping("/save")
	@ResponseBody
	R save(HouseDO house) {
    	if(house.getHouseRemark()==null||house.getHouseRemark()==""){
    		house.setHouseRemark("无");
    	}
		if (houseService.save(house) > 0) {
			return R.ok();
		}
		return R.error();
	}
    
    @Log("批量删除用户")
	@PostMapping("/batchRemove")
	@ResponseBody
	R batchRemove(@RequestParam("ids[]") Long[] ids) {
    	for (Long id : ids) {
    		int r = houseService.remove(id);
    		if(r<0){
    			return R.error();
    		}
		}	
		return R.ok();
	}
    
	@Log("编辑用户")
	@GetMapping("/edit/{houseId}")
	String edit(Model model, @PathVariable("houseId") Long houseId) {
		System.out.println("houseId:"+houseId);
		HouseDO houseDO = houseService.getId(houseId);
		model.addAttribute("house", houseDO);
		return prefix+"/edit";
	}
    
	@Log("更新房屋")
	@PostMapping("/update")
	@ResponseBody
	R update(HouseDO house) {
		if (houseService.update(house) > 0) {
			return R.ok();
		}
		return R.error();
	}
	
}