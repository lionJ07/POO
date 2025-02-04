package Logica;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

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
                writer.write(p.getCodigo() + "," + p.getNombreprod() + "," + p.getPrecioprod() + "," + (p.getCodigo() == this.codigo ? this.cantprod : p.getCantprod()) + "," + p.getDescripcionprod() + "\n");
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
                String[] data = line.split(",");
                int codigo = Integer.parseInt(data[0]);
                String nombre = data[1];
                double precio = Double.parseDouble(data[2]);
                int cantidad = Integer.parseInt(data[3]);
                String descripcion = data[4];
                productos.add(new Producto(codigo, nombre, precio, cantidad, descripcion));
            }
        } catch (IOException e) {
            System.out.println("Error al cargar productos.");
        }
        return productos;
    }
}
