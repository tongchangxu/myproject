package com.bootdo.rent.service;

import java.util.List;
import java.util.Map;

import com.bootdo.rent.vo.ContractVO;

/**
 * 
 * @author lzh
 *
 */
public interface ContractService {
	ContractVO getId(Long contractId);
	
	ContractVO get(String name);
	
	List<ContractVO> list(Map<String, Object> params);
	
	int count();
	
	int save(ContractVO contract);
	
	int update(ContractVO contract);
	
	int remove(Long contractId);
}