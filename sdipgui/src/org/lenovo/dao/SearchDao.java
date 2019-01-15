package org.lenovo.dao;

import org.lenovo.model.Search;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class SearchDao {
	private JdbcTemplate jdbcTemplate;
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public Search getSearchByid(int fieldid){
		String query="select fieldid, shortdesc, longdesctext from fields where fieldid=?";
	    return jdbcTemplate.queryForObject(query, new Object[]{fieldid},new BeanPropertyRowMapper<Search>(Search.class));  
	
	}

}
