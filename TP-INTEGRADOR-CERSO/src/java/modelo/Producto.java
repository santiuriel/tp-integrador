/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author estudiante
 */
public class Producto {
    private String id;
    private String marca;
    private String nombre;
    private int precio;
    private int stock;
    private int vendidos;

    public Producto() {
    }

    
//    public Producto(int id, String marca, String nombre, int precio, int stock, int vendidos) {
//        this.id = id;
//        this.marca = marca;
//        this.nombre = nombre;
//        this.precio = precio;
//        this.stock = stock;
//        this.vendidos = vendidos;
//    }
//
//    public Producto(String id, String marca, String nombre, String precio, String stock, String vendidos) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }

    public Producto(String id, String marca, String nombre, int precio, int stock, int vendidos) {
        this.id = id;
        this.marca = marca;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.vendidos = vendidos;
    }
    
    
    
    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getVendidos() {
        return vendidos;
    }

    public void setVendidos(int vendidos) {
        this.vendidos = vendidos;
    }

    public void add(Producto producto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
