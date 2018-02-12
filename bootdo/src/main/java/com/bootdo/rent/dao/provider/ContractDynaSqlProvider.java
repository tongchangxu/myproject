package com.bootdo.rent.dao.provider;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

public class ContractDynaSqlProvider {
	public String getContracts(final Map<String,Object> map){  
        String sql= new SQL(){  
            {  
                SELECT("*");  
                FROM("contract c,house h");  
                WHERE("c.house_id=h.house_id");  
                if(map.containsKey("contractNumber")){  
                    WHERE("contract_number = #{contractNumber}");  
                }  
                if(map.containsKey("number")){  
                    WHERE("number=#{number}");  
                }
            } 
        }.toString(); 
        return sql+" limit #{limit} offset #{offset}";
    } 
}
