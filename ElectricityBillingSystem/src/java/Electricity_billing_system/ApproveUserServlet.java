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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


   

// Import statements

@WebServlet("/ApproveUser")
public class ApproveUserServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try {
            // Get user ID from the form
            int userId = Integer.parseInt(request.getParameter("userId"));
            String email=request.getParameter("email");

            // Update newConnectionStatus to 'not applied' in the users table
            updateNewConnectionStatus(userId);

            // Redirect to approve.jsp with user ID as a parameter
            response.sendRedirect("approve.jsp?userId=" + userId + "&email=" + email);

        } catch (Exception e) {
            // Handle errors
            e.printStackTrace();
            response.getWriter().println("Error: " + e.getMessage());
        }
    }

    private void updateNewConnectionStatus(int userId) throws SQLException, ClassNotFoundException {
        Connection con = dbconnection.getConnectToElectricity_billing_system();

        // Update newConnectionStatus to 'not applied' for the specified user ID
        String updateSql = "UPDATE users SET newConnectionStatus = 'not applied' WHERE UserID = ?";
        try (PreparedStatement updateStatement = con.prepareStatement(updateSql)) {
            updateStatement.setInt(1, userId);
            updateStatement.executeUpdate();
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }
}
