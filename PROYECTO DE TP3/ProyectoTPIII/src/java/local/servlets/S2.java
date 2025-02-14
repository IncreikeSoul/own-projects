package local.servlets;

import java.io.IOException;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import local.utils.MicroModelGUI;
import local.utils.Utilities;

public class S2 extends HttpServlet {

    private static MicroModelGUI microModelGUI = new MicroModelGUI();
    private static Statement statement;
    
    static {
        statement = microModelGUI.createStatement();
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

    
    private boolean form(HttpServletRequest request, HttpServletResponse response)  {
        String btnINSERTAR = request.getParameter("INSERTAR");
        String btnELIMINAR = request.getParameter("ELIMINAR");
        String btnACTUALIZAR = request.getParameter("ACTUALIZAR");
        String btnGETDATOS = request.getParameter("GET_DATOS");
        
        String codProEmp = request.getParameter("Cod_Pro_Emp");
        String codProFab = request.getParameter("Cod_Pro_Fab");
        String nombreProducto = request.getParameter("Nombre_Producto");
        String precioUnitario = request.getParameter("Precio_Unitario");
        String stock = request.getParameter("STOCK");
        String fecha = request.getParameter("Fecha_Ingreso");
        String fkProveedor = request.getParameter("fk_proveedor");
        
        String evento;
        
        if(btnGETDATOS != null) {
            evento = "Get Datos";
            if (codProEmpresaVer_Edit_Delete(request, codProEmp, evento)==false){
                return false;
            }
        }
        
        if(btnINSERTAR != null) {
            evento = "Insertar";
            if(codProEmpresaInsertar(request, codProEmp, evento)==false){
                return false;
            }
            if(codProFabricante(request, codProFab, evento)==false){
                return false;
            }
            if(nombreProducto(request, nombreProducto, evento)==false){
                return false;
            }
            if(precioUnitario(request, precioUnitario, evento)==false){
                return false;
            }
            if(stock(request, stock, evento)==false){
                return false;
            }
            if(fecha(request, fecha, evento)==false){
                return false;
            }
            if(codigoProveedor(request, fkProveedor, evento)==false){
                return false;
            }
        }    
            
        if(btnELIMINAR != null) {
            evento = "Eliminar";
            if(codProEmpresaVer_Edit_Delete(request, codProEmp, evento)==false){
                return false;
            }
        }
        
        if(btnACTUALIZAR != null) {
            evento = "Actualizar";
            if(codProEmpresaVer_Edit_Delete(request, codProEmp, evento)==false){
                return false;
            }
            if(nombreProducto(request, nombreProducto, evento)==false){
                return false;
            }
            if(precioUnitario(request, precioUnitario, evento)==false){
                return false;
            }
            if(stock(request, stock, evento)==false){
                return false;
            }
            if(fecha(request, fecha, evento)==false){
                return false;
            }
            if(codigoProveedor(request, fkProveedor, evento)==false){
                return false;
            }
        }
        return true;
    }

//VALIDACION PARA INSERTAR
    private boolean codProEmpresaInsertar(HttpServletRequest request, String codProEmp, String evento) {
        try {
            int cont = codProEmp.length();
            String ret = null;

            if (codProEmp.isEmpty()) {
                throw new Exception(MSG_ERROR + "PROVIENE DE:    Codigo del Producto en la Empresa\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            No deje en blanco este casillero.");
            }
            if (codProEmp.startsWith(" ")) {
                throw new Exception(MSG_ERROR + "PROVIENE DE:    Codigo del Producto en la Empresa\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            No deje espacios en blanco.");
            }
            if (codProEmp.startsWith("-")) {
                throw new Exception(MSG_ERROR + "PROVIENE DE:    Codigo del Producto en la Empresa\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            No puede ser un numero negativo.");
            }
            if (!Utilities.esDigito(codProEmp)) {
                throw new Exception(MSG_ERROR + "PROVIENE DE:    Codigo del Producto en la Empresa\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            No debe contener ningun otro caracter o simbolo\n"
                                              + "                               a excepcion de cualquier digito.");                
            }
            if (cont < 0) {
                throw new Exception(MSG_ERROR + "PROVIENE DE:    Codigo del Producto en la Empresa\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            FALSE: No puede ser menor que 0.");
            }
            
            try {
                ret = excecuteSQLSpecific2(codProEmp);
            } catch (SQLException ex) {
                request.setAttribute("error", "EXCEPCIÓN CONTROLADA #04: "+ex);
                return false;
            }
            
            if (ret.equals("true")) {
                throw new Exception(MSG_ERROR + "PROVIENE DE:    Codigo del Producto en la Empresa\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            YA existe este codigo del producto.");
            }
        }catch(Exception e) {
            request.setAttribute("consolaInventario", e.getMessage());
            return false;
        }
        return true;
    }
    private boolean codProFabricante(HttpServletRequest request, String codProFab, String evento) {
        try {
            int cont = codProFab.length();
            String ret = null;

            if (codProFab.isEmpty()) {
                throw new Exception(MSG_ERROR + "PROVIENE DE:    Codigo del Producto segun el Fabricante\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            No deje en blanco este casillero.");
            }
            if (codProFab.startsWith(" ")) {
                throw new Exception(MSG_ERROR + "PROVIENE DE:    Codigo del Producto segun el Fabricante\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            No deje espacios en blanco.");
            }
            if (codProFab.startsWith("-")) {
                throw new Exception(MSG_ERROR + "PROVIENE DE:    Codigo del Producto segun el Fabricante\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            No puede ser un numero negativo.");
            }
            if (!Utilities.esLetraDigito(codProFab)){
                throw new Exception(MSG_ERROR + "PROVIENE DE:    Codigo del Producto segun el Fabricante\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            No debe contener ningun otro simbolo\n"
                                              + "                               a excepcion de cualquier digito o letra.");                
            }
            if (cont < 0) {
                throw new Exception(MSG_ERROR + "PROVIENE DE:    Codigo del Producto segun el Fabricante\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            FALSE: No puede ser menor que 0.");
            }
            
            try {
                ret = excecuteSQLSpecific3(codProFab);
            } catch (SQLException ex) {
                request.setAttribute("error", "EXCEPCIÓN CONTROLADA #06: "+ex);
                return false;
            }
            
            if (ret.equals("true")) {
                throw new Exception(MSG_ERROR + "PROVIENE DE:    Codigo del Producto segun el Fabricante\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            YA existe este codigo del producto.");
            }
        }catch(Exception e) {
            request.setAttribute("consolaInventario", e.getMessage());
            return false;
        }
        return true;
    }
    
// VALIDACION PARA EDITAR O ELIMINAR    
    private boolean codProEmpresaVer_Edit_Delete(HttpServletRequest request, String codProEmp, String evento) {
        try {
            int cont = codProEmp.length();
            String ret = null;

            if (codProEmp.isEmpty()) {
                throw new Exception(MSG_ERROR + "PROVIENE DE:    Codigo del Producto en la Empresa\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            No deje en blanco este casillero.");
            }
            if (codProEmp.startsWith(" ")) {
                throw new Exception(MSG_ERROR + "PROVIENE DE:    Codigo del Producto en la Empresa\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            No deje espacios en blanco.");
            }
            if (codProEmp.startsWith("-")) {
                throw new Exception(MSG_ERROR + "PROVIENE DE:    Codigo del Producto en la Empresa\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            No puede ser un numero negativo.");
            }
            if (!Utilities.esDigito(codProEmp)) {
                throw new Exception(MSG_ERROR + "PROVIENE DE:    Codigo del Producto en la Empresa\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            No debe contener ningun otro caracter o simbolo\n"
                                              + "                               a excepcion de cualquier digito.");                
            }
            if (cont < 0) {
                throw new Exception(MSG_ERROR + "PROVIENE DE:    Codigo del Producto en la Empresa\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            FALSE: No puede ser menor que 0.");
            }
            
            try {
                ret = excecuteSQLSpecific2(codProEmp);
            } catch (SQLException ex) {
                request.setAttribute("error", "EXCEPCIÓN CONTROLADA #04: "+ex);
                return false;
            }
            
            if (!ret.equals("true")) {
                throw new Exception(MSG_ERROR + "PROVIENE DE:    Codigo del Producto en la Empresa\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            NO existe este codigo del proveedor.");
            }
        }catch(Exception e) {
            request.setAttribute("consolaInventario", e.getMessage());
            return false;
        }
        return true;
    }
    private boolean nombreProducto(HttpServletRequest request, String nombProducto, String evento) {
        try {
            int contNombre = nombProducto.length();

            if (nombProducto.isEmpty()) {
                throw new Exception(MSG_ERROR + "PROVIENE DE:    Nombre del Producto\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            No deje en blanco este casillero.");
            }
            if (nombProducto.startsWith(" ")) {
                throw new Exception(MSG_ERROR + "PROVIENE DE:    Nombre del Producto\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            No deje espacios en blanco.");
            }
            if (contNombre > 40) {
                throw new Exception(MSG_ERROR + "PROVIENE DE:    Nombre del Producto\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            No debe tener mas de 40 caracteres.");
            }
            if (!Utilities.esLetraOConEspacio(nombProducto)){
                throw new Exception(MSG_ERROR + "PROVIENE DE:    Nombre del Producto\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            No debe contener ningun digito o simbolo,\n"
                                              + "                               solo caracter alfabetico.");
            }

        } catch (Exception e) {
            request.setAttribute("consolaInventario",""+e.getMessage());
            return false;
        }
        return true;
    }
    private boolean precioUnitario(HttpServletRequest request, String precioUnitario, String evento) {
        try {
            int cont = precioUnitario.length();
            String ret = null;

            if (precioUnitario.isEmpty()) {
                throw new Exception(MSG_ERROR + "PROVIENE DE:    Precio Unitario\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            No deje en blanco este casillero.");
            }
            if (precioUnitario.startsWith(" ")) {
                throw new Exception(MSG_ERROR + "PROVIENE DE:    Precio Unitario\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            No deje espacios en blanco.");
            }
            if (precioUnitario.startsWith("-")) {
                throw new Exception(MSG_ERROR + "PROVIENE DE:    Precio Unitario\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            No puede ser un numero negativo.");
            }
            try {
                Double.parseDouble(precioUnitario);
            } catch(NumberFormatException en) {
                request.setAttribute("consolaInventario", MSG_ERROR + "PROVIENE DE:    Precio Unitario\n"
                                                                    + "EVENTO:              Click \""+evento+"\" \n"
                                                                    + "MENSAJE:            Al fin a cabo, es un numero. Escribalo bien.");
                return false;
            }
            if (cont < 0) {
                throw new Exception(MSG_ERROR + "PROVIENE DE:    Precio Unitario\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            FALSE: No puede ser menor que 0.");
            }
        }catch(Exception e) {
            request.setAttribute("consolaInventario", e.getMessage());
            return false;
        }
        return true;
    }
    private boolean stock(HttpServletRequest request, String stock, String evento) {
        try {
            int cont = stock.length();

            if (stock.isEmpty()) {
                throw new Exception(MSG_ERROR + "PROVIENE DE:    Stock\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            No deje en blanco este casillero.");
            }
            if (stock.startsWith(" ")) {
                throw new Exception(MSG_ERROR + "PROVIENE DE:    Stock\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            No deje espacios en blanco.");
            }
            if (stock.startsWith("-")) {
                throw new Exception(MSG_ERROR + "PROVIENE DE:    Stock\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            No puede ser un numero negativo.");
            }
            if (cont < 0) {
                throw new Exception(MSG_ERROR + "PROVIENE DE:    Stock\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            FALSE: No puede ser menor que 0.");
            }
            if (!Utilities.esDigito(stock)) {
                throw new Exception(MSG_ERROR + "PROVIENE DE:    Stock\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            No debe contener ningun otro caracter o simbolo\n"
                                              + "                               a excepcion de cualquier digito.");                
            }
            
        } catch (Exception e) {
            request.setAttribute("consolaInventario", e.getMessage());
            return false;
        }
        return true;
    }
    private boolean fecha(HttpServletRequest request, String fecha, String evento) {
        try {
            if (fecha.isEmpty()) {
                throw new Exception(MSG_ERROR + "PROVIENE DE:    Fecha de Ingreso\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            No deje en blanco este casillero.");
            }
            if (fecha.startsWith(" ")) {
                throw new Exception(MSG_ERROR + "PROVIENE DE:    Fecha de Ingreso\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            No deje espacios en blanco.");
            }
            if (!(Utilities.esFechaValida(fecha))) {
                throw new Exception(MSG_ERROR + "PROVIENE DE:    Fecha de Ingreso\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            Formato correcto para registrar la fecha:: <yyyy-MM-dd>");
            }
        } catch (Exception e) {
            request.setAttribute("consolaInventario", e.getMessage());
            return false;
        }
        return true;
    }

//VALIDACION DE CODIGO DE PROOVEDOR    
    private boolean codigoProveedor(HttpServletRequest request, String codProve, String evento) {
        try {
            int cont = codProve.length();
            String ret = null;

            if (codProve.isEmpty()) {
                throw new Exception(MSG_ERROR + "PROVIENE DE:    FK Codigo del Proveedor\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            No deje en blanco este casillero.");
            }
            if (codProve.startsWith(" ")) {
                throw new Exception(MSG_ERROR + "PROVIENE DE:    FK Codigo del Proveedor\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            No deje espacios en blanco.");
            }
            if (codProve.startsWith("-")) {
                throw new Exception(MSG_ERROR + "PROVIENE DE:    FK Codigo del Proveedor\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            No puede ser un numero negativo.");
            }
            if (!Utilities.esDigito(codProve)) {
                throw new Exception(MSG_ERROR + "PROVIENE DE:    FK Codigo del Proveedor\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            No debe contener ningun otro caracter o simbolo\n"
                                              + "                               a excepcion de cualquier digito.");
            }
            if (cont < 0) {
                throw new Exception(MSG_ERROR + "PROVIENE DE:    FK Codigo del Proveedor\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            FALSE: No puede ser menor que 0.");
            }
            
            try {
                ret = excecuteSQLSpecific4(codProve);
            } catch (SQLException ex) {
                request.setAttribute("error", "EXCEPCIÓN CONTROLADA #04: "+ex);
                return false;
            }
            
            if (!ret.equals("true")) {
                throw new Exception(MSG_ERROR + "PROVIENE DE:    FK Codigo del Proveedor\n"
                                              + "EVENTO:              Click \""+evento+"\" \n"
                                              + "MENSAJE:            NO existe este codigo del proveedor.");
            }
        }catch(Exception e) {
            request.setAttribute("consolaInventario", e.getMessage());
            return false;
        }
        return true;
    }
    
    private boolean action(HttpServletRequest request, HttpServletResponse response) {
        String btnINSERTAR = request.getParameter("INSERTAR");
        String btnELIMINAR = request.getParameter("ELIMINAR");
        String btnACTUALIZAR = request.getParameter("ACTUALIZAR");
        String btnGETDATOS = request.getParameter("GET_DATOS");
        
        String codProEmp = request.getParameter("Cod_Pro_Emp");
        String codProFab = request.getParameter("Cod_Pro_Fab");
        String nombreProducto = request.getParameter("Nombre_Producto");
        String precioUnitario = request.getParameter("Precio_Unitario");
        String stock = request.getParameter("STOCK");
        String fecha = request.getParameter("Fecha_Ingreso");
        String fkProveedor = request.getParameter("fk_proveedor");
        
        String btnTabla = request.getParameter("getTableInventario");
        
        List lista = null;
        
        if (btnGETDATOS != null) {
            String codigoEmp = "";
            String codigoFab = "";
            String nombreProd = "";
            String precioUnit = "";
            String stoc = "";
            String fech = "";
            String fkProve = "";
            
            try {
                codigoEmp = excecuteSQLSpecific5(codProEmp);
                codigoFab = excecuteSQLSpecific6(codProEmp);
                nombreProd = excecuteSQLSpecific7(codProEmp);
                precioUnit = excecuteSQLSpecific8(codProEmp);
                stoc = excecuteSQLSpecific9(codProEmp);
                fech = excecuteSQLSpecific10(codProEmp);
                fkProve = excecuteSQLSpecific11(codProEmp);
                
                lista = excecuteSQLSpecific1();
            } catch(SQLException ex) {
                request.setAttribute("error", "EXCEPCIÓN CONTROLADA: "+ex);
                return false;
            
            } finally {
                request.setAttribute("Cod_Pro_Emp_VER", codigoEmp);
                request.setAttribute("Cod_Pro_Fab_VER", codigoFab);
                request.setAttribute("Nombre_Producto_VER", nombreProd);
                request.setAttribute("Precio_Unitario_VER", precioUnit);
                request.setAttribute("STOCK_VER", stoc);
                request.setAttribute("Fecha_Ingreso_VER", fech);
                request.setAttribute("fk_proveedor_VER", fkProve);
            }
        }
        
        if (btnINSERTAR != null) {
            ejecutaInsert(request, codProEmp, codProFab, nombreProducto, precioUnitario, stock, fecha, fkProveedor);
            try {
                lista = excecuteSQLSpecific1();
            } catch(SQLException ex) {
                request.setAttribute("error", "EXCEPCIÓN CONTROLADA: "+ex);
                return false;
            }
        }
        
        if (btnELIMINAR != null) {
            ejecutaDelete(request, codProEmp);
            try {
                lista = excecuteSQLSpecific1();
            } catch(SQLException ex) {
                request.setAttribute("error", "EXCEPCIÓN CONTROLADA: "+ex);
                return false;
            }
        }

        if (btnACTUALIZAR != null) {
            ejecutaUpdate(request, codProEmp, codProFab, nombreProducto, precioUnitario, stock, fecha, fkProveedor);
            try {
                lista = excecuteSQLSpecific1();
            } catch(SQLException ex) {
                request.setAttribute("error", "EXCEPCIÓN CONTROLADA: "+ex);
                return false;
            }
        }
        
        if(btnTabla != null) {
            try {
                lista = excecuteSQLSpecific1();
            } catch(SQLException ex) {
                request.setAttribute("error", "EXCEPCIÓN CONTROLADA: "+ex);
                return false;
            }
        }
        
        HttpSession session = request.getSession(false);
        session.setAttribute("inventario", lista);
        
        return true;
    }

    //STATEMENT
    private boolean ejecutaInsert(HttpServletRequest request, String codProEmp, String codProFab, String nombreProducto, String precioUnitario, 
                                  String stock, String fecha, String fkProveedor) {
        String sql = "INSERT INTO ARTICULOS VALUES ("+ codProEmp +", '"+ codProFab +"', '"+ nombreProducto +"', '"+ precioUnitario +"', "
                                                 + "'"+ stock +"', '"+ fecha +"', "+ fkProveedor +") ";
        try {
            microModelGUI.execute(statement, sql);
        } catch(SQLException ex) {
            request.setAttribute("error", "EXCEPCIÓN CONTROLADA #09 "+ex);
            return false;
        }
        return true;
    }

    private boolean ejecutaDelete(HttpServletRequest request, String codProEmp) {
        String sql = "DELETE FROM ARTICULOS "
                   + "WHERE COD_PRO_EMP = "+ codProEmp +" ";
        try {
            microModelGUI.execute(statement, sql);
        } catch(SQLException ex) {
            request.setAttribute("error", "EXCEPCIÓN CONTROLADA #10 "+ex);
            return false;
        }
        return true;
    }
    
    private boolean ejecutaUpdate(HttpServletRequest request, String codProEmp, String codProFab, String nombreProducto, String precioUnitario, 
                                  String stock, String fecha, String fkProveedor) {
    
        String sqlUpdate = "UPDATE ARTICULOS SET NOMBRE_PROD = '"+ nombreProducto +"', PRECIO_U = '"+ precioUnitario +"', "
                         + "STOCK = '"+ stock +"', FECHA = '"+ fecha +"', PROOVEDOR_CODIGO_PROOVEDOR = "+ fkProveedor +" "
                         + "WHERE COD_PRO_EMP = "+ codProEmp +" ";
        
        try {
            microModelGUI.execute(statement, sqlUpdate);
        } catch(SQLException ex) {
            request.setAttribute("error", "EXCEPCIÓN CONTROLADA #11 "+ex);
            return false;
        }
        return true;
    }
    
    
    private void view(HttpServletRequest request, HttpServletResponse response) {
        ServletContext context = this.getServletContext();
        RequestDispatcher view = context.getRequestDispatcher("/v_S2.jsp");
        
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

    
// QUERY    
    public String excecuteSQL(String sql) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List excecuteSQLSpecific1() throws SQLException {
        String sql = "SELECT * FROM ARTICULOS";
        
        ResultSet resultSet = MicroModelGUI.executeQuery(statement, sql);
        List lista = new ArrayList();
        
        try {
            while (resultSet.next()) {
                String codProEmp = resultSet.getString(1);
                String codProFab = resultSet.getString(2);
                String nombre = resultSet.getString(3);
                String precio = resultSet.getString(4);
                String stock = resultSet.getString(5);
                String fecha = resultSet.getString(6);
                String proveedor = resultSet.getString(7);
                
                String[] articulo = {codProEmp,codProFab,nombre,precio,stock,fecha,proveedor};

                lista.add(articulo);
            }
        } catch(SQLException e) {
            throw new SQLException(MicroModelGUI.resolveException(e));
        }
        return lista;
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
        String sql = "SELECT COUNT(*) FROM PROOVEDOR WHERE CODIGO_PROOVEDOR = '" + s + "'";
        ResultSet resultSet = MicroModelGUI.executeQuery(statement, sql);
        resultSet.next();
        int cont = Integer.parseInt(resultSet.getString(1));
        return cont == 0 ? "false" : "true";
    }
    
//QUERY PARA EL BOTON MOSTRAR
    public String excecuteSQLSpecific5(String s) throws SQLException {
        String sql = "SELECT COD_PRO_EMP "
                   + "FROM   ARTICULOS "
                   + "WHERE  COD_PRO_EMP = '"+ s +"' ";
        ResultSet resultSet = MicroModelGUI.executeQuery(statement, sql);
        resultSet.next();
        int codProEmp = Integer.parseInt(resultSet.getString(1));
        return "" + codProEmp;
    }
    
    public String excecuteSQLSpecific6(String s) throws SQLException {
        String sql = "SELECT COD_PRO_FAB "
                   + "FROM   ARTICULOS "
                   + "WHERE  COD_PRO_EMP = '"+ s +"' ";
        ResultSet resultSet = MicroModelGUI.executeQuery(statement, sql);
        resultSet.next();
        String codProFab = resultSet.getString(1);
        codProFab = resultSet.wasNull() ? "" : (codProFab + "");
        return codProFab;
    }
    
    public String excecuteSQLSpecific7(String s) throws SQLException {
        String sql = "SELECT NOMBRE_PROD "
                   + "FROM   ARTICULOS "
                   + "WHERE  COD_PRO_EMP = '"+ s +"' ";
        ResultSet resultSet = MicroModelGUI.executeQuery(statement, sql);
        resultSet.next();
        String nombre = resultSet.getString(1);
        nombre = resultSet.wasNull() ? "" : (nombre + "");
        return nombre;
    }

    public String excecuteSQLSpecific8(String s) throws SQLException {
        String sql = "SELECT PRECIO_U "
                   + "FROM   ARTICULOS "
                   + "WHERE  COD_PRO_EMP = '"+ s +"' ";
        ResultSet resultSet = MicroModelGUI.executeQuery(statement, sql);
        resultSet.next();
        double codProFab = Double.parseDouble(resultSet.getString(1));
        return "" + codProFab;
    }

    public String excecuteSQLSpecific9(String s) throws SQLException {
        String sql = "SELECT STOCK "
                   + "FROM   ARTICULOS "
                   + "WHERE  COD_PRO_EMP = '"+ s +"' ";
        ResultSet resultSet = MicroModelGUI.executeQuery(statement, sql);
        resultSet.next();
        int codProFab = Integer.parseInt(resultSet.getString(1));
        return "" + codProFab;
    }
    
    public String excecuteSQLSpecific10(String s) throws SQLException {
        String sql = "SELECT FECHA "
                   + "FROM   ARTICULOS "
                   + "WHERE  COD_PRO_EMP = '"+ s +"' ";
        ResultSet resultSet = MicroModelGUI.executeQuery(statement, sql);
        resultSet.next();
        String fecha = resultSet.getString(1);
        fecha = resultSet.wasNull() ? "" : (fecha + "");
        return fecha;
    }

    public String excecuteSQLSpecific11(String s) throws SQLException {
        String sql = "SELECT PROOVEDOR_CODIGO_PROOVEDOR "
                   + "FROM   ARTICULOS "
                   + "WHERE  COD_PRO_EMP = '"+ s +"' ";
        ResultSet resultSet = MicroModelGUI.executeQuery(statement, sql);
        resultSet.next();
        int codProFab = Integer.parseInt(resultSet.getString(1));
        return "" + codProFab;
    }

}