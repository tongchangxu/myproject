package com.bootdo.test.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootdo.common.annotation.Log;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.R;
import com.bootdo.test.domain.FruitDO;
import com.bootdo.test.service.FruitService;

/**
 * 
 * @author lzh
 *
 */

@Controller
@RequestMapping("/test/fruit")
public class FruitController {
    @Autowired
    private FruitService fruitService;
    private String prefix="test/fruit";
    
    @GetMapping("")
	String fruit(Model model) {
		return prefix + "/fruit";
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
    		List<FruitDO> fruitList = fruitService.list(map);
            int total = fruitService.count();
            PageUtils pageUtil = new PageUtils(fruitList, total);
    		return pageUtil;
    	}else{
    		List<FruitDO> fruitList = new ArrayList<>();
    		fruitList.add(fruitService.get(name));
        	int total = 1;
            PageUtils pageUtil = new PageUtils(fruitList, total);
    		return pageUtil;
    	}
    }
   
    @Log("添加水果")
	@GetMapping("/add")
	String add(Model model) {
		return prefix + "/add";
	}
    
    @PostMapping("/exit")
	@ResponseBody
	boolean exit(@RequestParam Map<String, Object> params) {
    	String name = params.get("name").toString();
		// 存在，不通过，false
		if(fruitService.get(name)!=null){
			return true;
		}else{
			return false;
		}
	}
    
    @Log("保存水果")
	@PostMapping("/save")
	@ResponseBody
	R save(FruitDO fruit) {
    	DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	fruit.setCreateDate(df.format(new Date()));
    	if(fruit.getRemarks()==null||fruit.getRemarks()==""){
    		fruit.setRemarks("无");
    	}
		if (fruitService.save(fruit) > 0) {
			return R.ok();
		}
		return R.error();
	}
    
    @Log("批量删除用户")
	@PostMapping("/batchRemove")
	@ResponseBody
	R batchRemove(@RequestParam("ids[]") Long[] ids) {
    	for (Long id : ids) {
    		int r = fruitService.remove(id);
    		if(r<0){
    			return R.error();
    		}
		}	
		return R.ok();
	}
}
