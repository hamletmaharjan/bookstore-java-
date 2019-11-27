<%-- 
    Document   : bookbycategories
    Created on : Nov 27, 2019, 5:58:09 PM
    Author     : hams
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <!--================Categories Banner Area =================-->
        <section class="categories_banner_area">
            <div class="container">
                <div class="c_banner_inner">
                    <h3>shop grid with left sidebar</h3>
                    <ul>
                        <li><a href="#">Home</a></li>
                        <li><a href="#">Categories</a></li>
                        <li class="current"><a href="#">Shop Grid with Left Sidebar</a></li>
                    </ul>
                </div>
            </div>
        </section>
        <!--================End Categories Banner Area =================-->
        
        <!--================Categories Product Area =================-->
        <section class="no_sidebar_2column_area">
            <div class="container">
                <div class="showing_fillter">
                    <div class="row m0">
                        <div class="first_fillter">
                            <h4>Showing 1 to 12 of 30 total</h4>
                        </div>
                        <div class="secand_fillter">
                            <h4>SORT BY :</h4>
                            <select class="selectpicker">
                                <option>Name</option>
                                <option>Name 2</option>
                                <option>Name 3</option>
                            </select>
                        </div>
                        <div class="third_fillter">
                            <h4>Show : </h4>
                            <select class="selectpicker">
                                <option>09</option>
                                <option>10</option>
                                <option>10</option>
                            </select>
                        </div>
                        <div class="four_fillter">
                            <h4>View</h4>
                            <a class="active" href="#"><i class="icon_grid-2x2"></i></a>
                            <a href="#"><i class="icon_grid-3x3"></i></a>
                        </div>
                    </div>
                </div>
                <div class="two_column_product">
                    <div class="row">
                        <div class="col-lg-3 col-sm-6">
                            <div class="l_product_item">
                                <div class="l_p_img">
                                    <img class="img-fluid" src="img/product/l-product-1.jpg" alt="">
                                    <h5 class="sale">Sale</h5>
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
                        <div class="col-lg-3 col-sm-6">
                            <div class="l_product_item">
                                <div class="l_p_img">
                                    <img class="img-fluid" src="img/product/l-product-2.jpg" alt="">
                                    <h5 class="new">New</h5>
                                </div>
                                <div class="l_p_text">
                                   <ul>
                                        <li class="p_icon"><a href="#"><i class="icon_piechart"></i></a></li>
                                        <li><a class="add_cart_btn" href="#">Add To Cart</a></li>
                                        <li class="p_icon"><a href="#"><i class="icon_heart_alt"></i></a></li>
                                    </ul>
                                    <h4>Travel Bags</h4>
                                    <h5><del>$130</del>  $110</h5>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-3 col-sm-6">
                            <div class="l_product_item">
                                <div class="l_p_img">
                                    <img class="img-fluid" src="img/product/l-product-3.jpg" alt="">
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
                        <div class="col-lg-3 col-sm-6">
                            <div class="l_product_item">
                                <div class="l_p_img">
                                    <img class="img-fluid" src="img/product/l-product-4.jpg" alt="">
                                </div>
                                <div class="l_p_text">
                                   <ul>
                                        <li class="p_icon"><a href="#"><i class="icon_piechart"></i></a></li>
                                        <li><a class="add_cart_btn" href="#">Add To Cart</a></li>
                                        <li class="p_icon"><a href="#"><i class="icon_heart_alt"></i></a></li>
                                    </ul>
                                    <h4>Nike Shoes</h4>
                                    <h5><del>$130 </del>  $110</h5>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-3 col-sm-6">
                            <div class="l_product_item">
                                <div class="l_p_img">
                                    <img class="img-fluid" src="img/product/l-product-5.jpg" alt="">
                                    <h5 class="sale">Sale</h5>
                                </div>
                                <div class="l_p_text">
                                   <ul>
                                        <li class="p_icon"><a href="#"><i class="icon_piechart"></i></a></li>
                                        <li><a class="add_cart_btn" href="#">Add To Cart</a></li>
                                        <li class="p_icon"><a href="#"><i class="icon_heart_alt"></i></a></li>
                                    </ul>
                                    <h4>Oxford Shirt</h4>
                                    <h5>$85.50</h5>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-3 col-sm-6">
                            <div class="l_product_item">
                                <div class="l_p_img">
                                    <img class="img-fluid" src="img/product/l-product-6.jpg" alt="">
                                </div>
                                <div class="l_p_text">
                                   <ul>
                                        <li class="p_icon"><a href="#"><i class="icon_piechart"></i></a></li>
                                        <li><a class="add_cart_btn" href="#">Add To Cart</a></li>
                                        <li class="p_icon"><a href="#"><i class="icon_heart_alt"></i></a></li>
                                    </ul>
                                    <h4>High Heel</h4>
                                    <h5><del>$130.50 </del>  $110</h5>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-3 col-sm-6">
                            <div class="l_product_item">
                                <div class="l_p_img">
                                    <img class="img-fluid" src="img/product/l-product-7.jpg" alt="">
                                </div>
                                <div class="l_p_text">
                                   <ul>
                                        <li class="p_icon"><a href="#"><i class="icon_piechart"></i></a></li>
                                        <li><a class="add_cart_btn" href="#">Add To Cart</a></li>
                                        <li class="p_icon"><a href="#"><i class="icon_heart_alt"></i></a></li>
                                    </ul>
                                    <h4>Fossil Watch</h4>
                                    <h5>$150</h5>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-3 col-sm-6">
                            <div class="l_product_item">
                                <div class="l_p_img">
                                    <img class="img-fluid" src="img/product/l-product-8.jpg" alt="">
                                </div>
                                <div class="l_p_text">
                                   <ul>
                                        <li class="p_icon"><a href="#"><i class="icon_piechart"></i></a></li>
                                        <li><a class="add_cart_btn" href="#">Add To Cart</a></li>
                                        <li class="p_icon"><a href="#"><i class="icon_heart_alt"></i></a></li>
                                    </ul>
                                    <h4>Ricky Shirt</h4>
                                    <h5>$45.05</h5>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-3 col-sm-6">
                            <div class="l_product_item">
                                <div class="l_p_img">
                                    <img class="img-fluid" src="img/product/four-column/product-1.jpg" alt="">
                                </div>
                                <div class="l_p_text">
                                   <ul>
                                        <li class="p_icon"><a href="#"><i class="icon_piechart"></i></a></li>
                                        <li><a class="add_cart_btn" href="#">Add To Cart</a></li>
                                        <li class="p_icon"><a href="#"><i class="icon_heart_alt"></i></a></li>
                                    </ul>
                                    <h4>Oxford Shoes</h4>
                                    <h5>$45.05</h5>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-3 col-sm-6">
                            <div class="l_product_item">
                                <div class="l_p_img">
                                    <img class="img-fluid" src="img/product/four-column/product-2.jpg" alt="">
                                </div>
                                <div class="l_p_text">
                                   <ul>
                                        <li class="p_icon"><a href="#"><i class="icon_piechart"></i></a></li>
                                        <li><a class="add_cart_btn" href="#">Add To Cart</a></li>
                                        <li class="p_icon"><a href="#"><i class="icon_heart_alt"></i></a></li>
                                    </ul>
                                    <h4>Formal Shirt</h4>
                                    <h5><del>$130 </del> $110</h5>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-3 col-sm-6">
                            <div class="l_product_item">
                                <div class="l_p_img">
                                    <img class="img-fluid" src="img/product/four-column/product-3.jpg" alt="">
                                </div>
                                <div class="l_p_text">
                                   <ul>
                                        <li class="p_icon"><a href="#"><i class="icon_piechart"></i></a></li>
                                        <li><a class="add_cart_btn" href="#">Add To Cart</a></li>
                                        <li class="p_icon"><a href="#"><i class="icon_heart_alt"></i></a></li>
                                    </ul>
                                    <h4>Beats HeadPhone</h4>
                                    <h5>$33.50</h5>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-3 col-sm-6">
                            <div class="l_product_item">
                                <div class="l_p_img">
                                    <img class="img-fluid" src="img/product/four-column/product-4.jpg" alt="">
                                </div>
                                <div class="l_p_text">
                                   <ul>
                                        <li class="p_icon"><a href="#"><i class="icon_piechart"></i></a></li>
                                        <li><a class="add_cart_btn" href="#">Add To Cart</a></li>
                                        <li class="p_icon"><a href="#"><i class="icon_heart_alt"></i></a></li>
                                    </ul>
                                    <h4>Wome Bag</h4>
                                    <h5>$590.00</h5>
                                </div>
                            </div>
                        </div>
                    </div>
                    <nav aria-label="Page navigation example" class="pagination_area">
                      <ul class="pagination">
                        <li class="page-item"><a class="page-link" href="#">1</a></li>
                        <li class="page-item"><a class="page-link" href="#">2</a></li>
                        <li class="page-item"><a class="page-link" href="#">3</a></li>
                        <li class="page-item"><a class="page-link" href="#">4</a></li>
                        <li class="page-item"><a class="page-link" href="#">5</a></li>
                        <li class="page-item"><a class="page-link" href="#">6</a></li>
                        <li class="page-item next"><a class="page-link" href="#"><i class="fa fa-angle-right" aria-hidden="true"></i></a></li>
                      </ul>
                    </nav>
                </div>
            </div>
        </section>
        <!--================End Categories Product Area =================-->
    </body>
</html>
