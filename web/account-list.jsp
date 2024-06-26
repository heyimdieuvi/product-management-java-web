<%-- 
    Document   : user-form.jsp
    Created on : 24 May 2024, 00:15:03
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Account List</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>

    <%@include file="menu-bar.jsp" %>
        <div class="container">
            <div>
                <h3 class="text-center" style="margin-top: 20px ">                            
                List of User
                </h3> 
                <hr><!-- a line to break content -->
                <a class="btn btn-success" href="<%=request.getContextPath()%>/account-management?action=new">
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
                        <th>First Name</th>
                        <th>BirthDay</th>
                        <th>Gender</th>
                        <th>Phone</th>
                        <th>Activate</th>
                        <th>Role</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="acc" items="${requestScope.listAccount}"> 
                        <tr>
                            <td>
                                <c:out value="${acc.account}"/> 
                            </td>
                            <td>
                                <c:out value="${acc.lastName}"/>
                            </td>
                            <td>
                                <c:out value="${acc.firstName}"/>
                            </td>
                            <td>
                                <c:out value="${acc.birthday}"/>
                            </td>
                            <td>
                                <c:out value="${acc.gender}"/>
                            </td>
                            <td>
                                <c:out value="${acc.phone}"/>
                            </td>
                            <td>
                                <c:out value="${acc.isUse}"/>
                            </td>
                            <td>
                                <c:out value="${acc.roleInSystem}"/>
                            </td>
                            <td>
                                <a class="btn btn-info" href="account-management?action=edit&accName=<c:out value="${acc.account}" />">Edit</a>
                                <a class="btn btn-info" href="account-management?action=delete&accName=<c:out value="${acc.account}"/>">Delete</a>
                            </td>
                        </tr>
                        </c:forEach>
                </tbody>
                </table>
            </div>
        </div>
            
    </body>
</html>
