package com.Test;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "TestServlet", value = "/Test-servlet")
public class Test extends HttpServlet {



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String course = request.getParameter("course");

        Connection con =null;

        try {
            //load sql Driver
            Class.forName("com.mysql.cj.jdbc.Driver");


            // build a Connection to database
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/seconddatabase","root","2002");

            // query
            String query ="insert into Test Name= "+name+"Email= "+email+"Course="+course;

            // execute query
            PreparedStatement pstmt =  con.prepareStatement(query);

            int row = pstmt.executeUpdate();

            if(row !=0){
                System.out.println("Data Inserted Successfully");
            }else {
                System.out.println("Data Insert Failed");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}