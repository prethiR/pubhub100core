package com.bookapp_core.dao;

import com.bookapp_core.model.Book;

public class TestBookDAO {

	public static void main(String[] args) {
Book book=new Book();
book.setId(1);
book.setName("rghjuvghpu");
book.setPrice(2453);
BookDAO bookdao=new BookDAO();
try {
	bookdao.save(book);
	bookdao.update(book);
	bookdao.remove(book.getId());
	System.out.println(bookdao.findAll());
	System.out.println(bookdao.findById(book.getId()));
	
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

	}

}
