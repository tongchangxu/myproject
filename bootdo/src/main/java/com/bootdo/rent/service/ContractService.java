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
	
	ContractDO get(String name);
	
	List<ContractDO> list(Map<String, Object> params);
	
	int count();
	
	int save(ContractDO contract);
	
	int update(ContractDO contract);
	
	int remove(Long contractId);
}