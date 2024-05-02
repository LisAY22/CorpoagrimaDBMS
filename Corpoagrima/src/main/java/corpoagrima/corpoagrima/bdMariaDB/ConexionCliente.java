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

        String sql = "SELECT * FROM Cliente WHERE Nombre LIKE ? OR ID_Cliente = ?";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setString(1, "%" + textoBusqueda + "%");
        stmt.setString(2, textoBusqueda);

        return stmt.executeQuery();

    }
    public ResultSet busqueda2(Connection conexion, String textoBusqueda) throws SQLException{

        String sql = "SELECT * FROM Cliente WHERE ID_Cliente = ? OR NIT = ?";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setString(1, textoBusqueda);
        stmt.setString(2, textoBusqueda);

        return stmt.executeQuery();

    }
    public ResultSet consulta(Connection conexion) throws SQLException{
        String sql = "SELECT * FROM Cliente";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        
        return stmt.executeQuery();
    }
    public boolean agregar(Connection conexion, String nombre, 
            String apellido, String nit, String correoElectronico, 
            String direccion, boolean clienteDestacado, int cantidadCompra) 
            throws SQLException{
        String sql = "INSERT INTO Cliente "
                + "(Nombre, Apellido, NIT, CorreoElectronico,"
                + "Direccion, Cliente_destacado, Cantidad_compras) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setString(1, nombre);
        stmt.setString(2, apellido);
        stmt.setString(3, nit);
        stmt.setString(4, correoElectronico);
        stmt.setString(5, direccion);
        stmt.setBoolean(6, clienteDestacado);
        stmt.setInt(7, cantidadCompra);
        // ejecutar la consulta
        int filasAfectadas = stmt.executeUpdate();
        return filasAfectadas > 0;
    }
    
    public boolean actualizar(Connection conexion, int idCliente, String nombre, 
            String apellido, String nit, String correoElectronico, 
            String direccion, boolean clienteDestacado, int cantidadCompra)
            throws SQLException{
        String sql = "UPDATE Cliente SET Nombre=?, Apellido=?, "
                + "NIT=?, CorreoElectronico=?, Direccion=?, Cliente_destacado=?, Cantidad_compras=? WHERE ID_Cliente=?";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setString(1, nombre);
        stmt.setString(2, apellido);
        stmt.setString(3, nit);
        stmt.setString(4, correoElectronico);
        stmt.setString(5, direccion);
        stmt.setBoolean(6, clienteDestacado);
        stmt.setInt(7, cantidadCompra);
        stmt.setInt(8, idCliente);
        // ejecutar la consulta
        int filasAfectadas = stmt.executeUpdate();
        return filasAfectadas > 0;
    }
    
    public boolean eliminar(Connection conexion, int id) throws SQLException{
        String sql = "DELETE FROM Cliente WHERE ID_Cliente=?";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setInt(1, id);
        // ejecutar la consulta
        int filasAfectadas = stmt.executeUpdate();
        return filasAfectadas > 0;
    }
}

