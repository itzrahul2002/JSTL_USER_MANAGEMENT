package com.example.usermanagement;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "DeleteServlet", value = "/Delete-servlet")
public class Delete extends HttpServlet {
    private static final String query = "delete from Usermanagement where id = ?";

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

                // Set parameter values
                ps.setInt(1,id);

                // Execute the query
                int count = ps.executeUpdate();

                out.println("<div class='card' style='margin:auto;width:300px;margin-top:100px;padding:20px;border-radius:10px;background-color:#f5f5f5;box-shadow:0 0 10px rgba(0,0,0,0.2);'>");
                if (count == 1) {
                    out.println("<h2 style='background:green;color:white;text-align:center;padding:10px;border-radius:5px;'>Record Deleted Successfully</h2>");
                    out.println("<button style='width: 10em; position: relative; height: 3.5em; border: 3px ridge #149CEA; outline: none; background-color: transparent; color: white; transition: 1s; border-radius: 0.3em; font-size: 16px; font-weight: bold; cursor: pointer;'>");
                    out.println("<span style='position: absolute; top: -10px; left: 3%; width: 95%; height: 40%; background-color: #212121; transition: 0.5s; transform-origin: center;'></span>");
                    out.println("<span style='position: absolute; top: 80%; left: 3%; width: 95%; height: 40%; background-color: #212121; transition: 0.5s; transform-origin: center;'></span>");
                    out.println("</button>");


                } else {
                    out.println("<h2 style='background:red;color:white;text-align:center;padding:10px;border-radius:5px;'>Record Deleted UnSuccessfully</h2>");
                }
            } catch (SQLException se) {
                out.println("<h1 style='text-align:center;color:red;'>" + se.getMessage() + " Error !!</h1>");
                se.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            out.println("<h2 style='text-align:center;color:red;'>MySQL JDBC Driver not found !!</h2>");
            e.printStackTrace();
        }
        out.println("<a href='ShowUser-servlet'>");
        out.println("<button style='position: relative; display: flex; justify-content: center; align-items: center; border-radius: 5px; background: #183153; font-family: \"Montserrat\", sans-serif; box-shadow: 0px 6px 24px 0px rgba(0, 0, 0, 0.2); overflow: hidden; cursor: pointer; border: none;'>");
        out.println("<span style='text-align: center; text-decoration: none; width: 100%; padding: 18px 25px; color: #fff; font-size: 1.125em; font-weight: 700; letter-spacing: 0.3em; z-index: 20;'>GO BACK</span>");
        out.println("</button>");
        out.println("</a>");

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