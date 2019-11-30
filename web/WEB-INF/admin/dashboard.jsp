<%-- 
    Document   : dashboard
    Created on : Nov 29, 2019, 9:30:47 PM
    Author     : hams
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="layouts/header.jsp" />

<jsp:include page="layouts/sidebar.jsp" />


<!--main content start-->
      <section id="main-content">
          <section class="wrapper">            
              <!--overview start-->
			  <div class="row">
				<div class="col-lg-12">
					<h3 class="page-header"><i class="fa fa-laptop"></i> Dashboard</h3>
					<ol class="breadcrumb">
						<li><i class="fa fa-home"></i><a href="index.html">Home</a></li>
						<li><i class="fa fa-laptop"></i>Dashboard</li>						  	
					</ol>
				</div>
			</div>
              
            <div class="row">
				
				<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
					<div class="info-box brown-bg">
						<i class="fa fa-shopping-cart"></i>
						<div class="count">
						<?php
						$totalCartItems = GetAllCartItems($conn);
						echo $totalCartItems;
						?></div>
						<div class="title">Cart Items</div>						
					</div><!--/.info-box-->			
				</div><!--/.col-->	
				
				<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
					<div class="info-box dark-bg">
						<i class="fa fa-thumbs-o-up"></i>
						<div class="count">
						<?php
						$totalOrders = GetAllOrders($conn);
						echo $totalOrders;
						?>
						</div>
						<div class="title">Orders</div>						
					</div><!--/.info-box-->			
				</div><!--/.col-->
				
				<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
					<div class="info-box green-bg">
						<i class="fa fa-cubes"></i>
						<div class="count">
						<?php
						$totalBooks = GetAllBooks($conn);
						echo $totalBooks;
						?>
						</div>
						<div class="title">Books</div>						
					</div><!--/.info-box-->			
				</div><!--/.col-->
				
			</div><!--/.row-->
            
		  
		  <!-- Today status end -->
			
              
		
      </section>
      <!--main content end-->
  </section>
  <!-- container section start -->

<jsp:include page="layouts/footer.jsp" />
  