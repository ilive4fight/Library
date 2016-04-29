<%--
  Created by IntelliJ IDEA.
  User: semen
  Date: 12.04.2016
  Time: 20:44
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html;charset=UTF-8; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>AdminPage</title>

    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"/>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"/>

</head>
<body>


Helo ${user}, welcome to admin page
<br/>


<br/>

<a href="<c:url value="/security/logout" />">Logout</a>


<br/>

<a href="<c:url value="/user" />">YourUserPage</a>





<div class="generic-container">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead"><h2>List of Users with JSTL</h2> </span></div>
        <div class="tablecontainer">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th>SSO ID</th>
                    <th width="100"></th>
                    <th width="100"></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${users}" var="user">
                    <tr>
                        <td>${user.firstName}</td>
                        <td>${user.lastName}</td>
                        <td>${user.email}</td>
                        <td>${user.ssoId}</td>
                        <td><a href="<c:url value='/user/edit-user-${user.ssoId}' />" class="btn btn-success custom-width">edit</a></td>
                        <td><a href="<c:url value='/user/delete-user-${user.ssoId}' />" class="btn btn-danger custom-width">delete</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <div class="well">
        <a href="<c:url value='/registration' />">Add New User</a>
    </div>
</div>
<table class="data-contacts-js table table-striped">
    <h2>List of Books with jQuery</h2>

    <tr>
        <th>name</th>
        <th>type</th>
        <th>description</th>
    </tr>
</table>
<button id='fetchContacts' onClick="this.disabled='true'" class="btn btn-default" type="submit">GetTableWithAjax
</button>
</body>
</html>
<script type="text/javascript">


    $("#fetchContacts").bind("click", function () {

        $.get("http://localhost:8080/SlobodaLibrary_war_exploded/admin/allUsersBooks", function (data) {

            $.each(data, function (i, book) {

                $(".data-contacts-js").append(
                        "<tr><td>" + book.name + "</td>" +
                        "<td>" + book.type + "</td>" +
                        "<td>" + book.description + "</td></tr>");
            });
        })
    });


</script>


