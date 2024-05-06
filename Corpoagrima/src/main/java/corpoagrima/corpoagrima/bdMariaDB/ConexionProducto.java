package corpoagrima.corpoagrima.bdMariaDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author karol
 * @author WilderL
 */
public class ConexionProducto {

    public ResultSet busqueda(Connection conexion, String textoBusqueda) throws SQLException {

        String sql = "SELECT * FROM Producto "
                + "WHERE (Nombre LIKE ? OR ID_Producto = ?) AND Eliminado=?";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setString(1, "%" + textoBusqueda + "%");
        stmt.setString(2, textoBusqueda);
        stmt.setBoolean(3, false);

        return stmt.executeQuery();

    }

    public ResultSet busqueda2(Connection conexion, int id) throws SQLException {

        String sql = "SELECT * FROM Producto WHERE ID_Producto = ? AND Eliminado=?";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.setBoolean(2, false);

        return stmt.executeQuery();

    }

    public ResultSet busqueda3(Connection conexion, String textoBusqueda) throws SQLException {
        String sql = "SELECT Producto.ID_Producto, Producto.Nombre, Producto.Descripcion, Producto.Marca, Producto.Categoria, "
                + "Producto.Unidad_Medida FROM Producto "
                + "WHERE (Producto.Nombre LIKE ? OR Producto.ID_Producto=?) AND Producto.Eliminado=?";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setString(1, "%" + textoBusqueda + "%");
        stmt.setString(2, textoBusqueda);
        stmt.setBoolean(3, false);

        return stmt.executeQuery();
    }

    public ResultSet consulta(Connection conexion) throws SQLException {
        // Crear una sentencia SQL
        String sql = "SELECT * FROM Producto WHERE Eliminado=?";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setBoolean(1, false);

        return stmt.executeQuery();
    }
    
    public ResultSet cantidad(Connection conexion, String nombre) throws SQLException {
        String sql = "SELECT ID_Producto, Stock FROM Producto WHERE Nombre=?";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setString(1, nombre);
        
        return stmt.executeQuery();
    }

    public boolean agregar(Connection conexion, String nombre, String descripcion, String marca,
            String categoria, int cantidad, String unidad_medida,
            float precio_venta) throws SQLException {
        String sql = "INSERT INTO Producto "
                + "(Nombre, Descripcion, Marca, Categoria, Stock, Unidad_Medida, Precio_Venta, Eliminado)"
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setString(1, nombre);
        stmt.setString(2, descripcion);
        stmt.setString(3, marca);
        stmt.setString(4, categoria);
        stmt.setInt(5, cantidad);
        stmt.setString(6, unidad_medida);
        stmt.setFloat(7, precio_venta);
        stmt.setBoolean(8, false);

        int filasAfectadas = stmt.executeUpdate();
        return filasAfectadas > 0;
    }

    public boolean eliminar(Connection conexion, int id) throws SQLException {
        String sql = "UPDATE Producto SET Eliminado=? WHERE ID_Producto=?";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setBoolean(1, true);
        stmt.setInt(2, id);
        // ejecutar la consulta
        int filasAfectadas = stmt.executeUpdate();
        return filasAfectadas > 0;
    }

    public boolean actualizar(Connection conexion, String nombre, String descripcion, String marca,
            String categoria, int cantidad, String unidad_medida,
            float precio_venta, int id) throws SQLException {
        String sql = "UPDATE Producto SET Nombre=?, Descripcion=?, Marca=?, "
                + "Categoria=?, Stock=?, Unidad_Medida=?, Precio_Venta=?, Eliminado=? WHERE ID_Producto=?";

        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setString(1, nombre);
        stmt.setString(2, descripcion);
        stmt.setString(3, marca);
        stmt.setString(4, categoria);
        stmt.setInt(5, cantidad);
        stmt.setString(6, unidad_medida);
        stmt.setFloat(7, precio_venta);
        stmt.setBoolean(8, false);
        stmt.setInt(9, id);

        // ejecutar la consulta
        int filasAfectadas = stmt.executeUpdate();
        return filasAfectadas > 0;
    }

    public boolean actualizar(Connection conexion, int idProducto, int cantidad) 
            throws SQLException {
        String sql = "UPDATE Producto SET Stock=? WHERE ID_Producto=?";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setInt(1, cantidad);
        stmt.setInt(2, idProducto);
        
        int filasAfectadas = stmt.executeUpdate();
        return filasAfectadas > 0;
    }
}
