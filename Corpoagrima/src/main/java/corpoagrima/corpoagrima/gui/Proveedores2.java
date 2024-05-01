/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package corpoagrima.corpoagrima.gui;

import corpoagrima.corpoagrima.bdMariaDB.ConexionProveedores;
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
public class Proveedores2 extends javax.swing.JFrame {

    private Connection conexion;
    private ResultSet credenciales;
    private ConexionProveedores proveedores;
    private int id;

    /**
     * Creates new form Proveedores2
     */
    public Proveedores2(Connection conexion, ResultSet credenciales) {
        this.conexion = conexion;
        this.credenciales = credenciales;
        proveedores = new ConexionProveedores();
        initComponents();
    }

    private void habilitar(){
        ID_textfield.setEditable(true);
        Empresa_textfield.setEditable(true);
        Nombre_textfield.setEditable(true);
        NIT_textfield.setEditable(true);
        Direccion_textfield.setEditable(true);
        Correo_textfield.setEditable(true);
        Limpiar_button1.setEnabled(true);
        Guardar_button1.setEnabled(true);
        Eliminar_button1.setEnabled(true);
        Buscar_Button.setEnabled(false);
        Buscar_textField.setEnabled(false);
    }
    
    private void deshabilitar(){
        ID_textfield.setEditable(false);
        Empresa_textfield.setEditable(false);
        Nombre_textfield.setEditable(false);
        NIT_textfield.setEditable(false);
        Direccion_textfield.setEditable(false);
        Correo_textfield.setEditable(false);
        Limpiar_button1.setEnabled(false);
        Guardar_button1.setEnabled(false);
        Eliminar_button1.setEnabled(false);
        Buscar_Button.setEnabled(true);
        Buscar_textField.setEnabled(true);
    }
    
    private void limpiar(){
        ID_textfield.setText("");
        Empresa_textfield.setText("");
        Nombre_textfield.setText("");
        NIT_textfield.setText("");
        Direccion_textfield.setText("");
        Correo_textfield.setText("");
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
        jPanel2 = new javax.swing.JPanel();
        Buscar_textField = new javax.swing.JTextField();
        Buscar_Button = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        NITLabel = new javax.swing.JLabel();
        ApellidoLabel = new javax.swing.JLabel();
        IDlabel = new javax.swing.JLabel();
        Empresa_textfield = new javax.swing.JTextField();
        Nombre_textfield = new javax.swing.JTextField();
        NIT_textfield = new javax.swing.JTextField();
        Direccion_textfield = new javax.swing.JTextField();
        CorreoLabel = new javax.swing.JLabel();
        Correo_textfield = new javax.swing.JTextField();
        DireccionLabel = new javax.swing.JLabel();
        NombreLabel = new javax.swing.JLabel();
        ID_textfield = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        Limpiar_button1 = new javax.swing.JButton();
        Guardar_button1 = new javax.swing.JButton();
        Eliminar_button1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Editar Proveedor");

        jPanel1.setBackground(new java.awt.Color(34, 85, 34));

        EditarLabel.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        EditarLabel.setForeground(new java.awt.Color(255, 255, 255));
        EditarLabel.setText("EDITAR PROVEEDOR");

        Regresar_Bn.setBackground(new java.awt.Color(34, 85, 34));
        Regresar_Bn.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Regresar_Bn.setForeground(new java.awt.Color(255, 255, 255));
        Regresar_Bn.setText("←");
        Regresar_Bn.setBorderPainted(false);
        Regresar_Bn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Regresar_BnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(Regresar_Bn, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(EditarLabel)
                .addGap(279, 279, 279))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EditarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Regresar_Bn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        Buscar_textField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Buscar_textField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Buscar_textFieldActionPerformed(evt);
            }
        });

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
                .addContainerGap(577, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Buscar_Button, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(Buscar_textField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        NITLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        NITLabel.setText("Nit");

        ApellidoLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ApellidoLabel.setText("Nombre");

        IDlabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        IDlabel.setText("ID");

        Empresa_textfield.setEditable(false);
        Empresa_textfield.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Empresa_textfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Empresa_textfieldActionPerformed(evt);
            }
        });

        Nombre_textfield.setEditable(false);
        Nombre_textfield.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        NIT_textfield.setEditable(false);
        NIT_textfield.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        NIT_textfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NIT_textfieldActionPerformed(evt);
            }
        });

        Direccion_textfield.setEditable(false);
        Direccion_textfield.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Direccion_textfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Direccion_textfieldActionPerformed(evt);
            }
        });

        CorreoLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        CorreoLabel.setText("Correo Electronico");

        Correo_textfield.setEditable(false);
        Correo_textfield.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Correo_textfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Correo_textfieldActionPerformed(evt);
            }
        });

        DireccionLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        DireccionLabel.setText("Dirección");

        NombreLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        NombreLabel.setText("Empresa");

        ID_textfield.setEditable(false);
        ID_textfield.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ID_textfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ID_textfieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(IDlabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ApellidoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(NombreLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Empresa_textfield, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                    .addComponent(Nombre_textfield)
                    .addComponent(ID_textfield))
                .addGap(88, 88, 88)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NITLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DireccionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CorreoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NIT_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Direccion_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Correo_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(Direccion_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NIT_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(DireccionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IDlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ID_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NombreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Empresa_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NITLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CorreoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Nombre_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ApellidoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Correo_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        Limpiar_button1.setText("Limpiar");
        Limpiar_button1.setEnabled(false);
        Limpiar_button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Limpiar_button1ActionPerformed(evt);
            }
        });

        Guardar_button1.setText("Guardar");
        Guardar_button1.setEnabled(false);
        Guardar_button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Guardar_button1ActionPerformed(evt);
            }
        });

        Eliminar_button1.setBackground(new java.awt.Color(255, 51, 51));
        Eliminar_button1.setText("Eliminar");
        Eliminar_button1.setEnabled(false);
        Eliminar_button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Eliminar_button1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Eliminar_button1)
                .addGap(18, 18, 18)
                .addComponent(Limpiar_button1)
                .addGap(18, 18, 18)
                .addComponent(Guardar_button1)
                .addGap(18, 18, 18))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Guardar_button1)
                    .addComponent(Limpiar_button1)
                    .addComponent(Eliminar_button1))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Buscar_textFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Buscar_textFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Buscar_textFieldActionPerformed

    private void Buscar_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Buscar_ButtonActionPerformed
        try {
                String textoBusqueda = Buscar_textField.getText().trim();

                if (textoBusqueda != null && !textoBusqueda.isEmpty()) {
                    ResultSet rs = proveedores.busqueda2(conexion, textoBusqueda);
                    if (rs.next()) {
                        id = rs.getInt("ID_Proveedor");
                        String empresa = rs.getString("Empresa");
                        String nombre = rs.getString("Nombre");
                        String direccion = rs.getString("Direccion");
                        String nit = rs.getString("Nit");
                        String correoElectronico = rs.getString("Correo_Electronico");

                        ID_textfield.setText(String.valueOf(id));
                        Empresa_textfield.setText(empresa);
                        Nombre_textfield.setText(nombre);
                        NIT_textfield.setText(nit);
                        Correo_textfield.setText(correoElectronico);
                        Direccion_textfield.setText(direccion);
                        
                        JOptionPane.showMessageDialog(this, "La busqueda ha sido exitosa",
                                "Busqueda", JOptionPane.INFORMATION_MESSAGE);
                        habilitar();
                        Eliminar_button1.setEnabled(true);
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
                Logger.getLogger(Proveedores2.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Ha habido un error "
                        + "compruebe la información", "Busqueda",
                        JOptionPane.ERROR_MESSAGE);
            }
    }//GEN-LAST:event_Buscar_ButtonActionPerformed

    private void Empresa_textfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Empresa_textfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Empresa_textfieldActionPerformed

    private void NIT_textfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NIT_textfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NIT_textfieldActionPerformed

    private void Direccion_textfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Direccion_textfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Direccion_textfieldActionPerformed

    private void Correo_textfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Correo_textfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Correo_textfieldActionPerformed

    private void ID_textfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ID_textfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ID_textfieldActionPerformed

    private void Limpiar_button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Limpiar_button1ActionPerformed
        // TODO add your handling code here:
        deshabilitar();
        limpiar();
        JOptionPane.showMessageDialog(this, "Se han limpiado los campos exitosamente.", "Limpieza",
                JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_Limpiar_button1ActionPerformed

    private void Guardar_button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Guardar_button1ActionPerformed
        try {
                id = Integer.parseInt(ID_textfield.getText());
                String empresa = Empresa_textfield.getText();
                String nombre = Nombre_textfield.getText();
                String direccion = Direccion_textfield.getText();
                String nit = NIT_textfield.getText();
                String correoELectronico = Correo_textfield.getText();

                boolean rs = proveedores.actualizar(conexion, id, empresa, nombre, direccion, nit, correoELectronico);
                if (rs) {
                    JOptionPane.showMessageDialog(this,
                            "Se ha guardado exitosamente el Proveedor.",
                            "Guardar Proveedor", JOptionPane.INFORMATION_MESSAGE);
                    deshabilitar();
                    limpiar();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Proveedores2.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Ha habido un error "
                        + "compruebe la información", "Guardar Proveedor",
                        JOptionPane.ERROR_MESSAGE);
            }     
    }//GEN-LAST:event_Guardar_button1ActionPerformed

    private void Eliminar_button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Eliminar_button1ActionPerformed
        try {
            int opcion = JOptionPane.showConfirmDialog(null,
                    "¿Quieres continuar?\nSe eliminara el proveedor permanentemente",
                    "Eliminar Proveedor", JOptionPane.YES_NO_OPTION);

            // Comprobar la opción seleccionada
            if (opcion == JOptionPane.YES_OPTION) {
                boolean resultSet = proveedores.eliminar(conexion, id);
                if (resultSet) {
                    JOptionPane.showMessageDialog(this,
                            "Se ha eliminado exitosamente el Proveedor.",
                            "Eliminar Proveedor", JOptionPane.INFORMATION_MESSAGE);
                    deshabilitar();
                    limpiar();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(Proveedores2.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "ERROR "
                    + "compruebe la información", "Eliminar Proveedor",
                    JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_Eliminar_button1ActionPerformed

    private void Regresar_BnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Regresar_BnMouseClicked
        Proveedores proveedores_screen = new Proveedores(conexion, credenciales);
        proveedores_screen.setVisible(true);
        
        // Cerrar la ventana actual
        dispose();
    }//GEN-LAST:event_Regresar_BnMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ApellidoLabel;
    private javax.swing.JButton Buscar_Button;
    private javax.swing.JTextField Buscar_textField;
    private javax.swing.JLabel CorreoLabel;
    private javax.swing.JTextField Correo_textfield;
    private javax.swing.JLabel DireccionLabel;
    private javax.swing.JTextField Direccion_textfield;
    private javax.swing.JLabel EditarLabel;
    private javax.swing.JButton Eliminar_button1;
    private javax.swing.JTextField Empresa_textfield;
    private javax.swing.JButton Guardar_button1;
    private javax.swing.JTextField ID_textfield;
    private javax.swing.JLabel IDlabel;
    private javax.swing.JButton Limpiar_button1;
    private javax.swing.JLabel NITLabel;
    private javax.swing.JTextField NIT_textfield;
    private javax.swing.JLabel NombreLabel;
    private javax.swing.JTextField Nombre_textfield;
    private javax.swing.JButton Regresar_Bn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    // End of variables declaration//GEN-END:variables
}
