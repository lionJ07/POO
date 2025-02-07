package Logica;

import java.io.*;
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

    // Nuevo constructor con nombre del vendedor
    public Producto(int codigo, String nombreprod, double precioprod, int cantprod, String descripcionprod, String nombreVendedor) {
        this.codigo = codigo;
        this.nombreprod = nombreprod;
        this.precioprod = precioprod;
        this.cantprod = cantprod;
        this.descripcionprod = descripcionprod;
        this.nombreVendedor = nombreVendedor;
    }
 // Getters y Setters
    public String getNombreVendedor() {
        return nombreVendedor;
    }

    public void setNombreVendedor(String nombreVendedor) {
        this.nombreVendedor = nombreVendedor;
    }
    public String getNombreprod() {
        return nombreprod;
    }

    public double getPrecioprod() {
        return precioprod;
    }

    public int getCantprod() {
        return cantprod;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescripcionprod() {
        return descripcionprod;
    }

    public void setCantprod(int cantprod) {
        this.cantprod = cantprod;
    }
    
    public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public void setNombreprod(String nombreprod) {
		this.nombreprod = nombreprod;
	}
	public void setPrecioprod(double precioprod) {
		this.precioprod = precioprod;
	}
	public void setDescripcionprod(String descripcionprod) {
		this.descripcionprod = descripcionprod;
	}
	public void venderProductos(int cantidadVendida) {
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
                            p.getDescripcionprod()));
                    		p.getNombreVendedor();
                    writer.newLine();
                }
            } catch (IOException e) {
                System.out.println("Error al actualizar productos.");
            }
        } else {
            System.out.println("Stock insuficiente.");
        }
    }


	private void actualizarProductoEnArchivo() {
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


    public static List<Producto> obtenerProductosPorUsuario(String nombreVendedor) {
        return cargarProductos().stream()
                .filter(p -> p.getNombreVendedor().equals(nombreVendedor))
                .collect(Collectors.toList());
    }
    
    public static void eliminarProducto(Producto productoAEliminar) {
        List<Producto> productos = cargarProductos();
        
        // Verifica si el producto está en la lista antes de intentar eliminarlo
        boolean eliminado = productos.removeIf(p -> p.getCodigo() == productoAEliminar.getCodigo());

        if (!eliminado) {
            System.out.println("No se encontró el producto a eliminar.");
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("productos.txt", false))) { // Sobreescribe correctamente
            for (Producto p : productos) {
                writer.write(String.format("%d,%s,%.2f,%d,%s,%s",
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




    public static List<Producto> cargarProductos() {
        List<Producto> productos = new ArrayList<>();
        File file = new File("productos.txt");

        if (!file.exists()) {
            return productos;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 6) {
                    int codigo = Integer.parseInt(data[0].trim());
                    String nombre = data[1].trim();
                    double precio = Double.parseDouble(data[2].trim().replace(",", ".")); // 🔹 Asegurar que usa punto
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

    
    public static boolean editarProducto(int codigo, String nuevoNombre, double nuevoPrecio, int nuevaCantidad, String nuevaDescripcion) {
        List<Producto> productos = cargarProductos();
        boolean actualizado = false;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("productos.txt", false))) { // Sobreescribe el archivo
            for (Producto p : productos) {
                if (p.getCodigo() == codigo) {
                    p = new Producto(codigo, nuevoNombre, nuevoPrecio, nuevaCantidad, nuevaDescripcion, p.getNombreVendedor());
                    actualizado = true;
                }
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

        return actualizado;
    }


}
