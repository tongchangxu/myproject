package com.bootdo.rent.service;

import java.util.List;
import java.util.Map;

import com.bootdo.rent.domain.ContractDO;
import com.bootdo.rent.vo.ContractVO;

/**
 * 
 * @author lzh
 *
 */
public interface ContractService {
	ContractDO getId(Long contractId);
	
	ContractDO get(String contractNumber);
	
	ContractDO getByContractNumber(String contractNumber);
	
	List<ContractDO> list(Map<String, Object> params);
	
	ContractVO detail(String contractNumber);
	
	int count();
	
	int save(ContractVO contract);
	
	int update(ContractVO contract);
	
	int remove(Long contractId);
}