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
            <center><h1>Student Registration</h1><br><br>
                <a href="students" >
                    <i class="fa-solid fa-backward"></i>   Back to  List</a><br>
            </center><br><br>

           <div class="container-fluid col-8">
                <form action="addStudent" method="POST">
                    <fieldset>
                        <div class="form-group">
                            <input type="text" name="firstName" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="First Name"> <br>
                        </div>
                        <div class="form-group">
                            <input type="text" name="lastName" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Last Name"> <br>
                        </div>
                        <div class="form-group">
                            <input type="email" name="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Email"> <br>
                        </div>
                         <div class="form-group">
                            <button type="submit" class="btn btn-success"><i class="fa-solid fa-floppy-disk"></i> Save</button>
                            <button type="reset" class="btn btn-warning" value="students"><i class="fa-solid fa-rotate-left"></i> Reset</button>
                        </div>
                    </fieldset>
                </form>
            </div>


        </div>
    </body>
</html>
