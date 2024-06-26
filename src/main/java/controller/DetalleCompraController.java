package controller;

import com.dao.DetalleCompraDAO;
import model.DetalleCompra;
import views.DetalleCompraView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class DetalleCompraController {
    private DetalleCompraDAO detalleCompraDAO;
    private DetalleCompraView detalleCompraView;

    public DetalleCompraController(DetalleCompraDAO detalleCompraDAO, DetalleCompraView detalleCompraView) {
        this.detalleCompraDAO = detalleCompraDAO;
        this.detalleCompraView = detalleCompraView;
        
       
       
    }

   

    private void crearDetalleCompra() {
        int idCompra = Integer.parseInt(detalleCompraView.txtIdCompra.getText());
        int idProducto = Integer.parseInt(detalleCompraView.txtidProducto.getText());
        int cantidad = Integer.parseInt(detalleCompraView.txtCantidad.getText());

        DetalleCompra detalleCompra = new DetalleCompra(0, idCompra, idProducto, cantidad);
        detalleCompraDAO.crearDetalleCompra(detalleCompra);
        mostrarDetalleCompras();
    }

    private void mostrarDetalleCompras() {
        List<DetalleCompra> detalleCompras = detalleCompraDAO.leerDetalleCompras();
        DefaultTableModel model = (DefaultTableModel) detalleCompraView.jTable1.getModel();
        model.setRowCount(0);
        for (DetalleCompra detalleCompra : detalleCompras) {
            model.addRow(new Object[]{detalleCompra.getId(), detalleCompra.getIdCompra(), detalleCompra.getIdProducto(), detalleCompra.getCantidad()});
        }
    }

    private void actualizarDetalleCompra() {
        int id = Integer.parseInt(detalleCompraView.txtIdDetalle.getText());
        int idCompra = Integer.parseInt(detalleCompraView.txtIdCompra.getText());
        int idProducto = Integer.parseInt(detalleCompraView.txtidProducto.getText());
        int cantidad = Integer.parseInt(detalleCompraView.txtCantidad.getText());

        DetalleCompra detalleCompra = new DetalleCompra(id, idCompra, idProducto, cantidad);
        detalleCompraDAO.actualizarDetalleCompra(detalleCompra);
        mostrarDetalleCompras();
    }

    private void eliminarDetalleCompra() {
        int id = Integer.parseInt(detalleCompraView.txtIdDetalle.getText());
        detalleCompraDAO.eliminarDetalleCompra(id);
        mostrarDetalleCompras();
    }
}