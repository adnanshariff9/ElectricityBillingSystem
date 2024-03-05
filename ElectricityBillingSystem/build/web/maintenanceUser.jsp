<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="icon" href="favicon.png" type="image/png">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

        <!-- Link to your shared styles.css file -->

        <link rel="stylesheet" href="login.css">


        <title>Welcome to Electricity Billing System</title>
    </head>
    <style> body{background-image: url('p12.jpg');}</style>
    <body>
        <!-- Navbar and transparent background code remains the same -->
        <!-- our code starts here -->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <a class="navbar-brand" href="#">Electricity Billing System</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                    aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">

                    <li class="nav-item active">
                        <a class="nav-link" href="home2.jsp">Home <span class="sr-only">(current)</span></a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href="about2.jsp">About</a>
                    </li>

                    <li class="nav-item ">
                        <a class="nav-link" href="contactus2.jsp">Contact us</a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href="#" onclick="confirmLogout()">Logout</a>
                    </li>

                    <script>
                        function confirmLogout() {
                            var logoutConfirmed = confirm("Are you sure you want to logout?");
                            if (logoutConfirmed) {
                                // Redirect to home.html after logout confirmation
                                window.location.href = "home.html";
                            } else {
                                // Do nothing or handle the cancellation
                                alert("Logout cancelled.");
                            }
                        }
                    </script>

                </ul>
            </div>
        </nav>

        <main>
            <center>
                <section id="user-section" style="border: 2px solid black; padding: 10px;">
                    <%-- Check if the user's email is available in the session --%>
                    <% if (session.getAttribute("email") != null) {%>
                    <h3 style="color: white;">Welcome <%= session.getAttribute("email")%>!</h3>
                    <% } else { %>
                    <h2 style="color: white;">Welcome Guest!</h2>
                    <% }%>
                </section>
            </center>

        </main>
<div class="container">
        <h2>Check for Maintenance cuts</h2>
        <!-- Added form tag with the 'action' attribute for redirection -->
        <form action="isPowerAvailable" method="post">

            <div class="box">
                <i class="fa-solid fa-shield-halved"></i>
                <input type="number" name="pincode" id="pincode" placeholder="Enter your area Pincode">
            </div>


            <!-- Added 'type="submit"' to the button and 'form' attribute -->
            <button type="submit">Check</button>
        </form>
    </div>
  






        <div class="footer">
        <p>&diams; 2023-2024 Electricity Billing System - by ADNAN SHARIFF 1HK21IS009</p>

        </div>

        <!-- Bootstrap JS and dependencies -->
        <!-- Include your Bootstrap JS and dependencies here -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
                integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
                integrity="sha384-U7Y9T+3b6CQs98ePjkx4U+8p7+cJz94PXXF1BOgS7I/6q1i9T8KgpvZ4Y6Jrm2Io"
        crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
                integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>

    </body>

</html>
