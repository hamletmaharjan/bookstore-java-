<%-- 
    Document   : contact
    Created on : Nov 26, 2019, 10:50:11 AM
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
        <section class="solid_banner_area">
            <div class="container">
                <div class="solid_banner_inner">
                    <h3>Contact</h3>
                    <ul>
                        <li><a href="#">Home</a></li>
                        <li><a href="contact.html">Contact</a></li>
                    </ul>
                </div>
            </div>
        </section>
        <!--================End Categories Banner Area =================-->
        <div class="row">
            <div class="col-lg-4">
            </div>
            <div class="col-lg-4">
                message placeholder
            </div>
            <div class="col-lg-4">
            </div>
            
        </div>
        <!--================Contact Area =================-->
        <section class="contact_area p_100">
            <div class="container">
                <div class="contact_title">
                    <h2>Get in Touch</h2>
                </div>
                <div class="contact_form_inner">
                    <h3>Drop a Message</h3>
                    <form class="contact_us_form row" action="contactprocess" method="POST" id="contactForm" novalidate="novalidate">
                        <div class="form-group col-lg-6">
                            <input type="text" class="form-control" id="name" name="full_name" placeholder="Full Name *">
                        </div>
                        <div class="form-group col-lg-6">
                            <input type="email" class="form-control" id="email" name="email" placeholder="Email Address *">
                        </div>
                        
                        <div class="form-group col-lg-12">
                            <textarea class="form-control" name="message" id="message" rows="1" placeholder="Type Your Message..." name="message"></textarea>
                        </div>
                        <div class="form-group col-lg-12">
                            
                            <button type="submit"  name="submitbtn" class="btn update_btn form-control">Send Message</button>
                        </div>
                    </form>
                </div>
            </div>
        </section>
        <!--================End Contact Area =================-->
        
         <!--================Contact Success and Error message Area =================-->
        <div id="success" class="modal modal-message fade" role="dialog">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <i class="fa fa-close"></i>
                        </button>
                        <h2>Thank you</h2>
                        <p>Your message is successfully sent...</p>
                    </div>
                </div>
            </div>
        </div>

        <!-- Modals error -->

        <div id="error" class="modal modal-message fade" role="dialog">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <i class="fa fa-close"></i>
                        </button>
                        <h2>Sorry !</h2>
                        <p> Something went wrong </p>
                    </div>
                </div>
            </div>
        </div>
        <!--================End Contact Success and Error message Area =================-->
    </body>
</html>
