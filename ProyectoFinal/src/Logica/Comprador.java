package Logica;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Comprador extends Usuario {
	
    private CarritoCompras carrito;

    public Comprador(String nombre, String usuario, String correo, String contraseña) {
        super(nombre, usuario, correo, contraseña);
        this.carrito = new CarritoCompras();
    }

    public CarritoCompras getCarrito() { 
    	return carrito; 
    }

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
                                .append(" | Precio: $").append(datos[2].trim()) // Precio ya debería estar con punto
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
