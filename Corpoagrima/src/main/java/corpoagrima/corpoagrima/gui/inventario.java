/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package corpoagrima.corpoagrima.gui;

import corpoagrima.corpoagrima.bdMariaDB.ConexionProducto;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.util.ArrayList;




/**
 *
 * @author lisaj
 */
public class inventario extends javax.swing.JFrame {

    /**
     * Creates new form inventario
     */    
    
    private Connection conexion;
    private ConexionProducto inventario;
    
    
    public inventario(Connection conexion) {
        this.conexion = conexion;
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
        JPanel2 = new javax.swing.JPanel();
        ordenarJButton = new javax.swing.JButton();
        buscarJButton = new javax.swing.JButton();
        buscarJTextField = new javax.swing.JTextField();
        actualizarJButton = new javax.swing.JButton();
        JPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        datosJTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inventario");
        setPreferredSize(new java.awt.Dimension(1300, 600));

        JPanel1.setBackground(new java.awt.Color(16, 82, 0));

        inventarioJLabel.setBackground(new java.awt.Color(16, 82, 0));
        inventarioJLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        inventarioJLabel.setForeground(new java.awt.Color(252, 252, 252));
        inventarioJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inventarioJLabel.setText("INVENTARIO");
        inventarioJLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        regresarJButton.setBackground(new java.awt.Color(136, 213, 133));
        regresarJButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        regresarJButton.setText("REGRESAR");
        regresarJButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        regresarJButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                regresarJButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout JPanel1Layout = new javax.swing.GroupLayout(JPanel1);
        JPanel1.setLayout(JPanel1Layout);
        JPanel1Layout.setHorizontalGroup(
            JPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanel1Layout.createSequentialGroup()
                .addGap(233, 233, 233)
                .addComponent(inventarioJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
                .addGap(240, 240, 240))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(regresarJButton))
        );
        JPanel1Layout.setVerticalGroup(
            JPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanel1Layout.createSequentialGroup()
                .addComponent(regresarJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(8, 8, 8)
                .addComponent(inventarioJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(33, 33, 33))
        );

        ordenarJButton.setText("ORDENAR");
        ordenarJButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ordenarJButtonMouseClicked(evt);
            }
        });

        buscarJButton.setText("BUSCAR");
        buscarJButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buscarJButtonMouseClicked(evt);
            }
        });

        buscarJTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        actualizarJButton.setText("ACTUALIZAR");
        actualizarJButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        actualizarJButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                actualizarJButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout JPanel2Layout = new javax.swing.GroupLayout(JPanel2);
        JPanel2.setLayout(JPanel2Layout);
        JPanel2Layout.setHorizontalGroup(
            JPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(ordenarJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(27, 27, 27)
                .addComponent(buscarJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(buscarJTextField)
                .addGap(33, 33, 33)
                .addComponent(actualizarJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(17, 17, 17))
        );
        JPanel2Layout.setVerticalGroup(
            JPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(JPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ordenarJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buscarJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buscarJTextField)
                    .addComponent(actualizarJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        datosJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Descripcion", "Costo", "Marca", "Fecha de Vencimiento", "Categoria", "Stock", "Unidad de Medida", "Precio"
            }
        ));
        jScrollPane1.setViewportView(datosJTable);

        javax.swing.GroupLayout JPanel3Layout = new javax.swing.GroupLayout(JPanel3);
        JPanel3.setLayout(JPanel3Layout);
        JPanel3Layout.setHorizontalGroup(
            JPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        JPanel3Layout.setVerticalGroup(
            JPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPanel3Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(JPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(JPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(JPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(3, 3, 3)
                .addComponent(JPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ordenarJButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ordenarJButtonMouseClicked
        // TODO add your handling code here:
        // Obtener el modelo de la tabla
        DefaultTableModel model = (DefaultTableModel) datosJTable.getModel();

        // Obtener el número de filas en la tabla
        int rowCount = model.getRowCount();

        // Verificar si hay al menos una fila en la tabla
        if (rowCount > 0) {
            // Crear un objeto TableRowSorter basado en el modelo de la tabla
            TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);

            // Asignar el TableRowSorter a la tabla
            datosJTable.setRowSorter(sorter);

            // Crear un RowSorter para ordenar por la columna "Nombre"
            ArrayList<RowSorter.SortKey> sortKeys = new ArrayList<>();
            int columnIndexToSort = 1; // Índice de la columna "Nombre" (comienza desde 0)
            sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.ASCENDING)); // Orden ascendente
            sorter.setSortKeys(sortKeys);

            // Ordenar la tabla
            sorter.sort();
        } else {
            // Mostrar un mensaje de advertencia si la tabla está vacía
            JOptionPane.showMessageDialog(this, "No hay datos para ordenar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
        
    }//GEN-LAST:event_ordenarJButtonMouseClicked

    private void actualizarJButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_actualizarJButtonMouseClicked
        // TODO add your handling code here:
        actualizarTabla();
    }//GEN-LAST:event_actualizarJButtonMouseClicked

    private void buscarJButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscarJButtonMouseClicked
        // TODO add your handling code here:
        String textoBusqueda = buscarJTextField.getText().trim();

        if (!textoBusqueda.isEmpty()) {
            try {
                ResultSet rs = inventario.busqueda(conexion, textoBusqueda);

                DefaultTableModel model = new DefaultTableModel();
                datosJTable.setModel(model);

                ResultSetMetaData metaData = rs.getMetaData();
                int columnCount = metaData.getColumnCount();
                for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                    model.addColumn(metaData.getColumnLabel(columnIndex));
                }

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

    private void regresarJButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_regresarJButtonMouseClicked
        // TODO add your handling code here:
        principal principal_screen = new principal(conexion);
        principal_screen.setVisible(true);
        principal_screen.setLocationRelativeTo(null);
        
        // Cerrar la ventana actual
        dispose();
    }//GEN-LAST:event_regresarJButtonMouseClicked


    private void actualizarTabla() {
        try {

            // Ejecutar la consulta y obtener el ResultSet
            ResultSet rs = inventario.consulta(conexion);

            // Crear un modelo de tabla y asignarlo a la JTable
            DefaultTableModel model = new DefaultTableModel();
            datosJTable.setModel(model);

            // Agregar columnas al modelo de tabla
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                model.addColumn(metaData.getColumnLabel(columnIndex));
            }

            // Agregar filas al modelo de tabla
            while (rs.next()) {
                Object[] rowData = new Object[columnCount];
                for (int i = 0; i < columnCount; i++) {
                    rowData[i] = rs.getObject(i + 1);
                }
                model.addRow(rowData);
            }

            // Cerrar la conexión y liberar recursos
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar los datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
}



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPanel1;
    private javax.swing.JPanel JPanel2;
    private javax.swing.JPanel JPanel3;
    private javax.swing.JButton actualizarJButton;
    private javax.swing.JButton buscarJButton;
    private javax.swing.JTextField buscarJTextField;
    private javax.swing.JTable datosJTable;
    private javax.swing.JLabel inventarioJLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton ordenarJButton;
    private javax.swing.JButton regresarJButton;
    // End of variables declaration//GEN-END:variables
}
