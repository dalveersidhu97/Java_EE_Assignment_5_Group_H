package com.group.h.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.group.h.beans.*;


public class BookDao {
	private JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public void addBook(Book b) {
		template.execute("insert into Books (Author, Title, Price) values('"+b.getAuthor()+"', '"+b.getTitle()+"', '"+b.getPrice()+"');");
	}
	
	public List<Book> getBookList() {
		return getBookList("select * from Books;");
	}
	
	public List<Book> getBookList(String sql) {
		try {
			 return template.query(sql, new RowMapper<Book>(){  
				    
				 public Book mapRow(ResultSet rs, int rownumber) throws SQLException {  
			    	
					Book b = new Book();
					b.setBookId(rs.getInt("bookId")); 
					b.setAuthor(rs.getString("Author")); 
					b.setTitle(rs.getString("Title")); 
					b.setPrice(rs.getInt("Price")); 
					b.setAvailabe(rs.getBoolean("Availability")); 
					return b;
			    }  
			 });
		} catch (Exception  e) {
			e.printStackTrace();
			// null if there is any error
			return null;
		}
	}

}