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
    public ResultSet busqueda(Connection conexion, String textoBusqueda) throws SQLException {
        String sql = "SELECT * FROM Cliente WHERE (Nombre LIKE ? OR ID_Cliente = ?) AND Eliminado = False";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setString(1, "%" + textoBusqueda + "%"); // Agregar comodines para la búsqueda parcial
        stmt.setString(2, textoBusqueda);

        return stmt.executeQuery();
    }

    public ResultSet busqueda2(Connection conexion, String textoBusqueda) throws SQLException{

        String sql = "SELECT * FROM Cliente WHERE (ID_Cliente = ? OR NIT = ?) AND Eliminado=False";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setString(1, textoBusqueda);
        stmt.setString(2, textoBusqueda);

        return stmt.executeQuery();

    }
    public ResultSet busqueda3(Connection conexion, String textoBusqueda) throws SQLException{

        String sql = "SELECT * FROM Cliente WHERE NIT = ? AND Eliminado=False";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setString(1, textoBusqueda);

        return stmt.executeQuery();

    }
    public ResultSet CF(Connection conexion) throws SQLException{

        String sql = "SELECT * FROM Cliente WHERE ID_Cliente = 0 AND Eliminado=False";
        PreparedStatement stmt = conexion.prepareStatement(sql);

        return stmt.executeQuery();

    }
    public ResultSet consulta(Connection conexion) throws SQLException{
        String sql = "SELECT * FROM Cliente WHERE Eliminado=False";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        
        return stmt.executeQuery();
    }
    public boolean agregar(Connection conexion, String nombre, 
            String apellido, String nit, String correoElectronico, 
            String direccion, boolean clienteDestacado, int cantidadCompra) 
            throws SQLException{
        String sql = "INSERT INTO Cliente "
                + "(Nombre, Apellido, NIT, CorreoElectronico,"
                + "Direccion, Cliente_destacado, Cantidad_compras, Eliminado) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setString(1, nombre);
        stmt.setString(2, apellido);
        stmt.setString(3, nit);
        stmt.setString(4, correoElectronico);
        stmt.setString(5, direccion);
        stmt.setBoolean(6, clienteDestacado);
        stmt.setInt(7, cantidadCompra);
        stmt.setBoolean(8, false);
        // ejecutar la consulta
        int filasAfectadas = stmt.executeUpdate();
        return filasAfectadas > 0;
    }
    
    public boolean actualizar(Connection conexion, int idCliente, String nombre, 
            String apellido, String nit, String correoElectronico, 
            String direccion, boolean clienteDestacado, int cantidadCompra)
            throws SQLException{
        String sql = "UPDATE Cliente SET Nombre=?, Apellido=?, "
                + "NIT=?, CorreoElectronico=?, Direccion=?, Cliente_destacado=?, Cantidad_compras=?, "
                + "Eliminado = ? WHERE ID_Cliente=?";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setString(1, nombre);
        stmt.setString(2, apellido);
        stmt.setString(3, nit);
        stmt.setString(4, correoElectronico);
        stmt.setString(5, direccion);
        stmt.setBoolean(6, clienteDestacado);
        stmt.setInt(7, cantidadCompra);
        stmt.setBoolean(8, false);
        stmt.setInt(9, idCliente);
        // ejecutar la consulta
        int filasAfectadas = stmt.executeUpdate();
        return filasAfectadas > 0;
    }
    
    public boolean eliminar(Connection conexion, int id) throws SQLException{
        String sql = "UPDATE Cliente SET Eliminado=true WHERE ID_Cliente=?";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setInt(1, id);
        // ejecutar la consulta
        int filasAfectadas = stmt.executeUpdate();
        return filasAfectadas > 0;
    }
    
    public ResultSet idCliente(Connection conexion, String nombre, String apellido)throws SQLException{
        String sql = "SELECT ID_Cliente FROM Cliente WHERE Nombre = ? AND Apellido = ? AND Eliminado=False";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setString(1, nombre);
        stmt.setString(2, apellido);
        return stmt.executeQuery();
    }
    
    public ResultSet idCliente2(Connection conexion, String nombre, String apellido)throws SQLException{
        String sql = "SELECT ID_Cliente FROM Cliente WHERE Nombre = ? AND Apellido = ?";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setString(1, nombre);
        stmt.setString(2, apellido);
        return stmt.executeQuery();
    }
    
}

