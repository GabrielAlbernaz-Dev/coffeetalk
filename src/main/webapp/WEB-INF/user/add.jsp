<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url value="/user" var="addUserUrl"></c:url>

<c:import url="./includes/header.jsp" />
	<form action="${addUserUrl}" method="post" >
		<input type="text" name="username">
		<input type="password" name="password">
		<button>Submit</button>
	</form>
	<a href="${registerUrl}">Don't have any account?</a>
<c:import url="./includes/footer.jsp" />