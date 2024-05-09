package corpoagrima.corpoagrima.gui.regcompra;

import corpoagrima.corpoagrima.bdMariaDB.ConexionCompra;
import corpoagrima.corpoagrima.bdMariaDB.ConexionProducto;
import corpoagrima.corpoagrima.bdMariaDB.ConexionProveedores;
import corpoagrima.corpoagrima.bdMariaDB.ConexionRegCompraProducto;
import java.awt.event.ItemEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author karol
 * @author WilderL
 */
public class EditarRegFactura extends javax.swing.JFrame {

    private Connection conexion;
    private ResultSet credenciales;
    private ConexionCompra compras;
    private ConexionProducto producto;
    private ConexionProveedores proveedor;
    private ConexionRegCompraProducto compraProducto;
    private String factura;
    private int id;

    /**
     * Creates new form editarRegFactura
     */
    public EditarRegFactura(Connection conexion, ResultSet credenciales, String numeroFactura) throws SQLException {
        this.conexion = conexion;
        this.credenciales = credenciales;
        this.factura = numeroFactura;
        producto = new ConexionProducto();
        compras = new ConexionCompra();
        proveedor = new ConexionProveedores();
        compraProducto = new ConexionRegCompraProducto();
        initComponents();
        datosTotales();
        mostrarInformacion();
    }

    public final void mostrarInformacion() throws SQLException {
        ResultSet rs = compras.busqueda(conexion, factura);
        if (rs.next()) {
            id = rs.getInt("ID_Compra");
            String NoFactura = factura;
            String fecha = rs.getString("Fecha");
            String nit = rs.getString("NIT");
            String tipoCompra = rs.getString("Tipo_Compra");
            String nombreUsuario = rs.getString("Nombre");
            String apellidoUsuario = rs.getString("Apellido");
            String nombreCompletoUsuario = nombreUsuario + " " + apellidoUsuario;
            String detalle = rs.getString("Detalle");
            double total = rs.getDouble("Total");

            if ("Credito".equals(tipoCompra)) {
                creditoCheckBox.setSelected(true);
            } else {
                creditoCheckBox.setSelected(false);
            }
            ConexionProveedores proveedor = new ConexionProveedores();
            ResultSet listaProveedor = proveedor.consulta(conexion);
            String nombreProveedor;
            Object items = Proveedor_comboBox.getSelectedItem();
            if (items != null) {
                Proveedor_comboBox.removeAllItems();
            }
            while (listaProveedor.next()) {
                nombreProveedor = listaProveedor.getString("Empresa");
                Proveedor_comboBox.addItem(nombreProveedor);
            }
            String nombre = (String) Proveedor_comboBox.getSelectedItem();
            datoProveedor(nombre);
            numeroFacturaTextfield.setText(NoFactura);
            fechaTextfield.setText(fecha);
            EmpleadoTextfield.setText(nombreCompletoUsuario);
            detalle_textfield1.setText(detalle);
            totalFinalJTextField.setText(String.valueOf(total));

            // Obtener el modelo de la tabla actual
            try (ResultSet productos = compras.busqueda2(conexion, factura)) {
                // Obtener el modelo de la tabla actual
                DefaultTableModel model = (DefaultTableModel) listProductoJTable.getModel();
                model.setRowCount(0); // Limpiar los datos existentes

                // Agregar nuevas filas al modelo de tabla
                ResultSetMetaData metaData = productos.getMetaData();
                int columnCount = metaData.getColumnCount();

                while (productos.next()) {
                    Object[] rowData = new Object[columnCount];
                    for (int i = 0; i < columnCount; i++) {
                        rowData[i] = productos.getObject(i + 1);
                    }
                    model.addRow(rowData);
                }
            }

        } else {
            JOptionPane.showMessageDialog(this, "No se encontraron resultados",
                    "Busqueda", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void datosTotales() {
        DefaultTableModel model = (DefaultTableModel) listProductoJTable.getModel();

        model.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                if (e.getType() == TableModelEvent.UPDATE || e.getType() == TableModelEvent.INSERT || e.getType() == TableModelEvent.DELETE) {
                    int totalProductos = 0;
                    double total = 0;
                    int numFilas = model.getRowCount();
                    for (int fila = 0; fila < numFilas; fila++) {
                        totalProductos += Integer.parseInt(model.getValueAt(fila, 3).toString());
                        total += Double.parseDouble(model.getValueAt(fila, 5).toString());
                    }

                    totalProductoJTextField.setText(String.valueOf(totalProductos));
                    totalFinalJTextField.setText(String.valueOf(total));
                }
            }
        });
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
        jLabel1 = new javax.swing.JLabel();
        Regresar_Bn = new javax.swing.JButton();
        agregarJLabel = new javax.swing.JLabel();
        AgregarBn = new javax.swing.JButton();
        listProductoJScrollPane = new javax.swing.JScrollPane();
        listProductoJTable = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        Reestablecer_button = new javax.swing.JButton();
        Guardar_button = new javax.swing.JButton();
        eliminarJLabel = new javax.swing.JLabel();
        EliminarBn = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        FechaLabel = new javax.swing.JLabel();
        noFacturaLabel = new javax.swing.JLabel();
        fechaTextfield = new javax.swing.JTextField();
        Telefonotextfield = new javax.swing.JTextField();
        empleadoLabel = new javax.swing.JLabel();
        EmpleadoTextfield = new javax.swing.JTextField();
        nitLabel = new javax.swing.JLabel();
        nitTextfield = new javax.swing.JTextField();
        telefonoLabel = new javax.swing.JLabel();
        ProveedorLabel = new javax.swing.JLabel();
        numeroFacturaTextfield = new javax.swing.JTextField();
        creditoCheckBox = new javax.swing.JCheckBox();
        Proveedor_comboBox = new javax.swing.JComboBox<>();
        CantidadComprasLabel1 = new javax.swing.JLabel();
        detalle_textfield1 = new javax.swing.JTextField();
        totalProductoLabel = new javax.swing.JLabel();
        totalProductoJTextField = new javax.swing.JTextField();
        totalFinalLabel = new javax.swing.JLabel();
        totalFinalJTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(34, 85, 34));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("EDITAR REGISTRO FACTURA");

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
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(Regresar_Bn, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(249, 249, 249)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Regresar_Bn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        agregarJLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        agregarJLabel.setText("AGREGAR");

        AgregarBn.setBackground(new java.awt.Color(136, 213, 133));
        AgregarBn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/agregar.png"))); // NOI18N
        AgregarBn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarBnActionPerformed(evt);
            }
        });

        listProductoJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Detalle", "Marca", "Cantidad", "Costo por unidad", "Subtotal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        listProductoJScrollPane.setViewportView(listProductoJTable);

        Reestablecer_button.setText("Reestablecer");
        Reestablecer_button.setEnabled(true);
        Reestablecer_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Reestablecer_buttonActionPerformed(evt);
            }
        });

        Guardar_button.setText("Guardar");
        Guardar_button.setEnabled(true);
        Guardar_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Guardar_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(889, Short.MAX_VALUE)
                .addComponent(Guardar_button)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Reestablecer_button)
                .addGap(52, 52, 52))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Reestablecer_button)
                    .addComponent(Guardar_button))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        eliminarJLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        eliminarJLabel.setText("ELIMINAR");

        EliminarBn.setBackground(new java.awt.Color(136, 213, 133));
        EliminarBn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/eliminar.png"))); // NOI18N
        EliminarBn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarBnActionPerformed(evt);
            }
        });

        FechaLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        FechaLabel.setText("Fecha");

        noFacturaLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        noFacturaLabel.setText("No. Factura");

        fechaTextfield.setEditable(true);
        fechaTextfield.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        Telefonotextfield.setEditable(false);
        Telefonotextfield.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        empleadoLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        empleadoLabel.setText("Empleado");

        EmpleadoTextfield.setEditable(false);
        EmpleadoTextfield.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        nitLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        nitLabel.setText("NIT");

        nitTextfield.setEditable(false);
        nitTextfield.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        telefonoLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        telefonoLabel.setText("Teléfono");

        ProveedorLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ProveedorLabel.setText("Proveedor");

        numeroFacturaTextfield.setEditable(true
        );
        numeroFacturaTextfield.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        creditoCheckBox.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        creditoCheckBox.setText("Credito");
        creditoCheckBox.setEnabled(true);

        Proveedor_comboBox.setEnabled(true);
        Proveedor_comboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                Proveedor_comboBoxItemStateChanged(evt);
            }
        });

        CantidadComprasLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        CantidadComprasLabel1.setText("Detalle");

        detalle_textfield1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ProveedorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(FechaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(Proveedor_comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(fechaTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(creditoCheckBox)
                                .addGap(149, 149, 149))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(noFacturaLabel)
                        .addGap(18, 18, 18)
                        .addComponent(numeroFacturaTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(empleadoLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(EmpleadoTextfield))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(telefonoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Telefonotextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(117, 117, 117)
                                .addComponent(nitLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nitTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(CantidadComprasLabel1)
                                .addGap(38, 38, 38)
                                .addComponent(detalle_textfield1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(95, 95, 95))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Telefonotextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(telefonoLabel))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(EmpleadoTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(empleadoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(numeroFacturaTextfield, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(noFacturaLabel)
                                .addComponent(nitLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(nitTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(creditoCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(fechaTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(FechaLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CantidadComprasLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ProveedorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Proveedor_comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(detalle_textfield1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        totalProductoLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        totalProductoLabel.setText("Total de productos:");

        totalProductoJTextField.setEditable(false);
        totalProductoJTextField.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N

        totalFinalLabel.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        totalFinalLabel.setForeground(new java.awt.Color(159, 46, 46));
        totalFinalLabel.setText("Total:");

        totalFinalJTextField.setEditable(false);
        totalFinalJTextField.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(totalProductoLabel)
                        .addGap(18, 18, 18)
                        .addComponent(totalProductoJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(totalFinalLabel)
                        .addGap(18, 18, 18)
                        .addComponent(totalFinalJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addComponent(listProductoJScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 912, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(EliminarBn, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AgregarBn, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(agregarJLabel)
                            .addComponent(eliminarJLabel))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(listProductoJScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(agregarJLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(AgregarBn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(eliminarJLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(EliminarBn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(totalProductoLabel)
                            .addComponent(totalProductoJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(totalFinalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalFinalJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void agregarProducto(int id) throws SQLException {
        ResultSet resultado = producto.busqueda2(conexion, id);

        // Obtener el modelo de la tabla actual
        DefaultTableModel model = (DefaultTableModel) listProductoJTable.getModel();

        resultado.next();
        String nombre = resultado.getString("Nombre");
        String descripcion = resultado.getString("Descripcion");
        String marca = resultado.getString("Marca");

        // Agregar a la tabla
        model.addRow(new Object[]{nombre, descripcion, marca, null, null, null, null});

    }

    private void Regresar_BnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Regresar_BnActionPerformed
        // TODO add your handling code here:
        Compra compra_screen = new Compra(conexion, credenciales);
        compra_screen.setVisible(true);
        // Cerrar la ventana actual
        dispose();
    }//GEN-LAST:event_Regresar_BnActionPerformed

    private void Reestablecer_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Reestablecer_buttonActionPerformed
        try {
            mostrarInformacion();
        } catch (SQLException ex) {
            Logger.getLogger(EditarRegFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Reestablecer_buttonActionPerformed

    private void EliminarBnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarBnActionPerformed
        // TODO add your handling code here:
        int fila = listProductoJTable.getSelectedRow();
        if (fila != -1) {
            DefaultTableModel model = (DefaultTableModel) listProductoJTable.getModel();
            model.removeRow(fila);
        }
    }//GEN-LAST:event_EliminarBnActionPerformed

    private void Proveedor_comboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_Proveedor_comboBoxItemStateChanged
        Proveedor_comboBox.addItemListener((ItemEvent e) -> {
            if (evt.getStateChange() == ItemEvent.SELECTED) {
                try {
                    String nombre = (String) Proveedor_comboBox.getSelectedItem();
                    datoProveedor(nombre);
                } catch (SQLException ex) {
                    Logger.getLogger(NuevoRegFactura.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }//GEN-LAST:event_Proveedor_comboBoxItemStateChanged

    private void AgregarBnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarBnActionPerformed
        // TODO add your handling code here:
        AgregarPRegFactura AgregarWindow = new AgregarPRegFactura(conexion, credenciales, this);
        AgregarWindow.setVisible(true);
    }//GEN-LAST:event_AgregarBnActionPerformed

    private void Guardar_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Guardar_buttonActionPerformed
        try {
            // datos del proveedor
            String nombreProveedor = (String) Proveedor_comboBox.getSelectedItem();
            ResultSet proveedorResultSet = this.proveedor.idProveedor(conexion, nombreProveedor);
            proveedorResultSet.next();
            int idProveedor = proveedorResultSet.getInt("ID_Proveedor");
            // datos de la factura
            String noFactura = numeroFacturaTextfield.getText();
            String fecha = fechaTextfield.getText();
            boolean esCredito = creditoCheckBox.isSelected();
            String credito = (esCredito) ? "Credito" : "Contado";
            float total = Float.parseFloat(totalFinalJTextField.getText());
            // datos registro compra has producto
            String detalle = detalle_textfield1.getText();
            // reducir la cantidad de productos de la factura en editar
            ResultSet idProductos = compraProducto.producto(conexion, id);
            int idProducto;
            String nombreProducto;
            int cantidad;
            float costoUnidad;
            float costoTotal;
            while (idProductos.next()) {
                idProducto = idProductos.getInt("idProducto");
                cantidad = idProductos.getInt("cantidad");
                // actualizar datos producto
                ResultSet productoResult = producto.cantidad(conexion, idProducto);
                productoResult.next();
                int stock = productoResult.getInt("Stock");
                stock -= cantidad;
                producto.actualizar(conexion, idProducto, stock);
            }
            // eliminacion de registros compra has producto de la factura
            compraProducto.eliminarRelacion(conexion, id);
            // obtener el estado de si es anulado la factura
            ResultSet estadoResult = compras.esAnulado(conexion, id);
            estadoResult.next();
            boolean esAnulado = estadoResult.getBoolean("Anulado");
            // actualizar factura compra
            boolean compraResultSet = compras.actualizar(conexion, id, noFactura,
                    esAnulado, fecha, credito, total, idProveedor);
            if (!compraResultSet) {
                throw new SQLException("Error al actualizar el registro de compra");
            }
            // recolecion de datos de la tabla
            DefaultTableModel modelo = (DefaultTableModel) listProductoJTable.getModel();
            int numFilas = modelo.getRowCount();
            for (int fila = 0; fila < numFilas; fila++) {
                nombreProducto = modelo.getValueAt(fila, 0).toString();
                cantidad = Integer.parseInt(modelo.getValueAt(fila, 3).toString());
                costoUnidad = Integer.parseInt(modelo.getValueAt(fila, 4).toString());
                costoTotal = Integer.parseInt(modelo.getValueAt(fila, 5).toString());

                // actualizar datos producto
                ResultSet productoResult = producto.cantidad(conexion, nombreProducto);
                productoResult.next();
                idProducto = productoResult.getInt("ID_Producto");
                int stock = productoResult.getInt("Stock");
                stock += cantidad;
                producto.actualizar(conexion, idProducto, stock);
                // guardado registro compra has producto
                compraProducto.agregar(conexion, id, idProducto, detalle,
                        cantidad, costoUnidad, costoTotal);
            }

            if (compraResultSet) {
                JOptionPane.showMessageDialog(this,
                        "Se ha guardado exitosamente.",
                        "Guardando", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EditarRegFactura.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this,
                    "Se ha producido un error.",
                    "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_Guardar_buttonActionPerformed

    private void datoProveedor(String nombre) throws SQLException {
        ResultSet proveedor = new ConexionProveedores().proveedor2(conexion, nombre);
        if (proveedor.next()) { // Verifica si hay al menos una fila en el ResultSet
            String numero = proveedor.getString("Numero");
            String nit = proveedor.getString("NIT");
            Telefonotextfield.setText(numero);
            nitTextfield.setText(nit);
        } else {
            // Maneja el caso en el que no se encontraron resultados
            Telefonotextfield.setText("");
            nitTextfield.setText("");
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AgregarBn;
    private javax.swing.JLabel CantidadComprasLabel1;
    private javax.swing.JButton EliminarBn;
    private javax.swing.JTextField EmpleadoTextfield;
    private javax.swing.JLabel FechaLabel;
    private javax.swing.JButton Guardar_button;
    private javax.swing.JLabel ProveedorLabel;
    private javax.swing.JComboBox<String> Proveedor_comboBox;
    private javax.swing.JButton Reestablecer_button;
    private javax.swing.JButton Regresar_Bn;
    private javax.swing.JTextField Telefonotextfield;
    private javax.swing.JLabel agregarJLabel;
    private javax.swing.JCheckBox creditoCheckBox;
    private javax.swing.JTextField detalle_textfield1;
    private javax.swing.JLabel eliminarJLabel;
    private javax.swing.JLabel empleadoLabel;
    private javax.swing.JTextField fechaTextfield;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane listProductoJScrollPane;
    private javax.swing.JTable listProductoJTable;
    private javax.swing.JLabel nitLabel;
    private javax.swing.JTextField nitTextfield;
    private javax.swing.JLabel noFacturaLabel;
    private javax.swing.JTextField numeroFacturaTextfield;
    private javax.swing.JLabel telefonoLabel;
    private javax.swing.JTextField totalFinalJTextField;
    private javax.swing.JLabel totalFinalLabel;
    private javax.swing.JTextField totalProductoJTextField;
    private javax.swing.JLabel totalProductoLabel;
    // End of variables declaration//GEN-END:variables
}
