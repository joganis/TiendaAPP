
package controller;

import com.dao.CategoriaDAO;
import model.Categoria;
import views.CategoriaVista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class CategoriaController {

    private CategoriaVista view;
    private CategoriaDAO dao;

    public CategoriaController(CategoriaVista view, CategoriaDAO dao) {
        this.view = view;
        this.dao = dao;

        // Configurar listeners de los botones en la vista
        this.view.btnCrearCategoria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crearCategoria();
            }
        });

        this.view.btnMostrarCategoria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarCategorias();
            }
        });

        this.view.btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (view.txtIdCategoria.getText().isEmpty() || view.txtNombreCategoria.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(view, "Por favor, seleccione una categoría de la tabla para actualizar.");
                } else {
                    actualizarCategoria();
                }
            }
        });

        this.view.btnEliminarCategoria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (view.txtIdCategoria.getText().isEmpty() || view.txtNombreCategoria.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(view, "Por favor, seleccione una categoría de la tabla para eliminar.");
                } else {
                    int response = JOptionPane.showConfirmDialog(
                            view,
                            "¿Está seguro de que desea eliminar esta categoría?",
                            "Confirmar eliminación",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE
                    );
                    if (response == JOptionPane.YES_OPTION) {
                        eliminarCategoria();
                    }
                }
            }
        });

        this.view.tablaCategoria.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting() && view.tablaCategoria.getSelectedRow() != -1) {
                    mostrarDatosSeleccionados();
                }
            }
        });

        // Mostrar las categorías al inicio
        mostrarCategorias();
    }

    private void crearCategoria() {
        String nombre = view.txtNombreCategoria.getText().trim();
        Categoria categoria = new Categoria(0, nombre); // El ID se asignará automáticamente en la BD

        dao.crearCategoria(categoria);
        JOptionPane.showMessageDialog(view, "Categoría creada exitosamente.");
        limpiarCampos();
        mostrarCategorias(); // Actualizar tabla después de crear
    }

    private void mostrarCategorias() {
        List<Categoria> categorias = dao.leerCategorias();
        DefaultTableModel model = (DefaultTableModel) view.tablaCategoria.getModel();
        model.setRowCount(0);

        for (Categoria categoria : categorias) {
            model.addRow(new Object[]{categoria.getId(), categoria.getNombre()});
        }
    }

    private void actualizarCategoria() {
        int id = Integer.parseInt(view.txtIdCategoria.getText().trim());
        String nombre = view.txtNombreCategoria.getText().trim();
        Categoria categoria = new Categoria(id, nombre);

        dao.actualizarCategoria(categoria);
        JOptionPane.showMessageDialog(view, "Categoría actualizada exitosamente.");
        limpiarCampos();
        mostrarCategorias(); // Actualizar tabla después de actualizar
    }

    private void eliminarCategoria() {
        int id = Integer.parseInt(view.txtIdCategoria.getText().trim());
        dao.eliminarCategoria(id);
        JOptionPane.showMessageDialog(view, "Categoría eliminada exitosamente.");
        limpiarCampos();
        mostrarCategorias(); // Actualizar tabla después de eliminar
    }

    private void limpiarCampos() {
        view.txtIdCategoria.setText("");
        view.txtNombreCategoria.setText("");
    }

    private void mostrarDatosSeleccionados() {
        int row = view.tablaCategoria.getSelectedRow();
        view.txtIdCategoria.setText(view.tablaCategoria.getValueAt(row, 0).toString());
        view.txtNombreCategoria.setText(view.tablaCategoria.getValueAt(row, 1).toString());
    }
}