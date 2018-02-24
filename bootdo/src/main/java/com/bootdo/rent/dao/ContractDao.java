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
import com.bootdo.rent.vo.ContractVO;

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
	
	@Select("SELECT * FROM contract WHERE contract_number=#{contractNumber}")
	ContractDO getByContractNumber(String contractNumber);
	
	@SelectProvider(type=ContractDynaSqlProvider.class,method="getContracts")  
	List<ContractDO> list(Map<String, Object> params);
	
	@SelectProvider(type=ContractDynaSqlProvider.class,method="getContractDetail")  
	ContractVO detail(String contractNumber);
	
	@Select("SELECT count(*) FROM contract")
	int count();
	
	@Insert("INSERT INTO contract (contract_number,operator,contract_name,company,rent,start_time,stop_time,lead_time,"
			+ "invoice_type,growth_rate,rent_detail,deposit,contract_status,create_time,status_description,growth_time,area,number,house_id) "
			+ "values(#{contractNumber},#{operator},#{contractName},#{company},#{rent},#{startTime},#{stopTime},#{leadTime},"
			+ "#{invoiceType},#{growthRate},#{rentDetail},#{deposit},#{contractStatus},#{createTime},#{statusDescription},#{growthTime},#{area},#{number},#{houseId})")
	@Options(useGeneratedKeys=true, keyProperty="contractId",keyColumn = "contract_id")
	int save(ContractVO contract);
	
	@Update("UPDATE contract set contract_number=#{contractNumber},operator=#{operator},contract_name=#{contractName},"
			+ "company=#{company},rent=#{rent},start_time=#{startTime},stop_time=#{stopTime},lead_time=#{leadTime},"
			+ "invoice_type=#{invoiceType},growth_rate=#{growthRate},rent_detail=#{rentDetail},deposit=#{deposit},"
			+ "contract_status=#{contractStatus},create_time=#{createTime},status_description=#{statusDescription},"
			+ "growth_time=#{growthTime},area=#{area},number=#{number},house_id=#{houseId} "
			+ "WHERE contract_id=#{contractId}")
	int update(ContractVO contract);
	
	@Delete("DELETE FROM contract WHERE contract_id=#{contractId}")
	int remove(Long id);
	
	@Select("SELECT * FROM contract WHERE contract_status!='退租' and contract_status!='终止协议' ")
	List<ContractDO> contractList();
	
	@Update("update contract set contract_status=#{contractStatus} where contract_id=#{contractId}")
	int updateStatus(Map<String, Object> map);
	
	//将修改和删除操作添加到操作记录表里面
	@Insert("INSERT INTO contract_handle (contract_id,contract_number,operator,contract_name,company,rent,start_time,stop_time,lead_time,"
			+ "invoice_type,growth_rate,rent_detail,deposit,contract_status,create_time,status_description,growth_time,area,number,house_id,handle,handle_time) "
			+ "values(#{contractId},#{contractNumber},#{operator},#{contractName},#{company},#{rent},#{startTime},#{stopTime},#{leadTime},"
			+ "#{invoiceType},#{growthRate},#{rentDetail},#{deposit},#{contractStatus},#{createTime},#{statusDescription},#{growthTime},#{area},#{number},#{houseId},#{handle},#{handleTime})")
	@Options(useGeneratedKeys=true, keyProperty="contractHandleId",keyColumn = "contract_handle_id")
	int updateHandle(ContractDO contract);
	
	@SelectProvider(type=ContractDynaSqlProvider.class,method="getHandleContracts")  
	List<ContractDO> handleList(Map<String, Object> params);
	
	@Select("SELECT count(*) FROM contract_handle")
	int countForHandle();
}
