/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.kist_bit.bookstore.filter;

import edu.kist_bit.bookstore.entity.TableAdmin;
import edu.kist_bit.bookstore.entity.TableCustomer;
import edu.kist_bit.bookstore.services.TableAdminJpaController;
import edu.kist_bit.bookstore.services.TableCustomerJpaController;
import edu.kist_bit.bookstore.services.exceptions.NonexistentEntityException;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hams
 */
@WebFilter(filterName = "AuthenticationFilter", urlPatterns = {"/*"},
        initParams = @WebInitParam(name = "avoids-url", value = "/login.jsp,"
                + ".css,"
                + ".js,"
                + "/index.jsp"))
public class AuthenticationFilter implements Filter {
    
    private static final boolean debug = false;

    // The filter configuration object we are associated with.  If
    // this value is null, this filter instance is not currently
    // configured. 
    private FilterConfig filterConfig = null;
    private ArrayList<String> urlList;
    
    public AuthenticationFilter() {
    }    
    
    
    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        
        if (debug) {
            log("AuthenticationFilter:doFilter()");
        }
        
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        String url = req.getServletPath();
        boolean allowedRequest = false;
        
        for(String s: urlList){
            if(url.contains(s)){
                allowedRequest = true;
                break;
            }
        }
        
        Throwable problem = null;
        
        if (!allowedRequest) {
            HttpSession session = req.getSession(false);
            if ((null == session || session.getAttribute("loggedInUser") == null) && url.equalsIgnoreCase("/dashboard")) {
                if (req.getMethod().equalsIgnoreCase("POST")) {
                    try {
                        if(checkLogin(req, resp)){
                            chain.doFilter(request, response);
                            return;
                        }else{
                            req.setAttribute("errorMsg", "Invalid Email and Password");
                            req.getRequestDispatcher("login.jsp").forward(request, response);
                            //resp.sendRedirect("login.jsp");
                            return;
                        }
                    } catch (NoSuchAlgorithmException ex) {
                        Logger.getLogger(AuthenticationFilter.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    resp.sendRedirect("login.jsp");
                    return;
                }
            } else if (null == session || session.getAttribute("loggedInUser") == null) {
                resp.sendRedirect("index.jsp");
                return;
            }
        }
        try {
            chain.doFilter(request, response);
        } catch (Throwable t) {
            // If an exception is thrown somewhere down the filter chain,
            // we still want to execute our after processing, and then
            // rethrow the problem after that.
            problem = t;
            t.printStackTrace();
        }
        
        //doAfterProcessing(request, response);

        // If there was a problem, we want to rethrow it if it is
        // a known type, otherwise log it.
        if (problem != null) {
            if (problem instanceof ServletException) {
                throw (ServletException) problem;
            }
            if (problem instanceof IOException) {
                throw (IOException) problem;
            }
            sendProcessingError(problem, response);
        }
    }

    /**
     * Return the filter configuration object for this filter.
     */
    public FilterConfig getFilterConfig() {
        return (this.filterConfig);
    }

    /**
     * Set the filter configuration object for this filter.
     *
     * @param filterConfig The filter configuration object
     */
    public void setFilterConfig(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    /**
     * Destroy method for this filter
     */
    public void destroy() {        
    }

    /**
     * Init method for this filter
     */
    public void init(FilterConfig filterConfig) {        
        this.filterConfig = filterConfig;
        String urls = filterConfig.getInitParameter("avoids-url");
        StringTokenizer token = new StringTokenizer(urls, ",");
        urlList = new ArrayList<>();
        while (token.hasMoreTokens()) {
            urlList.add(token.nextToken());
        }
        if (filterConfig != null) {
            if (debug) {                
                log("AuthenticationFilter:Initializing filter");
            }
        }
    }

    /**
     * Return a String representation of this object.
     */
    @Override
    public String toString() {
        if (filterConfig == null) {
            return ("AuthenticationFilter()");
        }
        StringBuffer sb = new StringBuffer("AuthenticationFilter(");
        sb.append(filterConfig);
        sb.append(")");
        return (sb.toString());
    }
    
    private void sendProcessingError(Throwable t, ServletResponse response) {
        String stackTrace = getStackTrace(t);        
        
        if (stackTrace != null && !stackTrace.equals("")) {
            try {
                response.setContentType("text/html");
                PrintStream ps = new PrintStream(response.getOutputStream());
                PrintWriter pw = new PrintWriter(ps);                
                pw.print("<html>\n<head>\n<title>Error</title>\n</head>\n<body>\n"); //NOI18N

                // PENDING! Localize this for next official release
                pw.print("<h1>The resource did not process correctly</h1>\n<pre>\n");                
                pw.print(stackTrace);                
                pw.print("</pre></body>\n</html>"); //NOI18N
                pw.close();
                ps.close();
                response.getOutputStream().close();
            } catch (Exception ex) {
            }
        } else {
            try {
                PrintStream ps = new PrintStream(response.getOutputStream());
                t.printStackTrace(ps);
                ps.close();
                response.getOutputStream().close();
            } catch (Exception ex) {
            }
        }
    }
    
    public static String getStackTrace(Throwable t) {
        String stackTrace = null;
        try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            t.printStackTrace(pw);
            pw.close();
            sw.close();
            stackTrace = sw.getBuffer().toString();
        } catch (Exception ex) {
        }
        return stackTrace;
    }
    
    public void log(String msg) {
        filterConfig.getServletContext().log(msg);        
    }

    private boolean checkLogin(HttpServletRequest req, HttpServletResponse resp) throws NoSuchAlgorithmException {
        EntityManagerFactory emf = (EntityManagerFactory) req.getServletContext().getAttribute("BookStoreemf");
        boolean isUserLoggedIn = false;
        TableAdmin admin = null;
        TableAdminJpaController tableAdminJpaController = new TableAdminJpaController(emf);
        try {
            admin = tableAdminJpaController.checkLogin(req.getParameter("email"));
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(AuthenticationFilter.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         if(admin != null){
            //if(BCrypt.checkpw(req.getParameter("password"),user.getPassword())){
            //String temp = getMd5(req.getParameter("password"));
            if(req.getParameter("password").equals(admin.getPassword())){
                
                isUserLoggedIn = true;
                HttpSession session = req.getSession();
                session.setAttribute("loggedInUser", admin);
            }
        }
        return isUserLoggedIn;
        
    }
    
    public String getMd5(String input) throws NoSuchAlgorithmException 
    { 
        
  
            // Static getInstance method is called with hashing MD5 
            MessageDigest md = MessageDigest.getInstance("MD5"); 
  
            // digest() method is called to calculate message digest 
            //  of an input digest() return array of byte 
            byte[] messageDigest = md.digest(input.getBytes()); 
  
            // Convert byte array into signum representation 
            BigInteger no = new BigInteger(1, messageDigest); 
  
            // Convert message digest into hex value 
            String hashtext = no.toString(16); 
            while (hashtext.length() < 32) { 
                hashtext = "0" + hashtext; 
            } 
            return hashtext; 
        
    }
    
    private boolean checkCustomerLogin(HttpServletRequest req, HttpServletResponse resp) throws NoSuchAlgorithmException {
        EntityManagerFactory emf = (EntityManagerFactory) req.getServletContext().getAttribute("BookStoreemf");
        boolean isUserLoggedIn = false;
        TableCustomer customer = null;
        TableCustomerJpaController tableCustomerJpaController = new TableCustomerJpaController(emf);
        try {
            customer = tableCustomerJpaController.checkLogin(req.getParameter("username"));
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(AuthenticationFilter.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         if(customer != null){
            //if(BCrypt.checkpw(req.getParameter("password"),user.getPassword())){
            //String temp = getMd5(req.getParameter("password"));
            if(req.getParameter("password").equals(customer.getCPassword())){
                
                isUserLoggedIn = true;
                HttpSession session = req.getSession();
                session.setAttribute("loggedInUser", customer);
            }
        }
        return isUserLoggedIn;
        
    }
}
