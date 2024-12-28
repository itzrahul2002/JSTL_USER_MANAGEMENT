package com.Portfolio;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "L_portfolioServlet", value = "/L_portfolio-servlet")
public class L_portfolio extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String l_name  = request.getParameter("L_name");
        String l_password = request.getParameter("L_password");
        HttpSession session = request.getSession();
        RequestDispatcher dispatcher = null;


        if(l_name==null || l_name.equals(" ")){
            request.setAttribute("status", "invalidUserName");
            dispatcher = request.getRequestDispatcher("L_Portfolio.jsp");
            dispatcher.forward(request,response);
        }
        if(l_password==null || l_password.equals(" ")){
            request.setAttribute("status", "Invalid Password");
            dispatcher = request.getRequestDispatcher("L_Portfolio.jsp");
            dispatcher.forward(request,response);
        }

        Connection conn;
        try{
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection to the database
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/seconddatabase", "root", "2002");

            // Create the SQL INSERT statement
            String sql = "select * from Personal where UserName =? and Password = ? ";

            // Create a PreparedStatement object
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,l_name);
            pstmt.setString(2,l_password);

            ResultSet rs  = pstmt.executeQuery();
            if (rs.next()){
                session.setAttribute("name",rs.getString("UserName"));
                dispatcher = request.getRequestDispatcher("index.jsp");
            }else {
                request.setAttribute("status","failed");
                dispatcher = request.getRequestDispatcher("L_Portfolio.jsp");
            }
            dispatcher.forward(request,response);


        }catch(Exception e){
            e.printStackTrace();
        }
    }


}