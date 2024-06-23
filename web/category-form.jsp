<%-- 
    Document   : category-form
    Created on : 23 Jun 2024, 18:19:19
    Author     : ADMIN
--%>

     
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Category Form</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>

<header>
    <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
        <div>
            <a href="https://www.example.com" class="navbar-brand"> Category Management App </a>
        </div>

        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/category-management" class="nav-link">Categories</a></li>
        </ul>
    </nav>
</header>
<br>
<div class="container col-md-5 card">
    <div class="container">
        <h2 class="text-center" style="margin-top: 10px">
            <c:if test="${category != null}">
                Edit Category
            </c:if>
            <c:if test="${category == null}">
                Add New Category
            </c:if>
        </h2>
        <c:if test="${category != null}">
            <form action="category-management?action=update" method="post">
                <input type="hidden" value="${category.typeId}" name="typeId">
                <div class="form-group">
                    <label class="h4">Category Name: </label>
                    <input type="text" class="form-control" value="<c:out value='${category.categoryName}'/>" name="categoryName">
                </div>
                <div class="form-group">
                    <label class="h4">Memo: </label>
                    <input type="text" class="form-control" value="<c:out value='${category.memo}'/>" name="memo">
                </div>
                <button type="submit" class="btn btn-success">Save</button>
            </form>
        </c:if>
        <c:if test="${category == null}">
            <form action="category-management?action=insert" method="post">
                <div class="form-group">
                    <label class="h4">Category Name: </label>
                    <input type="text" class="form-control" name="categoryName">
                </div>
                <div class="form-group">
                    <label class="h4">Memo: </label>
                    <input type="text" class="form-control" name="memo">
                </div>
                <button type="submit" class="btn btn-success">Save</button>
            </form>
        </c:if>
    </div>
</div>

</body>
</html>
