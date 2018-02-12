package com.bootdo.rent.service;

import java.util.List;
import java.util.Map;

import com.bootdo.rent.domain.HouseDO;

/**
 * 
 * @author lzh
 *
 */
public interface HouseService {
	HouseDO getId(Long houseId);
	
	HouseDO get(String name);
	
	List<HouseDO> list(Map<String, Integer> params);
	
	int count();
	
	int save(HouseDO house);
	
	int update(HouseDO house);
	
	int remove(Long id);
}