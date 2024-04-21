<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="javax.servlet.http.HttpServletResponse" %>
<%@ page import="javax.servlet.http.HttpServletRequest" %>
<%@ page import="javax.servlet.http.HttpSession" %>

<%
    if (session != null) {
        session.invalidate();
    }

    // Set headers to control cache
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
    response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
    response.setDateHeader("Expires", 0); // Proxies.
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Logging Out</title>
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            background-color: #f0f0f0;
            font-family: 'Arial', sans-serif;
            color: #333;
            text-align: center;
        }
        p {
            font-size: 24px;
            animation: fadeOut 3s forwards;
        }
        @keyframes fadeOut {
            0% {
                opacity: 1;
            }
            50% {
                opacity: 0.5;
                letter-spacing: 2px;
            }
            100% {
                opacity: 0;
                transform: scale(0.95);
            }
        }
    </style>
    <script type="text/javascript">
        window.history.forward();
        function noBack() {
            window.history.forward();
        }
    </script>
</head>
<body onload="noBack();" onpageshow="if (event.persisted) noBack();" onunload="">
    <p>You are being logged out...</p>
    <script type="text/javascript">
        // Redirect after a slight delay to ensure scripts have time to execute
        setTimeout(function() {
            window.location.href = "home.html";
        }, 3000); // Increased time to allow animation to play out
    </script>
</body>
</html>
