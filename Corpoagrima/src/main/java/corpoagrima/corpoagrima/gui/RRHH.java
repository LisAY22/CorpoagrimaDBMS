/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package corpoagrima.corpoagrima.gui;
import corpoagrima.corpoagrima.bdMariaDB.ConexionEmpleado;
import corpoagrima.corpoagrima.bdMariaDB.ConexionPuesto;
import corpoagrima.corpoagrima.bdMariaDB.ConexionUsuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
/**
 *
 * @author User
 * @author lisaj
 */
public class RRHH extends javax.swing.JFrame {
    
    private Connection conexion;
    private ConexionEmpleado empleado;
    private ConexionPuesto puesto;
    private ConexionUsuario usuario;
    private TableRowSorter<TableModel> sorter;
    /**
     * Creates new form RH
     * @param conexion
     * @throws java.sql.SQLException
     */
    public RRHH(Connection conexion) throws SQLException {
        this.conexion = conexion;
        empleado = new ConexionEmpleado();
        puesto = new ConexionPuesto();
        usuario = new ConexionUsuario();
        initComponents();
        Initial_table();
    }

    private RRHH() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    private void Initial_table() throws SQLException{
        DefaultTableModel model = (DefaultTableModel) TablaEmpleado.getModel();
        ResultSet resultado = empleado.consulta(conexion);
        model.setRowCount(0); // Limpiar los datos existentes
        
        while (resultado.next()) {
            int ID = resultado.getInt("ID_Empleado");
            String Nombre = resultado.getString("Nombre");
            String Apellido = resultado.getString("Apellido");
            String NIT = resultado.getString("NIT");
            String Correo = resultado.getString("Correo_electronico");
            String Direccion = resultado.getString("Direccion");
            String Bonificaciones = resultado.getString("Bonificaciones");
            int id_puesto = resultado.getInt("Puesto_ID_Puesto");
            int id_usuario = resultado.getInt("Usuario_ID_Usuario");
            float ajusteSueldo = Float.valueOf(resultado.getString("Ajuste_Sueldo"));

            // Segunda consulta para obtener el puesto y el sueldo del puesto.
            ResultSet resultadoPuesto = puesto.puestoId(conexion, id_puesto);
            
            resultadoPuesto.next();
            String puesto = resultadoPuesto.getString("Nombre");
            Float salario = resultadoPuesto.getFloat("Salario_Base") + ajusteSueldo;
            
            // Tercera consulta para obtener el nombre de usuario
            
            ResultSet resultado_usuario = usuario.usuarioId(conexion, id_usuario);
            
            resultado_usuario.next();
            String Nombre_usuario = resultado_usuario.getString("Nombre");
                    
            
            // Agregar a la tabla
            model.addRow(new Object[]{ID, Nombre, Apellido, NIT, Correo, Direccion, Bonificaciones, puesto,Nombre_usuario, salario});
        }
    }
    
    private void order_by_name() throws SQLException{
        DefaultTableModel model = (DefaultTableModel) TablaEmpleado.getModel();
        ResultSet resultado = empleado.ordenarNombre(conexion);
        model.setRowCount(0);
        
        while (resultado.next()) {
        int ID = resultado.getInt("ID_Empleado");
        String Nombre = resultado.getString("Nombre");
        String Apellido = resultado.getString("Apellido");
        String NIT = resultado.getString("NIT");
        String Correo = resultado.getString("Correo_electronico");
        String Direccion = resultado.getString("Direccion");
        String Bonificaciones = resultado.getString("Bonificaciones");
        int id_puesto = resultado.getInt("Puesto_ID_Puesto");
        int id_usuario = resultado.getInt("Usuario_ID_Usuario");

        // Segunda consulta para obtener el puesto y el sueldo del puesto.
        ResultSet resultadoPuesto = puesto.puestoId(conexion, id_puesto);
        resultadoPuesto.next();
        String puesto = resultadoPuesto.getString("Nombre");
        Float salario = resultadoPuesto.getFloat("Salario_Base");
            
        // Tercera consulta para obtener el nombre de usuario 
        ResultSet resultadoUsuario = usuario.usuarioId(conexion, id_usuario);
            
        resultadoUsuario.next();
        String Nombre_usuario = resultadoUsuario.getString("Nombre");
        // Agregar a la tabla
        model.addRow(new Object[]{ID, Nombre, Apellido, NIT, Correo, Direccion, Bonificaciones, puesto,Nombre_usuario, salario});
        }
    }
    
    private void order_by_Apellido() throws SQLException{
        DefaultTableModel model = (DefaultTableModel) TablaEmpleado.getModel();
        ResultSet resultado = empleado.ordenarApellido(conexion);
        model.setRowCount(0);
        
        while (resultado.next()) {
        int ID = resultado.getInt("ID_Empleado");
        String Nombre = resultado.getString("Nombre");
        String Apellido = resultado.getString("Apellido");
        String NIT = resultado.getString("NIT");
        String Correo = resultado.getString("Correo_electronico");
        String Direccion = resultado.getString("Direccion");
        String Bonificaciones = resultado.getString("Bonificaciones");
        int id_puesto = resultado.getInt("Puesto_ID_Puesto");
        int id_usuario = resultado.getInt("Usuario_ID_Usuario");

        // Segunda consulta para obtener el puesto y el sueldo del puesto.
        ResultSet resultadoPuesto = puesto.puestoId(conexion, id_puesto);
        resultadoPuesto.next();
        String puesto = resultadoPuesto.getString("Nombre");
        Float salario = resultadoPuesto.getFloat("Salario_Base");
            
        // Tercera consulta para obtener el nombre de usuario 
        ResultSet resultadoUsuario = usuario.usuarioId(conexion, id_usuario);
            
        resultadoUsuario.next();
        String Nombre_usuario = resultadoUsuario.getString("Nombre");
        // Agregar a la tabla
        model.addRow(new Object[]{ID, Nombre, Apellido, NIT, Correo, Direccion, Bonificaciones, puesto,Nombre_usuario, salario});
        
        }
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        puestoJLabel = new javax.swing.JLabel();
        Refresh_button = new javax.swing.JButton();
        back_Button = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaEmpleado = new javax.swing.JTable();
        jButtonEDP = new javax.swing.JButton();
        jButtonNP = new javax.swing.JButton();
        jButtonEDE = new javax.swing.JButton();
        jButtonNE = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        Ordenar_Bn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(34, 85, 34));

        puestoJLabel.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        puestoJLabel.setForeground(new java.awt.Color(255, 255, 255));
        puestoJLabel.setText("RR.HH");

        Refresh_button.setBackground(new java.awt.Color(34, 85, 34));
        Refresh_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/actualizar.png"))); // NOI18N
        Refresh_button.setBorderPainted(false);
        Refresh_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Refresh_buttonActionPerformed(evt);
            }
        });

        back_Button.setBackground(new java.awt.Color(34, 85, 34));
        back_Button.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        back_Button.setForeground(new java.awt.Color(255, 255, 255));
        back_Button.setText("←");
        back_Button.setBorderPainted(false);
        back_Button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                back_ButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(back_Button)
                .addGap(317, 317, 317)
                .addComponent(puestoJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(136, 136, 136)
                .addComponent(Refresh_button, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(puestoJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                .addComponent(back_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(Refresh_button, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TablaEmpleado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Apellido", "NIT", "Correo_Electrónico", "Dirección", "Bonificaciones", "Puesto", "Usuario", "Sueldo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TablaEmpleado);

        jButtonEDP.setBackground(new java.awt.Color(136, 213, 133));
        jButtonEDP.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonEDP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editar.png"))); // NOI18N
        jButtonEDP.setText("EDITAR PUESTO");
        jButtonEDP.setToolTipText("");
        jButtonEDP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonEDPMouseClicked(evt);
            }
        });
        jButtonEDP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEDPActionPerformed(evt);
            }
        });

        jButtonNP.setBackground(new java.awt.Color(136, 213, 133));
        jButtonNP.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonNP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nuevo.png"))); // NOI18N
        jButtonNP.setText("NUEVO PUESTO");
        jButtonNP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonNPMouseClicked(evt);
            }
        });

        jButtonEDE.setBackground(new java.awt.Color(136, 213, 133));
        jButtonEDE.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonEDE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editar.png"))); // NOI18N
        jButtonEDE.setText("EDITAR EMPLEADO");
        jButtonEDE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonEDEMouseClicked(evt);
            }
        });

        jButtonNE.setBackground(new java.awt.Color(136, 213, 133));
        jButtonNE.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonNE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nuevo.png"))); // NOI18N
        jButtonNE.setText("NUEVO EMPLEADO");
        jButtonNE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonNEMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 736, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonNE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonEDP)
                            .addComponent(jButtonNP)
                            .addComponent(jButtonEDE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jButtonEDP)
                .addGap(18, 18, 18)
                .addComponent(jButtonNP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonEDE)
                .addGap(18, 18, 18)
                .addComponent(jButtonNE)
                .addGap(48, 48, 48))
        );

        Ordenar_Bn.setBackground(new java.awt.Color(136, 213, 133));
        Ordenar_Bn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ordenar.png"))); // NOI18N
        Ordenar_Bn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Ordenar_BnMouseClicked(evt);
            }
        });
        Ordenar_Bn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Ordenar_BnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(Ordenar_Bn, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Ordenar_Bn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void back_ButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back_ButtonMouseClicked
        // TODO add your handling code here:
        principal principal_screen = new principal(conexion);
        principal_screen.setVisible(true);
        principal_screen.setLocationRelativeTo(null);

        // Cerrar la ventana actual
        dispose();
    }//GEN-LAST:event_back_ButtonMouseClicked

    private void Refresh_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Refresh_buttonActionPerformed
        try {
            Initial_table();
            JOptionPane.showMessageDialog(this,
                            "Se ha actualizado exitosamente.",
                            "Actualizar", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(RRHH.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Ha habido un error "
                    + "en la actualizacion.", "Actualizar",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_Refresh_buttonActionPerformed

    private void Ordenar_BnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Ordenar_BnMouseClicked
        // TODO add your handling code here:
        if (sorter == null) {
            // Crear un objeto TableRowSorter basado en el modelo de la tabla
            DefaultTableModel model = (DefaultTableModel) TablaEmpleado.getModel();
            sorter = new TableRowSorter<>(model);
            TablaEmpleado.setRowSorter(sorter);
        }

        // Crear un RowSorter para ordenar por la columna "Nombre"
        ArrayList<RowSorter.SortKey> sortKeys = new ArrayList<>();
        int columnIndexToSort = 1; // Indice de la columna "Nombre"
        sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.ASCENDING)); // Orden ascendente
        sorter.setSortKeys(sortKeys);

        // Ordenar la tabla
        sorter.sort();

        // Mostrar un mensaje indicando que la tabla ha sido ordenada
        JOptionPane.showMessageDialog(this, "El ordenamiento de la tabla ha sido habilitado.", "Ordenar tabla", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_Ordenar_BnMouseClicked

    private void jButtonEDPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEDPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonEDPActionPerformed

    private void Ordenar_BnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Ordenar_BnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Ordenar_BnActionPerformed

    private void jButtonEDPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonEDPMouseClicked
        // TODO add your handling code here:
        Puesto puestoed_screen = new Puesto(conexion);
        puestoed_screen.setVisible(true);
        puestoed_screen.setLocationRelativeTo(null);

        // Cerrar la ventana actual
        dispose();
    }//GEN-LAST:event_jButtonEDPMouseClicked

    private void jButtonNPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonNPMouseClicked
        // TODO add your handling code here:
        Puesto2 pueston_screen = new Puesto2(conexion);
        pueston_screen.setVisible(true);
        pueston_screen.setLocationRelativeTo(null);

        // Cerrar la ventana actual
        dispose();
    }//GEN-LAST:event_jButtonNPMouseClicked

    private void jButtonEDEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonEDEMouseClicked
        // TODO add your handling code here:
        Empleado empleadoed_screen = new Empleado(conexion);
        empleadoed_screen.setVisible(true);
        empleadoed_screen.setLocationRelativeTo(null);

        // Cerrar la ventana actual
        dispose();
    }//GEN-LAST:event_jButtonEDEMouseClicked

    private void jButtonNEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonNEMouseClicked
        // TODO add your handling code here:
        Empleado empleadon_screen = new Empleado(conexion);
        empleadon_screen.setVisible(true);
        empleadon_screen.setLocationRelativeTo(null);

        // Cerrar la ventana actual
        dispose();
    }//GEN-LAST:event_jButtonNEMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Ordenar_Bn;
    private javax.swing.JButton Refresh_button;
    private javax.swing.JTable TablaEmpleado;
    private javax.swing.JButton back_Button;
    private javax.swing.JButton jButtonEDE;
    private javax.swing.JButton jButtonEDP;
    private javax.swing.JButton jButtonNE;
    private javax.swing.JButton jButtonNP;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel puestoJLabel;
    // End of variables declaration//GEN-END:variables
}
