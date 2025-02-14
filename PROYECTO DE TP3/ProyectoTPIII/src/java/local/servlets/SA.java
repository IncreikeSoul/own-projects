package local.servlets;

import java.io.IOException;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import local.utils.MicroModelGUI;

public class SA extends HttpServlet{

    private static MicroModelGUI microModelGUI = new MicroModelGUI();
    private static Statement statement;
    
    static {
        statement = microModelGUI.createStatement();
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (action(request, response) == false) {
            error(request, response);
            return;
        }
        view(request, response);
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
        processRequest(request, response);
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
        processRequest(request, response);
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

    
    private boolean action(HttpServletRequest request, HttpServletResponse response) {
        String btnINICIO = request.getParameter("START");
        List listaNombres = null;
        List listaTabla = null;
        List listaTablaEliminar = null;
        
        if (btnINICIO != null){
            try {
                listaNombres = excecuteSQLSpecific1();
                listaTablaEliminar = excecuteSQLSpecific2();
                listaTabla = excecuteSQLSpecific5();
            } catch (SQLException ex) {
                request.setAttribute("error", "EXCEPCIÓN CONTROLADA #02: " + MicroModelGUI.resolveException(ex));
              }
        }
        HttpSession session = request.getSession(false);
        session.setAttribute("getNombres", listaNombres);
        session.setAttribute("getNombresDelete", listaTablaEliminar);
        session.setAttribute("datos", listaTabla);
        return true;
    }

    private void view(HttpServletRequest request, HttpServletResponse response) {
        ServletContext context = this.getServletContext();
        RequestDispatcher view = context.getRequestDispatcher("/v_S1.jsp");
        
        try {
            view.forward(request, response);
        } catch (ServletException | IOException ex) {
            request.setAttribute("error", "EXCEPCION CONTROLADA #01: "+ex);
        }
        
    }

    private void error(HttpServletRequest request, HttpServletResponse response) {
        ServletContext context = this.getServletContext();
        RequestDispatcher view = context.getRequestDispatcher("/VIEWS/error.jsp");
        try {
            view.forward(request, response);
        } catch (ServletException | IOException ex) {
            System.out.println("EXCEPCION CONTROLADA COD/Error: "+ex);
        }
    }

    public String excecuteSQL(String sql) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List excecuteSQLSpecific1() throws SQLException {
        String sql = "SELECT    NOMBRE_PROD "
                   + "FROM      ARTICULOS "
                   + "ORDER BY  COD_PRO_EMP ";
        
        ResultSet resultSet = MicroModelGUI.executeQuery(statement, sql);
        List lista = new ArrayList();
        
        try {
            while (resultSet.next()) {
                String nombreProducto =resultSet.getString(1);

                String []nombre = {nombreProducto};
                lista.add(nombre);
            }
        } catch(SQLException e) {
            throw new SQLException(MicroModelGUI.resolveException(e));
        }
        return lista;
    }
    
    public List excecuteSQLSpecific2() throws SQLException {
        String sql = "SELECT    ART.NOMBRE_PROD "
                
                   + "FROM      ARTICULOS AS ART INNER JOIN "
                   + "          CARRITO AS CAR "
                
                   + "ON       (CAR.ID_COD_PRO_EMP = ART.COD_PRO_EMP)"
                
                   + "ORDER BY  COD_PRO_EMP ";
        
        ResultSet resultSet = MicroModelGUI.executeQuery(statement, sql);
        List lista = new ArrayList();
        
        try {
            while (resultSet.next()) {
                String nombreProducto =resultSet.getString(1);

                String []nombre = {nombreProducto};
                lista.add(nombre);
            }
        } catch(SQLException e) {
            throw new SQLException(MicroModelGUI.resolveException(e));
        }
        return lista;
    }
    
    public List excecuteSQLSpecific5() throws SQLException {
        String sql = "SELECT    ART.COD_PRO_EMP, "
                   + "          ART.COD_PRO_FAB, "
                   + "          PRO.NOMBRE_PROOVEDOR, "
                   + "          ART.NOMBRE_PROD, "
                   + "          CAR.CANTIDAD, "
                   + "          ART.PRECIO_U "
                
                   + "FROM      ARTICULOS AS ART INNER JOIN "
                   + "          PROOVEDOR AS PRO INNER JOIN "
                   + "          CARRITO AS CAR "
                   
                   + "ON       (PRO.CODIGO_PROOVEDOR = ART.PROOVEDOR_CODIGO_PROOVEDOR AND "
                   + "          ART.COD_PRO_EMP = CAR.ID_COD_PRO_EMP                  AND "
                   + "          ART.COD_PRO_FAB = CAR.ID_COD_PRO_FAB)";
        
        ResultSet resultSet = MicroModelGUI.executeQuery(statement, sql);
        List lista = new ArrayList();
        
        try {
            while (resultSet.next()) {
                String COD_PRO_EMP = resultSet.getString(1);
                String COD_PRO_FAB = resultSet.getString(2);
                String NOMBRE_PROOVEDOR = resultSet.getString(3);
                String NOMBRE_PROD = resultSet.getString(4);
                String CANTIDAD = resultSet.getString(5);
                String PRECIO_U = resultSet.getString(6);
                
                String[] carrito = {COD_PRO_EMP, COD_PRO_FAB, NOMBRE_PROOVEDOR, NOMBRE_PROD, CANTIDAD, PRECIO_U};

                lista.add(carrito);
            }
        } catch(SQLException e) {
            throw new SQLException(MicroModelGUI.resolveException(e));
        }
        return lista;
    }
    
}