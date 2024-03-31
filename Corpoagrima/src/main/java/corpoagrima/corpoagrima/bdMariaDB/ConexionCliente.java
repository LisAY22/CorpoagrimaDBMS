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
    
    public ResultSet ordenarNombre(Connection conexion) throws SQLException{
        String sql = "SELECT * FROM Cliente ORDER BY Nombre ASC, Apellido ASC";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        
        return stmt.executeQuery();
    }
    
    public ResultSet ordenarApellido(Connection conexion) throws SQLException{
        String sql = "SELECT * FROM Cliente ORDER BY Apellido ASC, Nombre ASC";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        
        return stmt.executeQuery();
    }
    
    public ResultSet ordenarDestacado(Connection conexion) throws SQLException{
        String sql = "SELECT * FROM Cliente ORDER BY Cliente_destacado DES";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        return stmt.executeQuery();
    }
    
    public boolean agregar(Connection conexion, int idCliente, String nombre, 
            String apellido, String nit, String correoElectronico, 
            String direccion, int clienteDestacado, int cantidadCompra) 
            throws SQLException{
        String sql = "INSERT INTO Cliente "
                + "(ID_Cliente, Nombre, Apellido, NIT, Correo_Electronico,"
                + "Direccion, Cliente_destacado, Cantidad_compras) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setInt(1, idCliente);
        stmt.setString(2, nombre);
        stmt.setString(3, apellido);
        stmt.setString(4, nit);
        stmt.setString(5, correoElectronico);
        stmt.setString(6, direccion);
        stmt.setInt(7, clienteDestacado);
        stmt.setInt(8, cantidadCompra);
        // ejecutar la consulta
        int filasAfectadas = stmt.executeUpdate();
        return filasAfectadas > 0;
    }
    
    public boolean actualizar(Connection conexion, int idCliente, String nombre, 
            String apellido, String nit, String correoElectronico, 
            String direccion, int clienteDestacado, int cantidadCompra)
            throws SQLException{
        String sql = "UPDATE Empleado SET ID_Empleado=?, Nombre=?, Apellido=?, "
                + "NIT=?, Correo_Electronico=?, Direccion=?, Ajuste_Sueldo=?, "
                + "Bonificaciones=?, Puesto_ID_Puesto=?, Usuario_ID_Usuario=? "
                + "WHERE ID_Empleado=?";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setInt(1, idCliente);
        stmt.setString(2, nombre);
        stmt.setString(3, apellido);
        stmt.setString(4, nit);
        stmt.setString(5, correoElectronico);
        stmt.setString(6, direccion);
        stmt.setInt(7, clienteDestacado);
        stmt.setInt(8, cantidadCompra);
        stmt.setInt(9, idCliente);
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

