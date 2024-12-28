package com.StudentManagement;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "Std_deleteServlet", value = "/Std_delete-servlet")
public class Std_delete extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            // Retrieve student ID from the form
            String studentId = request.getParameter("studentId");

        Connection conn = null;
        PreparedStatement pstmt = null;

        try{
            // load the Mysql JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection to the database
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/firstdatabase","root","2002");

            // Create SQL query to delete student data based on student ID
            String query = "Delete from Student Where Student_Id=?";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, studentId);

            // Execute the Query
            int rowAffected = pstmt.executeUpdate();
            if(rowAffected > 0){
                response.sendRedirect("Std_Home.jsp");
            }
            else {
                response.sendRedirect("DeleteStudent.jsp?error=notfound");
            }

        }catch (Exception e){
            e.printStackTrace();
            response.sendRedirect("DeleteStudent.jsp?error=internal");
        }finally {
            try {
                conn.close();
                pstmt.close();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }
}