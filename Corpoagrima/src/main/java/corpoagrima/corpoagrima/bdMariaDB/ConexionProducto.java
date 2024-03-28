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
public class ConexionProducto {
    public ResultSet busqueda(Connection conexion, String textoBusqueda) throws SQLException{

        String sql = "SELECT * FROM producto WHERE nombre LIKE ? OR ID_Producto = ?";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setString(1, "%" + textoBusqueda + "%");
        stmt.setString(2, textoBusqueda);

        return stmt.executeQuery();

    }
    
    public ResultSet consulta(Connection conexion) throws SQLException{
        // Crear una sentencia SQL
        String sql = "SELECT * FROM producto";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        
        return stmt.executeQuery();
    }
}
