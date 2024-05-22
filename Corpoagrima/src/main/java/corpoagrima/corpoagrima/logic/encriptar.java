/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package corpoagrima.corpoagrima.logic;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

/**
 *
 * @author karol
 */
public class encriptar {
    public static String encriptarContrasenia(String contrasenia) {
        try {
            // Crear MessageDigest instance para SHA-256
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(contrasenia.getBytes());
            // Obtener hash's bytes
            byte[] bytes = md.digest();
            // Convertir bytes a formato hexadecimal
            StringBuilder sb = new StringBuilder();
            for (byte aByte : bytes) {
                sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
            }
            // Retornar contraseña
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static boolean verificarContrasenia(String contraseniaIngresada, String contraseniaEncriptada) {
        String contraseniaIngresadaEncriptada = encriptarContrasenia(contraseniaIngresada);
        return contraseniaIngresadaEncriptada.equals(contraseniaEncriptada);
    }

}
