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
import java.util.List;

@WebServlet(
        name = "searchParts",
        urlPatterns = {"/searchParts"}
)
/**
 * This servlet is for searching for parts
 *
 * @author Navy Jones
 */
public class SearchParts extends HttpServlet {
    /**
     * For searching parts
     *
     * @param req servlet request
     * @param resp servlet response
     * @throws ServletException for servlet exceptions
     * @throws IOException for io exceptions
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao<Part> partDao = new GenericDao<>(Part.class);
        HttpSession session = req.getSession();

        String searchTerm = req.getParameter("searchTerm");
        String searchBy = req.getParameter("searchBy");
        int category = Integer.parseInt(req.getParameter("categoryId"));
        List<Part> parts = null;

        if (searchBy.equals("partName")) {
            parts = partDao.getByPropertyLike("partName", searchTerm);
        } else if (searchBy.equals("partNumber")) {
            parts = partDao.getByPropertyLike("partNumber", searchTerm);
        }

        //Filter by category
        if (category != 0 && parts != null) {
            parts.removeIf(part -> part.getCategory().getId() != category);
        }

        //See if it's not a search all
        if (!searchTerm.equals("")) {
            session.setAttribute("searchedFor", searchTerm);
        }
        session.setAttribute("parts", parts);
        resp.sendRedirect("viewParts.jsp");
    }
}
