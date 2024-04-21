/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Electricity_billing_system ;

import DBconnection.dbconnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hp
 */
public class isPowerAvailable extends HttpServlet {

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
          long pincode = Long.parseLong(request.getParameter("pincode"));

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link rel=\"icon\" href=\"favicon.png\" type=\"image/png\">");
            out.println("<title>Power Availability Information</title>");
           
            //css styling
   out.println("<style>");
out.println("body {");
out.println("    background-image: url('p12.jpg');");
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
out.println("    width: 400px;");
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
out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<center>");
            out.println("<div class=\"container\">");
            out.println("<h1>Power Availability Information</h1>");

            try (Connection con = dbconnection.getConnectToElectricity_billing_system()) {
                String sql = "SELECT * FROM PowerAvailability WHERE Pincode=?";
                try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
                    preparedStatement.setLong(1, pincode);
                    try (ResultSet rs = preparedStatement.executeQuery()) {
                        
                        
                        out.println("<table>");
                        out.println("<tr><th>Pincode</th><th>Availability</th><th>Last Updated</th><th>Expected Outage till</th></tr>");

                        while (rs.next()) {
                            out.println("<tr>");
                            out.println("<td>" + rs.getLong("Pincode") + "</td>");
                            out.println("<td>"+rs.getString("IsPowerAvailable")+"</td>");
                           
                            
                            out.println("<td>" + rs.getTimestamp("LastUpdated") + "</td>");
                            out.println("<td>" + rs.getTimestamp("expectedOutageTime") + "</td>");
                            out.println("</tr>");
                        }

                        out.println("</table>");
                        
                      

                    }
                }
            } catch (SQLException e) {
                e.printStackTrace(); // Handle the exception according to your application's needs
                out.println("<p>Error accessing the database.</p>");
            }
            
            //css styling
             out.println("<style>");
        out.println(".return-button {");
        out.println("    background-color: #4CAF50;");
        out.println("    color: white;");
        out.println("    padding: 10px 20px;");
        out.println("    text-align: center;");
        out.println("    text-decoration: none;");
        out.println("    display: inline-block;");
        out.println("    font-size: 16px;");
        out.println("    cursor: pointer;");
        out.println("}");
        out.println(".return-button:hover {");
        out.println("    background-color:#08350a;");
        out.println("}");
        out.println("</style>");
            out.println("<a href='home2.jsp' class='return-button'>Return to Home</a>");
out.println("</div>");
  out.println("</center>");
  out.println("<br/>");
  out.println("<div class=\"footer\">\n" +
"    <p>&diams; 2023-2024 Electricity Billing System - by Adnan Shariff 1HK21IS009</p>\n" +
"  </div>");
            out.println("</body>");
            out.println("</html>");
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
            Logger.getLogger(isPowerAvailable.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(isPowerAvailable.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(isPowerAvailable.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(isPowerAvailable.class.getName()).log(Level.SEVERE, null, ex);
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
