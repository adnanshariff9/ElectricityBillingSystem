package Electricity_billing_system ;

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

public class LoginVerificationBE extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String email = request.getParameter("email");
            
            String pwd = request.getParameter("password");
            Connection con = dbconnection.getConnectToElectricity_billing_system();

            String sql = "SELECT * FROM users WHERE email=? AND passwordhash=?";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, email);
                ps.setString(2, pwd);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    // Valid login, create session

                    HttpSession session = request.getSession(true);
                    
                    session.setAttribute("email", email);
                    
                    session.setAttribute("userID", rs.getInt("UserID"));

                    session.setAttribute("name", rs.getString("name"));
                    session.setAttribute("AadharCardNumber", rs.getLong("AadharCardNumber"));
                    session.setAttribute("phone", rs.getLong("phone"));
                    session.setAttribute("address", rs.getString("address"));
                    session.setAttribute("pincode", rs.getLong("pincode"));
                    session.setAttribute("newConnectionStatus", rs.getString("newConnectionStatus"));
                    session.setAttribute("newSubsidyStatus",rs.getString("newSubsidyStatus"));

                                        
                    // Set the email as a request attribute
                    request.setAttribute("email", email);
                    
                    
                    // Redirect to home page
                    request.getRequestDispatcher("home2.jsp").forward(request, response);
                } else {
                    out.println("<script>alert('Invalid E-mail/Password');</script>");
                    request.getRequestDispatcher("login.html").include(request, response);
                }
            }
        } catch (Exception e) {
            // Handle exceptions appropriately
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(LoginVerificationBE.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(LoginVerificationBE.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
