/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import service.AccountService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;

/**
 *
 * @author Phi N
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        if (request.getParameter("logout") != null) {
            session.invalidate();
            request.setAttribute("message", "You have successfully logged out");
            getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
            response.sendRedirect("login");
        }
        if (session != null) {
            response.sendRedirect("home");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User service = new AccountService().login(username, password);
        HttpSession session = request.getSession();
        
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            request.setAttribute("message", "Please complete the form");
            getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
        } else if (service != null) {
            session.setAttribute("user", service);
            response.sendRedirect("home");
        } else {
            request.setAttribute("username", username);
            request.setAttribute("password", password);
            request.setAttribute("message", "Invalid username or password");
            getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
        }
    }
}
