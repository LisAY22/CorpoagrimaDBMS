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
public class Proveedores3 extends javax.swing.JFrame {

    private Connection conexion;
    private ResultSet credenciales;
    private ConexionProveedores proveedores;
    private int id;

    
    /**
     * Creates new form Proveedores3
     */
    public Proveedores3(Connection conexion, ResultSet credenciales) {
        this.conexion = conexion;
        this.credenciales = credenciales;
        proveedores = new ConexionProveedores();
        initComponents();
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
        Limpiar_button = new javax.swing.JButton();
        Guardar_button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Nuevo Proveedor");

        jPanel1.setBackground(new java.awt.Color(34, 85, 34));

        EditarLabel.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        EditarLabel.setForeground(new java.awt.Color(255, 255, 255));
        EditarLabel.setText("NUEVO PROVEEDOR");

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
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(Regresar_Bn, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(167, 167, 167)
                .addComponent(EditarLabel)
                .addContainerGap(331, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EditarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Regresar_Bn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        NITLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        NITLabel.setText("Nit");

        ApellidoLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ApellidoLabel.setText("Nombre");

        IDlabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        IDlabel.setText("ID");

        Empresa_textfield.setEditable(true);
        Empresa_textfield.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Empresa_textfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Empresa_textfieldActionPerformed(evt);
            }
        });

        Nombre_textfield.setEditable(true
        );
        Nombre_textfield.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        NIT_textfield.setEditable(true);
        NIT_textfield.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        NIT_textfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NIT_textfieldActionPerformed(evt);
            }
        });

        Direccion_textfield.setEditable(true);
        Direccion_textfield.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Direccion_textfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Direccion_textfieldActionPerformed(evt);
            }
        });

        CorreoLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        CorreoLabel.setText("Correo Electronico");

        Correo_textfield.setEditable(true);
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

        ID_textfield.setEditable(true);
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
                .addContainerGap(59, Short.MAX_VALUE))
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

        Limpiar_button.setText("Limpiar");
        Limpiar_button.setEnabled(true);
        Limpiar_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Limpiar_buttonMouseClicked(evt);
            }
        });

        Guardar_button.setText("Guardar");
        Guardar_button.setEnabled(true);
        Guardar_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Guardar_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Limpiar_button)
                .addGap(18, 18, 18)
                .addComponent(Guardar_button)
                .addGap(21, 21, 21))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Guardar_button)
                    .addComponent(Limpiar_button))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void Guardar_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Guardar_buttonActionPerformed
        try {
                id = Integer.parseInt(ID_textfield.getText());
                String empresa = Empresa_textfield.getText();
                String nombre = Nombre_textfield.getText();
                String direccion = Direccion_textfield.getText();
                String nit = NIT_textfield.getText();
                String correoELectronico = Correo_textfield.getText();
                

                boolean rs = proveedores.agregar(conexion, id, empresa, nombre, direccion, nit, correoELectronico);

                if (rs) {
                    JOptionPane.showMessageDialog(this, "Se ha creado un nuevo proveedor exitosamente.", "Nuevo Proveedor",
                            JOptionPane.INFORMATION_MESSAGE);
                    limpiar();
                } else {
                    JOptionPane.showMessageDialog(this, "Ha habido un error "
                            + "compruebe la información", "Nuevo Proveedor",
                            JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Proveedores3.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Ha habido un error "
                        + "compruebe la información", "Nuevo Proveedor",
                        JOptionPane.ERROR_MESSAGE);
            }
    }//GEN-LAST:event_Guardar_buttonActionPerformed

    private void Limpiar_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Limpiar_buttonMouseClicked
        // TODO add your handling code here:
        limpiar();
        JOptionPane.showMessageDialog(this, "Se han limpiado los campos exitosamente.", "Limpieza",
                JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_Limpiar_buttonMouseClicked

    private void Regresar_BnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Regresar_BnMouseClicked
        Proveedores proveedores_screen = new Proveedores(conexion, credenciales);
        proveedores_screen.setVisible(true);

        // Cerrar la ventana actual
        dispose();
    }//GEN-LAST:event_Regresar_BnMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ApellidoLabel;
    private javax.swing.JLabel CorreoLabel;
    private javax.swing.JTextField Correo_textfield;
    private javax.swing.JLabel DireccionLabel;
    private javax.swing.JTextField Direccion_textfield;
    private javax.swing.JLabel EditarLabel;
    private javax.swing.JTextField Empresa_textfield;
    private javax.swing.JButton Guardar_button;
    private javax.swing.JTextField ID_textfield;
    private javax.swing.JLabel IDlabel;
    private javax.swing.JButton Limpiar_button;
    private javax.swing.JLabel NITLabel;
    private javax.swing.JTextField NIT_textfield;
    private javax.swing.JLabel NombreLabel;
    private javax.swing.JTextField Nombre_textfield;
    private javax.swing.JButton Regresar_Bn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    // End of variables declaration//GEN-END:variables
}
