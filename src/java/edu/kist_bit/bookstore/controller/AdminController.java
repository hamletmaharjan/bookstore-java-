/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.kist_bit.bookstore.controller;

import edu.kist_bit.bookstore.entity.TableAuthor;
import edu.kist_bit.bookstore.entity.TableBook;
import edu.kist_bit.bookstore.services.TableAuthorJpaController;
import edu.kist_bit.bookstore.services.TableBookJpaController;
import edu.kist_bit.bookstore.services.exceptions.NonexistentEntityException;
import edu.kist_bit.bookstore.utils.FileUploadDTO;
import edu.kist_bit.bookstore.utils.FileUploadUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hams
 */
@WebServlet(name = "AdminController", urlPatterns = {"/admin","/adduser","/addbook","/insertbook","/addauthor","/insertauthor"})
@MultipartConfig
public class AdminController extends HttpServlet {

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
            throws ServletException, IOException, NonexistentEntityException {
        response.setContentType("text/html;charset=UTF-8");
        EntityManagerFactory emf =  (EntityManagerFactory) getServletContext().getAttribute("BookStoreemf");
        String redirectURL = "";
        String servletPath = request.getServletPath();
        TableAuthorJpaController tableAuthorJpaController;
        TableBookJpaController tableBookJpaController;
        switch (servletPath) {
            case "/admin":
                redirectURL = "/WEB-INF/admin/dashboard.jsp";
                break;
            case "/signup":
                redirectURL = "signup.jsp";
                break;
            case "/adduser":
                redirectURL = "/WEB-INF/admin/adduser.jsp";
                break;
            case "/addbook":
                tableAuthorJpaController = new TableAuthorJpaController(emf);
                List<TableAuthor> authors = tableAuthorJpaController.findTableAuthorEntities();
                request.setAttribute("authors", authors);
                redirectURL = "/WEB-INF/admin/addbook.jsp";
                break;
            case "/insertbook":
                tableBookJpaController = new TableBookJpaController(emf);
                TableBook createBook = getBookFormData(request,emf);
                FileUploadDTO fileUploadDTO = FileUploadUtil.fileUpload(request, response, "file");
                String photo = fileUploadDTO.getFileLocation();

                createBook.setCover(photo);
                tableBookJpaController.create(createBook);
                redirectURL = "/WEB-INF/admin/addbook.jsp";
                break;
            case "/addauthor":
                redirectURL = "/WEB-INF/admin/addauthor.jsp";
                break;
            
            case "/insertauthor":
                tableAuthorJpaController = new TableAuthorJpaController(emf);
                TableAuthor createAuthor = getFormData(request);
                tableAuthorJpaController.create(createAuthor);
                
                redirectURL = "/WEB-INF/admin/addauthor.jsp";
                break;
            default:
                break;
        }
        dispatchRequest(request, response, redirectURL);
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
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
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

    private void dispatchRequest(HttpServletRequest request, HttpServletResponse response, String redirectURL) throws ServletException, IOException {
        request.getRequestDispatcher(redirectURL).forward(request, response);
    }

    private TableAuthor getFormData(HttpServletRequest request) {
        TableAuthor author = new TableAuthor();
        String firstName = request.getParameter("a_firstname");
        String lastName = request.getParameter("a_lastname");
        String agestr =  request.getParameter("age");
        BigInteger age = new BigInteger(agestr);
        String email = request.getParameter("email");
        String contact = request.getParameter("contact");
        
        author.setAFirstname(firstName);
        author.setALastname(lastName);
        author.setAge(age);
        author.setEmail(email);
        author.setContact(contact);
        
        return author;
    }

    private TableBook getBookFormData(HttpServletRequest request, EntityManagerFactory emf) throws NonexistentEntityException {
        TableBook book = new TableBook();
        TableAuthorJpaController tableAuthorJpaController = new TableAuthorJpaController(emf);
        
        
        String title = request.getParameter("title");
        book.setTitle(title);
        String pricestr = request.getParameter("price");
        Double price = new Double(pricestr);
        book.setPrice(price);
        String authorstr = request.getParameter("author_id");
       
        Long authorid = new Long(authorstr);
        TableAuthor author = tableAuthorJpaController.findBooksById(authorid);
        
        book.setAuthorId(author);
        
        book.setCategories(request.getParameter("categories"));
        book.setPages(new Integer(request.getParameter("pages")));
        book.setPublishedDate(new Date(1532516399000l));
        book.setPublisher(request.getParameter("publisher"));
        
        
        return book;
    }

}
