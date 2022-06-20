<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer List</title>
</head>
<body>
<h1>Customers</h1>
<p>
    <a href="/product?action=create">Create new Product</a>
</p>
<p>
    <a href="/product?action=view">View Product</a>
</p>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Description</th>
        <th>Manufacture</th>
        <th>Actions</th>
    </tr>
    <c:forEach items='${requestScope["products"]}' var="product">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>${product.description}</td>
            <td>${product.manufacturer}</td>
            <td><a  href="/product?action=edit&id=${product.id}" role="button" name="Edit">Edit</a>
                <a  href="/product?action=delete&id=${product.id}" onclick="return confirm('Are you sure you want to delete?')" role="button" name="Delete">Delete</a>
            </td>
    </c:forEach>
</table>
</body>
</html>
