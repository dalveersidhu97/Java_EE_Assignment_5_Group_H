		
				<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
		
		<h2>Add book</h2>
		<hr>
		<form:form class="form" id="addForm" modelAttribute="book" action="addBookProcess" method="post">
			<div>
				<form:label path="author"> Author: </form:label></td>
				<form:input path="author" name="author" id="author" />
			</div>
			<div>
				<form:label path="title"> Book title:</form:label>
				<form:input path="title" name="title" id="title" />
			</div>
			
			<div>
				<form:label path="price"> Book price:</form:label>
				<form:input path="price" name="price" id="price" />
			</div>
		
			
			<div>
				<form:button id="login" name="login">Add book</form:button>
			</div>
			
		</form:form>
		<br>
		<center>${message}</center>