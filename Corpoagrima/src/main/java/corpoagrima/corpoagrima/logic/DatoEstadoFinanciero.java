package corpoagrima.corpoagrima.logic;

import corpoagrima.corpoagrima.bdMariaDB.ConexionCompra;
import corpoagrima.corpoagrima.bdMariaDB.ConexionEmpleado;
import corpoagrima.corpoagrima.bdMariaDB.ConexionFinanciero;
import corpoagrima.corpoagrima.bdMariaDB.ConexionVenta;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 *
 * @author WilderL
 */
public class DatoEstadoFinanciero {

    private Connection conexion;
    private ConexionCompra compra;
    private ConexionVenta venta;
    private ConexionEmpleado empleado;
    private ConexionFinanciero financiero;

    public DatoEstadoFinanciero(Connection conexion) {
        this.conexion = conexion;
        venta = new ConexionVenta();
        compra = new ConexionCompra();
        empleado = new ConexionEmpleado();
    }

    public float[] datos(Connection conexion, int mes, int anio,
            float gastoOperativo, float ingresos) throws SQLException {
        float venta = ventaT(conexion, mes, anio);
        float costoVenta = compraT(conexion, mes, anio);
        //------------------------------------------------------
        float utilidadBruta = venta - costoVenta;
        float gastoAdministrativo = empleadoT(conexion);
        // gastoAdministrativo
        //-------------------------------------------------------
        float utilidadAnteIngresos = utilidadBruta - gastoAdministrativo
                - gastoOperativo;
        // Ingresos
        //----------------------------------------------------------
        float utilidadAnteISR = utilidadAnteIngresos + ingresos;
        float isr25 = (float) (utilidadAnteISR * 0.25);
        //-----------------------------------------------------------
        float utilidadNeta = utilidadAnteISR - isr25;

        return new float[]{venta, costoVenta, utilidadBruta,
            gastoAdministrativo, gastoOperativo, utilidadAnteIngresos, ingresos,
            utilidadAnteISR, isr25, utilidadNeta};
    }

    private float ventaT(Connection conexion, int mes, int anio) throws SQLException {
        ResultSet ventasResult = venta.total(conexion, mes, anio);
        ventasResult.next();
        return ventasResult.getFloat("ventaT");
    }

    private float compraT(Connection conexion, int mes, int anio) throws SQLException {
        ResultSet compraResult = compra.total(conexion, mes, anio);
        compraResult.next();
        return compraResult.getFloat("compraT");
    }

    private float empleadoT(Connection conexion) throws SQLException {
        ResultSet empleadoResult = empleado.total(conexion);
        float sueldoBase = 0;
        float ajustoSueldo = 0;
        float bonificacion = 0;

        while (empleadoResult.next()) {
            sueldoBase += empleadoResult.getFloat("Salario_base");
            ajustoSueldo += Integer.valueOf(empleadoResult.getString("Ajuste_Sueldo"));
            bonificacion += empleadoResult.getInt("Bonificaciones");
        }

        return sueldoBase + ajustoSueldo + bonificacion;
    }
    
    public void actualizarFinanciero(Connection conexion) throws SQLException{
        this.financiero = new ConexionFinanciero();
        int mes = LocalDate.now().getMonthValue();
        int anio = LocalDate.now().getYear();
        ResultSet financieroResult = financiero.consulta(conexion, mes, anio);
        financieroResult.next();
        float gastosOperativos = financieroResult.getFloat("Gastos_Operacionales");
        float ingresos = financieroResult.getFloat("Ingresos");
        float[] datos = datos(conexion, mes, anio, gastosOperativos, ingresos);
        
        this.financiero.actualizar(conexion, datos[0], datos[1], datos[2], 
                datos[3], datos[4], datos[5], datos[6], datos[7], datos[8], 
                datos[9]);
    }
}
