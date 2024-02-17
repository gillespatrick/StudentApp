<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="~/../public/css/bootstrap.css" rel="stylesheet">
        <title>List Student</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg bg-primary" data-bs-theme="dark">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">Student App Management</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarColor01">
                    <ul class="navbar-nav me-auto">
                        <li class="nav-item">
                            <a class="nav-link active" href="#">Home

                            </a>
                        </li>

                    </ul>

                </div>
            </div>
        </nav><br><br>

    <center><h1>Students List</h1></center><br><br>

    <div class="container-fluid col-6">

        <table class="table table-hover">
            <thead>
                <tr>

                    <th scope="col">First Name</th>
                    <th scope="col">Last Name</th>
                    <th scope="col">Email</th>
                </tr>
            </thead>
            <c:forEach var="tempStudent" items="${student_list}">
                <tbody>
                    <tr>

                        <td>${tempStudent.firstName}</td>
                        <td>${tempStudent.lastName}</td>
                        <td>${tempStudent.email}</td>

                    </tr>
                </c:forEach>

            </tbody>
        </table>
    </div>
</body>
</html>
