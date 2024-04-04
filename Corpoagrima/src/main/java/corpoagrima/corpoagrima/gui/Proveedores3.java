/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package corpoagrima.corpoagrima.gui;

import corpoagrima.corpoagrima.bdMariaDB.ConexionProveedores;
import java.sql.Connection;

/**
 *
 * @author lisaj
 */
public class Proveedores3 extends javax.swing.JFrame {

    private Connection conexion;
    private ConexionProveedores proveedores;
    
    /**
     * Creates new form Proveedores3
     */
    public Proveedores3(Connection conexion) {
        this.conexion = conexion;
        proveedores = new ConexionProveedores();
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
        jPanel3 = new javax.swing.JPanel();
        NITLabel = new javax.swing.JLabel();
        ApellidoLabel = new javax.swing.JLabel();
        IDlabel = new javax.swing.JLabel();
        Nombre_textfield = new javax.swing.JTextField();
        Apellido_textfield = new javax.swing.JTextField();
        NIT_textfield = new javax.swing.JTextField();
        Direccion_textfield = new javax.swing.JTextField();
        CorreoLabel = new javax.swing.JLabel();
        Correo_textfield = new javax.swing.JTextField();
        DireccionLabel = new javax.swing.JLabel();
        NombreLabel = new javax.swing.JLabel();
        ID_textfield = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        Cancel_button1 = new javax.swing.JButton();
        Limpiar_button1 = new javax.swing.JButton();
        Guardar_button1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Nuevo Proveedor");
        setPreferredSize(new java.awt.Dimension(900, 370));

        jPanel1.setBackground(new java.awt.Color(34, 85, 34));

        EditarLabel.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        EditarLabel.setForeground(new java.awt.Color(255, 255, 255));
        EditarLabel.setText("NUEVO PROVEEDOR");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(278, 278, 278)
                .addComponent(EditarLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(EditarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        NITLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        NITLabel.setText("Nit");

        ApellidoLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ApellidoLabel.setText("Nombre");

        IDlabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        IDlabel.setText("ID");

        Nombre_textfield.setEditable(true);
        Nombre_textfield.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Nombre_textfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Nombre_textfieldActionPerformed(evt);
            }
        });

        Apellido_textfield.setEditable(true
        );
        Apellido_textfield.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

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
                    .addComponent(Nombre_textfield, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                    .addComponent(Apellido_textfield)
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
                            .addComponent(Nombre_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NITLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CorreoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Apellido_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ApellidoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Correo_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        Cancel_button1.setText("Cancelar");
        Cancel_button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cancel_button1ActionPerformed(evt);
            }
        });

        Limpiar_button1.setText("Limpiar");
        Limpiar_button1.setEnabled(true);
        Limpiar_button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Limpiar_button1ActionPerformed(evt);
            }
        });

        Guardar_button1.setText("Guardar");
        Guardar_button1.setEnabled(true);
        Guardar_button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Guardar_button1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Limpiar_button1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Guardar_button1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Cancel_button1)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Limpiar_button1)
                    .addComponent(Guardar_button1)
                    .addComponent(Cancel_button1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void Nombre_textfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Nombre_textfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Nombre_textfieldActionPerformed

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

    private void Cancel_button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cancel_button1ActionPerformed
        // TODO add your handling code here:
        Proveedores proveedores_screen = new Proveedores(conexion);
        proveedores_screen.setVisible(true);
        proveedores_screen.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_Cancel_button1ActionPerformed

    private void Limpiar_button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Limpiar_button1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Limpiar_button1ActionPerformed

    private void Guardar_button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Guardar_button1ActionPerformed

    }//GEN-LAST:event_Guardar_button1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ApellidoLabel;
    private javax.swing.JTextField Apellido_textfield;
    private javax.swing.JButton Cancel_button1;
    private javax.swing.JLabel CorreoLabel;
    private javax.swing.JTextField Correo_textfield;
    private javax.swing.JLabel DireccionLabel;
    private javax.swing.JTextField Direccion_textfield;
    private javax.swing.JLabel EditarLabel;
    private javax.swing.JButton Guardar_button1;
    private javax.swing.JTextField ID_textfield;
    private javax.swing.JLabel IDlabel;
    private javax.swing.JButton Limpiar_button1;
    private javax.swing.JLabel NITLabel;
    private javax.swing.JTextField NIT_textfield;
    private javax.swing.JLabel NombreLabel;
    private javax.swing.JTextField Nombre_textfield;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    // End of variables declaration//GEN-END:variables
}
