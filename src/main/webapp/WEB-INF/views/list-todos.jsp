<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Todo Application - List Todos</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
    <%@ include file="common/navbar.jspf" %>
    <div class="container">
        <h2 class="text-center mt-5">Todos Page</h2>
        <br />
        <!-- <h5>Yo! ${username}</h5> -->
        <br />
        <table class="table table-bordered table-striped">
            <caption>Your Todos are:</caption>
            <thead class="thead">
                <tr>
                    <th>Todo Id</th>
                    <th>Description</th>
                    <th>Target Date</th>
                    <th>isDone</th>
                    <th>Update</th>
                    <th>Delete</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${todos}" var="todo">
                    <tr>
                        <td>${todo.id}</td>
                        <td>${todo.description}</td>
                        <td>${todo.targetDate}</td>
                        <td>${todo.done}</td>
                        <td><a href="/update-todo?id=${todo.id}" class="btn btn-info">Update</a></td>
                        <td><a href="/delete-todo?id=${todo.id}" class="btn btn-danger">Delete</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href="/add-todo" class="btn btn-primary">Add Todo</a>
        <br />
        <br />
    </div>
</body>
</html>