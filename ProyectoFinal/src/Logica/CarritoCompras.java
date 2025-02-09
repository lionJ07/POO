/**
 * Clase que representa el carrito de compras de un usuario.
 * Permite agregar productos, obtener los productos del carrito y vaciarlo.
 * Los productos se almacenan en un archivo para persistencia.
 * 
 * @author Juliana Sofia Lopez
 * @author Leonardo Alejandro Guio
 * @version 1.0, Febrero 10, 2025
 */

package Logica;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class CarritoCompras {
    private List<Producto> productosCarrito;
    private static final String ARCHIVO_CARRITO = "carrito.txt";
    
    /**
     * Constructor de la clase CarritoCompras.
     * Inicializa la lista de productos del carrito y verifica la existencia del archivo de almacenamiento.
     */

    public CarritoCompras() {
        productosCarrito = new ArrayList<>();
        inicializarArchivo();
    }
    
    /**
     * Verifica si el archivo del carrito existe, y si no, lo crea.
     * Esto asegura la persistencia de los datos del carrito de compras.
     */
    private void inicializarArchivo() {
        File archivo = new File(ARCHIVO_CARRITO);
        try {
            if (!archivo.exists()) {
                archivo.createNewFile();
            }
        } catch (IOException e) {
            System.err.println("Error al crear el archivo del carrito: " + e.getMessage());
        }
    }
    
    /**
     * Agrega un producto al carrito con la cantidad especificada y lo guarda en el archivo.
     * 
     * @param producto El producto que se va a agregar al carrito.
     * @param cantidad La cantidad del producto que se desea agregar.
     * @param comprador El nombre del usuario que está agregando el producto al carrito.
     */
    public void agregarProductoAlCarrito(Producto producto, int cantidad, String comprador) {
        Producto productoComprado = new Producto(
            producto.getCodigo(),
            producto.getNombreprod(),
            producto.getPrecioprod(),
            cantidad,
            producto.getDescripcionprod(),
            producto.getNombreVendedor()
        );

        productosCarrito.add(productoComprado);
        guardarEnArchivo(productoComprado, comprador);
    }

    /**
     * Guarda un producto en el archivo del carrito junto con el nombre del comprador.
     * 
     * @param producto El producto que se guardará en el archivo del carrito.
     * @param comprador El nombre del usuario que añadió el producto.
     */
    private void guardarEnArchivo(Producto producto, String comprador) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO_CARRITO, true))) {
            writer.write(String.format(Locale.US, "%d,%s,%.2f,%d,%s,%s,%s",
                    producto.getCodigo(),
                    producto.getNombreprod(),
                    producto.getPrecioprod(),
                    producto.getCantprod(),
                    producto.getDescripcionprod(),
                    producto.getNombreVendedor(),
                    comprador));
            
        } catch (IOException e) {
            System.err.println("Error al guardar en el archivo del carrito: " + e.getMessage());
        }
    }

    /**
     * Obtiene todos los productos del carrito asociados a un comprador específico.
     * 
     * @param comprador El nombre del usuario cuyo carrito se desea consultar.
     * @return Una lista de productos que pertenecen al carrito del comprador.
     */
    public List<Producto> obtenerProductosCarrito(String comprador) {
        List<Producto> productos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(ARCHIVO_CARRITO))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 7) {
                    String compradorArchivo = datos[6].trim();
                    if (compradorArchivo.equals(comprador)) {
                        int codigo = Integer.parseInt(datos[0].trim());
                        double precio = Double.parseDouble(datos[2].replace(",", "."));
                        int cantidad = Integer.parseInt(datos[3]);
                        Producto producto = new Producto(
                            codigo, datos[1], precio, cantidad, datos[4], datos[5]
                        );
                        productos.add(producto);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo del carrito: " + e.getMessage());
        }
        return productos;
    }
    
    /**
     * Elimina todos los productos del carrito de un comprador específico.
     * Solo elimina los productos del comprador indicado, dejando intactos los demás.
     * 
     * @param comprador El nombre del usuario cuyo carrito será vaciado.
     */
    public void vaciarCarrito(String comprador) {
        List<String> nuevasLineas = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(ARCHIVO_CARRITO))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 7) {
                    String compradorArchivo = datos[6].trim(); // Última columna es el comprador
                    if (!compradorArchivo.equals(comprador)) {
                        nuevasLineas.add(linea); // Solo agregamos las líneas de otros compradores
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo del carrito: " + e.getMessage());
        }
        // Escribimos solo las líneas que NO pertenecen al comprador actual
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO_CARRITO, false))) {
            for (String nuevaLinea : nuevasLineas) {
                writer.write(nuevaLinea);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error al actualizar el archivo del carrito: " + e.getMessage());
        }
    }
}
