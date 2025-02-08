/**
 * @JulianaSofiaLopez
 * @LeonardoAlejandroGuio
 * @version1.0, Febrero 10,2025 
 * Este programa es una ecommerce que le permite al usuario entrar como vendedor y comprador 
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
        File archivo = new File("usuarios.txt");
        if (!archivo.exists()) {
            JOptionPane.showMessageDialog(null, "El archivo de usuarios no existe", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        try (Scanner scanner = new Scanner(archivo)) {
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                String[] partes = linea.split(",");
                if (partes.length == 4) {
                    String usuarioArchivo = partes[0].trim();
                    String contraseñaArchivo = partes[1].trim();
                    String nombreArchivo = partes[2].trim();
                    String correoArchivo = partes[3].trim();
                    if (usuario.equals(usuarioArchivo) && contraseña.equals(contraseñaArchivo)) {
                        return new Usuario(nombreArchivo, usuarioArchivo, correoArchivo, contraseñaArchivo);
                    }
                }
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Archivo de usuarios no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
}



