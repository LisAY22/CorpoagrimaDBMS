package corpoagrima.corpoagrima.bdMariaDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author WilderL
 */
public class ConexionCompra {
    //public ResultSet 

    public ResultSet consulta(Connection conexion) throws SQLException {
        String sql = "SELECT NoFactura, Proveedor.Empresa,  Fecha, Tipo_Compra, Total FROM Registro_Compra "
                + "JOIN Proveedor ON Registro_Compra.Proveedor_ID_Proveedor = Proveedor.ID_Proveedor "
                + "WHERE Anulado=?";

        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setBoolean(1, false);

        return stmt.executeQuery();
    }

    public ResultSet busqueda(Connection conexion, String factura) throws SQLException {
        String sql = "SELECT rc.ID_Compra, rc.NoFactura, rc.Fecha, rc.Tipo_Compra, rc.Total, p.Empresa, p.NIT, e.Nombre, e.Apellido, rcp.Detalle "
                + "FROM Registro_Compra rc "
                + "JOIN Proveedor p ON rc.Proveedor_ID_Proveedor = p.ID_Proveedor "
                + "JOIN Empleado e ON rc.Empleado_ID_Empleado = e.ID_Empleado "
                + "LEFT JOIN Registro_Compra_has_Producto rcp ON rcp.Registro_Compra_ID_Compra = rc.ID_Compra "
                + "WHERE rc.NoFactura=? LIMIT 1 ";

        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setString(1, factura);

        return stmt.executeQuery();
    }

    public ResultSet busqueda2(Connection conexion, String factura) throws SQLException {
        String sql = "SELECT Producto.Nombre, Producto.Descripcion, Producto.Marca, rcp.Cantidad_compra, rcp.Costo_Unidad, rcp.Costo_Total "
                + "FROM Registro_Compra rc "
                + "INNER JOIN Registro_Compra_has_Producto rcp ON rcp.Registro_Compra_ID_Compra = rc.ID_Compra "
                + "INNER JOIN Producto ON rcp.Producto_ID_Producto = Producto.ID_Producto "
                + "WHERE rc.NoFactura=?";

        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setString(1, factura);

        return stmt.executeQuery();
    }

    public ResultSet idCompra(Connection conexion, String noFactura) throws SQLException {
        String sql = "SELECT ID_Compra FROM Registro_Compra WHERE NoFactura=?";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setString(1, noFactura);

        return stmt.executeQuery();
    }

    public boolean agregar(Connection conexion, String noFactura,
            boolean anulado, String fecha, String tipoCompra,
            float total, int proveedor_id_proveedor, int empleado_id_empleado) throws SQLException {
        String sql = "INSERT INTO Registro_Compra "
                + "(NoFactura, Anulado, Fecha, Tipo_Compra,"
                + "Total, Proveedor_ID_Proveedor, Empleado_ID_Empleado)"
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setString(1, noFactura);
        stmt.setBoolean(2, anulado);
        stmt.setString(3, fecha);
        stmt.setString(4, tipoCompra);
        stmt.setFloat(5, total);
        stmt.setInt(6, proveedor_id_proveedor);
        stmt.setInt(7, empleado_id_empleado);
        // ejecutar la consulta
        int filasAfectadas = stmt.executeUpdate();
        return filasAfectadas > 0;
    }

    public boolean actualizar(Connection conexion, int id_Compra, String noFactura,
            boolean anulado, String fecha, String tipoCompra,
            float total, int proveedor_id_proveedor, int empleado_id_empleado) throws SQLException {
        String sql = "UPDATE Registro_Compra SET NoFactura=?, Anulado=?, Fecha=?, Tipo_Compra=?,"
                + "Total=?, Proveedor_ID_Proveedor=?, Empleado_ID_Empleado=?"
                + "WHERE ID_Compra=?";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setString(1, noFactura);
        stmt.setBoolean(2, anulado);
        stmt.setString(3, fecha);
        stmt.setString(4, tipoCompra);
        stmt.setFloat(5, total);
        stmt.setInt(6, proveedor_id_proveedor);
        stmt.setInt(7, empleado_id_empleado);
        stmt.setInt(8, id_Compra);
        // ejecutar la consulta
        int filasAfectadas = stmt.executeUpdate();
        return filasAfectadas > 0;
    }

    public boolean eliminar(Connection conexion, int id) throws SQLException {
        String sql = "UPDATE Registro_Compra SET Anulado=? WHERE ID_Compra=?";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setBoolean(1, true);
        stmt.setInt(2, id);
        // ejecutar la consulta
        int filasAfectadas = stmt.executeUpdate();
        return filasAfectadas > 0;
    }

    public boolean anular(Connection conexion, int id) throws SQLException {
        String sql = "UPDATE Registro_Compra SET Anulado=? WHERE ID_Compra=?";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setBoolean(1, true);
        stmt.setInt(2, id);

        int filasAfectadas = stmt.executeUpdate();
        return filasAfectadas > 0;
    }
}
