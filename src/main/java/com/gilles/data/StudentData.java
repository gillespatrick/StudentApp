package com.gilles.data;

import com.gilles.model.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    public void addStudent(Student student) throws Exception {
        Connection conn = null;
        PreparedStatement myStat = null;

        try {
            conn = source.getConnection();

            String sql = "insert into student"
                    + "(first_name,last_name,email)"
                    + "values(?,?,?)";

            myStat = conn.prepareStatement(sql);

            myStat.setString(1, student.getFirstName());
            myStat.setString(2, student.getLastName());
            myStat.setString(3, student.getEmail());

            myStat.execute();
        } finally {
            close(conn, null, myStat);
        }

    }

    public Student getStudent(String theStudentId) throws Exception {

        Student theStudent = null;
        Connection conn = null;
        PreparedStatement myStat = null;
        ResultSet result = null;
        //  int studentId;
        int id;

        try {
            id = Integer.parseInt(theStudentId);

            conn = source.getConnection();

            String sql = "select * from student where id =?";
            myStat = conn.prepareStatement(sql);
            myStat.setInt(1, id);

            result = myStat.executeQuery();

            if (result.next()) {
                String firstName = result.getString("first_name");
                String lastName = result.getString("last_name");
                String email = result.getString("email");

                theStudent = new Student(id, firstName, lastName, email);
            } else {
                throw new Exception("The student with id " + id + " not found");
            }

            return theStudent;
        } finally {
            close(conn, result, myStat);
        }
    }

    public void updateStudent(Student student) throws Exception {

        Connection conn = null;
        PreparedStatement myStat = null;
        try {
            conn = source.getConnection();

            String sql = "update student set first_name=?, last_name=?, email=? where id=?;";
            myStat = conn.prepareStatement(sql);

            myStat.setString(1, student.getFirstName());
            myStat.setString(2, student.getLastName());
            myStat.setString(3, student.getEmail());
            myStat.setInt(4, student.getId());

            myStat.execute();
        } finally {
            close(conn, null, myStat);
        }
    }

    public void deleteStudent(String StudentId) throws Exception {

        Connection conn = null;
        PreparedStatement myStat = null;

        try {
            int studentId = Integer.parseInt(StudentId);

            conn = source.getConnection();

            String sql = "delete from student where id = ?;";

            myStat = conn.prepareStatement(sql);

            myStat.setInt(1, studentId);
            myStat.executeUpdate();
        } finally {
            close(conn, null, myStat);
        }
      

    }

}
