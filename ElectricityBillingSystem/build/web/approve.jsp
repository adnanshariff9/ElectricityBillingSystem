<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Approve User</title>
    <style>
        body {
            background-image: url('p2.jpg');
            background-size: cover;
            background-position: center;
            background-repeat: no-repeat;
            height: 100vh;
            margin: 0;
            position: relative;
        }

        .container {
            background-color: rgba(255, 255, 255, 0.5); /* Adjust the alpha value for transparency */
            padding: 50px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
            width: 50%;
            margin: auto;
            text-align: center;
        }

        h2 {
            color: black;
        }

        form {
            max-width: 400px;
            margin: 20px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
        }

        input[type="text"],
        input[type="date"],
        input[type="submit"] {
            width: 100%;
            padding: 10px;
            margin: 5px 0;
            box-sizing: border-box;
        }

        input[type="submit"] {
            background-color: #4CAF50;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }
        
        .success-message {
            color: #008000;
            font-weight: bold;
        }

        .footer {
            background-color: #343a40;
            color: white;
            text-align: center;
            padding: 10px;
            position: absolute;
            bottom: 0;
            width: 100%;
        }

        /* Button styling */
        .btn {
            background-color: #4CAF50;
            color: #fff;
            border: none;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        .btn:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <div class="container">
        <%-- Check if success message is available in the request --%>
        <% if (request.getAttribute("successMessage") != null) { %>
            <p class="success-message"><%= request.getAttribute("successMessage") %></p>
            <a href="<%= request.getContextPath() %>/admin-home.jsp" class="btn">Return to Admin Home</a>
        <% } else { %>
            <h2>Enter New Meter Information:</h2>
            <form action="AddMeterServlet" method="post">
                <input type="hidden" name="userId" value="<%= request.getParameter("userId") %>">
                <input type="hidden" name="email" value="<%= request.getParameter("email") %>">

                Meter Number: <input type="text" name="meterNumber" required><br>
                Installation Date: <input type="date" name="installationDate" required><br>
                <input type="submit" value="Submit">
            </form>
        <% } %>
    </div>
            
    <div class="footer">
        <p>&diams; 2023-2024 Electricity Billing System - by Adnan Shariff 1HK21IS009</p>

    </div>
</body>
</html>
