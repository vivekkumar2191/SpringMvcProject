package org.lenovo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.lenovo.model.Sample;
import org.lenovo.model.Bsfusage;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

public class Bsfusagedao {

	private JdbcTemplate jdbcTemplate;



	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
	this.jdbcTemplate = jdbcTemplate;
}

	
	
  	public int createbsfusage(Bsfusage s){  
	String query="insert into bsf_usage_parameter(high_usage_warning,level)   value('"+s.getHigh_usage_warning()+"','"+s.getLevel()+"')";
  		return jdbcTemplate.update(query);  
	}  

  	
	public int updatebsfusage(Bsfusage s,int id){

  String query="update bsf_usage_parameter set high_usage_warning='"+s.getHigh_usage_warning()+"' where high_usage_warning='"+id+"'"  ;
  System.out.println(query);
	return jdbcTemplate.update(query);

	}
	

	
	public int updatebsfusage2(Bsfusage s,int level){

		  String query="update bsf_usage_parameter set level='"+s.getLevel()+"' where level='"+level+"'"  ;
		  System.out.println(query);
			return jdbcTemplate.update(query);

			}
			

	

	public List<Bsfusage> getbsfusage(){  
		 return jdbcTemplate.query("select * from bsf_usage_parameter",new ResultSetExtractor<List<Bsfusage>>(){  
		    
		     public List<Bsfusage> extractData(ResultSet rs) throws SQLException,  
		            DataAccessException {  
		      
		        List<Bsfusage> list=new ArrayList<Bsfusage>();  
		        while(rs.next()){  
		        	Bsfusage sh=new Bsfusage();  
/*		        	sh.setFieldid(rs.getInt("fieldid"));
		     sh.setShortdesc(rs.getString("shortdesc")); 
	
		     sh.setLongdesctext(rs.getString("longdesctext"));
*/		     
		        	sh.setHigh_usage_warning(rs.getInt("high_usage_warning"));
		        	sh.setLevel(rs.getInt("level"));
		        	list.add(sh);  
		        }  
		        return list;  
		        }  
		    });  
		  }  
	
	
	
	public List<Bsfusage> getBSFusagebyId(int highusage){
		
		return jdbcTemplate.query("select * from bsf_usage_parameter where high_usage_warning='"+highusage+"'", new RowMapper<Bsfusage>(){
			public Bsfusage mapRow(ResultSet rs, int row) throws SQLException {
				
				Bsfusage s=new Bsfusage();
				s.setHigh_usage_warning(rs.getInt("high_usage_warning"));
	//              s.setLongdesctext(rs.getString("longdesctext"));
               
				return s;
			}
			
		});
		
	}


	
public List<Bsfusage> getBSFusagebyId2(int level){
		
		return jdbcTemplate.query("select * from bsf_usage_parameter where level='"+level+"'", new RowMapper<Bsfusage>(){
			public Bsfusage mapRow(ResultSet rs, int row) throws SQLException {
				
				Bsfusage s=new Bsfusage();
				s.setLevel(rs.getInt("level"));
	//              s.setLongdesctext(rs.getString("longdesctext"));
               
				return s;
			}
			
		});
		
	}

	
}
