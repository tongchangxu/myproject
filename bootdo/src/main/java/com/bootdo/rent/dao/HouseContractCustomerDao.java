package com.bootdo.rent.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.bootdo.rent.domain.CustomerDO;
import com.bootdo.rent.domain.HouseContractCustomerDO;

/**
 * 
 * @author lzh
 *
 */
@Mapper
public interface HouseContractCustomerDao {
	@Select("select * from house_contract_customer where house_id=#{houseId} and customer_id=#{customerId}")
	HouseContractCustomerDO selectNumber(Map<String, Object> map);
	
	@Select("select * from house_contract_customer where number=#{number}")
	HouseContractCustomerDO getNumber(String numbers);
	
	@Select("select * from house_contract_customer where contract_number=#{contractNumber}")
	HouseContractCustomerDO selectByContractNumber(String contractNumber);
	
	@Insert("INSERT INTO house_contract_customer (house_id,contract_number,number,customer_id) "
			+ "values(#{houseId},#{contractNumber},#{number},#{customerId})")
	@Options(useGeneratedKeys=true, keyProperty="houseContractCustomerId",keyColumn = "houseContractCustomerId")
	int save(HouseContractCustomerDO houseContractCustomerDO);
	
	@Update("UPDATE house_contract_customer set house_id=#{houseId},contract_number=#{contractNumber},number=#{number},customer_id=#{customerId} "
			+ "WHERE house_contract_customer_id=#{houseContractCustomerId}")
	int update(HouseContractCustomerDO houseContractCustomerDO);
	
}
