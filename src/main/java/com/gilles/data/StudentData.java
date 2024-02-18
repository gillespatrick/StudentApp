package com.gilles.data;

import com.gilles.model.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import java.sql.Statement;

/**
 * @author gilles
 */
public class StudentData {

    private DataSource source;

    public StudentData(DataSource theDataSource) {
        this.source = theDataSource;
    }

    public List<Student> getStudents() throws Exception {

        List<Student> students = new ArrayList<>();

        Connection conn = null;
        Statement stat = null;
        ResultSet result = null;

        try {
            conn = source.getConnection();
            String sql = "select * from student order by last_name";
            stat = conn.createStatement();
            result = stat.executeQuery(sql);

            while (result.next()) {
                int id = result.getInt("id");
                String firstName = result.getString("first_name");
                String lastName = result.getString("last_name");
                String email = result.getString("email");

                Student tempStudent = new Student(id, firstName, lastName, email);

                students.add(tempStudent);
            }

            return students;
        } finally {
            close(conn, result, stat);

        }

    }

    private void close(Connection conn, ResultSet result, Statement stat) {
        try {

            if (result != null) {
                result.close();
            }
            if (stat != null) {
                stat.close();
            }
            if (conn != null) {
                conn.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void addStudent(Student student) throws Exception{
        Connection conn = null;
        PreparedStatement  myStat = null;
        
        try {
            conn = source.getConnection();
            
            String sql = "insert into student"
                    +"(first_name,last_name,email)"
                    +"values(?,?,?)";
            
            myStat = conn.prepareStatement(sql);
            
            myStat.setString(1, student.getFirstName());
            myStat.setString(2, student.getLastName());
            myStat.setString(3, student.getEmail());
            
            myStat.execute();
        } finally  {
            close(conn, null, myStat);
        }
        
    }

}
