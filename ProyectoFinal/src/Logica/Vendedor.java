/**
 * Este programa es una ecommerce que le permite al usuario entrar como vendedor y comprador 
 * @JulianaSofiaLopez
 * @LeonardoAlejandroGuio
 * @version1.0, Febrero 10,2025 
 */
package Logica;

import java.util.ArrayList;
import java.util.List;
import java.io.*;
public class Vendedor extends Usuario {
	
    private List<Producto> productos;
    private double balanceTotal;

    public Vendedor(String nombre, String usuario, String correo, String contraseña) {
        super(nombre, usuario, correo, contraseña);
        this.balanceTotal = 0.0;
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
        guardarProductoEnArchivo(producto);
    }

    private void guardarProductoEnArchivo(Producto producto) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("productos.txt", true))) {
            // Escribimos en el orden correcto: código, nombre, precio, cantidad, descripción
            writer.write(producto.getCodigo() + "," + producto.getNombreprod() + "," + producto.getPrecioprod() + "," + producto.getCantprod() + "," + producto.getDescripcionprod() + "\n");
        } catch (IOException e) {
            System.out.println("Error al guardar el producto.");
        }
    }

    
    public static Vendedor cargarVendedorDesdeArchivo(String usuarioBuscado) {
        try (BufferedReader reader = new BufferedReader(new FileReader("usuario.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4 && data[1].equals(usuarioBuscado)) {  // Buscar por nombre de usuario
                    return new Vendedor(data[0], data[1], data[2], data[3]);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar el vendedor.");
        }
        return null; // Retorna null si no encuentra el vendedor
    }

}


