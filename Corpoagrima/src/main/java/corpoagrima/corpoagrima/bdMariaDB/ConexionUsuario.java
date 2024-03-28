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
    
    public boolean consulta(Connection conexion, String usuario, String contrasenia) {
        // Utilizar String.format() para crear la cadena completa
        String sql = String.format("SELECT * FROM usuario WHERE nombre = '%s' AND contraseña = '%s'", usuario, contrasenia);
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
}
