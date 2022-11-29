package com.hondaparts.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(
        name = "signOut",
        urlPatterns = { "/signOut" }
)

/**
 * This servlet class is for redirecting to the aws sign out page
 *
 * @author Navy Jones
 */
public class SignOut extends HttpServlet {
    /**
     *  For signing out
     *
     *@param  req                   the HttpServletRequest object
     *@param  resp                   the HttpServletResponse object
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an IO failure
     */
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession();
        String choice = req.getParameter("choice");
        if (choice.equals("Sign Out")) {
            session.removeAttribute("user");
            ServletContext context = getServletContext();
            String SIGN_OUT_URL = (String) context.getAttribute("signOutURL");
            String CLIENT_ID = (String) context.getAttribute("clientId");
            String SIGN_OUT_REDIRECT_URL = (String) context.getAttribute("signOutRedirectURL");

            String url = SIGN_OUT_URL + "?client_id=" + CLIENT_ID + "&logout_uri=" + SIGN_OUT_REDIRECT_URL;
            resp.sendRedirect(url);
        } else {
            resp.sendRedirect("index.jsp");
        }
    }
}
