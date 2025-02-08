package Logica;

public class Comprador extends Usuario {
	
    private CarritoCompras carrito;

    public Comprador(String nombre, String usuario, String correo, String contraseña) {
        super(nombre, usuario, correo, contraseña);
        this.carrito = new CarritoCompras();
    }

    public CarritoCompras getCarrito() { return carrito; }

    
}