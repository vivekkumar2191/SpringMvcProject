package org.lenovo.dao;

import javax.sql.DataSource;

import org.lenovo.daoInterface.UserMgtDaoInterface;
import org.lenovo.model.UserMgt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserMgtDao implements UserMgtDaoInterface {
private JdbcTemplate jdbcTemplate;
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
	jdbcTemplate = jdbcTemplate;
}
@Autowired

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate=new JdbcTemplate(dataSource);
		
	}
//@SuppressWarnings("deprecation")
//	public boolean authenticateUser(UserMgt userMgt) {
//	String query="select count(*) from login " +
//			" where uname = ? and password = ?";
//	boolean userExists=false;
//	int rowcount = jdbcTemplate.queryForInt(query,
//			userMgt.getUsername(),userMgt.getPassword(),Integer.class);
//	if(rowcount==1){
//		userExists = true;
//	}
//	return userExists;
//	}
//
//}
@Override
public boolean authenticateUser(UserMgt userMgt) {
	// TODO Auto-generated method stub
	return false;
}
}
