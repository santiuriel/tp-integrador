/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Producto;
import util.DBConnection;

/**
 *
 * @author estudiante
 */
public class ProductoDAOImpl implements ProductoDAO {

    private String sql = " ";
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    @Override
    public void save(Producto producto) {

        try (Connection connection = DBConnection.getConnection()) {
            String sql = "INSERT INTO productos (marca, nombre, precio, stock, vendidos) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, producto.getMarca());
            statement.setString(2, producto.getNombre());
            statement.setInt(3, producto.getPrecio());
            statement.setInt(4, producto.getStock());
            statement.setInt(5, producto.getVendidos());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de excepciones
        }

    }

    @Override
    public void update(Producto producto) {
        try (Connection connection = DBConnection.getConnection()) {
            String sql = "UPDATE productos SET marca = ?, nombre = ?, precio = ?, stock = ?, vendidos = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, producto.getMarca());
            statement.setString(2, producto.getNombre());
            statement.setInt(3, producto.getPrecio());
            statement.setInt(4, producto.getStock());
            statement.setInt(5, producto.getVendidos());
            statement.setString(6, producto.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de excepciones
        }

    }

    @Override
    public void delete(int idProducto) {
        try (Connection connection = DBConnection.getConnection()) {
            String sql = "DELETE FROM productos WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, idProducto);

            statement.executeUpdate();
        } catch (SQLException e) {

        }
    }

    @Override
    public List<Producto> getAll() {
        List<Producto> productos = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection()) {
            String sql = "SELECT * FROM productos";
            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Producto producto = new Producto(
                        resultSet.getString("id"),
                        resultSet.getString(("marca")),
                        resultSet.getString("nombre"),
                        resultSet.getInt("precio"),
                        resultSet.getInt("stock"),
                        resultSet.getInt("vendidos")
                );
                productos.add(producto);
            }
        } catch (SQLException e) {

            // Manejo de excepciones
        }

        return productos;

    }

    @Override
    public Producto getById(int idProducto) {
        Producto producto = null;
        try (Connection connection = DBConnection.getConnection()) {
            String sql = "SELECT * FROM productos WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, idProducto);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                producto = new Producto(
                        resultSet.getString("id"),
                        resultSet.getString("marca"),
                        resultSet.getString("nombre"),
                        resultSet.getInt("precio"),
                        resultSet.getInt("stock"),
                        resultSet.getInt("vendidos")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de excepciones
        }

        return producto;

    }

}
