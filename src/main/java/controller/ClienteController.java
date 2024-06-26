package controller;

import com.dao.ClienteDAO;
import model.Cliente;
import views.ClienteVista;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ClienteController {

    private ClienteVista view;
    private ClienteDAO dao;

    public ClienteController(ClienteVista view, ClienteDAO dao) {
        this.view = view;
        this.dao = dao;
        
        this.view.btnCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crearCliente();
            }
        });

        this.view.btnMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarClientes();
            }
        });

        this.view.btnaActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (view.jTextField1.getText().isEmpty()
                        || view.jTextField2.getText().isEmpty()
                        || view.jTextField3.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(view, "Por favor, seleccione un cliente de la tabla para actualizar.");
                } else {
                    actualizarCliente();
                }
            }
        });

        this.view.btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (view.jTextField1.getText().isEmpty()
                        || view.jTextField2.getText().isEmpty()
                        || view.jTextField3.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(view, "Por favor, seleccione un cliente de la tabla para eliminar.");
                } else {
                    int response = JOptionPane.showConfirmDialog(
                            view,
                            "¿Está seguro de que desea eliminar este cliente?",
                            "Confirmar eliminación",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE
                    );
                    if (response == JOptionPane.YES_OPTION) {
                        eliminarCliente();
                    }
                }
            }
        });

        this.view.tablaClientes.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting() && view.tablaClientes.getSelectedRow() != -1) {
                    mostrarDatosSeleccionados();
                }
            }
        });
    }

    private void crearCliente() {
        String nombre = view.jTextField2.getText();
        String telefono = view.jTextField3.getText();
        Cliente cliente = new Cliente(nombre, telefono);
        boolean existe = dao.existeCliente(cliente);

        if (!existe) {
            dao.crearCliente(cliente, false);
            JOptionPane.showMessageDialog(view, "Cliente creado exitosamente.");
            limpiarCampos();
            mostrarClientes();
        } else {
            JOptionPane.showMessageDialog(view, "El cliente ya existe.");
        }
    }

    private void mostrarClientes() {
        List<Cliente> listaClientes = dao.leerCliente();
        DefaultTableModel model = (DefaultTableModel) view.tablaClientes.getModel();
        model.setRowCount(0);

        for (Cliente cliente : listaClientes) {
            model.addRow(new Object[]{cliente.getId(), cliente.getNombre(), cliente.getTelefono()});
        }
    }

    private void actualizarCliente() {
        int id = Integer.parseInt(view.jTextField1.getText());
        String nombre = view.jTextField2.getText();
        String telefono = view.jTextField3.getText();

        Cliente cliente = new Cliente(id, nombre, telefono);
        dao.actualizarClinete(cliente);

        JOptionPane.showMessageDialog(view, "Cliente actualizado exitosamente.");
        limpiarCampos();
        mostrarClientes();
    }

    private void eliminarCliente() {
        int id = Integer.parseInt(view.jTextField1.getText());
        dao.eliminarCliente(id);

        JOptionPane.showMessageDialog(view, "Cliente eliminado exitosamente.");
        limpiarCampos();
        mostrarClientes();
    }

    private void limpiarCampos() {
        view.jTextField1.setText("");
        view.jTextField2.setText("");
        view.jTextField3.setText("");
    }

    private void mostrarDatosSeleccionados() {
        int row = view.tablaClientes.getSelectedRow();
        view.jTextField1.setText(view.tablaClientes.getValueAt(row, 0).toString());
        view.jTextField2.setText(view.tablaClientes.getValueAt(row, 1).toString());
        view.jTextField3.setText(view.tablaClientes.getValueAt(row, 2).toString());
    }
}
