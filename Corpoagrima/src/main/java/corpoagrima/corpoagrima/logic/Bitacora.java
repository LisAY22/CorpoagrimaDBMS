package corpoagrima.corpoagrima.logic;

import java.io.BufferedWriter;      
import java.io.FileWriter;           
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author lisaj
 */
public class Bitacora {
    private static int contador_transacciones = 0;
    private static final String FILE_PATH = "C:\\Users\\lisaj\\OneDrive\\Documents\\GitHub\\CorpoagrimaDBMS\\Corpoagrima\\bitacora.txt";
    private String tiempoS;
    private String estado;
    private Long tiempo;
    
    public Bitacora() {
        contador_transacciones++;
        tiempo = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fechaHora = sdf.format(new Date(tiempo));
        this.tiempoS = fechaHora;
        this.estado = "Activa";
        registrarTransaccion();
    }
    
    private void registrarTransaccion() {
        // El true es para indicar que es en forma de anexado (append)
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write("Transacción " + Bitacora.contador_transacciones + ": " + tiempoS + " - Estado: " + estado);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error al registrar la transacción: " + e.getMessage());
        }
    }
    
    public void actualizarEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
        tiempo = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fechaHora = sdf.format(new Date(tiempo));
        this.tiempoS = fechaHora;
        registrarTransaccion();
    }
}
