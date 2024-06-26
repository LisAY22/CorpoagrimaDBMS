package corpoagrima.corpoagrima.gui.rrhh;

import corpoagrima.corpoagrima.bdMariaDB.ConexionEmpleado;
import corpoagrima.corpoagrima.bdMariaDB.ConexionPuesto;
import corpoagrima.corpoagrima.bdMariaDB.ConexionUsuario;
import corpoagrima.corpoagrima.bdMariaDB.ConexionTelefono;
import corpoagrima.corpoagrima.gui.Principal;
import corpoagrima.corpoagrima.logic.DatoEstadoFinanciero;
import corpoagrima.corpoagrima.logic.encriptar;
import java.awt.event.ItemEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 * @author lisaj
 * @author WilderL
 */
public final class BuscarEmpleado extends javax.swing.JFrame {

    private Connection conexion;
    private ResultSet credenciales;
    private ConexionEmpleado Empleado;
    private ConexionPuesto Puesto;
    private ConexionUsuario Usuario;
    private ConexionTelefono Telefono;
    private int idPuesto;
    private int idUsuario;
    private int idTelefono;
    private String contrasenia;
    private String idEmpleado;
    private DatoEstadoFinanciero logicFinanciero;

    /**
     * /**
     * Creates new form Empleado
     * @param conexion
     * @param credenciales
     * @param IDEmpleado
     */
    public BuscarEmpleado(Connection conexion, ResultSet credenciales, String IDEmpleado) {
        this.conexion = conexion;
        this.credenciales = credenciales;
        this.idEmpleado = IDEmpleado;
        this.logicFinanciero = new DatoEstadoFinanciero(conexion);
        Empleado = new ConexionEmpleado();
        Puesto = new ConexionPuesto();
        Usuario = new ConexionUsuario();
        Telefono = new ConexionTelefono();
        initComponents();
        comboboxfull();
        if (idEmpleado !=""){
            buscar(idEmpleado);
        }
        else{
        String nombre = (String) Puesto_comboBox.getSelectedItem();
            try {
                sueldoBase(nombre);
            } catch (SQLException ex) {
                Logger.getLogger(BuscarEmpleado.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        // Agregar el WindowListener para detectar el cierre de la ventana
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Aquí colocas el código que deseas ejecutar cuando la ventana se cierre
                try {
                    // TODO add your handling code here:
                    logicFinanciero.actualizarFinanciero(conexion);
                } catch (SQLException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    public final void buscar(String IDString){
        try {
            int IdInt = Integer.parseInt(IDString);
            ResultSet resultado = Empleado.empleadosID(conexion, IdInt);

            if (resultado.next()) { // Verificar si hay resultados antes de acceder a ellos
                int ID = resultado.getInt("ID_Empleado");
                String Nombre = resultado.getString("Nombre");
                String Apellido = resultado.getString("Apellido");
                String NIT = resultado.getString("NIT");
                String Correo = resultado.getString("Correo_electronico");
                String Direccion = resultado.getString("Direccion");
                String Bonificaciones = resultado.getString("Bonificaciones");
                int id_puesto = resultado.getInt("Puesto_ID_Puesto");
                int id_usuario = resultado.getInt("Usuario_ID_Usuario");
                String ajusteSueldo = resultado.getString("Ajuste_Sueldo");

                //Consulta de puesto y sueldo
                ResultSet resultadoPuesto = Puesto.puestoId(conexion, id_puesto);

                if (resultadoPuesto.next()) { // Verificar si hay resultados antes de acceder a ellos
                    idPuesto = id_puesto;
                    String puesto = resultadoPuesto.getString("Nombre");
                    Float salario = resultadoPuesto.getFloat("Salario_Base");

                    // Tercera consulta para obtener el nombre de usuario 
                    ResultSet resultadoUsuario = Usuario.usuario(conexion, id_usuario);

                    if (resultadoUsuario.next()) { // Verificar si hay resultados antes de acceder a ellos
                        idUsuario = resultadoUsuario.getInt("ID_Usuario");
                        String Nombre_usuario = resultadoUsuario.getString("Nombre");
                        String contrasenia = resultadoUsuario.getString("Contraseña");
                        this.contrasenia = contrasenia;

                        // Cuarta consulta para obtener el numero de telefono
                        ResultSet resultadoTelefono = Telefono.telefono(conexion, ID, "Empleado");

                        if (resultadoTelefono.next()) { // Verificar si hay resultados antes de acceder a ellos
                            idTelefono = resultadoTelefono.getInt("ID_Telefono");
                            String telefono = resultadoTelefono.getString("Numero");

                            // Insertar en los textfield la informacion y habilitarlos
                            ID_textfield.setText(String.valueOf(ID));
                            Nombre_textField.setText(Nombre);
                            Apellido_textField.setText(Apellido);
                            NIT_textfield.setText(NIT);
                            Correo_textfield.setText(Correo);
                            Direccion_textfield.setText(Direccion);
                            Bonificaciones_textfield.setText(Bonificaciones);
                            Telefono_textfield.setText(telefono);
                            AjusteSueldo_textfield.setText(ajusteSueldo);

                            //Autoajustar el combobox para que aparezca por defecto el que tiene en puesto
                            String[] itemsArray = getComboBoxItems(Puesto_comboBox);

                            int indice = -1;

                            for (int i = 0; i < itemsArray.length; i++) {
                                if (itemsArray[i].equals(puesto)) {
                                    indice = i;
                                    break;
                                }
                            }

                            // Si se encontró una coincidencia, establecer ese índice como la selección predeterminada
                            if (indice != -1) {
                                Puesto_comboBox.setSelectedIndex(indice);
                            } else {
                                // Si no se encontró ninguna coincidencia, mostrar un mensaje de error
                                JOptionPane.showMessageDialog(null, "No se encontró ninguna coincidencia para el texto en las opciones del ComboBox.", "Error", JOptionPane.ERROR_MESSAGE);
                            }

                            Sueldobase_textfield.setText(String.valueOf(salario));
                            Usuario_textfield.setText(Nombre_usuario);
                            contrasena_textfield1.setText(contrasenia);

                            Buscar_jButton.setEnabled(false);
                            Buscar_textField.setEnabled(false);

                            //Habilitar botones de guardado, borrar y limpiar
                            Delete_button.setEnabled(true);
                            Save_button.setEnabled(true);
                            Clean_button.setEnabled(true);

                            Enable();
                        } else {
                            JOptionPane.showMessageDialog(null, "No se encontró ningún resultado para el número de teléfono.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró ningún resultado para el usuario.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró ningún resultado para el puesto y salario.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ningún resultado para el ID especificado.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al consultar los datos", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingrese correctamente el Id",
                    "Busqueda", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    public void Enable() {
        Apellido_textField.setEditable(true);
        Bonificaciones_textfield.setEditable(true);
        Buscar_textField.setEditable(true);
        Correo_textfield.setEditable(true);
        Direccion_textfield.setEditable(true);
        NIT_textfield.setEditable(true);
        Nombre_textField.setEditable(true);
        Telefono_textfield.setEditable(true);
        Usuario_textfield.setEditable(true);
        contrasena_textfield1.setEditable(true);
        AjusteSueldo_textfield.setEditable(true);
        Puesto_comboBox.setEnabled(true);
    }

    public void comboboxfull() {
        try {
            ResultSet puestos = Puesto.puestos(conexion);

            while (puestos.next()) {
                String puesto = puestos.getString("Nombre");
                Puesto_comboBox.addItem(puesto);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se encontró ningún empleado para el ComboBox.", "Error", JOptionPane.ERROR_MESSAGE);
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
        Buscar_textField.setText("");
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

    private BuscarEmpleado() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        Encabezado_panel = new javax.swing.JPanel();
        Encabezad_panel2 = new javax.swing.JLabel();
        back_Button = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        Buscar_textField = new javax.swing.JTextField();
        Buscar_jButton = new javax.swing.JButton();
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
        Save_button = new javax.swing.JButton();
        Clean_button = new javax.swing.JButton();
        Delete_button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Encabezado_panel.setBackground(new java.awt.Color(34, 85, 34));

        Encabezad_panel2.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        Encabezad_panel2.setForeground(new java.awt.Color(255, 255, 255));
        Encabezad_panel2.setText("Empleados");

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

        javax.swing.GroupLayout Encabezado_panelLayout = new javax.swing.GroupLayout(Encabezado_panel);
        Encabezado_panel.setLayout(Encabezado_panelLayout);
        Encabezado_panelLayout.setHorizontalGroup(
            Encabezado_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Encabezado_panelLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(back_Button)
                .addGap(275, 275, 275)
                .addComponent(Encabezad_panel2, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                .addGap(363, 363, 363))
        );
        Encabezado_panelLayout.setVerticalGroup(
            Encabezado_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Encabezado_panelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(Encabezado_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Encabezad_panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(back_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        Buscar_textField.setToolTipText("Ingrese el ID del usuario");

        Buscar_jButton.setBackground(new java.awt.Color(136, 213, 133));
        Buscar_jButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lupa.png"))); // NOI18N
        Buscar_jButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Buscar_jButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(Buscar_jButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(Buscar_textField, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(761, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Buscar_jButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Buscar_textField))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("NIT");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Sueldo base");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Apellido");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("Nombre");

        Nombre_textField.setEditable(false);
        Nombre_textField.setToolTipText("Ingrese Nombre");

        Apellido_textField.setEditable(false);
        Apellido_textField.setToolTipText("Ingrese Apellido");

        NIT_textfield.setEditable(false);
        NIT_textfield.setToolTipText("Ingrese NIT");

        Correo_textfield.setEditable(false);
        Correo_textfield.setToolTipText("Ingrese correo electrónico");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setText("Dirección");

        Direccion_textfield.setEditable(false);
        Direccion_textfield.setToolTipText("Ingrese dirección");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setText("Bonificaciones ");

        Bonificaciones_textfield.setEditable(false);
        Bonificaciones_textfield.setToolTipText("Ingrese bonificaciones");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setText("Correo electrónico");

        Puesto_comboBox.setEnabled(false);
        Puesto_comboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                Puesto_comboBoxItemStateChanged(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel12.setText("Puesto");

        Sueldobase_textfield.setEditable(false);
        Sueldobase_textfield.setToolTipText("Sueldo en Quetzales");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel13.setText("Contraseña");

        Usuario_textfield.setEditable(false);
        Usuario_textfield.setToolTipText("Ingrese Usuario");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel15.setText("Teléfono");

        Telefono_textfield.setEditable(false);
        Telefono_textfield.setToolTipText("Ingrese Teléfono");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel16.setText("Usuario");

        contrasena_textfield1.setEditable(false);
        contrasena_textfield1.setToolTipText("Ingrese contraseña");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel14.setText("ID");

        ID_textfield.setEditable(false);
        ID_textfield.setToolTipText("ID del empleado");
        ID_textfield.setEnabled(false);

        Ajuste_label.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Ajuste_label.setText("Ajuste sueldo");

        AjusteSueldo_textfield.setEditable(false);
        AjusteSueldo_textfield.setToolTipText("Ajuste de sueldo en Quetzales");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Ajuste_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Usuario_textfield)
                    .addComponent(Sueldobase_textfield, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                    .addComponent(contrasena_textfield1)
                    .addComponent(Puesto_comboBox, 0, 280, Short.MAX_VALUE)
                    .addComponent(AjusteSueldo_textfield, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE))
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

        Save_button.setText("Guardar");
        Save_button.setEnabled(false);
        Save_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Save_buttonActionPerformed(evt);
            }
        });

        Clean_button.setText("Limpiar ");
        Clean_button.setEnabled(false);
        Clean_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Clean_buttonActionPerformed(evt);
            }
        });

        Delete_button.setBackground(new java.awt.Color(255, 51, 51));
        Delete_button.setText("Eliminar");
        Delete_button.setEnabled(false);
        Delete_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Delete_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Delete_button)
                .addGap(18, 18, 18)
                .addComponent(Clean_button)
                .addGap(18, 18, 18)
                .addComponent(Save_button)
                .addGap(25, 25, 25))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Delete_button)
                    .addComponent(Clean_button)
                    .addComponent(Save_button))
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Encabezado_panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(800, 800, 800)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 97, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Encabezado_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Delete_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Delete_buttonActionPerformed
        String id = ID_textfield.getText();
        int IdInt = Integer.parseInt(id);

        try {
            int opcion = JOptionPane.showConfirmDialog(null,
                    "¿Quieres continuar?\nSe eliminara el empleado permanentemente",
                    "Eliminar Empleado", JOptionPane.YES_NO_OPTION);

            // Comprobar la opción seleccionada
            if (opcion == JOptionPane.YES_OPTION) {
                boolean resultSet = Empleado.eliminar(conexion, IdInt);
                boolean resultUsuario = Usuario.eliminar(conexion, idUsuario);
                if (resultSet && resultUsuario) {
                    JOptionPane.showMessageDialog(this,
                            "Se ha eliminado exitosamente el empleado.",
                            "Eliminar Empleado", JOptionPane.INFORMATION_MESSAGE);
                    reset();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(BuscarEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Ha habido un error "
                    + "compruebe la información", "Eliminar empleado",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_Delete_buttonActionPerformed

    private void reset() {
        Clean();
        Buscar_jButton.setEnabled(true);
        Buscar_textField.setEditable(true);
        Buscar_textField.setEnabled(true);
        ID_textfield.setEditable(false);
        Nombre_textField.setEditable(false);
        Apellido_textField.setEditable(false);
        NIT_textfield.setEditable(false);
        AjusteSueldo_textfield.setEditable(false);
        Correo_textfield.setEditable(false);
        Direccion_textfield.setEditable(false);
        Bonificaciones_textfield.setEditable(false);
        Telefono_textfield.setEditable(false);
        Puesto_comboBox.setEnabled(false);
        Usuario_textfield.setEditable(false);
        contrasena_textfield1.setEditable(false);
        Delete_button.setEnabled(false);
        Clean_button.setEnabled(false);
        Save_button.setEnabled(false);
    }

    private void Clean_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Clean_buttonActionPerformed
        reset();
    }//GEN-LAST:event_Clean_buttonActionPerformed

    private void sueldoBase(String nombre) throws SQLException {
        ResultSet result = Puesto.puestoNombre(conexion, nombre);
        result.next();
        String salario = String.valueOf(result.getFloat("Salario_Base"));
        Sueldobase_textfield.setText(salario);
    }

    private void Buscar_jButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Buscar_jButtonActionPerformed
        String IDString = Buscar_textField.getText();
        buscar(IDString);
    }//GEN-LAST:event_Buscar_jButtonActionPerformed

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
            int idPuesto;

            ResultSet restPuesto = Puesto.puestoID(conexion, puesto);

            restPuesto.next();

            idPuesto = restPuesto.getInt("ID_Puesto");
            boolean resultUsuario;
            boolean resultTelefono = Telefono.actualizar(conexion, telefono, idTelefono);
            if (this.contrasenia.equals(contrasenia)) {
                resultUsuario = Usuario.actualizarSinContrasenia(conexion, usuario, idUsuario);
            } else {
                String contraseniaEncriptada = encriptar.encriptarContrasenia(contrasenia);
                resultUsuario = Usuario.actualizar(conexion, usuario, contraseniaEncriptada, idUsuario);
            }

            boolean resultSet = Empleado.actualizar(conexion, idEmpleado, nombre,
                    apellido, nit, correoElectronico, direccion, ajusteSueldo,
                    bonificaciones, idPuesto, idUsuario);

            if (resultSet && resultTelefono && resultUsuario) {
                JOptionPane.showMessageDialog(this,
                        "Se ha guardado exitosamente el empleado.",
                        "Guardar Empleado", JOptionPane.INFORMATION_MESSAGE);
                reset();
            }
        } catch (SQLException ex) {
            Logger.getLogger(BuscarEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Ha habido un error "
                    + "compruebe la información", "Guardar Emplrado",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_Save_buttonActionPerformed

    private void Puesto_comboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_Puesto_comboBoxItemStateChanged
        Puesto_comboBox.addItemListener((ItemEvent e) -> {
            if (evt.getStateChange() == ItemEvent.SELECTED) {
                try {
                    String nombre = (String) Puesto_comboBox.getSelectedItem();
                    sueldoBase(nombre);
                } catch (SQLException ex) {
                    Logger.getLogger(BuscarEmpleado.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

    }//GEN-LAST:event_Puesto_comboBoxItemStateChanged

    private void back_ButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back_ButtonMouseClicked
        // TODO add your handling code here:
        try {
            RRHH rh_window = new RRHH(conexion, credenciales);
            rh_window.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(BuscarEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
    }//GEN-LAST:event_back_ButtonMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AjusteSueldo_textfield;
    private javax.swing.JLabel Ajuste_label;
    private javax.swing.JTextField Apellido_textField;
    private javax.swing.JTextField Bonificaciones_textfield;
    private javax.swing.JButton Buscar_jButton;
    private javax.swing.JTextField Buscar_textField;
    private javax.swing.JButton Clean_button;
    private javax.swing.JTextField Correo_textfield;
    private javax.swing.JButton Delete_button;
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
    private javax.swing.JButton back_Button;
    private javax.swing.JTextField contrasena_textfield1;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables
}
