package com.bootdo.rent.dao.provider;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

public class ContractDynaSqlProvider {
	public String getContracts(final Map<String,Object> map){  
        String sql= new SQL(){  
            {  
                SELECT("*");  
                FROM("contract c,house h");  
                WHERE("h.house_id = c.house_id");  
                if(map.containsKey("contractNumber")){  
                    WHERE("h.contract_number = #{contractNumber}");  
                }  
                if(map.containsKey("number")){  
                    WHERE("h.number=#{number}");  
                }
                if(map.containsKey("address")){  
                    WHERE("h.address like concat('%',#{address},'%')");  //like '%'||#{name}||'%'  
                }
                if(map.containsKey("houseNumber")){  
                    WHERE("h.house_number=#{houseNumber}");  
                }
                ORDER_BY("c.contract_id");
            } 
        }.toString(); 
        return sql+" limit #{limit} offset #{offset}";
    } 
	
	public String getContractDetail(final String contractNumber){  
        String sql= new SQL(){  
            {  
                SELECT("*");  
                FROM("contract");  
                WHERE("contract_number=#{contractNumber}");
            } 
        }.toString(); 
        return sql;
    } 
	
	public String getHandleContracts(final Map<String,Object> map){  
        String sql= new SQL(){  
            {  
                SELECT("*");  
                FROM("contract_handle c,house h");  
                WHERE("h.house_id = c.house_id");  
                if(map.containsKey("contractNumber")){  
                    WHERE("h.contract_number = #{contractNumber}");  
                }  
                if(map.containsKey("number")){  
                    WHERE("h.number=#{number}");  
                }
                if(map.containsKey("address")){  
                    WHERE("h.address like concat('%',#{address},'%')");  //like '%'||#{name}||'%'  
                }
                if(map.containsKey("houseNumber")){  
                    WHERE("h.house_number=#{houseNumber}");  
                }
                ORDER_BY("c.contract_handle_id desc");
            } 
        }.toString(); 
        return sql+" limit #{limit} offset #{offset}";
    } 
	
}
