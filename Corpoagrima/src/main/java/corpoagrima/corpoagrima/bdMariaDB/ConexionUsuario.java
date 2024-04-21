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

    public ResultSet usuario(Connection conexion, int idUsuario) throws SQLException {
        String sql = "SELECT * FROM Usuario WHERE ID_Usuario = ?";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setInt(1, idUsuario);
        return stmt.executeQuery();
    }

    public ResultSet usuarioID(Connection conexion, String nombre) throws SQLException {
        String sql = "SELECT * FROM Usuario WHERE Nombre = ?";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setString(1, nombre);
        return stmt.executeQuery();
    }

    public ResultSet usuarioId(Connection conexion, int idUsuario) throws SQLException {
        String sql = "SELECT Nombre FROM Usuario WHERE ID_Usuario = ?";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setInt(1, idUsuario);
        return stmt.executeQuery();
    }

    public ResultSet consulta(Connection conexion, String usuario, String contrasenia) throws SQLException {
        String sql = """
                     SELECT puesto.nombre, puesto.Modulo_Cliente, puesto.Modulo_RH, puesto.Modulo_Proveedores, puesto.Modulo_Reg_Compra, 
                    puesto.Modulo_Reg_Venta, puesto.Modulo_Financiero, puesto.Modulo_Inventario FROM usuario
                    INNER JOIN empleado ON empleado.Usuario_ID_Usuario = usuario.ID_Usuario
                    INNER JOIN puesto ON empleado.Puesto_ID_Puesto = puesto.ID_Puesto WHERE usuario.Nombre = ? AND usuario.Contraseña = ?""";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setString(1, usuario);
        stmt.setString(2, contrasenia);
        return stmt.executeQuery();
    }

    public boolean agregar(Connection conexion, String nombre,
            String contrasenia) throws SQLException {
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
            String contrasenia, int id) throws SQLException {
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

    public boolean actualizarSinContrasenia(Connection conexion, String nombre, int id) throws SQLException {
        String sql = "UPDATE Usuario SET Nombre=? "
                + "WHERE ID_Usuario=?";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setString(1, nombre);
        stmt.setInt(2, id);
        // ejecutar la consulta
        int filasAfectadas = stmt.executeUpdate();
        return filasAfectadas > 0;
    }

    public boolean eliminar(Connection conexion, int id) throws SQLException {
        String sql = "DELETE FROM Usuario WHERE ID_Usuario=?";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setInt(1, id);
        // ejecutar la consulta
        int filasAfectadas = stmt.executeUpdate();
        return filasAfectadas > 0;
    }
}
