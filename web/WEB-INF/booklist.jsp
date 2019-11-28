<%-- 
    Document   : booklist
    Created on : Nov 27, 2019, 3:04:45 PM
    Author     : hams
--%>

<%@page import="java.util.List"%>
<%@page import="edu.kist_bit.bookstore.entity.TableBook"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1> crap
        <% String str =(String) request.getParameter("ref");
        out.print(str);
        %> </h1>
        <!--================Categories Product Area =================-->
        <section class="no_sidebar_2column_area">
            <div class="container">
                <div class="showing_fillter">
                    <div class="row m0">
                        <div class="first_fillter">
                            <h4><%  %></h4>
                        </div>
                        <div class="third_fillter">
                            <h4>Show : </h4>
                            <select class="selectpicker">
                                <option>8</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="two_column_product">
                    <div class="row">
                    	<%
                    	List<TableBook> books = (List<TableBook>) request.getAttribute("books");
                        
                        for (TableBook book:books){
                        	
                    	%>
                        <div class="col-lg-3 col-sm-6">
                            <div class="l_product_item">
                                <div class="l_p_img">
                                    <img class="" src="uploads/<%out.print(book.getCover());%>" alt="" height="350px" width="100%">
                                </div>
                                <div class="l_p_text">
                                   <ul>
                                        <li class="p_icon"><a href="productdetails.php?ref=<?php echo $value['b_id']?>"><i class="icon_piechart"></i></a></li>
                                        <li><a class="add_cart_btn" href="addtocart.php?ref=<?php echo $value['b_id']?>">Add To Cart</a></li>
                                        <li class="p_icon"><a href="#"><i class="icon_heart_alt"></i></a></li>
                                    </ul>
                                    <h4><%out.print(book.getTitle());%></h4>
                                    <h5><%out.print(book.getPrice());%></h5>
                                </div>
                            </div>
                        </div>
                       	<%}%>
                        
                    </div>
                    <nav aria-label="Page navigation example" class="pagination_area">
                      <ul class="pagination">
                      	<?php for($page=1; $page <= $totalPages; $page++): ?>
                        <li class="page-item"><a class="page-link" href="booklist.php?ref=<?php echo $bookType; ?>&amp;page=<?php echo $page; ?>"><?php echo $page; ?></a></li>
                    <?php endfor;?>
                        <li class="page-item next"><a class="page-link" href="#"><i class="fa fa-angle-right" aria-hidden="true"></i></a></li>
                      </ul>
                    </nav>
                </div>
            </div>
        </section>
        <!--================End Categories Product Area =================-->
    </body>
</html>
