package com.bookapp_core.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bookapp_core.model.User;
import com.bookapp_core.util.ConnectionUtil;

public class UserDAO {
	public void register(User user) throws Exception 
	{	Connection connection=ConnectionUtil.getConnection();
	
	 
		PreparedStatement pst = connection.prepareStatement("insert into user_table(name,email,password)values(?,?,?)");
		pst.setString(1,user.getName());
		pst.setString(1,user.getEmail());
		pst.setString(2,user.getPassword());
		pst.executeUpdate();

	
	}
	

	public boolean login(User user) throws Exception
	{
	Connection connection=ConnectionUtil.getConnection();
	PreparedStatement pst=connection.prepareStatement("select name from user_table where email=? and password=?");
	pst.setString(1,user.getEmail());
	pst.setString(2,user.getPassword());
	ResultSet rs=pst.executeQuery();
	boolean flag=false;
	 if(rs.next())
		 
	 {
		 flag=true;
	 }

	 return flag;
	 }
	}
	
	