/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.kist_bit.bookstore.controller;

import edu.kist_bit.bookstore.entity.TableAuthor;
import edu.kist_bit.bookstore.services.TableAuthorJpaController;
import edu.kist_bit.bookstore.services.exceptions.IllegalOrphanException;
import edu.kist_bit.bookstore.services.exceptions.NonexistentEntityException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hams
 */
@WebServlet(name = "PagesController", urlPatterns = {"/dec","/about","/contact","/logout","/manageauthors","/deleteauthor"})
public class PagesController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, IllegalOrphanException, NonexistentEntityException {
        response.setContentType("text/html;charset=UTF-8");
        EntityManagerFactory emf =  (EntityManagerFactory) getServletContext().getAttribute("BookStoreemf");
        String servlet = request.getServletPath();
        TableAuthorJpaController tableAuthorJpaController;
        String pageURL = "";
        switch(servlet){
            case "/about":
                pageURL = "/WEB-INF/about.jsp";
                break;
            case "/contact":
                pageURL = "/WEB-INF/contact.jsp";
                break;
            case "/deleteauthor":
                String ref = request.getParameter("ref");
                Long id = new Long(ref);
                tableAuthorJpaController = new TableAuthorJpaController(emf);
                tableAuthorJpaController.destroy(id);
                
                pageURL = "/WEB-INF/admin/manageauthors.jsp";
                break;
            case "/manageauthors":
                tableAuthorJpaController = new TableAuthorJpaController(emf);
                List<TableAuthor> authors = tableAuthorJpaController.findTableAuthorEntities();
                request.setAttribute("authors", authors);
                pageURL = "/WEB-INF/admin/manageauthors.jsp";
                break;
            case "/logout":
                pageURL = "/login.jsp";
                request.getSession().invalidate();
                
                break;
            default:
                break;
        }
        dispatchRequest(request, response, pageURL);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (IllegalOrphanException ex) {
            Logger.getLogger(PagesController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(PagesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (IllegalOrphanException ex) {
            Logger.getLogger(PagesController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(PagesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void dispatchRequest(HttpServletRequest request, HttpServletResponse response, String pageURL) throws ServletException, IOException {
        request.getRequestDispatcher(pageURL).forward(request, response);
    }

}
