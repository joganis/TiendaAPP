/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views;

/**
 *
 * @author Jobany
 */
public class CategoriaVista extends javax.swing.JPanel {

    /**
     * Creates new form CategoriaVista
     */
    public CategoriaVista() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jblIdCategoria = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtIdCategoria = new javax.swing.JTextField();
        txtNombreCategoria = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCategoria = new javax.swing.JTable();
        btnCrearCategoria = new javax.swing.JButton();
        btnMostrarCategoria = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminarCategoria = new javax.swing.JButton();

        jblIdCategoria.setText("Id Cateoria");

        jLabel2.setText(" nombre Categoria");

        tablaCategoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre categoria"
            }
        ));
        jScrollPane1.setViewportView(tablaCategoria);

        btnCrearCategoria.setText("Crear");

        btnMostrarCategoria.setText("Mostrar");
        btnMostrarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarCategoriaActionPerformed(evt);
            }
        });

        btnActualizar.setText("Actulizar");

        btnEliminarCategoria.setText("Eliminar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                    .addComponent(jblIdCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtIdCategoria)
                    .addComponent(txtNombreCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(174, 174, 174)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMostrarCategoria)
                    .addComponent(btnCrearCategoria)
                    .addComponent(btnActualizar)
                    .addComponent(btnEliminarCategoria))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 144, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(117, 117, 117))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jblIdCategoria)
                    .addComponent(txtIdCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombreCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 159, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnCrearCategoria)
                        .addGap(31, 31, 31)
                        .addComponent(btnMostrarCategoria)
                        .addGap(30, 30, 30)
                        .addComponent(btnActualizar)
                        .addGap(33, 33, 33)
                        .addComponent(btnEliminarCategoria))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(142, 142, 142))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnMostrarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMostrarCategoriaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnActualizar;
    public javax.swing.JButton btnCrearCategoria;
    public javax.swing.JButton btnEliminarCategoria;
    public javax.swing.JButton btnMostrarCategoria;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel jblIdCategoria;
    public javax.swing.JTable tablaCategoria;
    public javax.swing.JTextField txtIdCategoria;
    public javax.swing.JTextField txtNombreCategoria;
    // End of variables declaration//GEN-END:variables
}