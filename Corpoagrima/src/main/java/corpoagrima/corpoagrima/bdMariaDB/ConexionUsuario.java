/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package corpoagrima.corpoagrima.bdMariaDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author karol
 */
public class ConexionUsuario {
    
    public ResultSet usuario(Connection conexion, int idUsuario) throws SQLException{
        String sql = "SELECT * FROM Usuario WHERE ID_Usuario = ?";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setInt(1, idUsuario);
        return stmt.executeQuery();
    }
    
    public ResultSet usuarioID(Connection conexion, String nombre) throws SQLException{
        String sql = "SELECT * FROM Usuario WHERE Nombre = ?";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setString(1, nombre);
        return stmt.executeQuery();
    }
    
    public ResultSet usuarioId(Connection conexion, int idUsuario) throws SQLException{
        String sql = "SELECT Nombre FROM Usuario WHERE ID_Usuario = ?";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setInt(1, idUsuario);
        return stmt.executeQuery();
    }
    
    public boolean consulta(Connection conexion, String usuario, String contrasenia) {
        // Utilizar String.format() para crear la cadena completa
        String sql = String.format("SELECT * FROM Usuario WHERE Nombre = '%s' AND Contraseña = '%s'", usuario, contrasenia);
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
                try (ResultSet rs = stmt.executeQuery()) {
                    // Si se encuentra algún resultado, las credenciales son correctas
                    return rs.next();
                }
            }catch (SQLException e) {
            e.printStackTrace();
            return false; // Si ocurre algún error, considerar las credenciales como incorrectas
        }
    }
    
    public boolean agregar(Connection conexion, String nombre, 
            String contrasenia) throws SQLException{
        String sql = "INSERT INTO Usuario (Nombre, Contraseña) "
                + "VALUES (?, ?)";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setString(1, nombre);
        stmt.setString(2, contrasenia);
        // ejecutar la consulta
        int filasAfectadas = stmt.executeUpdate();
        return filasAfectadas > 0;
    }
    
    public boolean actualizar(Connection conexion, String nombre, 
            String contrasenia, int id)throws SQLException{
        String sql = "UPDATE Usuario SET Nombre=?, Contraseña=? "
                + "WHERE ID_Usuario=?";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setString(1, nombre);
        stmt.setString(2, contrasenia);
        stmt.setInt(3, id);
        // ejecutar la consulta
        int filasAfectadas = stmt.executeUpdate();
        return filasAfectadas > 0;
    }
    
    public boolean actualizarSinContrasenia(Connection conexion, String nombre, int id)throws SQLException{
        String sql = "UPDATE Usuario SET Nombre=? "
                + "WHERE ID_Usuario=?";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setString(1, nombre);
        stmt.setInt(2, id);
        // ejecutar la consulta
        int filasAfectadas = stmt.executeUpdate();
        return filasAfectadas > 0;
    }
    
    public boolean eliminar(Connection conexion, int id) throws SQLException{
        String sql = "DELETE FROM Usuario WHERE ID_Usuario=?";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setInt(1, id);
        // ejecutar la consulta
        int filasAfectadas = stmt.executeUpdate();
        return filasAfectadas > 0;
    }
}
