/**
 * Representa un usuario dentro del sistema de e-commerce, permitiendo su almacenamiento 
 * y autenticación. Los usuarios pueden ser compradores o vendedores.
 * 
 * Esta clase maneja la creación, almacenamiento y verificación de usuarios a través de 
 * un archivo de texto.
 * 
 * @author Juliana Sofia Lopez
 * @author Leonardo Alejandro Guio
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
	/**
	 * Nombre del usuario.
	 */
    private String nombre;
    /**
     * Nombre de usuario utilizado para iniciar sesión.
     */
    private String usuario;
    /**
     * Contraseña del usuario.
     */
    private String contraseña;
    /**
     * Correo electrónico del usuario.
     */
    private String correo;
    
    /**
     * Crea un nuevo usuario con la información proporcionada.
     * 
     * @param nombre el nombre del usuario.
     * @param usuario el nombre de usuario para iniciar sesión.
     * @param correo el correo electrónico del usuario.
     * @param contraseña la contraseña del usuario.
     */

    public Usuario(String nombre, String usuario, String correo, String contraseña) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.correo = correo;
        this.contraseña = contraseña;
    }
    /**
     * Obtiene el nombre del usuario.
     * 
     * @return el nombre del usuario.
     */
    public String getNombre() { return nombre; }
    /**
     * Obtiene el nombre de usuario.
     * 
     * @return el nombre de usuario.
     */
    public String getUsuario() { return usuario; }
    /**
     * Obtiene el correo electrónico del usuario.
     * 
     * @return el correo del usuario.
     */
    public String getCorreo() { return correo; }/**
     * Obtiene la contraseña del usuario.
     * 
     * @return la contraseña del usuario.
     */
    public String getContraseña() { return contraseña; }

    /**
     * Guarda la información del usuario en un archivo de texto.
     * Si ocurre un error, muestra un mensaje de error.
     */
    public void guardarUsuario() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("usuarios.txt", true))) {
            writer.write(usuario + "," + contraseña + "," + nombre + "," + correo + "\n");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar el usuario.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Verifica si un usuario con el nombre y contraseña proporcionados existe en el sistema.
     * 
     * @param usuario el nombre de usuario a verificar.
     * @param contraseña la contraseña a verificar.
     * @return una instancia de {@code Comprador} o {@code Vendedor} si el usuario existe, o {@code null} si no se encuentra.
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



