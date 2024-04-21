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
  <link rel="stylesheet" href="about.css">
  
  <style>
    .map-container {
      display: flex;
      justify-content: space-around;
      background-color: rgba(255, 255, 255, 0.5); /* White background with 50% transparency */
      padding: 20px;
    }

    iframe {
      border: 2px solid black; /* Optional: adds a border around each iframe */
    }
  </style>

  <title>Welcome to Electricity Billing System</title>
</head>

<body>
  <!-- Navbar -->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="home.html">Electricity Billing System</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
      aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav mr-auto">
        <li class="nav-item">
          <a class="nav-link" href="home.html">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="about.html">About</a>
        </li>
        <li class="nav-item active">
          <a class="nav-link" href="contactus.html">Contact us</a>
        </li>
           <li class="nav-item">
    <a class="nav-link" href="#" onclick="confirmLogout()">Logout</a>
</li>

<script>
    function confirmLogout() {
        var logoutConfirmed = confirm("Are you sure you want to logout?");
        if (logoutConfirmed) {
            // Redirect to home.html after logout confirmation
            window.location.href = "logout.jsp";
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
        <% if (session.getAttribute("email") != null) { %>
            <h3 style="color: white;">Welcome <%= session.getAttribute("email") %>!</h3>
        <% } else { %>
            <h2 style="color: white;">Welcome Guest!</h2>
        <% } %>
    </section>
</center>

</main>
<center><u> <h2>Visit our Offices :-</h2></u></center>

  <!-- Map Section -->
  <div class="map-container">
    <div>
      <h3>Head Office</h3>
<iframe src="https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d15551.7590324057!2d77.5880664!3d12.9757049!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3bae167253b099d5%3A0x6a4ef44dbc2cecf1!2sBESCOM%20Corporate%20office!5e0!3m2!1sen!2sin!4v1713722834454!5m2!1sen!2sin" width="400" height="300" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
    </div>
    <div>
      <h3>North Zonal Office</h3>
<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d15550.327386753797!2d77.60037560000004!3d12.998575600000006!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3bae165a4b372f83%3A0x970c4953ebbeb532!2sBESCOM%20North%20Zonal%20Office!5e0!3m2!1sen!2sin!4v1713722774761!5m2!1sen!2sin" width="400" height="300" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
    </div>
    <div>
      <h3>South Zonal Office</h3>
<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3887.9844577728113!2d77.58385797489301!3d12.972845787342683!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3bae1673673002f9%3A0xa5ee0fcdf7c08fc2!2sBESCOM%20SOUTH%20ZONE%20OFFICE!5e0!3m2!1sen!2sin!4v1713722377318!5m2!1sen!2sin" width="400" height="300" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
    </div>
  </div>

  <!-- Footer -->
  <div class="footer">
    <p>&diams; 2023-2024 Electricity Billing System - by Adnan Shariff 1HK21IS009</p>
  </div>

  <!-- Bootstrap JS and dependencies -->
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
