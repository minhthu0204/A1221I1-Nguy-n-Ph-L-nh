<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Information User</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">

</head>
<body>
<h1>Information User</h1>
<table class="table table-dark table-striped">
  <thead>
  <tr>
    <th scope="col">Id</th>
    <th scope="col">Name</th>
    <th scope="col">Email</th>
    <th scope="col">Address</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${user}" var="listUser" >
    <tr>
      <th ><c:out value="${listUser.getId()}" /></th>
      <td ><c:out value="${listUser.getName()}" /></td>
      <td ><c:out value="${listUser.getEmail()}" /></td>
      <td ><c:out value="${listUser.getAddress()}" /></td>
    </tr>
  </c:forEach>
  </tbody>
</table>
<button type="button" class="btn btn-danger">
  <a href="/user" style="text-decoration: none; color: white">Back To List User</a>
</button>
</body>
</html>
