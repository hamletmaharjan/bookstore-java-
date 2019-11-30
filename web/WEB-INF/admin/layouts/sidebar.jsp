<%-- 
    Document   : sidebar
    Created on : Nov 29, 2019, 9:33:07 PM
    Author     : hams
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
     <!--sidebar start-->
        <aside>
            <div id="sidebar"  class="nav-collapse ">
                <!-- sidebar menu start-->
                <ul class="sidebar-menu">                
                    <li class="active">
                        <a class="" href="dashboard.php">
                            <i class="icon_house_alt"></i>
                            <span>Dashboard</span>
                        </a>
                    </li>
                    <li class="sub-menu">
                        <a href="javascript:;" class="">
                            <i class="icon_genius"></i>
                            <span>Admin Users</span>
                            <span class="menu-arrow arrow_carrot-right"></span>
                        </a>
                       
                        <ul class="sub">
                            <li><a class="" href="adduser">Add Users</a></li>                          
                            <li><a class="" href="manageusers">Manage Users</a></li>
                            <li><a class="" href="addbook">Add Book</a></li>
                            <li><a class="" href="managebooks">Manage Books</a></li>
                        </ul>
                       

                    </li>
                     <li class="sub-menu">
                        <a href="javascript:;" class="">
                            <i class="icon_document_alt"></i>
                            <span>Tasks</span>
                            <span class="menu-arrow arrow_carrot-right"></span>
                        </a>
                        <ul class="sub">
                            <li><a class="" href="addauthor.php">Add Author</a></li>                          
                            <li><a class="" href="manageauthors.php">Manage Authors</a></li>
                        </ul>
                    </li> 
                    
                    <li class="sub-menu">
                        <a href="javascript:;" class="">
                            <i class="icon_documents_alt"></i>
                            <span>Pages</span>
                            <span class="menu-arrow arrow_carrot-right"></span>
                        </a>
                        <ul class="sub">                          
                            <li><a class="" href="profile.php">Profile</a></li>
                        </ul>
                    </li>
                    
                </ul>
                <!-- sidebar menu end-->
            </div>
        </aside>
        <!--sidebar end-->