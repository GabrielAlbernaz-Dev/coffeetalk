<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url value="/register" var="registerUrl"></c:url>

<c:import url="./includes/header.jsp" />
	<form>
		<input type="text" name="username">
		<input type="password" name="password">
		<button>Submit</button>
	</form>
	<a href="${registerUrl}">Don't have any account?</a>
<c:import url="./includes/footer.jsp" />