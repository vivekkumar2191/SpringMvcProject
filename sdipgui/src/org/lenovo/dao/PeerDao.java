package org.lenovo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.lenovo.model.Peer;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

public class PeerDao {
	private JdbcTemplate jdbcTemplate;



	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
	this.jdbcTemplate = jdbcTemplate;
}



	public List<Peer> getPeer(){  
		 return jdbcTemplate.query("select host_name,address,port,protocol,resp_timeout,watch_timeout from peer_config",new ResultSetExtractor<List<Peer>>(){  
		    
		     public List<Peer> extractData(ResultSet rs) throws SQLException,  
		            DataAccessException {  
		      
		        List<Peer> list=new ArrayList<Peer>();  
		        while(rs.next()){  
		        	Peer sh=new Peer();  
		        	sh.setHost_name(rs.getString("host_name")); 
		        	sh.setAddress(rs.getString("address")); 
		        	sh.setPort(rs.getInt("port"));
		        	sh.setProtocol(rs.getString("protocol"));
		        	sh.setResp_timeout(rs.getInt("resp_timeout"));
		        	sh.setWatch_timeout(rs.getInt("watch_timeout"));
		        	
		     System.out.println(sh.getHost_name());
		        list.add(sh);  
		        }  
		        return list;  
		        }  
		    });  
		  }  

		public int createPeer(Peer s){  
		   
		    return jdbcTemplate.update("INSERT INTO peer_config(host_name,address,port,protocol,resp_timeout,watch_timeout) VALUES(?,?,?,?,?,?)",
					s.getHost_name(),s.getAddress(),s.getPort(),s.getProtocol(),s.getResp_timeout(),s.getWatch_timeout());  
		    
	    
		}  
		public int updatePeer(Peer s,String id){

			String query="update peer_config set host_name='"+s.getHost_name()+"',address='"+s.getAddress()+"',port='"+s.getPort()+"',protocol='"+s.getProtocol()+"',resp_timeout='"+s.getResp_timeout()+"',watch_timeout='"+s.getWatch_timeout()+"' where host_name='"+id+"' ";
			System.out.println("query is:"+query);
			return jdbcTemplate.update(query);
			
			
		
		}
		

		public List<Peer> getPeerbyName(String host_name){
		
			return jdbcTemplate.query("select host_name,address,port,protocol,resp_timeout,watch_timeout from peer_config where host_name='"+host_name+"'", new RowMapper<Peer>(){
				public Peer mapRow(ResultSet rs, int row) throws SQLException {
					
					Peer s=new Peer();
				s.setHost_name(rs.getString("host_name"));
				s.setAddress(rs.getString("address"));
				s.setPort(rs.getInt("port"));
				s.setProtocol(rs.getString("protocol"));
				s.setResp_timeout(rs.getInt("resp_timeout"));
				s.setWatch_timeout(rs.getInt("watch_timeout"));
					return s;
				}
				
			});
			
		}
		public int deletePeer(String host_name){
			
			String query="delete from peer_config where host_name='"+host_name+"'";
		System.out.println(host_name);
		
			return jdbcTemplate.update(query);
		}


}
