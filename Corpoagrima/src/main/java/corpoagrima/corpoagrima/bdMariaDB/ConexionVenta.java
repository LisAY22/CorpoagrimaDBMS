package corpoagrima.corpoagrima.bdMariaDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author lisaj
 */
public class ConexionVenta {
    public ResultSet total(Connection conexion, int mes, int año) throws SQLException {
        String sql = "SELECT SUM(Registro_Venta.Total) AS ventaT FROM Registro_Venta "
                + "WHERE MONTH(Registro_Venta.Fecha) = ? AND YEAR(Registro_Venta.Fecha) = ? AND "
                + "Anulado=?";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setInt(1, mes);
        stmt.setInt(2, año);
        stmt.setBoolean(3, false);
        return stmt.executeQuery();
    }
    
    public ResultSet consulta(Connection conexion) throws SQLException {
        String sql = "SELECT ID_Venta, NoFactura, Cliente.Nombre, Cliente.Apellido, Tipo_de_venta, Total FROM Registro_Venta "
                + "JOIN Cliente ON Registro_Venta.Cliente_ID_Cliente = Cliente.ID_Cliente "
                + "WHERE Anulado=?";

        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setBoolean(1, false);

        return stmt.executeQuery();
    }
}
