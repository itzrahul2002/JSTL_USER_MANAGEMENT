package com.BookManagement;

import java.io.*;
import java.sql.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "EditBookServlet", value = "/EditBook-servlet")
public class EditBook extends HttpServlet {
    private static final String query = "select Book_Name,Book_Edition,Book_Price from BookManagement where ID=?";
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
            ResultSet rs = ps.executeQuery();

            rs.next();
            out.println("<form action='Edit_2-servlet?ID="+ID+"' method ='post'>");

            out.println("<table align='center'>");
            out.println("<tr>");
            out.println("<td>Book Name</td>");
            out.println("<td><input type='text' name='book_name' value='"+rs.getString(1)+"'></td>");
            out.println("</tr>");

            out.println("<tr>");
            out.println("<td>Book Edition</td>");
            out.println("<td><input type='text' name='book_edition' value='"+rs.getString(2)+"'></td>");
            out.println("</tr>");

            out.println("<tr>");
            out.println("<td>Book Price</td>");
            out.println("<td><input type='text' name='book_price' value='"+rs.getFloat(3)+"'></td>");
            out.println("</tr>");

            out.println("<tr>");
            out.println("<td><input type='submit' value='Edit'></td>");
            out.println("<td><input type='reset' value='Cancel'></td>");
            out.println("</tr>");

            out.println("</table>");
            out.println("</form>");

        }catch (SQLException sq){
            sq.printStackTrace();
            out.println("<h2>Error: " + sq.getMessage()+"</h2>");
        }catch (Exception e){
            e.printStackTrace();
            out.println("<h2>Error :"+e.getMessage()+"</h2>");
        }
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response); // Forward POST requests to the doGet method
    }
}