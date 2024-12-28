<%--
  Created by IntelliJ IDEA.
  User: RAHUL THAKUR
  Date: 22-04-2024
  Time: 08:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">

    <!-- Bootstrap JS and jQuery -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

    <link rel="stylesheet" href="CSS/UserHome.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>

<!-- Fetching data From DataBase  -->
<%
    // Define variables for database connection
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    try {
        // Load the MySQL JDBC Driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Establish the connection to the database
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/firstdatabase", "root", "2002");

        // Create SQL query to fetch all student data
        String query = "SELECT * FROM Student";
        pstmt = conn.prepareStatement(query);

        // Execute the query
        rs = pstmt.executeQuery();
%>

<!-- Fetching data From Database End -->

<!-- Dashboard -->
<div class="d-flex flex-column flex-lg-row h-lg-full bg-surface-secondary">
    <!-- Vertical Navbar -->
    <!-- Navbar code goes here -->
    <!-- Main content -->
    <div class="h-screen flex-grow-1 overflow-y-lg-auto">
        <!-- Main code goes here -->
        <main class="py-6 bg-surface-secondary">
            <div class="container-fluid">
                <!-- Card stats -->
                <!-- Table code goes here -->
                <div class="card shadow border-0 mb-7">
                    <div class="card-header">
                        <h5 class="mb-0">All Student Details</h5>
                    </div>
                    <div class="table-responsive">
                        <table class="table table-hover table-nowrap">
                            <thead class="thead-light">
                            <tr>
                                <th scope="col">Student Id</th>
                                <th scope="col">Name</th>
                                <th scope="col">Email Id</th>
                                <th scope="col">Course</th>
                                <th scope="col">Course Fee</th>
                                <th scope="col">Features</th>
                            </tr>
                            </thead>
                            <tbody>
                            <% while (rs.next()) { %>
                            <tr>
                                <td><%= rs.getString("Student_Id") %></td>
                                <td><%= rs.getString("Name") %></td>
                                <td><%= rs.getString("Email") %></td>
                                <td><%= rs.getString("Course") %></td>
                                <td><%= rs.getString("Course_Fee") %></td>
                                <td class="text-end">
                                    <a href="Std_Update_1.jsp?studentId=<%= rs.getString("Student_Id") %>" class="btn btn-sm btn-neutral">View</a>
                                </td>
                            </tr>
                            <% } %>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </main>
    </div>
</div>

<%
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        // Close resources
        if (rs != null) rs.close();
        if (pstmt != null) pstmt.close();
        if (conn != null) conn.close();
    }
%>

<!-- Script goes here -->
</body>
</html>

