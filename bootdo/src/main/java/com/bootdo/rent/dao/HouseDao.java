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
import com.bootdo.rent.dao.provider.HouseDynaSqlProvider;
import com.bootdo.rent.domain.CustomerDO;
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

	@SelectProvider(type = HouseDynaSqlProvider.class, method = "getHouse")
	List<HouseDO> list(Map<String, Object> paramst);

	@SelectProvider(type = HouseDynaSqlProvider.class, method = "normalList")
	List<HouseDO> normalList(Map<String, Object> paramst);

	@Select("SELECT count(*) FROM house where house_status=1")
	int normalCount();

	@Select("SELECT count(*) FROM house")
	int count();

	@Insert("INSERT INTO house (house_number,address,space,house_status,house_type,area,house_remark) "
			+ "values(#{houseNumber},#{address},#{space},#{houseStatus},#{houseType},#{area},#{houseRemark})")
	@Options(useGeneratedKeys = true, keyProperty = "houseId", keyColumn = "house_id")
	int save(HouseDO house);

	@Update("UPDATE house set house_number=#{houseNumber},address=#{address},space=#{space},house_status=#{houseStatus},house_type=#{houseType},area=#{area},house_remark=#{houseRemark} "
			+ "WHERE house_id=#{houseId}")
	int update(HouseDO house);

	@Delete("DELETE FROM house WHERE house_id=#{houseId}")
	int remove(Long id);

	// 将修改和删除操作添加到操作记录表里面
	@Insert("INSERT INTO house_handle (house_id,house_number,address,space,house_status,house_type,area,house_remark,handle,handle_time) "
			+ "values(#{houseId},#{houseNumber},#{address},#{space},#{houseStatus},#{houseType},#{area},#{houseRemark},#{handle},#{handleTime})")
	@Options(useGeneratedKeys = true, keyProperty = "houseHandleId", keyColumn = "house_handle_id")
	int updateHandle(HouseDO house);

	@SelectProvider(type = HouseDynaSqlProvider.class, method = "getHandleHouse")
	List<HouseDO> handleList(Map<String, Object> params);

	@Select("SELECT count(*) FROM house_handle")
	int countForHandle();

}
