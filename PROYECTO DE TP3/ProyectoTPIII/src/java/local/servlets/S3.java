package local.servlets;

import java.io.IOException;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import local.utils.MicroModelGUI;
import local.utils.Utilities;

public class S3 extends HttpServlet {

    private static MicroModelGUI microModelGUI = new MicroModelGUI();
    private static Statement statement;
    
    static {
        statement = microModelGUI.createStatement();
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
        
        super.init(config);
    }

    private final String MSG_ERROR = " \n"
                                   + "                              ERROR ENCONTRADO / INGRESO NO VALIDO\n"
                                   + "\n";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (form(request, response) == false) {
            view(request, response);
            return;
        }
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

    
    private boolean form(HttpServletRequest request, HttpServletResponse response) {
        String btnINSERTAR = request.getParameter("INSERTAR");
        String btnELIMINAR = request.getParameter("ELIMINAR");
        String btnACTUALIZAR = request.getParameter("ACTUALIZAR");
        String btnGETDATOS = request.getParameter("GET_DATOS");
        
        String codigoProveedor = request.getParameter("Cod_Proveedor");
        String nombreProveedor = request.getParameter("Nombre_Proveedor");
        String paisProveedor = request.getParameter("Pais_Proveedor");
        String telefono = request.getParameter("Telefono");
        
        String evento;
        
        if (btnGETDATOS != null){
            evento = "Get Datos";
            if (CodigoProveedorEditaryEliminar(request, codigoProveedor, evento)==false){
                return false;
            }
        }
        
        if (btnINSERTAR != null) {
            evento = "Insertar";
            if(CodigoProveedorInsertar(request, codigoProveedor, evento)==false){
                return false;
            }
            if(NombreProveedor(request, nombreProveedor, evento)==false){
                return false;
            }
            if(PaisProveedor(request, paisProveedor, evento)==false){
                return false;
            }
            if(Telefono(request, telefono, evento)==false){
                return false;
            }
        }
        if (btnELIMINAR != null) {
            evento = "Eliminar";
            if(CodigoProveedorEditaryEliminar(request, codigoProveedor, evento)==false){
                return false;
            }
        }
        if (btnACTUALIZAR != null) {
            evento = "Actualizar";
            if(CodigoProveedorEditaryEliminar(request, codigoProveedor, evento)==false){
                return false;
            }
            if(NombreProveedor(request, nombreProveedor, evento)==false){
                return false;
            }
            if(PaisProveedor(request, paisProveedor, evento)==false){
                return false;
            }
            if(Telefono(request, telefono, evento)==false){
                return false;
            }
        }
        return true;
    }

// VALIDACION
    private boolean CodigoProveedorInsertar(HttpServletRequest request, String codProve, String evento) {
        try {
            int cont = codProve.length();
            String ret = null;
            
            if (codProve.isEmpty()) {
                throw new Exception(MSG_ERROR + "PROVIENE DE:    Codigo del Proveedor\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            No deje en blanco este casillero.");
            }
            if (codProve.startsWith(" ")) {
                throw new Exception(MSG_ERROR + "PROVIENE DE:    Codigo del Proveedor\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            No deje espacios en blanco.");
            }
            if (codProve.startsWith("-")) {
                throw new Exception(MSG_ERROR + "PROVIENE DE:    Codigo del Proveedor\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            No puede ser un numero negativo.");
            }
            if (!Utilities.esDigito(codProve)) {
                throw new Exception(MSG_ERROR + "PROVIENE DE:    Codigo del Proveedor\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            No debe contener ningun otro caracter o simbolo\n"
                                              + "                             a excepcion de cualquier digito.");
            }
            if (cont < 0) {
                throw new Exception(MSG_ERROR + "PROVIENE DE:    Codigo del Proveedor\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            FALSE: No puede ser menor que 0.");
            }
            
            try {
                ret = excecuteSQLSpecific1(codProve);
            } catch (SQLException ex) {
                request.setAttribute("error", "EXCEPCIÓN CONTROLADA #04: "+ex);
            }
            
            if (ret.equals("true")) {
                throw new Exception(MSG_ERROR + "PROVIENE DE:    Codigo del Proveedor\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            YA existe este codigo del proveedor.");
            }
        }catch(Exception e) {
            request.setAttribute("consolaProveedor", e.getMessage());
            return false;
        }
        return true;
    }
    private boolean NombreProveedor(HttpServletRequest request, String nombProve, String evento) {
        try {
            int contNombre = nombProve.length();

            if (nombProve.isEmpty()) {
                throw new Exception(MSG_ERROR + "PROVIENE DE:    Nombre del Proveedor\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            No deje en blanco este casillero.");
            }
            if (nombProve.startsWith(" ")) {
                throw new Exception(MSG_ERROR + "PROVIENE DE:    Nombre del Proveedor\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            No deje espacios en blanco.");
            }
            if (contNombre > 40) {
                throw new Exception(MSG_ERROR + "PROVIENE DE:    Nombre del Proveedor\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            No debe tener mas de 40 caracteres.");
            }
            if (!Utilities.esLetraOConEspacio(nombProve)){
                throw new Exception(MSG_ERROR + "PROVIENE DE:    Nombre del Proveedor\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            No debe contener ningun digito o simbolo,\n"
                                              + "                             solo caracter alfabetico.");
            }

        } catch (Exception e) {
            request.setAttribute("consolaProveedor", e.getMessage());
            return false;
        }
        return true;
    }
    private boolean PaisProveedor(HttpServletRequest request, String paisProve, String evento) {
        try {
            int contPais = paisProve.length();

            if (paisProve.isEmpty()) {
                throw new Exception(MSG_ERROR + "PROVIENE DE:    Pais Residencial\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            No deje en blanco este casillero.");
            }
            if (paisProve.startsWith(" ")) {
                throw new Exception(MSG_ERROR + "PROVIENE DE:    Pais Residencial\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            No deje espacios en blanco.");
            }
            if (contPais > 40) {
                throw new Exception(MSG_ERROR + "PROVIENE DE:    Pais Residencial\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            No debe tener mas de 40 caracteres.");
            }
            if (!Utilities.esLetraOConEspacio(paisProve)){
                throw new Exception(MSG_ERROR + "PROVIENE DE:    Pais Residencial\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            No debe contener ningun digito o simbolo,\n"
                                              + "                             solo caracter alfabetico.");
            }

        } catch (Exception e) {
            request.setAttribute("consolaProveedor", e.getMessage());
            return false;
        }
        return true;
    }
    private boolean Telefono(HttpServletRequest request, String telefono, String evento) {
        try {
            int contTele = telefono.length();

            if (telefono.isEmpty()) {
                throw new Exception(MSG_ERROR + "PROVIENE DE:    Telefono\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            No deje en blanco este casillero.");
            }
            if (telefono.startsWith(" ")) {
                throw new Exception(MSG_ERROR + "PROVIENE DE:    Telefono\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            No deje espacios en blanco.");
            }
            if (contTele != 7) {
                Exception e = new Exception(MSG_ERROR + "PROVIENE DE:    Telefono\n"
                                                      + "EVENTO:              Click \""+evento+"\" \n"
                                                      + "MENSAJE:            Solamente 7 digitos puesto que es un telefono fijo.");
                throw e;
            }
            if (!Utilities.esDigito(telefono)){
                throw new Exception(MSG_ERROR + "PROVIENE DE:    Telefono\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            No debe contener ningun otro caracter o simbolo\n"
                                                      + "                             a excepcion de cualquier digito.");
            }

        } catch (Exception e) {
            request.setAttribute("consolaProveedor", e.getMessage());
            return false;
        }
        return true;
    }
    private boolean CodigoProveedorEditaryEliminar(HttpServletRequest request, String codProve, String evento) {
        try {
            int cont = codProve.length();
            String ret = null;

            if (codProve.isEmpty()) {
                throw new Exception(MSG_ERROR + "PROVIENE DE:    Codigo del Proveedor\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            No deje en blanco este casillero.");
            }
            if (codProve.startsWith(" ")) {
                throw new Exception(MSG_ERROR + "PROVIENE DE:    Codigo del Proveedor\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            No deje espacios en blanco.");
            }
            if (codProve.startsWith("-")) {
                throw new Exception(MSG_ERROR + "PROVIENE DE:    Codigo del Proveedor\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            No puede ser un numero negativo.");
            }
            if (!Utilities.esDigito(codProve)) {
                        throw new Exception(MSG_ERROR + "PROVIENE DE:    Codigo del Proveedor\n"
                                                      + "EVENTO:              Click \""+evento+"\" \n"
                                                      + "MENSAJE:            No debe contener ningun otro caracter o simbolo\n"
                                                      + "                             a excepcion de cualquier digito.");                
            }
            if (cont < 0) {
                throw new Exception(MSG_ERROR + "PROVIENE DE:    Codigo del proveedor\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            FALSE: No puede ser menor que 0.");
            }
            
            try {
                ret = excecuteSQLSpecific1(codProve);
            } catch (SQLException ex) {
                request.setAttribute("error", "EXCEPCIÓN CONTROLADA #04: "+ex);
            }
            
            if (!ret.equals("true")) {
                throw new Exception(MSG_ERROR + "PROVIENE DE:    Codigo del Proveedor\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            NO existe este codigo del proveedor.");
            }
        }catch(Exception e) {
            request.setAttribute("consolaProveedor", e.getMessage());
            return false;
        }
        return true;
    }
    
    private boolean action(HttpServletRequest request, HttpServletResponse response) {
        String btnINSERTAR = request.getParameter("INSERTAR");
        String btnELIMINAR = request.getParameter("ELIMINAR");
        String btnACTUALIZAR = request.getParameter("ACTUALIZAR");
        String btnGETDATOS = request.getParameter("GET_DATOS");
        String btnTabla = request.getParameter("getTableProovedor");
        
        String codigoProveedor = request.getParameter("Cod_Proveedor");
        String nombreProveedor = request.getParameter("Nombre_Proveedor");
        String paisProveedor = request.getParameter("Pais_Proveedor");
        String telefono = request.getParameter("Telefono");
        
        List lista = null;
        
        if (btnGETDATOS != null) {
            String codigoProv = "";
            String nombreProv = "";
            String paisProv = "";
            String telefProv = "";
            
            try {
                codigoProv = excecuteSQLSpecific3(codigoProveedor);
                nombreProv = excecuteSQLSpecific4(codigoProveedor);
                paisProv = excecuteSQLSpecific5(codigoProveedor);
                telefProv = excecuteSQLSpecific6(codigoProveedor);
                
                lista = excecuteSQLSpecific2();
            } catch(SQLException ex) {
                request.setAttribute("error", "EXCEPCIÓN CONTROLADA - GETDATOS: "+ex);
                return false;
            
            } finally {
                request.setAttribute("Cod_Proveedor_VER", codigoProv);
                request.setAttribute("Nombre_Proveedor_VER", nombreProv);
                request.setAttribute("Pais_Proveedor_VER", paisProv);
                request.setAttribute("Telefono_VER", telefProv);
            }
        }
        
        if (btnINSERTAR != null) {
            ejecutaInsert(request, codigoProveedor, nombreProveedor, paisProveedor, telefono);
            try {
                lista = excecuteSQLSpecific2();
            } catch(SQLException ex) {
                request.setAttribute("error", "EXCEPCIÓN CONTROLADA: "+ex);
                return false;
            }
        }
        
        if (btnELIMINAR != null) {
            ejecutaDelete(request, codigoProveedor);
            try {
                lista = excecuteSQLSpecific2();
            } catch(SQLException ex) {
                request.setAttribute("error", "EXCEPCIÓN CONTROLADA: "+ex);
                return false;
            }
        }

        if (btnACTUALIZAR != null) {
            ejecutaUpdate(request, codigoProveedor, nombreProveedor, paisProveedor, telefono);
            try {
                lista = excecuteSQLSpecific2();
            } catch(SQLException ex) {
                request.setAttribute("error", "EXCEPCIÓN CONTROLADA: "+ex);
                return false;
            }
        }
        
        if (btnTabla != null) {
            try {
                lista = excecuteSQLSpecific2();
            } catch(SQLException ex) {
                request.setAttribute("error", "EXCEPCIÓN CONTROLADA: "+ex);
                return false;
            }
        }
        
        
        HttpSession session = request.getSession(false);
        session.setAttribute("providers", lista);

        return true;
    }

//STATEMENT
    private boolean ejecutaInsert(HttpServletRequest request, String codProv, String nomProv, String paisProv, String telefono) {
        String sql = "INSERT INTO PROOVEDOR VALUES ("+ codProv +",'"+ nomProv +"','"+ paisProv +"','"+ telefono +"')";
        try {
            microModelGUI.execute(statement, sql);
        } catch(SQLException ex) {
            request.setAttribute("error", "EXCEPCIÓN CONTROLADA #09 "+ex);
            return false;
        }
        return true;
    }
    private boolean ejecutaDelete(HttpServletRequest request, String codProv) {
        String sql = "DELETE FROM PROOVEDOR "
                   + "WHERE CODIGO_PROOVEDOR = "+ codProv +" ";
        try {
            microModelGUI.execute(statement, sql);
        } catch(SQLException ex) {
            request.setAttribute("error", "EXCEPCIÓN CONTROLADA #10 "+ex);
            return false;
        }
        return true;
    }
    private boolean ejecutaUpdate(HttpServletRequest request, String codProv, String nomProv, String paisProv, String telefono) {
        String sql = "UPDATE PROOVEDOR SET NOMBRE_PROOVEDOR = '"+ nomProv +"', PAIS_PROOVEDOR = '"+ paisProv +"', TELEFONO = '"+ telefono +"' "
                   + "WHERE CODIGO_PROOVEDOR = "+ codProv +"";
        try {
            microModelGUI.execute(statement, sql);
        } catch(SQLException ex) {
            request.setAttribute("error", "EXCEPCIÓN CONTROLADA #11 "+ex);
            return false;
        }
        return true;
    }
    

    private void view(HttpServletRequest request, HttpServletResponse response) {
        ServletContext context = this.getServletContext();
        RequestDispatcher view = context.getRequestDispatcher("/v_S3.jsp");
        
        try {
            view.forward(request, response);
        } catch (ServletException | IOException ex) {
            request.setAttribute("error", "EXCEPCION CONTROLADA #01: "+ex);
        }
    }

    private void error(HttpServletRequest request, HttpServletResponse response) {
        ServletContext context = this.getServletContext();
        RequestDispatcher view = context.getRequestDispatcher("/views/error.jsp");
        try {
            view.forward(request, response);
        } catch (ServletException | IOException ex) {
            System.out.println("EXCEPCION CONTROLADA COD/Error: "+ex);
        }
    }

//QUERY
    public String excecuteSQL(String sql) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String excecuteSQLSpecific1(String s) throws SQLException {
        String sql = "SELECT COUNT(*) FROM PROOVEDOR WHERE CODIGO_PROOVEDOR = '" + s + "'";
        ResultSet resultSet = MicroModelGUI.executeQuery(statement, sql);
        resultSet.next();
        int cont = Integer.parseInt(resultSet.getString(1));
        return cont == 0 ? "false" : "true";
    }
    
    public List excecuteSQLSpecific2() throws SQLException {
        String sql = "SELECT * FROM PROOVEDOR";
        
        ResultSet resultSet = MicroModelGUI.executeQuery(statement, sql);
        List lista = new ArrayList();
        
        try {
            while (resultSet.next()) {
                String codigoProv = resultSet.getString(1);
                String nombreProv = resultSet.getString(2);
                String paisProv = resultSet.getString(3);
                String telefono = resultSet.getString(4);
                
                String[] proovedor = {codigoProv,nombreProv,paisProv,telefono};

                lista.add(proovedor);
            }
        } catch(SQLException e) {
            throw new SQLException(MicroModelGUI.resolveException(e));
        }
        return lista;
    }
    
    public String excecuteSQLSpecific3(String s) throws SQLException {
        String sql = "SELECT CODIGO_PROOVEDOR "
                   + "FROM   PROOVEDOR "
                   + "WHERE  CODIGO_PROOVEDOR = '"+ s +"' ";
        ResultSet resultSet = MicroModelGUI.executeQuery(statement, sql);
        resultSet.next();
        int codProv = Integer.parseInt(resultSet.getString(1));
        return "" + codProv;
    }
    
    public String excecuteSQLSpecific4(String s) throws SQLException {
        String sql = "SELECT NOMBRE_PROOVEDOR "
                   + "FROM   PROOVEDOR "
                   + "WHERE  CODIGO_PROOVEDOR = '"+ s +"' ";
        ResultSet resultSet = MicroModelGUI.executeQuery(statement, sql);
        resultSet.next();
        String nombre = resultSet.getString(1);
        nombre = resultSet.wasNull() ? "" : (nombre + "");
        return nombre;
    }
    
    public String excecuteSQLSpecific5(String s) throws SQLException {
        String sql = "SELECT PAIS_PROOVEDOR "
                   + "FROM   PROOVEDOR "
                   + "WHERE  CODIGO_PROOVEDOR = '"+ s +"' ";
        ResultSet resultSet = MicroModelGUI.executeQuery(statement, sql);
        resultSet.next();
        String pais = resultSet.getString(1);
        pais = resultSet.wasNull() ? "" : (pais + "");
        return pais;
    }

    public String excecuteSQLSpecific6(String s) throws SQLException {
        String sql = "SELECT TELEFONO "
                   + "FROM   PROOVEDOR "
                   + "WHERE  CODIGO_PROOVEDOR = '"+ s +"' ";
        ResultSet resultSet = MicroModelGUI.executeQuery(statement, sql);
        resultSet.next();
        int telefono = Integer.parseInt(resultSet.getString(1));
        return "" + telefono;
    }
    
}