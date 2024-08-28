<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url value="/user" var="addUserUrl"></c:url>

<c:import url="./includes/header.jsp" />
	<c:if test="${createUserError}">
		<h4 style="color:red;">Registration error</h4>
	</c:if>
	
	<c:if test="${createUserSuccess}">
		<h4 style="color:green;">Registration successfully created</h4>
	</c:if>

	<form action="${addUserUrl}" method="post">
		<input type="text" name="username" placeholder="username" required>
		<input type="email" name="email" placeholder="email" required>
		<input type="password" name="password" placeholder="password" required>
		<select name="role">
			<option>Choose your role</option>
		</select>
		<button>Submit</button>  
	</form>
<c:import url="./includes/footer.jsp" />