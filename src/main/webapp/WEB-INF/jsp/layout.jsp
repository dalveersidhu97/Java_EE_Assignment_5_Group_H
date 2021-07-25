
<%@page import="com.group.h.beans.*"  %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<!DOCTYPE html>
<html>

<head>
	<style>
		* {font-family: verdana;text-align: center;}
		input, button {padding: 10px; margin: 10px;}
	</style>
</head>

<body>

<!-- The flexible grid (content) -->
<div class="row">
	<h1>Assignment 5</h1>
  <div class="main">
  	
  	<%if(request.getAttribute("user")!=null) {%>
  		<h3>Logged in as: ${user.name}<br> Role: ${user.role }</h3>
  	<%
  		User user = (User)request.getAttribute("user");
  	
  		if(user.getRole().equals("Librarian")){ // nav for Librarian
  	%>
		<p>
			<a href="/Assignment_5_Group_H/books">All books</a> | 
			<a href="/Assignment_5_Group_H/issuedBooks">All issued books</a> | 
			<a href="/Assignment_5_Group_H/addBook">Add book</a> | 
			<a href="/Assignment_5_Group_H//books/request">Issue a book</a>
		<p>
  	<%	}if(user.getRole().equals("Admin")){ // nav for Admin
	%>
		<p>
			<a href="/Assignment_5_Group_H/books">All books</a> |
			<a href="/Assignment_5_Group_H/issuedBooks">All issued books</a>
		<p>
  	<%	
  		}
  		out.print("<p><a href='/Assignment_5_Group_H/logout'>Logout</a></p>");
  	}%>
    
    <c:forEach var = "view" items="${viewList}">
        <jsp:include page="${view}" />
    </c:forEach>
     
  </div>
</div>

<footer><hr><b>Assignment 5 - Group H <br><br>@Lambton College of Toronto</b></footer>

</body>
</html>
