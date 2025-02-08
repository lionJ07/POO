/**
 * @JulianaSofiaLopez
 * @LeonardoAlejandroGuio
 * @version1.0, Febrero 10,2025 
 * Este programa es una ecommerce que le permite al usuario entrar como vendedor y comprador 
 */
package Logica;

public class SesionIniciada {
    private static Usuario usuarioActual; // Usuario que ha iniciado sesión

    public static void iniciarSesion(Usuario usuario) {
        usuarioActual = usuario;
    }

    public static Usuario getUsuarioActual() {
        return usuarioActual;
    }

    public static void cerrarSesion() {
        usuarioActual = null;
    }

    public static boolean esVendedor() {
        return usuarioActual instanceof Vendedor;
    }
    
    public static void setUsuarioActual(Usuario usuario) {
        usuarioActual = usuario;
    }
    
    public static boolean esComprador() {
        return usuarioActual instanceof Comprador;
    }
    
}
