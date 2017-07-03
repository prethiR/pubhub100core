package com.bookapp_core.dao;


import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bookapp_core.model.Book;
import com.bookapp_core.util.ConnectionUtil;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;


public class BookDAO {
	public void save(Book book) throws Exception
	{		java.sql.Connection connection= ConnectionUtil.getConnection();
	java.sql.PreparedStatement pst=connection.prepareStatement("insert into book(name,price)values(?,?)");
pst.setString(1,book.getName());
pst.setInt(2,book.getPrice());
pst.executeUpdate();

			}
public void update(Book book) throws Exception{		
	java.sql.Connection connection= ConnectionUtil.getConnection();

java.sql.PreparedStatement pst=connection.prepareStatement("update book set name=? where id=?");
pst.setString(1,book.getName());
pst.setInt(2,book.getId());
pst.executeUpdate();
}
public void remove(int id) throws Exception
{
	java.sql.Connection connection=ConnectionUtil.getConnection(); 
	java.sql.PreparedStatement pst=connection.prepareStatement("delete from book where id=?");
	pst.setInt(1, id);
	pst.executeUpdate();
}
public List<Book>   findAll() throws Exception
{
java.sql.Connection connection=ConnectionUtil.getConnection();
java.sql.PreparedStatement pst= connection.prepareStatement("select id,name,price from book");

ResultSet rs=pst.executeQuery();
List<Book> booklist=new ArrayList<Book>();

while(rs.next())
{Book book=new Book();
	book.setId(rs.getInt(1));
	book.setName(rs.getString(2));
	book.setPrice(rs.getInt(3));
	book.add(book);
	
	booklist.add(book);
	
}return booklist;

}
public  Book findById(int id ) throws Exception
{
	java.sql.Connection connection=ConnectionUtil.getConnection();
	java.sql.PreparedStatement pst= connection.prepareStatement("select id,name,price from book where id=?");
	pst.setInt(1,id);
	 ResultSet rs=pst.executeQuery();
	 Book book=new Book();
	 if(rs.next())
	 {
		 book.setId(rs.getInt(1));
		 book.setName(rs.getString(2));
		 book.setPrice(rs.getInt(3));
	 }return book;
	 }
public Book findByName(Book book) throws Exception
{
	java.sql.Connection connection =ConnectionUtil.getConnection();
	java.sql.PreparedStatement pst=connection.prepareStatement("select id,name,price from book where name=?");
	String name = null;
	pst.setString(1,name);
	ResultSet rs=pst.executeQuery();
	if(rs.next())
	{
		book.setId(rs.getInt(1));
book.setName(rs.getString(2));
book.setPrice(rs.getInt(3));
}return book;
}
	
}

