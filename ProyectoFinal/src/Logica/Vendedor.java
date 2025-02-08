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
import java.text.ParseException;
import java.io.*;
import java.util.Locale;
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
            writer.write(producto.getCodigo() + "," +
                         producto.getNombreprod() + "," +
                         String.format(Locale.US, "%.2f", producto.getPrecioprod()) + "," + // 🔹 Asegura el punto decimal
                         producto.getCantprod() + "," +
                         producto.getDescripcionprod() + "," +
                         producto.getNombreVendedor());
            writer.newLine(); // Asegura el salto de línea
        } catch (IOException e) {
            System.out.println("Error al guardar el producto.");
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
            System.out.println("Error al cargar el vendedor.");
        }
        return null; 
    }
    
    private void actualizarArchivoProductos() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("productos.txt"))) {
            for (Producto p : productos) {
                writer.write(p.getCodigo() + "," + p.getNombreprod() + "," + p.getPrecioprod() + "," + p.getCantprod() + "," + p.getDescripcionprod() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error al actualizar el archivo de productos.");
        }
    }

    public boolean eliminarProducto(int codigo) {
        for (Producto p : productos) {
            if (p.getCodigo() == codigo) {
                productos.remove(p);
                actualizarArchivoProductos();
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
            	line = line.trim(); // 🔹 Asegura que no haya espacios en blanco al inicio o final
                if (line.isEmpty()) continue; //
                String[] data = line.split(",");
                if (data.length == 6) { // Verifica que la línea tenga 6 elementos
                    try {
                        int codigo = Integer.parseInt(data[0].trim());
                        String nombre = data[1].trim();
                        // 🔹 Reemplazamos la coma por un punto en el precio antes de convertirlo a double
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
            System.out.println("Error al leer el archivo de productos.");
        }

        return productosUsuario; // Devuelve los productos del usuario o una lista vacía si no tiene
    }


    public boolean editarProductoDeVendedor(int codigo, String nuevoNombre, double nuevoPrecio, int nuevaCantidad, String nuevaDescripcion) throws ParseException {
        return Producto.editarProducto(codigo, nuevoNombre, nuevoPrecio, nuevaCantidad, nuevaDescripcion);
    }


}


