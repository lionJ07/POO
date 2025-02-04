package Logica;

public class Comprador extends Usuario {
	
    private CarritoCompras carrito;

    public Comprador(String nombre, String usuario, String correo, String contraseña) {
        super(nombre, usuario, correo, contraseña);
        this.carrito = new CarritoCompras();
    }

    public CarritoCompras getCarrito() { return carrito; }

    public void comprar() {
        Transaccion transaccion = new Transaccion(this, carrito.getProductos(), carrito.getTotal());
        transaccion.procesar();
        carrito.vaciarCarrito();
    }
}