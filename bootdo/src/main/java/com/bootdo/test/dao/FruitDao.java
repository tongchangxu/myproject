package com.bootdo.test.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.bootdo.test.domain.FruitDO;
/**
 * 
 * @author lzh
 *
 */
@Mapper
public interface FruitDao {
	@Select("SELECT * FROM fruit")
	List<FruitDO> list();
	

}