package com.StudentManagement;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "Std_UpdateServlet", value = "/Std_Update-servlet")
public class Std_Update extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Connection conn = null;
        PreparedStatement pstmt = null;

        // Retrieve form data
        String studentId = request.getParameter("stdId");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String course = request.getParameter("course");
        String fee = request.getParameter("fee");

        try {
            // Load the MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection to the database
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/firstdatabase","root","2002");

            // Create SQL query to update student data
            String query = "update Student set Name=?,Email=?,Course=?,Course_Fee=? where Student_Id=?";
            pstmt = conn.prepareStatement(query);

            pstmt.setString(1,name);
            pstmt.setString(2,email);
            pstmt.setString(3,course);
            pstmt.setString(4,fee);
            pstmt.setString(5,studentId);

            // Execute the UPDATE
            int rowAffected = pstmt.executeUpdate();
            if(rowAffected >0){
                response.sendRedirect("Std_Home.jsp");
            }else{
                response.sendRedirect("UpdateStudent.jsp?error=notFound");
            }
        }catch (Exception e){
            e.printStackTrace();
            response.sendRedirect("Std_Update.jsp");
        }finally {
            // Close resources
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }


}