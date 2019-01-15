package org.lenovo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.lenovo.model.Bac;
import org.lenovo.model.Naf;
import org.lenovo.model.Peer;
import org.lenovo.model.Sample;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

public class BacDao {
	private JdbcTemplate jdbcTemplate;
	
public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	

	public List<Bac> getBac(){  
		 return jdbcTemplate.query("select * from bsf_app_parameter ",new ResultSetExtractor<List<Bac>>(){  
			
			 public List<Bac> extractData(ResultSet rs) throws SQLException,  
	            DataAccessException {  
	      
		        List<Bac> list=new ArrayList<Bac>();  
		        while(rs.next()){  
		        	Bac bac=new Bac(); 
		        
		        	bac.setBsf_server_name(rs.getString("bsf_server_name"));
		        	bac.setDestination_host(rs.getString("destination_host"));
		            bac.setZn_soap_url(rs.getString("zn_soap_url"));
		        	bac.setGba_type(rs.getString("gba_type"));
		        	bac.setUb_session_time(rs.getInt("ub_session_time"));
		        	bac.setUb_authentication_domain(rs.getString("ub_authentication_domain"));
		        	bac.setGba_Digest(rs.getString("gba_Digest"));
		        	bac.setB_tid_lifetime(rs.getInt("b_tid_lifetime"));
		        	bac.setGuss_timestamp(rs.getString("guss_timestamp"));
		        	bac.setSlf(rs.getString("slf"));
		        	bac.setUa_security_protocol_id(rs.getString("ua_security_protocol_id"));
		        	bac.setMaxNAFAllowed(rs.getInt("maxNAFAllowed"));
		        	bac.setCdr_logging(rs.getString("cdr_logging"));
		        	bac.setCdr_transfer_server(rs.getString("cdr_transfer_server"));
		        	bac.setCdr_transfer_server_details(rs.getString("cdr_transfer_server_details"));
		        System.out.println();
		   	     System.out.println("values are.gba type..........."+bac.getGba_type());
		   /*  System.out.println(bac.getbsf_server_name());
		    // System.out.println(bac.getDestination_host());
		     System.out.println("values are............"+bac.bsf_server_name());
		     System.out.println("values are............"+bac.getDestination_host());
		     System.out.println("values are............"+bac.getCDR_Transfer_Server_details());
		     
		    */    list.add(bac);  
		        }  
		        return list;  
		        }  
		    });  
		  }  
	
	
public List<Bac> getBacByServerName(String bsf_server_name){
		
		return jdbcTemplate.query("select * from bsf_app_parameter where BSF_server_name='"+bsf_server_name+"'", new RowMapper<Bac>(){
			public Bac mapRow(ResultSet rs, int row) throws SQLException {
				
			    Bac bac =new Bac();
			    bac.setBsf_server_name(rs.getString("bsf_server_name"));
	        	bac.setDestination_host(rs.getString("destination_host"));
	            bac.setZn_soap_url(rs.getString("zn_soap_url"));
	        	bac.setGba_type(rs.getString("gba_type"));
	        	bac.setUb_session_time(rs.getInt("ub_session_time"));
	        	bac.setUb_authentication_domain(rs.getString("ub_authentication_domain"));
	        	bac.setGba_Digest(rs.getString("gba_Digest"));
	        	bac.setB_tid_lifetime(rs.getInt("b_tid_lifetime"));
	        	bac.setGuss_timestamp(rs.getString("guss_timestamp"));
	        	bac.setSlf(rs.getString("slf"));
	        	bac.setUa_security_protocol_id(rs.getString("ua_security_protocol_id"));
	        	bac.setMaxNAFAllowed(rs.getInt("maxNAFAllowed"));
	        	bac.setCdr_logging(rs.getString("cdr_logging"));
	        	bac.setCdr_transfer_server(rs.getString("cdr_transfer_server"));
	        	bac.setCdr_transfer_server_details(rs.getString("cdr_transfer_server_details"));
			   System.out.println("bac values are.."+bac);
				return bac;
				
			}  
			
		});
		
	}
public int updateBac(Bac ba,String id){
		
			

	return jdbcTemplate.update("update bsf_app_parameter set Bsf_server_name=?,Destination_host=?,Zn_SOAP_URL=?,GBA_Type=?,Ub_Session_Time=?,Ub_authentication_domain=?,Gba_Digest=?,B_tid_lifetime=?,GUSS_Timestamp=?,SLF=?,Ua_Security_Protocol_ID=?,MaxNAFAllowed=?,CDR_Logging=?,CDR_Transfer_Server=?,CDR_Transfer_Server_details=? where BSF_server_name='"+id+"'",ba.getBsf_server_name(),ba.getDestination_host(),ba.getZn_soap_url(),ba.getGba_type(),ba.getUb_session_time(),ba.getUb_authentication_domain(),ba.getGba_Digest(),ba.getB_tid_lifetime(),ba.getGuss_timestamp(),ba.getSlf(),ba.getUa_security_protocol_id(),ba.getMaxNAFAllowed(),ba.getCdr_logging(),ba.getCdr_transfer_server(),ba.getCdr_transfer_server_details());
	
	

}
}
