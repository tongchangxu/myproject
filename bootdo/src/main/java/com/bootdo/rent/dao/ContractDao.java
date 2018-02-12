package com.bootdo.rent.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import com.bootdo.rent.dao.provider.ContractDynaSqlProvider;
import com.bootdo.rent.domain.ContractDO;

/**
 * 
 * @author lzh
 *
 */
@Mapper
public interface ContractDao {
	@Select("SELECT * FROM contract WHERE contract_id=#{contractId}")
	ContractDO getId(Long contractId);
	
	@Select("SELECT * FROM contract WHERE number=#{number}")
	ContractDO get(String number);
	
	@SelectProvider(type=ContractDynaSqlProvider.class,method="getContracts")  
	List<ContractDO> list(Map<String, Object> params);
	
	@Select("SELECT count(*) FROM contract")
	int count();
	
	@Insert("INSERT INTO contract (number,customer_name,customer_status,customer_remark) "
			+ "values(#{number},#{customerName},#{customerStatus},#{customerRemark})")
	@Options(useGeneratedKeys=true, keyProperty="contractId",keyColumn = "contract_id")
	int save(ContractDO contract);
	
	@Update("UPDATE contract set number=#{number},contract_name=#{contractName},contract_status=#{contractStatus},contract_remark=#{contractRemark} "
			+ "WHERE house_id=#{houseId}")
	int update(ContractDO contract);
	
	@Delete("DELETE FROM contract WHERE contract_id=#{contractId}")
	int remove(Long id);
	

}
