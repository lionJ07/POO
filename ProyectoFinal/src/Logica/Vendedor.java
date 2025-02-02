package Logica;

import java.util.ArrayList;
import java.util.List;
import java.io.*;
class Vendedor extends Usuario {
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
            writer.write(producto.getNombreprod() + "," + producto.getPrecioprod() + "," + producto.getCantprod() + "," + producto.getDescripcionprod() + "\n");
        } catch (IOException e) {
            System.out.println("Error al guardar el producto.");
        }
    }
}


