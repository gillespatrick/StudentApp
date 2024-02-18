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
            String theCommand = request.getParameter("command");

            if (theCommand == null) {
                theCommand = "students";
            }

            switch (theCommand) {
                case "students":
                    listStudents(request, response);
                    break;

                case "addStudent":
                    addStudent(request, response);
                    break;

                default:
                    listStudents(request, response);
            }

        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    private void listStudents(HttpServletRequest request, HttpServletResponse response) throws Exception {

        List<Student> students = studentData.getStudents();
        request.setAttribute("student_list", students);
        this.getServletContext().getRequestDispatcher("/WEB-INF/studentList.jsp").forward(request, response);

    }

    private void addStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
       String firstName = request.getParameter("firstName");
       String lastName = request.getParameter("lastName");
       String email = request.getParameter("email");
       
       Student student = new Student(firstName, lastName, email);
       
       studentData.addStudent(student);
       
        listStudents(request, response);
        
        this.getServletContext().getRequestDispatcher("/WEB-INF/studentForm.jsp").forward(request, response);
    }

}
