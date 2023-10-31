<%-- 
    Document   : list
    Created on : 05/10/2023, 18:58:53
    Author     : estudiante
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>        
        <a href="ProductoController?accion=nuevo"> <h3>Nuevo producto</h3> </a>
    
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>MARCA</th>
                    <th>NOMBRE</th>
                    <th>PRECIO</th>
                    <th>STOCK</th>
                    <th>VENDIDOS</th>
                    <th>ACCIONES</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="producto" items="${list}">
                <tr>
                    <td> <c:out value="${producto.id}"></c:out> </td>
                    <td> <c:out value="${producto.marca}"></c:out> </td>
                    <td> <c:out value="${producto.nombre}"></c:out> </td>
                    <td> <c:out value="${producto.precio}"></c:out> </td>
                    <td> <c:out value="${producto.stock}"></c:out> </td>
                    <td> <c:out value="${producto.vendidos}"></c:out> </td>
                    <td> 
                        <a href="ProductoController?accion=edit&id=<c:out value="${producto.id}"></c:out>">Actualizar</a>
                        |
                        <a href="ProductoController?accion=delete&id=<c:out value="${producto.id}"></c:out>">Borrar</a>
                    
                    </td>
                    
                </tr>
                </c:forEach>
            </tbody>
        </table>

    </body>
</html>
