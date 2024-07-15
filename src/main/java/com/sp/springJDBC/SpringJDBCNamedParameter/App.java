package com.sp.springJDBC.SpringJDBCNamedParameter;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.sp.resource.JavaConfig;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Map <String, Object> map=new HashMap<String, Object>();
    	map.put("key_accoutno", 902);
    	map.put("key_firstname", "Rahul");
    	map.put("key_lasttname", "Rahul");
    	map.put("key_balaace", 9020);
        ApplicationContext context=new AnnotationConfigApplicationContext(JavaConfig.class);
        
        NamedParameterJdbcTemplate jtmp=context.getBean(NamedParameterJdbcTemplate.class);
        
        String query="Insert into account values(:key_accoutno,:key_firstname,:key_lasttname,:key_balaace)";
        int count=jtmp.update(query, map);
        if(count>0)
        {
        	System.out.println("Data inserted successfully");
        }
        else {
        	System.out.println("Data  inserted  Failed");
        }
        
        
        
    }
}
