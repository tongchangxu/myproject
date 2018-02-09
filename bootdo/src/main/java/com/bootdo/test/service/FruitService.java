package com.bootdo.test.service;

import java.util.List;
import java.util.Map;

import com.bootdo.test.domain.FruitDO;

/**
 * 
 * @author lzh
 *
 */
public interface FruitService {
	FruitDO get(String name);
	
	List<FruitDO> list(Map<String, Integer> params);
	
	int count();
	
	int save(FruitDO fruit);
	
	int update(FruitDO fruit);
	
	int remove(Long id);
}
