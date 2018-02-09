package com.bootdo.test.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.bootdo.test.domain.FruitDO;
/**
 * 
 * @author lzh
 *
 */
@Mapper
public interface FruitDao {
	@Select("SELECT * FROM fruit WHERE name=#{name}")
	FruitDO get(String name);
	
	@Select("SELECT * FROM fruit limit #{limit} offset #{offset}")
	List<FruitDO> list(Map<String, Integer> paramst);
	
	@Select("SELECT count(*) FROM fruit")
	int count();
	
	@Insert("INSERT INTO fruit (name,weight,color,create_date,remarks,del_flag) "
			+ "values(#{name},#{weight},#{color},#{createDate},#{remarks},#{delFlag})")
	@Options(useGeneratedKeys=true, keyProperty="id",keyColumn = "id")
	int save(FruitDO user);
	
	@Update("UPDATE fruit set(#{name},#{weight},#{color},#{createDate},#{updateDate},#{remarks},#{delFlag}) "
			+ "WHERE id=#{id}")
	int update(FruitDO user);
	
	@Delete("DELETE FROM fruit WHERE id=#{id}")
	int remove(Long id);
	

}