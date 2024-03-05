package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public final class home2_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("  <!-- Required meta tags -->\n");
      out.write("  <meta charset=\"utf-8\">\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write(" <link rel=\"icon\" href=\"favicon.png\" type=\"image/png\">\n");
      out.write("\n");
      out.write("  <!-- Bootstrap CSS -->\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\"\n");
      out.write("    integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\n");
      out.write("\n");
      out.write("  <!-- Link to your shared styles.css file -->\n");
      out.write("  \n");
      out.write("  <link rel=\"stylesheet\" href=\"home.css\">\n");
      out.write("\n");
      out.write("\n");
      out.write("  <title>Welcome to Electricity Billing System</title>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("  <!-- Navbar and transparent background code remains the same -->\n");
      out.write(" <!-- our code starts here -->\n");
      out.write(" <nav class=\"navbar navbar-expand-lg navbar-dark bg-dark\">\n");
      out.write("    <a class=\"navbar-brand\" href=\"#\">Electricity Billing System</a>\n");
      out.write("    <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\"\n");
      out.write("      aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("      <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("    </button>\n");
      out.write("\n");
      out.write("    <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\n");
      out.write("      <ul class=\"navbar-nav mr-auto\">\n");
      out.write("\n");
      out.write("        <li class=\"nav-item active\">\n");
      out.write("          <a class=\"nav-link\" href=\"/\">Home <span class=\"sr-only\">(current)</span></a>\n");
      out.write("        </li>\n");
      out.write("\n");
      out.write("        <li class=\"nav-item\">\n");
      out.write("          <a class=\"nav-link\" href=\"about2.jsp\">About</a>\n");
      out.write("        </li>\n");
      out.write("        \n");
      out.write("         <li class=\"nav-item \">\n");
      out.write("          <a class=\"nav-link\" href=\"contactus2.jsp\">Contact us</a>\n");
      out.write("        </li>\n");
      out.write("\n");
      out.write("        <li class=\"nav-item\">\n");
      out.write("    <a class=\"nav-link\" href=\"#\" onclick=\"confirmLogout()\">Logout</a>\n");
      out.write("</li>\n");
      out.write("\n");
      out.write("<script>\n");
      out.write("    function confirmLogout() {\n");
      out.write("        var logoutConfirmed = confirm(\"Are you sure you want to logout?\");\n");
      out.write("        if (logoutConfirmed) {\n");
      out.write("            // Redirect to home.html after logout confirmation\n");
      out.write("            window.location.href = \"home.html\";\n");
      out.write("        } else {\n");
      out.write("            // Do nothing or handle the cancellation\n");
      out.write("            alert(\"Logout cancelled.\");\n");
      out.write("        }\n");
      out.write("    }\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("      </ul>\n");
      out.write("    </div>\n");
      out.write("  </nav>\n");
      out.write(" \n");
      out.write("<main>\n");
      out.write("   <center>\n");
      out.write("    <section id=\"user-section\" style=\"border: 2px solid black; padding: 10px;\">\n");
      out.write("        ");
      out.write("\n");
      out.write("        ");
 if (session.getAttribute("email") != null) { 
      out.write("\n");
      out.write("            <h3 style=\"color: white;\">Welcome ");
      out.print( session.getAttribute("name") );
      out.write("!</h3>\n");
      out.write("            <p class=\"hidden\">Name: ");
      out.print( session.getAttribute("name") );
      out.write("</p>\n");
      out.write("            <p class=\"hidden\">Aadhar: ");
      out.print( session.getAttribute("AadharCardNumber") );
      out.write("</p>\n");
      out.write("            <p class=\"hidden\">Phone: ");
      out.print( session.getAttribute("phone") );
      out.write("</p>\n");
      out.write("            <p class=\"hidden\">Address: ");
      out.print( session.getAttribute("address") );
      out.write("</p>\n");
      out.write("            <p class=\"hidden\">Pincode: ");
      out.print( session.getAttribute("pincode") );
      out.write("</p>\n");
      out.write("            <p class=\"hidden\">new connection status: ");
      out.print( session.getAttribute("newConnectionStatus") );
      out.write("</p>\n");
      out.write("            <p class=\"hidden\">new subsidy status: ");
      out.print( session.getAttribute("newSubsidyStatus") );
      out.write("</p>\n");
      out.write("\n");
      out.write("            <style>\n");
      out.write("                .hidden {\n");
      out.write("                    display: none;\n");
      out.write("                }\n");
      out.write("            </style>\n");
      out.write("            \n");
      out.write("        ");
 } else { 
      out.write("\n");
      out.write("            <h2 style=\"color: white;\">Welcome Guest!</h2>\n");
      out.write("        ");
 } 
      out.write("\n");
      out.write("    </section>\n");
      out.write("</center>\n");
      out.write("\n");
      out.write("</main>\n");
      out.write("\n");
      out.write("\n");
      out.write("  <div class=\"container\">\n");
      out.write("    <div class=\"row\">\n");
      out.write("      <div class=\"col-md-3 text-center\">\n");
      out.write("          <center> <img src=\"p9.jpg\" class=\"bd-placeholder-img rounded-circle\" width=\"140\" height=\"140\" /></center>\n");
      out.write("        <h2>Get Subsidized rates on your bill </h2>\n");
      out.write("        <p>Discover the relief of subsidized power rates, a government-backed initiative designed to assist those facing financial challenges. These discounted rates not only lighten the burden on tight budgets but also promote sustainable energy practices. </p>\n");
      out.write("        <p class=\"mt-auto\"><a class=\"btn btn-secondary\" href=\"confirmNewSubsidyApplication.jsp\" role=\"button\" >Apply for a Subsidy</a></p>\n");
      out.write("      </div>\n");
      out.write("        <div class=\"col-md-3 text-center\">\n");
      out.write("       <center> <img src=\"p11.jpg\" class=\"bd-placeholder-img rounded-circle\" width=\"140\" height=\"140\" /></center>\n");
      out.write("        <h2>Get your bill online </h2>\n");
      out.write("        <p> \n");
      out.write("Losing your physical electricity bill is no longer a hassle with the convenience of online billing systems. Easily access and retrieve your bills at your convenience with an internet connection. By going paperless, customers contribute to environmental sustainability and save trees. </p>\n");
      out.write("        <p class=\"mt-auto\"><a class=\"btn btn-secondary\" href=\"#\" role=\"button\" >View details »</a></p>\n");
      out.write("      </div>\n");
      out.write("      <div class=\"col-md-3 text-center\">\n");
      out.write("          <center> <img src=\"p10.jpg\" class=\"bd-placeholder-img rounded-circle\" width=\"140\" height=\"140\" /></center>\n");
      out.write("        <h2>Check for Scheduled Maintenance Cuts</h2>\n");
      out.write("        <p>Stay informed about scheduled power cuts in your area. Utilize and store power in advance to minimize disruptions. Keep devices charged before hand, and optimize your energy usage for a seamless experience during scheduled maintainence cuts.    </p>\n");
      out.write("        <p class=\"mt-auto\"><a class=\"btn btn-secondary\" href=\"maintenanceUser.jsp\" role=\"button\">Check for maintenance cuts</a></p>\n");
      out.write("      </div>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("      <div class=\"col-md-3 text-center\">\n");
      out.write("    <center> <img src=\"p6.jpg\" class=\"bd-placeholder-img rounded-circle\" width=\"140\" height=\"140\" /></center>\n");
      out.write("    <h2>Get a new Electricity Connection</h2>\n");
      out.write("    <p>\n");
      out.write("        For a new electricity connection, whether for residential or commercial purposes, contact your local utility provider. Submit required documents and fees, stay informed about the application status, and enjoy the convenience of your approved connection.\n");
      out.write("    </p>\n");
      out.write("\n");
      out.write("            <p class=\"mt-auto\"><a class=\"btn btn-secondary\" href=\"confirmNewConnection.jsp\" role=\"button\">Request for a new connection</a></p>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write(" \n");
      out.write(" \n");
      out.write("    \n");
      out.write("    \n");
      out.write("  <div class=\"footer\">\n");
      out.write("  <p>&diams; 2023-2024 Electricity Billing System - Team 12</p>\n");
      out.write("  </div>\n");
      out.write("\n");
      out.write("  <!-- Bootstrap JS and dependencies -->\n");
      out.write("  <!-- Include your Bootstrap JS and dependencies here -->\n");
      out.write("  <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\"\n");
      out.write("    integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\"\n");
      out.write("    crossorigin=\"anonymous\"></script>\n");
      out.write("  <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\"\n");
      out.write("    integrity=\"sha384-U7Y9T+3b6CQs98ePjkx4U+8p7+cJz94PXXF1BOgS7I/6q1i9T8KgpvZ4Y6Jrm2Io\"\n");
      out.write("    crossorigin=\"anonymous\"></script>\n");
      out.write("  <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\"\n");
      out.write("    integrity=\"sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM\"\n");
      out.write("    crossorigin=\"anonymous\"></script>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
