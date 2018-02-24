package com.bootdo.rent.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootdo.rent.dao.CustomerDao;
import com.bootdo.rent.domain.CustomerDO;
import com.bootdo.rent.service.CustomerService;


@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDao customerDao;

	@Override
	public CustomerDO getId(Long customerId){
		return customerDao.getId(customerId);
	}
	
	@Override
	public CustomerDO get(String name) {
		return customerDao.get(name);
	}
	
	@Override
	public List<CustomerDO> list(Map<String, Object> params) {
		return customerDao.list(params);
	}
	
	@Override
	public List<CustomerDO> normalList(Map<String, Object> params){
		return customerDao.normalList(params);
	}

	@Override
	public int normalCount(){
		return customerDao.normalCount();
	}
	
	@Override
	public int count() {
		return customerDao.count();
	}

	@Override
	public int save(CustomerDO customer) {
		return customerDao.save(customer);
	}


	@Override
	public int update(CustomerDO customer) {
		return customerDao.update(customer);
	}


	@Override
	public int remove(Long id) {
		return customerDao.remove(id);
	}

	@Override
	public int updateHandle(CustomerDO customer) {
		return customerDao.updateHandle(customer);
	}

	@Override
	public List<CustomerDO> handleList(Map<String, Object> params) {
		return customerDao.handleList(params);
	}

	@Override
	public int countForHandle() {
		return customerDao.countForHandle();
	}



	
	
}