/**
 * @JulianaSofiaLopez
 * @LeonardoAlejandroGuio
 * @version1.0, Febrero 10,2025 
 * Este programa es una ecommerce que le permite al usuario entrar como vendedor y comprador 
 */
package Logica;

import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.util.Iterator;

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
            // Escribimos en el orden correcto: código, nombre, precio, cantidad, descripción, nombre del vendedor
            writer.write(producto.getCodigo() + "," + producto.getNombreprod() + "," + producto.getPrecioprod() + "," 
                + producto.getCantprod() + "," + producto.getDescripcionprod() + "," + producto.getNombreVendedor() + "\n");
        } catch (IOException e) {
            System.out.println("Error al guardar el producto: " + e.getMessage());
        }
    }

    public static Vendedor cargarVendedorDesdeArchivo(String usuarioBuscado) {
        try (BufferedReader reader = new BufferedReader(new FileReader("usuarios.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4 && data[1].equals(usuarioBuscado)) {  // Buscar por nombre de usuario
                    return new Vendedor(data[0], data[1], data[2], data[3]);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar el vendedor: " + e.getMessage());
        }
        return null; 
    }

    private void actualizarArchivoProductos() {
        // Mejorar actualización del archivo de productos
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("productos.txt"))) {
            for (Producto p : productos) {
                writer.write(p.getCodigo() + "," + p.getNombreprod() + "," + p.getPrecioprod() + "," 
                    + p.getCantprod() + "," + p.getDescripcionprod() + "," + p.getNombreVendedor() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error al actualizar el archivo de productos: " + e.getMessage());
        }
    }

    public boolean eliminarProducto(int codigo) {
        // Usamos un iterador para evitar ConcurrentModificationException al eliminar elementos
        Iterator<Producto> iterator = productos.iterator();
        while (iterator.hasNext()) {
            Producto p = iterator.next();
            if (p.getCodigo() == codigo) {
                iterator.remove(); // Elimina el producto de la lista
                actualizarArchivoProductos(); // Actualiza el archivo después de eliminar
                return true;
            }
        }
        return false;
    }

    public double calcularBalance() {
        double balance = 0;
        for (Producto p : productos) {
            balance += p.getPrecioprod() * p.getCantprod();
        }
        return balance;
    }

    public static List<Producto> obtenerProductosPorUsuario(String nombreUsuario) {
        List<Producto> productosUsuario = new ArrayList<>();
        File file = new File("productos.txt");

        if (!file.exists()) {
            return productosUsuario; // Si el archivo no existe, retorna lista vacía
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 6) { // Verifica que la línea tenga 6 elementos
                    try {
                        int codigo = Integer.parseInt(data[0].trim());
                        String nombre = data[1].trim();
                        // Reemplazamos la coma por un punto en el precio antes de convertirlo a double
                        double precio = Double.parseDouble(data[2].trim().replace(",", "."));
                        int cantidad = Integer.parseInt(data[3].trim());
                        String descripcion = data[4].trim();
                        String nombreVendedor = data[5].trim(); // Último campo es el vendedor

                        // Filtra solo los productos del usuario actual
                        if (nombreVendedor.equals(nombreUsuario)) {
                            productosUsuario.add(new Producto(codigo, nombre, precio, cantidad, descripcion, nombreVendedor));
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Error en el formato de la línea: " + line);
                    }
                } else {
                    System.out.println("Formato incorrecto en línea: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de productos: " + e.getMessage());
        }

        return productosUsuario; // Devuelve los productos del usuario o una lista vacía si no tiene
    }
}
