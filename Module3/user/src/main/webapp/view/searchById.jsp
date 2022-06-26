<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <tr>
        <th >${listUser.getId()}</th>
        <td >${listUser.getName()} </td>
        <td >${listUser.getEmail()} </td>
        <td >${listUser.getAddress()}</td>
    </tr>
    </tbody>
</table>
<button type="button" class="btn btn-danger">
    <a href="/user" style="text-decoration: none; color: white">Back To List User</a>
</button>
</body>
</html>
