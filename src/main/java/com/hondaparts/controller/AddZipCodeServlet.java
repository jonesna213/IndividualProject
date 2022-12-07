package com.hondaparts.controller;

import com.hondaparts.entity.User;
import com.hondaparts.persistence.GenericDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(
        name = "addZipCodeServlet",
        urlPatterns = {"/addZipCodeServlet"}
)
/**
 * This servlet is for adding a zip code to a user.
 *
 * @author Navy Jones
 */
public class AddZipCodeServlet extends HttpServlet {
    /**
     * Add zip code to user
     *
     * @param req servlet request
     * @param resp servlet response
     * @throws ServletException for servlet exceptions
     * @throws IOException for io exceptions
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        GenericDao<User> dao = new GenericDao<>(User.class);

        User user = (User) session.getAttribute("user");
        String zip = req.getParameter("zip");
        boolean zipError = false;
        String redirectUrl = "index.jsp";

        //Verify its a real zip code
        if () {
            user.setZip(zip);
            dao.saveOrUpdate(user);
        } else {
            zipError = true;
            redirectUrl = "viewProfile.jsp";
        }

        session.setAttribute("user", user);
        session.setAttribute("zipError", zipError);

        resp.sendRedirect(redirectUrl);
    }
}
