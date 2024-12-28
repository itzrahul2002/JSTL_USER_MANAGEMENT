package com.BookManagement;

import java.io.*;
import java.sql.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "Edit_2Servlet", value = "/Edit_2-servlet")
public class Edit_2 extends HttpServlet {
    private static final String query = "update BookManagement set Book_Name=?,Book_Edition=?,Book_Price=? where ID=?";

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        int ID = Integer.parseInt(request.getParameter("ID"));

        String book_name = request.getParameter("book_name");
        String book_edition = request.getParameter("book_edition");
        float book_price = Float.parseFloat(request.getParameter("book_price"));

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }


        try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/firstdatabase","root","2002")){
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1,book_name);
            ps.setString(2,book_edition);
            ps.setFloat(3,book_price);
            ps.setInt(4,ID);

            int count = ps.executeUpdate();

            if (count!=0)
                out.println("<h2>Record Edited SucessFully</h2>");
            else
                out.println("<h2>Record Not Updated ");

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