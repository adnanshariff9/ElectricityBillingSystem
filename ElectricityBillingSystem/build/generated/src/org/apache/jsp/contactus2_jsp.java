package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public final class contactus2_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("  <!-- Required meta tags -->\n");
      out.write("  <meta charset=\"utf-8\">\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("  <link rel=\"icon\" href=\"favicon.png\" type=\"image/png\">\n");
      out.write("\n");
      out.write("  <!-- Bootstrap CSS -->\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\"\n");
      out.write("    integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\n");
      out.write("\n");
      out.write("  <!-- Link to your shared styles.css file -->\n");
      out.write("  <link rel=\"stylesheet\" href=\"about.css\">\n");
      out.write("  \n");
      out.write("  <style>\n");
      out.write("    .map-container {\n");
      out.write("      display: flex;\n");
      out.write("      justify-content: space-around;\n");
      out.write("      background-color: rgba(255, 255, 255, 0.5); /* White background with 50% transparency */\n");
      out.write("      padding: 20px;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    iframe {\n");
      out.write("      border: 2px solid black; /* Optional: adds a border around each iframe */\n");
      out.write("    }\n");
      out.write("  </style>\n");
      out.write("\n");
      out.write("  <title>Welcome to Electricity Billing System</title>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("  <!-- Navbar -->\n");
      out.write("  <nav class=\"navbar navbar-expand-lg navbar-dark bg-dark\">\n");
      out.write("    <a class=\"navbar-brand\" href=\"home.html\">Electricity Billing System</a>\n");
      out.write("    <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\"\n");
      out.write("      aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("      <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("    </button>\n");
      out.write("\n");
      out.write("    <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\n");
      out.write("      <ul class=\"navbar-nav mr-auto\">\n");
      out.write("        <li class=\"nav-item\">\n");
      out.write("          <a class=\"nav-link\" href=\"home.html\">Home</a>\n");
      out.write("        </li>\n");
      out.write("        <li class=\"nav-item\">\n");
      out.write("          <a class=\"nav-link\" href=\"about.html\">About</a>\n");
      out.write("        </li>\n");
      out.write("        <li class=\"nav-item active\">\n");
      out.write("          <a class=\"nav-link\" href=\"contactus.html\">Contact us</a>\n");
      out.write("        </li>\n");
      out.write("           <li class=\"nav-item\">\n");
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
      out.write("      </ul>\n");
      out.write("    </div>\n");
      out.write("  </nav>\n");
      out.write("      <main>\n");
      out.write("   <center>\n");
      out.write("    <section id=\"user-section\" style=\"border: 2px solid black; padding: 10px;\">\n");
      out.write("        ");
      out.write("\n");
      out.write("        ");
 if (session.getAttribute("email") != null) { 
      out.write("\n");
      out.write("            <h3 style=\"color: white;\">Welcome ");
      out.print( session.getAttribute("email") );
      out.write("!</h3>\n");
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
      out.write("<center><u> <h2>Visit our Offices :-</h2></u></center>\n");
      out.write("\n");
      out.write("  <!-- Map Section -->\n");
      out.write("  <div class=\"map-container\">\n");
      out.write("    <div>\n");
      out.write("      <h3>Head Office</h3>\n");
      out.write("<iframe src=\"https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d15551.7590324057!2d77.5880664!3d12.9757049!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3bae167253b099d5%3A0x6a4ef44dbc2cecf1!2sBESCOM%20Corporate%20office!5e0!3m2!1sen!2sin!4v1713722834454!5m2!1sen!2sin\" width=\"400\" height=\"300\" style=\"border:0;\" allowfullscreen=\"\" loading=\"lazy\" referrerpolicy=\"no-referrer-when-downgrade\"></iframe>\n");
      out.write("    </div>\n");
      out.write("    <div>\n");
      out.write("      <h3>North Zonal Office</h3>\n");
      out.write("<iframe src=\"https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d15550.327386753797!2d77.60037560000004!3d12.998575600000006!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3bae165a4b372f83%3A0x970c4953ebbeb532!2sBESCOM%20North%20Zonal%20Office!5e0!3m2!1sen!2sin!4v1713722774761!5m2!1sen!2sin\" width=\"400\" height=\"300\" style=\"border:0;\" allowfullscreen=\"\" loading=\"lazy\" referrerpolicy=\"no-referrer-when-downgrade\"></iframe>\n");
      out.write("    </div>\n");
      out.write("    <div>\n");
      out.write("      <h3>South Zonal Office</h3>\n");
      out.write("<iframe src=\"https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3887.9844577728113!2d77.58385797489301!3d12.972845787342683!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3bae1673673002f9%3A0xa5ee0fcdf7c08fc2!2sBESCOM%20SOUTH%20ZONE%20OFFICE!5e0!3m2!1sen!2sin!4v1713722377318!5m2!1sen!2sin\" width=\"400\" height=\"300\" style=\"border:0;\" allowfullscreen=\"\" loading=\"lazy\" referrerpolicy=\"no-referrer-when-downgrade\"></iframe>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("\n");
      out.write("  <!-- Footer -->\n");
      out.write("  <div class=\"footer\">\n");
      out.write("    <p>&diams; 2023-2024 Electricity Billing System - Team 12</p>\n");
      out.write("  </div>\n");
      out.write("\n");
      out.write("  <!-- Bootstrap JS and dependencies -->\n");
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
