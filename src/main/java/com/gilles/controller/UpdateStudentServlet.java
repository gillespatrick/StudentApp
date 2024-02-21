package com.gilles.controller;

import com.gilles.data.StudentData;
import com.gilles.model.Student;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.sql.DataSource;

/**
 *
 * @author gilles
 */
@WebServlet(name = "updateStudent", urlPatterns = {"/updateStudent"})
public class UpdateStudentServlet extends HttpServlet {

    @Resource(name = "jdbc/api")
    private DataSource source;
    private StudentData studentData;
    
     @Override
    public void init() throws ServletException {
        super.init();

        try {
            studentData = new StudentData(source);
        } catch (Exception exc) {
            throw new ServletException(exc);
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            updateStudent(request, response);
           

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {

        int id = Integer.parseInt(request.getParameter("id"));

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");

        Student theStudent = new Student(id, firstName, lastName, email);
        studentData.updateStudent(theStudent);
        response.sendRedirect("students");

    }

}
