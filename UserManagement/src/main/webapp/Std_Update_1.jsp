<%--
    Created by IntelliJ IDEA.
    User: RAHUL THAKUR
    Date: 22-04-2024
    Time: 07:35
    To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Student Details</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h2>Edit Student Details</h2>
    <%-- Fetch student details based on the provided student ID --%>
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

            // Get the student ID from the URL parameter
            String studentId = request.getParameter("studentId");

            // If the form is submitted to update data
            if (request.getMethod().equalsIgnoreCase("post")) {
                // Retrieve updated data from the form
                String name = request.getParameter("name");
                String email = request.getParameter("email");
                String course = request.getParameter("course");

                // Update student data in the database
                String updateQuery = "UPDATE Student SET Name=?, Email=?, Course=? WHERE Student_Id=?";
                pstmt = conn.prepareStatement(updateQuery);
                pstmt.setString(1, name);
                pstmt.setString(2, email);
                pstmt.setString(3, course);
                pstmt.setString(4, studentId);
                int rowsUpdated = pstmt.executeUpdate();

                // Check if data updated successfully
                if (rowsUpdated > 0) {
                    %>
                    <div class="alert alert-success" role="alert">
                        Student details updated successfully!
                        <% response.sendRedirect("Std_Home.jsp");%>
                    </div>
                    <%
                } else {
                    %>
                    <div class="alert alert-danger" role="alert">
                        Failed to update student details.
                    </div>
    <%
                }
        }

        // Create SQL query to fetch student data based on ID
        String query = "SELECT * FROM Student WHERE Student_Id = ?";
        pstmt = conn.prepareStatement(query);
        pstmt.setString(1, studentId);

        // Execute the query
        rs = pstmt.executeQuery();

        // If student data found, pre-fill the form fields
        if (rs.next()) {
            String name = rs.getString("Name");
            String email = rs.getString("Email");
            String course = rs.getString("Course");
    %>
    <form action="" method="post">
        <input type="hidden" name="studentId" value="<%= studentId %>">
        <div class="form-group">
            <label for="name">Name:</label>
            <input type="text" class="form-control" id="name" name="name" value="<%= name %>" required>
        </div>
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" class="form-control" id="email" name="email" value="<%= email %>" required>
        </div>
        <div class="form-group">
            <label for="course">Course:</label>
            <input type="text" class="form-control" id="course" name="course" value="<%= course %>" required>
        </div>
        <button type="submit" class="btn btn-primary">Update</button>
    </form>
    <%
            } else {
                // Handle case where student data not found
                out.println("Student not found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close resources
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        }
    %>
</div>
</body>
</html>
