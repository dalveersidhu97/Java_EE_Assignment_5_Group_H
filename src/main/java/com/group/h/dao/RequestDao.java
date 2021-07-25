package com.group.h.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.group.h.beans.*;

/**
 * 
 * @author Group-H
 * @date 12 July, 2021
 * @description DAO Bean for database operations for User such as register and
 *              login.
 * 
 */

public class RequestDao {
	
	private JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public List<Request> getIssuedBookList() {
		
		return getBookList("select * from Books b inner join Request r on r.bookId=b.bookId and b.Availability=0; ");
	}
	
	public List<Request> getBookList(String sql) {
		try {
			 return template.query(sql, new RowMapper<Request>(){  
				    
				 public Request mapRow(ResultSet rs, int rownumber) throws SQLException {  
			    	
					Request b = new Request();
					b.setBookId(rs.getInt("bookId")); 
					b.setAuthor(rs.getString("Author")); 
					b.setTitle(rs.getString("Title")); 
					b.setPrice(rs.getInt("Price")); 
					b.setAvailabe(rs.getBoolean("Availability")); 
					b.setIssuedTo(rs.getString("IssuedTo"));
					b.setDueDate(rs.getDate("DueDate"));
					return b;
			    }  
			 });
		} catch (Exception  e) {
			e.printStackTrace();
			// null if there is any error
			return null;
		}
	}

	public void issueBook(User u, Request r) {
		// issue the book
		template.execute("insert into Request (issuedBy, bookId, IssuedTo, DueDate) values('"+u.getUserId() + "', '" + r.getBookId()+"', '"+r.getIssuedTo()+"', '"+r.getDueDate()+"')");
		// mark the book as not available
		template.execute("Update Books set Availability=0 where bookId="+r.getBookId());
	}

	public void returnBook(String bookId) {
		// mark the book as available
		template.execute("Update Books set Availability=1 where bookId="+bookId);
		template.execute("delete from Request where bookId="+bookId);
	}

	public JdbcTemplate getTemplate() {
		return template;
	}





}