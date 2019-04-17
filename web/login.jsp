
<%@page import="package1.data"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <title>LOGIN</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="w3.css">
    <link rel="stylesheet" href="black.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
    <link rel="stylesheet" href="font.css">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <style>
        html,body,h1,h2,h3,h4,h5,h6 {font-family: "Roboto", sans-serif;}
        .w3-sidebar {
            z-index: 3;
            width: 250px;
            top: 43px;
            bottom: 0;
            height: inherit;


        }
        .w3-top{
            z-index: 0
        }
        .w3-main{
            z-index: -2;
        }
    </style>
    <body background="Images/light.jpg">



        <!-- Sidebar -->
        <nav class="w3-sidebar w3-bar-block w3-collapse w3-large w3-theme-l5 w3-animate-left"  id="mySidebar" >
            <a href="javascript:void(0)" onclick="w3_close()" class="w3-right w3-xlarge w3-padding-large w3-hover-black w3-hide-large" title="Close Menu">
                <i class="fa fa-remove"></i>
            </a>
            <h4 class="w3-bar-item"><b></b></h4>
             <p class=" w3-center"><img src="Images/logo.png" alt="logo" height="100" width="200"></p>
            <h1 style="font-family: cursive">&emsp;&nbsp;&nbsp;&nbsp;&nbsp;ARD</h1>
            <%if (data.getLoggedUserId() == null) {%>
            
            <form method="post" action="adminLogin.jsp" class="w3-center" style="align-items: center">
                <p ><button class="w3-button  w3-gray w3-center " style="width: 200px" type="submit">ADMINISTRATOR</button></p>
            </form>
            
            <%} else  {%>
            <p style="text-align: center"style="text-align: center">Logged in as</p>
            <p style="text-align: center"><%=data.getLoggedUserName()%></p>
            <br/>
            <form method="post" action="signOut" class="w3-center" style="align-items: center" onsubmit="return confirm('Are you sure to Sign out?')">
                <p ><button class="w3-button  w3-gray w3-center " style="width: 200px" type="submit">Sign out</button></p>
            </form>


            <%}%>

        </nav>

        <!-- Navbar -->
        <div style="z-index: 5"class="w3-top">
            <div style="z-index: 1" class="w3-bar w3-theme w3-top w3-left-align  " >
                <a class="w3-bar-item w3-button w3-right w3-hide-large w3-hover-white w3-large w3-theme-l1" href="javascript:void(0)" onclick="w3_open()"><i class="fa fa-bars"></i></a>
                <a href="index.jsp" class="w3-bar-item w3-button w3-theme-l1"><h6>HOME</h6></a>
                <%if ((data.getLoggedUserId() == null)&&(data.getLoggedAdminId() == null)) {%>
                <%} else if(data.getLoggedUserId() != null) { %>
                <a href="member.jsp" class="w3-bar-item w3-button w3-hide-small w3-hover-white"><h6>MEMBER</h6></a>
                <a href="viewBook.jsp" class="w3-bar-item w3-button w3-hide-small w3-hover-white"><h6>BOOKS</h6></a>
                <%} else if(data.getLoggedAdminId() != null){%>
                <a href="addBook.jsp" class="w3-bar-item w3-button w3-hide-small w3-hover-white"><h6>ADD BOOK</h6></a>
                <a href="updateBook.jsp" class="w3-bar-item w3-button w3-hide-small w3-hover-white"><h6>UPDATE BOOK</h6></a>
                <a href="issueBook.jsp" class="w3-bar-item w3-button w3-hide-small w3-hover-white"><h6>ISSUE BOOK</h6></a>
                <%}%>
                
                <a href="about.jsp" class="w3-bar-item w3-button w3-hide-small w3-hover-white"><h6>ABOUT</h6></a>

            </div>
        </div>

        <!-- Overlay effect when opening sidebar on small screens -->
        <div class="w3-overlay w3-hide-large" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

        <!-- Main content: shift it to the right by 250 pixels when the sidebar is visible -->
        <div  class="w3-main" style="margin-left:250px">

            <div class="w3-row w3-padding-64">
                <div class="w3-twothird w3-container">

                    <h1>MEMBER LOGIN<br/><br/></h1>

                    <form method="POST" action="login">

                        <p><label><i class="fa fa-user"></i> User Name</label></p></li>
                        <input class="w3-input w3-border" type="text" name="userName" required>        
                        <p><label><i class="fa fa-lock"></i> Password</label></p></li>
                        <input class="w3-input w3-border" type="password" name="password" required>
                        <br/>
                        <p><button class="w3-button w3-block w3-gray w3-left-align" type="submit"><i class="fa fa-sign-in w3-margin-right"></i> Log in</button></p>


                    </form>

                    <form method="post" action="newUser.jsp">            
                        <a href="newUser.jsp">
                            <p><button class="w3-button w3-block w3-gray w3-left-align" type="button"><i class="fa fa-user w3-margin-right"></i> Sign up</button></p>
                        </a>
                    </form>

                </div>

                 <div style="list-style-type: circle" class="w3-third w3-container w3-padding-64">

                    <p class=" w3-center"><img src="Images/back.jpg" alt="a" height="170" width="285"></p>
                    <p class=" w3-center w3-padding-64"><img src="Images/women.jpg" alt="d" height="170" width="285"></p>

                </div>
            </div>


            <!-- END MAIN -->
        </div>

        <script>
            // Get the Sidebar
            var mySidebar = document.getElementById("mySidebar");

            // Get the DIV with overlay effect
            var overlayBg = document.getElementById("myOverlay");

            // Toggle between showing and hiding the sidebar, and add overlay effect
            function w3_open() {
                if (mySidebar.style.display === 'block') {
                    mySidebar.style.display = 'none';
                    overlayBg.style.display = "none";
                } else {
                    mySidebar.style.display = 'block';
                    overlayBg.style.display = "block";
                }
            }

            // Close the sidebar with the close button
            function w3_close() {
                mySidebar.style.display = "none";
                overlayBg.style.display = "none";
            }

            alert - suc
        </script>

    </body>
</html>

