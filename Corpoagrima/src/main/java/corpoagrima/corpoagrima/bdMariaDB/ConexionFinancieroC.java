
package corpoagrima.corpoagrima.bdMariaDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author WilderL
 */
public class ConexionFinancieroC {
    public boolean insertar(Connection conexion) throws SQLException {
        String sql = "INSERT INTO Estado_Financiero (ID_BalanceC, "
                + "Gastos_Operacionales, Ingresos) VALUES (?, ?, ?)";

        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setInt(1, 1);
        stmt.setFloat(2, 0);
        stmt.setFloat(3, 0);


        int filasAfectadas = stmt.executeUpdate();
        return filasAfectadas > 0;
    }

    public boolean actualizar(Connection conexion, float gastoOperacionales,
            float ingresos) throws SQLException {
        String sql = "UPDATE Estado_Financiero SET Gastos_Operacionales=?, "
                + "Ingresos=? WHERE ID_BalanceC=?";

        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setFloat(1, gastoOperacionales);
        stmt.setFloat(2, ingresos);
        stmt.setInt(3, 1);

        int filasAfectadas = stmt.executeUpdate();
        return filasAfectadas > 0;
    }
}
