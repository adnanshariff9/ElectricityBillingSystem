<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Approve Subsidy</title>
    
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
            background-color: rgba(255, 255, 255, 0.6); /* Adjust the alpha value for transparency */
            padding: 25px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
            width: 50%;
            margin: auto; /* Center the container */
            text-align: center;
            border: 2px solid #333; /* Border color */
        }

        label {
            display: block;
            margin-bottom: 10px;
            color: black;
        }

        input[type="text"],
        select,
        input[type="submit"] {
            width: 50%; /* Make the input fields and submit button full-width */
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
        
        .footer {
            background-color: #343a40;
            color: white;
            text-align: center;
            padding: 10px;
            position: absolute;
            bottom: 0;
            width: 100%;
        }
    </style>
    
</head>
<body>
    <c:set var="userId" value="${param.userId}" />
    <c:set var="email" value="${param.email}" />

    <div class="container">
        <h2>Enter user Information for Subsidy:</h2>

        <form action="ProcessSubsidyApproval" method="post">
            <input type="hidden" name="userId" value="${userId}">
            <input type="hidden" name="email" value="${email}">
            
            <label for="meterId"><b>MeterID:<b/></label>
            <input type="text" name="meterId" required><br><br/>

            <label for="aplORbplCardNo"><b>APL/BPL Card Number:<b/></label>
            <input type="text" name="aplORbplCardNo" required><br><br/>

            <label for="subsidyType"><b>Subsidy Type:<b/></label>
            <select name="subsidyType" required>
                <option value="Above Poverty Line">Above Poverty Line</option>
                <option value="Below Poverty Line">Below Poverty Line</option>
            </select><br>

            <input type="submit" value="Submit">
        </form>
    </div>

    <div class="footer">
        <p>&diams; 2023-2024 Electricity Billing System - by ADNAN SHARIFF 1HK21IS009</p>
    </div>
</body>
</html>
