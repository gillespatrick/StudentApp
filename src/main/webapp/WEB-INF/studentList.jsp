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

        <div class="container-fluid col-8 ">
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
                        <th scope="col">Action</th>
                    </tr>
                </thead>


                <tbody>

                    <c:forEach var="tempStudent" items="${student_list}">

                        <tr>

                            <td><c:out  value="${tempStudent.firstName}"/></td>
                            <td><c:out  value="${tempStudent.lastName}"/></td>
                            <td><c:out  value="${tempStudent.email}"/></td>

                            <td><a href="editStudent?id=<c:out value='${tempStudent.id}' />"> <i class="fa-solid fa-pencil" ></i></a>
                                | <a  href="deleteStudent?id=<c:out value='${tempStudent.id}' />"
                                      onclick="if (!(confirm ('Are you sure you want to delete the student ${tempStudent.firstName} ${tempStudent.lastName}'))) return false"
                                      > <i class="fa-solid fa-trash" style="color: red"></i> </a>
                            </td>

                        </tr>

                    </c:forEach>


                </tbody>
            </table>





        </div>
    </body>
</html>

<%-- 



            <table class="table table-hover">
                <thead>
                    <tr>

                        <th scope="col">First Name</th>
                        <th scope="col">Last Name</th>
                        <th scope="col">Email</th>
                        <th scope="col">Action</th>
                    </tr>
                </thead>
                <% for (Student tempStudent : theStudents) {%>

                <c:url var="tempLink" value="editStudent">
                  <c:param name="id" value="editStudent"/> 
                    <c:param name="id" value="${tempStudent.id}"/>

                </c:url>
                <tbody>
                    <tr>

                        <td><%= tempStudent.getFirstName() %></td>
                        <td><%= tempStudent.getLastName() %></td>
                        <td><%= tempStudent.getEmail() %></td>
                        <td><a href="${tempLink}"> <i class="fa-solid fa-pencil" ></i></a>
<!--                            | <a href="${tempLink}"> <i class="fa-solid fa-trash" style="color: red"></i> </a>-->
                        </td>

                    </tr>


                </tbody>
                <% } %>
            </table>

--%>