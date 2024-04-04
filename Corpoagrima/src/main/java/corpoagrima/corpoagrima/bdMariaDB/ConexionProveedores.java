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
 * @author lisaj
 */
public class ConexionProveedores {
    public ResultSet consulta(Connection conexion) throws SQLException{
        String sql = "SELECT * FROM Proveedor";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        
        return stmt.executeQuery();
    }
    
    public boolean actualizar(Connection conexion, int idProveedor, String empresa, 
            String nombre, String direccion, String nit, String correo_electronico)
            throws SQLException{
        String sql = "UPDATE Proveedor SET Empresa=?, Nombre=?, "
                + "Direccion=?, NIT=?, Correo_Electronico=? WHERE ID_Proveedor=?";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setString(1, empresa);
        stmt.setString(2, nombre);
        stmt.setString(3, direccion);
        stmt.setString(4, nit);
        stmt.setString(5, correo_electronico);
        stmt.setInt(6, idProveedor);
        // ejecutar la consulta
        int filasAfectadas = stmt.executeUpdate();
        return filasAfectadas > 0;
    }
        
    public ResultSet busqueda(Connection conexion, String textoBusqueda) throws SQLException{

        String sql = "SELECT * FROM Proveedor WHERE Empresa LIKE ? OR Nombre LIKE ? OR ID_Proveedor = ?";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setString(1, "%" + textoBusqueda + "%");
        stmt.setString(2, "%" + textoBusqueda + "%"); // Asumiendo que quieres buscar en el nombre también
        stmt.setString(3, textoBusqueda);

        return stmt.executeQuery();
    }
    
    public ResultSet busqueda2(Connection conexion, String textoBusqueda) throws SQLException{
        String sql = "SELECT * FROM Proveedor WHERE ID_Proveedor = ?";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setString(1, textoBusqueda);

        return stmt.executeQuery();
    }
    
    public boolean agregar(Connection conexion, int idProveedor, String empresa, 
            String nombre, String direccion, String nit, String correo_electronico) 
            throws SQLException{
        String sql = "INSERT INTO Proveedor "
                + "(ID_Proveedor, Empresa, Nombre, Direccion, NIT,"
                + "Correo_Electronico) "
                + "VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setInt(1, idProveedor);
        stmt.setString(2, empresa);
        stmt.setString(3, nombre);
        stmt.setString(4, direccion);
        stmt.setString(5, nit);
        stmt.setString(6, correo_electronico);
        // ejecutar la consulta
        int filasAfectadas = stmt.executeUpdate();
        return filasAfectadas > 0;
    }

    
    public boolean eliminar(Connection conexion, int id) throws SQLException{
        String sql = "DELETE FROM Proveedor WHERE ID_Proveedor=?";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setInt(1, id);
        // ejecutar la consulta
        int filasAfectadas = stmt.executeUpdate();
        return filasAfectadas > 0;
    }
}
