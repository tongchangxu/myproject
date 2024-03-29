package com.bootdo.rent.service;

import java.util.Map;

import com.bootdo.rent.domain.HouseContractCustomerDO;
import com.bootdo.rent.vo.HouseContractCustomerVO;

/**
 * 
 * @author lzh
 *
 */
public interface HouseContractCustomerService {
	HouseContractCustomerDO selectNumber(Map<String, Object> map);
	
	HouseContractCustomerDO getNumber(String numbers);

	HouseContractCustomerDO selectByContractNumber(String contractNumber);
	
	int save(HouseContractCustomerDO houseContractCustomerDO);

	int update(HouseContractCustomerDO houseContractCustomerDO);
	
	HouseContractCustomerVO getDetail(String number);
}