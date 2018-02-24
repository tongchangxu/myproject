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
import com.bootdo.rent.dao.provider.CustomerDynaSqlProvider;
import com.bootdo.rent.domain.ContractDO;
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

	@Select("SELECT * FROM customer WHERE customer_name=#{customerName}")
	CustomerDO get(String customerName);

	@SelectProvider(type = CustomerDynaSqlProvider.class, method = "getCustomer")
	List<CustomerDO> list(Map<String, Object> params);

	@SelectProvider(type = CustomerDynaSqlProvider.class, method = "normalList")
	List<CustomerDO> normalList(Map<String, Object> params);

	@Select("SELECT count(*) FROM customer where customer_status!=0")
	int normalCount();

	@Select("SELECT count(*) FROM customer")
	int count();

	@Insert("INSERT INTO customer (customer_name,customer_status,customer_remark) "
			+ "values(#{customerName},#{customerStatus},#{customerRemark})")
	@Options(useGeneratedKeys = true, keyProperty = "customerId", keyColumn = "customer_id")
	int save(CustomerDO customer);

	@Update("UPDATE customer set customer_name=#{customerName},customer_status=#{customerStatus},customer_remark=#{customerRemark} "
			+ "WHERE customer_id=#{customerId}")
	int update(CustomerDO customer);

	@Delete("DELETE FROM customer WHERE customer_id=#{customerId}")
	int remove(Long id);

	// 将修改和删除操作添加到操作记录表里面
	@Insert("INSERT INTO customer_handle (customer_id,customer_name,customer_status,customer_remark,handle,handle_time) "
			+ "values(#{customerId},#{customerName},#{customerStatus},#{customerRemark},#{handle},#{handleTime})")
	@Options(useGeneratedKeys = true, keyProperty = "customerHandleId", keyColumn = "customer_handle_id")
	int updateHandle(CustomerDO customer);

	@SelectProvider(type = CustomerDynaSqlProvider.class, method = "getHandleCustomers")
	List<CustomerDO> handleList(Map<String, Object> params);

	@Select("SELECT count(*) FROM customer_handle")
	int countForHandle();
}
