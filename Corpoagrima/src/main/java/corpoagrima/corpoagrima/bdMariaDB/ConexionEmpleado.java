
package corpoagrima.corpoagrima.bdMariaDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author WilderL
 */
public class ConexionEmpleado {
    
    public ResultSet ordenarNombre(Connection conexion) throws SQLException{
        String sql = "SELECT * FROM Empleado ORDER BY Nombre ASC, Apellido ASC";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        return stmt.executeQuery();
    }
    
    public ResultSet ordenarApellido(Connection conexion) throws SQLException{
        String sql = "SELECT * FROM Empleado ORDER BY Apellido ASC, Nombre ASC";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        return stmt.executeQuery();
    }
    
    public ResultSet consulta(Connection conexion) throws SQLException{
        String sql = "SELECT * FROM Empleado";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        return stmt.executeQuery();
    }
    
    public ResultSet empleados(Connection conexion, String nombre) throws SQLException{
        String sql = "SELECT * FROM Empleado WHERE Nombre LIKE ?";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setString(1, "%" + nombre + "%");
        return stmt.executeQuery();
    }
    
    public ResultSet empleadosID(Connection conexion, int IDEmpleado) throws SQLException{
        String sql = "SELECT * FROM Empleado WHERE ID_Empleado LIKE ?";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setString(1, "%" + IDEmpleado + "%");
        return stmt.executeQuery();
    }
    
    public ResultSet idEmpleado(Connection conexion, String nombre, String apellido)throws SQLException{
        String sql = "SELECT ID_Empleado FROM Empleado WHERE Nombre = ? AND Apellido = ?";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setString(1, nombre);
        stmt.setString(2, apellido);
        return stmt.executeQuery();
    }
    
    public boolean agregar(Connection conexion, String nombre, String apellido, 
            String nit, String correoElectronico,String direccion, 
            String ajusteSueldo, float bonificaciones, int idPuesto, 
            int idUsuario) throws SQLException{
        String sql = "INSERT INTO Empleado "
                + "(Nombre, Apellido, NIT, Correo_Electronico,"
                + "Direccion, Ajuste_Sueldo, Bonificaciones, Puesto_ID_Puesto,"
                + "Usuario_ID_Usuario) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setString(1, nombre);
        stmt.setString(2, apellido);
        stmt.setString(3, nit);
        stmt.setString(4, correoElectronico);
        stmt.setString(5, direccion);
        stmt.setString(6, ajusteSueldo);
        stmt.setFloat(7, bonificaciones);
        stmt.setInt(8, idPuesto);
        stmt.setInt(9, idUsuario);
        // ejecutar la consulta
        int filasAfectadas = stmt.executeUpdate();
        return filasAfectadas > 0;
    }
    
    public boolean actualizar(Connection conexion, int idEmpleado, String nombre, 
            String apellido, String nit, String correoElectronico, 
            String direccion, String ajusteSueldo, float bonificaciones, 
            int idPuesto, int idUsuario)throws SQLException{
        String sql = "UPDATE Empleado SET ID_Empleado=?, Nombre=?, Apellido=?, "
                + "NIT=?, Correo_Electronico=?, Direccion=?, Ajuste_Sueldo=?, "
                + "Bonificaciones=?, Puesto_ID_Puesto=?, Usuario_ID_Usuario=? "
                + "WHERE ID_Empleado=?";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setInt(1, idEmpleado);
        stmt.setString(2, nombre);
        stmt.setString(3, apellido);
        stmt.setString(4, nit);
        stmt.setString(5, correoElectronico);
        stmt.setString(6, direccion);
        stmt.setString(7, ajusteSueldo);
        stmt.setFloat(8, bonificaciones);
        stmt.setInt(9, idPuesto);
        stmt.setInt(10, idUsuario);
        stmt.setInt(11, idEmpleado);
        // ejecutar la consulta
        int filasAfectadas = stmt.executeUpdate();
        return filasAfectadas > 0;
    }
    
    public boolean eliminar(Connection conexion, int id) throws SQLException{
        String sql = "DELETE FROM Empleado WHERE ID_Empleado=?";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setInt(1, id);
        // ejecutar la consulta
        int filasAfectadas = stmt.executeUpdate();
        return filasAfectadas > 0;
    }
    
}
