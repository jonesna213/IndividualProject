package com.hondaparts.controller;

import com.hondaparts.entity.User;
import com.hondaparts.persistence.GenericDao;
import com.hondaparts.persistence.WeatherDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(
        name = "editProfileServlet",
        urlPatterns = {"/editProfileServlet"}
)
/**
 * This servlet is for editing a profile
 *
 * @author Navy Jones
 */
public class EditProfileServlet extends HttpServlet {
    /**
     * Edit a user's profile
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
        WeatherDao weatherDao = new WeatherDao();

        User user = (User) session.getAttribute("user");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String zip = req.getParameter("zip");
        boolean error = true;

        //Verify its a real zip code
        String temp = weatherDao.getTemperature(zip);
        if (temp != null) {
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setEmail(email);
            user.setZip(zip);
            dao.saveOrUpdate(user);

            if (dao.getById(user.getId()).equals(user)) {
                error = false;
            }

            session.setAttribute("temperature", temp);
            session.removeAttribute("noZip");
        } else {
            session.setAttribute("zipError", true);
        }

        session.setAttribute("user", user);
        session.setAttribute("error", error);

        resp.sendRedirect("viewProfile.jsp");
    }
}
