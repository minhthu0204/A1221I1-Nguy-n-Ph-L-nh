<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <thead>
    <th>Name</th>
    <th>Birthday</th>
    <th>Address</th>
    <th>Avatar</th>
    </thead>
    <c:forEach var="c" items="${customers}" >
    <tr>
        <td class="no">${no.count}</td>
        <td>${c.name}</td>
        <td>${c.birthday}</td>
        <td>${c.address}</td>
        <td>
            <img src="${c.imgPath}">
        </td>
    </tr>
    </c:forEach>
</body>
</html>
