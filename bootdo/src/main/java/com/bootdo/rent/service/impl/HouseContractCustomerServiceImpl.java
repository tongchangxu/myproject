package com.bootdo.rent.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootdo.rent.dao.HouseContractCustomerDao;
import com.bootdo.rent.domain.HouseContractCustomerDO;
import com.bootdo.rent.service.HouseContractCustomerService;
import com.bootdo.rent.vo.HouseContractCustomerVO;


@Service
public class HouseContractCustomerServiceImpl implements HouseContractCustomerService {
	@Autowired
	private HouseContractCustomerDao houseContractCustomerDao;

	@Override
	public HouseContractCustomerDO selectNumber(Map<String, Object> map){
		return houseContractCustomerDao.selectNumber(map);
	}

	@Override
	public HouseContractCustomerDO getNumber(String numbers) {
		return houseContractCustomerDao.getNumber(numbers);
	}

	@Override
	public HouseContractCustomerDO selectByContractNumber(String contractNumber) {
		return houseContractCustomerDao.selectByContractNumber(contractNumber);
	}
	
	@Override
	public int save(HouseContractCustomerDO houseContractCustomerDO) {
		return houseContractCustomerDao.save(houseContractCustomerDO);
	}

	@Override
	public int update(HouseContractCustomerDO houseContractCustomerDO) {
		return houseContractCustomerDao.update(houseContractCustomerDO);
	}

	@Override
	public HouseContractCustomerVO getDetail(String number) {
		return houseContractCustomerDao.getDetail(number);
	}

	
}