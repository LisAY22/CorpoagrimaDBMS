
package corpoagrima.corpoagrima.bdMariaDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author WilderL
 */
public class ConexionRegCompraProducto {
    public boolean agregar(Connection conexion, int idCompra, int idProducto,
            String detalle, int cantidadCompra, float costoUnidad,
            float costoTotal) throws SQLException {
        String sql = "INSERT INTO Registro_Compra_has_Producto "
                + "(Registro_Compra_ID_Compra, Producto_ID_Producto, Detalle,"
                + "Cantidad_compra, Costo_Unidad, Costo_Total)"
                + "VALUES(?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setInt(1, idCompra);
        stmt.setInt(2, idProducto);
        stmt.setString(3, detalle);
        stmt.setFloat(4, cantidadCompra);
        stmt.setFloat(5, costoUnidad);
        stmt.setFloat(6, costoTotal);

        int filasAfectadas = stmt.executeUpdate();
        return filasAfectadas > 0;
    }
    
    public boolean eliminarRelacion(Connection conexion, int idFactura) throws SQLException{
        String sql = "DELETE FROM Registro_Compra_has_Producto WHERE Registro_Compra_ID_Compra = ?";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        
        stmt.setInt(1, idFactura);
        int filasAfectadas = stmt.executeUpdate();
        return filasAfectadas > 0;
    }
    
    public ResultSet producto(Connection conexion, int idFactura) throws SQLException{
        String sql = "SELECT Producto_ID_Producto AS idProducto, Cantidad_compra AS cantidad "
                + "FROM Registro_Compra_has_Producto WHERE Registro_Compra_ID_Compra=?";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        
        stmt.setInt(1, idFactura);
        
        return stmt.executeQuery();
    }
}
