package com.bootdo.rent.service;

import java.util.List;
import java.util.Map;

import com.bootdo.rent.domain.CustomerDO;

/**
 * 
 * @author lzh
 *
 */
public interface CustomerService {
	CustomerDO getId(Long customerId);
	
	CustomerDO get(String name);
	
	List<CustomerDO> list(Map<String, Object> params);
	
	int count();
	
	int save(CustomerDO customer);
	
	int update(CustomerDO customer);
	
	int remove(Long customerId);
}