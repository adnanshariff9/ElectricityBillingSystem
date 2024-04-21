package Electricity_billing_system;

import DBconnection.dbconnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class getYourBill extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Fetch user details from the session
        HttpSession session = request.getSession();
        Integer userID = (Integer) session.getAttribute("userID");

        // Check if the user is authenticated
        if (userID == null) {
            // Redirect to login page if not authenticated
            response.sendRedirect("login.html");
            return;
        }

        // Fetch meter number and reading date from the form
        String meterNumber = request.getParameter("meternum");
        String readingDate = request.getParameter("readingdate");

        // Fetch billing information from the database
        double consumptionKWh = 0.0;
        double billAmountBeforeSubsidy = 0.0;
        double subsidyAmount = 0.0;
        double billAmountAfterSubsidy = 0.0;
        String subsidyType = "";
        String userName = "";
        String userEmail = "";
        String userAddress = "";
        String userPhone = "";
        String userPincode = "";

        try {
            Connection con = dbconnection.getConnectToElectricity_billing_system();

            // Query to retrieve billing information
            String billingInfoQuery = "SELECT ConsumptionKWh, BillAmount, SubsidyAmount FROM electricitybilling WHERE MeterNumber = ? AND ReadingDate = ? AND UserID = ?";
            try (PreparedStatement preparedStatement = con.prepareStatement(billingInfoQuery)) {
                preparedStatement.setString(1, meterNumber);
                preparedStatement.setString(2, readingDate);
                preparedStatement.setInt(3, userID);

                ResultSet billingInfoResult = preparedStatement.executeQuery();

                if (billingInfoResult.next()) {
                    consumptionKWh = billingInfoResult.getDouble("ConsumptionKWh");
                    billAmountBeforeSubsidy = billingInfoResult.getDouble("BillAmount");
                    subsidyAmount = billingInfoResult.getDouble("SubsidyAmount");
                    billAmountAfterSubsidy = billAmountBeforeSubsidy - subsidyAmount;
                }
            }

            // Query to retrieve user details
            String userDetailsQuery = "SELECT * FROM users WHERE UserID = ?";
            try (PreparedStatement userDetailsStatement = con.prepareStatement(userDetailsQuery)) {
                userDetailsStatement.setInt(1, userID);

                ResultSet userDetailsResult = userDetailsStatement.executeQuery();

                if (userDetailsResult.next()) {
                    userName = userDetailsResult.getString("Name");
                    userEmail = userDetailsResult.getString("Email");
                    userAddress = userDetailsResult.getString("Address");
                    userPhone = userDetailsResult.getString("Phone");
                    userPincode = userDetailsResult.getString("Pincode");
                }
            }

            // Query to retrieve subsidy details
            String subsidyQuery = "SELECT * FROM subsidies WHERE MeterID IN (SELECT MeterID FROM meters WHERE MeterNumber = ?)";
            try (PreparedStatement subsidyStatement = con.prepareStatement(subsidyQuery)) {
                subsidyStatement.setString(1, meterNumber);

                ResultSet subsidyResult = subsidyStatement.executeQuery();

                if (subsidyResult.next()) {
                    subsidyType = subsidyResult.getString("SubsidyType");
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            // Handle the exception appropriately (e.g., log it)
            e.printStackTrace();
        }

        // Display bill information using the external view
        generateHtmlResponse(response, meterNumber, readingDate, consumptionKWh,
                billAmountBeforeSubsidy, subsidyType, subsidyAmount, billAmountAfterSubsidy, userID, userName,
                userEmail, userAddress, userPhone, userPincode);
    }

    private void generateHtmlResponse(HttpServletResponse response, String meterNumber, String readingDate,
            double consumptionKWh, double billAmountBeforeSubsidy, String subsidyType, double subsidyAmount,
            double billAmountAfterSubsidy, int userID, String userName, String userEmail, String userAddress,
            String userPhone, String userPincode) throws IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<div style='text-align: center;'>");
        out.println("<img src='favicon-32x32.png'>");
        out.println("<h2>Electricity Billing System</h2>");
        out.println("-------------------------------------------------------");
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
}
