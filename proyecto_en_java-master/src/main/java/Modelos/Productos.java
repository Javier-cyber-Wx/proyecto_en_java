package Modelos;

public class Productos {
    private int codigo;
    private String producto;
    private double precio;
    private int cantidad_disponible;
    private String uom;
    
    public Productos()
    {
        
    }

    public Productos(int codigo, String producto, double precio, int cantidad_disponible, String uom) {
        this.codigo = codigo;
        this.producto = producto;
        this.precio = precio;
        this.cantidad_disponible = cantidad_disponible;
        this.uom = uom;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad_disponible() {
        return cantidad_disponible;
    }

    public void setCantidad_disponible(int cantidad_disponible) {
        this.cantidad_disponible = cantidad_disponible;
    }

    public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }
    
}
