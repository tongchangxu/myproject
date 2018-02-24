package com.bootdo.rent.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootdo.rent.dao.ReceivableDao;
import com.bootdo.rent.domain.ReceivableDO;
import com.bootdo.rent.service.ReceivableService;
import com.bootdo.rent.vo.ReceivableVO;


@Service
public class ReceivableServiceImpl implements ReceivableService {
	@Autowired
	private ReceivableDao receivableDao;
	
	@Override
	public ReceivableDO getId(Long receivableId) {
		return receivableDao.getId(receivableId);
	}

	@Override
	public List<ReceivableVO> getByNumber(String number) {
		return receivableDao.getByNumber(number);
	}

	@Override
	public List<ReceivableVO> getByContractId(Long contractId) {
		return receivableDao.getByContractId(contractId);
	}

	@Override
	public List<ReceivableVO> list(Map<String, Object> params) {
		return receivableDao.list(params);
	}

	@Override
	public int count(Map<String, Object> params) {
		return receivableDao.count(params);
	}
	
	@Override
	public List<ReceivableVO> list2(Map<String, Object> params) {
		return receivableDao.list2(params);
	}

	@Override
	public int count2(Map<String, Object> params) {
		return receivableDao.count2(params);
	}

	@Override
	public int update(Map<String, Object> params) {
		return receivableDao.update(params);
	}
}