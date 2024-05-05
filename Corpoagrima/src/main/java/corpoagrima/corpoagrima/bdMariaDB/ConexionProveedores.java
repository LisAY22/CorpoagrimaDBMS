
package corpoagrima.corpoagrima.bdMariaDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author lisaj
 * @author WilderL
 */
public class ConexionProveedores {
    public ResultSet consulta(Connection conexion) throws SQLException{
        String sql = "SELECT * FROM Proveedor WHERE Eliminado=?";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setBoolean(1, false);
        
        return stmt.executeQuery();
    }
    
    public boolean actualizar(Connection conexion, int idProveedor, String empresa, 
            String nombre, String direccion, String nit, String correo_electronico)
            throws SQLException{
        String sql = "UPDATE Proveedor SET Empresa=?, Nombre=?, "
                + "Direccion=?, NIT=?, Correo_Electronico=? "
                + "WHERE ID_Proveedor=? AND Eliminado=?";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setString(1, empresa);
        stmt.setString(2, nombre);
        stmt.setString(3, direccion);
        stmt.setString(4, nit);
        stmt.setString(5, correo_electronico);
        stmt.setInt(6, idProveedor);
        stmt.setBoolean(7, false);
        // ejecutar la consulta
        int filasAfectadas = stmt.executeUpdate();
        return filasAfectadas > 0;
    }
        
    public ResultSet busqueda(Connection conexion, String textoBusqueda) throws SQLException{

        String sql = "SELECT * FROM Proveedor "
                + "WHERE Empresa LIKE ? OR Nombre LIKE ? OR ID_Proveedor = ? "
                + "AND Eliminado=?";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setString(1, "%" + textoBusqueda + "%");
        stmt.setString(2, "%" + textoBusqueda + "%"); // Asumiendo que quieres buscar en el nombre también
        stmt.setString(3, textoBusqueda);
        stmt.setBoolean(4, false);

        return stmt.executeQuery();
    }
    
    public ResultSet busqueda2(Connection conexion, String textoBusqueda) throws SQLException{
        String sql = "SELECT * FROM Proveedor "
                + "WHERE ID_Proveedor = ? AND Eliminado=?";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setString(1, textoBusqueda);
        stmt.setBoolean(2, false);

        return stmt.executeQuery();
    }
    
    public ResultSet proveedor(Connection conexion, String nombre) throws SQLException{
        String sql = "SELECT p.*, t.numero FROM Proveedor p "
                + "INNER JOIN Telefono t ON ID_Proveedor=Proveedor_ID_Proveedor "
                + "WHERE Empresa = ? AND Eliminado=?";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setString(1, nombre);
        stmt.setBoolean(2, false);
        
        return stmt.executeQuery();
    }
    
    public boolean agregar(Connection conexion, String empresa, 
            String nombre, String direccion, String nit, String correo_electronico) 
            throws SQLException{
        String sql = "INSERT INTO Proveedor "
                + "(Empresa, Nombre, Direccion, NIT, Correo_Electronico, Eliminado = false) "
                + "VALUES (?, ?, ?, ?, ?)";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setString(1, empresa);
        stmt.setString(2, nombre);
        stmt.setString(3, direccion);
        stmt.setString(4, nit);
        stmt.setString(5, correo_electronico);
        // ejecutar la consulta
        int filasAfectadas = stmt.executeUpdate();
        return filasAfectadas > 0;
    }

    
    public boolean eliminar(Connection conexion, int id) throws SQLException{
        String sql = "UPDATE Proveedor SET Eliminado=? WHERE ID_Proveedor=?";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setBoolean(1, true);
        stmt.setInt(2, id);
        // ejecutar la consulta
        int filasAfectadas = stmt.executeUpdate();
        return filasAfectadas > 0;
    }
    public ResultSet idProveedor(Connection conexion, String empresa, String nombre)throws SQLException{
        String sql = "SELECT ID_Proveedor FROM Proveedor WHERE Empresa = ? AND Nombre = ?";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setString(1, empresa);
        stmt.setString(2, nombre);
        return stmt.executeQuery();
    }
}
