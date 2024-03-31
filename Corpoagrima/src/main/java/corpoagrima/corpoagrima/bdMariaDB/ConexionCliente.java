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
public class ConexionCliente {
    public ResultSet busqueda(Connection conexion, String textoBusqueda) throws SQLException{

        String sql = "SELECT * FROM cliente WHERE Nombre LIKE ? OR ID_Cliente = ?";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setString(1, "%" + textoBusqueda + "%");
        stmt.setString(2, textoBusqueda);

        return stmt.executeQuery();

    }
    public ResultSet busqueda2(Connection conexion, String textoBusqueda) throws SQLException{

        String sql = "SELECT * FROM cliente WHERE ID_Cliente = ? OR NIT = ?";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setString(1, textoBusqueda);
        stmt.setString(2, textoBusqueda);

        return stmt.executeQuery();

    }
    public ResultSet consulta(Connection conexion) throws SQLException{
        String sql = "SELECT * FROM cliente";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        
        return stmt.executeQuery();
    }
    
    public ResultSet ordenarNombre(Connection conexion) throws SQLException{
        String sql = "SELECT * FROM cliente ORDER BY nombre ASC, apellido ASC";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        
        return stmt.executeQuery();
    }
    
    public ResultSet ordenarApellido(Connection conexion) throws SQLException{
        String sql = "SELECT * FROM cliente ORDER BY apellido ASC, nombre ASC";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        
        return stmt.executeQuery();
    }
    
    public ResultSet ordenarDestacado(Connection conexion) throws SQLException{
        String sql = "SELECT * FROM cliente ORDER BY Cliente_destacado DES";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        
        return stmt.executeQuery();
    }
}

