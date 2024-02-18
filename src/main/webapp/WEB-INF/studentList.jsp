<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*,com.gilles.data.* ,com.gilles.model.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
      <title>List Student</title>
    </head>
    <%
        List<Student> theStudents = (List<Student>)request.getAttribute("student_list");
    %>
    <body>
       <jsp:include page="parts/header.jsp" />

        <div class="container-fluid col-6 ">
            <center><h1>Students List</h1><br><br>
                <a href="addStudent" >
                    <i class="fa-solid fa-user-plus"></i> Add Student</a><br>
                   </center><br><br>

        <table class="table table-hover">
            <thead>
                <tr>

                    <th scope="col">First Name</th>
                    <th scope="col">Last Name</th>
                    <th scope="col">Email</th>
                </tr>
            </thead>
            <% for (Student tempStudent : theStudents) {%>
            <tbody>
                <tr>

                    <td><%= tempStudent.getFirstName() %></td>
                    <td><%= tempStudent.getLastName() %></td>
                    <td><%= tempStudent.getEmail() %></td>

                </tr>


            </tbody>
            <% } %>
        </table>


    </div>
</body>
</html>
