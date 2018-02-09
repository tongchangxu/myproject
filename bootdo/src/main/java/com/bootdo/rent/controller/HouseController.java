package com.bootdo.rent.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootdo.common.utils.PageUtils;
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
	String fruit(Model model) {
		return prefix + "/house";
	}
    
    @ResponseBody
    @GetMapping("/list")
    public PageUtils list(@RequestParam Map<String, Object> params) {
    	String name = params.get("name").toString();
    	Integer offset = Integer.parseInt(params.get("offset").toString());
    	Integer limit = Integer.parseInt(params.get("limit").toString());
    	Map<String, Integer> map = new HashMap<>();
    	map.put("limit", limit);
    	map.put("offset", offset);
    	if(name==null||name==""){
    		List<HouseDO> houseList = houseService.list(map);
            int total = houseService.count();
            PageUtils pageUtil = new PageUtils(houseList, total);
    		return pageUtil;
    	}else{
    		List<HouseDO> houseList = new ArrayList<>();
    		houseList.add(houseService.get(name));
        	int total = 1;
            PageUtils pageUtil = new PageUtils(houseList, total);
    		return pageUtil;
    	}
    }
   
    /*@Log("添加水果")
	@GetMapping("/add")
	String add(Model model) {
		return prefix + "/add";
	}*/
    
    /*@PostMapping("/exit")
	@ResponseBody
	boolean exit(@RequestParam Map<String, Object> params) {
    	String name = params.get("name").toString();
		// 存在，不通过，false
		if(houseService.get(name)!=null){
			return true;
		}else{
			return false;
		}
	}*/
    
    /*@Log("保存水果")
	@PostMapping("/save")
	@ResponseBody
	R save(FruitDO fruit) {
    	DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	fruit.setCreateDate(df.format(new Date()));
    	if(fruit.getRemarks()==null||fruit.getRemarks()==""){
    		fruit.setRemarks("无");
    	}
		if (houseService.save(fruit) > 0) {
			return R.ok();
		}
		return R.error();
	}*/
    
    /*@Log("批量删除用户")
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
	}*/
}
