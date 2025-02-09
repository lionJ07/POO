/**
 * Gestiona la sesión actual de un usuario en la aplicación.
 * Permite almacenar y recuperar la información del usuario que ha iniciado sesión.
 * 
 * @author Juliana Sofia Lopez
 * @author Leonardo Alejandro Guio
 * @version 1.0, Febrero 10, 2025
 */

package Logica;

public class SesionIniciada {
	/**
	 * Usuario que ha iniciado sesión en la aplicación.
	 */
    private static Usuario usuarioActual;
    
    /**
     * Inicia sesión con el usuario proporcionado.
     * 
     * @param usuario el usuario que inicia sesión.
     */

    public static void iniciarSesion(Usuario usuario) {
        usuarioActual = usuario;
    }
    
    /**
     * Obtiene el usuario que actualmente ha iniciado sesión.
     * 
     * @return el usuario actual, o {@code null} si no hay sesión iniciada.
     */

    public static Usuario getUsuarioActual() {
        return usuarioActual;
    }
    
    /**
     * Cierra la sesión actual eliminando la referencia al usuario.
     */

    public static void cerrarSesion() {
        usuarioActual = null;
    }
    
    /**
     * Verifica si el usuario actual es un vendedor.
     * 
     * @return {@code true} si el usuario es un vendedor, {@code false} en caso contrario.
     */

    public static boolean esVendedor() {
        return usuarioActual instanceof Vendedor;
    }
    
    /**
     * Establece un usuario como el usuario actual en la sesión.
     * 
     * @param usuario el usuario a establecer como actual.
     */

    public static void setUsuarioActual(Usuario usuario) {
        usuarioActual = usuario;
    }
    
    /**
     * Verifica si el usuario actual es un comprador.
     * 
     * @return {@code true} si el usuario es un comprador, {@code false} en caso contrario.
     */

    public static boolean esComprador() {
        return usuarioActual instanceof Comprador;
    }
    
}
