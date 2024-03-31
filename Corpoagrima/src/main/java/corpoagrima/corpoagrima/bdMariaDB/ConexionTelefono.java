
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
    
    /**
     * 
     * @param conexion Coneccion a la base de datos
     * @param id Llave foranea asociada al numero de telefono 
     * @param tipoEntidad Entidad tipo Cliente, Empleado o Proveedor, para la busqueda
     * @return Un booleano si la operacion a si exitosa o no
     * @throws SQLException 
     */
    public ResultSet telefono(Connection conexion, int id, String tipoEntidad) throws SQLException {
        String columnaId = "";
        switch (tipoEntidad) {
            case "Empleado":
                columnaId = "Empleado_ID_Empleado";
                break;
            case "Cliente":
                columnaId = "Cliente_ID_Cliente";
                break;
            case "Proveedor":
                columnaId = "Proveedor_ID_Proveedor";
                break;
            default:
                throw new IllegalArgumentException("Tipo de entidad no válido");
        }

        String sql = "SELECT Numero FROM Telefono WHERE " + columnaId + " = ?";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setInt(1, id);
        return stmt.executeQuery();
    }

    /**
     * 
     * @param conexion Coneccion a la base de datos
     * @param numero Numero telefonico
     * @param tipoEntidad Entidad tipo Cliente, Empleado o Proveedor, para agregar
     * @return Un booleano si la operacion a si exitosa o no
     * @throws SQLException 
     */
    public boolean agregar(Connection conexion, String numero, 
            String tipoEntidad) throws SQLException{
        String columnaId = "";
        switch (tipoEntidad) {
            case "Empleado":
                columnaId = "Empleado_ID_Empleado";
                break;
            case "Cliente":
                columnaId = "Cliente_ID_Cliente";
                break;
            case "Proveedor":
                columnaId = "Proveedor_ID_Proveedor";
                break;
            default:
                throw new IllegalArgumentException("Tipo de entidad no válido");
        }
        
        String sql = "INSERT INTO Empleado (Numero, " + columnaId + ") "
                + "VALUES (?, ?)";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setString(1, numero);
        stmt.setString(2, tipoEntidad);
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
