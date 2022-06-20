<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View customer</title>
</head>
<body>

<h1>View product</h1>
<p>
    <c:if test='${requestScope["message"]}'>
        <span style="color: blue">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="/product" class="badge badge-primary">Back to product</a>
</p>
<p>
<form class="form-group" method="post">
    <label>ID:</label>
    <input type="text" name="id" class="form-control" placeholder="Enter your id:" aria-describedby="helpId">
    <button class="btn btn-primary" type="submit">Find</button>

</form>
</p>
<table class="table">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Description</th>
        <th>Manufacture</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>${requestScope["product"].id}</td>
        <td>${requestScope["product"].name}</td>
        <td>${requestScope["product"].price}</td>
        <td>${requestScope["product"].description}</td>
        <td>${requestScope["product"].manufacturer}</td>
    </tr>
    </tbody>
</table>
</body>
</html>
