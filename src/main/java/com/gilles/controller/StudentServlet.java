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
import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author gilles
 */
@WebServlet(name = "students", urlPatterns = {"/students"})
public class StudentServlet extends HttpServlet {

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
            listStudents(request, response);
             } catch (Exception ex) {
            ex.printStackTrace();
        }

    }


    private void listStudents(HttpServletRequest request, HttpServletResponse response) throws Exception {

        List<Student> students = studentData.getStudents();
        request.setAttribute("student_list", students);
        this.getServletContext().getRequestDispatcher("/WEB-INF/studentList.jsp").forward(request, response);

    }



}
