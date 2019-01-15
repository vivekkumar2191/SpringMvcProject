package org.lenovo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import org.lenovo.model.Plan;
import org.lenovo.model.Sample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class PlanDao {
	@Autowired
	 private JdbcTemplate jdbcTemplate;
	 public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

        
        
        
	public List<Plan> getplanbyName(String name){
	
		return jdbcTemplate.query("SELECT * FROM plan where name='"+name+"' ", new RowMapper<Plan>(){
			public Plan mapRow(ResultSet rs, int row) throws SQLException {
				
				Plan plan=new Plan();
                                
                                plan.setName(rs.getString("name"));
                                plan.setNamesample(rs.getInt("namesample"));
                                plan.setFirstcallsample(rs.getInt("firstcallsample"));
                                plan.setPrecallsample(rs.getInt("precallsample"));
                                
                                
                                System.out.println(rs.getString(2));
                                return plan;
			}
			
		});
		
	}


        
        
        	public int updatePlan(Plan plan){
return jdbcTemplate.update( "update plan set namesample=? ,precallsample=?,firstcallsample=? where name = ?", 
				 plan.getNamesample(),plan.getPrecallsample(),plan.getFirstcallsample(),plan.getName());
	
                }

        
        
        
        
     /*.............for displaying result in plan page..........................*/   
        
	 public List<Plan> getRecord() {
		
		 final String SELECT_QUERY = "SELECT name,namesample,firstcallsample,precallsample FROM plan ";
	 return jdbcTemplate.query(SELECT_QUERY, new PlanRowMapper());
	 }

	 private final class PlanRowMapper implements RowMapper<Plan> {

	 @Override
	 public Plan mapRow(ResultSet rs, int args) throws SQLException {
	 return new Plan(rs.getString("name"), rs.getInt("namesample"), rs.getInt("firstcallsample"),rs.getInt("precallsample"));
	 }

	 }
}