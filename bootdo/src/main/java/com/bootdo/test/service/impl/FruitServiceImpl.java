package com.bootdo.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootdo.test.dao.FruitDao;
import com.bootdo.test.domain.FruitDO;
import com.bootdo.test.service.FruitService;


@Service
public class FruitServiceImpl implements FruitService {
	@Autowired
	private FruitDao fruitDao;

	
	@Override
	public List<FruitDO> list() {
		return fruitDao.list();
	}



	
	
}
