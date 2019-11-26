<%-- 
    Document   : index
    Created on : Nov 26, 2019, 6:57:39 PM
    Author     : hams
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1>hello world</h1>
<ul>
        <c:forEach var="book" items="${books}">
            <li>${book.title}</li>
            
        </c:forEach>
        </ul>

 <!--================Our Latest Product Area =================-->
        <section class="our_latest_product">
            <div class="container">
                <div class="s_m_title">
                    <h2>Our Latest Product</h2>
                </div>
                <div class="l_product_slider owl-carousel">
                    <div class="item">
                        <div class="l_product_item">
                            <div class="l_p_img">
                                <img src="img/product/l-product-1.jpg" alt="">
                            </div>
                            <div class="l_p_text">
                                <ul>
                                    <li class="p_icon"><a href="#"><i class="icon_piechart"></i></a></li>
                                    <li><a class="add_cart_btn" href="#">Add To Cart</a></li>
                                    <li class="p_icon"><a href="#"><i class="icon_heart_alt"></i></a></li>
                                </ul>
                                <h4>Womens Libero</h4>
                                <h5><del>$45.50</del>  $40</h5>
                            </div>
                        </div>
                    </div>
                    <div class="item">
                        <div class="l_product_item">
                            <div class="l_p_img">
                                <img src="img/product/l-product-2.jpg" alt="">
                            </div>
                            <div class="l_p_text">
                               <ul>
                                    <li class="p_icon"><a href="#"><i class="icon_piechart"></i></a></li>
                                    <li><a class="add_cart_btn" href="#">Add To Cart</a></li>
                                    <li class="p_icon"><a href="#"><i class="icon_heart_alt"></i></a></li>
                                </ul>
                                <h4>Travel Bags</h4>
                                <h5><del>$45.50</del>  $40</h5>
                            </div>
                        </div>
                    </div>
                    <div class="item">
                        <div class="l_product_item">
                            <div class="l_p_img">
                                <img src="img/product/l-product-3.jpg" alt="">
                            </div>
                            <div class="l_p_text">
                               <ul>
                                    <li class="p_icon"><a href="#"><i class="icon_piechart"></i></a></li>
                                    <li><a class="add_cart_btn" href="#">Add To Cart</a></li>
                                    <li class="p_icon"><a href="#"><i class="icon_heart_alt"></i></a></li>
                                </ul>
                                <h4>Summer Dress</h4>
                                <h5>$45.05</h5>
                            </div>
                        </div>
                    </div>
                    <div class="item">
                        <div class="l_product_item">
                            <div class="l_p_img">
                                <img src="img/product/l-product-4.jpg" alt="">
                            </div>
                            <div class="l_p_text">
                               <ul>
                                    <li class="p_icon"><a href="#"><i class="icon_piechart"></i></a></li>
                                    <li><a class="add_cart_btn" href="#">Add To Cart</a></li>
                                    <li class="p_icon"><a href="#"><i class="icon_heart_alt"></i></a></li>
                                </ul>
                                <h4>Nike Shoes</h4>
                                <h5><del>$130</del> $110</h5>
                            </div>
                        </div>
                    </div>
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
                                <img src="img/product/l-product-1.jpg" alt="">
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
                    
                    <div class="item">
                        <div class="l_product_item">
                            <div class="l_p_img">
                                <img src="img/product/l-product-2.jpg" alt="">
                            </div>
                            <div class="l_p_text">
                               <ul>
                                    <li class="p_icon"><a href="#"><i class="icon_piechart"></i></a></li>
                                    <li><a class="add_cart_btn" href="#">Add To Cart</a></li>
                                    <li class="p_icon"><a href="#"><i class="icon_heart_alt"></i></a></li>
                                </ul>
                                <h4>Travel Bags</h4>
                                <h5><del>$45.50</del>  $40</h5>
                            </div>
                        </div>
                    </div>
                    <div class="item">
                        <div class="l_product_item">
                            <div class="l_p_img">
                                <img src="img/product/l-product-3.jpg" alt="">
                            </div>
                            <div class="l_p_text">
                               <ul>
                                    <li class="p_icon"><a href="#"><i class="icon_piechart"></i></a></li>
                                    <li><a class="add_cart_btn" href="#">Add To Cart</a></li>
                                    <li class="p_icon"><a href="#"><i class="icon_heart_alt"></i></a></li>
                                </ul>
                                <h4>Summer Dress</h4>
                                <h5>$45.05</h5>
                            </div>
                        </div>
                    </div>
                    <div class="item">
                        <div class="l_product_item">
                            <div class="l_p_img">
                                <img src="img/product/l-product-4.jpg" alt="">
                            </div>
                            <div class="l_p_text">
                               <ul>
                                    <li class="p_icon"><a href="#"><i class="icon_piechart"></i></a></li>
                                    <li><a class="add_cart_btn" href="#">Add To Cart</a></li>
                                    <li class="p_icon"><a href="#"><i class="icon_heart_alt"></i></a></li>
                                </ul>
                                <h4>Nike Shoes</h4>
                                <h5><del>$130</del> $110</h5>
                            </div>
                        </div>
                    </div>
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
                            <div class="f_add_img"><img class="img-fluid" src="img/feature-add/f-add-4.jpg" alt=""></div>
                            <div class="f_add_hover">
                                <h4>Best Summer <br />Collection</h4>
                                <a class="add_btn" href="#">Shop Now <i class="arrow_right"></i></a>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <div class="f_add_item white_add">
                            <div class="f_add_img"><img class="img-fluid" src="img/feature-add/f-add-5.jpg" alt=""></div>
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
                    <div class="col-lg-4">
                        <div class="row">
                            <div class="col-lg-6 col-sm-8">
                                <div class="p_list_text">
                                    <h3>Men</h3>
                                    <ul>
                                        <li><a href="#">Down Jackets</a></li>
                                        <li><a href="#">Hoodies</a></li>
                                        <li><a href="#">Suits</a></li>
                                        <li><a href="#">Jeans</a></li>
                                        <li><a href="#">Casual Pants</a></li>
                                        <li><a href="#">Sunglass</a></li>
                                    </ul>
                                </div>
                            </div>
                            <div class="col-lg-6 col-sm-4">
                                <div class="p_list_img">
                                    <img src="img/product/p-categories-list/product-l-1.jpg" alt="">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4">
                        <div class="row">
                            <div class="col-lg-6 col-sm-8">
                                <div class="p_list_text">
                                    <h3>Women</h3>
                                    <ul>
                                        <li><a href="#">Down Jackets</a></li>
                                        <li><a href="#">Hoodies</a></li>
                                        <li><a href="#">Suits</a></li>
                                        <li><a href="#">Jeans</a></li>
                                        <li><a href="#">Casual Pants</a></li>
                                        <li><a href="#">Sunglass</a></li>
                                    </ul>
                                </div>
                            </div>
                            <div class="col-lg-6 col-sm-4">
                                <div class="p_list_img">
                                    <img src="img/product/p-categories-list/product-l-2.jpg" alt="">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4">
                        <div class="row">
                            <div class="col-lg-6 col-sm-8">
                                <div class="p_list_text">
                                    <h3>Accessories</h3>
                                    <ul>
                                        <li><a href="#">Down Jackets</a></li>
                                        <li><a href="#">Hoodies</a></li>
                                        <li><a href="#">Suits</a></li>
                                        <li><a href="#">Jeans</a></li>
                                        <li><a href="#">Casual Pants</a></li>
                                        <li><a href="#">Sunglass</a></li>
                                    </ul>
                                </div>
                            </div>
                            <div class="col-lg-6 col-sm-4">
                                <div class="p_list_img">
                                    <img src="img/product/p-categories-list/product-l-3.jpg" alt="">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!--================End Product_listing Area =================-->
        
        <!--================Featured Product Area =================-->
        <section class="feature_product_area">
            <div class="container">
                <div class="f_p_inner">
                    <div class="row">
                        <div class="col-lg-3">
                            <div class="f_product_left">
                                <div class="s_m_title">
                                    <h2>Featured Products</h2>
                                </div>
                                <div class="f_product_inner">
                                    <div class="media">
                                        <div class="d-flex">
                                            <img src="img/product/featured-product/f-p-1.jpg" alt="">
                                        </div>
                                        <div class="media-body">
                                            <h4>Oxford Shirt</h4>
                                            <h5>$45.05</h5>
                                        </div>
                                    </div>
                                    <div class="media">
                                        <div class="d-flex">
                                            <img src="img/product/featured-product/f-p-2.jpg" alt="">
                                        </div>
                                        <div class="media-body">
                                            <h4>Puffer Jacket</h4>
                                            <h5>$45.05</h5>
                                        </div>
                                    </div>
                                    <div class="media">
                                        <div class="d-flex">
                                            <img src="img/product/featured-product/f-p-3.jpg" alt="">
                                        </div>
                                        <div class="media-body">
                                            <h4>Leather Bag</h4>
                                            <h5>$45.05</h5>
                                        </div>
                                    </div>
                                    <div class="media">
                                        <div class="d-flex">
                                            <img src="img/product/featured-product/f-p-4.jpg" alt="">
                                        </div>
                                        <div class="media-body">
                                            <h4>Casual Shoes</h4>
                                            <h5>$45.05</h5>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-9">
                            <div class="fillter_slider_inner">
                                <ul class="portfolio_filter">
                                    <li class="active" data-filter="*"><a href="#">men's</a></li>
                                    <li data-filter=".woman"><a href="#">Woman</a></li>
                                    <li data-filter=".shoes"><a href="#">Shoes</a></li>
                                    <li data-filter=".bags"><a href="#">Bags</a></li>
                                </ul>
                                <div class="fillter_slider owl-carousel">
                                    <div class="item shoes">
                                        <div class="fillter_product_item bags">
                                            <div class="f_p_img">
                                                <img src="img/product/fillter-product/f-product-1.jpg" alt="">
                                                <h5 class="sale">Sale</h5>
                                            </div>
                                            <div class="f_p_text">
                                                <h5>Nike Max Air Vapor Power</h5>
                                                <h4>$45.05</h4>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="item woman shoes bags">
                                        <div class="fillter_product_item">
                                            <div class="f_p_img">
                                                <img src="img/product/fillter-product/f-product-2.jpg" alt="">
                                                <h5 class="new">New</h5>
                                            </div>
                                            <div class="f_p_text">
                                                <h5>Fossil Watch</h5>
                                                <h4><del>$250</del> $110</h4>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="item woman shoes">
                                        <div class="fillter_product_item">
                                            <div class="f_p_img">
                                                <img src="img/product/fillter-product/f-product-3.jpg" alt="">
                                                <h5 class="discount">-10%</h5>
                                            </div>
                                            <div class="f_p_text">
                                                <h5>High Heel</h5>
                                                <h4>$45.05</h4>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="item shoes">
                                        <div class="fillter_product_item bags">
                                            <div class="f_p_img">
                                                <img src="img/product/fillter-product/f-product-1.jpg" alt="">
                                                <h5 class="sale">Sale</h5>
                                            </div>
                                            <div class="f_p_text">
                                                <h5>Nike Max Air Vapor Power</h5>
                                                <h4>$45.05</h4>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="item woman shoes bags">
                                        <div class="fillter_product_item">
                                            <div class="f_p_img">
                                                <img src="img/product/fillter-product/f-product-2.jpg" alt="">
                                                <h5 class="new">New</h5>
                                            </div>
                                            <div class="f_p_text">
                                                <h5>Fossil Watch</h5>
                                                <h4><del>$250</del> $110</h4>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="item woman shoes">
                                        <div class="fillter_product_item">
                                            <div class="f_p_img">
                                                <img src="img/product/fillter-product/f-product-3.jpg" alt="">
                                                <h5 class="discount">-10%</h5>
                                            </div>
                                            <div class="f_p_text">
                                                <h5>High Heel</h5>
                                                <h4>$45.05</h4>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="item shoes">
                                        <div class="fillter_product_item bags">
                                            <div class="f_p_img">
                                                <img src="img/product/fillter-product/f-product-1.jpg" alt="">
                                                <h5 class="sale">Sale</h5>
                                            </div>
                                            <div class="f_p_text">
                                                <h5>Nike Max Air Vapor Power</h5>
                                                <h4>$45.05</h4>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="item woman shoes bags">
                                        <div class="fillter_product_item">
                                            <div class="f_p_img">
                                                <img src="img/product/fillter-product/f-product-2.jpg" alt="">
                                                <h5 class="new">New</h5>
                                            </div>
                                            <div class="f_p_text">
                                                <h5>Fossil Watch</h5>
                                                <h4><del>$250</del> $110</h4>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="item woman shoes">
                                        <div class="fillter_product_item">
                                            <div class="f_p_img">
                                                <img src="img/product/fillter-product/f-product-3.jpg" alt="">
                                                <h5 class="discount">-10%</h5>
                                            </div>
                                            <div class="f_p_text">
                                                <h5>High Heel</h5>
                                                <h4>$45.05</h4>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!--================End Featured Product Area =================-->
        
        <!--================Form Blog Area =================-->
        <section class="from_blog_area">
            <div class="container">
                <div class="from_blog_inner">
                    <div class="c_main_title">
                        <h2>From The Blog</h2>
                    </div>
                    <div class="row">
                        <div class="col-lg-4 col-sm-6">
                            <div class="from_blog_item">
                                <img class="img-fluid" src="img/blog/from-blog/f-blog-1.jpg" alt="">
                                <div class="f_blog_text">
                                    <h5>fashion</h5>
                                    <p>Neque porro quisquam est qui dolorem ipsum</p>
                                    <h6>21.09.2017</h6>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-4 col-sm-6">
                            <div class="from_blog_item">
                                <img class="img-fluid" src="img/blog/from-blog/f-blog-2.jpg" alt="">
                                <div class="f_blog_text">
                                    <h5>fashion</h5>
                                    <p>Neque porro quisquam est qui dolorem ipsum</p>
                                    <h6>21.09.2017</h6>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-4 col-sm-6">
                            <div class="from_blog_item">
                                <img class="img-fluid" src="img/blog/from-blog/f-blog-3.jpg" alt="">
                                <div class="f_blog_text">
                                    <h5>fashion</h5>
                                    <p>Neque porro quisquam est qui dolorem ipsum</p>
                                    <h6>21.09.2017</h6>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!--================End Form Blog Area =================-->
