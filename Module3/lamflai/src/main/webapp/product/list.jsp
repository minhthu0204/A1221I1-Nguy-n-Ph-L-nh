<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<table class="table">
    <h1>Customers</h1>
    <p>
        <a href="/product?action=create">Create new Product</a>
    </p>
    <p>
        <a href="/product?action=view">View Product</a>
    </p>
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Description</th>
        <th>Manufacturer</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="product" items= "${products}">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>${product.description}</td>
            <td>${product.manufacturer}</td>
            <td>
                <a class="btn btn-primary"  href="/product?action=edit&id=${product.id}" role="button" name="Edit" >Edit</a>
                <a class="btn btn-danger" href="/product?action=delete&id=${product.id}" onclick="return confirm('Are you sure you want to delete?')" role="button" name="Delete">Delete</a>
            </td>
        </tr>
    </c:forEach>

    </tbody>
</table>
</body>
</html>

