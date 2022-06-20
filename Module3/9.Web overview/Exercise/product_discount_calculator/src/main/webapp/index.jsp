<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/14/2022
  Time: 1:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h2>Application Product Calculator</h2>
<form method="post" action="/display-discount">
    <input type="text" placeholder="Product Description" name = "description">
    <input type="number" placeholder="List Price" name="price">
    <input type="number" placeholder="Discount Percent" name = "percent">
    <button type="submit">Calculator</button>
</form>
</body>
</html>