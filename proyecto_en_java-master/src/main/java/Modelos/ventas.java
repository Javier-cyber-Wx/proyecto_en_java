/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

/**
 *
 * @author bayro
 */
public class ventas {
    int Codigo;
    String producto;
    String UOM;
    int Cantidad;
    double precio;
    public ventas(){
      
    } 

    public ventas(int Codigo, String producto, String UOM, int Cantidad, double precio) {
        this.Codigo = Codigo;
        this.producto = producto;
        this.UOM = UOM;
        this.Cantidad = Cantidad;
        this.precio = precio;
    }
    
    

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getUOM() {
        return UOM;
    }

    public void setUOM(String UOM) {
        this.UOM = UOM;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
}

