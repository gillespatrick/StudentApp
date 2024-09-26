
package com.gilles.controller;

import com.gilles.data.StudentData;
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
@WebServlet(name = "deleteStudent", urlPatterns = {"/deleteStudent"})
public class DeleteStudentServlet extends HttpServlet {

    
    
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
            //  response.sendRedirect("students");
            deleteStudent(request, response);
        } catch (Exception ex) {
           ex.printStackTrace();
        }
       
    }
    
    
    
    
    private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
       String StudentId = request.getParameter("id");
         studentData.deleteStudent(StudentId);
         response.sendRedirect("students");

    }

}
