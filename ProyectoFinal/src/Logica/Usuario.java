/**
 * Este programa es una ecommerce que le permite al usuario entrar como vendedor y comprador 
 * @JulianaSofiaLopez
 * @LeonardoAlejandroGuio
 * @version1.0, Febrero 10,2025 
 */
package Logica;

import java.io.*;

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

    public void guardarUsuario() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("usuarios.txt", true))) {
            writer.write(usuario + "," + contraseña + "," + nombre + "," + correo + "\n");
        } catch (IOException e) {
            System.out.println("Error al guardar el usuario.");
        }
    }
}
