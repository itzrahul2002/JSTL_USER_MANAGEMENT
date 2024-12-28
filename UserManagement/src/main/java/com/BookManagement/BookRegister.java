package com.BookManagement;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "BookRegisterServlet", value = "/BookRegister-servlet")
public class BookRegister extends HttpServlet {
    private static final String query = "insert into BookManagement(Book_Name,Book_Edition,Book_Price) values(?,?,?)";

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

//        Fetching Data from Html form

        String BookName = request.getParameter("BookName");
        String BookEdition = request.getParameter("BookEdition");
        float BookPrice = Float.parseFloat(request.getParameter("BookPrice"));

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/firstdatabase","root","2002"); PreparedStatement ps = con.prepareStatement(query);){

            ps.setString(1,BookName);
            ps.setString(2,BookEdition);
            ps.setFloat(3,BookPrice);

            int count = ps.executeUpdate();
            if(count==1)
                out.println("<h2>Record Is Registered Sucessfully</h2>");
            else
                out.println("<h2>Record Not Registered Sucessfully</h2>");

        }catch (SQLException e) {
            e.printStackTrace();
            out.println("<h1> Error: " + e.getMessage()+"</h1>");
        }


        out.println("<html><body>");
//        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


}