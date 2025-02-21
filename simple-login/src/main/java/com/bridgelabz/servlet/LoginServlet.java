package com.bridgelabz.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        description = "Login Servlet Testing",
        urlPatterns = { "/LoginServlet" },
        initParams = {
                @WebInitParam(name = "user", value = "Narayan"),
                @WebInitParam(name = "password", value = "BridgeLabz")
        }
)
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // get request parameters for user-ID, password, and name
        String user = request.getParameter("username");
        String pwd = request.getParameter("password");
        String name = request.getParameter("name");

        // get servlet config init params
        String userID = getServletConfig().getInitParameter("user");
        String password = getServletConfig().getInitParameter("password");

        // Validate name
        if (isValidName(name)) {
            if (userID.equals(user) && password.equals(pwd)) {
                request.setAttribute("user", user);
                request.setAttribute("name", name);
                request.getRequestDispatcher("LoginSuccess.jsp").forward(request, response);
            } else {
                PrintWriter out = response.getWriter();
                out.println("<font color='red'>Either user name or password is wrong.</font>");
                request.getRequestDispatcher("/login.html").include(request, response);
            }
        } else {
            PrintWriter out = response.getWriter();
            out.println("<font color='red'>Name must start with a capital letter and have a minimum of 3 characters.</font>");
            request.getRequestDispatcher("/login.html").include(request, response);
        }
    }

    private boolean isValidName(String name) {
        return name != null && name.matches("^[A-Z][a-zA-Z]{2,}$");
    }
}
