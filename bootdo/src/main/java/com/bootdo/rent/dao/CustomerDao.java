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

import com.bootdo.rent.dao.provider.CustomerDynaSqlProvider;
import com.bootdo.rent.domain.CustomerDO;

/**
 * 
 * @author lzh
 *
 */
@Mapper
public interface CustomerDao {
	@Select("SELECT * FROM customer WHERE customer_id=#{customerId}")
	CustomerDO getId(Long customerId);
	
	@Select("SELECT * FROM customer WHERE number=#{number}")
	CustomerDO get(String number);
	
	@SelectProvider(type=CustomerDynaSqlProvider.class,method="getCustomer")  
	List<CustomerDO> list(Map<String, Object> params);
	
	@Select("SELECT count(*) FROM customer")
	int count();
	
	@Insert("INSERT INTO customer (number,customer_name,customer_status,customer_remark) "
			+ "values(#{number},#{customerName},#{customerStatus},#{customerRemark})")
	@Options(useGeneratedKeys=true, keyProperty="customerId",keyColumn = "customer_id")
	int save(CustomerDO customer);
	
	@Update("UPDATE customer set number=#{number},customer_name=#{customerName},customer_status=#{customerStatus},customer_remark=#{customerRemark} "
			+ "WHERE customer_id=#{customerId}")
	int update(CustomerDO customer);
	
	@Delete("DELETE FROM customer WHERE customer_id=#{customerId}")
	int remove(Long id);
	

}
