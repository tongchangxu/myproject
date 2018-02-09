package com.bootdo.rent.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootdo.rent.dao.HouseDao;
import com.bootdo.rent.domain.HouseDO;
import com.bootdo.rent.service.HouseService;


@Service
public class HouseServiceImpl implements HouseService {
	@Autowired
	private HouseDao houseDao;

	@Override
	public HouseDO getId(Long houseId){
		return houseDao.getId(houseId);
	}
	
	@Override
	public HouseDO get(String name) {
		return houseDao.get(name);
	}
	
	@Override
	public List<HouseDO> list(Map<String, Integer> params) {
		return houseDao.list(params);
	}

	@Override
	public int count() {
		return houseDao.count();
	}


	@Override
	public int save(HouseDO house) {
		return houseDao.save(house);
	}


	@Override
	public int update(HouseDO house) {
		return houseDao.update(house);
	}


	@Override
	public int remove(Long id) {
		return houseDao.remove(id);
	}



	
	
}