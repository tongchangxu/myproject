package com.bootdo.test.service.impl;

import java.util.List;
import java.util.Map;

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
	public FruitDO get(String name) {
		return fruitDao.get(name);
	}
	
	@Override
	public List<FruitDO> list(Map<String, Integer> params) {
		return fruitDao.list(params);
	}

	@Override
	public int count() {
		return fruitDao.count();
	}


	@Override
	public int save(FruitDO user) {
		return fruitDao.save(user);
	}


	@Override
	public int update(FruitDO user) {
		return fruitDao.update(user);
	}


	@Override
	public int remove(Long id) {
		return fruitDao.remove(id);
	}



	
	
}
