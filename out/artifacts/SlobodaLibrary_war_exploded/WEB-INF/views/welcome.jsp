<%--
  Created by IntelliJ IDEA.
  User: semen
  Date: 12.04.2016
  Time: 20:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html;charset=UTF-8; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"/>
<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"/>

<html>
<head>
    <meta http-equiv="CONTENT-TYPE" content="text/html;charset=ISO-8859-1">
    <title>WelcomePage</title>

</head>
<body>
<div class="container">

    Go to <a href="<c:url value='/security/login' />">Login</a>
    <br>


    <h1>Greeting: ${greeting}
        This is a welcome page</h1>
</div>


<div class="generic-container">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">List of All Books </span></div>
        <div class="tablecontainer">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>No.</th>
                    <th>File Name</th>
                    <th>Type</th>
                    <th>Description</th>

                </tr>
                </thead>
                <tbody>
                <c:forEach items="${documents}" var="doc" varStatus="counter">
                    <tr>
                        <td>${counter.index + 1}</td>
                        <td>${doc.name}</td>
                        <td>${doc.type}</td>
                        <td>${doc.description}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>



</div>
</body>
</html>
