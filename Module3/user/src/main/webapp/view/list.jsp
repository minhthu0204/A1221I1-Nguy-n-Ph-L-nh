<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>List User</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
<body>
<h1 style="font-family: Arial">LIST USER</h1>
<table class="table table-dark table-striped">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Name</th>
        <th scope="col">Email</th>
        <th scope="col">Address</th>
        <th scope="col">Edit</th>
        <th scope="col">Delete</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="listUser" >
        <tr>
            <th ><c:out value="${listUser.getId()}" /></th>
            <td ><c:out value="${listUser.getName()}" /></td>
            <td ><c:out value="${listUser.getEmail()}" /></td>
            <td ><c:out value="${listUser.getAddress()}" /></td>
            <td><button type="button" class="btn btn-warning"><a href="/user?action=updateByProcedure&id=${listUser.getId()}" style="text-decoration: none; color: white ">Edit</a></button></td>
            <td><button type="button" class="btn btn-danger"><a href="/user?action=deleteByProcedure&id=${listUser.getId()}" style="text-decoration: none; color: white" >Delete</a></button></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<!--Create new user -->
<button type="button" class="btn btn-danger" style="display: inline-block">
    <a style="text-decoration:none;color: white; " id="create" href="/user?action=create">Create New User</a>
</button>
<!--Sort user by name -->
<form action="/user" method="get" style="display: inline-block">
    <input name="action" value="sort" type="submit" class="btn btn-danger">
</form>
<!--Insert user by storedProducer -->
<form action="/user" method="get" style="display: inline-block">
    <input type="submit" class="btn btn-danger" name="action" value="insertByStored">
</form>
<!--Create new user -->
<form action="/user" method="get" style="display: inline-block">
    <input type="submit" class="btn btn-danger" name="action" value="permision">
</form>
<!--Create new user -->
<form action="/user" method="get" style="display: inline-block">
    <input type="submit" class="btn btn-danger" name="action" value="test-without-tran">
</form>
<!--Search by address -->
<form action="/user" method="get">
    <input  type="text" name="search1" placeholder="Enter Address">
    <input type="submit" class="btn btn-danger" name="action" value="search">
</form>
<!--Search by id User -->
<form action="/user" method="get">
    <input  type="number" name="id" placeholder="Enter Id">
    <input type="submit" class="btn btn-danger" name="action" value="searchByNumber">
</form>
</body>
</html>