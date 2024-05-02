/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package corpoagrima.corpoagrima.gui.inventario;

import corpoagrima.corpoagrima.bdMariaDB.ConexionProducto;
import corpoagrima.corpoagrima.gui.Principal;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;




/**
 *
 * @author lisaj
 */
public class Inventario extends javax.swing.JFrame {

    /**
     * Creates new form inventario
     */    
    
    private Connection conexion;
    private ResultSet credenciales;
    private ConexionProducto inventario;
    private TableRowSorter<DefaultTableModel> sorter; // Variable miembro para mantener el TableRowSorter
    
    
    public Inventario(Connection conexion, ResultSet credenciales) {
        this.conexion = conexion;
        this.credenciales = credenciales;
        inventario = new ConexionProducto();
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

        JPanel1 = new javax.swing.JPanel();
        inventarioJLabel = new javax.swing.JLabel();
        regresarJButton = new javax.swing.JButton();
        Actualizar_Bn = new javax.swing.JButton();
        JPanel2 = new javax.swing.JPanel();
        buscarJTextField = new javax.swing.JTextField();
        ordenarJButton = new javax.swing.JButton();
        buscarJButton = new javax.swing.JButton();
        JPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        datosJTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        nuevojButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inventario");

        JPanel1.setBackground(new java.awt.Color(34, 85, 34));
        JPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JPanel1MouseClicked(evt);
            }
        });

        inventarioJLabel.setBackground(new java.awt.Color(34, 85, 34));
        inventarioJLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        inventarioJLabel.setForeground(new java.awt.Color(252, 252, 252));
        inventarioJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inventarioJLabel.setText("INVENTARIO");
        inventarioJLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        regresarJButton.setBackground(new java.awt.Color(34, 85, 34));
        regresarJButton.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        regresarJButton.setForeground(new java.awt.Color(255, 255, 255));
        regresarJButton.setText("←");
        regresarJButton.setBorderPainted(false);
        regresarJButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                regresarJButtonMouseClicked(evt);
            }
        });

        Actualizar_Bn.setBackground(new java.awt.Color(34, 85, 34));
        Actualizar_Bn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/actualizar.png"))); // NOI18N
        Actualizar_Bn.setBorderPainted(false);
        Actualizar_Bn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Actualizar_BnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout JPanel1Layout = new javax.swing.GroupLayout(JPanel1);
        JPanel1.setLayout(JPanel1Layout);
        JPanel1Layout.setHorizontalGroup(
            JPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(regresarJButton)
                .addGap(157, 157, 157)
                .addComponent(inventarioJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(151, 151, 151)
                .addComponent(Actualizar_Bn, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        JPanel1Layout.setVerticalGroup(
            JPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(JPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPanel1Layout.createSequentialGroup()
                        .addComponent(Actualizar_Bn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(JPanel1Layout.createSequentialGroup()
                        .addGroup(JPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inventarioJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(regresarJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27))))
        );

        buscarJTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        ordenarJButton.setBackground(new java.awt.Color(136, 213, 133));
        ordenarJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ordenar.png"))); // NOI18N
        ordenarJButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ordenarJButtonMouseClicked(evt);
            }
        });

        buscarJButton.setBackground(new java.awt.Color(136, 213, 133));
        buscarJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lupa.png"))); // NOI18N
        buscarJButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buscarJButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout JPanel2Layout = new javax.swing.GroupLayout(JPanel2);
        JPanel2.setLayout(JPanel2Layout);
        JPanel2Layout.setHorizontalGroup(
            JPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(ordenarJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buscarJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buscarJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        JPanel2Layout.setVerticalGroup(
            JPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanel2Layout.createSequentialGroup()
                .addGroup(JPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(JPanel2Layout.createSequentialGroup()
                        .addContainerGap(20, Short.MAX_VALUE)
                        .addComponent(ordenarJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(JPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(JPanel2Layout.createSequentialGroup()
                                .addComponent(buscarJTextField)
                                .addGap(1, 1, 1))
                            .addComponent(buscarJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        datosJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Descripcion", "Marca", "Fecha de Vencimiento", "Categoria", "Stock", "Unidad de Medida", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        datosJTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                datosJTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(datosJTable);

        javax.swing.GroupLayout JPanel3Layout = new javax.swing.GroupLayout(JPanel3);
        JPanel3.setLayout(JPanel3Layout);
        JPanel3Layout.setHorizontalGroup(
            JPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPanel3Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 857, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        JPanel3Layout.setVerticalGroup(
            JPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 3, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("EDITAR");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("NUEVO");

        jButton1.setBackground(new java.awt.Color(136, 213, 133));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editar.png"))); // NOI18N
        jButton1.setToolTipText("");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        nuevojButton2.setBackground(new java.awt.Color(136, 213, 133));
        nuevojButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nuevo.png"))); // NOI18N
        nuevojButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevojButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(JPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(JPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nuevojButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(JPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(JPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(nuevojButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JPanel1MouseClicked

    }//GEN-LAST:event_JPanel1MouseClicked

    private void regresarJButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_regresarJButtonMouseClicked
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
    }//GEN-LAST:event_regresarJButtonMouseClicked

    private void ordenarJButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ordenarJButtonMouseClicked
        // TODO add your handling code here:

        if (sorter == null) {
            // Crear un objeto TableRowSorter basado en el modelo de la tabla
            DefaultTableModel model = (DefaultTableModel) datosJTable.getModel();
            sorter = new TableRowSorter<>(model);
            datosJTable.setRowSorter(sorter);
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

    }//GEN-LAST:event_ordenarJButtonMouseClicked

    private void Actualizar_BnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Actualizar_BnMouseClicked
        // TODO add your handling code here:
        actualizarTabla();
    }//GEN-LAST:event_Actualizar_BnMouseClicked

    private void buscarJButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscarJButtonMouseClicked
        String textoBusqueda = buscarJTextField.getText().trim();

        if (!textoBusqueda.isEmpty()) {
            try {
                ResultSet rs = inventario.busqueda(conexion, textoBusqueda);

                // Obtener el modelo de la tabla actual
                DefaultTableModel model = (DefaultTableModel) datosJTable.getModel();
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
                JOptionPane.showMessageDialog(this, "Error al realizar la búsqueda: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Ingrese un nombre o ID para buscar.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_buscarJButtonMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        EditarProducto screen_edit_product = new EditarProducto(conexion, credenciales, "");
        screen_edit_product.setVisible(true);
        
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void nuevojButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevojButton2ActionPerformed
        // TODO add your handling code here:
        NuevoProducto screen_new_product = new NuevoProducto(conexion, credenciales);
        screen_new_product.setVisible(true);
        
        dispose();
    }//GEN-LAST:event_nuevojButton2ActionPerformed

    private void datosJTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_datosJTableMouseClicked

            datosJTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1 && e.getClickCount() == 2) { 
                    System.out.println("Hola");
                    int fila = datosJTable.getSelectedRow();
                    System.out.println(fila);
                    if (fila >= 0) {
                        long ID = (long) datosJTable.getValueAt(fila, 0);
                        String numCadena= String.valueOf(ID);
                        EditarProducto screen_edit_product = new EditarProducto(conexion, credenciales, numCadena);
                        screen_edit_product.setVisible(true);      
                        dispose();
                    }
                }
            }
        });
    }//GEN-LAST:event_datosJTableMouseClicked


    private void actualizarTabla() {
        try {

            ResultSet rs = inventario.consulta(conexion);

            // Obtener el modelo de la tabla actual
            DefaultTableModel model = (DefaultTableModel) datosJTable.getModel();
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



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Actualizar_Bn;
    private javax.swing.JPanel JPanel1;
    private javax.swing.JPanel JPanel2;
    private javax.swing.JPanel JPanel3;
    private javax.swing.JButton buscarJButton;
    private javax.swing.JTextField buscarJTextField;
    private javax.swing.JTable datosJTable;
    private javax.swing.JLabel inventarioJLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton nuevojButton2;
    private javax.swing.JButton ordenarJButton;
    private javax.swing.JButton regresarJButton;
    // End of variables declaration//GEN-END:variables
}
