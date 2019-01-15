package org.lenovo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.lenovo.model.Ntf;
import org.lenovo.model.Sample;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;



public class SampleDao {
private JdbcTemplate jdbcTemplate;



	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
	this.jdbcTemplate = jdbcTemplate;
}



      public List<Sample> creationId(){  
		 return jdbcTemplate.query("select fieldid from fields order by fieldid DESC limit 1",new ResultSetExtractor<List<Sample>>(){  
		    
		     public List<Sample> extractData(ResultSet rs) throws SQLException,  
		            DataAccessException {  
		      
		        List<Sample> list=new ArrayList<Sample>();  
		        while(rs.next()){  
		        	Sample sh=new Sample();  
		        	sh.setFieldid(rs.getInt("fieldid"));
		    
		        list.add(sh);  
		        }  
		        return list;  
		        }  
		    });  
		  }  
      
      
      
      
  	public int createSample(Sample s){  
	    String query="insert into route_config (realm,dest_host) values(   '"+s.getRealm()+"','"+s.getDest_host()+"')";  
	    return jdbcTemplate.update(query);  
	}  

  	
	public int updateSample(Sample s,String id){

  String query="update route_config set realm='"+s.getRealm()+"',dest_host='"+s.getDest_host()+"' where realm='"+id+"'"  ;
  System.out.println(query);
	return jdbcTemplate.update(query);

	}
	
	public int deleteSample(String id){
		String query="delete from route_config where realm='"+id+"'";
		return jdbcTemplate.update(query);
	}

	public List<Sample> getSample(){  
		 return jdbcTemplate.query("select * from route_config",new ResultSetExtractor<List<Sample>>(){  
		    
		     public List<Sample> extractData(ResultSet rs) throws SQLException,  
		            DataAccessException {  
		      
		        List<Sample> list=new ArrayList<Sample>();  
		        while(rs.next()){  
		        	Sample sh=new Sample();  
/*		        	sh.setFieldid(rs.getInt("fieldid"));
		     sh.setShortdesc(rs.getString("shortdesc")); 
	
		     sh.setLongdesctext(rs.getString("longdesctext"));
*/		     
		        	sh.setRealm(rs.getString("realm"));
		        	sh.setDest_host(rs.getString("dest_host"));
		        	list.add(sh);  
		        }  
		        return list;  
		        }  
		    });  
		  }  
	
	
	
	public List<Sample> getSamplebyId(String realm){
		
		return jdbcTemplate.query("select * from route_config where realm='"+realm+"'", new RowMapper<Sample>(){
			public Sample mapRow(ResultSet rs, int row) throws SQLException {
				
				Sample s=new Sample();
				s.setRealm(rs.getString("realm"));;
			    s.setDest_host(rs.getString("dest_host"));

               
				return s;
			}
			
		});
		
	}


        
            public List<Sample> nextpageid(){  
		 return jdbcTemplate.query("select fieldid,shortdesc from fields  ",new ResultSetExtractor<List<Sample>>(){  
		    
		     public List<Sample> extractData(ResultSet rs) throws SQLException,  
		            DataAccessException {  
		      
		        List<Sample> list=new ArrayList<Sample>();  
		        while(rs.next()){  
		        	Sample sh=new Sample();  
		        	sh.setFieldid(rs.getInt("fieldid"));
                                sh.setShortdesc(rs.getString("shortdesc"));
                          
		    
		        list.add(sh);  
		        }  
		        return list;  
		        }  
		    });  
		  }
 

 public List<Sample> notifyLeftTable(){  
		 return jdbcTemplate.query("select fieldid,shortdesc,fieldtypeid,languageid,sourceid,condid from fields where fieldid>=0  ",new ResultSetExtractor<List<Sample>>(){  
		    
		     public List<Sample> extractData(ResultSet rs) throws SQLException,  
		            DataAccessException {  
		      
		        List<Sample> list1=new ArrayList<Sample>();  
		        while(rs.next()){  
		        	Sample sample1=new Sample();  
		        	sample1.setFieldid(rs.getInt("fieldid"));
                             sample1.setShortdesc(rs.getString("shortdesc"));
                             sample1.setFieldtypeid(rs.getInt("fieldtypeid"));
                             sample1.setLanguageid(rs.getInt("languageid"));
                             sample1.setSourceid(rs.getInt("sourceid"));
                             sample1.setCondid(rs.getInt("condid"));
		    
		        list1.add(sample1);
                       
		        }  
		        return list1;  
		        }  
		    });  
		  }
 
// public List<Sample> eventtab5(){  
//	 return jdbcTemplate.query("select fieldid,shortdesc,fieldtypeid,languageid,sourceid,condid from fields where fieldid>=2 AND languageid='$lang_id' ",new ResultSetExtractor<List<Sample>>(){  
//	    
//	     public List<Sample> extractData(ResultSet rs) throws SQLException,  
//	            DataAccessException {  
//	      
//	        List<Sample> list1=new ArrayList<Sample>();  
//	        while(rs.next()){  
//	        	Sample sample1=new Sample();  
//	        	sample1.setFieldid(rs.getInt("fieldid"));
//                         sample1.setShortdesc(rs.getString("shortdesc"));
//                         sample1.setFieldtypeid(rs.getInt("fieldtypeid"));
//                         sample1.setLanguageid(rs.getInt("languageid"));
//                         sample1.setSourceid(rs.getInt("sourceid"));
//                         sample1.setCondid(rs.getInt("condid"));
//	    
//	        list1.add(sample1);
//                   
//	        }  
//	        return list1;  
//	        }  
//	    });  
//	  }
 
 
     public List<Sample> notifyRightTable(){  
		 return jdbcTemplate.query("select fieldid,shortdesc,fieldtypeid,languageid,sourceid,condid from fields  ",new ResultSetExtractor<List<Sample>>(){  
		    
		     public List<Sample> extractData(ResultSet rs) throws SQLException,  
		            DataAccessException {  
		      
		        List<Sample> list2=new ArrayList<Sample>();  
		        while(rs.next()){  
		        	Sample sample=new Sample();  
		        	sample.setFieldid(rs.getInt("fieldid"));
                                sample.setShortdesc(rs.getString("shortdesc"));
                                sample.setFieldtypeid(rs.getInt("fieldtypeid"));
                             sample.setLanguageid(rs.getInt("languageid"));
                             sample.setSourceid(rs.getInt("sourceid"));
                             sample.setCondid(rs.getInt("condid"));
                                list2.add(sample);
                         
		    
		          
		        }  
		        return list2;  
		        }  
		    });  
		  }     
     public List<Sample> notifyLanguageSelection(Ntf lang){  
    	 String query="select fieldid,shortdesc,fieldtypeid,languageid,sourceid,condid from fields where languageid='"+lang.getLang()+"' and fieldid>0";
		 return jdbcTemplate.query(query,new ResultSetExtractor<List<Sample>>(){  
		    
		     public List<Sample> extractData(ResultSet rs) throws SQLException,  
		            DataAccessException {  
		      
		        List<Sample> notifyList=new ArrayList<Sample>();  
		        while(rs.next()){  
		        	Sample sample1=new Sample();  
		        	sample1.setFieldid(rs.getInt("fieldid"));
                             sample1.setShortdesc(rs.getString("shortdesc"));
                             sample1.setFieldtypeid(rs.getInt("fieldtypeid"));
                             sample1.setLanguageid(rs.getInt("languageid"));
                             System.out.println(rs.getInt("languageid"));
                             sample1.setSourceid(rs.getInt("sourceid"));
                             sample1.setCondid(rs.getInt("condid"));
		    
                             notifyList.add(sample1);
                       
		        }  
		        return notifyList;  
		        }  
		    });  
		  }

        
}
