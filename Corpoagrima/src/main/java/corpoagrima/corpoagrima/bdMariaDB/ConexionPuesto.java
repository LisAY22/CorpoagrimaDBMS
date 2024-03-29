
package corpoagrima.corpoagrima.bdMariaDB;

import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author WilderL
 */
public class ConexionPuesto {
    public ResultSet consulta(Connection conexion){
        String sql = "SELECT * FROM Puesto";
        return null;
    }
    
    public ResultSet puestos(Connection conexion, String nombre){
        String sql = String.format("SELECT Nombre FROM Puesto WHERE nombre=%s", nombre);
        return null;
    }
    
}
