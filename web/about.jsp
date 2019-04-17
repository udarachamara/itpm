
<%@page import="package1.data"%>
<%@page import="package1.logginInfo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <title>ABOUT</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="w3.css">
    <link rel="stylesheet" href="black.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
    <link rel="stylesheet" href="font.css">
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
    <body background="Images/back.jpg" >



        <!-- Sidebar -->
        <nav class="w3-sidebar w3-bar-block w3-collapse w3-large w3-theme-l5 w3-animate-left"  id="mySidebar" >
            <a href="javascript:void(0)" onclick="w3_close()" class="w3-right w3-xlarge w3-padding-large w3-hover-black w3-hide-large" title="Close Menu">
                <i class="fa fa-remove"></i>
            </a>
            <h4 class="w3-bar-item"><b></b></h4>
            <p class=" w3-center"><img src="Images/logo.png" alt="logo" height="100" width="200"></p>
            <h1 style="font-family: cursive">&emsp;&nbsp;&nbsp;&nbsp;&nbsp;ARD</h1>
            
            <%if ((data.getLoggedAdminId() == null)&&(data.getLoggedUserId() == null)) {%>
            
            <form method="post" action="login.jsp" class="w3-center" style="align-items: center">
                <p ><button class="w3-button  w3-gray w3-center " style="width: 200px " style="align-items: center" type="submit">LOGIN</button></p>
            </form>
            <form method="post" action="addUser.jsp" class="w3-center" style="align-items: center">
                <p ><button class="w3-button  w3-gray w3-center " style="width: 200px" type="submit">SIGN UP</button></p>
            </form>
            <form method="post" action="adminLogin.jsp" class="w3-center" style="align-items: center">
                <p ><button class="w3-button  w3-gray w3-center " style="width: 200px" type="submit">ADMINISTRATOR</button></p>
            </form>
            
            <%} else if ((data.getLoggedAdminId() != null)||(data.getLoggedUserId() != null)){%>
            
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
                <a href="manageBook.jsp" class="w3-bar-item w3-button w3-hide-small w3-hover-white"><h6>UPDATE BOOK</h6></a>
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
                    
                    <br/><br/><br/>
                    <h1 class="w3-text-teal">About ARD Organization</h1>
                    
                    <div class="col-md-8">

                        <center ><h3 class="fontheading3">VISION AND MISSION</h3> </center>
                    <hr/> 
                    
                    <br/>

                    <center><h4>Vision</h4></center>
                    <br class="br"/>
                    <br class="br"/>
                    <p class="vi_mi_text">Being the national knowledge center, providing access to library and information services for all.</p>
                    
                    <br/>
                    
                    <center><h4>Mission</h4></center>
                    <br class="br"/>
                    <br class="br"/>
                    <p class="vi_mi_text">Creating a knowledge society through the preservation of intellectual heritage of the nation.</p><p class="vi_mi_text">Development of National library and information system.</p><p class="vi_mi_text">Encouraging the utilization of information and communication technology for an effective library service.</p><p class="vi_mi_text">Providing bibliographical services and assisting for book publication.</p>

                    <br class="br"/>
                    <h3 class="fontheading3">WHO WE ARE</h3> 
                    

                    <p align="justify">The National Library is mainly a research and a reference library and it is the main library and information centre in Sri Lanka. It intends to provide library resources as well as information to all Sri Lankans through the National Library. The library has five floors with a floor area of 11,250 sqm. and 866 meters of shelving. There are three reading areas with a seating capacity for 320 readers and several special study rooms, air conditioned auditorium with 145 seats and a conference room with 30 seats. The current library material stock of approximately over 1,000,000 volumes will form the nucleus of the future national collection.</p>
                    <p align="justify">The National Library has been building it’s collection since 1970’s through it’s acquisition programme. Methods of acquiring library material are purchases, deposits, donations and exchange (local and international). The National Library was attributed the Legal Deposit status by the Printers and Publishers Act in 1976 which made provisions to deposit a copy of each local publication in the National Library.</p>
                    


                </div>

                    <p><br/>
                         </p>

                    <br/><br/>

                    

                </div>

                <div class="w3-third w3-container w3-padding-64">
                    <p class=" w3-center w3-padding-64"><img src="Images/women.jpg" alt="women" height="200" width="285"></p>
                    <p class=" w3-center"><img src="Images/map.png" alt="BOOK" height="190" width="295"></p>
                    
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
        </script>

    </body>
</html>
