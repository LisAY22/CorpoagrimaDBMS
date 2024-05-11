/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package corpoagrima.corpoagrima.gui.regventa;
import java.sql.Connection;
import java.sql.ResultSet;
/**
 *
 * @author User
 */
public class EditarRegVenta extends javax.swing.JFrame {
    private final Connection conexion;
    private final ResultSet credenciales;
    /**
     * Creates new form EditarRegFactura
     * @param conexion
     * @param credenciales
     * @param Factura
     */
    public EditarRegVenta(Connection conexion, ResultSet credenciales, String Factura) {
        this.conexion = conexion;
        this.credenciales = credenciales;
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        encabezadoJPanel = new javax.swing.JPanel();
        puestoJLabel = new javax.swing.JLabel();
        back_Button = new javax.swing.JButton();
        Apellido_Label = new javax.swing.JLabel();
        Nombre_TextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        NoFactura_TextField1 = new javax.swing.JTextField();
        Nombre_jLabel2 = new javax.swing.JLabel();
        Apellido_TextField = new javax.swing.JTextField();
        Apellido_Label1 = new javax.swing.JLabel();
        Direccion_TextField = new javax.swing.JTextField();
        Direccion_Label = new javax.swing.JLabel();
        Direccion_TextField1 = new javax.swing.JTextField();
        Empleado_label = new javax.swing.JLabel();
        Empleado_TextField = new javax.swing.JTextField();
        Fecha_label = new javax.swing.JLabel();
        Fecha_TextField = new javax.swing.JTextField();
        Destacado_checkBox = new javax.swing.JCheckBox();
        Direccion_Label1 = new javax.swing.JLabel();
        Detalles_TextField = new javax.swing.JTextField();
        Consumidor_CheckBox = new javax.swing.JCheckBox();
        NIT_CheckBox = new javax.swing.JCheckBox();
        Credito_checkbox = new javax.swing.JCheckBox();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 0), new java.awt.Dimension(5, 32767));
        jScrollPane1 = new javax.swing.JScrollPane();
        Productos_table = new javax.swing.JTable();
        Agregar_button = new javax.swing.JButton();
        Eliminar_button = new javax.swing.JButton();
        Destacado_label2 = new javax.swing.JLabel();
        Efectivo_TextField = new javax.swing.JTextField();
        Destacado_label3 = new javax.swing.JLabel();
        Cambio_TextField = new javax.swing.JTextField();
        Destacado_label4 = new javax.swing.JLabel();
        Total_TextField = new javax.swing.JTextField();
        Guardar_Button = new javax.swing.JButton();
        Limpiar_button = new javax.swing.JButton();
        Buscar_jbutton = new javax.swing.JButton();
        Total_TextField1 = new javax.swing.JTextField();
        Destacado_label5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        encabezadoJPanel.setBackground(new java.awt.Color(34, 85, 34));

        puestoJLabel.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        puestoJLabel.setForeground(new java.awt.Color(255, 255, 255));
        puestoJLabel.setText("Editar Registro Factura");

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
        back_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_ButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout encabezadoJPanelLayout = new javax.swing.GroupLayout(encabezadoJPanel);
        encabezadoJPanel.setLayout(encabezadoJPanelLayout);
        encabezadoJPanelLayout.setHorizontalGroup(
            encabezadoJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(encabezadoJPanelLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(back_Button)
                .addGap(196, 196, 196)
                .addComponent(puestoJLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        encabezadoJPanelLayout.setVerticalGroup(
            encabezadoJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, encabezadoJPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(encabezadoJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(puestoJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(back_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        Apellido_Label.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Apellido_Label.setText("Apellido");

        Nombre_TextField.setToolTipText("Nombre del cliente");
        Nombre_TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Nombre_TextFieldActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("No. Factura");

        NoFactura_TextField1.setToolTipText("Número de factura");
        NoFactura_TextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NoFactura_TextField1ActionPerformed(evt);
            }
        });

        Nombre_jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Nombre_jLabel2.setText("Nombre");

        Apellido_TextField.setToolTipText("Apellido del cliente");
        Apellido_TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Apellido_TextFieldActionPerformed(evt);
            }
        });

        Apellido_Label1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Apellido_Label1.setText("Dirección");

        Direccion_TextField.setToolTipText("Dirección del cliente");
        Direccion_TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Direccion_TextFieldActionPerformed(evt);
            }
        });

        Direccion_Label.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Direccion_Label.setText("Nit");

        Direccion_TextField1.setToolTipText("Búsqueda por NIT");
        Direccion_TextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Direccion_TextField1ActionPerformed(evt);
            }
        });

        Empleado_label.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Empleado_label.setText("Empleado");

        Empleado_TextField.setToolTipText("Empleado");
        Empleado_TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Empleado_TextFieldActionPerformed(evt);
            }
        });

        Fecha_label.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Fecha_label.setText("Fecha");

        Fecha_TextField.setToolTipText("Fecha");
        Fecha_TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Fecha_TextFieldActionPerformed(evt);
            }
        });

        Destacado_checkBox.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Destacado_checkBox.setText("Destacado");
        Destacado_checkBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Destacado_checkBoxActionPerformed(evt);
            }
        });

        Direccion_Label1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Direccion_Label1.setText("Detalle");

        Detalles_TextField.setToolTipText("Detalle de factura");
        Detalles_TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Detalles_TextFieldActionPerformed(evt);
            }
        });

        Consumidor_CheckBox.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Consumidor_CheckBox.setText("Consumidor Final");

        NIT_CheckBox.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        NIT_CheckBox.setText("NIT");
        NIT_CheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NIT_CheckBoxActionPerformed(evt);
            }
        });

        Credito_checkbox.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Credito_checkbox.setText("Crédito");
        Credito_checkbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Credito_checkboxActionPerformed(evt);
            }
        });

        Productos_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Detalle", "Cantidad", "Descuento", "Precio Unidad", "Precio Total"
            }
        ));
        jScrollPane1.setViewportView(Productos_table);

        Agregar_button.setBackground(new java.awt.Color(136, 213, 133));
        Agregar_button.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Agregar_button.setText("Agregar");
        Agregar_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Agregar_buttonMouseClicked(evt);
            }
        });
        Agregar_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Agregar_buttonActionPerformed(evt);
            }
        });

        Eliminar_button.setBackground(new java.awt.Color(255, 0, 0));
        Eliminar_button.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Eliminar_button.setText("Eliminar");

        Destacado_label2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Destacado_label2.setText("Efectivo");
        Destacado_label2.setToolTipText("");
        Destacado_label2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        Efectivo_TextField.setBackground(new java.awt.Color(102, 255, 51));
        Efectivo_TextField.setToolTipText("Cantidad de efectivo");
        Efectivo_TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Efectivo_TextFieldActionPerformed(evt);
            }
        });

        Destacado_label3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Destacado_label3.setText("Cambio");

        Cambio_TextField.setForeground(new java.awt.Color(255, 51, 51));
        Cambio_TextField.setToolTipText("Cambio ");
        Cambio_TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cambio_TextFieldActionPerformed(evt);
            }
        });

        Destacado_label4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        Destacado_label4.setForeground(new java.awt.Color(255, 0, 51));
        Destacado_label4.setText("Total ");

        Total_TextField.setForeground(new java.awt.Color(255, 51, 51));
        Total_TextField.setToolTipText("Total venta");
        Total_TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Total_TextFieldActionPerformed(evt);
            }
        });

        Guardar_Button.setText("Guardar");

        Limpiar_button.setText("Limpiar");

        Buscar_jbutton.setText("Buscar");
        Buscar_jbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Buscar_jbuttonActionPerformed(evt);
            }
        });

        Total_TextField1.setForeground(new java.awt.Color(255, 51, 51));
        Total_TextField1.setToolTipText("Total venta");
        Total_TextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Total_TextField1ActionPerformed(evt);
            }
        });

        Destacado_label5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Destacado_label5.setText("Total Productos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(encabezadoJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Apellido_Label1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Apellido_Label, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                            .addComponent(Nombre_jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Nombre_TextField, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                                    .addComponent(NoFactura_TextField1))
                                .addComponent(Apellido_TextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Direccion_TextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(Empleado_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(Empleado_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(Fecha_label, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(Fecha_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(Destacado_checkBox, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Credito_checkbox, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(Direccion_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Direccion_TextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addComponent(Consumidor_CheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(Buscar_jbutton)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addComponent(NIT_CheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Direccion_Label1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Detalles_TextField))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Destacado_label5, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(Total_TextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                                .addComponent(Destacado_label4, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Total_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 659, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 3, Short.MAX_VALUE)
                                .addComponent(Guardar_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Limpiar_button, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Eliminar_button, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Efectivo_TextField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Destacado_label2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Cambio_TextField)
                            .addComponent(Destacado_label3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Agregar_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(encabezadoJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NoFactura_TextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Fecha_label, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Fecha_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Consumidor_CheckBox)
                                .addComponent(NIT_CheckBox)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Direccion_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Direccion_TextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Buscar_jbutton))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Nombre_jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Nombre_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Destacado_checkBox, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Apellido_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Apellido_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Credito_checkbox, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Empleado_label, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Empleado_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Apellido_Label1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Direccion_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Direccion_Label1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Detalles_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Agregar_button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Eliminar_button)
                        .addGap(27, 27, 27)
                        .addComponent(Destacado_label2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Efectivo_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Destacado_label3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Cambio_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Destacado_label5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Total_TextField1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Total_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Guardar_Button)
                            .addComponent(Limpiar_button)
                            .addComponent(Destacado_label4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void back_ButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back_ButtonMouseClicked
        // TODO add your handling code here:
        Venta VentaWindow = new Venta(conexion, credenciales);
        VentaWindow.setVisible(true);
        dispose();
    }//GEN-LAST:event_back_ButtonMouseClicked

    private void back_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_ButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_back_ButtonActionPerformed

    private void Nombre_TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Nombre_TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Nombre_TextFieldActionPerformed

    private void NoFactura_TextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NoFactura_TextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NoFactura_TextField1ActionPerformed

    private void Apellido_TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Apellido_TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Apellido_TextFieldActionPerformed

    private void Direccion_TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Direccion_TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Direccion_TextFieldActionPerformed

    private void Direccion_TextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Direccion_TextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Direccion_TextField1ActionPerformed

    private void Empleado_TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Empleado_TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Empleado_TextFieldActionPerformed

    private void Fecha_TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Fecha_TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Fecha_TextFieldActionPerformed

    private void Destacado_checkBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Destacado_checkBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Destacado_checkBoxActionPerformed

    private void Detalles_TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Detalles_TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Detalles_TextFieldActionPerformed

    private void Credito_checkboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Credito_checkboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Credito_checkboxActionPerformed

    private void Agregar_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Agregar_buttonMouseClicked
        
    }//GEN-LAST:event_Agregar_buttonMouseClicked

    private void Agregar_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Agregar_buttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Agregar_buttonActionPerformed

    private void Efectivo_TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Efectivo_TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Efectivo_TextFieldActionPerformed

    private void Cambio_TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cambio_TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Cambio_TextFieldActionPerformed

    private void Total_TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Total_TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Total_TextFieldActionPerformed

    private void Buscar_jbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Buscar_jbuttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Buscar_jbuttonActionPerformed

    private void NIT_CheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NIT_CheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NIT_CheckBoxActionPerformed

    private void Total_TextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Total_TextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Total_TextField1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Agregar_button;
    private javax.swing.JLabel Apellido_Label;
    private javax.swing.JLabel Apellido_Label1;
    private javax.swing.JTextField Apellido_TextField;
    private javax.swing.JButton Buscar_jbutton;
    private javax.swing.JTextField Cambio_TextField;
    private javax.swing.JCheckBox Consumidor_CheckBox;
    private javax.swing.JCheckBox Credito_checkbox;
    private javax.swing.JCheckBox Destacado_checkBox;
    private javax.swing.JLabel Destacado_label2;
    private javax.swing.JLabel Destacado_label3;
    private javax.swing.JLabel Destacado_label4;
    private javax.swing.JLabel Destacado_label5;
    private javax.swing.JTextField Detalles_TextField;
    private javax.swing.JLabel Direccion_Label;
    private javax.swing.JLabel Direccion_Label1;
    private javax.swing.JTextField Direccion_TextField;
    private javax.swing.JTextField Direccion_TextField1;
    private javax.swing.JTextField Efectivo_TextField;
    private javax.swing.JButton Eliminar_button;
    private javax.swing.JTextField Empleado_TextField;
    private javax.swing.JLabel Empleado_label;
    private javax.swing.JTextField Fecha_TextField;
    private javax.swing.JLabel Fecha_label;
    private javax.swing.JButton Guardar_Button;
    private javax.swing.JButton Limpiar_button;
    private javax.swing.JCheckBox NIT_CheckBox;
    private javax.swing.JTextField NoFactura_TextField1;
    private javax.swing.JTextField Nombre_TextField;
    private javax.swing.JLabel Nombre_jLabel2;
    private javax.swing.JTable Productos_table;
    private javax.swing.JTextField Total_TextField;
    private javax.swing.JTextField Total_TextField1;
    private javax.swing.JButton back_Button;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel encabezadoJPanel;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel puestoJLabel;
    // End of variables declaration//GEN-END:variables
}
