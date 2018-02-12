package com.bootdo.rent.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootdo.rent.dao.ContractDao;
import com.bootdo.rent.service.ContractService;
import com.bootdo.rent.vo.ContractVO;


@Service
public class ContractServiceImpl implements ContractService {
	@Autowired
	private ContractDao contractDao;

	@Override
	public ContractVO getId(Long contractId){
		return contractDao.getId(contractId);
	}
	
	@Override
	public ContractVO get(String contractNumber) {
		return contractDao.get(contractNumber);
	}
	
	@Override
	public List<ContractVO> list(Map<String, Object> params) {
		return contractDao.list(params);
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

	
}