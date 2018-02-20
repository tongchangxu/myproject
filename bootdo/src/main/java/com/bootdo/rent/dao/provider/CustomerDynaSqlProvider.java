package com.bootdo.rent.dao.provider;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

public class CustomerDynaSqlProvider {
	public String getCustomer(Map<String,Object> map){  
        String sql= new SQL(){  
            {  
                SELECT("*");  
                FROM("customer");  
                if(map.containsKey("customerId")){  
                    WHERE("customer_id=#{customerId}");  
                }
                if(map.containsKey("customerName")){  
                    WHERE("customer_name=#{customerName}");  
                }
            } 
        }.toString(); 
        System.out.println(map.toString());
        System.out.println(sql);
        return sql+" limit #{limit} offset #{offset}";
    } 
}
