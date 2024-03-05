<%-- 
    Document   : confirmNewSubsidyApplication
    Created on : Feb 23, 2024, 7:09:52 AM
    Author     : hp
--%>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="java.util.Objects" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="icon" href="favicon.png" type="image/png">
  <script src="https://kit.fontawesome.com/9557032e05.js" crossorigin="anonymous"></script>

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
                <!-- Your navigation items -->
            </ul>
        </div>
    </nav>

    <main>
        <center>
            <section id="user-section" style="border: 2px solid black; padding: 10px;">
                <%-- Check if the user's email is available in the session --%>
                <% if (session.getAttribute("email") != null) { %>
                    <h3 style="color: white;">Welcome <%= session.getAttribute("email")%>!</h3>
                <% } else { %>
                    <h2 style="color: white;">Welcome Guest!</h2>
                <% } %>
            </section>
        </center>

    </main>

   

           <div class="container">
               
                <%
            // Check if the user's newSubsidyStatus is 'applied'
            String newSubsidyStatus = (String) session.getAttribute("newSubsidyStatus");

            if (Objects.equals(newSubsidyStatus, "existing")) {
        %>
                <h2>You have already sent an application for a subsidy, or you have an existing subsidy linked to your account. One user is applicable to gain subsidy to one meter only</h2>
        <p class="mt-auto"><a class="btn btn-secondary" href="home2.jsp" role="button" >Return to Home</a></p>
        <%
            } else {
        %>
               
               
    <h2>Confirm details for a subsidy</h2>
    <!-- Add a form for confirmation and update -->
    <form action="NewSubsidyUserSide" method="post">

        <div class="box">
            <i class="fa-solid fa-user"></i>
            <input type="text" id="name" name="name" placeholder="Name" value="<%= session.getAttribute("name") %>" required>
        </div>

        <div class="box">
            <i class="fa-solid fa-id-card"></i>
            <input type="text" id="aadhar" name="aadhar" placeholder="Aadhar number" value="<%= session.getAttribute("AadharCardNumber") %>" required>
        </div>

        <div class="box">
            <i class="fa-solid fa-phone"></i>
            <input type="tel" id="phone" name="phone" placeholder="Phone Number" value="<%= session.getAttribute("phone") %>" required>
        </div>

        <div class="box">
            <i class="fa-solid fa-location-dot"></i>
            <input type="text" id="address" name="address" placeholder="Address" value="<%= session.getAttribute("address") %>" required>
        </div>

        <div class="box">
            <i class="fa-solid fa-map-location-dot"></i>
            <input type="text" name="pincode" id="pincode" placeholder="Pincode" value="<%= session.getAttribute("pincode") %>" required>
        </div>
        <br/>
         <div class="box">
            <i class="fa-solid fa-check-to-slot"></i>
    <select id="newConnectionStatus" name="newSubsidyStatus" required>
        <option value="not applied" <% if ("not applied".equals(session.getAttribute("newSubsidyStatus"))) { %>selected<% } %>>Not Applied</option>
        <option value="applied" <% if ("applied".equals(session.getAttribute("newSubsidyStatus"))) { %>selected<% } %>>Apply</option>
    </select>
</div>
         <br/>

     

        <!-- Add a submit button for the confirmation and update -->
        
        <button type="submit">Confirm and Update</button>
    </form>
        
       <% }%>
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

