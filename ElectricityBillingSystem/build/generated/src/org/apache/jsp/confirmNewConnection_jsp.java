package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public final class confirmNewConnection_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <!-- Required meta tags -->\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("    <link rel=\"icon\" href=\"favicon.png\" type=\"image/png\">\n");
      out.write("  <script src=\"https://kit.fontawesome.com/9557032e05.js\" crossorigin=\"anonymous\"></script>\n");
      out.write("\n");
      out.write("    <!-- Bootstrap CSS -->\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\"\n");
      out.write("          integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\n");
      out.write("\n");
      out.write("    <!-- Link to your shared styles.css file -->\n");
      out.write("\n");
      out.write("    <link rel=\"stylesheet\" href=\"login.css\">\n");
      out.write("\n");
      out.write("    <title>Welcome to Electricity Billing System</title>\n");
      out.write("</head>\n");
      out.write("<style> body{background-image: url('p12.jpg');}</style>\n");
      out.write("<body>\n");
      out.write("    <!-- Navbar and transparent background code remains the same -->\n");
      out.write("    <!-- our code starts here -->\n");
      out.write("    <nav class=\"navbar navbar-expand-lg navbar-dark bg-dark\">\n");
      out.write("        <a class=\"navbar-brand\" href=\"#\">Electricity Billing System</a>\n");
      out.write("        <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\"\n");
      out.write("                aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("            <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("        </button>\n");
      out.write("\n");
      out.write("        <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\n");
      out.write("            <ul class=\"navbar-nav mr-auto\">\n");
      out.write("                <!-- Your navigation items -->\n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("    </nav>\n");
      out.write("\n");
      out.write("    <main>\n");
      out.write("        <center>\n");
      out.write("            <section id=\"user-section\" style=\"border: 2px solid black; padding: 10px;\">\n");
      out.write("                ");
      out.write("\n");
      out.write("                ");
 if (session.getAttribute("email") != null) { 
      out.write("\n");
      out.write("                    <h3 style=\"color: white;\">Welcome ");
      out.print( session.getAttribute("email"));
      out.write("!</h3>\n");
      out.write("                ");
 } else { 
      out.write("\n");
      out.write("                    <h2 style=\"color: white;\">Welcome Guest!</h2>\n");
      out.write("                ");
 } 
      out.write("\n");
      out.write("            </section>\n");
      out.write("        </center>\n");
      out.write("\n");
      out.write("    </main>\n");
      out.write("\n");
      out.write("   \n");
      out.write("\n");
      out.write("           <div class=\"container\">\n");
      out.write("    <h2>Confirm details for New Connection</h2>\n");
      out.write("    <!-- Add a form for confirmation and update -->\n");
      out.write("    <form action=\"NewConnectionUsers\" method=\"post\">\n");
      out.write("\n");
      out.write("        <div class=\"box\">\n");
      out.write("            <i class=\"fa-solid fa-user\"></i>\n");
      out.write("            <input type=\"text\" id=\"name\" name=\"name\" placeholder=\"Name\" value=\"");
      out.print( session.getAttribute("name") );
      out.write("\" required>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"box\">\n");
      out.write("            <i class=\"fa-solid fa-id-card\"></i>\n");
      out.write("            <input type=\"text\" id=\"aadhar\" name=\"aadhar\" placeholder=\"Aadhar number\" value=\"");
      out.print( session.getAttribute("AadharCardNumber") );
      out.write("\" required>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"box\">\n");
      out.write("            <i class=\"fa-solid fa-phone\"></i>\n");
      out.write("            <input type=\"tel\" id=\"phone\" name=\"phone\" placeholder=\"Phone Number\" value=\"");
      out.print( session.getAttribute("phone") );
      out.write("\" required>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"box\">\n");
      out.write("            <i class=\"fa-solid fa-location-dot\"></i>\n");
      out.write("            <input type=\"text\" id=\"address\" name=\"address\" placeholder=\"Address\" value=\"");
      out.print( session.getAttribute("address") );
      out.write("\" required>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"box\">\n");
      out.write("            <i class=\"fa-solid fa-map-location-dot\"></i>\n");
      out.write("            <input type=\"text\" name=\"pincode\" id=\"pincode\" placeholder=\"Pincode\" value=\"");
      out.print( session.getAttribute("pincode") );
      out.write("\" required>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        <div class=\"box\">\n");
      out.write("            <i class=\"fa-solid fa-check-to-slot\"></i>\n");
      out.write("    <select id=\"newConnectionStatus\" name=\"newConnectionStatus\" required>\n");
      out.write("        <option value=\"not applied\" ");
 if ("not applied".equals(session.getAttribute("newConnectionStatus"))) { 
      out.write("selected");
 } 
      out.write(">Not Applied</option>\n");
      out.write("        <option value=\"applied\" ");
 if ("applied".equals(session.getAttribute("newConnectionStatus"))) { 
      out.write("selected");
 } 
      out.write(">Apply</option>\n");
      out.write("    </select>\n");
      out.write("</div>\n");
      out.write("<br/>\n");
      out.write("\n");
      out.write("     \n");
      out.write("\n");
      out.write("        <!-- Add a submit button for the confirmation and update -->\n");
      out.write("        \n");
      out.write("        <button type=\"submit\">Confirm and Update</button>\n");
      out.write("    </form>\n");
      out.write("</div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <div class=\"footer\">\n");
      out.write("        <p>&diams; 2023-2024 Electricity Billing System - Team 12</p>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <!-- Bootstrap JS and dependencies -->\n");
      out.write("    <!-- Include your Bootstrap JS and dependencies here -->\n");
      out.write("    <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\"\n");
      out.write("            integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\"\n");
      out.write("            crossorigin=\"anonymous\"></script>\n");
      out.write("    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\"\n");
      out.write("            integrity=\"sha384-U7Y9T+3b6CQs98ePjkx4U+8p7+cJz94PXXF1BOgS7I/6q1i9T8KgpvZ4Y6Jrm2Io\"\n");
      out.write("            crossorigin=\"anonymous\"></script>\n");
      out.write("    <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\"\n");
      out.write("            integrity=\"sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM\"\n");
      out.write("            crossorigin=\"anonymous\"></script>\n");
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
