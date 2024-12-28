package com.example.usermanagement;

import java.io.*;
import java.sql.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "ShowUserServlet", value = "/ShowUser-servlet")
public class ShowUser extends HttpServlet {
    private static final String query = "select ID,Name,Email,Moblie,DOB,City,Gender from Usermanagement";

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
                ResultSet rs = ps.executeQuery();

                // Start the table and apply CSS styles for centering
                out.println("<div style='display: flex; justify-content: center;'>");
                out.println("<table style='border-collapse: collapse; width: 100%;'>");
                out.println("<tr>");
                out.println("<th style='border: 1px solid #ddd; padding: 8px; background-color: #f2f2f2;'>ID</th>");
                out.println("<th style='border: 1px solid #ddd; padding: 8px; background-color: #f2f2f2;'>Name</th>");
                out.println("<th style='border: 1px solid #ddd; padding: 8px; background-color: #f2f2f2;'>Email</th>");
                out.println("<th style='border: 1px solid #ddd; padding: 8px; background-color: #f2f2f2;'>Mobile</th>");
                out.println("<th style='border: 1px solid #ddd; padding: 8px; background-color: #f2f2f2;'>DOB</th>");
                out.println("<th style='border: 1px solid #ddd; padding: 8px; background-color: #f2f2f2;'>City</th>");
                out.println("<th style='border: 1px solid #ddd; padding: 8px; background-color: #f2f2f2;'>Gender</th>");
                out.println("<th style='border: 1px solid #ddd; padding: 8px; background-color: #f2f2f2;'>Update</th>");
                out.println("<th style='border: 1px solid #ddd; padding: 8px; background-color: #f2f2f2;'>Delete</th>");
                out.println("</tr>");

                // Loop through the result set and display data in the table rows
                while (rs.next()){
                    out.println("<tr>");
                    out.println("<td style='border: 1px solid #ddd; padding: 8px;'>"+rs.getInt(1)+"</td>");
                    out.println("<td style='border: 1px solid #ddd; padding: 8px;'>"+rs.getString(2)+"</td>");
                    out.println("<td style='border: 1px solid #ddd; padding: 8px;'>"+rs.getString(3)+"</td>");
                    out.println("<td style='border: 1px solid #ddd; padding: 8px;'>"+rs.getString(4)+"</td>");
                    out.println("<td style='border: 1px solid #ddd; padding: 8px;'>"+rs.getString(5)+"</td>");
                    out.println("<td style='border: 1px solid #ddd; padding: 8px;'>"+rs.getString(6)+"</td>");
                    out.println("<td style='border: 1px solid #ddd; padding: 8px;'>"+rs.getString(7)+"</td>");
                    out.println("<td><a href='Update-servlet?ID="+rs.getInt(1)+"'>UPDATE</a></td>");
                    out.println("<td><a href='Delete-servlet?ID="+rs.getInt(1)+"'>DELETE</a></td>");


                    out.println("</tr>");
                }
//                out.println("<tr>");
                out.println("<td style='border: 1px solid'>");

                out.println("</td>");
//                out.println("<tr>");
                out.println("</table>");





                out.println("</div>");

            } catch (SQLException se) {
                out.println("<h1 style='text-align:center;color:red;'>" + se.getMessage() + " Error !!</h1>");
                se.printStackTrace();
            }

        } catch (ClassNotFoundException e) {
            out.println("<h2 style='text-align:center;color:red;'>MySQL JDBC Driver not found !!</h2>");
            e.printStackTrace();
        }
        out.println("<a href='Home.html'>");
        out.println("<button style='position: relative; display: flex; justify-content: center; align-items: center; border-radius: 5px; background: #183153; font-family: \"Montserrat\", sans-serif; box-shadow: 0px 6px 24px 0px rgba(0, 0, 0, 0.2); overflow: hidden; cursor: pointer; border: none;'>");
        out.println("<span style='text-align: center; text-decoration: none; width: 100%; padding: 18px 25px; color: #fff; font-size: 1.125em; font-weight: 700; letter-spacing: 0.3em; z-index: 20;'>HOME</span>");
        out.println("</button>");
        out.println("</a>");

        out.println("</div>");
        out.close();

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}