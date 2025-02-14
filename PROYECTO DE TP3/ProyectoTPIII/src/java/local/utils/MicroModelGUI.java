/* MicroModelGUI.java
 * Autor: profesor Augusto Vega Pinedo.
 * Descripcion: Datos y metodos globales para interaccion entre las bases de
 *              datos y el programa JDBC.
 */

package local.utils;

import java.sql.*;

public class MicroModelGUI {
    private static final String DEFAULT_DRIVER="com.mysql.jdbc.Driver";
    private static final String DEFAULT_DATABASE_NAME="localhost/proyectomysql";
    private static final String DEFAULT_USER="root";
    private static final String DEFAULT_PASSWORD="123";
    private static final String DEFAULT_PRE_SOURCE_URL="jdbc:mysql://";
    private static final String DEFAULT_SOURCE_URL=
                                    "jdbc:mysql://"+DEFAULT_DATABASE_NAME
                                        +"?user="+DEFAULT_USER
                                        +"&password="+DEFAULT_PASSWORD;
    //private static final String DATABASE_URL_COMPLETE =
    //        "jdbc:mysql://localhost/mystore2?user=root&password=1234";
    private String driver=DEFAULT_DRIVER;
    public String databaseName=DEFAULT_DATABASE_NAME;
    public String user=DEFAULT_USER;
    public String password=DEFAULT_PASSWORD;
    public String preSourceURL=DEFAULT_PRE_SOURCE_URL;
    public String sourceURL=DEFAULT_SOURCE_URL;
    
    private Connection connection;
    
    public MicroModelGUI(String driver, String databaseName, String preSourceURL,
                      String user, String password)
    {
        setDriver(driver);
        setDatabaseName(databaseName);
        setPreSourceURL(preSourceURL);
        setUser(user);
        setPassword(password);
        updateSourceURL();
        //Carga la clase Driver
        try {
            Class.forName(this.driver);
        } catch(ClassNotFoundException e) {
            System.err.println(e);
        }
        //Crear la conexion a traves de DriveManager
        try {
            connection=DriverManager.getConnection(this.sourceURL);
        } catch(SQLException e) {
            resolveException(e);
        }
    }
    public MicroModelGUI(String user, String password) {
        this(null, null, null, user, password);
    }
    public MicroModelGUI(String databaseName, String user, String password) {
        this(null, databaseName, null, user, password);
    }
    public MicroModelGUI(String databaseName) {this(databaseName, null, null);}
    public MicroModelGUI() {this(null);}
    //--------------------------------------------------------------------------
    public void setDriver(String driver) {
        this.driver=driver!=null?driver:DEFAULT_DRIVER;
    }
    public void setDatabaseName(String databaseName) {
        this.databaseName=databaseName!=null?databaseName:DEFAULT_DATABASE_NAME;
    }
    public void setPreSourceURL(String preSourceURL) {
        this.preSourceURL=preSourceURL!=null?preSourceURL:DEFAULT_PRE_SOURCE_URL;
    }
    public void setSourceURL(String sourceURL) {
        this.sourceURL=sourceURL!=null?sourceURL:DEFAULT_SOURCE_URL;
    }
    public void setUser(String user) {
        this.user=user!=null?user:DEFAULT_USER;
    }
    public void setPassword(String password) {
        this.password=password!=null?password:DEFAULT_PASSWORD;
    }
    //--------------------------------------------------------------------------
    public String getDriver() {return driver;}
    public String getDatabaseName() {return databaseName;}
    public String getPreSourceURL() {return preSourceURL;}
    public String getSourceURL() {return sourceURL;}
    public String getUser() {return user;}
    public String getPassword() {return password;}
    //--------------------------------------------------------------------------
    public void updateSourceURL() {
        setSourceURL(preSourceURL+databaseName
                    +((user==null || user=="" || password==null|| password=="")?
                    "" : ("?user="+user+"&password="+password)));
    }
    //--------------------------------------------------------------------------
    public void close() {
        if(connection==null) {
            return;
        }
        try {
            connection.close();
        } catch(SQLException e) {
            resolveException(e);
        }
    }
    //--------------------------------------------------------------------------
    public Statement createStatement() {
        Statement statement=null;
        try {
            statement=connection.createStatement();
        } catch(SQLException e) {
            resolveException(e);
        }
        return statement;
    }
    public Statement createStatement(int resultSetType, int resultSetConcurrency)
    {
        Statement statement=null;
        try {
            statement=connection.createStatement(
                            resultSetType, resultSetConcurrency);
        } catch(SQLException e) {
            resolveException(e);
        }
        return statement;
    }
    
    public static ResultSet executeQuery(Statement statement, String query)
        throws SQLException
    {   ResultSet resultSet=statement.executeQuery(query);
        return resultSet;
    }
        
    public void execute(Statement statement, String query)
        throws SQLException
    {
        if(connection == null) {
            return;
        }
        try {
            statement.execute(query);
        } catch(SQLException ex) {
            throw new SQLException(resolveException(ex));
        }
    }
    
    public static void closeResultSet(ResultSet resultSet) {
        if(resultSet!=null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                resolveException(e);
            }
        } 
    }
    public static void closeStatement(Statement statement) {
        if(statement!=null) {
            try {
                statement.close();
            } catch (SQLException e) {
                resolveException(e);
            }
        } 
    }
    public void closeConnection() {
        if(connection!=null) {
            try {
                connection.close();
                connection = null;
            } catch(SQLException e) {
                resolveException(e);
            }
        }
    }
    public void closeAll(ResultSet resultSet, Statement statement) {
        closeResultSet(resultSet);
        closeStatement(statement);
        closeConnection();
    }
    //--------------------------------------------------------------------------
    public static String resolveException(SQLException e) {
        StringBuffer sb = new StringBuffer();
        do {
            sb.append("\nExcepcion ocurrida:\nMessage: "+e.getMessage());
            sb.append("\nEstado SQL: "+e.getSQLState());
            sb.append("\nCodigo del fabricante: "+e.getErrorCode()
                                +"\n----------------");
        } while((e=e.getNextException())!=null);
        return sb + "";
    }
    static String checkForWarning(SQLWarning w) {
        if(w == null) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        do {
            sb.append("\nWarning:\nMensaje: " + w.getMessage());
            sb.append("\nEstado SQL: " + w.getSQLState());
            sb.append("\nCodigo del fabricante: " + w.getErrorCode()
                                + "\n----------------");
        } while((w=w.getNextWarning())!=null);
        return sb + "";
    }

    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////

    public String getContent(Statement statement, String nombreDeTabla)
            throws SQLException
    {
        StringBuffer sb = new StringBuffer();
        String query = "SELECT * FROM "+nombreDeTabla;
        ResultSet resultSet = executeQuery(statement, query);
        ResultSetMetaData rsmd = resultSet.getMetaData();
        int count = rsmd.getColumnCount();
        boolean yaHayUnaLinea = false;
        while(resultSet.next()) {
            if(yaHayUnaLinea) {
                sb.append("\n");
            }
            for(int i=1; i<=count; i++) {
                if(i>1) {
                    sb.append(", ");
                }
                sb.append(resultSet.getString(i));
            }
            yaHayUnaLinea=true;
        }
        return sb+"";
    }
}