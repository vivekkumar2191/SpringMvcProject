package org.lenovo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.lenovo.model.Sample;

import org.lenovo.model.Text_Helper;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class TextDao {
 
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate template){
		this.jdbcTemplate=template;
	}
	
	public int saveText(Text_Helper t){
		String query="insert into fields(fieldid,languageid,shortdesc,longdesctext) values('"+t.getFieldid()+"', '"+t.getLanguageid()+"', '"+t.getShortdesc()+"','"+t.getLongdesctext()+"')";
		return jdbcTemplate.update(query);
	}
	
	public int updateText(Text_Helper t){
		String query="update fields set fieldid='"+t.getFieldid()+"', languageid='"+t.getLanguageid()+"',shortdesc='"+t.getShortdesc()+"',longdesctext='"+t.getLongdesctext()+"' where fieldid='"+t.getFieldid()+"'" ;
        return jdbcTemplate.update(query);
	}
	
	public int deleteText(int fieldid){
		String query="delete from fields where fieldid='"+fieldid+"'";
		return jdbcTemplate.update(query);
	}
        
	public List<Text_Helper> getTextByid(int fieldid){
	
        return jdbcTemplate.query("select fieldid,languageid,shortdesc,longdesctext from fields where fieldid='"+fieldid+"'", new RowMapper<Text_Helper>(){
			public Text_Helper mapRow(ResultSet rs, int row) throws SQLException {
				
				Text_Helper th=new Text_Helper();
                       th.setFieldid(rs.getInt("fieldid"));
                       th.setLanguageid(rs.getString("languageid"));
                       th.setShortdesc(rs.getString("shortdesc"));
                       th.setLongdesctext(rs.getString("longdesctext"));
                        return th;
                        }
			
		});
        }
        
	
	public List<Text_Helper> getText(){
		return jdbcTemplate.query("select * from fields", (ResultSet rs, int row) -> {
                    Text_Helper t=new Text_Helper();
                    int lang=rs.getInt("languageid");
                    String language=String.valueOf(lang);
                    if(language.equals("1")){
                        language="English";
                    }
                    else if(language.equals("0")){
                        language="Spanish";
                    }
                    t.setFieldid(rs.getInt("fieldid"));
                    t.setLanguageid(language);
                    t.setShortdesc(rs.getString("shortdesc"));
                    t.setLongdesctext(rs.getString("longdesctext"));
                    return t;
                });
		
	}
	
	
	
}
