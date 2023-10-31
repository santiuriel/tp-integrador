<%-- 
    Document   : form-empleado
    Created on : 05/10/2023, 18:59:11
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
        <h3>Formulario producto</h3>
        
        <form action="ProductoController" method="post">
            <p>
                Marca: 
                <input type="text" name="marca" value="<c:out value="${producto.marca}"></c:out> required">
            </p>
            
            <p>
                Nombre:
                <input type="text" name="nombre" value="<c:out value="${producto.nombre}"></c:out> required">
            </p>
        
            <p>
                Precio:
                <input type="text" name="precio" value="<c:out value="${producto.precio}"></c:out> required">
            </p>
            
            <p>
                Stock:
                <input type="text" name="stock" value="<c:out value="${producto.stock}"></c:out> required">
            </p>
            
            <p>
                Vendidos:
                <input type="text" name="vendidos" value="<c:out value="${producto.vendidos}"></c:out> required">
            </p>
            
            <p>
                
                <input type="hidden" name="id" value="<c:out value="${producto.id}"></c:out>">    
            <input type="submit" value="Guardar">
            </p>
        
        </form>
        
 
    </body>
</html>
