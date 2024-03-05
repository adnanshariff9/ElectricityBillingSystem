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
import javax.servlet.http.HttpSession;

/**
 *
 * @author hp
 */
public class SignupBE extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet signupBE</title>");            
            out.println("</head>");
            out.println("<body>");
           
            String name=request.getParameter("name");
            String email=request.getParameter("email");
            String address=request.getParameter("address");
            long pincode=Long.parseLong(request.getParameter("pincode"));
            long ph_no=Long.parseLong(request.getParameter("phone"));
                        long aadhar=Long.parseLong(request.getParameter("aadhar"));
            String pwd=request.getParameter("password");
            
    
            
            //JDBC steps
            Connection con=dbconnection.getConnectToElectricity_billing_system();
            String sql="INSERT INTO users( name,aadharCardNumber,email,phone,address,Pincode,passwordhash) values(?,?,?,?,?,?,?)";
             PreparedStatement ps=con.prepareStatement(sql);
            
             ps.setString(1, name);
             ps.setLong(2,aadhar);
             ps.setString(3, email);
             ps.setLong(4,ph_no);
             ps.setString(5,address);
             ps.setLong(6, pincode);
             ps.setString(7,pwd);
             
            
            
           int rowsAffected = ps.executeUpdate(); // Use executeUpdate for INSERT queries

            if (rowsAffected > 0) {
                out.println("<script>alert('Account created');</script>");

                HttpSession session = request.getSession(true);
                session.setAttribute("email", email);
                session.setAttribute("name", name);
                session.setAttribute("AadharCardNumber", aadhar);
                session.setAttribute("phone", ph_no);
                session.setAttribute("address", address);
                session.setAttribute("pincode", pincode);

                // Redirect to home page
                response.sendRedirect("home2.jsp");
            } else {
                out.println("<script>alert('Account creation failed');</script>");
            }
            con.close();
           // out.println("<h1>Servlet signupBE at " + request.getContextPath() + "</h1>");
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
            try {
                processRequest(request, response);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(SignupBE.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SignupBE.class.getName()).log(Level.SEVERE, null, ex);
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
            try {
                processRequest(request, response);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(SignupBE.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SignupBE.class.getName()).log(Level.SEVERE, null, ex);
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
