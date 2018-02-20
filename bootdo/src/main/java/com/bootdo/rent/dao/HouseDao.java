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
import com.bootdo.rent.dao.provider.HouseDynaSqlProvider;
import com.bootdo.rent.domain.HouseDO;
/**
 * 
 * @author lzh
 *
 */
@Mapper
public interface HouseDao {
	@Select("SELECT * FROM house WHERE house_id=#{houseId}")
	HouseDO getId(Long houseId);
	
	@Select("SELECT * FROM house WHERE address=#{address}")
	HouseDO get(String address);
	
	@SelectProvider(type=HouseDynaSqlProvider.class,method="getHouse")  
	List<HouseDO> list(Map<String, Object> paramst);
	
	@Select("SELECT count(*) FROM house")
	int count();
	
	@Insert("INSERT INTO house (address,space,house_status,area,house_remark) "
			+ "values(#{address},#{space},#{houseStatus},#{area},#{houseRemark})")
	@Options(useGeneratedKeys=true, keyProperty="houseId",keyColumn = "house_id")
	int save(HouseDO house);
	
	@Update("UPDATE house set address=#{address},space=#{space},house_status=#{houseStatus},area=#{area},house_remark=#{houseRemark} "
			+ "WHERE house_id=#{houseId}")
	int update(HouseDO house);
	
	@Delete("DELETE FROM house WHERE house_id=#{houseId}")
	int remove(Long id);
	

}
