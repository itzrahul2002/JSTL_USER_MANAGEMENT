<%--
  Created by IntelliJ IDEA.
  User: RAHUL THAKUR
  Date: 22-04-2024
  Time: 05:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Delete Student</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h2>Delete Student Data</h2>
    <form action="Std_delete-servlet" method="post">
        <div class="form-group">
            <label for="studentId">Student ID:</label>
            <input type="text" class="form-control" id="studentId" name="studentId">
        </div>
        <button type="submit" class="btn btn-danger">Delete</button>
    </form>
</div>
</body>
</html>
