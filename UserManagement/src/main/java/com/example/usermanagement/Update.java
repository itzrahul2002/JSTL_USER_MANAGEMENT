package com.example.usermanagement;

import java.io.*;
import java.sql.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "UpdateServlet", value = "/Update-servlet")
public class Update extends HttpServlet {
    private static final String query = "select Name,Email,Moblie, DOB, City, Gender from Usermanagement where id=?";

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css' rel='stylesheet' integrity='sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH' crossorigin='anonymous'>");

        int id = Integer.parseInt(request.getParameter("ID"));



        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/firstdatabase", "root", "2002")) {
                PreparedStatement ps = con.prepareStatement(query);

                ps.setInt(1,id);
                ResultSet rs = ps.executeQuery();
                rs.next();
                out.println("<form action='EditRecord-servlet?ID="+id+"' method ='post'>");

                out.println("<table>");
                out.println("<tr>");
                out.println("<td>Name</td>");
                out.println("<td><input type='text' name='Name' value='"+rs.getString(1)+"'></td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td>Email</td>");
                out.println("<td><input type='email' name='Email' value='"+rs.getString(2)+"'></td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td>Moblie</td>");
                out.println("<td><input type='mobile' name='Moblie' value='"+rs.getString(3)+"'></td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td>DOB</td>");
                out.println("<td><input type='date' name='DOB' value='"+rs.getString(4)+"'></td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td>City</td>");
                out.println("<td><input type='text' name='City' value='"+rs.getString(5)+"'></td>");
                out.println("</tr>");

                out.println("<tr>");
                out.println("<td>Gender</td>");
                out.println("<td><input type='text' name='Gender' value='"+rs.getString(6)+"'></td>");
                out.println("</tr>");

                out.println("<tr>");
                out.println("<td><a href='EditRecord-servlet'><button type='submit'>Edit</button></a></td>");
                out.println("<td><button type='reset'>Cancel</button></td>");
                out.println("<td><button type='ShowUser-servlet'>Home</button></td>");
                out.println("</tr>");

                out.println("</table>");

                out.println("</form>");

                // Execute the query


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