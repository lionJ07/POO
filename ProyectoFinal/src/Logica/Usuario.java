/**
 * Este programa es una ecommerce que le permite al usuario entrar como vendedor y comprador 
 * @JulianaSofiaLopez
 * @LeonardoAlejandroGuio
 * @version 1.0, Febrero 10, 2025 
 */

package Logica;

import java.io.*;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * Esta clase maneja los datos y la verificación de los usuarios
 */
public class Usuario {

    private String nombre;
    private String usuario;
    private String contraseña;
    private String correo;

    public Usuario(String nombre, String usuario, String correo, String contraseña) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.correo = correo;
        this.contraseña = contraseña;
    }
    public String getNombre() { return nombre; }
    public String getUsuario() { return usuario; }
    public String getCorreo() { return correo; }
    public String getContraseña() { return contraseña; }

    /**
     * Método para guardar el usuario en un archivo de texto
     */
    public void guardarUsuario() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("usuarios.txt", true))) {
            writer.write(usuario + "," + contraseña + "," + nombre + "," + correo + "\n");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar el usuario.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Método para verificar si el usuario y la contraseña son correctos
     * @param usuario el nombre de usuario
     * @param contraseña la contraseña proporcionada
     * @return el usuario si es correcto, o null si no lo es
     */
    public static Usuario verificar(String usuario, String contraseña) {
        try (BufferedReader br = new BufferedReader(new FileReader("usuarios.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 5) { // Verificamos que haya 5 elementos
                    String nombreArchivo = datos[0];
                    String usuarioArchivo = datos[1];
                    String correoArchivo = datos[2];
                    String contraseñaArchivo = datos[3];
                    String tipoUsuario = datos[4]; // Último campo indica el tipo de usuario

                    if (usuario.equals(usuarioArchivo) && contraseña.equals(contraseñaArchivo)) {
                        if (tipoUsuario.equalsIgnoreCase("Comprador")) {
                            return new Comprador(nombreArchivo, usuarioArchivo, correoArchivo, contraseñaArchivo);
                        } else if (tipoUsuario.equalsIgnoreCase("Vendedor")) {
                            return new Vendedor(nombreArchivo, usuarioArchivo, correoArchivo, contraseñaArchivo);
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null; // Usuario no encontrado
    }

}



