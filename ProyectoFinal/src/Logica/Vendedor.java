/**
 * Representa a un vendedor dentro del sistema de e-commerce. 
 * Un vendedor puede gestionar sus productos, agregarlos, eliminarlos y consultar sus ventas.
 * 
 * Esta clase extiende de {@link Usuario} y proporciona funcionalidades específicas para la gestión de productos.
 * 
 * @author Juliana Sofia Lopez
 * @author Leonardo Alejandro Guio
 * @version 1.0, Febrero 10, 2025
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
    
    /**
     * Crea un nuevo vendedor con la información proporcionada.
     * 
     * @param nombre Nombre del vendedor.
     * @param usuario Nombre de usuario del vendedor.
     * @param correo Correo electrónico del vendedor.
     * @param contraseña Contraseña del vendedor.
     */

    public Vendedor(String nombre, String usuario, String correo, String contraseña) {
        super(nombre, usuario, correo, contraseña);
        this.balanceTotal = 0.0;
        this.productos = new ArrayList<>();
    }
    
    /**
     * Agrega un producto a la lista de productos del vendedor y lo guarda en el archivo.
     * 
     * @param producto Producto a agregar.
     */

    public void agregarProducto(Producto producto) {
        productos.add(producto);
        guardarProductoEnArchivo(producto);
    }
    
    /**
     * Guarda la información de un producto en el archivo de productos.
     * 
     * @param producto Producto que se va a guardar.
     */

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
    
    /**
     * Carga un vendedor desde el archivo de usuarios a partir de su nombre de usuario.
     * 
     * @param usuarioBuscado Nombre de usuario del vendedor a buscar.
     * @return Una instancia de {@code Vendedor} si se encuentra, de lo contrario {@code null}.
     */

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
    
    /**
     * Actualiza el archivo de productos con la información más reciente.
     */

    private void actualizarArchivoProductos() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("productos.txt"))) {
            for (Producto p : productos) {
                // Escribe los datos del producto en el archivo con el formato correcto
                writer.write(p.getCodigo() + "," + 
                             p.getNombreprod() + "," + 
                             String.format(Locale.US, "%.2f", p.getPrecioprod()) + "," + 
                             p.getCantprod() + "," + 
                             p.getDescripcionprod() + "," + 
                             p.getNombreVendedor());
                writer.newLine(); // Asegura que se inserte un salto de línea después de cada producto
            }
        } catch (IOException e) {
            System.out.println("Error al actualizar el archivo de productos.");
        }
    }

    /**
     * Elimina un producto del vendedor a partir de su código.
     * 
     * @param codigo Código del producto a eliminar.
     * @return {@code true} si el producto fue eliminado, {@code false} si no se encontró.
     */

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
    
    /**
     * Obtiene una lista de productos vendidos por el vendedor.
     * 
     * @return Lista de productos vendidos.
     */

    public List<Producto> obtenerVentas() {
        List<Producto> ventas = new ArrayList<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader("historial.txt"))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 7) {
                    String vendedorArchivo = datos[5].trim();
                    if (vendedorArchivo.equals(this.getUsuario().trim())) { // Verifica que la venta sea del vendedor actual
                        int codigo = Integer.parseInt(datos[0].trim());
                        double precio = Double.parseDouble(datos[2].replace(",", "."));
                        int cantidad = Integer.parseInt(datos[3]);

                        Producto venta = new Producto(
                            codigo, datos[1], precio, cantidad, datos[4], vendedorArchivo
                        );
                        ventas.add(venta);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el historial de ventas: " + e.getMessage());
        }
        
        return ventas;
    }
    
    /**
     * Obtiene todos los productos de un vendedor en base a su nombre de usuario.
     * 
     * @param nombreUsuario Nombre de usuario del vendedor.
     * @return Lista de productos pertenecientes al vendedor.
     */

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

    /**
     * Edita un producto perteneciente al vendedor.
     * 
     * @param codigo Código del producto a editar.
     * @param nuevoNombre Nuevo nombre del producto.
     * @param nuevoPrecio Nuevo precio del producto.
     * @param nuevaCantidad Nueva cantidad disponible del producto.
     * @param nuevaDescripcion Nueva descripción del producto.
     * @return {@code true} si la edición fue exitosa, {@code false} en caso contrario.
     * @throws ParseException Si hay un error en el formato de los datos.
     */

    public boolean editarProductoDeVendedor(int codigo, String nuevoNombre, double nuevoPrecio, int nuevaCantidad, String nuevaDescripcion) throws ParseException {
        return Producto.editarProducto(codigo, nuevoNombre, nuevoPrecio, nuevaCantidad, nuevaDescripcion);
    }


}


