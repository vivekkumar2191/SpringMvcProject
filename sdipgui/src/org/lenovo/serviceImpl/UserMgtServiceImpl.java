package org.lenovo.serviceImpl;

import org.lenovo.daoInterface.UserMgtDaoInterface;
import org.lenovo.model.UserMgt;
import org.lenovo.service.userMgtService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserMgtServiceImpl implements  userMgtService{

@Autowired
private UserMgtDaoInterface userMgtDaoInterface;
	public boolean authenticateUser(UserMgt userMgt) {
		
		return userMgtDaoInterface.authenticateUser(userMgt);
	}

}
