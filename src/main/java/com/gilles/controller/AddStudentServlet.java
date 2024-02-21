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
@WebServlet(name = "addStudent", urlPatterns = {"/addStudent"})
public class AddStudentServlet extends HttpServlet {

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/studentForm.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            addStudent(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void addStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");

        Student student = new Student(firstName, lastName, email);

        studentData.addStudent(student);
        response.sendRedirect("students");
     
    }
    
   

}
