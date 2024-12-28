package com.Portfolio;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "P_LogoutServlet", value = "/P_Logout-servlet")
public class P_Logout extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

            HttpSession session = request.getSession();
            session.invalidate();
            response.sendRedirect("L_Portfolio.jsp");
    }


}