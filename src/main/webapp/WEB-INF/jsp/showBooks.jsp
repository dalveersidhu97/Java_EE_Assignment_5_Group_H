	<%@ page import="java.util.List, java.util.ArrayList, com.group.h.beans.*" %>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
	
	<h2>${title}</h2>
	
     <%
     
     	ArrayList<Book> bookList = (ArrayList<Book>) request.getAttribute("bookList");
     
     	for(Book b : bookList){
     %>		
     		<hr>
     		<p><b>Title:</b> <%=b.getTitle()%></p>
     		<p><b>Author:</b> <%=b.getAuthor()%></p>
     		<p><b>Price:</b> $<%=b.getPrice()%></p>
     		<p><b>Status:</b> <%=b.isAvailabe()?"Available":"Issued"%></p>
     		<p><b>Book ID:</b> <%=b.getBookId()%></p> 
     <%		
     	}
     %>