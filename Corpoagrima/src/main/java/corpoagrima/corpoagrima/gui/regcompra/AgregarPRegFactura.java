/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package corpoagrima.corpoagrima.gui.regcompra;

import corpoagrima.corpoagrima.bdMariaDB.ConexionProducto;
import corpoagrima.corpoagrima.gui.Principal;
import corpoagrima.corpoagrima.gui.cliente.EditarCliente;
import corpoagrima.corpoagrima.logic.DatoEstadoFinanciero;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author karol
 * @author lisaj
 */
public class AgregarPRegFactura extends javax.swing.JFrame {

    private Connection conexion;
    private ResultSet credenciales;
    private ConexionProducto producto;
    private NuevoRegFactura nuevaFactura = null;
    private EditarRegFactura editarFactura = null;
    private int id;
    private DatoEstadoFinanciero logicFinanciero;

    /**
     * Creates new form AgregarPRegFactura
     */
    public AgregarPRegFactura(Connection conexion, ResultSet credenciales, NuevoRegFactura nuevaFactura) {
        this.conexion = conexion;
        this.credenciales = credenciales;
        this.nuevaFactura = nuevaFactura;
        this.logicFinanciero = new DatoEstadoFinanciero(conexion);
        producto = new ConexionProducto();
        initComponents();
        
        // Agregar el WindowListener para detectar el cierre de la ventana
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Aquí colocas el código que deseas ejecutar cuando la ventana se cierre
                try {
                    // TODO add your handling code here:
                    logicFinanciero.actualizarFinanciero(conexion);
                } catch (SQLException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
    }

    public AgregarPRegFactura(Connection conexion, ResultSet credenciales, EditarRegFactura editarFactura) {
        this.conexion = conexion;
        this.credenciales = credenciales;
        this.editarFactura = editarFactura;
        producto = new ConexionProducto();
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

        jPanel1 = new javax.swing.JPanel();
        EditarLabel = new javax.swing.JLabel();
        Regresar_Bn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        Buscar_textField = new javax.swing.JTextField();
        Buscar_Button = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        Seleccionar_button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(34, 85, 34));

        EditarLabel.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        EditarLabel.setForeground(new java.awt.Color(255, 255, 255));
        EditarLabel.setText("AGREGAR PRODUCTO AL REGISTRO DE COMPRA");

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(Regresar_Bn, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(EditarLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EditarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Regresar_Bn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID_Producto", "Nombre", "Descripción", "Marca", "Categoria", "Unidad Medida"
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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 839, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                .addContainerGap())
        );

        Buscar_textField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        Buscar_Button.setBackground(new java.awt.Color(136, 213, 133));
        Buscar_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lupa.png"))); // NOI18N
        Buscar_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Buscar_ButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(Buscar_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Buscar_textField, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Buscar_Button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Buscar_textField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        Seleccionar_button.setText("Seleccionar");
        Seleccionar_button.setEnabled(true);
        Seleccionar_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Seleccionar_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Seleccionar_button)
                .addGap(38, 38, 38))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(Seleccionar_button)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Regresar_BnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Regresar_BnActionPerformed
        // Cerrar la ventana actual
        dispose();
    }//GEN-LAST:event_Regresar_BnActionPerformed

    private void Buscar_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Buscar_ButtonActionPerformed
        try {
            String textoBusqueda = Buscar_textField.getText().trim();

            if (!textoBusqueda.isEmpty()) {
                ResultSet rs = producto.busqueda3(conexion, textoBusqueda);

                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                model.setRowCount(0); // Limpiar los datos existentes

                ResultSetMetaData metaData = rs.getMetaData();
                int columnCount = metaData.getColumnCount();

                while (rs.next()) {
                    Object[] rowData = new Object[columnCount];
                    for (int i = 0; i < columnCount - 1; i++) { // Ajuste en el límite del bucle
                        // Obtener el valor de la columna
                        Object value = rs.getObject(i + 1);
                        if (i == 5) {  // Verificar si es la columna específica para el cambio
                            if (value instanceof Integer) {
                                int intValue = (int) value;
                                switch (intValue) {
                                    case 0:
                                        rowData[i] = "-";
                                        break;
                                    case 1:
                                        rowData[i] = "\u2605"; // Código Unicode para una estrella
                                        break;
                                    default:
                                        rowData[i] = value;
                                        break;
                                }
                            } else {
                                rowData[i] = value == null ? "-" : value; // Si el valor es null, colocamos un guion "-"
                            }
                        } else {
                            rowData[i] = value == null ? "-" : value; // Si el valor es null, colocamos un guion "-"
                        }
                    }
                    model.addRow(rowData);
                }

                if (model.getRowCount() > 0) {
                    JOptionPane.showMessageDialog(this, "La búsqueda ha sido exitosa",
                            "Búsqueda", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "No se encontraron resultados",
                            "Búsqueda", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Ingrese un texto para buscar",
                        "Búsqueda", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EditarCliente.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Ha habido un error durante la búsqueda",
                    "Búsqueda", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_Buscar_ButtonActionPerformed


    private void Seleccionar_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Seleccionar_buttonActionPerformed
        try {
            if (editarFactura == null) {
                int fila = jTable1.getSelectedRow();
                if (fila != -1) {
                    long ID = (long) jTable1.getValueAt(fila, 0);
                    int id = (int) ID; // Convertir long a int
                    nuevaFactura.agregarProducto(id);
                }
            } else {
                int fila1 = jTable1.getSelectedRow();
                if (fila1 != -1) {
                    long ID = (long) jTable1.getValueAt(fila1, 0);
                    int id = (int) ID;
                    editarFactura.agregarProducto(id);
                }
            }
            dispose();
        } catch (SQLException ex) {
            Logger.getLogger(AgregarPRegFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Seleccionar_buttonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Buscar_Button;
    private javax.swing.JTextField Buscar_textField;
    private javax.swing.JLabel EditarLabel;
    private javax.swing.JButton Regresar_Bn;
    private javax.swing.JButton Seleccionar_button;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
