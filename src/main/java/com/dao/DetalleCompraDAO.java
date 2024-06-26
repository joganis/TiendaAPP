package com.dao;

import config.ConexionBD;
import model.DetalleCompra;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DetalleCompraDAO {
    private Connection conexion;
    private ConexionBD conexionBD;

    public DetalleCompraDAO() {
        conexionBD = new ConexionBD();
        conexion = conexionBD.getConexion();
    }

    public void crearDetalleCompra(DetalleCompra detalleCompra) {
        String sql =  "INSERT INTO detalle_compra (id_compra, id_producto, cantidad) VALUES (?, ?, ?)";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setInt(1, detalleCompra.getIdCompra());
            statement.setInt(2, detalleCompra.getIdProducto());
            statement.setInt(3, detalleCompra.getCantidad());
            statement.executeUpdate();
            System.out.println("Detalle de compra insertado con éxito.");
        } catch (SQLException e) {
            System.out.println("Error al guardar los datos: " + e.getMessage());
        }
    }
    
    public List<DetalleCompra> leerDetalleCompras() {
        List<DetalleCompra> detalleCompras = new ArrayList<>();
        String sql = "SELECT * FROM detalle_compra";
        try (Statement statement = conexion.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int idCompra = resultSet.getInt("id_compra");
                int idProducto = resultSet.getInt("id_producto");
                int cantidad = resultSet.getInt("cantidad");
                DetalleCompra detalleCompra = new DetalleCompra(id, idCompra, idProducto, cantidad);
                detalleCompras.add(detalleCompra);
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar los datos: " + e.getMessage());
        }
        return detalleCompras;
    }

    public void actualizarDetalleCompra(DetalleCompra detalleCompra) {
        String sql = "UPDATE detalle_compra SET id_compra = ?, id_producto = ?, cantidad = ? WHERE id = ?";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setInt(1, detalleCompra.getIdCompra());
            statement.setInt(2, detalleCompra.getIdProducto());
            statement.setInt(3, detalleCompra.getCantidad());
            statement.setInt(4, detalleCompra.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al actualizar los datos: " + e.getMessage());
        }
    }

    public void eliminarDetalleCompra(int id) {
        String sql = "DELETE FROM detalle_compra WHERE id = ?";
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al eliminar los datos: " + e.getMessage());
        }
    }

    public void cerrarConexion() {
        conexionBD.closeConexion(conexion);
    }
}