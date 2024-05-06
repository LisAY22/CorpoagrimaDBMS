/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package corpoagrima.corpoagrima.gui.regcompra;

import corpoagrima.corpoagrima.bdMariaDB.ConexionCompra;
import corpoagrima.corpoagrima.gui.Principal;
import corpoagrima.corpoagrima.gui.inventario.Inventario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author alfaryus
 */
public class Compra extends javax.swing.JFrame {
    private Connection conexion;
    private ResultSet credenciales;
    private ConexionCompra compras;
    private TableRowSorter<DefaultTableModel> sorter;
    /**
     * Creates new form Compra
     */
    public Compra(Connection conexion, ResultSet credenciales) {
        this.conexion = conexion;
        this.credenciales = credenciales;
        compras = new ConexionCompra();
        initComponents();
        actualizarTabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Regresar_Bn = new javax.swing.JButton();
        Refresh_button = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        NuevoPuesto_jbutton = new javax.swing.JButton();
        Ordenar_Bn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        EditarPuesto_jbutton = new javax.swing.JButton();
        Anular_jbutton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(34, 85, 34));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("REGISTRO DE COMPRA");

        Regresar_Bn.setBackground(new java.awt.Color(34, 85, 34));
        Regresar_Bn.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Regresar_Bn.setForeground(new java.awt.Color(255, 255, 255));
        Regresar_Bn.setText("←");
        Regresar_Bn.setBorderPainted(false);
        Regresar_Bn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Regresar_BnActionPerformed(evt);
            }
        });

        Refresh_button.setBackground(new java.awt.Color(34, 85, 34));
        Refresh_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/actualizar.png"))); // NOI18N
        Refresh_button.setBorderPainted(false);
        Refresh_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Refresh_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(Regresar_Bn, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(132, 132, 132)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Refresh_button, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Refresh_button, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Regresar_Bn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        NuevoPuesto_jbutton.setBackground(new java.awt.Color(136, 213, 133));
        NuevoPuesto_jbutton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        NuevoPuesto_jbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nuevo.png"))); // NOI18N
        NuevoPuesto_jbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NuevoPuesto_jbuttonActionPerformed(evt);
            }
        });

        Ordenar_Bn.setBackground(new java.awt.Color(136, 213, 133));
        Ordenar_Bn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ordenar.png"))); // NOI18N
        Ordenar_Bn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Ordenar_BnActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "No.Factura", "Empresa", "Fecha Compra", "Tipo compra", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        EditarPuesto_jbutton.setBackground(new java.awt.Color(136, 213, 133));
        EditarPuesto_jbutton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        EditarPuesto_jbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editar.png"))); // NOI18N
        EditarPuesto_jbutton.setToolTipText("");
        EditarPuesto_jbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarPuesto_jbuttonActionPerformed(evt);
            }
        });

        Anular_jbutton.setBackground(new java.awt.Color(255, 0, 0));
        Anular_jbutton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Anular_jbutton.setForeground(new java.awt.Color(255, 255, 255));
        Anular_jbutton.setText("ANULAR");
        Anular_jbutton.setEnabled(true);
        Anular_jbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Anular_jbuttonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("EDITAR");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("NUEVO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 688, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(Anular_jbutton)
                                .addGap(40, 40, 40))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(EditarPuesto_jbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(NuevoPuesto_jbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2)))
                                .addGap(51, 51, 51))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Ordenar_Bn, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(4, 4, 4)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 644, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(164, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Ordenar_Bn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EditarPuesto_jbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NuevoPuesto_jbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(Anular_jbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(71, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void actualizarTabla() {
        try {
            ResultSet rs = compras.consulta(conexion);

            // Obtener el modelo de la tabla actual
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0); // Limpiar los datos existentes

            // Agregar nuevas filas al modelo de tabla
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            
            while (rs.next()) {
                Object[] rowData = new Object[columnCount];
                for (int i = 0; i < columnCount; i++) {
                    rowData[i] = rs.getObject(i + 1);
                }
                model.addRow(rowData);
            }

            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar los datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void EditarPuesto_jbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarPuesto_jbuttonActionPerformed
        EditarRegFactura EditarWindow = new EditarRegFactura(conexion, credenciales);
        EditarWindow.setVisible(true);
        dispose();
    }//GEN-LAST:event_EditarPuesto_jbuttonActionPerformed

    private void NuevoPuesto_jbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevoPuesto_jbuttonActionPerformed
        NuevoRegFactura NuevoWindow = new NuevoRegFactura(conexion, credenciales);
        NuevoWindow.setVisible(true);
        dispose();
    }//GEN-LAST:event_NuevoPuesto_jbuttonActionPerformed

    private void Anular_jbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Anular_jbuttonActionPerformed
        // Obtener la fila seleccionada
        int selectedRow = jTable1.getSelectedRow();

        // Verificar si se ha seleccionado una fila
        if(selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione una fila para anular.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Salir del método si no hay fila seleccionada
        }

        // Obtener el número de factura de la fila seleccionada
        Object facturaObject = jTable1.getValueAt(selectedRow, 1); // Se asume que el número de factura está en la segunda columna (índice 1)
        if(facturaObject == null) {
            JOptionPane.showMessageDialog(this, "No se puede obtener el número de factura.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Salir del método si el número de factura es nulo
        }

        // Convertir el objeto a un String (el número de factura)
        String numeroFactura = facturaObject.toString();

        // Ahora puedes usar el número de factura como desees, por ejemplo, pasarlo a la ventana de anulación
        AnularRegFactura AnularWindow = new AnularRegFactura(conexion, credenciales, numeroFactura);
        AnularWindow.setVisible(true);
        dispose();
    }//GEN-LAST:event_Anular_jbuttonActionPerformed

    private void Regresar_BnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Regresar_BnActionPerformed
        // TODO add your handling code here:
        Principal principal_screen = null;
        try {
            principal_screen = new Principal(conexion, credenciales);
        } catch (SQLException ex) {
            Logger.getLogger(Inventario.class.getName()).log(Level.SEVERE, null, ex);
        }
        principal_screen.setVisible(true);
        principal_screen.setLocationRelativeTo(null);
        
        // Cerrar la ventana actual
        dispose();
    }//GEN-LAST:event_Regresar_BnActionPerformed

    private void Refresh_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Refresh_buttonActionPerformed
        // TODO add your handling code here:
        actualizarTabla();
    }//GEN-LAST:event_Refresh_buttonActionPerformed

    private void Ordenar_BnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Ordenar_BnActionPerformed
        // TODO add your handling code here:
        if (sorter == null) {
            // Crear un objeto TableRowSorter basado en el modelo de la tabla
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            sorter = new TableRowSorter<>(model);
            jTable1.setRowSorter(sorter);
        }

        // Crear un RowSorter para ordenar por la columna "Nombre"
        ArrayList<RowSorter.SortKey> sortKeys = new ArrayList<>();
        int columnIndexToSort = 1;
        sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.ASCENDING)); // Orden ascendente
        sorter.setSortKeys(sortKeys);

        // Ordenar la tabla
        sorter.sort();

        // Mostrar un mensaje indicando que la tabla ha sido ordenada
        JOptionPane.showMessageDialog(this, "El ordenamiento de la tabla ha sido habilitado.", "Ordenar tabla", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_Ordenar_BnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Anular_jbutton;
    private javax.swing.JButton EditarPuesto_jbutton;
    private javax.swing.JButton NuevoPuesto_jbutton;
    private javax.swing.JButton Ordenar_Bn;
    private javax.swing.JButton Refresh_button;
    private javax.swing.JButton Regresar_Bn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
