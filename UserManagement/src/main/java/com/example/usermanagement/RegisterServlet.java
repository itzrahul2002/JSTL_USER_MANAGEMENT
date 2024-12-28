package com.example.usermanagement;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "RegisterServletServlet", value = "/RegisterServlet-servlet")
public class RegisterServlet extends HttpServlet {
    private static final String query = "insert into Usermanagement(Name, Email, Moblie, DOB, City, Gender) values (?, ?, ?, ?, ?, ?)";

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css' rel='stylesheet' integrity='sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH' crossorigin='anonymous'>");

        String Name = request.getParameter("name");
        String Email = request.getParameter("email");
        String Moblie = request.getParameter("mobile");
        String DOB = request.getParameter("dob");
        String City = request.getParameter("city");
        String Gender = request.getParameter("gender");

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/firstdatabase", "root", "2002")) {
                PreparedStatement ps = con.prepareStatement(query);

                // Set parameter values
                ps.setString(1, Name);
                ps.setString(2, Email);
                ps.setString(3, Moblie);
                ps.setString(4, DOB);
                ps.setString(5, City);
                ps.setString(6, Gender);

                // Execute the query
                int count = ps.executeUpdate();

                out.println("<div class='card' style='margin:auto;width:300px;margin-top:100px;padding:20px;border-radius:10px;background-color:#f5f5f5;box-shadow:0 0 10px rgba(0,0,0,0.2);'>");
                if (count == 1) {
                    out.println("<h2 style='background:green;color:white;text-align:center;padding:10px;border-radius:5px;'>Record Registered Successfully</h2>");
                    out.println("<button style='width: 10em; position: relative; height: 3.5em; border: 3px ridge #149CEA; outline: none; background-color: transparent; color: white; transition: 1s; border-radius: 0.3em; font-size: 16px; font-weight: bold; cursor: pointer;'>");
                    out.println("<span style='position: absolute; top: -10px; left: 3%; width: 95%; height: 40%; background-color: #212121; transition: 0.5s; transform-origin: center;'></span>");
                    out.println("<span style='position: absolute; top: 80%; left: 3%; width: 95%; height: 40%; background-color: #212121; transition: 0.5s; transform-origin: center;'></span>");
                    out.println("</button>");


                } else {
                    out.println("<h2 style='background:red;color:white;text-align:center;padding:10px;border-radius:5px;'>Record Not Registered Successfully</h2>");
                }
            } catch (SQLException se) {
                out.println("<h1 style='text-align:center;color:red;'>" + se.getMessage() + " Error !!</h1>");
                se.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            out.println("<h2 style='text-align:center;color:red;'>MySQL JDBC Driver not found !!</h2>");
            e.printStackTrace();
        }
        out.println("</div>");
        out.close();

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
