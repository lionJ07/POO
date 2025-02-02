package Logica;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Producto {
    private String nombreprod;
    private double precioprod;
    private int cantprod;
    private String descripcionprod;

    public Producto(String nombreprod, double precioprod, int cantprod, String descripcionprod) {
        this.nombreprod = nombreprod;
        this.precioprod = precioprod;
        this.cantprod = cantprod;
        this.descripcionprod = descripcionprod;
    }

    public String getNombreprod() { return nombreprod; }
    public double getPrecioprod() { return precioprod; }
    public int getCantprod() { return cantprod; }
    public String getDescripcionprod() { return descripcionprod; }

    public void setCantprod(int cantprod) { this.cantprod = cantprod; }

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
                writer.write(p.getNombreprod() + "," + p.getPrecioprod() + "," + (p.getNombreprod().equals(this.nombreprod) ? this.cantprod : p.getCantprod()) + "," + p.getDescripcionprod() + "\n");
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
                productos.add(new Producto(data[0], Double.parseDouble(data[1]), Integer.parseInt(data[2]), data[3]));
            }
        } catch (IOException e) {
            System.out.println("Error al cargar productos.");
        }
        return productos;
    }
}
