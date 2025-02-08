/**
 * @JulianaSofiaLopez
 * @LeonardoAlejandroGuio
 * @version1.0, Febrero 10,2025 
 * Este programa es una ecommerce que le permite al usuario entrar como vendedor y comprador 
 */
package Logica;

public class Comprador extends Usuario {
	
    private CarritoCompras carrito;

    public Comprador(String nombre, String usuario, String correo, String contraseña) {
        super(nombre, usuario, correo, contraseña);
        this.carrito = new CarritoCompras();
    }

    public CarritoCompras getCarrito() { return carrito; }

    
}