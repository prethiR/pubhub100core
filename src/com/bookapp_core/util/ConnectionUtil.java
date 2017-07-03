package com.bookapp_core.util;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionUtil {
	public static Connection getConnection() throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/users_db","root","prethi");			
		return connection;
	}

}
