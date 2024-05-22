
package corpoagrima.corpoagrima.bdMariaDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author WilderL
 */
public class ConexionTelefono {
    
    public ResultSet telefonoId(Connection conexion, String numero) throws SQLException{
        String sql = "SELECT ID_Telefono FROM Telefono WHERE " + numero + " = ?";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setString(1, numero);
        return stmt.executeQuery();
    }
    
    /**
     * 
     * @param conexion Coneccion a la base de datos
     * @param idForanea Llave foranea asociada al numero de telefono 
     * @param tipoEntidad Entidad tipo Cliente, Empleado o Proveedor, para la busqueda
     * @return Un booleano si la operacion a si exitosa o no
     * @throws SQLException 
     */
    public ResultSet telefono(Connection conexion, int idForanea, String tipoEntidad) throws SQLException {
        String columnaId = "";
        switch (tipoEntidad) {
            case "Empleado" -> columnaId = "Empleado_ID_Empleado";
            case "Cliente" -> columnaId = "Cliente_ID_Cliente";
            case "Proveedor" -> columnaId = "Proveedor_ID_Proveedor";
            default -> throw new IllegalArgumentException("Tipo de entidad no válido");
        }

        String sql = "SELECT * FROM Telefono WHERE " + columnaId + " = ?";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setInt(1, idForanea);
        return stmt.executeQuery();
    }

    /**
     * 
     * @param conexion Coneccion a la base de datos
     * @param numero Numero telefonico
     * @param tipoEntidad Entidad tipo Cliente, Empleado o Proveedor, para agregar
     * @param idForanea
     * @return Un booleano si la operacion a si exitosa o no
     * @throws SQLException 
     */
    public boolean agregar(Connection conexion, String numero, 
            String tipoEntidad, int idForanea) throws SQLException{
        String columnaId = "";
        switch (tipoEntidad) {
            case "Empleado" -> columnaId = "Empleado_ID_Empleado";
            case "Cliente" -> columnaId = "Cliente_ID_Cliente";
            case "Proveedor" -> columnaId = "Proveedor_ID_Proveedor";
            default -> throw new IllegalArgumentException("Tipo de entidad no válido");
        }
        
        String sql = "INSERT INTO Telefono (Numero, " + columnaId + ") "
                + "VALUES (?, ?)";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setString(1, numero);
        stmt.setInt(2, idForanea);
        // ejecutar la consulta
        int filasAfectadas = stmt.executeUpdate();
        return filasAfectadas > 0;
    }
    
    /**
     * 
     * @param conexion Coneccion a la base de datos
     * @param numero Numero telefonico
     * @param idTelefono id del numero que se va a modificiar
     * @return
     * @throws SQLException 
     */
    public boolean actualizar(Connection conexion, String numero, 
            int idTelefono)throws SQLException{
        String sql = "UPDATE Telefono SET Numero=? WHERE ID_Telefono=?";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setString(1, numero);
        stmt.setInt(2, idTelefono);
        // ejecutar la consulta
        int filasAfectadas = stmt.executeUpdate();
        return filasAfectadas > 0;
    }
    
    public boolean eliminar(Connection conexion, int id) throws SQLException{
        String sql = "DELETE FROM Telefono WHERE ID_Telefono=?";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setInt(1, id);
        // ejecutar la consulta
        int filasAfectadas = stmt.executeUpdate();
        return filasAfectadas > 0;
    }
}
