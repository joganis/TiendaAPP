package model;

import java.sql.Date;

/**
 *
 * @author USUARIO
 */
public class DetalleCompra {
   private int id;
   private int IdCompra;
   private int IdProducto;
   private int cantidad;

    public DetalleCompra(int id, int IdCompra, int IdProducto, int cantidad) {
        this.id = id;
        this.IdCompra = IdCompra;
        this.IdProducto = IdProducto;
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCompra() {
        return IdCompra;
    }

    public void setIdCompra(int IdCompra) {
        this.IdCompra = IdCompra;
    }

    public int getIdProducto() {
        return IdProducto;
    }

    public void setIdProducto(int IdProducto) {
        this.IdProducto = IdProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
   
   

}