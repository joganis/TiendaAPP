
package controller;

import com.dao.ProductoDAO;
import model.Producto;
import views.ProductoVista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ProductoController {
    private ProductoDAO productoDAO;
    private ProductoVista productoVista;

    public ProductoController(ProductoDAO productoDAO, ProductoVista productoVista) {
        this.productoDAO = productoDAO;
        this.productoVista = productoVista;

        // Agregar listeners a los botones
        this.productoVista.btnCrearProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crearProducto();
            }
        });
        
        this.productoVista.btnMotrarProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarProductos();
            }
        });

        this.productoVista.btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarProducto();
            }
        });

        this.productoVista.btnEliminarProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarProducto();
            }
        });
    }

    private void crearProducto() {
        String nombre = productoVista.txtNombreProducto.getText();
        double precio = Double.parseDouble(productoVista.txtPrecioProducto.getText());
        int categoriaId = Integer.parseInt(productoVista.txtCategoriaProducto.getText());

        Producto producto = new Producto(nombre, precio, categoriaId);
        productoDAO.crearProducto(producto);
        JOptionPane.showMessageDialog(null, "Producto creado con éxito");
        limpiarCampos();
    }

    private void mostrarProductos() {
        List<Producto> productos = productoDAO.leerProductos();
        DefaultTableModel model = (DefaultTableModel) productoVista.TablaProductos.getModel();
        model.setRowCount(0); // Limpiar tabla

        for (Producto producto : productos) {
            Object[] row = new Object[4];
            row[0] = producto.getId();
            row[1] = producto.getNombre();
            row[2] = producto.getPrecio();
            row[3] = producto.getCategoriaId();
            model.addRow(row);
        }
    }

    private void actualizarProducto() {
        int id = Integer.parseInt(productoVista.txtIdProducto.getText());
        String nombre = productoVista.txtNombreProducto.getText();
        double precio = Double.parseDouble(productoVista.txtPrecioProducto.getText());
        int categoriaId = Integer.parseInt(productoVista.txtCategoriaProducto.getText());

        Producto producto = new Producto(id, nombre, precio, categoriaId);
        productoDAO.actualizarProducto(producto);
        JOptionPane.showMessageDialog(null, "Producto actualizado con éxito");
        limpiarCampos();
    }

    private void eliminarProducto() {
        int id = Integer.parseInt(productoVista.txtIdProducto.getText());
        productoDAO.eliminarProducto(id);
        JOptionPane.showMessageDialog(null, "Producto eliminado con éxito");
        limpiarCampos();
    }

    private void limpiarCampos() {
        productoVista.txtIdProducto.setText("");
        productoVista.txtNombreProducto.setText("");
        productoVista.txtPrecioProducto.setText("");
        productoVista.txtCategoriaProducto.setText("");
    }
}