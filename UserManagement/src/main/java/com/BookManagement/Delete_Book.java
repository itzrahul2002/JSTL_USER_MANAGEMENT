package com.BookManagement;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "Delete_BookServlet", value = "/Delete_Book-servlet")
public class Delete_Book extends HttpServlet {
    private static final String query = "delete from BookManagement where ID=?";

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        int ID = Integer.parseInt(request.getParameter("ID"));


        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }


        try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/firstdatabase","root","2002")){
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1,ID);

            int count = ps.executeUpdate();

            if (count!=0)
                out.println("<h2>Record Deleted SucessFully</h2>");
            else
                out.println("<h2>Record Not Deleted ");

        }catch (SQLException sq){
            sq.printStackTrace();
            out.println("<h2>Error: " + sq.getMessage()+"</h2>");
        }catch (Exception e){
            e.printStackTrace();
            out.println("<h2>Error :"+e.getMessage()+"</h2>");
        }
        out.println("<a href='BookList-servlet'><button class='button' style='background-color: #4CAF50; /* Green */\n" +
                "border: none;\n" +
                "color: white;\n" +
                "padding: 15px 32px;\n" +
                "text-align: center;\n" +
                "text-decoration: none;\n" +
                "display: inline-block;\n" +
                "font-size: 16px;\n" +
                "margin: 4px 2px;\n" +
                "transition-duration: 0.4s;\n" +
                "cursor: pointer;'>Go Home</button></a>");

    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response); // Forward POST requests to the doGet method
    }
}