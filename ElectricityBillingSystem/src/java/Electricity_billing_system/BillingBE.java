package Electricity_billing_system;

import DBconnection.dbconnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BillingBE extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String meterNumber = request.getParameter("meternum");
        String readingDate = request.getParameter("readingdate");
        double consumptionKWh = Double.parseDouble(request.getParameter("ConsumptionKWh"));

        // Fetch user details from the database based on MeterNumber
        int userID = getUserIdFromMeterNumber(meterNumber);

        double tariff;
        if (consumptionKWh <= 100) {
            tariff = 6.0;
        } else if (consumptionKWh <= 200) {
            tariff = 7.0;
        } else {
            tariff = 8.0;
        }

        double billAmountBeforeSubsidy = consumptionKWh * tariff;

        // Fetch additional details for display
        String userName = "";
        String userEmail = "";
        String userAddress = "";
        String userPhone = "";
        String userPincode = "";

        try {
            Connection con = dbconnection.getConnectToElectricity_billing_system();

            String userDetailsQuery = "SELECT * FROM users WHERE UserID = ?";
            try (PreparedStatement preparedStatement = con.prepareStatement(userDetailsQuery)) {
                preparedStatement.setInt(1, userID);

                ResultSet userDetails = preparedStatement.executeQuery();

                if (userDetails.next()) {
                    userName = userDetails.getString("Name");
                    userEmail = userDetails.getString("Email");
                    userAddress = userDetails.getString("Address");
                    userPhone = userDetails.getString("Phone");
                    userPincode = userDetails.getString("Pincode");
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            // Log the exception or handle it appropriately for your application
            e.printStackTrace();
        }

        // Calculate bill amount before subsidization
        double billAmount = consumptionKWh * tariff;

        // Fetch subsidy details and calculate subsidization
        double subsidyAmount = 0.0;
        String subsidyType = "";

        try {
            Connection con = dbconnection.getConnectToElectricity_billing_system();

            // Query to retrieve subsidy details based on MeterID
            String subsidyQuery = "SELECT * FROM subsidies WHERE MeterID IN (SELECT MeterID FROM meters WHERE MeterNumber = ?)";
            try (PreparedStatement subsidyStatement = con.prepareStatement(subsidyQuery)) {
                subsidyStatement.setString(1, meterNumber);

                ResultSet subsidyResult = subsidyStatement.executeQuery();

                if (subsidyResult.next()) {
                    subsidyType = subsidyResult.getString("SubsidyType");

                    // Calculate subsidy amount based on subsidy type
                    if (subsidyType.equals("Above Poverty Line")) {
                        subsidyAmount = 0.15 * billAmountBeforeSubsidy;
                    } else if (subsidyType.equals("Below Poverty Line")) {
                        subsidyAmount = 0.20 * billAmountBeforeSubsidy;
                    }
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            // Log the exception or handle it appropriately for your application
            e.printStackTrace();
        }

        // Calculate bill amount after subsidization
        double billAmountAfterSubsidy = billAmountBeforeSubsidy - subsidyAmount;

        // Save billing information to the database
        saveBillingInfo(meterNumber, readingDate, consumptionKWh, billAmountAfterSubsidy, userID);

        // Send response to the client with the bill details
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<div style='text-align: center;'>");
        out.println("<img src='favicon-32x32.png'>");
        out.println("<h2>Electricity Billing System</h2>");
        out.println("-----------------------------------------------");
        out.println("<p>Meter Number: " + meterNumber + "</p>");
        out.println("<p>Reading Date: " + readingDate + "</p>");
        out.println("<p>Consumption (KWh): " + consumptionKWh + "</p>");
        out.println("<p>Bill Amount (Before Subsidy): " + billAmountBeforeSubsidy + "</p>");
        out.println("<p>Subsidy Type: " + subsidyType + "</p>");
        out.println("<p>Subsidy Amount: " + subsidyAmount + "</p>");
        out.println("<p>Bill Amount (After Subsidy): " + billAmountAfterSubsidy + "</p>");
        out.println("<p>User ID: " + userID + "</p>");
        out.println("<p>User Name: " + userName + "</p>");
        out.println("<p>User Email: " + userEmail + "</p>");
        out.println("<p>User Address: " + userAddress + "</p>");
        out.println("<p>User Phone: " + userPhone + "</p>");
        out.println("<p>User Pincode: " + userPincode + "</p>");
        out.println("</div>");
        out.println("</body></html>");
    }

    // Add the following method to retrieve UserID based on MeterNumber
    private int getUserIdFromMeterNumber(String meterNumber) {
        int userID = -1; // Default value indicating no user found

        try {
            Connection con = dbconnection.getConnectToElectricity_billing_system();

            // Query to retrieve the UserID based on MeterNumber
            String userIdQuery = "SELECT UserID FROM meters WHERE MeterNumber = ?";

            try (PreparedStatement preparedStatement = con.prepareStatement(userIdQuery)) {
                preparedStatement.setString(1, meterNumber);

                ResultSet userIdResult = preparedStatement.executeQuery();

                if (userIdResult.next()) {
                    userID = userIdResult.getInt("UserID");
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            // Handle the exception appropriately (e.g., log it)
            e.printStackTrace();
        }

        return userID;
    }

    private void saveBillingInfo(String meterNumber, String readingDate, double consumptionKWh, double billAmount, int userID) {
        try {
            Connection con = dbconnection.getConnectToElectricity_billing_system();

            // Query to insert billing information into the electricitybilling table
            String insertBillingInfoQuery = "INSERT INTO electricitybilling (MeterNumber, ReadingDate, ConsumptionKWh, BillAmount, UserID) VALUES (?, ?, ?, ?, ?)";

            try (PreparedStatement preparedStatement = con.prepareStatement(insertBillingInfoQuery)) {
                preparedStatement.setString(1, meterNumber);
                preparedStatement.setString(2, readingDate);
                preparedStatement.setDouble(3, consumptionKWh);
                preparedStatement.setDouble(4, billAmount);
                preparedStatement.setInt(5, userID);

                preparedStatement.executeUpdate();
            }
        } catch (SQLException | ClassNotFoundException e) {
            // Handle the exception appropriately (e.g., log it)
            e.printStackTrace();
        }
    }
}