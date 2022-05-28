/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

/**
 *
 * @author eroda
 */
public class Clientes {
    String Cliente;
    String Numero;
    String Comentario; 
    String Forma_Pago;
    String Producto;
    public Clientes(){
        
    }

    public Clientes(String Cliente, String Numero, String Comentario, String Forma_Pago, String Producto) {
        this.Cliente = Cliente;
        this.Numero = Numero;
        this.Comentario = Comentario;
        this.Forma_Pago = Forma_Pago;
        this.Producto = Producto;
    }

    public String getCliente() {
        return Cliente;
    }

    public void setCliente(String Cliente) {
        this.Cliente = Cliente;
    }

    public String getNumero() {
        return Numero;
    }

    public void setNumero(String Numero) {
        this.Numero = Numero;
    }

    public String getComentario() {
        return Comentario;
    }

    public void setComentario(String Comentario) {
        this.Comentario = Comentario;
    }

    public String getForma_Pago() {
        return Forma_Pago;
    }

    public void setForma_Pago(String Forma_Pago) {
        this.Forma_Pago = Forma_Pago;
    }

    public String getProducto() {
        return Producto;
    }

    public void setProducto(String Producto) {
        this.Producto = Producto;
    }
    
    
}

