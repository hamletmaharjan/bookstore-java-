<%-- 
    Document   : addbook
    Created on : Nov 30, 2019, 12:20:29 PM
    Author     : hams
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="layouts/header.jsp" />

<jsp:include page="layouts/sidebar.jsp" />
<!--main content start-->
          <section id="main-content">
              <section class="wrapper">
    		  <div class="row">
    				<div class="col-lg-12">
    					<h3 class="page-header"><i class="fa fa-file-text-o"></i> Add Book </h3>
    					<ol class="breadcrumb">
    						<li><i class="fa fa-home"></i><a href="index.html">Home</a></li>
    						<li><i class="icon_document_alt"></i>Books</li>
    						<li><i class="fa fa-file-text-o"></i>Add Book</li>
    					</ol>
    				</div>
    			</div>


                  <div class="row">
                      <div class="col-lg-12">
                          <section class="panel">
                              <header class="panel-heading">
                                User Form 
                              </header>
                              <div class="panel-body">
                                  <form class="form-horizontal " method="POST" enctype="multipart/form-data">
                                      <div class="form-group">
                                          <label class="col-sm-2 control-label">Book Title</label>
                                          <div class="col-sm-10">
                                              <input type="text" name="title" class="form-control">
                                          </div>
                                      </div>
                                      <div class="form-group">
                                          <label class="col-sm-2 control-label">Price</label>
                                          <div class="col-sm-10">
                                              <input type="number" name="price" class="form-control">
                                          </div>
                                     </div>
                                     <div class="form-group">
                                          <label class="col-sm-2 control-label">Author</label>
                                          <div class="col-sm-10">
                                            <select class="form-control m-bot15" name="author_id">
                                            	<?php $authors = GetAuthors($conn);
                                            	
                                            	if($authors):
                                            		foreach ($authors as $key => $value):
                                            		?>
														<option value="<?php echo $value['a_id'] ?>"><?php echo $value['a_firstname']." ".$value['a_lastname']; ?></option>
			                                        <?php endforeach;

			                                    else:
			                                        ?>
			                                        	<option value="null">no data found</option>
			                                    <?php endif; ?>
                                          </select>
                                          </div>
                                      </div>
                                     <div class="form-group">
                                          <label class="col-sm-2 control-label">Categories</label>
                                          <div class="col-sm-10">
                                            <select class="form-control m-bot15" name="categories">
                                              <option value="academics">Academics</option>
                                              <option value="biography">Biography</option>
                                              <option value="fiction">Fiction</option>
                                              <option value="history">History</option>
                                              <option value="medical science">Medical Science</option>
                                              <option value="poetry">Poetry</option>
                                              <option value="others">Others</option>
                                          </select>
                                          </div>
                                      </div>
                                     <div class="form-group">
                                          <label class="col-sm-2 control-label">Pages</label>
                                          <div class="col-sm-10">
                                              <input type="number" name="pages" class="form-control">
                                          </div>
                                     </div>
                                     <div class="form-group">
                                          <label class="col-sm-2 control-label">Published Date</label>
                                          <div class="col-sm-10">
                                              <input type="date" name="published_date" class="form-control">
                                          </div>
                                     </div>
                                     <div class="form-group">
                                          <label class="col-sm-2 control-label">Publisher</label>
                                          <div class="col-sm-10">
                                              <input type="text" name="publisher" class="form-control">
                                          </div>
                                     </div>
                                     <div class="form-group">
                                          <label class="col-sm-2 control-label">Cover</label>
                                          <div class="col-sm-10">
                                              <input type="file" name="file" class="form-control">
                                          </div>
                                     </div>
                                     <div class="form-group">
                                            <div class="col-lg-offset-2 col-lg-10">
                                                <button type="submit" name="submitbtn"class="btn btn-primary">Submit</button>
                                                <button type="button" class="btn btn-danger">Cancel</button>
                                            </div>
                     
                                     </div>
                                     
                                  </form>
                              </div>
                          </section>
                          
                      </div>
                  </div>
                 
              </section>
          </section>
          <!--main content end-->

          
<jsp:include page="layouts/footer.jsp" />
          