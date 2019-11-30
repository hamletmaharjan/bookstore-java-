<%-- 
    Document   : manageauthors
    Created on : Nov 30, 2019, 4:25:35 PM
    Author     : hams
--%>

<%@page import="edu.kist_bit.bookstore.entity.TableAuthor"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="layouts/header.jsp" />

<jsp:include page="layouts/sidebar.jsp" />


<!--main content start-->
          <section id="main-content">
              <section class="wrapper">
    		  <div class="row">
    				<div class="col-lg-12">
    					<h3 class="page-header"><i class="fa fa-table"></i> Table</h3>
    					<ol class="breadcrumb">
    						<li><i class="fa fa-home"></i><a href="index.html">Home</a></li>
    						<li><i class="fa fa-table"></i>Table</li>
    						<li><i class="fa fa-th-list"></i>Author table</li>
    					</ol>
    				</div>
    			</div>
                  <!-- page start-->
                  
                  <div class="row">
                  	
                      <div class="col-lg-12">
                          <section class="panel">
                            
                              <header class="panel-heading">
                                  Advanced Table
                              </header>
                              
                              <table class="table table-striped table-advance table-hover">
                               <tbody>
                                  <tr>
                                     <th><i class="#"></i></th>
                                     <th><i class="#"></i> Name</th>
                                     <th><i class="#"></i> Age</th>
                                     <th><i class="#"></i> Email</th>
                                     <th><i class="#"></i> Contact</th>
                                     <th><i class="icon_cogs"></i> Action</th>
                                  </tr>
                                  <%
                                    List<TableAuthor> authors = (List<TableAuthor>) request.getAttribute("authors");
                                    int count = 0;
                                    for (TableAuthor author:authors){
                        	
                                    %>
                                  <tr>
                                     <td><%out.print(++count);%></td>
                                     <td><%out.print(author.getAFirstname() + " " + author.getALastname());%></td>
                                     <td><%out.print(author.getAge());%></td>
                                     <td><%out.print(author.getEmail());%></td>
                                     <td><%out.print(author.getContact());%></td>

                                     <td>
                                      <div class="btn-group">
                                          <a class="btn btn-primary" href="#"><i class="icon_check_alt2"></i></a>
                                          
                                          <a class="btn btn-success" href="updateauthor?ref=<%out.print(author.getAId());%>"><i class="icon_plus_alt2"></i></a> 
                                          <a class="btn btn-danger" href="deleteauthor?ref=<%out.print(author.getAId());%>" onclick="return confirm('You Sure?');"><i class="icon_close_alt2"></i></a>  
                                      </div>
                                      </td>
                                  </tr>
                                 <%}%>            
                               </tbody>
                            </table>
                          </section>
                      </div>
                  </div>
                  <!-- page end-->
              </section>
          </section>

<jsp:include page="layouts/footer.jsp" />

