package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class v_005fS3_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
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
      out.write("    \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Proyecto Tienda Virtual</title>\n");
      out.write("        <meta http-equiv=\"content-type\" content=\"TEXT/HTML; CHARSET=UTF-8\">\n");
      out.write("        <meta name=\"keywords\" content=\"keywords\">\n");
      out.write("        <meta name=\"description\" content=\"description\">\n");
      out.write("        <meta name=\"author\" content=\"\">\n");
      out.write("        <meta name=\"language\" content=\"de\">\n");
      out.write("        <meta name=\"robots\" content=\"index, follow\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/CSS/style.css\" type=\"text/css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"1000\">\n");
      out.write("            <tr>\n");
      out.write("                <td colspan=\"4\" height=\"20px\">&nbsp;</td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td width=\"20px\">&nbsp;</td>\n");
      out.write("                <td class=\"oben\" colspan=\"2\">\n");
      out.write("                    <div class=\"logo\">\n");
      out.write("                        <img src=\"images/symbol.png\" width=\"180\" height=\"130\" border=\"0\" alt=\"\">\n");
      out.write("                    </div>\n");
      out.write("                    <div id=\"textobengross\">TIENDA VIRTUAL \"SAGA FALABELLA\"</div>\n");
      out.write("                    <div id=\"textobenklein\">Sistema de compra dinámica</div>\n");
      out.write("                </td>\n");
      out.write("                <td width=\"20px\">&nbsp;</td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td width=\"20px\">&nbsp;</td>\n");
      out.write("                <td style=\"background: url(images/navbar.jpg); height: 36px; text-align: center;\" colspan=\"2\">\n");
      out.write("                    <div class=\"headernavi\">\n");
      out.write("                        <form action=\"S3\" method=\"POST\">\n");
      out.write("                            <a href=\"v_S1.jsp\">CARRITO DE COMPRAS</a>\n");
      out.write("                            <a name=\"inventario\" href=\"v_S2.jsp\">INVENTARIO</a>\n");
      out.write("                            <a name=\"proveedor\" href=\"v_S3.jsp\">PROVEEDOR</a>\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("                </td>\n");
      out.write("                <td width=\"20px\">&nbsp;</td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td width=\"20px\">&nbsp;</td>\n");
      out.write("                <td style=\"color: #000000; background-color: #FFFFFF; background: url(images/lineback.jpg) repeat-x; height: 13px;\" colspan=\"2\">&nbsp;</td>\n");
      out.write("                <td width=\"20px\">&nbsp;</td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td width=\"20px\">&nbsp;</td>\n");
      out.write("                <td class=\"hauptfenster\" valign=\"top\" align=\"center\" colspan=\"2\">\n");
      out.write("                    <div class=\"haupttext\">\n");
      out.write("                        <form action=\"S3\" method=\"GET\">\n");
      out.write("                            <div align=\"center\">\n");
      out.write("                                <h4></h4>\n");
      out.write("                                <h1>PROVEEDOR</h1>\n");
      out.write("                                <h4></h4><br>\n");
      out.write("                            </div>\n");
      out.write("                            <div align=\"center\">\n");
      out.write("                                &nbsp;&nbsp;<input type=\"text\" name=\"Cod_Proveedor\" placeholder=\" Codigo del proveedor\" style=\"width: 175px; height: 23px;\" /> &nbsp;\n");
      out.write("                                <br><br>\n");
      out.write("                                <input type=\"text\" name=\"Nombre_Proveedor\" placeholder=\" Nombre del proveedor\" style=\"width: 175px; height: 20px;\" /> &nbsp;\n");
      out.write("                                <input type=\"text\" name=\"Pais_Proveedor\" placeholder=\" Pais Residencial\" style=\"width: 175px; height: 20px;\" /> &nbsp;\n");
      out.write("                                <input type=\"text\" name=\"Telefono\" placeholder=\" Telefono del proveedor\" style=\"width: 175px; height: 20px;\" />\n");
      out.write("                                <br><br><br>\n");
      out.write("                                <input type=\"submit\" name=\"INSERTAR\" value=\"INSERTAR\" style=\"width: 175px; height: 30px;\" /> &nbsp;\n");
      out.write("                                <input type=\"submit\" name=\"ELIMINAR\" value=\"ELIMINAR\" style=\"width: 175px; height: 30px;\" /> &nbsp;\n");
      out.write("                                <input type=\"submit\" name=\"ACTUALIZAR\" value=\"ACTUALIZAR\" style=\"width: 175px; height: 30px;\" />\n");
      out.write("                            </div>\n");
      out.write("                        </form>\n");
      out.write("                        <br><br>\n");
      out.write("                        <div>\n");
      out.write("                            <table border=\"1\" width=\"100%\" cellspacing=\"2\" cellpadding=\"3\">\n");
      out.write("                                <tr>\n");
      out.write("                                    <th width=\"20%\">Codigo Proveedor</th>\n");
      out.write("                                    <th>Nombre Completo</th>\n");
      out.write("                                    <th>Pais Residencial</th>\n");
      out.write("                                    <th>Telefono</th>\n");
      out.write("                                </tr>\n");
      out.write("                                ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                            </table>\n");
      out.write("                        </div>\n");
      out.write("                        <br><br><br>\n");
      out.write("                        <textarea rows=\"8\" cols=\"60\" readonly=\"readonly\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope['consolaProveedor']}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</textarea>\n");
      out.write("                    </div>\n");
      out.write("                </td>\n");
      out.write("                <td width=\"20px\">&nbsp;</td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td  colspan=\"4\" height=\"20px\">&nbsp;</td>\n");
      out.write("            </tr>\n");
      out.write("        </table>\n");
      out.write("        <div align=\"center\">\n");
      out.write("            <a class=\"copyright\" style=\"color:#C0C0C0;background-color:#000000;\" target=\"_blank\">&nbsp;</a>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>");
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

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope['providers']}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_0.setVar("prov");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                                <tr>\n");
          out.write("                                    <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${prov[0]}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                    <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${prov[1]}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                    <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${prov[2]}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                    <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${prov[3]}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                </tr>\n");
          out.write("                              ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }
}
