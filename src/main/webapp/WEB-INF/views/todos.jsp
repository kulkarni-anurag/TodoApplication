<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Todo Application - Add / Update Todo</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.min.css" integrity="sha512-mSYUmp1HYZDFaVKK//63EcZq4iFWFjxSL+Z3T/aCt4IO9Cejm03q3NKKYN6pFQzY0SBOr8h+eCIAZHPXcpZaNw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
    <%@ include file="common/navbar.jspf" %>
    <div class="container">
        <h2 class="text-center mt-5">Add / Update Todo Page</h2>
        <br />
        <div class="row justify-content-center">
            <div class="card col-md-8">
                <div class="card-body">
                    <form:form method="post" modelAttribute="todo">
                        <div class="form-group">
                            <form:hidden path="id" />
                        </div>
                        <div class="form-group">
                            <form:label path="description">Enter Todo Description:</form:label>
                            <form:textarea path="description" class="form-control" required="true" placeholder="Enter Description"></form:textarea>
                            <form:errors path="description" cssClass="text-danger" />
                        </div>
                        <div class="form-group">
                            <form:input type="text" path="targetDate" class="form-control" id="targetDate" required="true" placeholder="Select Date" />
                            <form:errors path="targetDate" cssClass="text-warning" />
                        </div>
                        <div class="form-group">
                            <button type="submit" class="btn btn-success">Submit</button>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js" integrity="sha512-T/tUfKSV1bihCnd+MxKD0Hm1uBBroVYBOYSk1knyvQ9VyZJpc/ALb4P0r6ubwVPSGB2GvjeoMAJJImBG12TiaQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <script type="text/javascript">
        $("#targetDate").datepicker({
            format: 'dd/mm/yyyy'
        });
    </script>
</body>
</html>