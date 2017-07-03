package com.bookapp_core.dao;

import com.bookapp_core.model.User;

public class TestUserDAO {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		User user=new User();
		UserDAO userdao=new UserDAO();
		userdao.register(user);}
	{
		User user=new User();
		UserDAO userdao=new UserDAO();
		try {
			userdao.login(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
