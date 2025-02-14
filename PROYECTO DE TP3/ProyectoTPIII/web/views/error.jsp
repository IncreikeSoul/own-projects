<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ERROR</title>
    </head>
    <body style="background-color: #000000; color: tomato;">
        <%--<jsp:include page="/form1.jsp" />--%>
        <h1 style="font-size:60px">Mensaje de ERROR</h1>
        <h2>${requestScope['error']}</h2>
        <form>
<div>
  <input type="button" value="OK" style="font-size:120px" name="Back2" onclick="history.back()" />
  </div>
 </form>
    </body>
</html>
