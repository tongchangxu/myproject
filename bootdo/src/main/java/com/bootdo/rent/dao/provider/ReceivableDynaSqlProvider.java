package com.bootdo.rent.dao.provider;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

public class ReceivableDynaSqlProvider {
	public String getReceivables(final Map<String,Object> map){  
        String sql= new SQL(){  
            {  
                SELECT("*");  
                FROM("contract c,receivable r");  
                WHERE("c.contract_id=r.contract_id");  
                WHERE("r.receivable_date=#{receivableDate}");
            } 
        }.toString(); 
        return sql+" limit #{limit} offset #{offset}";
    } 
	
	public String receivableCount(final Map<String,Object> map){  
        String sql= new SQL(){  
            {  
                SELECT("count(*)");  
                FROM("contract c,receivable r");  
                WHERE("c.contract_id=r.contract_id");  
                WHERE("r.receivable_date=#{receivableDate}");
            } 
        }.toString(); 
        return sql;
    } 
	
	public String getReceivables2(final Map<String,Object> map){  
        String sql= new SQL(){  
            {  
            	SELECT("*");  
                FROM("contract c,receivable r");  
                WHERE("c.contract_id=r.contract_id"); 
                WHERE("r.receivable_date>=#{receivableDate1}");
                WHERE("r.receivable_date<=#{receivableDate2}");
                WHERE("r.number=#{number}");
            } 
        }.toString(); 
        return sql+" limit #{limit} offset #{offset}";
    } 
	
	public String receivableCount2(final Map<String,Object> map){  
        String sql= new SQL(){  
            {  
                SELECT("count(*)");  
                FROM("contract c,receivable r");  
                WHERE("c.contract_id=r.contract_id"); 
                WHERE("r.receivable_date>=#{receivableDate1}");
                WHERE("r.receivable_date<=#{receivableDate2}");
                WHERE("r.number=#{number}");
            } 
        }.toString(); 
        return sql;
    } 
}
