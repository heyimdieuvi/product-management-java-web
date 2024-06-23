<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
    <title>Account Management</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>

<body>

    <%@include file="menu-bar.jsp" %>
            
    <br>
    <div class="container col-md-5 card">
        <div class="container">
            <h2 class="text-center" style="margin-top: 10px">
                <c:if test="${account != null}">
                    Edit User
                </c:if>
                <c:if test="${account == null}">
                    Add New User
                </c:if>
            </h2>
            <c:if test="${account != null}">
                <form action="account-management" method="post">
                    <input type="hidden" value="${account.account}" name="account">
                    <div class="form-group">
                        <label class="h4">Password: </label>
                        <input type="password" class="form-control" value="<c:out value="${account.pass}"/>" name="pass">
                    </div>
                    <div class="form-group">
                        <label class="h4">Last Name: </label>
                        <input type="text" class="form-control" value="<c:out value="${account.lastName}"/>" name="lastName">
                    </div>
                    <div class="form-group">
                        <label class="h4">First Name: </label>
                        <input type="text" class="form-control" value="<c:out value="${account.firstName}"/>" name="firstName">
                    </div>
                    <div class="form-group">
                        <label class="h4">BirthDay: </label>
                        <input type="date" class="form-control" value="<c:out value="${account.birthday}"/>" name="birthday">
                    </div>
                    <div class="form-group">
                        <label class="h4">Gender: </label>
                        <select class="form-control" name="gender">
                            <option value="true" <c:if test="${account.gender}">selected</c:if>>Male</option>
                            <option value="false" <c:if test="${!account.gender}">selected</c:if>>Female</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label class="h4">Phone: </label>
                        <input type="text" class="form-control" value="<c:out value="${account.phone}"/>" name="phone">
                    </div>
                    <div class="form-group">
                        <label class="h4">Activate: </label>
                        <select class="form-control" name="isUse">
                            <option value="true" <c:if test="${account.isUse}">selected</c:if>>Active</option>
                            <option value="false" <c:if test="${!account.isUse}">selected</c:if>>Inactive</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label class="h4">Role: </label>
                        <input type="number" class="form-control" value="<c:out value="${account.roleInSystem}"/>" name="roleInSystem">
                    </div>
                    <button type="submit" name="action" value="update" class="btn btn-success">Save</button>
                </form>
            </c:if>
            <c:if test="${account == null}">
                <form action="account-management" method="post">
                    <div class="form-group">
                        <label class="h4">Account: </label>
                        <input type="text" class="form-control" name="account">
                    </div>
                    <div class="form-group">
                        <label class="h4">Password: </label>
                        <input type="password" class="form-control" name="pass">
                    </div>
                    <div class="form-group">
                        <label class="h4">Last Name: </label>
                        <input type="text" class="form-control" name="lastName">
                    </div>
                    <div class="form-group">
                        <label class="h4">First Name: </label>
                        <input type="text" class="form-control" name="firstName">
                    </div>
                    <div class="form-group">
                        <label class="h4">BirthDay: </label>
                        <input type="date" class="form-control" name="birthday">
                    </div>
                    <div class="form-group">
                        <label class="h4">Gender: </label>
                        <select class="form-control" name="gender">
                            <option value="true">Male</option>
                            <option value="false">Female</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label class="h4">Phone: </label>
                        <input type="text" class="form-control" name="phone">
                    </div>
                    <div class="form-group">
                        <label class="h4">Activate: </label>
                        <select class="form-control" name="isUse">
                            <option value="true">Active</option>
                            <option value="false">Inactive</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label class="h4">Role: </label>
                        <input type="number" class="form-control" name="roleInSystem">
                    </div>
                    <button type="submit" name="action" value="insert" class="btn btn-success">Save</button>
                </form>
            </c:if>
        </div>
    </div>

</body>

</html>
