/**
 * Representa un comprador dentro de la plataforma de ecommerce.
 * Hereda de la clase Usuario y tiene acceso a un carrito de compras.
 * También permite consultar el historial de compras del usuario.
 * 
 * @author Juliana Sofia Lopez
 * @author Leonardo Alejandro Guio
 * @version 1.0, Febrero 10, 2025
 */

package Logica;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Comprador extends Usuario {
	
    private CarritoCompras carrito;
    
    /**
     * Constructor de la clase Comprador.
     * Inicializa un comprador con sus datos personales y su carrito de compras.
     * 
     * @param nombre Nombre del comprador.
     * @param usuario Nombre de usuario del comprador.
     * @param correo Correo electrónico del comprador.
     * @param contraseña Contraseña del comprador.
     */
    public Comprador(String nombre, String usuario, String correo, String contraseña) {
        super(nombre, usuario, correo, contraseña);
        this.carrito = new CarritoCompras();
    }
    
    /**
     * Obtiene el carrito de compras del comprador.
     * 
     * @return El objeto CarritoCompras asociado al comprador.
     */

    public CarritoCompras getCarrito() { 
    	return carrito; 
    }
    
    /**
     * Carga el historial de compras del comprador desde un archivo.
     * Busca en el archivo "historial.txt" las compras asociadas al usuario actual.
     * 
     * @return Una cadena con el historial de compras formateado,
     *         o un mensaje indicando que no hay compras registradas.
     */
    public String cargarHistorial() {
        StringBuilder historial = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader("historial.txt"))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length >= 7) {
                    String usuarioArchivo = datos[6].trim(); // Asegurar que no haya espacios adicionales
                    if (usuarioArchivo.equalsIgnoreCase(this.getUsuario().trim())) { // Comparar sin importar mayúsculas/minúsculas
                        historial.append("Código: ").append(datos[0].trim())
                                .append(" | Producto: ").append(datos[1].trim())
                                .append(" | Precio: $").append(datos[2].trim()) 
                                .append(" | Cantidad: ").append(datos[3].trim())
                                .append("\n");
                    }
                }
            }
            return historial.length() > 0 ? historial.toString() : "No hay compras registradas.";
        } catch (IOException e) {
            return "Error al cargar el historial.";
        }
    }
}
