package com.bootdo.rent.dao.provider;

import org.apache.ibatis.jdbc.SQL;

public class HouseContractCustomerDynaSqlProvider {
	public String getDetail(String number){  
        String sql= new SQL(){  
            {  
                SELECT("*");  
                FROM("customer c,house h,house_contract_customer hcc");  
                WHERE("c.customer_id=hcc.customer_id");  
                WHERE("h.house_id=hcc.house_id");
                WHERE("hcc.number=#{number}");
            } 
        }.toString(); 
        return sql;
    } 
}
