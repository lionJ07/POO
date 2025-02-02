package Logica;

import java.util.ArrayList;
import java.util.List;

public class CarritoCompras {
    private List<Producto> productos;

    public CarritoCompras() {
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public void vaciarCarrito() {
        productos.clear();
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public double getTotal() {
        return productos.stream().mapToDouble(Producto::getPrecioprod).sum();
    }
}