package com.BookManagement;

import java.io.*;
import java.sql.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "BookListServlet", value = "/BookList-servlet")
public class BookList extends HttpServlet {
    private static final String query = "select ID,Book_Name,Book_Edition,Book_Price from BookManagement";
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }


        try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/firstdatabase","root","2002")){
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            out.println("<html>");
            out.println("<head>");
            out.println("<style>");
            out.println("body {");
            out.println("    font-family: Arial, sans-serif;");
            out.println("    background-color: #f0f0f0;");
            out.println("}");
            out.println("table {");
            out.println("    width: 100%;");
            out.println("    border-collapse: collapse;");
            out.println("    margin-top: 20px;");
            out.println("}");
            out.println("th, td {");
            out.println("    border: 1px solid #dddddd;");
            out.println("    text-align: left;");
            out.println("    padding: 12px;");
            out.println("}");
            out.println("th {");
            out.println("    background-color: #4CAF50;");
            out.println("    color: white;");
            out.println("}");
            out.println("tr:nth-child(even) {");
            out.println("    background-color: #f2f2f2;");
            out.println("}");
            out.println("tr:hover {");
            out.println("    background-color: #ddd;");
            out.println("}");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");

            out.println("<table>");
            out.println("<tr>");
            out.println("<th>Book Id</th>");
            out.println("<th>Book Name</th>");
            out.println("<th>Book Edition</th>");
            out.println("<th>Book Price</th>");
            out.println("<th>EDIT</th>");
            out.println("<th>DELETE</th>");
            out.println("</tr>");

            while (rs.next()){
                out.println("<tr>");
                out.println("<td>"+rs.getInt(1)+"</td>");
                out.println("<td>"+rs.getString(2)+"</td>");
                out.println("<td>"+rs.getString(3)+"</td>");
                out.println("<td>"+rs.getFloat(4)+"</td>");
                out.println("<td><a href='EditBook-servlet?ID="+rs.getInt(1)+"'>EDIT</a></td>");
                out.println("<td><a href='Delete_Book-servlet?ID="+rs.getInt(1)+"'>DELETE</a></td>");
                out.println("</tr>");
            }

            out.println("</table>");
            out.println("<a href='BookHome.html'><button class='button' style='background-color: #4CAF50; /* Green */\n" +
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

            out.println("</body>");
            out.println("</html>");

        }catch (SQLException sq){
            sq.printStackTrace();
            out.println("<h2>Error: " + sq.getMessage()+"</h2>");
        }catch (Exception e){
            e.printStackTrace();
            out.println("<h2>Error :"+e.getMessage()+"</h2>");
        }



    }

}