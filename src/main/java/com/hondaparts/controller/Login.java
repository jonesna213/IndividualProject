package com.hondaparts.controller;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "login",
        urlPatterns = {"/login"}
)
/**
 * This servlet is for redirecting to the aws login page
 *
 * @author Navy Jones
 */
public class Login extends HttpServlet {
    /**
     * Route to the aws hosted cognito login page.
     * @param req servlet request
     * @param resp servlet response
     * @throws ServletException for servlet exceptions
     * @throws IOException for io exceptions
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = getServletContext();
        String LOGIN_URL = (String) context.getAttribute("loginURL");
        String CLIENT_ID = (String) context.getAttribute("clientId");
        String REDIRECT_URL = (String) context.getAttribute("redirectURL");

        String url = LOGIN_URL + "?response_type=code&client_id=" + CLIENT_ID + "&redirect_uri=" + REDIRECT_URL;
        resp.sendRedirect(url);
    }
}
