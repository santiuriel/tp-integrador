/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import modelo.Producto;

/**
 *
 * @author estudiante
 */
public interface ProductoDAO {
    void save (Producto producto);
    
    void update(Producto producto);
    
    void delete(int idProducto);
    
    List<Producto> getAll();
    
    Producto getById(int idProducto);
    
}
