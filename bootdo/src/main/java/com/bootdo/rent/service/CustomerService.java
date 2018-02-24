package com.bootdo.rent.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.bootdo.rent.dao.provider.CustomerDynaSqlProvider;
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
	
	List<CustomerDO> normalList(Map<String, Object> params);

	int normalCount();
	
	int count();
	
	int save(CustomerDO customer);
	
	int update(CustomerDO customer);
	
	int remove(Long customerId);
	
	int updateHandle(CustomerDO customer);

	List<CustomerDO> handleList(Map<String, Object> params);

	int countForHandle();
}