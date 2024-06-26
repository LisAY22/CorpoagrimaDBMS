
package corpoagrima.corpoagrima.bdMariaDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author WilderL
 */
public class ConexionPuesto {
    public ResultSet consulta(Connection conexion) throws SQLException{
        String sql = "SELECT * FROM Puesto Eliminado=?";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setBoolean(1,false);
        
        return stmt.executeQuery();
    }
    
    public ResultSet puestos(Connection conexion) throws SQLException{
        String sql = "SELECT Nombre FROM Puesto WHERE Eliminado=?";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setBoolean(1, false);
        
        return stmt.executeQuery();
    }
    
    public ResultSet puestoNombre(Connection conexion, String nombre) throws SQLException{
        String sql = "SELECT * FROM Puesto WHERE Nombre = ? AND Eliminado=?";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setString(1, nombre);
        stmt.setBoolean(2, false);
        
        return stmt.executeQuery();
    }
    
    public ResultSet puestoID(Connection conexion, String nombre) throws SQLException{
        String sql = "SELECT ID_Puesto FROM Puesto WHERE Nombre = ? AND Eliminado=?";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setString(1, nombre);
        stmt.setBoolean(2, false);
        
        return stmt.executeQuery();
    }
    
    public ResultSet puestoId(Connection conexion, int idPuesto) throws SQLException{
        String sql = "SELECT Nombre, Salario_Base FROM Puesto "
                + "WHERE ID_Puesto = ? AND Eliminado=?";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setInt(1, idPuesto);
        stmt.setBoolean(2, false);
        
        return stmt.executeQuery();
    }
    
    public boolean agregar(Connection conexion,String nombre, String horario, 
            String descripcion, float salarioBase, boolean moduloCliente,
            boolean moduloRH, boolean moduloProveedores, boolean moduloRegCompra,
            boolean moduloRegVenta, boolean moduloFinanciero, boolean moduloInventario
    ) throws SQLException{
        String sql = "INSERT INTO Puesto "
                + "(Nombre, Horario, Descripcion, Salario_Base, Modulo_Cliente,"
                + "Modulo_RH, Modulo_Proveedores, Modulo_Reg_Compra, "
                + "Modulo_Reg_Venta, Modulo_Financiero, Modulo_Inventario, Eliminado) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setString(1, nombre);
        stmt.setString(2, horario);
        stmt.setString(3, descripcion);
        stmt.setFloat(4, salarioBase);
        stmt.setBoolean(5, moduloCliente);
        stmt.setBoolean(6, moduloRH);
        stmt.setBoolean(7, moduloProveedores);
        stmt.setBoolean(8, moduloRegCompra);
        stmt.setBoolean(9, moduloRegVenta);
        stmt.setBoolean(10, moduloFinanciero);
        stmt.setBoolean(11, moduloInventario);
        stmt.setBoolean(12, false);
        int filasAfectadas = stmt.executeUpdate();
        return filasAfectadas > 0;
    }
    
    public boolean actualizar(Connection conexion,String nombre, String horario, 
            String descripcion, float salarioBase, boolean moduloCliente,
            boolean moduloRH, boolean moduloProveedores, boolean moduloRegCompra,
            boolean moduloRegVenta, boolean moduloFinanciero, boolean moduloInventario,
            int id)throws SQLException{
        String sql = "UPDATE Puesto SET Nombre=?, Horario=?, Descripcion=?,"
                + " Salario_Base=?, Modulo_Cliente=?, Modulo_RH=?, "
                + "Modulo_Proveedores=?, Modulo_Reg_Compra=?, "
                + "Modulo_Reg_Venta=?, Modulo_Financiero=?, Modulo_Inventario=?, Eliminado=? "
                + "WHERE ID_Puesto=?";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setString(1, nombre);
        stmt.setString(2, horario);
        stmt.setString(3, descripcion);
        stmt.setFloat(4, salarioBase);
        stmt.setBoolean(5, moduloCliente);
        stmt.setBoolean(6, moduloRH);
        stmt.setBoolean(7, moduloProveedores);
        stmt.setBoolean(8, moduloRegCompra);
        stmt.setBoolean(9, moduloRegVenta);
        stmt.setBoolean(10, moduloFinanciero);
        stmt.setBoolean(11, moduloInventario);
        stmt.setBoolean(12, false);
        stmt.setInt(13, id);
        // ejecutar la consulta
        int filasAfectadas = stmt.executeUpdate();
        return filasAfectadas > 0;
    }
    
    public boolean eliminar(Connection conexion, int id) throws SQLException{
        String sql = "UPDATE Puesto SET Eliminado=? WHERE ID_Puesto=?";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setBoolean(1,true);
        stmt.setInt(2, id);
        // ejecutar la consulta
        int filasAfectadas = stmt.executeUpdate();
        return filasAfectadas > 0;
    }
    
}
