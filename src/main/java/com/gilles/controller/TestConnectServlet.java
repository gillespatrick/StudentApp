/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.gilles.controller;

import com.gilles.data.StudentData;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.sql.DataSource;

/**
 *
 * @author gilles
 */
@WebServlet(name = "TestConnectServlet", urlPatterns = {"/test"})
public class TestConnectServlet extends HttpServlet {

    @Resource(name = "jdbc/api")
    private DataSource source;
    private StudentData studentData;

    @Override
    public void init() throws ServletException {
        super.init();

        try {
            studentData = new StudentData(source);
        } catch (Exception e) {
            throw new ServletException();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        response.setContentType("text/plain");

        Connection conn = null;
        Statement stat = null;
        ResultSet result = null;

        try {
            conn = source.getConnection();
            String sql = "select * from student";
            stat = conn.createStatement();
            result = stat.executeQuery(sql);

            while (result.next()) {
                String email = result.getString("email");
                out.println(email);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
