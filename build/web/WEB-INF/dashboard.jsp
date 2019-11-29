<%-- 
    Document   : dashboard
    Created on : Nov 22, 2019, 7:40:38 PM
    Author     : hams
--%>

<%@page import="edu.kist_bit.bookstore.entity.TableAuthor"%>
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <!--================Our Latest Product Area =================-->
        <section class="our_latest_product">
            <div class="container">
                <div class="s_m_title">
                    <h2>Our Latest Books</h2>
                </div>
                <div class="l_product_slider owl-carousel">
                <c:forEach var="book" items="${books}">
                    <div class="item">
                        <div class="l_product_item">
                            <div class="l_p_img">
                                <img src="uploads/${book.cover}" alt="" width="150px" height="350px">
                            </div>
                            <div class="l_p_text">
                                <ul>
                                    <li class="p_icon"><a href="#"><i class="icon_piechart"></i></a></li>
                                    <li><a class="add_cart_btn" href="#">Add To Cart</a></li>
                                    <li class="p_icon"><a href="#"><i class="icon_heart_alt"></i></a></li>
                                </ul>
                                <h4>${book.title}</h4>
                                <h5>${book.price}</h5>
                            </div>
                        </div>
                    </div>
                </c:forEach>
                    
                    
                </div>
            </div>
        </section>
        <!--================End Our Latest Product Area =================-->
        <!--================Our Latest Product Area =================-->
        <section class="our_latest_product">
            <div class="container">
                <div class="s_m_title">
                    <h2>Our Best Books</h2>
                </div>
                <div class="l_product_slider owl-carousel">
                <c:forEach var="book" items="${books}">
                    <div class="item">
                        <div class="l_product_item">
                            <div class="l_p_img">
                                <img src="uploads/${book.cover}" alt="" width="150px" height="350px">
                            </div>
                            <div class="l_p_text">
                                <ul>
                                    <li class="p_icon"><a href="#"><i class="icon_piechart"></i></a></li>
                                    <li><a class="add_cart_btn" href="#">Add To Cart</a></li>
                                    <li class="p_icon"><a href="#"><i class="icon_heart_alt"></i></a></li>
                                </ul>
                                <h4>${book.title}</h4>
                                <h5>${book.price}</h5>
                            </div>
                        </div>
                    </div>
                </c:forEach>
                    
                    
                </div>
            </div>
        </section>
        <!--================End Our Latest Product Area =================-->
        <!--================Feature Big Add Area =================-->
        <section class="feature_big_add_area">
            <div class="container">
                <div class="row">
                    <div class="col-lg-6">
                        <div class="f_add_item white_add">
                            <div class="f_add_img"><img class="img-fluid" src="img/feature-add/f-add-11.jpg" alt="" height="120%" width="100%"></div>
                            <div class="f_add_hover">
                                <h4>Best Summer <br />Collection</h4>
                                <a class="add_btn" href="#">Shop Now <i class="arrow_right"></i></a>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <div class="f_add_item white_add">
                            <div class="f_add_img"><img class="img-fluid" src="img/feature-add/f-add-0.jpg" alt="" height="100%" width="100%"></div>
                            <div class="f_add_hover">
                                <h4>Best Summer <br />Collection</h4>
                                <a class="add_btn" href="#">Shop Now <i class="arrow_right"></i></a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!--================End Feature Big Add Area =================-->
        
        <!--================Product_listing Area =================-->
        <section class="product_listing_area">
            <div class="container">
                <div class="row p_listing_inner">
                    <div class="col-lg-12">
                        <div class="row">
                            <div class="col-lg-6 col-sm-8">
                                <div class="p_list_text">
                                    <h3>Authors</h3>
                                    <ul>
                                        <%
                                        List<TableAuthor> authors = (List<TableAuthor>) request.getAttribute("authors");
                                        for(int i=0; i<=5; i++){
                                        %>
                                        <li><a href="#"></a><% out.print(authors.get(i).getAFirstname()+" "+ authors.get(i).getALastname());%></li>
                                    <%} %>
                                        
                                    </ul>
                                </div>
                            </div>
                            <div class="col-lg-6 col-sm-4">
                                <div class="p_list_img">
                                    <img src="img/thoughts.png" alt="" height="60%" width="60%">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!--================End Product_listing Area =================-->
        
        
    </body>
</html>
