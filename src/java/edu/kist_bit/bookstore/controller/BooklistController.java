/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.kist_bit.bookstore.controller;

import edu.kist_bit.bookstore.entity.TableBook;
import edu.kist_bit.bookstore.entity.TableOrder;
import edu.kist_bit.bookstore.services.TableBookJpaController;
import edu.kist_bit.bookstore.services.TableOrderJpaController;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
@WebServlet(name = "BooklistController", urlPatterns = {"/booklist"})
public class BooklistController extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        EntityManagerFactory emf =  (EntityManagerFactory) getServletContext().getAttribute("BookStoreemf");
        String booklistURL = "/WEB-INF/booklist.jsp";
        
        TableBookJpaController tableBookJpaController = new TableBookJpaController(emf);
        
        String ref = request.getParameter("ref");
        List<TableBook> books = null;
        int totalOrders = 0;
        List<TableOrder> orders = null;
         
        switch(ref){
            case "pb":
                TableOrderJpaController tableOrderJpaController = new TableOrderJpaController(emf);
                totalOrders = tableOrderJpaController.getTableOrderCount();
                orders = tableOrderJpaController.findTableOrderEntities();
                books = tableBookJpaController.findTableBookEntities();
                request.setAttribute("orders", orders);
                break;
                
            case "lb":
                books = tableBookJpaController.findLatestBooks();
                break;
            
            case "cb":
                books = tableBookJpaController.findCheapestBooks();
                break;
                
            case "ab":
                books = tableBookJpaController.findTableBookEntities();
                break;
                
            default:
                books = tableBookJpaController.findTableBookEntities();
                break;
        }
        request.setAttribute("books", books);
        
        dispatchRequest(request, response, booklistURL);
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
        processRequest(request, response);
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
        processRequest(request, response);
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

    private void dispatchRequest(HttpServletRequest request, HttpServletResponse response, String booklistURL) throws ServletException, IOException {
        request.getRequestDispatcher(booklistURL).forward(request, response);
    }

}
