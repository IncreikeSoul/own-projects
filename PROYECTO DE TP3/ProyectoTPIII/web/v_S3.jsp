<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>Proyecto Tienda Virtual</title>
        <meta http-equiv="content-type" content="TEXT/HTML; CHARSET=UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/style.css" type="text/css">
    </head>
    <body>
        <table align="center" border="0" cellpadding="0" cellspacing="0" width="1000">
            <tr>
                <td colspan="4" height="20px">&nbsp;</td>
            </tr>
            <tr>
                <td width="20px">&nbsp;</td>
                <td class="oben" colspan="2">
                    <div class="logo">
                        <img src="images/symbol.png" width="180" height="130" border="0" alt="">
                    </div>
                    <div id="textobengross">TIENDA VIRTUAL "SAGA FALABELLA"</div>
                    <div id="textobenklein">Sistema de compra dinámica</div>
                </td>
                <td width="20px">&nbsp;</td>
            </tr>
            <tr>
                <td width="20px">&nbsp;</td>
                <td style="background: url(images/navbar.jpg); height: 36px; text-align: center;" colspan="2">
                    <div class="headernavi">
                        <form method="POST">
                            <a href="http://localhost:8084/ProyectoTPIII/SA?START=">CARRITO DE COMPRAS</a>
                            <a href="http://localhost:8084/ProyectoTPIII/S2?Cod_Pro_Emp=&Cod_Pro_Fab=&Nombre_Producto=&Precio_Unitario=&STOCK=&Fecha_Ingreso=&fk_proveedor=&getTableInventario=Enviar">INVENTARIO</a>
                            <a href="v_S3.jsp">PROVEEDOR</a>
                        </form>
                    </div>
                </td>
                <td width="20px">&nbsp;</td>
            </tr>
            <tr>
                <td width="20px">&nbsp;</td>
                <td style="color: #000000; background-color: #FFFFFF; background: url(images/lineback.jpg) repeat-x; height: 13px;" colspan="2">&nbsp;</td>
                <td width="20px">&nbsp;</td>
            </tr>
            <tr>
                <td width="20px">&nbsp;</td>
                <td class="hauptfenster" valign="top" align="center" colspan="2">
                    <div class="haupttext">
                        <form action="S3" method="GET">
                            <div align="center">
                                <h4></h4>
                                <h1>PROVEEDOR</h1>
                                <h4></h4><br>
                            </div>
                            <div align="center">
                                &nbsp;&nbsp;<input type="text" name="Cod_Proveedor" placeholder=" Codigo del proveedor" style="width: 175px; height: 23px;" value="${requestScope['Cod_Proveedor_VER']}"/> &nbsp; 
                                <input type="submit" name="GET_DATOS" value="GET DATOS" style="width: 175px; height: 30px;" />
                                <br><br>
                                <h4></h4>
                                <br><br>
                                <input type="text" name="Nombre_Proveedor" placeholder=" Nombre del proveedor" style="width: 175px; height: 20px;" value="${requestScope['Nombre_Proveedor_VER']}"/> &nbsp;
                                <input type="text" name="Pais_Proveedor" placeholder=" Pais Residencial" style="width: 175px; height: 20px;" value="${requestScope['Pais_Proveedor_VER']}"/> &nbsp;
                                <input type="text" name="Telefono" placeholder=" Telefono del proveedor" style="width: 175px; height: 20px;" value="${requestScope['Telefono_VER']}"/>
                                <br><br><br>
                                <input type="submit" name="INSERTAR" value="INSERTAR" style="width: 175px; height: 30px;" /> &nbsp;
                                <input type="submit" name="ELIMINAR" value="ELIMINAR" style="width: 175px; height: 30px;" /> &nbsp;
                                <input type="submit" name="ACTUALIZAR" value="ACTUALIZAR" style="width: 175px; height: 30px;" />
                            </div>
                                <input type="submit" name="getTableProovedor" style="color: transparent; background-color: transparent; border-color: transparent; cursor: default;">
                        </form>
                        <br><br>
                        <div><br>
                            <table border="1" width="100%" cellspacing="2" cellpadding="3">
                                <tr>
                                    <th width="20%">Codigo Proveedor</th>
                                    <th>Nombre Completo</th>
                                    <th>Pais Residencial</th>
                                    <th>Telefono</th>
                                </tr>
                                <c:forEach items="${sessionScope['providers']}" var="prov" >
                                <tr>
                                    <td>${prov[0]}</td>
                                    <td>${prov[1]}</td>
                                    <td>${prov[2]}</td>
                                    <td>${prov[3]}</td>
                                </tr>
                              </c:forEach>
                            </table>
                        </div>
                        <br><br><br>
                        <textarea rows="8" style="width: 85%" readonly="readonly">${requestScope['consolaProveedor']}</textarea>
                    </div>
                </td>
                <td width="20px">&nbsp;</td>
            </tr>
            <tr>
                <td  colspan="4" height="20px">&nbsp;</td>
            </tr>
        </table>
        <div align="center">
            <a class="copyright" style="color:#C0C0C0;background-color:#000000;" target="_blank">&nbsp;</a>
        </div>
    </body>
</html>