package com.hondaparts.controller;

import com.hondaparts.entity.Part;
import com.hondaparts.entity.User;
import com.hondaparts.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(
        name = "savedParts",
        urlPatterns = {"/savedParts"}
)
/**
 * This servlet is for saving and un-saving parts to a users saved parts
 *
 * @author Navy Jones
 */
public class SavedParts extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    /**
     * For saving and un-saving parts
     *
     * @param req servlet request
     * @param resp servlet response
     * @throws ServletException for servlet exceptions
     * @throws IOException for io exceptions
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        GenericDao<Part> partDao = new GenericDao<>(Part.class);
        GenericDao<User> userDao = new GenericDao<>(User.class);
        User user = (User) session.getAttribute("user");

        String partId = req.getParameter("partId");
        Part part = partDao.getById(Integer.parseInt(partId));

        String redirectUrl = "viewParts.jsp#" + partId;
        String action = req.getParameter("action");

        if (part == null) {
            resp.sendRedirect("viewParts.jsp#" + partId);
        }
        switch (action) {
            case "save":
                logger.debug("Saved");
                user.getParts().add(part);
                break;
            case "unsave":
                logger.debug("UnSaved");
                user.getParts().remove(part);
                break;
            case "remove":
                user.getParts().remove(part);
                redirectUrl = "savedParts.jsp#" + partId;
                break;
            default:
                resp.sendRedirect("viewParts.jsp#" + partId);
                break;
        }

        userDao.saveOrUpdate(user);

        resp.sendRedirect(redirectUrl);
    }
}
