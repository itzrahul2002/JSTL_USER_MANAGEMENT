package com.StudentManagement;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "Std_RegisterServlet", value = "/Std_Register-servlet")
public class Std_Register extends HttpServlet {



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            String stdId = request.getParameter("stdId");
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String course = request.getParameter("course");
            String fee = request.getParameter("fee");

        Connection conn = null;

        try{

            //load the MYSQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");


            // Establish the connection to the database
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/firstdatabase","root","2002");

            // Create Sql query
            String query ="insert into Student (Student_Id, Name, Email, Course, Course_Fee) values(?,?,?,?,?)";

            // Create a PreparedStatement Object
            PreparedStatement pstmt = conn.prepareStatement(query);

            // set Parameters Values
            pstmt.setString(1,stdId);
            pstmt.setString(2,name);
            pstmt.setString(3,email);
            pstmt.setString(4,course);
            pstmt.setString(5,fee);

            // Execute the Insert statement
            int rowAffected = pstmt.executeUpdate();

            if(rowAffected>0){
                request.setAttribute("status","success");
            }
            else {
                request.setAttribute("status","failure");
            }

            // Forward the request to the appropriate JSP Page
            request.getRequestDispatcher("Std_Home.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
            request.setAttribute("status","failure");
            request.getRequestDispatcher("Std_Home.jsp").forward(request,response);
        }finally {
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void destroy() {
    }
}