
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h2>Issuing book</h2>
<hr><br>
<form:form class="form" id="loginForm" modelAttribute="book"
	action="/Assignment_5_Group_H/books/issue" method="post">
	<div>
		<form:label path="bookId"> Enter book id: </form:label>
		<form:input path="bookId" name="bookId" id="username" />
	</div>
	
	<div>
		<form:label path="issuedTo"> Issued to: </form:label>
		<form:input path="issuedTo" name="issuedTo" id="username" />
	</div>
	
	<div>
		<form:label path="dueDate"> Due date: </form:label>
		<form:input type="date" path="dueDate" name="dueDate" id="dueDate" />
	</div>
	
	<div>
		<form:button id="login" name="login">Issue book</form:button>
	</div>

</form:form>
<br>
<center>${message}</center>