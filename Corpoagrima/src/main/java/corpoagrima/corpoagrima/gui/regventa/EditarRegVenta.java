/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package corpoagrima.corpoagrima.gui.regventa;
import corpoagrima.corpoagrima.bdMariaDB.ConexionVenta;
import corpoagrima.corpoagrima.bdMariaDB.ConexionProducto;
import corpoagrima.corpoagrima.bdMariaDB.ConexionUsuario;
import corpoagrima.corpoagrima.bdMariaDB.ConexionCliente;
import corpoagrima.corpoagrima.gui.cliente.Cliente;
import corpoagrima.corpoagrima.gui.regcompra.EditarRegFactura;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author User
 */
public final class EditarRegVenta extends javax.swing.JFrame {
    private final Connection conexion;
    private final ResultSet credenciales;
    private String NoFactura;
    private ConexionVenta Venta;
    private ConexionProducto Producto;
    private ConexionUsuario Usuario;
    private ConexionCliente Cliente;
    private int id;
    private boolean edicion;
    private boolean cambiosPorUsuario = true;
    /**
     * Creates new form EditarRegFactura
     * @param conexion
     * @param credenciales
     * @param Factura
     * @throws java.sql.SQLException
     */
    public EditarRegVenta(Connection conexion, ResultSet credenciales, String Factura) throws SQLException {
        this.conexion = conexion;
        this.credenciales = credenciales;
        this.NoFactura = Factura;
        this.Venta = new ConexionVenta();
        this.Producto = new ConexionProducto();
        this.Usuario = new ConexionUsuario();
        this.Cliente = new ConexionCliente();
        edicion();
        initComponents();
        actualizarTablaSinNotificar();
        totales();
    }
    
    public void edicion() throws SQLException{
        ResultSet Datos = Venta.ConsultaEditWindow(conexion, NoFactura);
        if(Datos.next()){
            boolean ClienteDestacado = Datos.getBoolean("Cliente_destacado");
            if(ClienteDestacado == true){
                edicion = true;
            }else{
                edicion = false;
            }
        }
    }
    
    public void initialParams() throws SQLException{
        ResultSet Datos = Venta.ConsultaEditWindow(conexion, NoFactura);
        if (Datos.next()){
            id = Datos.getInt("ID_Venta");
            String NombreCliente = Datos.getString("Nombre");
            String ApellidoCliente = Datos.getString("Apellido");
            String Direccion = Datos.getString("Direccion");
            boolean ClienteDestacado = Datos.getBoolean("Cliente_destacado");
            String FechaFactura = Datos.getString("Fecha");
            String NombreEmpleado = Datos.getString("nombre");
            String NIT = Datos.getString("NIT");
            String Tipo = Datos.getString("Tipo_de_Venta");
            float cambio = Datos.getFloat("Cambio");
            float efectivo = Datos.getFloat("Efectivo");
            String Cambio = String.valueOf(cambio);
            String Efectivo = String.valueOf(efectivo);
            
            // Insercion a los label correspondientes
            NoFactura_TextField1.setText(NoFactura);
            Nombre_TextField.setText(NombreCliente);
            Apellido_TextField.setText(ApellidoCliente);
            Direccion_TextField.setText(Direccion);
            Fecha_TextField.setText(FechaFactura);
            Empleado_TextField.setText(NombreEmpleado);
            NIT_textField.setText(NIT);
            Efectivo_TextField.setText(Efectivo);
            Cambio_TextField.setText(Cambio);
            
            // Habilitacion de los checkBox
            if (ClienteDestacado == true){
                Destacado_checkBox.setSelected(true);
            }
            
            if (NIT.equals("C/F")){
                Consumidor_CheckBox.setSelected(true);
            }else{
                NIT_CheckBox.setSelected(true);
            }
            
            if (Tipo.equals("Crédito")){
                Credito_checkbox.setSelected(true);
            }
            
            
            try (ResultSet productos1 = Venta.ConsultaProductos(conexion, NoFactura)) {
                // Obtener el modelo de la tabla actual
                DefaultTableModel model = (DefaultTableModel) Productos_table.getModel();
                model.setRowCount(0); // Limpiar los datos existentes

                // Agregar nuevas filas al modelo de tabla
                ResultSetMetaData metaData = productos1.getMetaData();
                int columnCount = metaData.getColumnCount();

                while (productos1.next()) {
                    Object[] rowData = new Object[columnCount];
                    for (int i = 0; i < columnCount; i++) {
                        rowData[i] = productos1.getObject(i + 1);
                    }
                    model.addRow(rowData);
                }
            }
            DefaultTableModel model = (DefaultTableModel) Productos_table.getModel();
            
            double total = 0;
            int numFilas = model.getRowCount();
            int totalProductos = 0;
            for (int fila = 0; fila < numFilas; fila++) {
                totalProductos += Integer.parseInt(model.getValueAt(fila, 2).toString());
                total += Double.parseDouble(model.getValueAt(fila, 5).toString());
            }
            TotalProductos_TextField.setText(String.valueOf(totalProductos));
            Total_TextField.setText(String.valueOf(total));
        }
        else{
            JOptionPane.showMessageDialog(this, "No se encontraron resultados",
                    "Busqueda", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    private void actualizarTotalFila(){
        DefaultTableModel model = (DefaultTableModel) Productos_table.getModel();
        int numFilas = model.getRowCount();
         for (int fila = 0; fila < numFilas; fila++) {
            int Cantidad = Integer.parseInt(model.getValueAt(fila, 2).toString());
            double Descuento = Double.parseDouble(model.getValueAt(fila, 3).toString());
            double PrecioUnidad = Double.parseDouble(model.getValueAt(fila, 4).toString());
            double PrecioTotal = (Cantidad * PrecioUnidad) - Descuento;
            model.setValueAt(PrecioTotal, fila, 5);
        }
    }
    
    private void actualizarTablaSinNotificar() throws SQLException {
        // Temporalmente desactivar el TableModelListener
        cambiosPorUsuario = false;
        try {
            // Llamar a actualizarTabla() sin que active el TableModelListener
            initialParams();
        } finally {
            // Reactivar el TableModelListener
            cambiosPorUsuario = true;
        }
    }
    
    private void actualizarTablaSinNotificar2(){
        // Temporalmente desactivar el TableModelListener
        cambiosPorUsuario = false;
        try {
            // Llamar a actualizarTabla() sin que active el TableModelListener
            actualizarTotalFila();
        } finally {
            // Reactivar el TableModelListener
            cambiosPorUsuario = true;
        }
    }
    
    
    
    private void totales() {
        DefaultTableModel model = (DefaultTableModel) Productos_table.getModel();
        model.addTableModelListener((TableModelEvent e) -> {
            if (cambiosPorUsuario && (e.getType() == TableModelEvent.UPDATE || e.getType() == TableModelEvent.INSERT || e.getType() == TableModelEvent.DELETE)) {
                actualizarTablaSinNotificar2();
                int totalProductos = 0;
                double total = 0;
                int numFilas = model.getRowCount();
                for (int fila = 0; fila < numFilas; fila++) {
                    totalProductos += Integer.parseInt(model.getValueAt(fila, 2).toString());
                    total += Double.parseDouble(model.getValueAt(fila, 5).toString());
                }
                TotalProductos_TextField.setText(String.valueOf(totalProductos));
                Total_TextField.setText(String.valueOf(total));
                
                double Efectivo = Double.parseDouble(Efectivo_TextField.getText());
                double Cambio = Efectivo - total;
                
                Cambio_TextField.setText(String.valueOf(Cambio));
            }
        });
    }
    
    public void agregarProducto(int id) throws SQLException {
        ResultSet resultado = Producto.busqueda2(conexion, id);

        // Obtener el modelo de la tabla actual
        DefaultTableModel model = (DefaultTableModel) Productos_table.getModel();

        resultado.next();
        String nombre = resultado.getString("Nombre");
        String descripcion = resultado.getString("Descripcion");
        String precio = resultado.getString("Precio_Venta");

        // Agregar a la tabla
        model.addRow(new Object[]{nombre, descripcion, 0, 0, precio, 0});
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
        NIT_textField = new javax.swing.JTextField();
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
        Total_TextField = new javax.swing.JTextField();
        Guardar_Button = new javax.swing.JButton();
        Limpiar_button = new javax.swing.JButton();
        TotalProductos_TextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        totalProductoLabel = new javax.swing.JLabel();
        totalLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        encabezadoJPanel.setBackground(new java.awt.Color(34, 85, 34));

        puestoJLabel.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        puestoJLabel.setForeground(new java.awt.Color(255, 255, 255));
        puestoJLabel.setText("EDITAR REGISTRO DE VENTA");

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
                .addGap(149, 149, 149)
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
        Nombre_TextField.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Nombre_TextField.setEnabled(false);
        Nombre_TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Nombre_TextFieldActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("No. Factura");

        NoFactura_TextField1.setToolTipText("Número de factura");
        NoFactura_TextField1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        NoFactura_TextField1.setEnabled(false);
        NoFactura_TextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NoFactura_TextField1ActionPerformed(evt);
            }
        });

        Nombre_jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Nombre_jLabel2.setText("Nombre");

        Apellido_TextField.setToolTipText("Apellido del cliente");
        Apellido_TextField.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Apellido_TextField.setEnabled(false);
        Apellido_TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Apellido_TextFieldActionPerformed(evt);
            }
        });

        Apellido_Label1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Apellido_Label1.setText("Dirección");

        Direccion_TextField.setToolTipText("Dirección del cliente");
        Direccion_TextField.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Direccion_TextField.setEnabled(false);
        Direccion_TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Direccion_TextFieldActionPerformed(evt);
            }
        });

        NIT_textField.setToolTipText("Búsqueda por NIT");
        NIT_textField.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        NIT_textField.setEnabled(false);
        NIT_textField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NIT_textFieldActionPerformed(evt);
            }
        });

        Empleado_label.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Empleado_label.setText("Empleado");

        Empleado_TextField.setToolTipText("Empleado");
        Empleado_TextField.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Empleado_TextField.setDoubleBuffered(true);
        Empleado_TextField.setEnabled(false);
        Empleado_TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Empleado_TextFieldActionPerformed(evt);
            }
        });

        Fecha_label.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Fecha_label.setText("Fecha");

        Fecha_TextField.setToolTipText("Fecha");
        Fecha_TextField.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Fecha_TextField.setEnabled(false);
        Fecha_TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Fecha_TextFieldActionPerformed(evt);
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
        Consumidor_CheckBox.setEnabled(false);

        NIT_CheckBox.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        NIT_CheckBox.setText("NIT");
        NIT_CheckBox.setEnabled(false);
        NIT_CheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NIT_CheckBoxActionPerformed(evt);
            }
        });

        Credito_checkbox.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Credito_checkbox.setText("Crédito");
        Credito_checkbox.setEnabled(false);
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
        ) {
            boolean editabl = edicion;
            boolean[] canEdit = new boolean [] {
                false, false, true, true, false, false
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                // Se ajusta la edición de las columnas 2 y 3 según el valor de permitirEdicionColumnas
                if (editabl) {
                    // Si permitirEdicionColumnas es true, las columnas 2 y 3 son editables
                    return canEdit[columnIndex];
                } else {
                    // Si permitirEdicionColumnas es false, solo la columna 2 es editable
                    return columnIndex == 2; // Columna 2
                }
            }
        });
        jScrollPane1.setViewportView(Productos_table);

        Agregar_button.setBackground(new java.awt.Color(136, 213, 133));
        Agregar_button.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Agregar_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/agregar.png"))); // NOI18N
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

        Eliminar_button.setBackground(new java.awt.Color(136, 213, 133));
        Eliminar_button.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Eliminar_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/eliminar.png"))); // NOI18N
        Eliminar_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Eliminar_buttonActionPerformed(evt);
            }
        });

        Destacado_label2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Destacado_label2.setText("Efectivo");
        Destacado_label2.setToolTipText("");
        Destacado_label2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        Efectivo_TextField.setBackground(new java.awt.Color(102, 255, 51));
        Efectivo_TextField.setToolTipText("Cantidad de efectivo");
        Efectivo_TextField.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Efectivo_TextField.setEnabled(false);
        Efectivo_TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Efectivo_TextFieldActionPerformed(evt);
            }
        });

        Destacado_label3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Destacado_label3.setText("Cambio");

        Cambio_TextField.setForeground(new java.awt.Color(255, 51, 51));
        Cambio_TextField.setToolTipText("Cambio ");
        Cambio_TextField.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Cambio_TextField.setEnabled(false);
        Cambio_TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cambio_TextFieldActionPerformed(evt);
            }
        });

        Total_TextField.setEditable(false);
        Total_TextField.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        Total_TextField.setToolTipText("Total venta");
        Total_TextField.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        Total_TextField.setEnabled(false);
        Total_TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Total_TextFieldActionPerformed(evt);
            }
        });

        Guardar_Button.setText("Guardar");
        Guardar_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Guardar_ButtonActionPerformed(evt);
            }
        });

        Limpiar_button.setText("Reestablecer");
        Limpiar_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Limpiar_buttonActionPerformed(evt);
            }
        });

        TotalProductos_TextField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        TotalProductos_TextField.setForeground(new java.awt.Color(255, 51, 51));
        TotalProductos_TextField.setToolTipText("Total venta");
        TotalProductos_TextField.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        TotalProductos_TextField.setEnabled(false);
        TotalProductos_TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TotalProductos_TextFieldActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("AGREGAR");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("ELIMINAR");

        totalProductoLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        totalProductoLabel.setText("Total de productos:");

        totalLabel.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        totalLabel.setForeground(new java.awt.Color(159, 46, 46));
        totalLabel.setText("Total");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(encabezadoJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 699, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(totalProductoLabel)
                        .addGap(18, 18, 18)
                        .addComponent(TotalProductos_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80)
                        .addComponent(totalLabel)
                        .addGap(18, 18, 18)
                        .addComponent(Total_TextField)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addGap(126, 126, 126))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Efectivo_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Cambio_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Guardar_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(Limpiar_button, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(Destacado_label2, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Destacado_label3, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(42, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(125, 125, 125)
                                .addComponent(Agregar_button, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(127, 127, 127)
                                .addComponent(Eliminar_button, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(Apellido_Label, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Nombre_jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                        .addComponent(Apellido_Label1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(Direccion_Label1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Nombre_TextField, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                                    .addComponent(NoFactura_TextField1))
                                .addComponent(Apellido_TextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Direccion_TextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel3)
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
                                    .addGap(87, 87, 87)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Credito_checkbox, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Consumidor_CheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(NIT_CheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(NIT_textField, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                    .addComponent(Detalles_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 692, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(NoFactura_TextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Fecha_label, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Fecha_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(NIT_CheckBox)
                                .addComponent(NIT_textField, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Nombre_jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Nombre_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Destacado_checkBox, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Consumidor_CheckBox)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Apellido_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Apellido_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Credito_checkbox, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Empleado_label, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Empleado_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Apellido_Label1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Direccion_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Direccion_Label1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Detalles_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Agregar_button, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Eliminar_button, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(Destacado_label2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Efectivo_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Destacado_label3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(totalProductoLabel)
                        .addComponent(TotalProductos_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(totalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Total_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Cambio_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Guardar_Button)
                            .addComponent(Limpiar_button))))
                .addGap(22, 22, 22))
        );

        Eliminar_button.getAccessibleContext().setAccessibleName("");

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

    private void NIT_textFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NIT_textFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NIT_textFieldActionPerformed

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
        AgregarProductoRegFactura AgregarWindow = new AgregarProductoRegFactura(conexion, credenciales, this);
        AgregarWindow.setVisible(true);
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

    private void NIT_CheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NIT_CheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NIT_CheckBoxActionPerformed

    private void TotalProductos_TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TotalProductos_TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TotalProductos_TextFieldActionPerformed

    private void Limpiar_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Limpiar_buttonActionPerformed
        try {
            initialParams();
        } catch (SQLException ex) {
            Logger.getLogger(EditarRegVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Limpiar_buttonActionPerformed

    private void Eliminar_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Eliminar_buttonActionPerformed
        int fila = Productos_table.getSelectedRow();
        if (fila != -1) {
            DefaultTableModel model = (DefaultTableModel) Productos_table.getModel();
            model.removeRow(fila);
        }else{
            JOptionPane.showMessageDialog(this, "No se selecionado una fila, porfavor intente de nuevo",
                    "Eliminacion", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_Eliminar_buttonActionPerformed

    private void Guardar_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Guardar_ButtonActionPerformed
        try {
            // datos del Usuario
            String Nombre = Nombre_TextField.getText();
            String Apellido = Apellido_TextField.getText();
            ResultSet ClienteResultSet = Cliente.idCliente2(conexion, Nombre, Apellido);
            ClienteResultSet.next();
            int Cliente = ClienteResultSet.getInt("ID_Cliente");
            // datos de la factura
            int noFactura = Integer.parseInt(NoFactura_TextField1.getText());
            String fecha = Fecha_TextField.getText();
            boolean esCredito = Credito_checkbox.isSelected();
            String credito = (esCredito) ? "Credito" : "Contado";
            float total = Float.parseFloat(Total_TextField.getText());
            // datos registro compra has producto
            String detalle = Detalles_TextField.getText();
            
            // reducir la cantidad de productos de la factura en editar
            ResultSet idProductos = Venta.producto(conexion, noFactura);
            int idProducto;
            String nombreProducto;
            int cantidad;
            float costoUnidad;
            float costoTotal;
            while (idProductos.next()) {
                idProducto = idProductos.getInt("idProducto");
                cantidad = idProductos.getInt("cantidad");
                // actualizar datos producto
                ResultSet productoResult = Producto.cantidad(conexion, idProducto);
                productoResult.next();
                int stock = productoResult.getInt("Stock");
                stock += cantidad;
                Producto.actualizar(conexion, idProducto, stock);
            }
            
            // eliminacion de registros Venta has producto de la factura
            Venta.eliminarRelacion(conexion, id);
            // obtener el estado de si es anulado la factura
            ResultSet estadoResult = Venta.esAnulado(conexion, id);
            estadoResult.next();
            boolean esAnulado = estadoResult.getBoolean("Anulado");
            float efectivo = Float.parseFloat(Efectivo_TextField.getText());
            float Cambio = Float.parseFloat(Cambio_TextField.getText());
            float Total = Float.parseFloat(Total_TextField.getText());
            // actualizar factura compra
            boolean VentaResultSet = Venta.actualizar(conexion, id, esAnulado, Total, Cambio, efectivo );
            if (!VentaResultSet) {
                throw new SQLException("Error al actualizar el registro de compra");
            }
            // recolecion de datos de la tabla
            DefaultTableModel modelo = (DefaultTableModel) Productos_table.getModel();
            int numFilas = modelo.getRowCount();
            for (int fila = 0; fila < numFilas; fila++) {
                nombreProducto = modelo.getValueAt(fila, 0).toString();
                cantidad = Integer.parseInt(modelo.getValueAt(fila, 2).toString());
                costoUnidad = Float.parseFloat(modelo.getValueAt(fila, 4).toString());
                costoTotal = Float.parseFloat(modelo.getValueAt(fila, 5).toString());
                Float descuento = Float.valueOf(modelo.getValueAt(fila, 3).toString());

                // actualizar datos producto
                ResultSet productoResult = Producto.cantidad(conexion, nombreProducto);
                productoResult.next();
                idProducto = productoResult.getInt("ID_Producto");
                int stock = productoResult.getInt("Stock");
                stock -= cantidad;
                Producto.actualizar(conexion, idProducto, stock);
                // guardado registro Venta has producto
                Venta.agregarProducto(conexion, id, idProducto, detalle,
                        cantidad, descuento, costoUnidad, costoTotal);
            }

            if (VentaResultSet) {
                JOptionPane.showMessageDialog(this,
                        "Se ha guardado exitosamente.",
                        "Guardando", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EditarRegVenta.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this,
                    "Se ha producido un error.",
                    "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_Guardar_ButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Agregar_button;
    private javax.swing.JLabel Apellido_Label;
    private javax.swing.JLabel Apellido_Label1;
    private javax.swing.JTextField Apellido_TextField;
    private javax.swing.JTextField Cambio_TextField;
    private javax.swing.JCheckBox Consumidor_CheckBox;
    private javax.swing.JCheckBox Credito_checkbox;
    private javax.swing.JCheckBox Destacado_checkBox;
    private javax.swing.JLabel Destacado_label2;
    private javax.swing.JLabel Destacado_label3;
    private javax.swing.JTextField Detalles_TextField;
    private javax.swing.JLabel Direccion_Label1;
    private javax.swing.JTextField Direccion_TextField;
    private javax.swing.JTextField Efectivo_TextField;
    private javax.swing.JButton Eliminar_button;
    private javax.swing.JTextField Empleado_TextField;
    private javax.swing.JLabel Empleado_label;
    private javax.swing.JTextField Fecha_TextField;
    private javax.swing.JLabel Fecha_label;
    private javax.swing.JButton Guardar_Button;
    private javax.swing.JButton Limpiar_button;
    private javax.swing.JCheckBox NIT_CheckBox;
    private javax.swing.JTextField NIT_textField;
    private javax.swing.JTextField NoFactura_TextField1;
    private javax.swing.JTextField Nombre_TextField;
    private javax.swing.JLabel Nombre_jLabel2;
    private javax.swing.JTable Productos_table;
    private javax.swing.JTextField TotalProductos_TextField;
    private javax.swing.JTextField Total_TextField;
    private javax.swing.JButton back_Button;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel encabezadoJPanel;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel puestoJLabel;
    private javax.swing.JLabel totalLabel;
    private javax.swing.JLabel totalProductoLabel;
    // End of variables declaration//GEN-END:variables
}
