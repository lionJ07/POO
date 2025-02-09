/**
 * Representa un producto dentro del ecommerce.
 * Contiene información como el código, nombre, precio, cantidad disponible,
 * descripción y el nombre del vendedor que lo ofrece.
 * 
 * Incluye métodos para manipular la información de los productos, 
 * como cargar, editar, eliminar y vender productos.
 * 
 * @author Juliana Sofia Lopez
 * @author Leonardo Alejandro Guio
 * @version 1.0, Febrero 10, 2025
 */

package Logica;

import java.io.*;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;

public class Producto {
	
	private int codigo;
    private String nombreprod;
    private double precioprod;
    private int cantprod;
    private String descripcionprod;
    private String nombreVendedor; // Nuevo atributo

    /**
     * Constructor de la clase Producto.
     * Inicializa un producto con los atributos especificados.
     * 
     * @param codigo Código único del producto.
     * @param nombreprod Nombre del producto.
     * @param precioprod Precio del producto.
     * @param cantprod Cantidad disponible del producto.
     * @param descripcionprod Descripción del producto.
     * @param nombreVendedor Nombre del vendedor que ofrece el producto.
     */
    public Producto(int codigo, String nombreprod, double precioprod, int cantprod, String descripcionprod, String nombreVendedor) {
        this.codigo = codigo;
        this.nombreprod = nombreprod;
        this.precioprod = precioprod;
        this.cantprod = cantprod;
        this.descripcionprod = descripcionprod;
        this.nombreVendedor = nombreVendedor;
    }
    /**
     * Obtiene el nombre del vendedor del producto.
     * 
     * @return Nombre del vendedor.
     */

    public String getNombreVendedor() {
        return nombreVendedor;
    }
    
    /**
     * Establece el nombre del vendedor del producto.
     * 
     * @param nombreVendedor Nombre del vendedor.
     */
    
    public void setNombreVendedor(String nombreVendedor) {
        this.nombreVendedor = nombreVendedor;
    }
    /**
     * Obtiene el nombre del producto.
     * 
     * @return Nombre del producto.
     */

    public String getNombreprod() {
        return nombreprod;
    }
    /**
     * Obtiene el precio del producto.
     * 
     * @return Precio del producto.
     */
    public double getPrecioprod() {
        return precioprod;
    }
    
    /**
     * Obtiene la cantidad del producto.
     * 
     * @return Cantidad del producto.
     */

    public int getCantprod() {
        return cantprod;
    }
    
    /**
     * Obtiene el codigo del producto.
     * 
     * @return Codigo del producto.
     */

    public int getCodigo() {
        return codigo;
    }
    
    /**
     * Obtiene la descripcion del producto.
     * 
     * @return Descripcion del producto.
     */

    public String getDescripcionprod() {
        return descripcionprod;
    }
    
    /**
     * Establece la cantidad del producto.
     * 
     * @param Cantprod Cantidad del producto.
     */

    public void setCantprod(int cantprod) {
        this.cantprod = cantprod;
    }
    
    /**
     * Establece el codigo del producto.
     * 
     * @param Codigo Codigo del producto.
     */

    public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
    
    /**
     * Establece el nombre del producto.
     * 
     * @param nombreprod Nombre del producto.
     */

	public void setNombreprod(String nombreprod) {
		this.nombreprod = nombreprod;
	}
	
	/**
	 * Establece el precio del producto.
	 * 
	 * @param Precioprod Precio del producto.
	 */

	public void setPrecioprod(double precioprod) {
		this.precioprod = precioprod;
	}
	
	/**
	 * Establece la descripcion del producto.
	 * 
	 * @param Descripcionprod Descripcion del producto.
	 */

	public void setDescripcionprod(String descripcionprod) {
		this.descripcionprod = descripcionprod;
	}
	
	/**
	 * Reduce la cantidad disponible del producto cuando se realiza una venta.
	 * También actualiza el archivo de productos con la nueva cantidad.
	 * 
	 * @param cantidadVendida Cantidad de unidades vendidas.
	 * @throws ParseException Si hay un error en el formato numérico del archivo.
	 */

	public void venderProductos(int cantidadVendida) throws ParseException {
        if (cantidadVendida <= cantprod) {
            this.cantprod -= cantidadVendida;

            // Cargar productos, actualizar el stock del vendido y reescribir el archivo
            List<Producto> productos = cargarProductos();
            productos = productos.stream()
                    .map(p -> p.getCodigo() == this.codigo ? this : p)
                    .collect(Collectors.toList());

            try (BufferedWriter writer = new BufferedWriter(new FileWriter("productos.txt"))) {
                for (Producto p : productos) {
                    writer.write(String.format("%d,%s,%.2f,%d,%s",
                            p.getCodigo(),
                            p.getNombreprod(),
                            p.getPrecioprod(),
                            p.getCantprod(),
                            p.getDescripcionprod(),
                    		p.getNombreVendedor()));
                    writer.newLine();
                }
            } catch (IOException e) {
                System.out.println("Error al actualizar productos.");
            }
        } else {
            System.out.println("Stock insuficiente.");
        }
    }
	
	/**
	 * Actualiza la información del producto en el archivo "productos.txt".
	 * 
	 * @throws ParseException Si hay un error en el formato numérico del archivo.
	 */

	private void actualizarProductoEnArchivo() throws ParseException {
	    List<Producto> productos = cargarProductos();
	    try (BufferedWriter writer = new BufferedWriter(new FileWriter("productos.txt"))) {
	        for (Producto p : productos) {
	            writer.write(String.format(Locale.US, "%d,%s,%.2f,%d,%s,%s",
	                    p.getCodigo(),
	                    p.getNombreprod(),
	                    p.getPrecioprod(),
	                    p.getCantprod(),
	                    p.getDescripcionprod(),
	                    p.getNombreVendedor())); // 🔹 Formato asegurado con Locale.US
	            writer.newLine();
	        }
	    } catch (IOException e) {
	        System.out.println("Error al actualizar productos.");
	    }
	}
	
	/**
	 * Obtiene la lista de productos de un vendedor específico.
	 * 
	 * @param nombreVendedor Nombre del vendedor cuyos productos se desean obtener.
	 * @return Lista de productos del vendedor.
	 * @throws ParseException Si hay un error en el formato numérico del archivo.
	 */
	
    public static List<Producto> obtenerProductosPorUsuario(String nombreVendedor) throws ParseException {
        return cargarProductos().stream()
                .filter(p -> p.getNombreVendedor().equals(nombreVendedor))
                .collect(Collectors.toList());
    }
    	
    /**
     * Elimina un producto del archivo "productos.txt".
     * 
     * @param productoAEliminar Producto que se desea eliminar.
     * @throws ParseException Si hay un error en el formato numérico del archivo.
     */

    public static void eliminarProducto(Producto productoAEliminar) throws ParseException {
        List<Producto> productos = cargarProductos();
        
        // Verifica si el producto está en la lista antes de intentar eliminarlo
        boolean eliminado = productos.removeIf(p -> p.getCodigo() == productoAEliminar.getCodigo());

        if (!eliminado) {
            System.out.println("No se encontró el producto a eliminar.");
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("productos.txt", false))) { // Sobreescribe correctamente
            for (Producto p : productos) {
                writer.write(String.format(Locale.US, "%d,%s,%.2f,%d,%s,%s",
                        p.getCodigo(),
                        p.getNombreprod(),
                        p.getPrecioprod(),
                        p.getCantprod(),
                        p.getDescripcionprod(),
                        p.getNombreVendedor()));
                writer.newLine();
            }
            writer.flush(); // Asegura que los datos se escriben
        } catch (IOException e) {
            System.out.println("Error al actualizar productos: " + e.getMessage());
        }
    }
    
    /**
     * Carga la lista de productos desde el archivo "productos.txt".
     * 
     * @return Lista de productos disponibles.
     * @throws ParseException Si hay un error en el formato numérico del archivo.
     */

    public static List<Producto> cargarProductos() throws ParseException {
        List<Producto> productos = new ArrayList<>();
        File file = new File("productos.txt");
        if (!file.exists()) {
            return productos;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
            	line = line.trim();
                if (line.isEmpty()) continue; 
                String[] data = line.split(",");
                if (data.length == 6) {
                    int codigo = Integer.parseInt(data[0].trim());
                    String nombre = data[1].trim();
                    double precio = NumberFormat.getInstance(Locale.US).parse(data[2].trim()).doubleValue();
                    int cantidad = Integer.parseInt(data[3].trim());
                    String descripcion = data[4].trim();
                    String nombreVendedor = data[5].trim();

                    productos.add(new Producto(codigo, nombre, precio, cantidad, descripcion, nombreVendedor));
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error al cargar productos.");
        }
        return productos;
    }
    
    /**
     * Edita la información de un producto existente en el archivo.
     * 
     * @param codigo Código del producto a editar.
     * @param nuevoNombre Nuevo nombre del producto.
     * @param nuevoPrecio Nuevo precio del producto.
     * @param nuevaCantidad Nueva cantidad disponible del producto.
     * @param nuevaDescripcion Nueva descripción del producto.
     * @return true si el producto fue actualizado correctamente, false en caso contrario.
     * @throws ParseException Si hay un error en el formato numérico del archivo.
     */

    public static boolean editarProducto(int codigo, String nuevoNombre, double nuevoPrecio, int nuevaCantidad, String nuevaDescripcion) throws ParseException {
        List<Producto> productos = cargarProductos();
        boolean actualizado = false;

        for (int i = 0; i < productos.size(); i++) {
            Producto p = productos.get(i);
            if (p.getCodigo() == codigo) {
                productos.set(i, new Producto(codigo, nuevoNombre, nuevoPrecio, nuevaCantidad, nuevaDescripcion, p.getNombreVendedor()));
                actualizado = true;
                break;
            }
        }

        if (actualizado) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("productos.txt", false))) {
                for (Producto p : productos) {
                    writer.write(String.format(Locale.US, "%d,%s,%.2f,%d,%s,%s",
                            p.getCodigo(),
                            p.getNombreprod(),
                            p.getPrecioprod(),
                            p.getCantprod(),
                            p.getDescripcionprod(),
                            p.getNombreVendedor()));
                    writer.newLine();
                }
            } catch (IOException e) {
                System.out.println("Error al actualizar productos.");
            }
        }

        return actualizado;
    }
    
    private static List<Producto> productos = new ArrayList<>();
    
    /**
     * Recarga la lista de productos desde el archivo para reflejar cambios recientes.
     * 
     * @throws ParseException Si hay un error en el formato numérico del archivo.
     */

    public static void recargarProductos() throws ParseException {
        productos = cargarProductos();
    }
    
    /**
     * Verifica si un código de producto ya existe en la lista de productos.
     * 
     * @param codigo Código del producto a verificar.
     * @return true si el código existe, false en caso contrario.
     * @throws ParseException Si hay un error en el formato numérico del archivo.
     */

    public static boolean existeCodigo(int codigo) throws ParseException {
        List<Producto> productos = cargarProductos();
        for (Producto p : productos) {
            if (p.getCodigo() == codigo) {
                return true; // El código ya existe
            }
        }
        return false; // El código no existe
    }



}
