<%-- 
    Document   : adduser
    Created on : Nov 30, 2019, 12:12:55 PM
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
    					<h3 class="page-header"><i class="fa fa-file-text-o"></i> Add User </h3>
    					<ol class="breadcrumb">
    						<li><i class="fa fa-home"></i><a href="index.html">Home</a></li>
    						<li><i class="icon_document_alt"></i>Users</li>
    						<li><i class="fa fa-file-text-o"></i>Add User</li>
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
                                  <form class="form-horizontal " method="POST">
                                      <div class="form-group">
                                          <label class="col-sm-2 control-label">First Name</label>
                                          <div class="col-sm-10">
                                              <input type="text" name="first_name" class="form-control">
                                          </div>
                                      </div>
                                      <div class="form-group">
                                          <label class="col-sm-2 control-label">Last Name</label>
                                          <div class="col-sm-10">
                                              <input type="text" name="last_name" class="form-control">
                                          </div>
                                      </div>
                                      <div class="form-group">
                                          <label class="col-sm-2 control-label">Email</label>
                                          <div class="col-sm-10">
                                              <input type="email" name="email" class="form-control">
                                          </div>
                                      </div>
                                      <div class="form-group">
                                          <label class="col-sm-2 control-label">Passowrd</label>
                                          <div class="col-sm-10">
                                              <input type="password" name="password" class="form-control">
                                          </div>
                                      </div>
                                      <div class="form-group">
                                          <label class="col-sm-2 control-label">Contact</label>
                                          <div class="col-sm-10">
                                              <input type="text" name="contact" class="form-control">
                                          </div>
                                      </div>
                                      <div class="form-group">
                                          <label class="col-sm-2 control-label">Role</label>
                                          <div class="col-sm-10">
                                            <select class="form-control m-bot15" name="role">
                                              <option value="superadmin">Super Admin</option>
                                              <option value="admin">Admin</option>
                                          </select>
                                          </div>
                                      </div>
                                      <div class="form-group">
                                          <label class="col-sm-2 control-label">Status</label>
                                          <div class="col-sm-10">
                                            <select class="form-control m-bot15" name="status">
                                              <option value="active">Active</option>
                                              <option value="inactive">Innactive</option>
                                          </select>
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

