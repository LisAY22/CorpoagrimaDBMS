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
    public ResultSet noFactura(Connection conexion) throws SQLException {
        String sql = "SELECT MAX(NoFactura) AS maxFac FROM Registro_Venta";
        PreparedStatement stmt = conexion.prepareStatement(sql);

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
    
    public ResultSet ConsultaEditWindow(Connection conexion, String NoFactura) throws SQLException{
        String sql = "SELECT Cliente.Nombre, Cliente.Apellido, Cliente.Direccion, Cliente.NIT, Cliente.Cliente_destacado, "
                + "rv.ID_Venta, rv.Fecha, rv.Tipo_de_Venta, Empleado.nombre, rv.Efectivo, rv.Cambio "
                + "FROM Cliente INNER JOIN Registro_Venta rv ON Cliente.ID_Cliente = rv.Cliente_ID_Cliente "
                + "INNER JOIN Empleado ON rv.Empleado_ID_Empleado = Empleado.ID_Empleado "
                + "WHERE rv.NoFactura=?";

        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setString(1, NoFactura);

        return stmt.executeQuery();
    }
    
    public ResultSet ConsultaProductos(Connection conexion, String NoFactura) throws SQLException{
        String sql = "SELECT Producto.Nombre, Producto.Descripcion, rvp.Cantidad, rvp.Descuento, rvp.Precio_Unidad, rvp.Precio_Total "
                + "FROM Registro_Venta rv "
                + "INNER JOIN Registro_Venta_has_Producto rvp ON rvp.Registro_Venta_ID_Venta = rv.ID_Venta "
                + "INNER JOIN Producto ON rvp.Producto_ID_Producto = Producto.ID_Producto "
                + "WHERE rv.NoFactura=?";

        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setString(1, NoFactura);

        return stmt.executeQuery();
    }
    
    public ResultSet producto(Connection conexion, int idFactura) throws SQLException{
        String sql = "SELECT Producto_ID_Producto AS idProducto, Cantidad AS cantidad "
                + "FROM Registro_Venta_has_Producto WHERE Registro_Venta_ID_Venta=?";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        
        stmt.setInt(1, idFactura);
        
        return stmt.executeQuery();
    }
    
    public boolean eliminarRelacion(Connection conexion, int idFactura) throws SQLException{
        String sql = "DELETE FROM Registro_Venta_has_Producto WHERE Registro_Venta_ID_Venta = ?";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        
        stmt.setInt(1, idFactura);
        int filasAfectadas = stmt.executeUpdate();
        return filasAfectadas > 0;
    }
    
    public ResultSet esAnulado(Connection conexion, int idVenta) throws SQLException{
        String sql = "SELECT Anulado FROM Registro_Venta WHERE ID_Venta=?";
        
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setInt(1, idVenta);
        
        return stmt.executeQuery();
    }
    
    public boolean actualizar(Connection conexion, int id_Venta,
            boolean anulado,
            float total, float Cambio, float efectivo) throws SQLException {
        String sql = "UPDATE Registro_Venta SET Efectivo = ?, Anulado=?, "
                + "Total=?, Cambio=? "
                + "WHERE ID_Venta=?";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setFloat(1, efectivo);
        stmt.setBoolean(2, anulado);
        stmt.setFloat(3, total);
        stmt.setFloat(4, Cambio);
        stmt.setInt(5, id_Venta);
        // ejecutar la consulta
        int filasAfectadas = stmt.executeUpdate();
        return filasAfectadas > 0;
    }
    
    public boolean agregar(Connection conexion, int idVenta, int idProducto,
            String detalle, int cantidadCompra, float Descuento, float costoUnidad,
            float costoTotal) throws SQLException {
        String sql = "INSERT INTO Registro_Venta_has_Producto "
                + "(Registro_Venta_ID_Venta, Producto_ID_Producto, Detalle,"
                + "Cantidad, Descuento, Precio_Unidad, Precio_Total)"
                + "VALUES(?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setInt(1, idVenta);
        stmt.setInt(2, idProducto);
        stmt.setString(3, detalle);
        stmt.setFloat(4, cantidadCompra);
        stmt.setFloat(5, Descuento);
        stmt.setFloat(6, costoUnidad);
        stmt.setFloat(7, costoTotal);

        int filasAfectadas = stmt.executeUpdate();
        return filasAfectadas > 0;
    }
}
