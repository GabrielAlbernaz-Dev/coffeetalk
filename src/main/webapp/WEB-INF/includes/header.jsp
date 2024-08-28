<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
 <c:url value = "/home" var="homeUrl"></c:url>
 <c:url value = "/login" var="loginUrl"></c:url>
 <c:url value = "/logout" var="logoutUrl"></c:url>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CoffeTalk</title>
</head>
<body>
	<header id="main-header">
		<ul>
			<li>
				<a href="${homeUrl}">Home</a>
			</li>
			<li>
				<a href="${loginUrl}">Login</a>
			</li>
			<li>
				<a href="${logoutUrl}">Logout</a>
			</li>
		</ul>
	</header>