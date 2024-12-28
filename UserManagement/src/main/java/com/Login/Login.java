package com.Login;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "LoginServlet", value = "/Login-servlet")
public class Login extends HttpServlet {
    private static final String query ="insert into Login (Name)" ;


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String s_name =request.getParameter("s_name");
        String s_email =request.getParameter("s_email");
        String s_password =request.getParameter("s_password");





        out.println("<html><body>");
        out.println("<head>");

        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; background-color: #f0f0f0; }");
        out.println(".info { margin: 20px; padding: 10px; background-color: #fff; border-radius: 5px; box-shadow: 0 2px 5px rgba(0,0,0,0.1); }");
        out.println(".info p { margin: 5px 0; }");
        out.println(".info p span { font-weight: bold; }");
        out.println(".info p:hover { background-color: #f9f9f9; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");

        out.println("<div class='info'>");
        out.println("<p><span>User_Name :</span> " + s_name + "</p>");
        out.println("<p><span>Email_Address :</span> " + s_email + "</p>");
        out.println("<p><span>Password :</span> " + s_password + "</p>");
        out.println("</div>");

        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request, response);
    }

}