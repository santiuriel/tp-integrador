/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.ProductoDAO;
import dao.ProductoDAOImpl;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
//import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Producto;

/**
 *
 * @author estudiante
 */
@WebServlet(name = "ProductoController", urlPatterns = {"/ProductoController"})
public class ProductoController extends HttpServlet {

    ProductoDAO productoDAO = new ProductoDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if (accion == null || accion.isEmpty()) {
            //ir a la lista
            listarProductos(request, response);

        } else {
            switch (accion) {
                case "nuevo":
                    nuevoProducto(request, response);
                    break;
                case "edit":
                    editProducto(request, response);
                    break;
                case "delete":
                    deleteProducto(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Producto producto = null;
        String id = request.getParameter("id");
        String marca = request.getParameter("marca");
        String nombre = request.getParameter("nombre");
        int precio = Integer.parseInt(request.getParameter("precio").trim());
        int stock = Integer.parseInt(request.getParameter("stock").trim());
        int vendidos = Integer.parseInt(request.getParameter("vendidos").trim());

        if (id == null || id.isEmpty()) {
            producto = new Producto(id, marca, nombre, precio, stock, vendidos);
            productoDAO.save(producto);
            listarProductos(request, response);
        } else {
            producto = new Producto(id, marca, nombre, precio, stock, vendidos);
            productoDAO.update(producto);
            listarProductos(request, response);
        }
    }

    private void listarProductos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Producto> list = new ArrayList<>();

        list = productoDAO.getAll();

        request.setAttribute("list", list);

        request.getRequestDispatcher("list.jsp").forward(request, response);
    }

    private void nuevoProducto(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("form-empleado.jsp");
    }

    private void editProducto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Producto producto;
        int id = Integer.parseInt(request.getParameter("id"));

        producto = productoDAO.getById(id);

        request.setAttribute("producto", producto);

        request.getRequestDispatcher("form-empleado.jsp").forward(request, response);
    }

    private void deleteProducto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        productoDAO.delete(id);
        listarProductos(request, response);
        
    }

}
