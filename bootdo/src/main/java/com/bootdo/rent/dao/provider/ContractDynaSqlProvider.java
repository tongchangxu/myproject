package com.bootdo.rent.dao.provider;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

public class ContractDynaSqlProvider {
	public String getContracts(final Map<String,Object> map){  
        String sql= new SQL(){  
            {  
                SELECT("*");  
                FROM("contract co,house_contract_customer hcc,house h,customer cu");  
                WHERE("hcc.contract_number=co.contract_number");  
                WHERE("hcc.house_id=h.house_id");
                WHERE("hcc.customer_id=cu.customer_id");
                if(map.containsKey("contractNumber")){  
                    WHERE("contract_number = #{contractNumber}");  
                }  
                if(map.containsKey("number")){  
                    WHERE("number=#{number}");  
                }
                if(map.containsKey("address")){  
                    WHERE("address like '%#{address}%'");  
                }
                if(map.containsKey("houseNumber")){  
                    WHERE("house_number=#{houseNumber}");  
                }
            } 
        }.toString(); 
        return sql+" limit #{limit} offset #{offset}";
    } 
}
