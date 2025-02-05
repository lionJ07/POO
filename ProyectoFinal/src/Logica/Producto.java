package Logica;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;

public class Producto {
	
    private int codigo;
    private String nombreprod;
    private double precioprod;
    private int cantprod;
    private String descripcionprod;

    public Producto(int codigo, String nombreprod, double precioprod, int cantprod, String descripcionprod) {
        this.codigo = codigo;
        this.nombreprod = nombreprod;
        this.precioprod = precioprod;
        this.cantprod = cantprod;
        this.descripcionprod = descripcionprod;
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

    public void venderProductos(int cantidadVendida) {
        if (cantidadVendida <= cantprod) {
            this.cantprod -= cantidadVendida;
            actualizarProductoEnArchivo();
        } else {
            System.out.println("Stock insuficiente.");
        }
    }

    private void actualizarProductoEnArchivo() {
        List<Producto> productos = cargarProductos();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("productos.txt"))) {
            for (Producto p : productos) {
                String linea = String.format("%d,%s,%.2f,%s",
                        p.getCodigo(),
                        p.getNombreprod(),
                        p.getPrecioprod(),
                        p.getDescripcionprod());
                writer.write(linea);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al actualizar productos.");
        }
    }



    public static List<Producto> cargarProductos() {
        List<Producto> productos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("productos.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(","); // Separa por comas
                if (data.length == 5) { // Verifica que haya 5 elementos
                    int codigo = Integer.parseInt(data[0].trim());
                    String nombre = data[1].trim();
                    double precio = Double.parseDouble(data[2].trim());
                    int cantidad = Integer.parseInt(data[3].trim()); // Se agrega la cantidad correctamente
                    String descripcion = data[4].trim();
                    productos.add(new Producto(codigo, nombre, precio, cantidad, descripcion)); 
                } else {
                    System.out.println("Formato incorrecto en línea: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar productos.");
        } catch (NumberFormatException e) {
            System.out.println("Error en el formato de los datos del archivo.");
        }
        return productos;
    }



}
