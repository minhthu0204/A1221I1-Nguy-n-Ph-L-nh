<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sandwich</title>
</head>
<body>
<h1>Sandwich</h1>
<form action="save" method="post">
    <input type="checkbox" name="condiment" value="Lecture">Lecture
    <input type="checkbox" name="condiment" value="Tomato">Tomato
    <input type="checkbox" name="condiment" value="Mustard">Mustard
    <input type="checkbox" name="condiment" value="Sprouts">Sprouts
    <br>
    <input type="submit" value="Save">
</form>

<c:if test="${not empty condiment}" >
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
        </tr>
        <c:forEach items="${condiment}" var="c" varStatus="i">
            <tr>
                <td>${i.count}</td>
                <td>${c}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
