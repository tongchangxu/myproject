package com.bootdo.rent.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootdo.rent.dao.ContractDao;
import com.bootdo.rent.domain.ContractDO;
import com.bootdo.rent.service.ContractService;
import com.bootdo.rent.vo.ContractVO;


@Service
public class ContractServiceImpl implements ContractService {
	@Autowired
	private ContractDao contractDao;

	@Override
	public ContractDO getId(Long contractId){
		return contractDao.getId(contractId);
	}
	
	@Override
	public ContractDO get(String contractNumber) {
		return contractDao.get(contractNumber);
	}
	@Override
	public ContractDO getByContractNumber(String contractNumber){
		return contractDao.getByContractNumber(contractNumber);
	}
	
	@Override
	public List<ContractDO> list(Map<String, Object> params) {
		return contractDao.list(params);
	}
	
	@Override
	public ContractVO detail(String contractNumber){
		return contractDao.detail(contractNumber);
	}
	
	@Override
	public int count() {
		return contractDao.count();
	}


	@Override
	public int save(ContractVO contract) {
		return contractDao.save(contract);
	}


	@Override
	public int update(ContractVO contract) {
		return contractDao.update(contract);
	}


	@Override
	public int remove(Long contractId) {
		return contractDao.remove(contractId);
	}

	@Override
	public List<ContractDO> contractList() {
		return contractDao.contractList();
	}

	@Override
	public int updateStatus(Map<String, Object> map) {
		return contractDao.updateStatus(map);
	}

	@Override
	public int updateHandle(ContractDO contract) {
		return contractDao.updateHandle(contract);
	}

	@Override
	public List<ContractDO> handleList(Map<String, Object> params) {
		return contractDao.handleList(params);
	}

	@Override
	public int countForHandle() {
		return contractDao.countForHandle();
	}

	
}