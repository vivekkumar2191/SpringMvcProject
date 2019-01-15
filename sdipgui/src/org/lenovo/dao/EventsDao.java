/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lenovo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.lenovo.model.Events;
import org.lenovo.model.Plan;
import org.lenovo.model.Sample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author JITENDER
 */
public class EventsDao {
   
    /**
     * @return the jdbcTemplate
     */
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    /**
     * @param jdbcTemplate the jdbcTemplate to set
     */
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
 @Autowired private JdbcTemplate jdbcTemplate;   
 
   
            public List<Events> getEvents(){  
		 return jdbcTemplate.query("select eventid,sourceid,shortdesc,notitemplateidcreditzero,notitemplateidexpired from events  ",new ResultSetExtractor<List<Events>>(){  
		    
		     public List<Events> extractData(ResultSet rs) throws SQLException,  
		            DataAccessException {  
		      
		        List<Events> list=new ArrayList<Events>();  
		        while(rs.next()){  
		        	Events event=new Events();  
		        	event.setEventid(rs.getInt("eventid"));
                                event.setSourceid(rs.getInt("sourceid"));
                                event.setShortdesc(rs.getString("shortdesc"));
                                event.setNotitemplateidcreditzero(rs.getInt("notitemplateidcreditzero"));
                                event.setNotitemplateidexpired(rs.getInt("notitemplateidexpired"));
                                list.add(event);
		        }  
		        return list;  
		        }  
		    });  
		  }
            
    
 
 
}

