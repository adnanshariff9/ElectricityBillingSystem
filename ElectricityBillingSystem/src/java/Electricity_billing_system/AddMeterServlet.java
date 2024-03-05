/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Electricity_billing_system;

import DBconnection.dbconnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hp
 */
public class AddMeterServlet extends HttpServlet {

protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try {
            // Get user ID, email, meter number, and installation date from the form
            int userId = Integer.parseInt(request.getParameter("userId"));
            String email = request.getParameter("email");
            String meterNumber = request.getParameter("meterNumber");
            String installationDate = request.getParameter("installationDate");

            // Insert new meter information into the meters table
            insertMeterInfo(userId, email, meterNumber, installationDate);

            response.getWriter().println("Meter information added successfully!");
                        response.getWriter().println("<br><a href=\"adminhome.html\">Return to Admin Home</a>");


        } catch (Exception e) {
            // Handle errors
            e.printStackTrace();
            response.getWriter().println("Error: " + e.getMessage());
        }
    }

    private void insertMeterInfo(int userId, String email, String meterNumber, String installationDate) throws SQLException, ClassNotFoundException {
        Connection con = dbconnection.getConnectToElectricity_billing_system();

        // Insert new meter information into the meters table
        String insertSql = "INSERT INTO meters (MeterNumber, userid, Email, InstallationDate) VALUES (?, ?, ?, ?)";
        try (PreparedStatement insertStatement = con.prepareStatement(insertSql)) {
            insertStatement.setString(1, meterNumber);
            insertStatement.setInt(2, userId);
            insertStatement.setString(3, email);
            insertStatement.setDate(4, java.sql.Date.valueOf(installationDate));
            insertStatement.executeUpdate();
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }
}

