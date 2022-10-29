package com.hondaparts.controller;

import com.hondaparts.entity.Category;
import com.hondaparts.entity.Part;
import com.hondaparts.persistence.GenericDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(
        name = "getAllPartsAndCategories",
        urlPatterns = {"/getAllPartsAndCategories"}
)
/**
 * This servlet is for getting all the parts and categories for the view parts page
 *
 * @author Navy Jones
 */
public class GetAllPartsAndCategories extends HttpServlet {
    /**
     * Gets all the parts and categories into the session for view parts page
     *
     * @param req servlet request
     * @param resp servlet response
     * @throws ServletException for servlet exceptions
     * @throws IOException for io exceptions
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        if (session.getAttribute("parts") == null || session.getAttribute("categories") == null) {
            GenericDao<Part> partDao = new GenericDao<>(Part.class);
            GenericDao<Category> categoryDao = new GenericDao<>(Category.class);

            List<Part> parts = partDao.getAll();
            List<Category> categories = categoryDao.getAll();

            session.setAttribute("parts", parts);
            session.setAttribute("categories", categories);
        }

        resp.sendRedirect("viewParts.jsp");
    }
}
