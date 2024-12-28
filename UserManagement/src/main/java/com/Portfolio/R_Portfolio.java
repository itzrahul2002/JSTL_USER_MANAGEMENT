package com.Portfolio;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(name = "R_PortfolioServlet", value = "/R_Portfolio-servlet")
public class R_Portfolio extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("Uname");
        String password = request.getParameter("Password");
        String email = request.getParameter("Email");
        String mobile = request.getParameter("Mobile");

        Connection conn = null;
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection to the database
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/seconddatabase", "root", "2002");

            // Create the SQL INSERT statement
            String sql = "INSERT INTO Personal (UserName, Password, Email, Mobile) VALUES (?, ?, ?, ?)";

            // Create a PreparedStatement object
            PreparedStatement pstmt = conn.prepareStatement(sql);

            // Set parameter values
            pstmt.setString(1, name);
            pstmt.setString(2, password);
            pstmt.setString(3, email);
            pstmt.setString(4, mobile);

            // Execute the INSERT statement
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                // If insertion was successful
                request.setAttribute("status", "success");
            } else {
                // If no rows were affected
                request.setAttribute("status", "failure");
            }

            // Forward the request to the appropriate JSP page
            request.getRequestDispatcher("L_Portfolio.jsp").forward(request, response);

        } catch (ClassNotFoundException | SQLException e) {
            // Handle any exceptions
            e.printStackTrace();
            request.setAttribute("status", "failure");
            request.getRequestDispatcher("L_Portfolio.jsp").forward(request, response);
        } finally {
            // Close the database connection
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
