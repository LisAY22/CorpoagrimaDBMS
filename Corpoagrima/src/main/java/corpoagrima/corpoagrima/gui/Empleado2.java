/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package corpoagrima.corpoagrima.gui;

import corpoagrima.corpoagrima.bdMariaDB.ConexionEmpleado;
import corpoagrima.corpoagrima.bdMariaDB.ConexionPuesto;
import corpoagrima.corpoagrima.bdMariaDB.ConexionTelefono;
import corpoagrima.corpoagrima.bdMariaDB.ConexionUsuario;
import java.awt.event.ItemEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author lisaj
 */
public class Empleado2 extends javax.swing.JFrame {
    
    private Connection conexion;
    private ConexionEmpleado Empleado;
    private ConexionPuesto Puesto;
    private ConexionUsuario Usuario;
    private ConexionTelefono Telefono;
    private int idPuesto;
    private int idUsuario;
    private int idTelefono;

    /**
     * Creates new form Empleado2
     */
    public Empleado2(Connection conexion) {
        this.conexion = conexion;
        Empleado = new ConexionEmpleado();
        Puesto = new ConexionPuesto();
        Usuario = new ConexionUsuario();
        Telefono = new ConexionTelefono();
        initComponents();
        comboboxfull();
        String nombre = (String) Puesto_comboBox.getSelectedItem();
        try {
            sueldoBase(nombre);
        } catch (SQLException ex) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void comboboxfull() {
        try {
            ResultSet puestos = Puesto.puestos(conexion);

            while (puestos.next()) {
                String puesto = puestos.getString("Nombre");
                Puesto_comboBox.addItem(puesto);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se encontró ningún puesto para el ComboBox.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private String[] getComboBoxItems(JComboBox<String> comboBox) {
        int itemCount = comboBox.getItemCount();

        String[] itemsArray = new String[itemCount];

        for (int i = 0; i < itemCount; i++) {
            itemsArray[i] = (String) comboBox.getItemAt(i);
        }

        return itemsArray;
    }
    
    private void Clean() {
        Apellido_textField.setText("");
        Bonificaciones_textfield.setText("");
        Correo_textfield.setText("");
        ID_textfield.setText("");
        Direccion_textfield.setText("");
        NIT_textfield.setText("");
        Nombre_textField.setText("");
        Telefono_textfield.setText("");
        Usuario_textfield.setText("");
        contrasena_textfield1.setText("");
        Sueldobase_textfield.setText("");
        AjusteSueldo_textfield.setText("");
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Encabezado_panel = new javax.swing.JPanel();
        Encabezad_panel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Nombre_textField = new javax.swing.JTextField();
        Apellido_textField = new javax.swing.JTextField();
        NIT_textfield = new javax.swing.JTextField();
        Correo_textfield = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        Direccion_textfield = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        Bonificaciones_textfield = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        Puesto_comboBox = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        Sueldobase_textfield = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        Usuario_textfield = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        Telefono_textfield = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        contrasena_textfield1 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        ID_textfield = new javax.swing.JTextField();
        Ajuste_label = new javax.swing.JLabel();
        AjusteSueldo_textfield = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        Cancel_button = new javax.swing.JButton();
        Save_button = new javax.swing.JButton();
        Clean_button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1027, 450));

        Encabezado_panel.setBackground(new java.awt.Color(34, 85, 34));

        Encabezad_panel2.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        Encabezad_panel2.setForeground(new java.awt.Color(255, 255, 255));
        Encabezad_panel2.setText("Empleados");

        javax.swing.GroupLayout Encabezado_panelLayout = new javax.swing.GroupLayout(Encabezado_panel);
        Encabezado_panel.setLayout(Encabezado_panelLayout);
        Encabezado_panelLayout.setHorizontalGroup(
            Encabezado_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Encabezado_panelLayout.createSequentialGroup()
                .addGap(377, 377, 377)
                .addComponent(Encabezad_panel2, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                .addGap(368, 368, 368))
        );
        Encabezado_panelLayout.setVerticalGroup(
            Encabezado_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Encabezado_panelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(Encabezad_panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(29, 29, 29))
        );

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("NIT");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Sueldo base");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Apellido");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("Nombre");

        Nombre_textField.setEditable(true);
        Nombre_textField.setToolTipText("Ingrese Nombre");
        Nombre_textField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Nombre_textFieldActionPerformed(evt);
            }
        });

        Apellido_textField.setEditable(true);
        Apellido_textField.setToolTipText("Ingrese Apellido");

        NIT_textfield.setEditable(true);
        NIT_textfield.setToolTipText("Ingrese NIT");

        Correo_textfield.setEditable(true);
        Correo_textfield.setToolTipText("Ingrese correo electrónico");
        Correo_textfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Correo_textfieldActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setText("Dirección");

        Direccion_textfield.setEditable(true);
        Direccion_textfield.setToolTipText("Ingrese dirección");
        Direccion_textfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Direccion_textfieldActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setText("Bonificaciones ");

        Bonificaciones_textfield.setEditable(true);
        Bonificaciones_textfield.setToolTipText("Ingrese bonificaciones");
        Bonificaciones_textfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bonificaciones_textfieldActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setText("Correo electrónico");

        Puesto_comboBox.setEnabled(true);
        Puesto_comboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                Puesto_comboBoxItemStateChanged(evt);
            }
        });
        Puesto_comboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Puesto_comboBoxActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel12.setText("Puesto");

        Sueldobase_textfield.setEditable(true);
        Sueldobase_textfield.setToolTipText("Sueldo en Quetzales");
        Sueldobase_textfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Sueldobase_textfieldActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel13.setText("Contraseña");

        Usuario_textfield.setEditable(true);
        Usuario_textfield.setToolTipText("Ingrese Usuario");
        Usuario_textfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Usuario_textfieldActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel15.setText("Teléfono");

        Telefono_textfield.setEditable(true);
        Telefono_textfield.setToolTipText("Ingrese Teléfono");
        Telefono_textfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Telefono_textfieldActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel16.setText("Usuario");

        contrasena_textfield1.setEditable(true);
        contrasena_textfield1.setToolTipText("Ingrese contraseña");
        contrasena_textfield1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contrasena_textfield1ActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel14.setText("ID");

        ID_textfield.setEditable(true);
        ID_textfield.setToolTipText("ID del empleado");

        Ajuste_label.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Ajuste_label.setText("Ajuste sueldo");

        AjusteSueldo_textfield.setEditable(true);
        AjusteSueldo_textfield.setToolTipText("Ajuste de sueldo en Quetzales");
        AjusteSueldo_textfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AjusteSueldo_textfieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(Nombre_textField, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ID_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Apellido_textField, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NIT_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Correo_textfield, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Direccion_textfield, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Bonificaciones_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Telefono_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Ajuste_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Usuario_textfield)
                    .addComponent(Sueldobase_textfield, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                    .addComponent(contrasena_textfield1)
                    .addComponent(Puesto_comboBox, 0, 178, Short.MAX_VALUE)
                    .addComponent(AjusteSueldo_textfield, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ID_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Correo_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Puesto_comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Nombre_textField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Direccion_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Sueldobase_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Apellido_textField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Bonificaciones_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NIT_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Ajuste_label, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AjusteSueldo_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Usuario_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Telefono_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(contrasena_textfield1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        Cancel_button.setText("Cancelar");
        Cancel_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cancel_buttonActionPerformed(evt);
            }
        });

        Save_button.setText("Guardar");
        Save_button.setEnabled(true);
        Save_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Save_buttonActionPerformed(evt);
            }
        });

        Clean_button.setText("Limpiar ");
        Clean_button.setEnabled(true);
        Clean_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Clean_buttonMouseClicked(evt);
            }
        });
        Clean_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Clean_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Clean_button)
                .addGap(18, 18, 18)
                .addComponent(Save_button)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Cancel_button)
                .addGap(12, 12, 12))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Clean_button)
                    .addComponent(Save_button)
                    .addComponent(Cancel_button))
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Encabezado_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Encabezado_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Nombre_textFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Nombre_textFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Nombre_textFieldActionPerformed

    private void Correo_textfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Correo_textfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Correo_textfieldActionPerformed

    private void Direccion_textfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Direccion_textfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Direccion_textfieldActionPerformed

    private void Bonificaciones_textfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bonificaciones_textfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Bonificaciones_textfieldActionPerformed

    private void Puesto_comboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_Puesto_comboBoxItemStateChanged
        Puesto_comboBox.addItemListener((ItemEvent e) -> {
            if (evt.getStateChange() == ItemEvent.SELECTED) {
                try {
                    String nombre = (String) Puesto_comboBox.getSelectedItem();
                    sueldoBase(nombre);
                } catch (SQLException ex) {
                    Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }//GEN-LAST:event_Puesto_comboBoxItemStateChanged

    private void Puesto_comboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Puesto_comboBoxActionPerformed

    }//GEN-LAST:event_Puesto_comboBoxActionPerformed

    private void Sueldobase_textfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Sueldobase_textfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Sueldobase_textfieldActionPerformed

    private void Usuario_textfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Usuario_textfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Usuario_textfieldActionPerformed

    private void Telefono_textfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Telefono_textfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Telefono_textfieldActionPerformed

    private void contrasena_textfield1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contrasena_textfield1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contrasena_textfield1ActionPerformed

    private void AjusteSueldo_textfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AjusteSueldo_textfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AjusteSueldo_textfieldActionPerformed

    private void Cancel_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cancel_buttonActionPerformed
        try {
            RRHH rh_window = new RRHH(conexion);
            rh_window.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }//GEN-LAST:event_Cancel_buttonActionPerformed

    private void Save_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Save_buttonActionPerformed
        try {
            String apellido = Apellido_textField.getText();
            float bonificaciones = Float.parseFloat(Bonificaciones_textfield.getText());
            String correoElectronico = Correo_textfield.getText();
            int idEmpleado = Integer.parseInt(ID_textfield.getText());
            String direccion = Direccion_textfield.getText();
            String nit = NIT_textfield.getText();
            String nombre = Nombre_textField.getText();
            String telefono = Telefono_textfield.getText();
            String usuario = Usuario_textfield.getText();
            String contrasenia = contrasena_textfield1.getText();
            String ajusteSueldo = AjusteSueldo_textfield.getText();
            String puesto = (String) Puesto_comboBox.getSelectedItem();
            int idUsuario;
            int idPuesto;

            // tabla usuario
            boolean resultUsuario = Usuario.agregar(conexion, usuario, contrasenia);


            ResultSet resultPuesto = Puesto.puestoID(conexion, puesto);
            ResultSet restUsuario = Usuario.usuarioID(conexion, usuario);

            resultPuesto.next();
            restUsuario.next();
            idPuesto = resultPuesto.getInt("ID_Puesto");
            idUsuario = restUsuario.getInt("ID_Usuario");

            // tabla empleado
            boolean resultSet = Empleado.agregar(conexion, idEmpleado, nombre,
                    apellido, nit, correoElectronico, direccion, ajusteSueldo,
                    bonificaciones, idPuesto, idUsuario);

            // tabla telefono
            boolean resultTelefono = Telefono.agregar(conexion, telefono,
                    "Empleado", idEmpleado);

            if (resultSet && resultTelefono && resultUsuario) {
                JOptionPane.showMessageDialog(this, "Se ha creado un nuevo "
                        + "empleado exitosamente.", "Nuevo Empleado",
                        JOptionPane.INFORMATION_MESSAGE);
                Clean();
            } else {
                JOptionPane.showMessageDialog(this, "Ha habido un error "
                        + "compruebe la información", "Nuevo Empleado",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Puesto.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Ha habido un error "
                    + "compruebe la información", "Nuevo Empleado",
                    JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_Save_buttonActionPerformed

    private void Clean_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Clean_buttonActionPerformed
    }//GEN-LAST:event_Clean_buttonActionPerformed

    private void Clean_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Clean_buttonMouseClicked
        // TODO add your handling code here:
        Clean();
    }//GEN-LAST:event_Clean_buttonMouseClicked

    private void sueldoBase(String nombre) throws SQLException {
        ResultSet result = Puesto.puestoNombre(conexion, nombre);
        result.next();
        String salario = String.valueOf(result.getFloat("Salario_Base"));
        Sueldobase_textfield.setText(salario);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AjusteSueldo_textfield;
    private javax.swing.JLabel Ajuste_label;
    private javax.swing.JTextField Apellido_textField;
    private javax.swing.JTextField Bonificaciones_textfield;
    private javax.swing.JButton Cancel_button;
    private javax.swing.JButton Clean_button;
    private javax.swing.JTextField Correo_textfield;
    private javax.swing.JTextField Direccion_textfield;
    private javax.swing.JLabel Encabezad_panel2;
    private javax.swing.JPanel Encabezado_panel;
    private javax.swing.JTextField ID_textfield;
    private javax.swing.JTextField NIT_textfield;
    private javax.swing.JTextField Nombre_textField;
    private javax.swing.JComboBox<String> Puesto_comboBox;
    private javax.swing.JButton Save_button;
    private javax.swing.JTextField Sueldobase_textfield;
    private javax.swing.JTextField Telefono_textfield;
    private javax.swing.JTextField Usuario_textfield;
    private javax.swing.JTextField contrasena_textfield1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables
}
