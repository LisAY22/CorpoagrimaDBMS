/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package corpoagrima.corpoagrima.gui.regcompra;

import corpoagrima.corpoagrima.bdMariaDB.ConexionCompra;
import corpoagrima.corpoagrima.bdMariaDB.ConexionProducto;
import corpoagrima.corpoagrima.bdMariaDB.ConexionProveedores;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author karol
 */
public class VisualizarRegFactura extends javax.swing.JFrame {
    
    private final Connection conexion;
    private final ResultSet credenciales;
    private final ConexionCompra compras;
    private final ConexionProducto productos;
    private final String factura;
    private int id;
    
    public VisualizarRegFactura(Connection conexion, ResultSet credenciales, String numeroFactura) throws SQLException {
        this.conexion = conexion;
        this.credenciales = credenciales;
        this.factura = numeroFactura;
        
        compras = new ConexionCompra();
        productos = new ConexionProducto();
        initComponents();
        mostrarInformacion();
        sumarColumnaProductos();
    }

    public final void mostrarInformacion() throws SQLException {
        ResultSet rs = compras.busqueda(conexion, factura);
        if (rs.next()) {
            id = rs.getInt("ID_Compra");
            String NoFactura = factura;
            String fecha = rs.getString("Fecha");
            String empresa = rs.getString("Empresa");
            String nit = rs.getString("NIT");
            String tipoCompra = rs.getString("Tipo_Compra");
            String nombreUsuario = rs.getString("Nombre");
            String apellidoUsuario = rs.getString("Apellido");
            String nombreCompletoUsuario = nombreUsuario + " " + apellidoUsuario;
            String detalle = rs.getString("Detalle");
            double total = rs.getDouble("Total");

            if ("Credito".equals(tipoCompra)) {
                credito_checkBox.setSelected(true);
            } else {
                credito_checkBox.setSelected(false);
            }

            ResultSet proveedor = new ConexionProveedores().proveedor2(conexion, empresa);
            proveedor.next();
            String numero = proveedor.getString("Numero");
            telefono_textfield.setText(numero);
            noFactura_textfield.setText(NoFactura);
            fecha_textfield.setText(fecha);
            proveedor_textfield.setText(empresa);
            nit_textfield.setText(nit);
            empleado_textfield.setText(nombreCompletoUsuario);
            Detalle_textfield.setText(detalle);
            totalJTextField1.setText(String.valueOf(total));

            // Obtener el modelo de la tabla actual
            try (ResultSet productos = compras.busqueda2(conexion, factura)) {
                // Obtener el modelo de la tabla actual
                DefaultTableModel model = (DefaultTableModel) listaProductoJTable.getModel();
                model.setRowCount(0); // Limpiar los datos existentes

                // Agregar nuevas filas al modelo de tabla
                ResultSetMetaData metaData = productos.getMetaData();
                int columnCount = metaData.getColumnCount();

                while (productos.next()) {
                    Object[] rowData = new Object[columnCount];
                    for (int i = 0; i < columnCount; i++) {
                        rowData[i] = productos.getObject(i + 1);
                    }
                    model.addRow(rowData);
                }
            }

        } else {
            JOptionPane.showMessageDialog(this, "No se encontraron resultados",
                    "Busqueda", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    private void sumarColumnaProductos() {
        DefaultTableModel model = (DefaultTableModel) listaProductoJTable.getModel();
        int rowCount = model.getRowCount();
        int total = 0;

        for (int i = 0; i < rowCount; i++) {
            int cantidad = Integer.parseInt(model.getValueAt(i, 3).toString());
            // Sumar al total
            total += cantidad;
        }

        totalProductoJTextField.setText(String.valueOf(total));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        totalProductoLabel = new javax.swing.JLabel();
        totalProductoJTextField = new javax.swing.JTextField();
        totalLabel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        FechaLabel = new javax.swing.JLabel();
        FacturaLabel = new javax.swing.JLabel();
        telefono_textfield = new javax.swing.JTextField();
        EmpleadoLabel = new javax.swing.JLabel();
        empleado_textfield = new javax.swing.JTextField();
        NITLabel = new javax.swing.JLabel();
        nit_textfield = new javax.swing.JTextField();
        TelefonoLabel = new javax.swing.JLabel();
        ProveedorLabel = new javax.swing.JLabel();
        credito_checkBox = new javax.swing.JCheckBox();
        Detalle_textfield = new javax.swing.JTextField();
        DetalleLabel = new javax.swing.JLabel();
        noFactura_textfield = new javax.swing.JTextField();
        fecha_textfield = new javax.swing.JTextField();
        proveedor_textfield = new javax.swing.JTextField();
        totalJTextField1 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaProductoJTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        EditarLabel = new javax.swing.JLabel();
        Regresar_Bn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        totalProductoLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        totalProductoLabel.setText("Total de productos:");

        totalProductoJTextField.setEditable(false);
        totalProductoJTextField.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N

        totalLabel.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        totalLabel.setForeground(new java.awt.Color(159, 46, 46));
        totalLabel.setText("Total:");

        FechaLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        FechaLabel.setText("Fecha");

        FacturaLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        FacturaLabel.setText("No. Factura");

        telefono_textfield.setEditable(false);
        telefono_textfield.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        EmpleadoLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        EmpleadoLabel.setText("Empleado");

        empleado_textfield.setEditable(false);
        empleado_textfield.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        NITLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        NITLabel.setText("NIT");

        nit_textfield.setEditable(false);
        nit_textfield.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        TelefonoLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        TelefonoLabel.setText("Teléfono");

        ProveedorLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ProveedorLabel.setText("Proveedor");

        credito_checkBox.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        credito_checkBox.setText("Credito");
        credito_checkBox.setEnabled(false);

        Detalle_textfield.setEditable(false);
        Detalle_textfield.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        DetalleLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        DetalleLabel.setText("Detalle");

        noFactura_textfield.setEditable(false);
        noFactura_textfield.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        fecha_textfield.setEditable(false);
        fecha_textfield.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        proveedor_textfield.setEditable(false);
        proveedor_textfield.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(ProveedorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(FechaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(FacturaLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(noFactura_textfield, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                    .addComponent(fecha_textfield)
                    .addComponent(proveedor_textfield))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DetalleLabel)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(EmpleadoLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(TelefonoLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(telefono_textfield, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                            .addComponent(empleado_textfield))
                        .addGap(95, 95, 95)
                        .addComponent(NITLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(credito_checkBox)
                            .addComponent(nit_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(Detalle_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TelefonoLabel)
                            .addComponent(telefono_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(EmpleadoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(empleado_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(FacturaLabel)
                            .addComponent(NITLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nit_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(noFactura_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(credito_checkBox, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(FechaLabel)
                                .addComponent(fecha_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ProveedorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(proveedor_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(DetalleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Detalle_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13))
        );

        totalJTextField1.setEditable(false);
        totalJTextField1.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N

        listaProductoJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Descripcion", "Marca", "Cantidad", "Costo por unidad", "Subtotal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(listaProductoJTable);

        jPanel1.setBackground(new java.awt.Color(34, 85, 34));

        EditarLabel.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        EditarLabel.setForeground(new java.awt.Color(255, 255, 255));
        EditarLabel.setText("VISUALIZAR REGISTRO DE COMPRA");

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(Regresar_Bn, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(162, 162, 162)
                .addComponent(EditarLabel)
                .addContainerGap(259, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EditarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Regresar_Bn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(40, 40, 40)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(totalProductoLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(totalProductoJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(totalLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(totalJTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 912, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(62, 62, 62))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addContainerGap()))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 584, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(123, 123, 123)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(totalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(totalProductoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(totalProductoJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(totalJTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(50, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Regresar_BnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Regresar_BnActionPerformed
        Compra compra_screen = new Compra(conexion, credenciales);
        compra_screen.setVisible(true);
        // Cerrar la ventana actual
        dispose();
    }//GEN-LAST:event_Regresar_BnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DetalleLabel;
    private javax.swing.JTextField Detalle_textfield;
    private javax.swing.JLabel EditarLabel;
    private javax.swing.JLabel EmpleadoLabel;
    private javax.swing.JLabel FacturaLabel;
    private javax.swing.JLabel FechaLabel;
    private javax.swing.JLabel NITLabel;
    private javax.swing.JLabel ProveedorLabel;
    private javax.swing.JButton Regresar_Bn;
    private javax.swing.JLabel TelefonoLabel;
    private javax.swing.JCheckBox credito_checkBox;
    private javax.swing.JTextField empleado_textfield;
    private javax.swing.JTextField fecha_textfield;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable listaProductoJTable;
    private javax.swing.JTextField nit_textfield;
    private javax.swing.JTextField noFactura_textfield;
    private javax.swing.JTextField proveedor_textfield;
    private javax.swing.JTextField telefono_textfield;
    private javax.swing.JTextField totalJTextField1;
    private javax.swing.JLabel totalLabel;
    private javax.swing.JTextField totalProductoJTextField;
    private javax.swing.JLabel totalProductoLabel;
    // End of variables declaration//GEN-END:variables
}
