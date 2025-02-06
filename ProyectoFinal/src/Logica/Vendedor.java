/**
 * @author Juliana Sofia Lopez, Leonardo Alejandro Guio
 * @version 1.0, Febrero 10, 2025
 * Este programa es una aplicación ecommerce que le permite al usuario entrar como vendedor y comprador.
 */
package Logica;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import java.io.*;

public class Vendedor extends Usuario {
    
    private List<Producto> productos;
    private double balanceTotal;

    public Vendedor(String nombre, String usuario, String correo, String contraseña) {
        super(nombre, usuario, correo, contraseña);
        this.balanceTotal = 0.0;
        this.productos = new ArrayList<>();
    }

    /**
     * Método para eliminar un producto del archivo productos.txt basado en su código.
     */
    private void eliminarProducto(String codigoStr) {
        try {
            // Verificar que el código sea numérico
            if (!codigoStr.matches("\\d+")) {
                JOptionPane.showMessageDialog(null, "Ingrese un código numérico válido.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int codigo = Integer.parseInt(codigoStr);

            // Cargar los productos y eliminar el que coincida con el código
            List<Producto> productos = Producto.cargarProductos();
            List<Producto> productosActualizados = productos.stream()
                    .filter(p -> p.getCodigo() != codigo)
                    .collect(Collectors.toList());

            // Verificar si el producto fue encontrado
            if (productos.size() == productosActualizados.size()) {
                JOptionPane.showMessageDialog(null, "No se encontró el producto.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Guardar los productos actualizados en el archivo
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("productos.txt"))) {
                for (Producto p : productosActualizados) {
                    writer.write(String.format("%d,%s,%.2f,%d,%s\n", 
                            p.getCodigo(), p.getNombreprod(), p.getPrecioprod(), p.getCantprod(), p.getDescripcionprod()));
                }
            }

            JOptionPane.showMessageDialog(null, "Producto eliminado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Ingrese un código válido.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el producto.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
        guardarProductoEnArchivo(producto);
    }

    private void guardarProductoEnArchivo(Producto producto) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("productos.txt", true))) {
            // Escribir los datos del producto en el archivo
            writer.write(producto.getCodigo() + "," + producto.getNombreprod() + "," + producto.getPrecioprod() + "," 
                         + producto.getCantprod() + "," + producto.getDescripcionprod() + "\n");
        } catch (IOException e) {
            System.out.println("Error al guardar el producto.");
        }
    }

    /**
     * Cargar un vendedor desde el archivo usuario.txt.
     * @param usuarioBuscado Nombre de usuario del vendedor a buscar.
     * @return Vendedor encontrado o null si no existe.
     */
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
        return null; // Si no se encuentra el vendedor
    }
}


