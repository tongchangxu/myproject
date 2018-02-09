package com.bootdo.rent.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.bootdo.rent.domain.HouseDO;
/**
 * 
 * @author lzh
 *
 */
@Mapper
public interface HouseDao {
	@Select("SELECT * FROM house WHERE address=#{address}")
	HouseDO get(String address);
	
	@Select("SELECT * FROM house limit #{limit} offset #{offset}")
	List<HouseDO> list(Map<String, Integer> paramst);
	
	@Select("SELECT count(*) FROM house")
	int count();
	
	@Insert("INSERT INTO fruit (name,weight,color,create_date,remarks,del_flag) "
			+ "values(#{name},#{weight},#{color},#{createDate},#{remarks},#{delFlag})")
	@Options(useGeneratedKeys=true, keyProperty="id",keyColumn = "id")
	int save(HouseDO house);
	
	@Update("UPDATE fruit set(#{name},#{weight},#{color},#{createDate},#{updateDate},#{remarks},#{delFlag}) "
			+ "WHERE id=#{id}")
	int update(HouseDO house);
	
	@Delete("DELETE FROM house WHERE id=#{id}")
	int remove(Long id);
	

}