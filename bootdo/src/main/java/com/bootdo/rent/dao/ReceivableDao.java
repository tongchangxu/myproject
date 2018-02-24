package com.bootdo.rent.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import com.bootdo.rent.dao.provider.ReceivableDynaSqlProvider;
import com.bootdo.rent.domain.ReceivableDO;
import com.bootdo.rent.vo.ReceivableVO;

/**
 * 
 * @author lzh
 *
 */
@Mapper
public interface ReceivableDao {
	@Select("SELECT * FROM receivable WHERE receivable_id=#{receivableId}")
	ReceivableDO getId(Long receivableId);
	
	@Select("SELECT * FROM receivable WHERE number=#{number}")
	List<ReceivableVO> getByNumber(String number);
	
	@Select("SELECT * FROM receivable WHERE contract_id=#{contractId}")
	List<ReceivableVO> getByContractId(Long contractId);
	
	@SelectProvider(type=ReceivableDynaSqlProvider.class,method="getReceivables")  
	List<ReceivableVO> list(Map<String, Object> params);
	
	@SelectProvider(type=ReceivableDynaSqlProvider.class,method="receivableCount") 
	int count(Map<String, Object> params);
	
	@SelectProvider(type=ReceivableDynaSqlProvider.class,method="getReceivables2")  
	List<ReceivableVO> list2(Map<String, Object> params);
	
	@SelectProvider(type=ReceivableDynaSqlProvider.class,method="receivableCount2") 
	int count2(Map<String, Object> params);
	
	@Update("update receivable set number=#{number} where contract_id=#{contractId}")
	int update(Map<String, Object> params);
}
