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

        String sql = "SELECT * FROM Producto WHERE Nombre LIKE ? OR ID_Producto = ?";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setString(1, "%" + textoBusqueda + "%");
        stmt.setString(2, textoBusqueda);

        return stmt.executeQuery();

    }
    public ResultSet busqueda2(Connection conexion, int id) throws SQLException{

        String sql = "SELECT * FROM Producto WHERE ID_Producto = ?";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setInt(1, id);

        return stmt.executeQuery();

    }
    
    public ResultSet consulta(Connection conexion) throws SQLException{
        // Crear una sentencia SQL
        String sql = "SELECT * FROM Producto";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        
        return stmt.executeQuery();
    }
    
    public boolean agregar(Connection conexion, String nombre, String descripcion, String marca, 
            String fecha_vencimiento, String categoria, int cantidad, String unidad_medida, 
            float precio_venta) throws SQLException{
        String sql = "INSERT INTO Producto "
                + "(Nombre, Descripcion, Marca, Fecha_Vencimiento, Categoria, Stock, Unidad_Medida, Precio_Venta)"
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setString(1, nombre);
        stmt.setString(2, descripcion);
        stmt.setString(3, marca);
        stmt.setString(4, fecha_vencimiento);
        stmt.setString(5, categoria);
        stmt.setInt(6, cantidad);
        stmt.setString(7, unidad_medida);
        stmt.setFloat(8, precio_venta);
        
        int filasAfectadas = stmt.executeUpdate();
        return filasAfectadas > 0;
    }
    
    public boolean eliminar(Connection conexion, int id) throws SQLException{
        String sql = "DELETE FROM Producto WHERE ID_Producto=?";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setInt(1, id);
        // ejecutar la consulta
        int filasAfectadas = stmt.executeUpdate();
        return filasAfectadas > 0;
    }
    
    public boolean actualizar(Connection conexion, String nombre, String descripcion, String marca, 
            String fecha_vencimiento, String categoria, int cantidad, String unidad_medida, 
            float precio_venta, int id) throws SQLException {
            String sql = "UPDATE Producto SET Nombre=?, Descripcion=?, Marca=?, Fecha_Vencimiento=?, "
                    + "Categoria=?, Stock=?, Unidad_Medida=?, Precio_Venta=? WHERE ID_Producto=?";
            
            PreparedStatement stmt = conexion.prepareStatement(sql);
            stmt.setString(1, nombre);
            stmt.setString(2, descripcion);
            stmt.setString(3, marca);
            stmt.setString(4, fecha_vencimiento);
            stmt.setString(5, categoria);
            stmt.setInt(6, cantidad);
            stmt.setString(7, unidad_medida);
            stmt.setFloat(8, precio_venta);
            stmt.setInt(9, id);
            
        // ejecutar la consulta
        int filasAfectadas = stmt.executeUpdate();
        return filasAfectadas > 0;
    }
}
