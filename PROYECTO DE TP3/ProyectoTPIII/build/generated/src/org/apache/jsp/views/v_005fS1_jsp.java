package org.apache.jsp.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class v_005fS1_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\n");
      out.write("   \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("   <head>\n");
      out.write("      <title>My Website of www.website-templates.info</title>\n");
      out.write("      <meta http-equiv=\"content-type\" content=\"TEXT/HTML; CHARSET=UTF-8\">\n");
      out.write("      <meta name=\"keywords\" content=\"keywords\">\n");
      out.write("      <meta name=\"description\" content=\"description\">\n");
      out.write("      <meta name=\"author\" content=\"\">\n");
      out.write("      <meta name=\"language\" content=\"de\">\n");
      out.write("      <meta name=\"robots\" content=\"index, follow\">\n");
      out.write("      <link rel=\"stylesheet\" href=\"/views/CSS/style.css\" type=\"text/css\">\n");
      out.write("   </head>\n");
      out.write("   <body>\n");
      out.write("      <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"950\">\n");
      out.write("         <tr>\n");
      out.write("            <td  colspan=\"4\" height=\"20px\">&nbsp;</td>\n");
      out.write("         </tr>\n");
      out.write("         <tr>\n");
      out.write("            <td width=\"20px\">&nbsp;</td>\n");
      out.write("            <td class=\"oben\" colspan=\"2\">\n");
      out.write("               <div class=\"logo\">\n");
      out.write("                   <img src=\"images/testlogo.gif\" width=\"180\" height=\"130\" border=\"0\" alt=\"\">\n");
      out.write("               </div>\n");
      out.write("               <div id=\"textobengross\">My beautiful new website</div>\n");
      out.write("               <div id=\"textobenklein\">Here you find all information you need</div>\n");
      out.write("            </td>\n");
      out.write("            <td width=\"20px\">&nbsp;</td>\n");
      out.write("         </tr>\n");
      out.write("         <tr>\n");
      out.write("            <td width=\"20px\">&nbsp;</td>\n");
      out.write("            <td id=\"navioben\" colspan=\"2\">\n");
      out.write("               <div class=\"headernavi\">\n");
      out.write("                   <a href=\"index.html\">Link 1</a>\n");
      out.write("                   <a href=\"page2.html\">Link 2</a>\n");
      out.write("                   <a href=\"#\">Link 3</a>\n");
      out.write("                   <a href=\"#\">Link 4</a>\n");
      out.write("                   <a href=\"#\">Link 5</a>\n");
      out.write("                   <a href=\"#\">Link 6</a>\n");
      out.write("                   <a href=\"#\">Link 7</a>\n");
      out.write("               </div>\n");
      out.write("            </td>\n");
      out.write("            <td width=\"20px\">&nbsp;</td>\n");
      out.write("         </tr>\n");
      out.write("         <tr>\n");
      out.write("            <td width=\"20px\">&nbsp;</td>\n");
      out.write("            <td class=\"zwischen\" colspan=\"2\">&nbsp;</td>\n");
      out.write("            <td width=\"20px\">&nbsp;</td>\n");
      out.write("         </tr>\n");
      out.write("         <tr>\n");
      out.write("            <td width=\"20px\">&nbsp;</td>\n");
      out.write("            <td valign=\"top\" class=\"links\">\n");
      out.write("               <div class=\"naviueberschrift\">Title 1</div>\n");
      out.write("               <div class=\"zwischen2\">&nbsp;</div>\n");
      out.write("               <ul class=\"menue\">\n");
      out.write("                  <li><a title=\"Home\" href=\"index.html\">&raquo; Home</a></li>\n");
      out.write("                  <li><a title=\"Page 2\" href=\"page2.html\">&raquo; Page 2</a></li>\n");
      out.write("                  <li><a title=\"Page 3\" href=\"#\">&raquo; Page 3</a></li>\n");
      out.write("                  <li><a title=\"Page 4\" href=\"#\">&raquo; Page 4</a></li>\n");
      out.write("                  <li><a title=\"Page 5\" href=\"#\">&raquo; Page 5</a></li>\n");
      out.write("                  <li><a title=\"Page 6\" href=\"#\">&raquo; Page 6</a></li>\n");
      out.write("               </ul>\n");
      out.write("            </td>\n");
      out.write("            <td class=\"hauptfenster\" valign=\"top\">\n");
      out.write("               <div class=\"haupttext\">\n");
      out.write("                  <h1>H1-Heading</h1>\n");
      out.write("                  <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus bibendum lacus ac elit ornare sagittis. Nam faucibus pharetra erat a adipiscing. Morbi ultrices commodo nibh vitae convallis. Sed a arcu id dui feugiat mollis.</p>\n");
      out.write("                  <h2>H2-Heading</h2>\n");
      out.write("                  <p>Donec vel libero erat. Duis lacinia turpis vitae neque tincidunt nec hendrerit urna tristique. Pellentesque ultrices, nulla id pulvinar ultricies, dolor ante feugiat felis, non venenatis augue arcu non nunc.</p>\n");
      out.write("                  <h3>H3-Heading</h3>\n");
      out.write("                  <p>Integer commodo dapibus metus at blandit. Etiam et magna sit amet elit lobortis tempor. Maecenas vitae dolor vitae nunc elementum vehicula. Maecenas et diam enim, non aliquam libero.</p>\n");
      out.write("                  <h4>H4-Heading</h4>\n");
      out.write("                  <p>Aenean facilisis ultricies eros et pretium. Morbi a est magna. Etiam convallis sollicitudin augue. Nunc dapibus eros vel enim vehicula non ultrices tortor tincidunt. Donec nunc lectus, ullamcorper nec mattis eu, dictum in nibh. Donec sagittis ultrices sagittis.</p>\n");
      out.write("                  <h5>H5-Heading</h5>\n");
      out.write("                  <p>Aliquam cursus volutpat lorem, eu aliquam magna venenatis quis. Donec vitae sagittis eros. Fusce semper convallis ligula, non consectetur ante lacinia vitae. Morbi elementum orci ac nisl aliquet pretium sit amet eu lectus. Praesent egestas sem vel justo fringilla a luctus velit gravida.</p>\n");
      out.write("                  <hr noshade size=\"1\">\n");
      out.write("                  <h4>This template is linkware</h4>\n");
      out.write("                  <p>That means:</p>\n");
      out.write("                  <ul>\n");
      out.write("                     <li>You may use this template free of charge if the link to www.website-templates.info remains unchanged. Please read the <a href=\"http://www.website-templates.info/terms-of-use.html\" target=\"_blank\">terms for free use</a> to read all details. With download of this template you accept these rules.</li>\n");
      out.write("                  </ul>\n");
      out.write("               </div>\n");
      out.write("            </td>\n");
      out.write("            <td width=\"20px\">&nbsp;</td>\n");
      out.write("         </tr>\n");
      out.write("         <tr>\n");
      out.write("            <td  colspan=\"4\" height=\"20px\">&nbsp;</td>\n");
      out.write("         </tr>\n");
      out.write("      </table>\n");
      out.write("   </body>\n");
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
