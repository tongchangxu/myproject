package com.bootdo.rent.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.bootdo.rent.dao.provider.HouseDynaSqlProvider;
import com.bootdo.rent.domain.HouseDO;

/**
 * 
 * @author lzh
 *
 */
public interface HouseService {
	HouseDO getId(Long houseId);
	
	HouseDO get(String name);
	
	List<HouseDO> list(Map<String, Object> params);
	
	List<HouseDO> normalList(Map<String, Object> paramst);
	
	int normalCount();
	
	int count();
	
	int save(HouseDO house);
	
	int update(HouseDO house);
	
	int remove(Long id);
	
	int updateHandle(HouseDO house);

	List<HouseDO> handleList(Map<String, Object> params);

	int countForHandle();
}