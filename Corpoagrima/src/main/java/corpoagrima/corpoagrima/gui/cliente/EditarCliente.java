/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package corpoagrima.corpoagrima.gui.cliente;

import corpoagrima.corpoagrima.bdMariaDB.ConexionCliente;
import corpoagrima.corpoagrima.bdMariaDB.ConexionTelefono;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author karol
 * @author Diana
 * 
 */
public class EditarCliente extends javax.swing.JFrame{

    private Connection conexion;
    private ResultSet credenciales;
    private ConexionCliente clientes;
    private ConexionTelefono Telefono;
    private int id;
    private int idTelefono;
    
    /**
     * Creates new form clientes2
     */
    public EditarCliente(Connection conexion, ResultSet credenciales) {
        this.conexion = conexion;
        this.credenciales = credenciales;
        clientes = new ConexionCliente();
        Telefono = new ConexionTelefono();
        
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
        
    private void habilitar(){
        Nombre_textfield.setEditable(true);
        Apellido_textfield.setEditable(true);
        NIT_textfield.setEditable(true);
        Direccion_textfield.setEditable(true);
        Correo_textfield.setEditable(true);
        telefono_textfield1.setEditable(true);
        Destacado_checkBox.setEnabled(true);
        Limpiar_button.setEnabled(true);
        Guardar_button.setEnabled(true);
        Buscar_Button.setEnabled(false);
        Buscar_textField.setEnabled(false);
    }
    
    private void deshabilitar(){
        Nombre_textfield.setEditable(false);
        Apellido_textfield.setEditable(false);
        NIT_textfield.setEditable(false);
        Direccion_textfield.setEditable(false);
        Cantidadcompras_textfield.setEditable(false);
        Correo_textfield.setEditable(false);
        telefono_textfield1.setEditable(false);
        Destacado_checkBox.setEnabled(false);
        Eliminar_button.setEnabled(false);
        Limpiar_button.setEnabled(false);
        Guardar_button.setEnabled(false);
        Buscar_Button.setEnabled(true);
        Buscar_textField.setEnabled(true);
        
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
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
        Nombre_textfield = new javax.swing.JTextField();
        Apellido_textfield = new javax.swing.JTextField();
        NIT_textfield = new javax.swing.JTextField();
        Direccion_textfield = new javax.swing.JTextField();
        CantidadComprasLabel = new javax.swing.JLabel();
        Cantidadcompras_textfield = new javax.swing.JTextField();
        CorreoLabel = new javax.swing.JLabel();
        Correo_textfield = new javax.swing.JTextField();
        DireccionLabel = new javax.swing.JLabel();
        NombreLabel = new javax.swing.JLabel();
        ID_textfield = new javax.swing.JTextField();
        Destacado_checkBox = new javax.swing.JCheckBox();
        CorreoLabel1 = new javax.swing.JLabel();
        telefono_textfield1 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        Limpiar_button = new javax.swing.JButton();
        Guardar_button = new javax.swing.JButton();
        Eliminar_button = new javax.swing.JButton();

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("Nombre");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Editar Cliente");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(34, 85, 34));

        EditarLabel.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        EditarLabel.setForeground(new java.awt.Color(255, 255, 255));
        EditarLabel.setText("EDITAR CLIENTE");

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
                .addGap(168, 168, 168)
                .addComponent(EditarLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        ApellidoLabel.setText("Apellido");

        IDlabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        IDlabel.setText("ID");

        Nombre_textfield.setEditable(false);
        Nombre_textfield.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Nombre_textfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Nombre_textfieldActionPerformed(evt);
            }
        });

        Apellido_textfield.setEditable(false);
        Apellido_textfield.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

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

        CantidadComprasLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        CantidadComprasLabel.setText("Cantidad de compras ");

        Cantidadcompras_textfield.setEditable(false);
        Cantidadcompras_textfield.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Cantidadcompras_textfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cantidadcompras_textfieldActionPerformed(evt);
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
        NombreLabel.setText("Nombre");

        ID_textfield.setEditable(false);
        ID_textfield.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ID_textfield.setEnabled(false);
        ID_textfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ID_textfieldActionPerformed(evt);
            }
        });

        Destacado_checkBox.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Destacado_checkBox.setText("Destacado");
        Destacado_checkBox.setEnabled(false);
        Destacado_checkBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Destacado_checkBoxActionPerformed(evt);
            }
        });

        CorreoLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        CorreoLabel1.setText("Telefono");

        telefono_textfield1.setEditable(false);
        telefono_textfield1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        telefono_textfield1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telefono_textfield1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Destacado_checkBox)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(IDlabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ApellidoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                .addComponent(NombreLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(NITLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Nombre_textfield, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                            .addComponent(Apellido_textfield)
                            .addComponent(NIT_textfield)
                            .addComponent(ID_textfield))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DireccionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(CorreoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Correo_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Direccion_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(telefono_textfield1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(CantidadComprasLabel)
                                    .addGap(18, 18, 18)
                                    .addComponent(Cantidadcompras_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(CorreoLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(Direccion_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Cantidadcompras_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                            .addComponent(CantidadComprasLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Correo_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Apellido_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ApellidoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(CorreoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NITLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(NIT_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(CorreoLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(telefono_textfield1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(Destacado_checkBox, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
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
        Guardar_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Guardar_buttonActionPerformed(evt);
            }
        });

        Eliminar_button.setBackground(new java.awt.Color(255, 51, 51));
        Eliminar_button.setText("Eliminar");
        Eliminar_button.setEnabled(false);
        Eliminar_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Eliminar_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Eliminar_button)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                    .addComponent(Eliminar_button))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void limpiar(){
        ID_textfield.setText("");
        Nombre_textfield.setText("");
        Apellido_textfield.setText("");
        NIT_textfield.setText("");
        Direccion_textfield.setText("");
        Cantidadcompras_textfield.setText("");
        Correo_textfield.setText("");
        telefono_textfield1.setText("");
    }      
    private void Buscar_textFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Buscar_textFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Buscar_textFieldActionPerformed

    private void Eliminar_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Eliminar_buttonActionPerformed
        try {
            int opcion = JOptionPane.showConfirmDialog(null,
                    "¿Quieres continuar?\nSe eliminara el cliente permanentemente",
                    "Eliminar Cliente", JOptionPane.YES_NO_OPTION);

            // Comprobar la opción seleccionada
            if (opcion == JOptionPane.YES_OPTION) {
                boolean resultSet = clientes.eliminar(conexion, id);
                boolean resultTelefono = Telefono.eliminar(conexion, idTelefono);
                if (resultSet) {
                    JOptionPane.showMessageDialog(this,
                            "Se ha eliminado exitosamente el cliente.",
                            "Eliminar Cliente", JOptionPane.INFORMATION_MESSAGE);
                    deshabilitar();
                    limpiar();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(EditarCliente.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "ERROR "
                    + "compruebe la información", "Eliminar Cliente",
                    JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_Eliminar_buttonActionPerformed

    private void Correo_textfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Correo_textfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Correo_textfieldActionPerformed

    private void Direccion_textfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Direccion_textfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Direccion_textfieldActionPerformed

    private void NIT_textfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NIT_textfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NIT_textfieldActionPerformed

    private void Nombre_textfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Nombre_textfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Nombre_textfieldActionPerformed

    private void Cantidadcompras_textfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cantidadcompras_textfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Cantidadcompras_textfieldActionPerformed

    private void ID_textfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ID_textfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ID_textfieldActionPerformed

    private void Destacado_checkBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Destacado_checkBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Destacado_checkBoxActionPerformed

    private void Limpiar_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Limpiar_buttonActionPerformed
        // TODO add your handling code here:
        deshabilitar();
        limpiar();
        Destacado_checkBox.setSelected(false);
        JOptionPane.showMessageDialog(this, "Se han limpiado los campos exitosamente.", "Limpieza",
                JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_Limpiar_buttonActionPerformed

    private void Buscar_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Buscar_ButtonActionPerformed
        try {
                String textoBusqueda = Buscar_textField.getText().trim();

                if (textoBusqueda != null && !textoBusqueda.isEmpty()) {
                    ResultSet rs = clientes.busqueda2(conexion, textoBusqueda);
                    if (rs.next()) {
                        id = rs.getInt("ID_Cliente");
                        String nombre = rs.getString("Nombre");
                        String apellido = rs.getString("Apellido");
                        String nit = rs.getString("NIT");
                        String correoElectronico = rs.getString("CorreoElectronico");
                        String direccion = rs.getString("Direccion");
                        int destacado = rs.getInt("Cliente_destacado");
                        int cantCompras = rs.getInt("Cantidad_compras");
                        
                        if (destacado == 1) {
                            // Si el número es 1, marcamos el checkbox como seleccionado
                            Destacado_checkBox.setSelected(true);
                        } else {
                            // Si el número no es 1, no marcamos el checkbox
                            Destacado_checkBox.setSelected(false);
                        }

                        // Cuarta consulta para obtener el numero de telefono
                        ResultSet resultadoTelefono = Telefono.telefono(conexion, id, "Cliente");

                        if (resultadoTelefono.next()) { // Verificar si hay resultados antes de acceder a ellos
                            idTelefono = resultadoTelefono.getInt("ID_Telefono");
                            String telefono = resultadoTelefono.getString("Numero");

                            // Insertar en los textfield la informacion y habilitarlos
                            ID_textfield.setText(String.valueOf(id));
                            Nombre_textfield.setText(nombre);
                            Apellido_textfield.setText(apellido);
                            NIT_textfield.setText(nit);
                            Correo_textfield.setText(correoElectronico);
                            Direccion_textfield.setText(direccion);
                            Cantidadcompras_textfield.setText(String.valueOf(cantCompras));
                            telefono_textfield1.setText(telefono);


                            JOptionPane.showMessageDialog(this, "La busqueda ha sido exitosa",
                                    "Busqueda", JOptionPane.INFORMATION_MESSAGE);
                            habilitar();
                            Eliminar_button.setEnabled(true);

                          
                        } else {
                            JOptionPane.showMessageDialog(null, "No se encontró ningún resultado para el número de teléfono.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        
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
                Logger.getLogger(EditarCliente.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Ha habido un error "
                        + "compruebe la información", "Busqueda",
                        JOptionPane.ERROR_MESSAGE);
            }
    }//GEN-LAST:event_Buscar_ButtonActionPerformed

    private void Guardar_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Guardar_buttonActionPerformed
            try {
                id = Integer.parseInt(ID_textfield.getText());
                String nombre = Nombre_textfield.getText();
                String apellido = Apellido_textfield.getText();
                String nit = NIT_textfield.getText();
                String correoELectronico = Correo_textfield.getText();
                String direccion = Direccion_textfield.getText();
                int cantCompras = Integer.parseInt(Cantidadcompras_textfield.getText());
                String telefono = telefono_textfield1.getText();
                boolean destacado;
                destacado = Destacado_checkBox.isSelected();
                
                boolean resultTelefono = Telefono.actualizar(conexion, telefono, idTelefono);
                boolean rs = clientes.actualizar(conexion, id, nombre, apellido, nit, correoELectronico, 
                        direccion, destacado, cantCompras);
                if (rs && resultTelefono) {
                    JOptionPane.showMessageDialog(this,
                            "Se ha guardado exitosamente el cliente.",
                            "Guardar Cliente", JOptionPane.INFORMATION_MESSAGE);
                    deshabilitar();
                    limpiar();
                }
            } catch (SQLException ex) {
                Logger.getLogger(EditarCliente.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Ha habido un error "
                        + "compruebe la información", "Guardar Cliente",
                        JOptionPane.ERROR_MESSAGE);
            }
    }//GEN-LAST:event_Guardar_buttonActionPerformed

    private void Regresar_BnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Regresar_BnMouseClicked
        // TODO add your handling code here:
        Cliente principal_screen = new Cliente(conexion, credenciales);
        principal_screen.setVisible(true);
        principal_screen.setLocationRelativeTo(null);
        // Cerrar la ventana actual
        dispose();
    }//GEN-LAST:event_Regresar_BnMouseClicked

    private void Regresar_BnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Regresar_BnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Regresar_BnActionPerformed

    private void telefono_textfield1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telefono_textfield1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telefono_textfield1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ApellidoLabel;
    private javax.swing.JTextField Apellido_textfield;
    private javax.swing.JButton Buscar_Button;
    private javax.swing.JTextField Buscar_textField;
    private javax.swing.JLabel CantidadComprasLabel;
    private javax.swing.JTextField Cantidadcompras_textfield;
    private javax.swing.JLabel CorreoLabel;
    private javax.swing.JLabel CorreoLabel1;
    private javax.swing.JTextField Correo_textfield;
    private javax.swing.JCheckBox Destacado_checkBox;
    private javax.swing.JLabel DireccionLabel;
    private javax.swing.JTextField Direccion_textfield;
    private javax.swing.JLabel EditarLabel;
    private javax.swing.JButton Eliminar_button;
    private javax.swing.JButton Guardar_button;
    private javax.swing.JTextField ID_textfield;
    private javax.swing.JLabel IDlabel;
    private javax.swing.JButton Limpiar_button;
    private javax.swing.JLabel NITLabel;
    private javax.swing.JTextField NIT_textfield;
    private javax.swing.JLabel NombreLabel;
    private javax.swing.JTextField Nombre_textfield;
    private javax.swing.JButton Regresar_Bn;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField telefono_textfield1;
    // End of variables declaration//GEN-END:variables
}