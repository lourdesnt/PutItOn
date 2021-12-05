package clases;

import java.io.Serializable;

public class Producto implements Serializable {
    private int referencia;
    private int imagen;
    private String nombre;
    private String talla;
    private double precio;
    private int cantidad;

    public Producto(){

    }

    public Producto(int referencia, int imagen, String nombre, double precio) {
        this.referencia = referencia;
        this.imagen = imagen;
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getReferencia() {
        return referencia;
    }

    public void setReferencia(int referencia) {
        this.referencia = referencia;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}
