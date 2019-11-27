<%-- 
    Document   : login
    Created on : Nov 22, 2019, 5:28:53 PM
    Author     : hams
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!--================Categories Banner Area =================-->
        <section class="solid_banner_area">
            <div class="container">
                <div class="solid_banner_inner">
                    <h3>Login</h3>
                    <ul>
                        <li><a href="#">Home</a></li>
                        <li><a href="track.html">Login</a></li>
                    </ul>
                </div>
            </div>
        </section>
        <!--================End Categories Banner Area =================-->

        <div class="row">
        	<div class="col-lg-4">
        	</div>
        	<div class="col-lg-4">
        	<c:set var="errmsg" scope="page" value="${errorMsg}"></c:set>
                    <c:if test="${errmsg != null}">
                        <p>${errmsg}</p>   
                    </c:if>
        	</div>
        	<div class="col-lg-4">
        	</div>
        	
        </div>
        <!--================login Area =================-->
        <section class="login_area p_100">
        	
        	
            <div class="container">
                <div class="login_inner">
                    <div class="row">
                        <div class="col-lg-6">
                            <div class="login_title">
                                <h2>log in to your account</h2>
                                
                            </div>
                            <form class="login_form row" method="POST" action="dashboard">
                                <div class="col-lg-12 form-group">
                                    <input class="form-control" type="text" name="email" placeholder="email">
                                </div>
                                <div class="col-lg-12 form-group">
                                    <input class="form-control" type="password" name="password"  placeholder="Password">
                                </div>
                                <div class="col-lg-12 form-group">
                                    <button type="submit" value="submit" name="loginbtn" class="btn update_btn form-control">Login</button>
                                </div>
                            </form>
                        </div>
                        <div class="col-lg-6">
                            <div class="login_title">
                                <h2>create account</h2>
                            </div>
                            <form class="login_form row" method="POST" action="signup">
                                <div class="col-lg-12 form-group">
                                    <input class="form-control" type="text" name="c_name" placeholder="Name">
                                </div>
                                <div class="col-lg-12 form-group">
                                    <input class="form-control" type="text" name="c_username" placeholder="User Name">
                                </div>
                                <div class="col-lg-12 form-group">
                                    <input class="form-control" type="email" name="c_email" placeholder="Email">
                                </div>
                                <div class="col-lg-12 form-group">
                                    <input class="form-control" type="text" name="c_phone" placeholder="Phone">
                                </div>
                                <div class="col-lg-12 form-group">
                                    <input class="form-control" type="password" name="c_password" placeholder="Password">
                                </div>
                                <div class="col-lg-12 form-group">
                                    <button type="submit" name="submitbtn" class="btn subs_btn form-control">register now</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!--================End login Area =================-->
        
        