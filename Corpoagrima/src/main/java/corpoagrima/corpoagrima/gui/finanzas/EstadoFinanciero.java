package corpoagrima.corpoagrima.gui.finanzas;

import corpoagrima.corpoagrima.bdMariaDB.ConexionFinanciero;
import corpoagrima.corpoagrima.gui.Principal;
import corpoagrima.corpoagrima.gui.inventario.Inventario;
import corpoagrima.corpoagrima.logic.DatoEstadoFinanciero;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author lisaj
 * @author WilderL
 */
public class EstadoFinanciero extends javax.swing.JFrame {

    private final String ANIOINICIAL = "2024";
    private boolean cambiosPorUsuario = true;
    private String añoSeleccionado;
    private String mesSeleccionado;
    private float[] datoFinanciero;
    private Connection conexion;
    private ResultSet credenciales;
    private TableRowSorter<DefaultTableModel> sorter; // Variable miembro para mantener el TableRowSorter
    private DatoEstadoFinanciero logicFinanciero;
    private ConexionFinanciero financiero;

    /**
     * Creates new form EstadoFinanciero
     */
    public EstadoFinanciero(Connection conexion, ResultSet credenciales) {
        this.conexion = conexion;
        this.credenciales = credenciales;
        this.logicFinanciero = new DatoEstadoFinanciero(conexion);
        this.financiero = new ConexionFinanciero();
        initComponents();
        anios();
        informacionInicial();
        meses(LocalDate.now().getMonthValue());
        mes();
        actualizarTablaSinNotificar();
        modificacionDatoTabla();

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
        regresarJButton = new javax.swing.JButton();
        actualizarJButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        mesjComboBox = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        añojComboBox = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        graficajButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(34, 85, 34));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ESTADO FINANCIERO");

        regresarJButton.setBackground(new java.awt.Color(16, 82, 0));
        regresarJButton.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        regresarJButton.setForeground(new java.awt.Color(248, 244, 227));
        regresarJButton.setText("←");
        regresarJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarJButtonActionPerformed(evt);
            }
        });

        actualizarJButton.setBackground(new java.awt.Color(34, 85, 34));
        actualizarJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/actualizar.png"))); // NOI18N
        actualizarJButton.setBorderPainted(false);
        actualizarJButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                actualizarJButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(regresarJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(114, 114, 114)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                .addComponent(actualizarJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(regresarJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(actualizarJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("MES");

        mesjComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Agosto", "Novimiebre", "Diciembre" }));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("AÑO");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel2)
                .addGap(38, 38, 38)
                .addComponent(mesjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77)
                .addComponent(jLabel3)
                .addGap(35, 35, 35)
                .addComponent(añojComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(añojComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(mesjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Ventas", null},
                {"Costos de Ventas", null},
                {"Utilidad Bruta", null},
                {"Gastos Administrativos", null},
                {"Gastos Operacionales", 0},
                {"Utilidad antes de los Ingresos", null},
                {"Ingresos", 0},
                {"Utilidad antes del ISR", null},
                {"ISR 25%", null},
                {"Utilidad Neta", null}
            },
            new String [] {
                "Descripcion", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex] && (rowIndex == 4 || rowIndex == 6);
            }
        });
        jTable1.setAutoscrolls(false);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(130, 130, 130))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        graficajButton.setText("GRAFICA");
        graficajButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                graficajButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(graficajButton)
                .addGap(28, 28, 28))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addComponent(graficajButton)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void informacionInicial() {
        // Obtener el mes y año actual
        int mesActual = LocalDate.now().getMonthValue(); // Mes actual (1-12)
        int añoActual = LocalDate.now().getYear();       // Año actual

        // Establecer el índice seleccionado en el combo box del mes
        mesjComboBox.setSelectedIndex(mesActual - 1);  // Los índices comienzan desde 0, por lo que restamos 1

        // Establecer el índice seleccionado en el combo box del año
        // Para encontrar el índice del año actual, restamos el año inicial (2024) del año actual y agregamos 1
        añojComboBox.setSelectedIndex(añoActual - Integer.parseInt(ANIOINICIAL));

        actualizarTablaSinNotificar();
    }

    private void modificacionDatoTabla() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        model.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                // Solo realizar acciones si los cambios son iniciados por el usuario
                if (cambiosPorUsuario && (e.getType() == TableModelEvent.UPDATE
                        || e.getType() == TableModelEvent.INSERT || 
                        e.getType() == TableModelEvent.DELETE)) {
                    int filaGastosOperacionales = 4;
                    int filaIngresos = 6;
                    int columnaCantidad = 1;

                    // Verificar si el evento corresponde a la celda (4,1) o (6,1)
                    if ((e.getFirstRow() == filaGastosOperacionales && e.getColumn() == columnaCantidad)
                            || (e.getFirstRow() == filaIngresos && e.getColumn() == columnaCantidad)) {

                        try {
                            int mes = LocalDate.now().getMonthValue(); // Mes actual (1-12)
                            int anio = LocalDate.now().getYear();       // Año actual
                            float valor = Float.parseFloat(model.getValueAt(e.getFirstRow(), columnaCantidad).toString());

                            // Actualizar la base de datos según la celda modificada
                            if (e.getFirstRow() == filaGastosOperacionales) {
                                financiero.actualizarGastosOperacionales(conexion, valor);
                            } else if (e.getFirstRow() == filaIngresos) {
                                financiero.actualizarIngresos(conexion, valor);
                            }
                            actualizarTablaSinNotificar();
                        } catch (SQLException ex) {
                            Logger.getLogger(EstadoFinanciero.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(null, "Ingrese un número válido en la celda.");
                        }
                    }
                }
            }
        });
    }

    // Método para actualizar la tabla sin activar el TableModelListener
    private void actualizarTablaSinNotificar() {
        // Temporalmente desactivar el TableModelListener
        cambiosPorUsuario = false;
        try {
            // Llamar a actualizarTabla() sin que active el TableModelListener
            actualizarTabla();
        } finally {
            // Reactivar el TableModelListener
            cambiosPorUsuario = true;
        }
    }

    private void actualizarTabla() {
        try {
            // Obtener el mes y el año seleccionados
            int mesSeleccionadoIndex = mesjComboBox.getSelectedIndex() + 1; // El índice comienza desde 0
            int añoSeleccionado = Integer.parseInt((String) añojComboBox.getSelectedItem());
            // Obtener el mes y año actual
            int mesActual = LocalDate.now().getMonthValue(); // Mes actual (1-12)
            int añoActual = LocalDate.now().getYear();       // Año actual

            if (mesActual == mesSeleccionadoIndex && añoActual == añoSeleccionado) {
                ResultSet financieroResult = financiero.financieroActual(conexion);
                financieroResult.next();
                float gastosOperativos = financieroResult.getFloat("Gastos_Operacionales");
                float ingresos = financieroResult.getFloat("Ingresos");
                this.datoFinanciero = logicFinanciero.datos(conexion, mesSeleccionadoIndex,
                        añoSeleccionado, gastosOperativos, ingresos);

                // Llenar la tabla con los datos obtenidos de la consulta poniendo solo en la columna 2
                int columna = 1;
                // Llenar la tabla con los valores de la fila actual de la consulta
                for (int fila = 0; fila < jTable1.getRowCount(); fila++) {
                    // El primer valor de la consulta corresponde a la primera columna de la tabla,
                    // por lo que usamos columna + 1 para movernos a través de las columnas de la tabla
                    jTable1.setValueAt(String.valueOf(datoFinanciero[fila]), fila, columna);
                }
                logicFinanciero.actualizarFinanciero(conexion);

            } else {
                // Realizar la consulta a la base de datos con el mes y el año seleccionados
                ResultSet resultadoConsulta = new ConexionFinanciero().consulta(
                        conexion, mesSeleccionadoIndex, añoSeleccionado);

                // Llenar la tabla con los datos obtenidos de la consulta poniendo solo en la columna 2
                int columna = 1;
                while (resultadoConsulta.next()) {
                    // Llenar la tabla con los valores de la fila actual de la consulta
                    for (int fila = 0; fila < jTable1.getRowCount(); fila++) {
                        // El primer valor de la consulta corresponde a la primera columna de la tabla,
                        // por lo que usamos columna + 1 para movernos a través de las columnas de la tabla
                        jTable1.setValueAt(resultadoConsulta.getObject(fila + 1), fila, columna);
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(EstadoFinanciero.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void regresarJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarJButtonActionPerformed
        Principal principal_screen = null;
        try {
            principal_screen = new Principal(conexion, credenciales);
        } catch (SQLException ex) {
            Logger.getLogger(Inventario.class.getName()).log(Level.SEVERE, null, ex);
        }
        principal_screen.setVisible(true);
        principal_screen.setLocationRelativeTo(null);

        // Cerrar la ventana actual
        dispose();
    }//GEN-LAST:event_regresarJButtonActionPerformed

    private void actualizarJButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_actualizarJButtonMouseClicked
        try {
            informacionInicial();
            logicFinanciero.actualizarFinanciero(conexion);
        } catch (SQLException ex) {
            Logger.getLogger(EstadoFinanciero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_actualizarJButtonMouseClicked

    private void graficajButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_graficajButtonActionPerformed
        Grafica grafica_screen = new Grafica(conexion, credenciales);
        grafica_screen.setVisible(true);
        dispose();
    }//GEN-LAST:event_graficajButtonActionPerformed

    private void meses(int mes) {
        int mesactual = LocalDate.now().getMonthValue();
        boolean isMesActual = (mes == mesactual);

        // Establecer la editabilidad de la tabla completa basada en el mes actual
        jTable1.setEnabled(isMesActual);
    }

    private void mes() {
        // Agregar el ItemListener después de haber agregado los años al combo box
        mesjComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    mesSeleccionado = (String) mesjComboBox.getSelectedItem();
                    int mesIndex = mesjComboBox.getSelectedIndex();
                    meses(mesIndex + 1);
                    actualizarTablaSinNotificar();
                    // Mostrar un mensaje de ejemplo con el año seleccionado
                    JOptionPane.showMessageDialog(EstadoFinanciero.this, "Has seleccionado el mes: " + mesSeleccionado);
                }
            }
        });
    }

    private void anios() {
        int anioinicial = Integer.parseInt(ANIOINICIAL);
        int anioactual = LocalDate.now().getYear();
        int anios = anioactual - anioinicial;
        int anio;
        for (int i = 0; i < anios; i++) {
            anio = anioinicial + i;
            añojComboBox.addItem(String.valueOf(anio));
        }
        if (anios == 0) {
            añojComboBox.addItem(ANIOINICIAL);
        }

        // Agregar el ItemListener después de haber agregado los años al combo box
        añojComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    añoSeleccionado = (String) añojComboBox.getSelectedItem();
                    actualizarTablaSinNotificar();
                    // Mostrar un mensaje de ejemplo con el año seleccionado
                    JOptionPane.showMessageDialog(EstadoFinanciero.this, "Has seleccionado el año: " + añoSeleccionado);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actualizarJButton;
    private javax.swing.JComboBox<String> añojComboBox;
    private javax.swing.JButton graficajButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> mesjComboBox;
    private javax.swing.JButton regresarJButton;
    // End of variables declaration//GEN-END:variables
}
