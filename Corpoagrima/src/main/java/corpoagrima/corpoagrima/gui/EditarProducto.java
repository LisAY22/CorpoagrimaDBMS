/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package corpoagrima.corpoagrima.gui;

import corpoagrima.corpoagrima.bdMariaDB.ConexionProducto;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author lisaj
 */
public class EditarProducto extends javax.swing.JFrame {
    
    private Connection conexion;
    private ResultSet credenciales;
    private ConexionProducto inventario;
    private int id;
    
    /**
     * Creates new form EditarProducto
     */
    public EditarProducto(Connection conexion, ResultSet credenciales) {
        this.conexion = conexion;
        this.credenciales = credenciales;
        inventario = new ConexionProducto();
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
        jPanel4 = new javax.swing.JPanel();
        Limpiar_button = new javax.swing.JButton();
        Guardar_button = new javax.swing.JButton();
        Eliminar_button1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        nombre_jLabel1 = new javax.swing.JLabel();
        nombre_jTextField1 = new javax.swing.JTextField();
        marca_jLabel2 = new javax.swing.JLabel();
        marca_jTextField2 = new javax.swing.JTextField();
        fechaV_jLabel2 = new javax.swing.JLabel();
        fechaV_jTextField3 = new javax.swing.JTextField();
        categoria_jLabel2 = new javax.swing.JLabel();
        categoria_jTextField2 = new javax.swing.JTextField();
        unidadM_jLabel3 = new javax.swing.JLabel();
        unidadM_jTextField3 = new javax.swing.JTextField();
        precioV_jLabel4 = new javax.swing.JLabel();
        precioV_jTextField4 = new javax.swing.JTextField();
        cantidad_jLabel3 = new javax.swing.JLabel();
        cantidad_jTextField4 = new javax.swing.JTextField();
        nombre_jLabel2 = new javax.swing.JLabel();
        descripcion_jTextField4 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        Buscar_textField = new javax.swing.JTextField();
        Buscar_Button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(34, 85, 34));

        EditarLabel.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        EditarLabel.setForeground(new java.awt.Color(255, 255, 255));
        EditarLabel.setText("EDITAR PRODUCTO");

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
                .addGap(39, 39, 39)
                .addComponent(Regresar_Bn, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(136, 136, 136)
                .addComponent(EditarLabel)
                .addContainerGap(198, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Regresar_Bn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EditarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(218, 218, 218))
        );

        Limpiar_button.setText("Limpiar");
        Limpiar_button.setEnabled(false);
        Limpiar_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Limpiar_buttonActionPerformed(evt);
            }
        });

        Guardar_button.setText("Guardar");
        Guardar_button.setEnabled(false);

        Eliminar_button1.setText("Eliminar");
        Eliminar_button1.setEnabled(false);
        Eliminar_button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Eliminar_button1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Eliminar_button1)
                .addGap(18, 18, 18)
                .addComponent(Limpiar_button)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Guardar_button)
                .addGap(15, 15, 15))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Guardar_button)
                    .addComponent(Limpiar_button)
                    .addComponent(Eliminar_button1))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        nombre_jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        nombre_jLabel1.setText("Nombre");

        nombre_jTextField1.setEditable(false);
        nombre_jTextField1.setToolTipText("");
        nombre_jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombre_jTextField1ActionPerformed(evt);
            }
        });

        marca_jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        marca_jLabel2.setText("Marca");

        marca_jTextField2.setEditable(false);
        marca_jTextField2.setToolTipText("");
        marca_jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                marca_jTextField2ActionPerformed(evt);
            }
        });

        fechaV_jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        fechaV_jLabel2.setText("Fecha de Vencimiento");

        fechaV_jTextField3.setEditable(false);
        fechaV_jTextField3.setToolTipText("");
        fechaV_jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fechaV_jTextField3ActionPerformed(evt);
            }
        });

        categoria_jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        categoria_jLabel2.setText("Categoria");

        categoria_jTextField2.setEditable(false);
        categoria_jTextField2.setToolTipText("");
        categoria_jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoria_jTextField2ActionPerformed(evt);
            }
        });

        unidadM_jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        unidadM_jLabel3.setText("Unidad de Medida");

        unidadM_jTextField3.setEditable(false);
        unidadM_jTextField3.setToolTipText("");
        unidadM_jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unidadM_jTextField3ActionPerformed(evt);
            }
        });

        precioV_jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        precioV_jLabel4.setText("Precio de Venta");

        precioV_jTextField4.setEditable(false);
        precioV_jTextField4.setText("0");
        precioV_jTextField4.setToolTipText("");
        precioV_jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                precioV_jTextField4ActionPerformed(evt);
            }
        });

        cantidad_jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cantidad_jLabel3.setText("Cantidad");

        cantidad_jTextField4.setEditable(false);
        cantidad_jTextField4.setText("0");
        cantidad_jTextField4.setToolTipText("");
        cantidad_jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cantidad_jTextField4ActionPerformed(evt);
            }
        });

        nombre_jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        nombre_jLabel2.setText("Descripción");

        descripcion_jTextField4.setEditable(false);
        descripcion_jTextField4.setToolTipText("");
        descripcion_jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descripcion_jTextField4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(nombre_jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(descripcion_jTextField4))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cantidad_jLabel3)
                        .addGap(27, 27, 27)
                        .addComponent(cantidad_jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(fechaV_jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(fechaV_jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(precioV_jLabel4))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nombre_jLabel1)
                                    .addComponent(marca_jLabel2))
                                .addGap(29, 29, 29)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(marca_jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(unidadM_jLabel3))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(nombre_jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(195, 195, 195)
                                        .addComponent(categoria_jLabel2)))))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(categoria_jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(unidadM_jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(precioV_jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombre_jLabel1)
                    .addComponent(nombre_jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(categoria_jLabel2)
                    .addComponent(categoria_jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(unidadM_jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(marca_jLabel2)
                        .addComponent(marca_jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(unidadM_jLabel3)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fechaV_jLabel2)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fechaV_jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(precioV_jLabel4)
                        .addComponent(precioV_jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cantidad_jLabel3)
                    .addComponent(cantidad_jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nombre_jLabel2)
                    .addComponent(descripcion_jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        Buscar_textField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        Buscar_Button.setBackground(new java.awt.Color(136, 213, 133));
        Buscar_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lupa.png"))); // NOI18N
        Buscar_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Buscar_ButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(Buscar_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Buscar_textField, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Buscar_Button, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(Buscar_textField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void limpiar(){
        nombre_jTextField1.setText("");
        marca_jTextField2.setText("");
        fechaV_jTextField3.setText("");
        cantidad_jTextField4.setText("");
        categoria_jTextField2.setText("");
        unidadM_jTextField3.setText("");
        precioV_jTextField4.setText("");
        descripcion_jTextField4.setText("");
    } 
    
    private void habilitar(){
        nombre_jTextField1.setEditable(true);
        marca_jTextField2.setEditable(true);
        fechaV_jTextField3.setEditable(true);
        cantidad_jTextField4.setEditable(true);
        categoria_jTextField2.setEditable(true);
        unidadM_jTextField3.setEditable(true);
        precioV_jTextField4.setEditable(true);
        descripcion_jTextField4.setEditable(true);
        Limpiar_button.setEnabled(true);
        Guardar_button.setEnabled(true);
        Buscar_Button.setEnabled(false);
        Buscar_textField.setEnabled(false);
        Eliminar_button1.setEnabled(true);
    }
    
    private void desabilitar(){
        nombre_jTextField1.setEditable(false);
        marca_jTextField2.setEditable(false);
        fechaV_jTextField3.setEditable(false);
        cantidad_jTextField4.setEditable(false);
        categoria_jTextField2.setEditable(false);
        unidadM_jTextField3.setEditable(false);
        precioV_jTextField4.setEditable(false);
        descripcion_jTextField4.setEditable(false);
        Limpiar_button.setEnabled(false);
        Guardar_button.setEnabled(false);
        Buscar_Button.setEnabled(true);
        Buscar_textField.setEnabled(true);
        Eliminar_button1.setEnabled(false);
    }
    
    private void nombre_jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombre_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombre_jTextField1ActionPerformed

    private void marca_jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_marca_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_marca_jTextField2ActionPerformed

    private void fechaV_jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fechaV_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fechaV_jTextField3ActionPerformed

    private void categoria_jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoria_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_categoria_jTextField2ActionPerformed

    private void unidadM_jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unidadM_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_unidadM_jTextField3ActionPerformed

    private void precioV_jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_precioV_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_precioV_jTextField4ActionPerformed

    private void cantidad_jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cantidad_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cantidad_jTextField4ActionPerformed

    private void Eliminar_button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Eliminar_button1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Eliminar_button1ActionPerformed

    private void Limpiar_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Limpiar_buttonActionPerformed
        // TODO add your handling code here:
        limpiar();
        JOptionPane.showMessageDialog(this, "Se han limpiado los campos exitosamente.", "Limpieza",
            JOptionPane.INFORMATION_MESSAGE);
        desabilitar();
    }//GEN-LAST:event_Limpiar_buttonActionPerformed

    private void Regresar_BnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Regresar_BnActionPerformed
        // TODO add your handling code here:
        Inventario inventario_screen = new Inventario(conexion, credenciales);
        inventario_screen.setVisible(true);
        dispose();
    }//GEN-LAST:event_Regresar_BnActionPerformed

    private void descripcion_jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descripcion_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_descripcion_jTextField4ActionPerformed

    private void Buscar_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Buscar_ButtonActionPerformed
        // TODO add your handling code here:
        try {
            String texto_busqueda = Buscar_textField.getText().trim();
            
            if (texto_busqueda != null && !texto_busqueda.isEmpty()) {
                ResultSet ResultB = inventario.busqueda(conexion, texto_busqueda);
                if (ResultB.next()) {
                    id = ResultB.getInt("ID_Producto");
                    String nombre = ResultB.getString("Nombre");
                    String marca = ResultB.getString("Marca");
                    String fechaVen = ResultB.getString("Fecha_Vencimiento");
                    int cantidad = ResultB.getInt("Stock");
                    String categoria =  ResultB.getString("Categoria");
                    String unidad_Med = ResultB.getString("Unidad_Medida");
                    float precioVen = ResultB.getFloat("Precio_Venta");
                    String descripcion = ResultB.getString("Descripcion");
                    
                    nombre_jTextField1.setText(nombre);
                    marca_jTextField2.setText(marca);
                    fechaV_jTextField3.setText(fechaVen);
                    cantidad_jTextField4.setText(String.valueOf(cantidad));
                    categoria_jTextField2.setText(categoria);
                    unidadM_jTextField3.setText(unidad_Med);
                    precioV_jTextField4.setText(String.valueOf(precioVen));
                    descripcion_jTextField4.setText(descripcion);
                    
                    JOptionPane.showMessageDialog(this, "La busqueda ha sido exitosa",
                                "Busqueda", JOptionPane.INFORMATION_MESSAGE);
                    habilitar();
                } else {
                        JOptionPane.showMessageDialog(this, "No se encontraron resultados",
                                "Busqueda", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                    JOptionPane.showMessageDialog(this, "ERROR"
                            + "compruebe el codigo ingresado", "Busqueda",
                            JOptionPane.ERROR_MESSAGE);
                }
        } catch (SQLException ex) {
                Logger.getLogger(Inventario.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Ha habido un error "
                        + "compruebe la información", "Busqueda",
                        JOptionPane.ERROR_MESSAGE);
            }
    }//GEN-LAST:event_Buscar_ButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Buscar_Button;
    private javax.swing.JTextField Buscar_textField;
    private javax.swing.JLabel EditarLabel;
    private javax.swing.JButton Eliminar_button1;
    private javax.swing.JButton Guardar_button;
    private javax.swing.JButton Limpiar_button;
    private javax.swing.JButton Regresar_Bn;
    private javax.swing.JLabel cantidad_jLabel3;
    private javax.swing.JTextField cantidad_jTextField4;
    private javax.swing.JLabel categoria_jLabel2;
    javax.swing.JTextField categoria_jTextField2;
    private javax.swing.JTextField descripcion_jTextField4;
    private javax.swing.JLabel fechaV_jLabel2;
    private javax.swing.JTextField fechaV_jTextField3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel marca_jLabel2;
    private javax.swing.JTextField marca_jTextField2;
    private javax.swing.JLabel nombre_jLabel1;
    private javax.swing.JLabel nombre_jLabel2;
    private javax.swing.JTextField nombre_jTextField1;
    private javax.swing.JLabel precioV_jLabel4;
    javax.swing.JTextField precioV_jTextField4;
    private javax.swing.JLabel unidadM_jLabel3;
    javax.swing.JTextField unidadM_jTextField3;
    // End of variables declaration//GEN-END:variables
}
