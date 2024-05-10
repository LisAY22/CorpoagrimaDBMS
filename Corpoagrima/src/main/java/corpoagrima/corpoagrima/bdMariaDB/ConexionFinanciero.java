package corpoagrima.corpoagrima.bdMariaDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 *
 * @author WilderL
 */
public class ConexionFinanciero {

    public ResultSet consulta(Connection conexion, int mes, int anio) throws SQLException {
        String sql = "SELECT Ventas, Costos_Ventas, Gastos_Administrativos, "
                + "Gastos_Operacionales, Utilidad_Antes_Ingresos, Ingresos, "
                + "Utilidad_Antes_ISR, ISR25, Utilidad_Neta "
                + "FROM Estado_Financiero WHERE MONTH(Fecha)=? AND YEAR(Fecha)=?";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setInt(1, mes);
        stmt.setInt(2, anio);
        
        return stmt.executeQuery();
    }
    
    public ResultSet utilidadNeta(Connection conexion, int mes, int anio) throws SQLException{
        String sql = "SELECT Utilidad_Neta FROM Estado_Financiero "
                + "WHERE MONTH(Fecha)=? AND YEAR(Fecha)=? BY ORDER Fecha";
        PreparedStatement stmt = conexion.prepareStatement(sql);

        
        return stmt.executeQuery();
    }
    
    public ResultSet gastoIngreso(Connection conexion) throws SQLException{
        String sql = "SELECT Gastos_Operacionales, Ingresos "
                + "FROM Estado_Financiero BY ORDER Fecha DESC LIMIT 1";
        PreparedStatement stmt = conexion.prepareStatement(sql);

        
        return stmt.executeQuery();
    }

    public boolean insertar(Connection conexion, float venta, float costoVenta,
            float gastoAdministrativos, float gastoOperacionales,
            float utilidadAnteIngresos, float ingresos, float utilidadAnteISR,
            float isr25, float utilidadNeta) throws SQLException {
        String sql = "INSERT INTO Estado_Financiero (Fecha, Ventas, "
                + "Costos_Ventas, Gastos_Administrativos, Gastos_Operacionales,"
                + "Utilidad_Antes_Ingresos, Ingresos, Utilidad_Antes_ISR, ISR25,"
                + "Utilidad_Neta) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement stmt = conexion.prepareStatement(sql);
        String fecha = LocalDate.now().toString();
        stmt.setString(1, fecha);
        stmt.setFloat(2, venta);
        stmt.setFloat(3, costoVenta);
        stmt.setFloat(4, gastoAdministrativos);
        stmt.setFloat(5, gastoOperacionales);
        stmt.setFloat(6, utilidadAnteIngresos);
        stmt.setFloat(7, ingresos);
        stmt.setFloat(8, utilidadAnteISR);
        stmt.setFloat(9, isr25);
        stmt.setFloat(10, utilidadNeta);

        int filasAfectadas = stmt.executeUpdate();
        return filasAfectadas > 0;
    }

    public boolean actualizar(Connection conexion, float venta, float costoVenta,
            float gastoAdministrativos, float gastoOperacionales,
            float utilidadAnteIngresos, float ingresos, float utilidadAnteISR,
            float isr25, float utilidadNeta) throws SQLException {
        String sql = "UPDATE Estado_Financiero SET Ventas=?, "
                + "Costos_Ventas=?, Gastos_Administrativos=?, "
                + "Gastos_Operacionales=?, Utilidad_Antes_Ingresos=?, "
                + "Ingresos=?, Utilidad_Antes_ISR=?, ISR25=?, Utilidad_Neta=? "
                + "WHERE Fecha=?";

        PreparedStatement stmt = conexion.prepareStatement(sql);
        String fecha = LocalDate.now().toString();
        stmt.setFloat(1, venta);
        stmt.setFloat(2, costoVenta);
        stmt.setFloat(3, gastoAdministrativos);
        stmt.setFloat(4, gastoOperacionales);
        stmt.setFloat(5, utilidadAnteIngresos);
        stmt.setFloat(6, ingresos);
        stmt.setFloat(7, utilidadAnteISR);
        stmt.setFloat(8, isr25);
        stmt.setFloat(9, utilidadNeta);
        stmt.setString(10, fecha);

        int filasAfectadas = stmt.executeUpdate();
        return filasAfectadas > 0;
    }
    
    public boolean actualizarGastosOperacionales(Connection conexion, float gastosOpera, int year, int month) throws SQLException {
        String sql = "UPDATE Estado_Financiero SET Gastos_Operacionales=? "
                + "WHERE MONTH(Fecha)=? AND YEAR(Fecha)=? BY ORDER Fecha DESC LIMIT 1";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setFloat(1, gastosOpera);
        stmt.setInt(2, year);
        stmt.setInt(3, month);
        
        int filasAfectadas = stmt.executeUpdate();
        return filasAfectadas > 0;
    }
    
    public boolean actualizarIngresos(Connection conexion, float ingresos, int year, int month) throws SQLException {
        String sql = "UPDATE Estado_Financiero SET Ingresos=? "
                + "WHERE MONTH(Fecha)=? AND YEAR(Fecha)=? BY ORDER Fecha DESC LIMIT 1";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setFloat(1, ingresos);
        stmt.setInt(2, year);
        stmt.setInt(3, month);
        
        int filasAfectadas = stmt.executeUpdate();
        return filasAfectadas > 0;
    }
}
