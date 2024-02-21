<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*,com.gilles.data.* ,com.gilles.model.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Update Student</title>
    </head>

    <body>

        <jsp:include page="parts/header.jsp" />

        <div class="container-fluid col-6 ">
            <center><h1>Update Student</h1><br><br>
                <a href="students" >
                    <i class="fa-solid fa-backward"></i>   Back to  List</a><br>
            </center><br><br>

            <div class="container-fluid col-8">
                <form action="updateStudent" method="POST">

                    <input type="hidden" name="id" value="<c:out value='${the_student.id}' />" />



                    <fieldset>
                        <div class="form-group">
                            <input type="text" name="firstName" class="form-control"value="<c:out  value="${the_student.firstName}"/>" placeholder="First Name"> <br>
                        </div>
                        <div class="form-group">
                            <input type="text" name="lastName" class="form-control" value="<c:out  value="${the_student.lastName}"/>" placeholder="Last Name"> <br>
                        </div>
                        <div class="form-group">
                            <input type="email" name="email" class="form-control" value="<c:out  value="${the_student.email}"/>" placeholder="Email"> <br>
                        </div>
                        <div class="form-group">
                            <button type="submit" class="btn btn-success"><i class="fa-solid fa-download"></i>Update</button>

                        </div>
                    </fieldset>
                </form>
            </div>


        </div>
    </body>
</html>
