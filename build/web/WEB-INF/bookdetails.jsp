<%-- 
    Document   : bookdetails
    Created on : Nov 30, 2019, 9:48:40 PM
    Author     : hams
--%>

<%@page import="edu.kist_bit.bookstore.entity.TableBook"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!--================Categories Banner Area =================-->
       
        <!--================End Categories Banner Area =================-->
        
        <!--================Product Details Area =================-->
        <%TableBook book = (TableBook) request.getAttribute("book");%>
        <section class="product_details_area">
            <div class="container">
                <div class="row">
                    <div class="col-lg-4">
                        <div class="product_details_slider">
                            <div id="product_slider" class="rev_slider" data-version="5.3.1.6">
                                <ul>	<!-- SLIDE  -->
                                    <li>
                                        <!-- MAIN IMAGE -->
                                        <img src="uploads/<%out.print(book.getCover());%>"  alt="" data-bgposition="center center" data-bgfit="cover" data-bgrepeat="no-repeat" data-bgparallax="5" class="rev-slidebg" data-no-retina>
                                        <!-- LAYERS -->
                                    </li>
                                    
                                    
                                    <!-- SLIDE  -->
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-8">
                        <div class="product_details_text">
                            <h3><%out.print(book.getTitle());%></h3>
                            <div class="add_review">
                                <a href="#">5 Reviews</a>
                                <a href="#">Add your review</a>
                            </div>
                            <h6>Available In <span>Stock</span></h6>
                            <h4>Rs <%out.print(book.getPrice());%></h4>
                            <p>Author:</p>
                            <p><span>Categories</span>: <%out.print(book.getCategories());%></p>
                            <p>Pages: <%out.print(book.getPrice());%></p>
                            <p>Published Date: <%out.print(book.getPublishedDate());%></p>
                            <p>Publisher: <%out.print(book.getPublisher());%></p>

                            
                            <div class="quantity">
                                <div class="custom">
                                    <button onclick="var result = document.getElementById('sst'); var sst = result.value; if( !isNaN( sst ) &amp;&amp; sst > 0 ) result.value--;return false;" class="reduced items-count" type="button"><i class="icon_minus-06"></i></button>
                                    <input type="text" name="qty" id="sst" maxlength="12" value="01" title="Quantity:" class="input-text qty">
                                    <button onclick="var result = document.getElementById('sst'); var sst = result.value; if( !isNaN( sst )) result.value++;return false;" class="increase items-count" type="button"><i class="icon_plus"></i></button>
                                </div>
                                <a class="add_cart_btn" href="addtocart.php?ref=<?php echo $book['b_id']?>">add to cart</a>
                            </div>
                            <div class="shareing_icon">
                                <h5>share :</h5>
                                <ul>
                                    <li><a href="#"><i class="social_facebook"></i></a></li>
                                    <li><a href="#"><i class="social_twitter"></i></a></li>
                                    <li><a href="#"><i class="social_pinterest"></i></a></li>
                                    <li><a href="#"><i class="social_instagram"></i></a></li>
                                    <li><a href="#"><i class="social_youtube"></i></a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!--================End Product Details Area =================-->
        
        <!--================Product Description Area =================-->
        
        <!--================End Product Details Area =================-->
        
        <!--================End Related Product Area =================-->
        <section class="related_product_area">
            <div class="container">
                <div class="related_product_inner">
                    <h2 class="single_c_title">Related Books/ More by Author</h2>
                    <div class="row">
                    	<?php
                    	$relatedBook = GetBooksByAuthor($conn,$book['author_id']);
                    	foreach ($relatedBook as $key => $value):
                    	?>
                        <div class="col-lg-3 col-sm-6">
                            <div class="l_product_item">
                                <div class="l_p_img">
                                    <img class="" src="../admin/uploads/<?php echo $value['cover'];?>" alt="" height="350px" width="100%">
                                </div>
                                <div class="l_p_text">
                                   <ul>
                                        <li class="p_icon"><a href="#"><i class="icon_piechart"></i></a></li>
                                        <li><a class="add_cart_btn" href="addtocart.php?ref=<?php echo $value['b_id']?>">Add To Cart</a></li>
                                        <li class="p_icon"><a href="#"><i class="icon_heart_alt"></i></a></li>
                                    </ul>
                                    <h4><?php echo $value['title']; ?></h4>
                                    <h5>Rs <?php echo $value['price'] ?></h5>
                                </div>
                            </div>
                        </div>
                    <?php endforeach; ?>
                     
                    </div>
                    <nav aria-label="Page navigation example" class="pagination_area">
                      <ul class="pagination">
                        <li class="page-item"><a class="page-link" href="#">1</a></li>
                        <li class="page-item next"><a class="page-link" href="#"><i class="fa fa-angle-right" aria-hidden="true"></i></a></li>
                      </ul>
                    </nav>
                </div>
            </div>
        </section>
        <!--================End Related Product Area =================-->
