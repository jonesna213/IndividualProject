package com.hondaparts.controller;

import com.hondaparts.entity.Part;
import com.hondaparts.persistence.GenericDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(
        name = "viewAllPrices",
        urlPatterns = {"/viewAllPrices"}
)
/**
 * This servlet is for redirecting to the specific parts prices page
 *
 * @author Navy Jones
 */
public class ViewAllPrices extends HttpServlet {
    /**
     * For redirecting to viewPrices jsp with the part in session
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
        //Remove if there already is one in the session
        if (session.getAttribute("partToView") != null) {
            session.removeAttribute("partToView");
        }

        String partId = req.getParameter("partId");
        Part part = partDao.getById(Integer.parseInt(partId));

        session.setAttribute("partToView", part);

        resp.sendRedirect("viewPrices.jsp");
    }
}
