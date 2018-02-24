package com.bootdo.rent.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import com.bootdo.rent.dao.provider.ContractDynaSqlProvider;
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
	
	List<ContractDO> contractList();
	
	int updateStatus(Map<String, Object> map);
	
	int updateHandle(ContractDO contract);
	
	List<ContractDO> handleList(Map<String, Object> params);
	
	int countForHandle();
}