/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package corpoagrima.corpoagrima.gui;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author lisaj
 */
public class Principal extends javax.swing.JFrame {
    
    /**
     * Creates new form principal
     */
    private Connection conexion;
    private ResultSet credenciales;
    
    public Principal(Connection conexion, ResultSet credenciales) throws SQLException {
        this.conexion = conexion;
        this.credenciales = credenciales;
        initComponents();
        boolean permisoInventario = credenciales.getBoolean("Modulo_Inventario");
        boolean permisoCliente = credenciales.getBoolean("Modulo_Cliente");
        boolean permisoRH = credenciales.getBoolean("Modulo_RH");
        boolean permisoProveedores = credenciales.getBoolean("Modulo_Proveedores");
        boolean permisoRegCompra = credenciales.getBoolean("Modulo_Reg_Compra");
        boolean permisoRegVenta = credenciales.getBoolean("Modulo_Reg_Venta");
        boolean permisoFinanciero = credenciales.getBoolean("Modulo_Financiero");
        inventarioJButton.setEnabled(permisoInventario);
        clientesJButton.setEnabled(permisoCliente);
        rhJButton.setEnabled(permisoRH);
        proveedoresJButton.setEnabled(permisoProveedores);
        comprasJButton.setEnabled(permisoRegCompra);
        ventasJButton.setEnabled(permisoRegVenta);
        finanzasJButton.setEnabled(permisoFinanciero);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        inventarioJButton = new javax.swing.JButton();
        proveedoresJButton = new javax.swing.JButton();
        finanzasJButton = new javax.swing.JButton();
        clientesJButton = new javax.swing.JButton();
        ventasJButton = new javax.swing.JButton();
        rhJButton = new javax.swing.JButton();
        comprasJButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        regresarJButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu");
        setBackground(new java.awt.Color(196, 212, 209));
        setResizable(false);

        inventarioJButton.setBackground(new java.awt.Color(136, 213, 133));
        inventarioJButton.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        inventarioJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventario.png"))); // NOI18N
        inventarioJButton.setText("INVENTARIO");
        inventarioJButton.setToolTipText("");
        inventarioJButton.setPreferredSize(new java.awt.Dimension(100, 100));
        inventarioJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inventarioJButtonActionPerformed(evt);
            }
        });

        proveedoresJButton.setBackground(new java.awt.Color(136, 213, 133));
        proveedoresJButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        proveedoresJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proveedores.png"))); // NOI18N
        proveedoresJButton.setText("PROVEEDORES");
        proveedoresJButton.setToolTipText("");
        proveedoresJButton.setPreferredSize(new java.awt.Dimension(100, 100));
        proveedoresJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proveedoresJButtonActionPerformed(evt);
            }
        });

        finanzasJButton.setBackground(new java.awt.Color(136, 213, 133));
        finanzasJButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        finanzasJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/finanzas.png"))); // NOI18N
        finanzasJButton.setText("FINANZAS");
        finanzasJButton.setToolTipText("");
        finanzasJButton.setPreferredSize(new java.awt.Dimension(100, 100));

        clientesJButton.setBackground(new java.awt.Color(136, 213, 133));
        clientesJButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        clientesJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clientes.png"))); // NOI18N
        clientesJButton.setText("CLIENTES");
        clientesJButton.setToolTipText("");
        clientesJButton.setPreferredSize(new java.awt.Dimension(100, 100));
        clientesJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientesJButtonActionPerformed(evt);
            }
        });

        ventasJButton.setBackground(new java.awt.Color(136, 213, 133));
        ventasJButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ventasJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventas.png"))); // NOI18N
        ventasJButton.setText("VENTAS");
        ventasJButton.setToolTipText("");
        ventasJButton.setPreferredSize(new java.awt.Dimension(100, 100));

        rhJButton.setBackground(new java.awt.Color(136, 213, 133));
        rhJButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rhJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rh.png"))); // NOI18N
        rhJButton.setText("     RH");
        rhJButton.setToolTipText("");
        rhJButton.setPreferredSize(new java.awt.Dimension(100, 100));
        rhJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rhJButtonActionPerformed(evt);
            }
        });

        comprasJButton.setBackground(new java.awt.Color(136, 213, 133));
        comprasJButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        comprasJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/compras.png"))); // NOI18N
        comprasJButton.setText("COMPRAS");
        comprasJButton.setToolTipText("");
        comprasJButton.setPreferredSize(new java.awt.Dimension(100, 100));

        jPanel1.setBackground(new java.awt.Color(34, 85, 34));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("MENU");

        regresarJButton.setBackground(new java.awt.Color(16, 82, 0));
        regresarJButton.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        regresarJButton.setForeground(new java.awt.Color(248, 244, 227));
        regresarJButton.setText("←");
        regresarJButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                regresarJButtonMouseClicked(evt);
            }
        });
        regresarJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(regresarJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(153, 153, 153)
                .addComponent(jLabel1)
                .addContainerGap(262, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(regresarJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ventasJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(comprasJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(inventarioJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(clientesJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(finanzasJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rhJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createSequentialGroup()
                .addGap(203, 203, 203)
                .addComponent(proveedoresJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inventarioJButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clientesJButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rhJButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(proveedoresJButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comprasJButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ventasJButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(finanzasJButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        inventarioJButton.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void regresarJButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_regresarJButtonMouseClicked
        // TODO add your handling code here:
        Login login_screen = new Login();
        login_screen.setVisible(true);
        login_screen.setLocationRelativeTo(null);
        
        // Cerrar la ventana actual
        dispose();
    }//GEN-LAST:event_regresarJButtonMouseClicked

    private void rhJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rhJButtonActionPerformed
        try {
            RRHH rh_window = new RRHH(conexion, credenciales);
            rh_window.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
    }//GEN-LAST:event_rhJButtonActionPerformed

    private void regresarJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarJButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_regresarJButtonActionPerformed

    private void inventarioJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inventarioJButtonActionPerformed
        // TODO add your handling code here:
        Inventario inventario_screen = new Inventario(conexion, credenciales);
        inventario_screen.setVisible(true);
        dispose();
    }//GEN-LAST:event_inventarioJButtonActionPerformed

    private void clientesJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientesJButtonActionPerformed
        // TODO add your handling code here:
        Clientes clientes_screen = new Clientes(conexion, credenciales);
        clientes_screen.setVisible(true);        
        // Cerrar la ventana actual
        dispose();
    }//GEN-LAST:event_clientesJButtonActionPerformed

    private void proveedoresJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proveedoresJButtonActionPerformed
        // TODO add your handling code here:
        Proveedores proveedores_screen = new Proveedores(conexion, credenciales);
        proveedores_screen.setVisible(true);
        
        // Cerrar la ventana actual
        dispose();
    }//GEN-LAST:event_proveedoresJButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clientesJButton;
    private javax.swing.JButton comprasJButton;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JButton finanzasJButton;
    private javax.swing.JButton inventarioJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton proveedoresJButton;
    private javax.swing.JButton regresarJButton;
    private javax.swing.JButton rhJButton;
    private javax.swing.JButton ventasJButton;
    // End of variables declaration//GEN-END:variables
}
