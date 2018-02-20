package com.bootdo.rent.dao.provider;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

public class HouseDynaSqlProvider {
	public String getHouse(Map<String,Object> map){  
        String sql= new SQL(){  
            {  
                SELECT("*");  
                FROM("house");  
                if(map.containsKey("houseId")){  
                    WHERE("house_id=#{houseId}");  
                }
                if(map.containsKey("houseNumber")){  
                    WHERE("house_number=#{houseNumber}");  
                }
                if(map.containsKey("address")){  
                	WHERE("address like concat('%',#{address},'%')");  //like '%'||#{name}||'%'  
                }
                
            } 
        }.toString(); 
        System.out.println(map.toString());
        System.out.println(sql);
        return sql+" limit #{limit} offset #{offset}";
    }
}
