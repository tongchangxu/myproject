package com.bootdo.rent.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootdo.common.utils.PageUtils;
import com.bootdo.rent.service.ReceivableService;
import com.bootdo.rent.vo.ReceivableVO;

/**
 * 
 * @author lzh
 *
 */

@Controller
@RequestMapping("/rent/receivable")
public class ReceivableController {
    @Autowired
    private ReceivableService receivableService;
    
    private String prefix="rent/receivable";
    
    @GetMapping("")
	String contract(Model model) {
		return prefix + "/receivable";
	}
    
    @GetMapping("/receivableList/{number}")
    String  receivableList(Model model, @PathVariable("number")String number) {
    	model.addAttribute("number", number);
  		return prefix+"/receivableList";
    }
    
    @ResponseBody
    @GetMapping("/list")
    public PageUtils list(@RequestParam Map<String, Object> params) {
    	Integer offset = Integer.parseInt(params.get("offset").toString());
    	Integer limit = Integer.parseInt(params.get("limit").toString());
    	Map<String, Object> map = new HashMap<>();
    	map.put("limit", limit);
    	map.put("offset", offset);
    	if(params.get("year")!=null&&params.get("year")!=""&&params.get("month")!=null&&params.get("month")!=""){
    		String receivableDate = params.get("year")+"年"+params.get("month")+"月";
    		map.put("receivableDate", receivableDate);
    	}
    	List<ReceivableVO> receivableList = receivableService.list(map);
        int total = receivableService.count(map);
        PageUtils pageUtil = new PageUtils(receivableList, total);
  		return pageUtil;
    }
    
    @ResponseBody
    @GetMapping("/list2")
    public PageUtils list2(@RequestParam Map<String, Object> params) {
    	Integer offset = Integer.parseInt(params.get("offset").toString());
    	Integer limit = Integer.parseInt(params.get("limit").toString());
    	Map<String, Object> map = new HashMap<>();
    	map.put("limit", limit);
    	map.put("offset", offset);
    	if(params.get("year1")!=null&&params.get("year1")!=""&&params.get("month1")!=null&&params.get("month1")!=""){
    		String receivableDate1 = params.get("year1")+"年"+params.get("month1")+"月";
    		map.put("receivableDate1", receivableDate1);
    	}
    	if(params.get("year2")!=null&&params.get("year2")!=""&&params.get("month2")!=null&&params.get("month2")!=""){
    		String receivableDate2 = params.get("year2")+"年"+params.get("month2")+"月";
    		map.put("receivableDate2", receivableDate2);
    	}
    	if(params.get("number")!=null&&params.get("number")!=""){
    		map.put("number", params.get("number"));
    	}
    	List<ReceivableVO> receivableList = receivableService.list2(map);
        int total = receivableService.count2(map);
        PageUtils pageUtil = new PageUtils(receivableList, total);
  		return pageUtil;
    }
 
}