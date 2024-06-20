<%-- 
    Document   : DashBoard
    Created on : 19 Jun 2024, 16:00:34
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dash Board</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <div>
            <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
                <a href="https://www.w3schools.com/js/js_examples.asp" target="_blank" 
                   class="navbar-brand" style="margin-left: 10px">
                    User Management App</a>
                <a href="<%=request.getContextPath()%>/new" class="nav-link" style="color: white">
                    Users
                </a>
            </nav>
        </div>
        <div class="container">
            <div>
                <h3 class="text-center" style="margin-top: 20px ">                            
                List of User
                </h3> 
                <hr><!-- a line to break content -->
                <a class="btn btn-success" href="<%=request.getContextPath()%>/new">
                    Add New Account
                </a>
            </div>
                    <br>        
            <div>        
                <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>Account</th>
                        <th>Last Name</th>
                        <th>First Name</th><!-- comment -->
                        <th>Birthday</th>
                        <th>Gender</th>
                        <th>Phone</th>
                        <th>Status</th> <!-- isUse -->
                        <th>Role</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="user" items="${requestScope.lisAccount}"> 
                        <tr>
                            <td>
                                <c:out value="${user.account}"/> 
                            </td>
                            <td>
                                <c:out value="${user.lastName}"/>
                            </td>
                            <td>
                                <c:out value="${user.firstName}"/>
                            </td>
                            <td>
                                <c:out value="${user.birthday}"/>
                            </td>
                            <td>
                                <c:out value="${user.gender}"/>
                            </td>
                            <td>
                                <c:out value="${user.phone}"/>
                            </td>
                            <td>
                                <c:out value="${user.isUse}"/>
                            </td>
                            <td>
                                <a class="btn btn-info" href="edit?id=<c:out value="${user.id}" />">Edit</a>
                                <a class="btn btn-info" href="delete?id=<c:out value="${user.id}"/>">Delete</a>
                            </td>
                        </tr>
                        </c:forEach>
                </tbody>
                </table>
            </div>
        </div>
            
    </body>
</html>