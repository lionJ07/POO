package Logica;

import java.util.List;

class Transaccion {
	
    private Comprador comprador;
    private List<Producto> productos;
    private double total;

    public Transaccion(Comprador comprador, List<Producto> productos, double total) {
        this.comprador = comprador;
        this.productos = productos;
        this.total = total;
    }

    public void procesar() {
        System.out.println("Procesando transacción de: " + comprador.getNombre() + " por $" + total);
        for (Producto p : productos) {
            p.venderProductos(1);
        }
    }
}