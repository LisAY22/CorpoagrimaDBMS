/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package corpoagrima.corpoagrima.gui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author lisaj
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
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

        principalJPanel = new javax.swing.JPanel();
        logoJLabel = new javax.swing.JLabel();
        usuarioJLabel = new javax.swing.JLabel();
        contraseñaJLabel = new javax.swing.JLabel();
        usuarioJTextField = new javax.swing.JTextField();
        contraseñaJPasswordField = new javax.swing.JPasswordField();
        contraseñaJButton = new javax.swing.JButton();
        ingresarJButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setResizable(false);

        logoJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo.png"))); // NOI18N
        logoJLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        usuarioJLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        usuarioJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        usuarioJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/usuario.png"))); // NOI18N
        usuarioJLabel.setText("USUARIO");
        usuarioJLabel.setIconTextGap(5);

        contraseñaJLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        contraseñaJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        contraseñaJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/contraseña.png"))); // NOI18N
        contraseñaJLabel.setText("CONTRASEÑA");
        contraseñaJLabel.setIconTextGap(5);

        usuarioJTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        contraseñaJPasswordField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        contraseñaJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ojo.png"))); // NOI18N
        contraseñaJButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                contraseñaJButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                contraseñaJButtonMouseReleased(evt);
            }
        });

        ingresarJButton.setBackground(new java.awt.Color(16, 82, 0));
        ingresarJButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ingresarJButton.setForeground(new java.awt.Color(252, 252, 252));
        ingresarJButton.setText("INGRESAR");
        ingresarJButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ingresarJButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout principalJPanelLayout = new javax.swing.GroupLayout(principalJPanel);
        principalJPanel.setLayout(principalJPanelLayout);
        principalJPanelLayout.setHorizontalGroup(
            principalJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(principalJPanelLayout.createSequentialGroup()
                .addGap(175, 175, 175)
                .addComponent(logoJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(175, 175, 175))
            .addGroup(principalJPanelLayout.createSequentialGroup()
                .addGroup(principalJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(principalJPanelLayout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addGroup(principalJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(usuarioJLabel)
                            .addComponent(contraseñaJLabel))
                        .addGap(73, 73, 73)
                        .addGroup(principalJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(usuarioJTextField)
                            .addComponent(contraseñaJPasswordField, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(contraseñaJButton))
                    .addGroup(principalJPanelLayout.createSequentialGroup()
                        .addGap(217, 217, 217)
                        .addComponent(ingresarJButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        principalJPanelLayout.setVerticalGroup(
            principalJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(principalJPanelLayout.createSequentialGroup()
                .addGroup(principalJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(principalJPanelLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(logoJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(33, 33, 33)
                        .addComponent(usuarioJLabel))
                    .addGroup(principalJPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(usuarioJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(37, 37, 37)
                .addGroup(principalJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(contraseñaJLabel)
                    .addComponent(contraseñaJPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(contraseñaJButton))
                .addGap(44, 44, 44)
                .addComponent(ingresarJButton)
                .addGap(58, 58, 58))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(principalJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(principalJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void contraseñaJButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contraseñaJButtonMousePressed
        // TODO add your handling code here:
        String contraseña = new String(contraseñaJPasswordField.getPassword());
    
        // Establecer el campo de contraseña para mostrar el contenido en texto claro
        contraseñaJPasswordField.setEchoChar((char) 0);
    
        // Establecer el texto del campo de contraseña como la contraseña
        contraseñaJPasswordField.setText(contraseña);
    }//GEN-LAST:event_contraseñaJButtonMousePressed

    private void contraseñaJButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contraseñaJButtonMouseReleased
        // TODO add your handling code here:
        // Restablecer el campo de contraseña para mostrar los puntos
        contraseñaJPasswordField.setEchoChar('°');
    }//GEN-LAST:event_contraseñaJButtonMouseReleased

    private void ingresarJButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ingresarJButtonMouseClicked
        // TODO add your handling code here:
        // Obtener el usuario y la contraseña ingresados por el usuario
        String usuario = usuarioJTextField.getText();
        String contraseña = new String(contraseñaJPasswordField.getPassword());
        
        // Verificar las credenciales en la base de datos
        if (verificarCredenciales(usuario, contraseña)) {
            // Si las credenciales son correctas, abrir la nueva ventana
            Principal principal_screen = new Principal();
            principal_screen.setVisible(true);
            principal_screen.setLocationRelativeTo(null);

            // Cerrar la ventana actual
            dispose();
        }
        else {
            JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos", "Error de inicio de sesión", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_ingresarJButtonMouseClicked
    
    private boolean verificarCredenciales(String usuario, String contraseña) {
        // Establecer la conexión a la base de datos
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/CorpoagrimaBD?serverTimezone=UTC", "root", "Mi.Brol.22")) {
            // Crear la consulta SQL para verificar las credenciales
            String sql = "SELECT * FROM usuario WHERE nombre = ? AND contraseña = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, usuario);
                stmt.setString(2, contraseña);
                try (ResultSet rs = stmt.executeQuery()) {
                    // Si se encuentra algún resultado, las credenciales son correctas
                    return rs.next();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Si ocurre algún error, considerar las credenciales como incorrectas
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton contraseñaJButton;
    private javax.swing.JLabel contraseñaJLabel;
    private javax.swing.JPasswordField contraseñaJPasswordField;
    private javax.swing.JButton ingresarJButton;
    private javax.swing.JLabel logoJLabel;
    private javax.swing.JPanel principalJPanel;
    private javax.swing.JLabel usuarioJLabel;
    private javax.swing.JTextField usuarioJTextField;
    // End of variables declaration//GEN-END:variables
}