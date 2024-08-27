/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package corpoagrima.corpoagrima.bdMariaDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author karol
 */
public class Conexion {
    private static Connection conexion;
    
    // Método para obtener la conexión a la base de datos
    public Connection obtenerConexion() {
        if (conexion == null) {
            try {
                conexion = DriverManager.getConnection("jdbc:mariadb://localhost:3306/CorpoagrimaBD?serverTimezone=UTC", "root","Necrosis98");
                System.out.println("Conexión establecida correctamente.");
            } catch (SQLException e) {
                System.out.println("Error al conectar a la base de datos: " + e.getMessage());
            }
        }
        return conexion;
    }

    // Método para cerrar la conexión a la base de datos
    public void cerrarConexion() {
        if (conexion != null) {
            try {
                conexion.close();
                System.out.println("Conexión cerrada correctamente.");
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
    
    // Método para iniciar una transacción
    public boolean iniciarTransaccion(Connection conexion) {
        try {
            conexion.setAutoCommit(false);
            System.out.println("Transacción iniciada.");
            return true;
        } catch (SQLException e) {
            System.out.println("Error al iniciar la transacción: " + e.getMessage());
            return false;
        }
    }

    // Método para hacer commit de una transacción
    public boolean commitTransaccion(Connection conexion) {
        try {
            conexion.commit();
            conexion.setAutoCommit(true);
            System.out.println("Transacción realizada con éxito.");
            return true;
        } catch (SQLException e) {
            System.out.println("Error al hacer commit de la transacción: " + e.getMessage());
            return false;
        }
    }

    // Método para hacer rollback de una transacción
    public boolean rollbackTransaccion(Connection conexion) {
        try {
            conexion.rollback();
            conexion.setAutoCommit(true);
            System.out.println("Rollback realizado.");
            return true;
        } catch (SQLException e) {
            System.out.println("Error al hacer rollback de la transacción: " + e.getMessage());
            return false;
        }
    }
}
