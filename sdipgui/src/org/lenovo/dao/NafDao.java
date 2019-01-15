package org.lenovo.dao;

import org.lenovo.model.Naf;
import org.lenovo.model.Peer;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class NafDao {
	
	private JdbcTemplate jdbcTemplate;



	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
	this.jdbcTemplate = jdbcTemplate;
}
	public List <Naf> getNaf(){
		
		 return jdbcTemplate.query("select domain_name,ua_security_protocol_id,impi_send_flag,ip_address from naf_provisioning",new ResultSetExtractor<List<Naf>>(){  
		    
		     public List<Naf> extractData(ResultSet rs) throws SQLException,  
		            DataAccessException {  
		      
		        List<Naf> list=new ArrayList<Naf>();  
		        while(rs.next()){  
		        	Naf naf=new Naf();  
		     
		        	naf.setDomain_name(rs.getString("domain_name"));
		        	naf.setUa_security_protocol_id(rs.getString("ua_security_protocol_id"));
		        	naf.setImpi_send_flag(rs.getInt("impi_send_flag"));
		        	naf.setIp_address(rs.getString("ip_address"));
		        	list.add(naf);  
		        }  
		        return list;  
		        }  
		    });  
		  }
	public int createNaf(Naf n){  
		   
	    return jdbcTemplate.update("INSERT INTO naf_provisioning(domain_name,ua_security_protocol_id,impi_send_flag,ip_address) VALUES(?,?,?,?)",
				n.getDomain_name(),n.getUa_security_protocol_id(),n.getImpi_send_flag(),n.getIp_address());  
	    
    
	} 
	public List<Naf> getNafbyName(String domain_name){
		
		return jdbcTemplate.query("select domain_name,ua_security_protocol_id,impi_send_flag,ip_address from naf_provisioning where domain_name='"+domain_name+"'", new RowMapper<Naf>(){
			public Naf mapRow(ResultSet rs, int row) throws SQLException {
				
				Naf n=new Naf();
			n.setDomain_name(rs.getString("domain_name"));
			n.setUa_security_protocol_id(rs.getString("ua_security_protocol_id"));
			n.setImpi_send_flag(rs.getInt("impi_send_flag"));
			n.setIp_address(rs.getString("ip_address"));
		
				return n;
			}
			
		});
		
	}
	public int updateNaf(Naf na,String id){
		
		String query="update naf_provisioning set domain_name='"+na.getDomain_name()+"',ua_security_protocol_id='"+na.getUa_security_protocol_id()+"',impi_send_flag='"+na.getImpi_send_flag()+"',ip_address='"+na.getIp_address()+"' where domain_name='"+id+"' ";
		System.out.println("query is:"+query);
		return jdbcTemplate.update(query);
		
		
	
	}
	

	

}
