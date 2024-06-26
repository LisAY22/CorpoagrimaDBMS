/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package corpoagrima.corpoagrima.gui.regventa;
import corpoagrima.corpoagrima.gui.Principal;
import corpoagrima.corpoagrima.bdMariaDB.ConexionVenta;
import corpoagrima.corpoagrima.gui.regcompra.Compra;
import corpoagrima.corpoagrima.gui.regcompra.EditarRegFactura;
import corpoagrima.corpoagrima.gui.regcompra.NuevoRegFactura;
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
 * @author melis
 */
public final class Venta extends javax.swing.JFrame {

    private final Connection conexion;
    private final ResultSet credenciales;
    private final ConexionVenta Venta;
    private TableRowSorter<DefaultTableModel> sorter;
    
    /**
     * @param conexion
     * @param credenciales
     */
    public Venta(Connection conexion, ResultSet credenciales) {
        this.conexion = conexion;
        this.credenciales = credenciales;
        this.Venta = new ConexionVenta();
        initComponents();
        UpdateTableModel();
    }
    
    
    public void UpdateTableModel(){
        try {
            try (ResultSet Ventas_Result_Set = Venta.consulta(conexion)) {
                DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
                model.setRowCount(0); // Limpiar los datos existentes
                
                ResultSetMetaData metaData = Ventas_Result_Set.getMetaData();
                int columnCount = metaData.getColumnCount();
                
                while (Ventas_Result_Set.next()) {
                    Object[] rowData = new Object[columnCount];
                    for (int i = 0; i < columnCount; i++) {
                        rowData[i] = Ventas_Result_Set.getObject(i + 1);
                    }
                    model.addRow(rowData);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar los datos de ventas: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBox1 = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Regresar_Bn = new javax.swing.JButton();
        Refresh_button = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        Ordenar_Bn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        Nuevo_jbutton = new javax.swing.JButton();
        Anular_jbutton = new javax.swing.JButton();
        Editar_jbutton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        Visualizar_jbutton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        jCheckBox1.setText("jCheckBox1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(34, 85, 34));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("REGISTRO DE VENTA");

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
                .addGap(201, 201, 201)
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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(Refresh_button, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Regresar_Bn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        Ordenar_Bn.setBackground(new java.awt.Color(136, 213, 133));
        Ordenar_Bn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ordenar.png"))); // NOI18N
        Ordenar_Bn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Ordenar_BnActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "No.Factura", "Nombre", "Apellido", "Tipo Venta", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);

        Nuevo_jbutton.setBackground(new java.awt.Color(136, 213, 133));
        Nuevo_jbutton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Nuevo_jbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nuevo.png"))); // NOI18N
        Nuevo_jbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Nuevo_jbuttonActionPerformed(evt);
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

        Editar_jbutton1.setBackground(new java.awt.Color(136, 213, 133));
        Editar_jbutton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Editar_jbutton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editar.png"))); // NOI18N
        Editar_jbutton1.setToolTipText("");
        Editar_jbutton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Editar_jbutton1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("EDITAR");

        Visualizar_jbutton.setBackground(new java.awt.Color(136, 213, 133));
        Visualizar_jbutton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Visualizar_jbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ojo.png"))); // NOI18N
        Visualizar_jbutton.setEnabled(true);
        Visualizar_jbutton.setPreferredSize(new java.awt.Dimension(30, 31));
        Visualizar_jbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Visualizar_jbuttonActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("VISUALIZAR");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("NUEVO");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Ordenar_Bn, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 644, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(Visualizar_jbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Anular_jbutton)
                                    .addComponent(jLabel6)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(Nuevo_jbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Editar_jbutton1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4)))))))
                .addGap(0, 43, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(Ordenar_Bn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Editar_jbutton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Nuevo_jbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Visualizar_jbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(Anular_jbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Regresar_BnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Regresar_BnActionPerformed
        // TODO add your handling code here:
        Principal principal_screen = null;   
        try {
            principal_screen = new Principal(conexion, credenciales);
        } catch (SQLException ex) {
            Logger.getLogger(Venta.class.getName()).log(Level.SEVERE, null, ex);
        }
        principal_screen.setVisible(true);
        principal_screen.setLocationRelativeTo(null);

        // Cerrar la ventana actual
        dispose();
    }//GEN-LAST:event_Regresar_BnActionPerformed

    private void Refresh_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Refresh_buttonActionPerformed
        UpdateTableModel();
    }//GEN-LAST:event_Refresh_buttonActionPerformed

    private void NuevoPuesto_jbutton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevoPuesto_jbutton1ActionPerformed
        
    }//GEN-LAST:event_NuevoPuesto_jbutton1ActionPerformed

    private void Nuevo_jbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Nuevo_jbuttonActionPerformed
        NuevoRegVenta NuevaVentana = null;
        try {
            NuevaVentana = new NuevoRegVenta(conexion, credenciales);
        } catch (SQLException ex) {
            Logger.getLogger(Venta.class.getName()).log(Level.SEVERE, null, ex);
        }
        NuevaVentana.setVisible(true);
        dispose();
    }//GEN-LAST:event_Nuevo_jbuttonActionPerformed

    private void Ordenar_BnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Ordenar_BnActionPerformed
        // TODO add your handling code here:
        if (sorter == null) {
            // Crear un objeto TableRowSorter basado en el modelo de la tabla
            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
            sorter = new TableRowSorter<>(model);
            jTable2.setRowSorter(sorter);
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

    private void Editar_jbutton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Editar_jbutton1ActionPerformed
        int selectedRow = jTable2.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione una factura para editar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Obtener el número de factura de la fila seleccionada
        Object facturaObject = jTable2.getValueAt(selectedRow, 1); 
        if (facturaObject == null) {
            JOptionPane.showMessageDialog(this, "No se puede obtener el número de factura.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Salir del método si el número de factura es nulo
        }

        // Convertir el objeto a un String (el número de factura)
        String numeroFactura = facturaObject.toString();

        
        try {
            EditarRegVenta EditarWindow = new EditarRegVenta(conexion, credenciales, numeroFactura);
            EditarWindow.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Compra.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose(); 
    }//GEN-LAST:event_Editar_jbutton1ActionPerformed

    private void Visualizar_jbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Visualizar_jbuttonActionPerformed
        int selectedRow = jTable2.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione una factura para visualizar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Obtener el número de factura de la fila seleccionada
        Object facturaObject = jTable2.getValueAt(selectedRow, 1); 
        if (facturaObject == null) {
            JOptionPane.showMessageDialog(this, "No se puede obtener el número de factura.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Salir del método si el número de factura es nulo
        }

        // Convertir el objeto a un String (el número de factura)
        String numeroFactura = facturaObject.toString();

        
        VisualizarRegVenta VisualizarWindow = null;
        try {
            VisualizarWindow = new VisualizarRegVenta(conexion, credenciales, numeroFactura);
        } catch (SQLException ex) {
            Logger.getLogger(Venta.class.getName()).log(Level.SEVERE, null, ex);
        }
        VisualizarWindow.setVisible(true);
        dispose(); 
    }//GEN-LAST:event_Visualizar_jbuttonActionPerformed

    private void Anular_jbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Anular_jbuttonActionPerformed
        int selectedRow = jTable2.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione una factura para anular.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Obtener el número de factura de la fila seleccionada
        Object facturaObject = jTable2.getValueAt(selectedRow, 1); 
        if (facturaObject == null) {
            JOptionPane.showMessageDialog(this, "No se puede obtener el número de factura.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Salir del método si el número de factura es nulo
        }

        // Convertir el objeto a un String (el número de factura)
        String numeroFactura = facturaObject.toString();

        
        AnularRegVenta AnularWindow = null;
        try {
            AnularWindow = new AnularRegVenta(conexion, credenciales, numeroFactura);
        } catch (SQLException ex) {
            Logger.getLogger(Venta.class.getName()).log(Level.SEVERE, null, ex);
        }
        AnularWindow.setVisible(true);
        dispose(); 
    }//GEN-LAST:event_Anular_jbuttonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Anular_jbutton;
    private javax.swing.JButton Editar_jbutton1;
    private javax.swing.JButton Nuevo_jbutton;
    private javax.swing.JButton Ordenar_Bn;
    private javax.swing.JButton Refresh_button;
    private javax.swing.JButton Regresar_Bn;
    private javax.swing.JButton Visualizar_jbutton;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
