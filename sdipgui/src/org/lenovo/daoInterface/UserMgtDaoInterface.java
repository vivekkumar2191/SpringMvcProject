package org.lenovo.daoInterface;

import javax.sql.DataSource;

import org.lenovo.model.UserMgt;

public interface UserMgtDaoInterface {
	public abstract void setDataSource(DataSource dataSource);
	public abstract boolean authenticateUser(UserMgt userMgt);

}
