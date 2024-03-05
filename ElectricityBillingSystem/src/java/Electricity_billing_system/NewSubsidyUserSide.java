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
public class NewSubsidyUserSide extends HttpServlet {

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
    try (PrintWriter out = response.getWriter();
         Connection con = dbconnection.getConnectToElectricity_billing_system()) {

        String name = request.getParameter("name");
        long aadharCardNumber = Long.parseLong(request.getParameter("aadhar"));
        long phone = Long.parseLong(request.getParameter("phone"));
        String address = request.getParameter("address");
        long pincode = Long.parseLong(request.getParameter("pincode"));
        String newSubsidyStatus = request.getParameter("newSubsidyStatus");

        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");
       

        String sql = "UPDATE users SET Name=?, AadharCardNumber=?, Phone=?, Address=?, Pincode=?, newSubsidyStatus=? WHERE Email=?";
        out.println(newSubsidyStatus);

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setLong(2, aadharCardNumber);
            ps.setLong(3, phone);
            ps.setString(4, address);
            ps.setLong(5, pincode);
            ps.setString(6, newSubsidyStatus);

            // Assuming 'email' is obtained from the session or request parameters
            ps.setString(7, email); // Add the appropriate way to obtain 'email'

            int rowsAffected = ps.executeUpdate();
                    

            if (rowsAffected > 0) {
                // Update successful
                   out.println("<script>alert('Your request for a Subsidy has been sent. Visit your nearest Bescom office to verify and procure a new connection.'); window.location='home2.jsp';</script>");

                // Additional logic if needed
            } else {
                // Update failed
                // Additional logic if needed
                out.println("<script>alert('An unexpected error occurred.');</script>");
                                response.sendRedirect("home2.jsp");

            }
        }

        out.println("</body>");
        out.println("</html>");
    } catch (SQLException | ClassNotFoundException e) {
        // Handle exceptions appropriately
        e.printStackTrace();
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
          Logger.getLogger(NewSubsidyUserSide.class.getName()).log(Level.SEVERE, null, ex);
      } catch (ClassNotFoundException ex) {
          Logger.getLogger(NewSubsidyUserSide.class.getName()).log(Level.SEVERE, null, ex);
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
          Logger.getLogger(NewSubsidyUserSide.class.getName()).log(Level.SEVERE, null, ex);
      } catch (ClassNotFoundException ex) {
          Logger.getLogger(NewSubsidyUserSide.class.getName()).log(Level.SEVERE, null, ex);
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
