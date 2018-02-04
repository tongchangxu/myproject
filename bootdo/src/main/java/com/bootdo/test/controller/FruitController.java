package com.bootdo.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @ResponseBody
    @GetMapping("/get")
    public List<FruitDO> list() {
        List<FruitDO> fruitList = fruitService.list();
        return fruitList;
    }


}
