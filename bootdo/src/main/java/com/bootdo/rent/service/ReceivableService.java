package com.bootdo.rent.service;

import java.util.List;
import java.util.Map;

import com.bootdo.rent.domain.ReceivableDO;
import com.bootdo.rent.vo.ReceivableVO;

/**
 * 
 * @author lzh
 *
 */
public interface ReceivableService {
	ReceivableDO getId(Long receivableId);
	
	List<ReceivableVO> getByNumber(String number);
	
	List<ReceivableVO> getByContractId(Long contractId);
	
	List<ReceivableVO> list(Map<String, Object> params);
	
	int count(Map<String, Object> params);
	
	List<ReceivableVO> list2(Map<String, Object> params);
	
	int count2(Map<String, Object> params);
	
	int update(Map<String, Object> params);
}