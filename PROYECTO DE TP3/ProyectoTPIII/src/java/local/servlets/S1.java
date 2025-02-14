package local.servlets;

import java.io.IOException;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import local.utils.MicroModelGUI;
import local.utils.Utilities;

public class S1 extends HttpServlet {

    //Se crea los objetos en vez de micromodel, pones pull.
    private static MicroModelGUI microModelGUI = new MicroModelGUI();
    private static Statement statement;
    
    //Lo comprobe testeando, lo que no usa es el statement.
    //tendras que inicializar el objeto dentro del constructor.
    static {
        statement = microModelGUI.createStatement();
    }
    
    //esto de aca es irrelevante.
    private final String MSG_ERROR = " \n"
                                   + "                                               ERROR ENCONTRADO / INGRESO NO VALIDO\n"
                                   + "\n";
    
    //En el processRequest es la tradicional form, action y el view donde redirigiras del servlet al jsp. Esto ya lo sabes.
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

    //Aqui no agarras nada.
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
    
    //Aqui yace tus validaciones o ciertas operaciones al calcular para luego validarlas.
    private boolean form(HttpServletRequest request, HttpServletResponse response) {
        //Desde la vista v_S1.jsp
        String btnAgregar = request.getParameter("AGREGAR");
        String buscaNombre = request.getParameter("browser");
        String cantidad = request.getParameter("cantidad");
        
        //Desde la vista v_S1_Update.jsp
        String btnCambiarEmp = request.getParameter("CAMBIAR_CodProEmp");
        String btncambiarFab = request.getParameter("CAMBIAR_CodProFab");
        String btnActualiza = request.getParameter("ACTUALIZAR");
        String codProEmpAct = request.getParameter("codProEmpActual");
        String codProEmpNue = request.getParameter("codProEmpNueva");
        String cantidadA = request.getParameter("cantidadA");
        String codProFabAct = request.getParameter("codProFabActual");
        String codProFabNue = request.getParameter("codProFabNueva");
        String cantidadB = request.getParameter("cantidadB");
        String codProEmp = request.getParameter("COD_PRO_EMP");
        String cantidadC = request.getParameter("cantidadC");
        
        //Desde la vista v_S1_Delete.jsp
        String btnEliminar = request.getParameter("ELIMINAR");
        String browserEliminar = request.getParameter("browserEliminar");
        
        String evento;
        
        if(btnAgregar != null){
            evento = "Agregar";
            if(NombreDelProducto(request, buscaNombre, evento)==false) {
                return false;
            }
            if(Cantidad(request, cantidad, evento)==false){
                return false;
            }
        }
        
        if(btnCambiarEmp != null){
            evento = "Cambiar otro articulo por CodProdEMP";
            if(CodProEmpresaActual(request, codProEmpAct, evento)==false){
                return false;
            }
            if(CodProEmpresaNueva(request, codProEmpNue, evento)==false){
                return false;
            }
            if(Cantidad(request, cantidadA, evento)==false){
                return false;
            }
        }
        
        if(btncambiarFab != null){
            evento = "Cambiar otro articulo por CodProdFAB";
            if(CodProFabricanteActual(request, codProFabAct,evento)==false){
                return false;
            }
            if(CodProFabricanteNueva(request, codProFabNue,evento)==false){
                return false;
            }
            if(Cantidad(request, cantidadB,evento)==false){
                return false;
            }
        }
        
        if(btnActualiza != null){
            evento = "Actualizar";
            if(CodProEmpresaActual(request, codProEmp,evento)==false){
                return false;
            }
            if(Cantidad(request, cantidadC,evento)==false){
                return false;
            }
        }
        
        if(btnEliminar != null){
            evento = "Eliminar/Quitar";
            if(NombreDelProducto(request, browserEliminar, evento)==false){
                return false;
            }
        }
        return true;
    }

//Aqui tienes un gran pack de validaciones recien horneadas, chequealo bien si te alcanza tiempo ;v
//te recomiendo que minimices los metodos reutilizables como estas validaciones..
// VALIDACION DE LA VISTA V_S1.JSP   
    private boolean NombreDelProducto(HttpServletRequest request, String nombre, String evento) {
        try {
            int cont = nombre.length();
            String ret = null;
            
            if (nombre.isEmpty()) {
                throw new Exception(MSG_ERROR + "PROVIENE DE:    Nombre del Producto\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            No deje en blanco este casillero.");
            }
            if (nombre.startsWith(" ")) {
                throw new Exception(MSG_ERROR + "PROVIENE DE:    Nombre del Producto\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            No deje espacios en blanco.");
            }
            if (cont > 40) {
                throw new Exception(MSG_ERROR + "PROVIENE DE:    Nombre del Producto\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            No debe tener mas de 40 caracteres.");
            }

            if (!Utilities.esLetraOConEspacio(nombre)){
                throw new Exception(MSG_ERROR + "PROVIENE DE:    Nombre del Producto\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            No debe contener ningun digito o simbolo,\n"
                                              + "                             solo caracter alfabetico.");
            }
            
            try {
                ret = excecuteSQLSpecific4(nombre);
            } catch (SQLException ex) {
                request.setAttribute("error", "EXCEPCIÓN CONTROLADA #03: : "+ex);
            }
            
            if (!ret.equals("true")) {
                throw new Exception(MSG_ERROR + "PROVIENE DE:    Nombre del Producto\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            NO existe este articulo en el inventario.");
            }
            
        } catch (Exception e) {
            request.setAttribute("consolaCarrito", e.getMessage());
            return false;
        }
        return true;
    }
    private boolean Cantidad(HttpServletRequest request, String cantidad, String evento) {
        try {
            int cont = cantidad.length();

            if (cantidad.isEmpty()) {
                throw new Exception(MSG_ERROR + "PROVIENE DE:    Cantidad\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            No deje en blanco este casillero.");
            }
            if (cantidad.startsWith(" ")) {
                throw new Exception(MSG_ERROR + "PROVIENE DE:    Cantidad\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            No deje espacios en blanco.");
            }
            if (cantidad.startsWith("-")) {
                throw new Exception(MSG_ERROR + "PROVIENE DE:    Cantidad\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            No puede ser un numero negativo.");
            }
            if (cont < 0) {
                throw new Exception(MSG_ERROR + "PROVIENE DE:    Cantidad\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            FALSE: No puede ser menor que 0.");
            }
            if (!Utilities.esDigito(cantidad)) {
                throw new Exception(MSG_ERROR + "PROVIENE DE:    Cantidad\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            No debe contener ningun otro caracter o simbolo\n"
                                              + "                             a excepcion de cualquier digito.");
            }
            
        } catch (Exception e) {
            request.setAttribute("consolaCarrito", e.getMessage());
            return false;
        }
        return true;
    }
    
// VALIDACION DE LA VISTA V_S1_UPDATE.JSP y V_S1_DELETE.JSP
    private boolean CodProEmpresaActual(HttpServletRequest request, String codProEmpAct, String evento) {
        try {
            int cont = codProEmpAct.length();
            String ret = null;

            if (codProEmpAct.isEmpty()) {
                throw new Exception(MSG_ERROR + "PROVIENE DE:    Codigo del Producto en la Empresa ACTUAL\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            No deje en blanco este casillero.");
            }
            if (codProEmpAct.startsWith(" ")) {
                throw new Exception(MSG_ERROR + "PROVIENE DE:    Codigo del Producto en la Empresa ACTUAL\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            No deje espacios en blanco.");
            }
            if (codProEmpAct.startsWith("-")) {
                throw new Exception(MSG_ERROR + "PROVIENE DE:    Codigo del Producto en la Empresa ACTUAL\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            No puede ser un numero negativo.");
            }
            if (!Utilities.esDigito(codProEmpAct)) {
                throw new Exception(MSG_ERROR + "PROVIENE DE:    Codigo del Producto en la Empresa ACTUAL\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            No debe contener ningun otro caracter o simbolo\n"
                                              + "                             a excepcion de cualquier digito.");
            }
            if (cont < 0) {
                throw new Exception(MSG_ERROR + "PROVIENE DE:    Codigo del Producto en la Empresa ACTUAL\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            FALSE: No puede ser menor que 0.");
            }
            
            try {
                ret = excecuteSQLSpecific2(codProEmpAct);
            } catch (SQLException ex) {
                request.setAttribute("error", "EXCEPCIÓN CONTROLADA #04: "+ex);
            }
            
            if (!ret.equals("true")) {
                throw new Exception(MSG_ERROR + "PROVIENE DE:    Codigo del Producto en la Empresa ACTUAL\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            NO existe este codigo del producto.");
            }
        }catch(Exception e){
            request.setAttribute("consolaCarrito", e.getMessage());
            return false;
        }
        return true;
    }
    private boolean CodProEmpresaNueva(HttpServletRequest request, String codProEmpNue, String evento) {
        try {
            int cont = codProEmpNue.length();
            String ret = null;

            if (codProEmpNue.isEmpty()) {
                throw new Exception(MSG_ERROR + "PROVIENE DE:    Codigo del Producto en la Empresa NUEVA\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            No deje en blanco este casillero.");
            }
            if (codProEmpNue.startsWith(" ")) {
                throw new Exception(MSG_ERROR + "PROVIENE DE:    Codigo del Producto en la Empresa NUEVA\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            No deje espacios en blanco.");
            }
            if (codProEmpNue.startsWith("-")) {
                throw new Exception(MSG_ERROR + "PROVIENE DE:    Codigo del Producto en la Empresa NUEVA\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            No puede ser un numero negativo.");
            }
            if (!Utilities.esDigito(codProEmpNue)) {
                throw new Exception(MSG_ERROR + "PROVIENE DE:    Codigo del Producto en la Empresa NUEVA\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            No debe contener ningun otro caracter o simbolo\n"
                                              + "                             a excepcion de cualquier digito.");
            }
            if (cont < 0) {
                throw new Exception(MSG_ERROR + "PROVIENE DE:    Codigo del Producto en la Empresa NUEVA\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            FALSE: No puede ser menor que 0.");
            }
            
            try {
                ret = excecuteSQLSpecific2(codProEmpNue);
            } catch (SQLException ex) {
                request.setAttribute("error", "EXCEPCIÓN CONTROLADA #05: "+ex);
            }
            
            if (!ret.equals("true")) {
                throw new Exception(MSG_ERROR + "PROVIENE DE:    Codigo del Producto en la Empresa NUEVA\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            NO existe este codigo del producto.");
            }
        }catch(Exception e){
            request.setAttribute("consolaCarrito", e.getMessage());
            return false;
        }
        return true;
    }
    private boolean CodProFabricanteActual(HttpServletRequest request, String codProFabAct, String evento) {
        try {
            int cont = codProFabAct.length();
            String ret = null;

            if (codProFabAct.isEmpty()) {
                throw new Exception(MSG_ERROR + "PROVIENE DE:    Codigo del Producto segun Fabricante ACTUAL\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            No deje en blanco este casillero.");
            }
            if (codProFabAct.startsWith(" ")) {
                throw new Exception(MSG_ERROR + "PROVIENE DE:    Codigo del Producto segun Fabricante ACTUAL\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            No deje espacios en blanco.");
            }
            if (codProFabAct.startsWith("-")) {
                throw new Exception(MSG_ERROR + "PROVIENE DE:    Codigo del Producto segun Fabricante ACTUAL\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            No puede ser un numero negativo.");
            }
            if (!Utilities.esLetraDigito(codProFabAct)) {
                throw new Exception(MSG_ERROR + "PROVIENE DE:    Codigo del Producto segun Fabricante ACTUAL\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            No debe contener ningun otro simbolo o espacio\n"
                                              + "                             a excepcion de cualquier digito o letra.");
            }
            if (cont < 0) {
                throw new Exception(MSG_ERROR + "PROVIENE DE:    Codigo del Producto segun Fabricante ACTUAL\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            FALSE: No puede ser menor que 0.");
            }
            
            try {
                ret = excecuteSQLSpecific3(codProFabAct);
            } catch (SQLException ex) {
                request.setAttribute("error", "EXCEPCIÓN CONTROLADA #06: "+ex);
            }
            
            if (!ret.equals("true")) {
                throw new Exception(MSG_ERROR + "PROVIENE DE:    Codigo del Producto segun Fabricante ACTUAL\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            NO existe este codigo del producto.");
            }
        }catch(Exception e){
            request.setAttribute("consolaCarrito", e.getMessage());
            return false;
        }
        return true;
    }
    private boolean CodProFabricanteNueva(HttpServletRequest request, String codProFabNue, String evento) {
        try {
            int cont = codProFabNue.length();
            String ret = null;

            if (codProFabNue.isEmpty()) {
                throw new Exception(MSG_ERROR + "PROVIENE DE:    Codigo del Producto segun Fabricante NUEVA\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            No deje en blanco este casillero.");
            }
            if (codProFabNue.startsWith(" ")) {
                throw new Exception(MSG_ERROR + "PROVIENE DE:    Codigo del Producto segun Fabricante NUEVA\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            No deje espacios en blanco.");
            }
            if (codProFabNue.startsWith("-")) {
                throw new Exception(MSG_ERROR + "PROVIENE DE:    Codigo del Producto segun Fabricante NUEVA\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            No puede ser un numero negativo.");
            }
            if (!Utilities.esLetraDigito(codProFabNue)) {
                throw new Exception(MSG_ERROR + "PROVIENE DE:    Codigo del Producto segun Fabricante NUEVA\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            No debe contener ningun otro simbolo o espacio\n"
                                              + "                             a excepcion de cualquier digito o letra.");
            }
            if (cont < 0) {
                throw new Exception(MSG_ERROR + "PROVIENE DE:    Codigo del Producto segun Fabricante NUEVA\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            FALSE: No puede ser menor que 0.");
            }
            
            try {
                ret = excecuteSQLSpecific3(codProFabNue);
            } catch (SQLException ex) {
                request.setAttribute("error", "EXCEPCIÓN CONTROLADA #07: "+ex);
            }
            
            if (!ret.equals("true")) {
                throw new Exception(MSG_ERROR + "PROVIENE DE:    Codigo del Producto segun Fabricante NUEVA\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            NO existe este codigo del producto.");
            }
        }catch(Exception e){
            request.setAttribute("consolaCarrito", e.getMessage());
            return false;
        }
        return true;
    }
    
//Aqui ejecutas tus operaciones SQL directamente o por metodos reutilizables. Bien servido.    
    private boolean action(HttpServletRequest request, HttpServletResponse response) {
        //Desde la vista v_S1.jsp
        String btnAgregar = request.getParameter("AGREGAR");
        String nroCarrito = request.getParameter("nroCarrito");
        String buscaNombre = request.getParameter("browser");
        String cantidad = request.getParameter("cantidad");
        
        //Desde la vista v_S1_Update.jsp
        String btnCambiarEmp = request.getParameter("CAMBIAR_CodProEmp");
        String btncambiarFab = request.getParameter("CAMBIAR_CodProFab");
        String btnActualiza = request.getParameter("ACTUALIZAR");
        String codProEmpAct = request.getParameter("codProEmpActual");
        String codProEmpNue = request.getParameter("codProEmpNueva");
        String cantidadA = request.getParameter("cantidadA");
        String codProFabAct = request.getParameter("codProFabActual");
        String codProFabNue = request.getParameter("codProFabNueva");
        String cantidadB = request.getParameter("cantidadB");
        String codProEmp = request.getParameter("COD_PRO_EMP");
        String cantidadC = request.getParameter("cantidadC");
        
        //Desde la vista v_S1_Delete.jsp
        String btnEliminar = request.getParameter("ELIMINAR");
        String browserEliminar = request.getParameter("browserEliminar");

        List carrito = null;

        if (btnAgregar != null) {
            System.out.println("HOLAAAA : "+cantidad);
            try {
                String []articulo = excecuteSQLSpecific1(buscaNombre);
                ejecutaInsert(request, nroCarrito, articulo[0], articulo[1], cantidad);
                carrito = excecuteSQLSpecific5();
            } catch(SQLException e) {
                request.setAttribute("error", "EXCEPCIÓN CONTROLADA #08bbbbb: "+e);
                return false;
            }
        }
        if (btnCambiarEmp != null) {
            try {
                String []articulo = excecuteSQLSpecific6(codProEmpNue);
                ejecutaCambiaXCPEmpresa(request, codProEmpAct, nroCarrito, articulo[0], articulo[1], cantidadA);
                carrito = excecuteSQLSpecific5();
            } catch(SQLException e) {
                request.setAttribute("error", "EXCEPCIÓN CONTROLADA #08: "+e);
            }
        }
        
        if (btncambiarFab != null) {
            try {
                String []articulo = excecuteSQLSpecific7(codProFabNue);
                ejecutaCambiaXCPFabricante(request, codProFabAct, nroCarrito, articulo[0], articulo[1], cantidadB);
                carrito = excecuteSQLSpecific5();
            } catch(SQLException e) {
                request.setAttribute("error", "EXCEPCIÓN CONTROLADA #08: "+e);
            }
        }
        
        if (btnActualiza != null) {
            try {
                ejecutaCambiaCantidad(request, codProEmp, cantidadC);
                carrito = excecuteSQLSpecific5();
            } catch(SQLException e) {
                request.setAttribute("error", "EXCEPCIÓN CONTROLADA #08: "+e);
            }
        }
        
        if (btnEliminar != null) {
            try {
                String []articulo = excecuteSQLSpecific8(browserEliminar);
                ejecutaEliminar(request, articulo[0]);
                carrito = excecuteSQLSpecific5();
            } catch(SQLException e) {
                request.setAttribute("error", "EXCEPCIÓN CONTROLADA #08: "+e);
            }
        }
        
        HttpSession session = request.getSession(false);
        session.setAttribute("datos",carrito);
        
        return true;
    }

    
// STATEMENTS    
    private boolean ejecutaInsert(HttpServletRequest request, String idCarrito, String idCodProEmp, String idCodProFab, String Cantidad) {
        
        String sql = "INSERT INTO CARRITO VALUES ('"+ idCarrito +"','"+ idCodProEmp +"','"+ idCodProFab + "','"+ Cantidad +"') ";
        
        try {
            microModelGUI.execute(statement, sql);
        } catch(SQLException ex) {
            return false;
        }
        return true;
    }
    
    private boolean ejecutaCambiaXCPEmpresa(HttpServletRequest request, String idCodProEmpActual, String idCarrito, String idCodProEmpNueva, String idCodProFab, String Cantidad) {
        String sqlA = "DELETE FROM CARRITO "
                    + "WHERE ID_COD_PRO_EMP = '"+ idCodProEmpActual +"' ";
        
        try {
            ejecutaInsert(request, idCarrito, idCodProEmpNueva, idCodProFab, Cantidad);
            microModelGUI.execute(statement, sqlA);
        } catch(SQLException ex) {
            request.setAttribute("error", "EXCEPCIÓN CONTROLADA #09aaaa "+ex);
            return false;
        }
        return true;
    }
    
    private boolean ejecutaCambiaXCPFabricante(HttpServletRequest request, String idCodProFabActual, String idCarrito, String idCodProFabNueva, String idCodProFab, String Cantidad) {
        String sqlA = "DELETE FROM CARRITO "
                    + "WHERE ID_COD_PRO_FAB = '"+ idCodProFabActual +"' ";
        
        try {
            ejecutaInsert(request, idCarrito, idCodProFabNueva, idCodProFab, Cantidad);
            microModelGUI.execute(statement, sqlA);
        } catch(SQLException ex) {
            request.setAttribute("error", "EXCEPCIÓN CONTROLADA #09aaaa "+ex);
            return false;
        }
        return true;
    }
    
    private boolean ejecutaCambiaCantidad(HttpServletRequest request, String idCodProEmp, String Cantidad) {
        String sql = "UPDATE CARRITO SET CANTIDAD = '"+ Cantidad +"' "
                   + "WHERE ID_COD_PRO_EMP = '"+ idCodProEmp +"' ";
        
        try {
            microModelGUI.execute(statement, sql);
        } catch(SQLException ex) {
            request.setAttribute("error", "EXCEPCIÓN CONTROLADA #09aaaa "+ex);
            return false;
        }
        return true;
    }
    
    private boolean ejecutaEliminar(HttpServletRequest request, String idCodProEmp) {
        String sql = "DELETE FROM CARRITO "
                   + "WHERE ID_COD_PRO_EMP = '"+ idCodProEmp +"' ";
        
        try {
            microModelGUI.execute(statement, sql);
        } catch(SQLException ex) {
            request.setAttribute("error", "EXCEPCIÓN CONTROLADA #09aaaa "+ex);
            return false;
        }
        return true;
    }
//FIN DE LAS OPERACIONES SQL    
    
    /*
// PARA HALLAR CANT TOTAL Y PRECIO TOTAL    
    private String hallaCantidadTotal(HttpServletRequest request) throws SQLException{
        List cantidad = excecuteSQLSpecific5();
        int cont;
        
        while(cantidad.get(4)){
            
        }
        
        return "";
    }*/
    
//Ya sabes lo que es esto.
    private void view(HttpServletRequest request, HttpServletResponse response) {
        ServletContext context = this.getServletContext();
        RequestDispatcher view = context.getRequestDispatcher("/v_S1.jsp");
        
        try {
            view.forward(request, response);
        } catch (ServletException | IOException ex) {
            request.setAttribute("error", "EXCEPCION CONTROLADA #01: "+ex);
        }
    }

//Esto ni lo uses si aun tienes orgullo xd
    private void error(HttpServletRequest request, HttpServletResponse response) {
        ServletContext context = this.getServletContext();
        RequestDispatcher view = context.getRequestDispatcher("/views/error.jsp");
        try {
            view.forward(request, response);
        } catch (ServletException | IOException ex) {
            System.out.println("EXCEPCION CONTROLADA COD/Error: "+ex);
        }
    }

// Estos son los querys que reutilizo despues dentro del metodo ACTION. El flujo es bastante simple de entender, ordenado y practico.
// QUERYS
    public String excecuteSQL(String sql) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String[] excecuteSQLSpecific1(String nombre) throws SQLException {
        String sql = "SELECT    COD_PRO_EMP, "
                   + "          COD_PRO_FAB "
                   + "FROM      ARTICULOS "
                   + "WHERE     NOMBRE_PROD = '"+ nombre +"' ";

        ResultSet resultSet = MicroModelGUI.executeQuery(statement, sql);

        String codProEmp = null;
        String codProFab = null;
        try {
            while (resultSet.next()) {
                codProEmp = resultSet.getString(1);
                codProFab = resultSet.getString(2);
            }
        } catch(SQLException e) {
            throw new SQLException(MicroModelGUI.resolveException(e));
        }

        String[] inventario = {codProEmp,codProFab};

        return inventario;
    }
    
    public String excecuteSQLSpecific2(String s) throws SQLException {
        String sql = "SELECT COUNT(*) FROM ARTICULOS WHERE COD_PRO_EMP = '" + s + "'";
        ResultSet resultSet = MicroModelGUI.executeQuery(statement, sql);
        resultSet.next();
        int cont = Integer.parseInt(resultSet.getString(1));
        return cont == 0 ? "false" : "true";
    }
    
    public String excecuteSQLSpecific3(String s) throws SQLException {
        String sql = "SELECT COUNT(*) FROM ARTICULOS WHERE COD_PRO_FAB = '" + s + "'";
        ResultSet resultSet = MicroModelGUI.executeQuery(statement, sql);
        resultSet.next();
        int cont = Integer.parseInt(resultSet.getString(1));
        return cont == 0 ? "false" : "true";
    }
    
    public String excecuteSQLSpecific4(String s) throws SQLException {
        String sql = "SELECT COUNT(*) FROM ARTICULOS WHERE NOMBRE_PROD = '" + s + "'";
        ResultSet resultSet = MicroModelGUI.executeQuery(statement, sql);
        resultSet.next();
        int cont = Integer.parseInt(resultSet.getString(1));
        return cont == 0 ? "false" : "true";
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
    
    public String[] excecuteSQLSpecific6(String codProEmpNueva) throws SQLException {
        String sql = "SELECT    COD_PRO_EMP, "
                   + "          COD_PRO_FAB "
                   + "FROM      ARTICULOS "
                   + "WHERE     COD_PRO_EMP = '"+ codProEmpNueva +"' ";

        ResultSet resultSet = MicroModelGUI.executeQuery(statement, sql);

        String codProEmp = null;
        String codProFab = null;
        try {
            while (resultSet.next()) {
                codProEmp = resultSet.getString(1);
                codProFab = resultSet.getString(2);
            }
        } catch(SQLException e) {
            throw new SQLException(MicroModelGUI.resolveException(e));
        }

        String[] inventario = {codProEmp,codProFab};

        return inventario;
    }
    
    public String[] excecuteSQLSpecific7(String codProFabNueva) throws SQLException {
        String sql = "SELECT    COD_PRO_EMP, "
                   + "          COD_PRO_FAB "
                   + "FROM      ARTICULOS "
                   + "WHERE     COD_PRO_FAB = '"+ codProFabNueva +"' ";

        ResultSet resultSet = MicroModelGUI.executeQuery(statement, sql);

        String codProEmp = null;
        String codProFab = null;
        try {
            while (resultSet.next()) {
                codProEmp = resultSet.getString(1);
                codProFab = resultSet.getString(2);
            }
        } catch(SQLException e) {
            throw new SQLException(MicroModelGUI.resolveException(e));
        }

        String[] inventario = {codProEmp,codProFab};

        return inventario;
    }
    
    public String[] excecuteSQLSpecific8(String nombre) throws SQLException {
        String sql = "SELECT    COD_PRO_EMP "
                   + "FROM      ARTICULOS "
                   + "WHERE     NOMBRE_PROD = '"+ nombre +"' ";

        ResultSet resultSet = MicroModelGUI.executeQuery(statement, sql);

        String codProEmp = null;
        try {
            while (resultSet.next()) {
                codProEmp = resultSet.getString(1);
            }
        } catch(SQLException e) {
            throw new SQLException(MicroModelGUI.resolveException(e));
        }

        String[] inventario = {codProEmp};

        return inventario;
    }
    
    
}