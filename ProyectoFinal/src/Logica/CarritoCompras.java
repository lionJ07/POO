/**
 * @JulianaSofiaLopez
 * @LeonardoAlejandroGuio
 * @version1.0, Febrero 10,2025 
 * Este programa es una ecommerce que le permite al usuario entrar como vendedor y comprador 
 */
package Logica;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class CarritoCompras {
    private List<Producto> productosCarrito;
    private static final String ARCHIVO_CARRITO = "carrito.txt";

    public CarritoCompras() {
        productosCarrito = new ArrayList<>();
        inicializarArchivo();
    }

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
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error al guardar en el archivo del carrito: " + e.getMessage());
        }
    }


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
