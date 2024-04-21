package corpoagrima.corpoagrima.gui;

import java.sql.Connection;
import corpoagrima.corpoagrima.bdMariaDB.ConexionPuesto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author WilderL
 * @author User
 */
public class Puesto extends javax.swing.JFrame {

    private Connection conexion;
    private ConexionPuesto puesto;
    private int id;

    /**
     * Creates new form Puesto
     *
     * @param conexion
     */
    public Puesto(Connection conexion) {
        this.conexion = conexion;
        puesto = new ConexionPuesto();
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

        jSpinner1 = new javax.swing.JSpinner();
        encabezadoJPanel = new javax.swing.JPanel();
        puestoJLabel = new javax.swing.JLabel();
        opcionJPanel = new javax.swing.JPanel();
        buscarJButton = new javax.swing.JButton();
        buscarJTextField = new javax.swing.JTextField();
        informacionJPanel = new javax.swing.JPanel();
        nombreJLabel = new javax.swing.JLabel();
        salarioBaseJLabel = new javax.swing.JLabel();
        horarioJLabel = new javax.swing.JLabel();
        nombreJTextField = new javax.swing.JTextField();
        salarioBaseJTextField = new javax.swing.JTextField();
        horarioJTextField = new javax.swing.JTextField();
        DescripciónJLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        descripcionJTextPane = new javax.swing.JTextPane();
        moduloInventarioJCheckBox = new javax.swing.JCheckBox();
        moduloFinancieroJCheckBox = new javax.swing.JCheckBox();
        moduloClienteJCheckBox = new javax.swing.JCheckBox();
        moduloVentaJCheckBox = new javax.swing.JCheckBox();
        moduloCompraJCheckBox = new javax.swing.JCheckBox();
        moduloProveedoresJCheckBox = new javax.swing.JCheckBox();
        moduloRHJCheckBox = new javax.swing.JCheckBox();
        PermisoJLabel = new javax.swing.JLabel();
        botonesJPanel = new javax.swing.JPanel();
        cancelarJButton = new javax.swing.JButton();
        guardarJButton = new javax.swing.JButton();
        limpiarJButton = new javax.swing.JButton();
        eliminarJButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        encabezadoJPanel.setBackground(new java.awt.Color(34, 85, 34));

        puestoJLabel.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        puestoJLabel.setForeground(new java.awt.Color(255, 255, 255));
        puestoJLabel.setText("PUESTO");

        javax.swing.GroupLayout encabezadoJPanelLayout = new javax.swing.GroupLayout(encabezadoJPanel);
        encabezadoJPanel.setLayout(encabezadoJPanelLayout);
        encabezadoJPanelLayout.setHorizontalGroup(
            encabezadoJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(encabezadoJPanelLayout.createSequentialGroup()
                .addGap(305, 305, 305)
                .addComponent(puestoJLabel)
                .addContainerGap(320, Short.MAX_VALUE))
        );
        encabezadoJPanelLayout.setVerticalGroup(
            encabezadoJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, encabezadoJPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(puestoJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        buscarJButton.setBackground(new java.awt.Color(136, 213, 133));
        buscarJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lupa.png"))); // NOI18N
        buscarJButton.setToolTipText("Boton de búsqueda del puesto");
        buscarJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarJButtonActionPerformed(evt);
            }
        });

        buscarJTextField.setToolTipText("Ingrese nombre del puesto");

        javax.swing.GroupLayout opcionJPanelLayout = new javax.swing.GroupLayout(opcionJPanel);
        opcionJPanel.setLayout(opcionJPanelLayout);
        opcionJPanelLayout.setHorizontalGroup(
            opcionJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(opcionJPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(buscarJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buscarJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        opcionJPanelLayout.setVerticalGroup(
            opcionJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(opcionJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(opcionJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buscarJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buscarJTextField))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        buscarJTextField.getAccessibleContext().setAccessibleName("");

        nombreJLabel.setText("Nombre");

        salarioBaseJLabel.setText("Salario Base");

        horarioJLabel.setText("Horario");

        nombreJTextField.setEditable(false);

        salarioBaseJTextField.setEditable(false);

        horarioJTextField.setEditable(false);

        DescripciónJLabel.setText("Descripción");

        descripcionJTextPane.setEditable(false);
        jScrollPane2.setViewportView(descripcionJTextPane);

        moduloInventarioJCheckBox.setText("Inventario");
        moduloInventarioJCheckBox.setEnabled(false);

        moduloFinancieroJCheckBox.setText("Financiero");
        moduloFinancieroJCheckBox.setEnabled(false);

        moduloClienteJCheckBox.setText("Clientes");
        moduloClienteJCheckBox.setEnabled(false);

        moduloVentaJCheckBox.setText("Ventas");
        moduloVentaJCheckBox.setEnabled(false);

        moduloCompraJCheckBox.setText("Compras");
        moduloCompraJCheckBox.setEnabled(false);

        moduloProveedoresJCheckBox.setText("Proveedores");
        moduloProveedoresJCheckBox.setEnabled(false);

        moduloRHJCheckBox.setText("Recursos Humanos");
        moduloRHJCheckBox.setEnabled(false);

        PermisoJLabel.setText("Permisos");

        javax.swing.GroupLayout informacionJPanelLayout = new javax.swing.GroupLayout(informacionJPanel);
        informacionJPanel.setLayout(informacionJPanelLayout);
        informacionJPanelLayout.setHorizontalGroup(
            informacionJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(informacionJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(informacionJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(informacionJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(informacionJPanelLayout.createSequentialGroup()
                            .addGroup(informacionJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(nombreJLabel)
                                .addComponent(salarioBaseJLabel)
                                .addComponent(horarioJLabel))
                            .addGap(27, 27, 27)
                            .addGroup(informacionJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(nombreJTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                                .addComponent(salarioBaseJTextField)
                                .addComponent(horarioJTextField))
                            .addGap(18, 18, 18)
                            .addComponent(DescripciónJLabel))
                        .addGroup(informacionJPanelLayout.createSequentialGroup()
                            .addGroup(informacionJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(moduloInventarioJCheckBox)
                                .addComponent(moduloVentaJCheckBox))
                            .addGap(18, 18, 18)
                            .addGroup(informacionJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(moduloClienteJCheckBox)
                                .addComponent(moduloCompraJCheckBox)
                                .addComponent(moduloProveedoresJCheckBox))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                            .addGroup(informacionJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(moduloRHJCheckBox)
                                .addComponent(moduloFinancieroJCheckBox))
                            .addGap(15, 15, 15)))
                    .addComponent(PermisoJLabel))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                .addContainerGap())
        );
        informacionJPanelLayout.setVerticalGroup(
            informacionJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(informacionJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(informacionJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreJLabel)
                    .addComponent(nombreJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DescripciónJLabel))
                .addGap(18, 18, 18)
                .addGroup(informacionJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salarioBaseJLabel)
                    .addComponent(salarioBaseJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(informacionJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(horarioJLabel)
                    .addComponent(horarioJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(PermisoJLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(informacionJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(moduloInventarioJCheckBox)
                    .addComponent(moduloClienteJCheckBox)
                    .addComponent(moduloRHJCheckBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(moduloProveedoresJCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(informacionJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(moduloVentaJCheckBox)
                    .addComponent(moduloCompraJCheckBox)
                    .addComponent(moduloFinancieroJCheckBox))
                .addGap(14, 14, 14))
            .addComponent(jScrollPane2)
        );

        cancelarJButton.setText("Cancelar");
        cancelarJButton.setToolTipText("Cancela y cierra la ventana");
        cancelarJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarJButtonActionPerformed(evt);
            }
        });

        guardarJButton.setText("Guardar");
        guardarJButton.setToolTipText("Guarda los datos actuales");
        guardarJButton.setEnabled(false);
        guardarJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarJButtonActionPerformed(evt);
            }
        });

        limpiarJButton.setText("Limpiar");
        limpiarJButton.setToolTipText("Limpia las opcion para escoger de nuevo entre buscar o crear nuevo puesto");
        limpiarJButton.setEnabled(false);
        limpiarJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarJButtonActionPerformed(evt);
            }
        });

        eliminarJButton.setBackground(new java.awt.Color(255, 0, 0));
        eliminarJButton.setText("Eliminar");
        eliminarJButton.setToolTipText("Elimina el puesto de forma permanente");
        eliminarJButton.setEnabled(false);
        eliminarJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout botonesJPanelLayout = new javax.swing.GroupLayout(botonesJPanel);
        botonesJPanel.setLayout(botonesJPanelLayout);
        botonesJPanelLayout.setHorizontalGroup(
            botonesJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, botonesJPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(eliminarJButton)
                .addGap(18, 18, 18)
                .addComponent(limpiarJButton)
                .addGap(18, 18, 18)
                .addComponent(guardarJButton)
                .addGap(18, 18, 18)
                .addComponent(cancelarJButton)
                .addContainerGap())
        );
        botonesJPanelLayout.setVerticalGroup(
            botonesJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(botonesJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(botonesJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelarJButton)
                    .addComponent(guardarJButton)
                    .addComponent(limpiarJButton)
                    .addComponent(eliminarJButton))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(encabezadoJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(opcionJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(botonesJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(informacionJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(encabezadoJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(opcionJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(informacionJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonesJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void habilitar() {
        nombreJTextField.setEditable(true);
        salarioBaseJTextField.setEditable(true);
        horarioJTextField.setEditable(true);
        descripcionJTextPane.setEditable(true);
        limpiarJButton.setEnabled(true);
        guardarJButton.setEnabled(true);
        buscarJButton.setEnabled(false);
        buscarJTextField.setEnabled(false);
        moduloClienteJCheckBox.setEnabled(true);
        moduloCompraJCheckBox.setEnabled(true);
        moduloFinancieroJCheckBox.setEnabled(true);
        moduloInventarioJCheckBox.setEnabled(true);
        moduloProveedoresJCheckBox.setEnabled(true);
        moduloRHJCheckBox.setEnabled(true);
        moduloVentaJCheckBox.setEnabled(true);
    }

    private void deshabilitar() {
        nombreJTextField.setEditable(false);
        salarioBaseJTextField.setEditable(false);
        horarioJTextField.setEditable(false);
        descripcionJTextPane.setEditable(false);
        limpiarJButton.setEnabled(false);
        guardarJButton.setEnabled(false);
        eliminarJButton.setEnabled(false);
        buscarJButton.setEnabled(true);
        buscarJTextField.setEnabled(true);
        moduloClienteJCheckBox.setEnabled(false);
        moduloCompraJCheckBox.setEnabled(false);
        moduloFinancieroJCheckBox.setEnabled(false);
        moduloInventarioJCheckBox.setEnabled(false);
        moduloProveedoresJCheckBox.setEnabled(false);
        moduloRHJCheckBox.setEnabled(false);
        moduloVentaJCheckBox.setEnabled(false);

    }

    private void limpiar() {
        nombreJTextField.setText("");
        salarioBaseJTextField.setText("");
        horarioJTextField.setText("");
        descripcionJTextPane.setText("");
        buscarJTextField.setText("");
        moduloClienteJCheckBox.setSelected(false);
        moduloCompraJCheckBox.setSelected(false);
        moduloFinancieroJCheckBox.setSelected(false);
        moduloInventarioJCheckBox.setSelected(false);
        moduloProveedoresJCheckBox.setSelected(false);
        moduloRHJCheckBox.setSelected(false);
        moduloVentaJCheckBox.setSelected(false);
    }

    private void buscarJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarJButtonActionPerformed
        try {
            String nombre = buscarJTextField.getText().trim();

            if (nombre != null && !nombre.isEmpty()) {
                ResultSet resultSet = puesto.puestoNombre(conexion, nombre);
                if (resultSet.next()) {
                    id = resultSet.getInt("ID_Puesto");
                    nombre = resultSet.getString("Nombre");
                    float salarioBase = resultSet.getFloat("Salario_Base");
                    String horario = resultSet.getString("Horario");
                    String descripcion = resultSet.getString("Descripcion");
                    boolean moduloInventario = resultSet.getBoolean("Modulo_Inventario");
                    boolean moduloCliente = resultSet.getBoolean("Modulo_Cliente");
                    boolean moduloRH = resultSet.getBoolean("Modulo_RH");
                    boolean moduloProveedores = resultSet.getBoolean("Modulo_Proveedores");
                    boolean moduloRegVenta = resultSet.getBoolean("Modulo_Reg_Venta");
                    boolean moduloRegCompra = resultSet.getBoolean("Modulo_Reg_Compra");
                    boolean moduloFinanciero = resultSet.getBoolean("Modulo_Financiero");

                    nombreJTextField.setText(nombre);
                    salarioBaseJTextField.setText(String.valueOf(salarioBase));
                    horarioJTextField.setText(horario);
                    descripcionJTextPane.setText(descripcion);
                    moduloClienteJCheckBox.setSelected(moduloCliente);
                    moduloCompraJCheckBox.setSelected(moduloRegCompra);
                    moduloFinancieroJCheckBox.setSelected(moduloFinanciero);
                    moduloInventarioJCheckBox.setSelected(moduloInventario);
                    moduloProveedoresJCheckBox.setSelected(moduloProveedores);
                    moduloRHJCheckBox.setSelected(moduloRH);
                    moduloVentaJCheckBox.setSelected(moduloRegVenta);

                    JOptionPane.showMessageDialog(this, "La busqueda ha sido exitosa",
                            "Busqueda", JOptionPane.INFORMATION_MESSAGE);
                    habilitar();
                    eliminarJButton.setEnabled(true);
                } else {
                    JOptionPane.showMessageDialog(this, "No se encontraron resultados",
                            "Busqueda", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Ingrese correctamente el "
                        + "nombre", "Busqueda", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Puesto.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Ha habido un error "
                    + "compruebe la información", "Busqueda",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_buscarJButtonActionPerformed

    private void limpiarJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarJButtonActionPerformed
        deshabilitar();
        limpiar();
        JOptionPane.showMessageDialog(this, "Se ha limpiado los campos"
                + "exitosamente.", "Limpieza",
                JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_limpiarJButtonActionPerformed

    private void eliminarJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarJButtonActionPerformed
        try {
            int opcion = JOptionPane.showConfirmDialog(null,
                    "¿Quieres continuar?\nSe eliminara el puesto permanentemente",
                    "Eliminar Puesto", JOptionPane.YES_NO_OPTION);

            // Comprobar la opción seleccionada
            if (opcion == JOptionPane.YES_OPTION) {
                boolean resultSet = puesto.eliminar(conexion, id);
                if (resultSet) {
                    JOptionPane.showMessageDialog(this,
                            "Se ha eliminado exitosamente el puesto.",
                            "Eliminar Puesto", JOptionPane.INFORMATION_MESSAGE);
                    deshabilitar();
                    limpiar();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(Puesto.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Ha habido un error "
                    + "compruebe la información", "Eliminar puesto",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_eliminarJButtonActionPerformed

    private void cancelarJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarJButtonActionPerformed
        try {
            RRHH rh_window = new RRHH(conexion);
            rh_window.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.dispose();
    }//GEN-LAST:event_cancelarJButtonActionPerformed

    private void guardarJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarJButtonActionPerformed
        try {
            String nombre = nombreJTextField.getText();
            float salarioBase = Float.parseFloat(salarioBaseJTextField.getText());
            String horario = horarioJTextField.getText();
            String descripcion = descripcionJTextPane.getText();
            boolean moduloInventario = moduloInventarioJCheckBox.isSelected();
            boolean moduloCliente = moduloClienteJCheckBox.isSelected();
            boolean moduloRH = moduloRHJCheckBox.isSelected();
            boolean moduloProveedores = moduloProveedoresJCheckBox.isSelected();
            boolean moduloRegVenta = moduloVentaJCheckBox.isSelected();
            boolean moduloRegCompra = moduloCompraJCheckBox.isSelected();
            boolean moduloFinanciero = moduloFinancieroJCheckBox.isSelected();
            boolean resultSet = puesto.actualizar(conexion, nombre, horario,
                    descripcion, salarioBase, moduloCliente, moduloRH,
                    moduloProveedores, moduloRegCompra, moduloRegVenta,
                    moduloFinanciero, moduloInventario, id);
            if (resultSet) {
                JOptionPane.showMessageDialog(this,
                        "Se ha guardado exitosamente el puesto.",
                        "Guardar Puesto", JOptionPane.INFORMATION_MESSAGE);
                deshabilitar();
                limpiar();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Puesto.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Ha habido un error "
                    + "compruebe la información", "Guardar Puesto",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_guardarJButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DescripciónJLabel;
    private javax.swing.JLabel PermisoJLabel;
    private javax.swing.JPanel botonesJPanel;
    private javax.swing.JButton buscarJButton;
    private javax.swing.JTextField buscarJTextField;
    private javax.swing.JButton cancelarJButton;
    private javax.swing.JTextPane descripcionJTextPane;
    private javax.swing.JButton eliminarJButton;
    private javax.swing.JPanel encabezadoJPanel;
    private javax.swing.JButton guardarJButton;
    private javax.swing.JLabel horarioJLabel;
    private javax.swing.JTextField horarioJTextField;
    private javax.swing.JPanel informacionJPanel;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JButton limpiarJButton;
    private javax.swing.JCheckBox moduloClienteJCheckBox;
    private javax.swing.JCheckBox moduloCompraJCheckBox;
    private javax.swing.JCheckBox moduloFinancieroJCheckBox;
    private javax.swing.JCheckBox moduloInventarioJCheckBox;
    private javax.swing.JCheckBox moduloProveedoresJCheckBox;
    private javax.swing.JCheckBox moduloRHJCheckBox;
    private javax.swing.JCheckBox moduloVentaJCheckBox;
    private javax.swing.JLabel nombreJLabel;
    private javax.swing.JTextField nombreJTextField;
    private javax.swing.JPanel opcionJPanel;
    private javax.swing.JLabel puestoJLabel;
    private javax.swing.JLabel salarioBaseJLabel;
    private javax.swing.JTextField salarioBaseJTextField;
    // End of variables declaration//GEN-END:variables
}
