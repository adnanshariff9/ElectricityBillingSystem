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

public class ProcessSubsidyApproval extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        String email = request.getParameter("email");
        String meterId = request.getParameter("meterId");
        String aplORbplCardNo = request.getParameter("aplORbplCardNo");
        String subsidyType = request.getParameter("subsidyType");

        // Insert data into subsidies table without SubsidyRate
        try (Connection con = dbconnection.getConnectToElectricity_billing_system()) {
            String insertSql = "INSERT INTO subsidies (UserID, MeterID, aplORbplCardNo, SubsidyType) VALUES (?, ?, ?, ?)";
            try (PreparedStatement insertStatement = con.prepareStatement(insertSql)) {
                insertStatement.setInt(1, userId);
                insertStatement.setString(2, meterId);
                insertStatement.setString(3, aplORbplCardNo);
                insertStatement.setString(4, subsidyType);

                insertStatement.executeUpdate();
            }

            // Update newSubsidyStatus in users table
            String updateSql = "UPDATE users SET newSubsidyStatus = 'existing' WHERE UserID = ?";
            try (PreparedStatement updateStatement = con.prepareStatement(updateSql)) {
                updateStatement.setInt(1, userId);
                updateStatement.executeUpdate();
            }
        } catch (SQLException | ClassNotFoundException ex) {
            // Handle exceptions
            ex.printStackTrace();
        }

        // Set a success message in the request attribute
        request.setAttribute("approvalMessage", "Your subsidy request has been approved!");

        // Forward the request to the JSP page
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Subsidy Approval Result</title>");
            // Add your CSS links here
            out.println("<link rel=\"stylesheet\" href=\"your-styles.css\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class=\"container\">");
            out.println("<script>");
            out.println("alert(\"" + request.getAttribute("approvalMessage") + "\");");
            // Redirect to another page if needed
            out.println("window.location.href = \"adminhome.html\";");
            out.println("</script>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // ... (existing code)

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    // ... (existing code)
}
