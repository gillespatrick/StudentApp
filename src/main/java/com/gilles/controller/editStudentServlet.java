
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
@WebServlet(name = "editStudent", urlPatterns = {"/editStudent"})
public class editStudentServlet extends HttpServlet {

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
        try {
            loadStudent(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

   

    private void loadStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String StudentId = request.getParameter("id");

        Student student = studentData.getStudent(StudentId);

        request.setAttribute("the_student", student);

        this.getServletContext().getRequestDispatcher("/WEB-INF/editStudent.jsp").forward(request, response);

    }

   

}
