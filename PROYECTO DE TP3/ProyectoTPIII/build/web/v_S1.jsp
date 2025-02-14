<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>Proyecto Tienda Virtual</title>
        <meta http-equiv="content-type" content="TEXT/HTML; CHARSET=UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/style.css" type="text/css">
    </head>
    <body>
        <table align="center" border="0" cellpadding="0" cellspacing="0" width="1250">
            <tr>
                <td  colspan="4" height="20px">&nbsp;</td>
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
                        <a name="linkCarrito" href="v_S1.jsp">CARRITO DE COMPRAS</a>
                        <a name="linkInventario" href="http://localhost:8084/ProyectoTPIII/S2?Cod_Pro_Emp=&Cod_Pro_Fab=&Nombre_Producto=&Precio_Unitario=&STOCK=&Fecha_Ingreso=&fk_proveedor=&getTableInventario=Enviar">INVENTARIO</a>
                        <a name="linkProovedor" href="http://localhost:8084/ProyectoTPIII/S3?Cod_Proveedor=&Nombre_Proveedor=&Pais_Proveedor=&Telefono=&getTableProovedor=Enviar">PROVEEDOR</a>
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
                <td colspan="2" align="center">
                    <div class="haupttext">
                        <h4></h4>
                        <h1>CARRITO DE COMPRAS</h1>
                        <h4></h4><br>
                    </div> 
                </td>
                <td width="20px">&nbsp;</td>
            </tr>
            <!--CUERPO-->
            <tr>
                <td width="20px">&nbsp;</td>
                <td valign="top" width="25%">
                    <form action="S1" method="GET">
                        <h2>NRO. CARRITO ACTUAL (#): </h2>
                            <input type="text" name="nroCarrito" value="${initParam['carrito']}" readonly style="width: 250px; height: 25px; font-size: 15px; text-align: center;">
                        <br><br>
                    <!--FORMULARIO "INSERT"-->    
                        <h4 style="width: 88%">Formulario "Agregar"</h4><p><br>
                    <!--INSERTAR-->
                        <fieldset style="width: 83%">
                            <legend>Agregar al Carrito</legend>
                            <!--LISTA DEL INVENTARIO-->
                            <p>Nombre del Articulo:</p>
                                <p><input list="browsers" name="browser" style="width: 220px; height: 20px;"></p>
                            <datalist id="browsers">
                                <c:forEach items="${sessionScope['getNombres']}" var="nom" >
                                    <option>${nom[0]}</option>
                                </c:forEach>
                            </datalist>
                            <!--EL RESTO DEL FORMULARIO-->
                            <br>
                            <p>Cantidad:</p>
                                <p><input type="text" name="cantidad" style="width: 180px; height: 20px;"></p><br>
                            <p>
                            <input type="submit" name="AGREGAR" value="AGREGAR" style="width: 165px; height: 40px;">
                        </fieldset>
                        <br>
                    <!--ACTUALIZAR-->
                        <h4 style="width: 88%">Formulario "Actualizar"</h4><p><br>
                        <!--CAMBIAR OTRO ARTICULO X CODPROEMP-->
                        <fieldset style="width: 83%">
                            <legend>Cambiar otro artículo x C.P.E:</legend>
                            <p>Cod_Pro_Emp Actual:</p>
                                <p><input type="text" name="codProEmpActual" style="width: 180px; height: 20px;"></p>
                            <p>Cod_Pro_Emp Nueva:</p>
                                <p><input type="text" name="codProEmpNueva" style="width: 180px; height: 20px;"></p>
                            <p>Cantidad:</p>
                                <p><input type="text" name="cantidadA" style="width: 180px; height: 20px;"></p>
                            <p><br>
                            <input type="submit" name="CAMBIAR_CodProEmp" value="CAMBIAR" style="width: 100px; height: 30px">
                        </fieldset>
                        <br><br>
                        <!--CAMBIAR OTRO ARTICULO X CODPROFAB-->
                        <fieldset style="width: 83%">
                            <legend>Cambiar otro artículo x C.P.F:</legend>
                            <p>Cod_Pro_Fab Actual:</p>
                                <p><input type="text" name="codProFabActual" style="width: 180px; height: 20px;"></p>
                            <p>Cod_Pro_Fab Nueva:</p>
                                <p><input type="text" name="codProFabNueva" style="width: 180px; height: 20px;"></p>
                            <p>Cantidad:</p>
                                <p><input type="text" name="cantidadB" style="width: 180px; height: 20px;"></p>
                            <p><br>
                            <input type="submit" name="CAMBIAR_CodProFab" value="CAMBIAR" style="width: 100px; height: 30px">
                        </fieldset>
                        <br>
                        <!--CAMBIAR LA CANTIDAD-->
                        <fieldset style="width: 83%">
                            <legend>Cambiar de cantidad:</legend>
                            <p>Cod_Pro_Emp Actual:</p>
                                <p><input type="text" name="COD_PRO_EMP" style="width: 180px; height: 20px;"></p>
                            <p>Cantidad:</p>
                                <p><input type="text" name="cantidadC" style="width: 180px; height: 20px;"></p>
                            <p><br>
                            <input type="submit" name="ACTUALIZAR" value="ACTUALIZAR" style="width: 120px; height: 30px">
                        </fieldset>        
                        <br><br>        
                    <!--BORRAR-->
                        <h4 style="width: 88%">Formulario "Eliminar"</h4><p><br>
                        <fieldset style="width: 83%">
                            <legend>Sacar articulo del Carrito</legend>
                            <p>Nombre del Articulo:</p>
                                <p><input list="browsersDelete" name="browserEliminar" style="width: 220px; height: 20px;"></p>
                            <datalist id="browsersDelete">
                                <c:forEach items="${sessionScope['getNombresDelete']}" var="nom" >
                                    <option>${nom[0]}</option>
                                </c:forEach>
                            </datalist>
                            <br>
                            <p><input type="submit" name="ELIMINAR" value="ELIMINAR" style="width: 165px; height: 40px;"><p>
                        </fieldset>
                    </form>
                    <!--Fin del Formulario-->
                    <br>
                </td>
            <!--RESULTADO-->    
            <td class="hauptfenster" valign="top">
                    <div class="haupttext">
                        <br><br>
                        <table border="1" width="870" cellspacing="2" cellpadding="3">
                            <tr>
                                <th width="15%">Cod. Prod. en la empresa</th>
                                <th width="15%">Cod. Prod. segun fabricante</th>
                                <th>Nombre del fabricante</th>
                                <th>Nombre del producto</th>
                                <th width="8%">Cantidad</th>
                                <th width="8%">Precio Unitario</th>
                            </tr>
                        <c:forEach items="${sessionScope['datos']}" var="d" varStatus="c">
                            <tr name="TablaResultado" style="background-color:yellow">
                                <td>${d[0]}</td>
                                <td>${d[1]}</td>
                                <td>${d[2]}</td>
                                <td>${d[3]}</td>
                                <td>${d[4]}</td>
                                <td>${d[5]}</td>
                            </tr>
                          </c:forEach>
                        </table>
                        <br><br><br><br>
                        
                        <table border="1" width="0" cellspacing="2" cellpadding="3" >
                            <tr>
                                <th width="100px">Cantidad Total</th>
                                <th style="background-color: powderblue">
                                    <c:set var="Y" scope="page" value="${applicationScope['me']+initParam['vejez']}" />
                                        <input type="text" name="CANTIDAD_TOTAL" size="20" value="${applicationScope['cantTotal']}" readonly="readonly" />
                                
                                </th>
                                <th width="100px">Precio Total</th>
                                <th style="background-color: powderblue">
                                    <input type="text" name="PRECIO_TOTAL" size="20" value="${applicationScope['precioTotal']}" readonly="readonly" />
                                </th>
                            </tr>
                        </table>
                    </div>
                    <br><br><br><br><br>
                    <textarea rows="8" style="width: 85%" readonly="readonly">${requestScope['consolaCarrito']}</textarea>
                    <br>
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