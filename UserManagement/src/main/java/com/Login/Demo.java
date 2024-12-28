package com.Login;

import java.io.*;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

public class Demo extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String pass = request.getParameter("Password");

        ServletConfig sc = getServletConfig();
        String Password = sc.getInitParameter("Password");
        String Email = sc.getInitParameter("Email");

        if(pass.equals(Password))
            out.println("<h1>Email Address Is : "+Email+"</h1>");
        else
            out.println("Error !!");


        out.println("<html><body>");
//        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public void destroy() {
    }
}