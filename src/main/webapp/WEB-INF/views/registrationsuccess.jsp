<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>


<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Registration Confirmation Page</title>
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>
<body>
	<div class="generic-container">
		<div class="alert alert-success lead">
	    	${success}
		</div>

		<span class="well pull-right">
			<sec:authorize access="hasRole('ADMIN')">
			Go to <a href="<c:url value='/admin' />">Admin Page</a>
			</sec:authorize>
		</span>
		<span class="well pull-left">
			<sec:authorize access="hasRole('USER')">
				Go to <a href="<c:url value='/user' />">Admin Page</a>
			</sec:authorize>
		</span>
	</div>
</body>

</html>