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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hp
 */
public class SeeNewConnections extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            Connection con = dbconnection.getConnectToElectricity_billing_system();
             String sql = "SELECT * FROM users WHERE newConnectionStatus = 'applied'";
             PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ApproveNewConnection</title>"); 
                        out.println("<link rel=\"icon\" href=\"favicon.png\" type=\"image/png\">");
           
                    //css styling
           out.println("<style>");
        out.println("body {");
        out.println("    background-image: url('p2.jpg');");
        out.println("    background-size: cover;");
        out.println("    background-position: center;");
        out.println("    background-repeat: no-repeat;");
        out.println("    height: 100vh;");
        out.println("    margin: 0;");
        out.println("    position: relative;");
        out.println("}");

        out.println(".container {");
        out.println("    background-color: rgba(255, 255, 255, 0.6); /* Adjust the alpha value for transparency */");
        out.println("    padding: 50px;");
        out.println("    border-radius: 10px;");
        out.println("    box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);");
        out.println("    width: auto;");
        out.println("    text-align: center;");
        out.println("    border: 2px solid #333; /* Border color */");
        out.println("}");

        out.println("table { border-collapse: collapse; width: 100%; }");
        out.println("th, td { border: 1px solid #dddddd; text-align: left; padding: 8px; }");
        out.println("th { background-color: #4CAF50; }");
        out.println(".return-button { display: inline-block; padding: 10px 20px; margin-top: 20px; background-color: #4CAF50; color: #ffffff; text-decoration: none; border-radius: 5px; }");
        out.println(".footer {\n" +
        "    background-color: #343a40;\n" +
        "    color: white;\n" +
        "    text-align: center;\n" +
        "    padding: 10px;\n" +
        "    position: absolute;\n" +
        "    bottom: 0;\n" +
        "    width: 100%;\n" +
        "}");
        out.println("input[type=\"submit\"] {");
out.println("    background-color: #4CAF50;");
out.println("    color: #ffffff;");
out.println("    padding: 10px 20px;");
out.println("    border: none;");
out.println("    border-radius: 5px;");
out.println("    cursor: pointer;");
out.println("}");

out.println("input[type=\"submit\"]:hover {");
out.println("    background-color: #45a052;");
out.println("}");
                   out.println("</style>");

            out.println("</head>");
            out.println("<body>");
                         out.println("<center>");

                        out.println("<div class=\"container\">");

            out.println("<h2>Users who have applied for a new connection:</h2>");
        out.println("<table ><tr><th>User ID</th><th>Aadhar Card Number</th><th>Email</th><th>Phone</th><th>Address</th><th>Pincode</th><th>Name</th><th>New Connection Status</th></tr>");

        while (resultSet.next()) {
            out.println("<tr>");
            out.println("<td>" + resultSet.getInt("UserID") + "</td>");
            out.println("<td>" + resultSet.getLong("AadharCardNumber") + "</td>");
            out.println("<td>" + resultSet.getString("Email") + "</td>");
            out.println("<td>" + resultSet.getLong("Phone") + "</td>");
            out.println("<td>" + resultSet.getString("Address") + "</td>");
            out.println("<td>" + resultSet.getLong("Pincode") + "</td>");
            out.println("<td>" + resultSet.getString("Name") + "</td>");
            out.println("<td>" + resultSet.getString("newConnectionStatus") + "</td>");

            out.println("<td><form action=\"ApproveUserServlet\" method=\"post\">");
            out.println("<input type=\"hidden\" name=\"userId\" value=\"" + resultSet.getInt("UserID") + "\">");
            out.println("<input type=\"hidden\" name=\"email\" value=\"" + resultSet.getString("Email") + "\">");
            out.println("<input type=\"submit\" value=\"Approve\">");
            out.println("</form></td>");

            out.println("</tr>");
        }

        out.println("</table>");

out.println("</div>");
  out.println("</center>");
  out.println("<br/>");
  out.println("<div class=\"footer\">\n" +
"    <p>&diams; 2023-2024 Electricity Billing System - by ADNAN SHARIFF 1HK21IS009</p>\n" +
"  </div>");

            out.println("</body>");
            out.println("</html>");
            con.close();

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(SeeNewConnections.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SeeNewConnections.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(SeeNewConnections.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SeeNewConnections.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
