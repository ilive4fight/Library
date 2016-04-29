<%--
  Created by IntelliJ IDEA.
  User: semen
  Date: 12.04.2016
  Time: 21:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"/>
  <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"/>
  <title>AccessDenied page</title>
</head>
<body>
<strong>${user}</strong>,  not authorized to access this page
<a href="<c:url value="/security/logout" />">Logout</a>
</body>
</html>