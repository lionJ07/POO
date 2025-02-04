/**
 * Este programa es una ecommerce que le permite al usuario entrar como vendedor y comprador 
 * @JulianaSofiaLopez
 * @LeonardoAlejandroGuio
 * @version1.0, Febrero 10,2025 
 */
package Logica;

import java.util.ArrayList;
import java.util.List;

public class Vendedor extends Usuario {
	private List<Producto> productos;
	private double balanceTotal;
	
	public List<Producto> getProductos() {
		return productos;
	}
	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	public double getBalanceTotal() {
		return balanceTotal;
	}
	public void setBalanceTotal(double balanceTotal) {
		this.balanceTotal = balanceTotal;
	}
	Vendedor(String nombre,String usuario, String correo, String contraseña) {
		super(nombre, usuario, correo, contraseña);
		this.balanceTotal = 0.0;
		this.productos = new ArrayList<>();
	}
	// Método para agregar producto
	   public void agregarProducto(String nombreprod, double precioprod, double cantprod, String descripcionprod) {
	        Producto producto = new Producto(nombreprod, precioprod, cantprod, descripcionprod);
	        productos.add(producto);
	        System.out.println("Producto agregado: " + producto.getNombreprod());
	    }
	   // Método para eliminar producto 
	    public void eliminarProducto(String nombreProducto) {
	        productos.removeIf(p -> p.getNombreprod().equalsIgnoreCase(nombreProducto));
	        System.out.println("Producto eliminado: " + nombreProducto);
	    }
	    // Método para editar producto
	    public void editarProducto(String nombreProducto, String nuevoNombre, double nuevoPrecio, double nuevaCantidad, String nuevaDescripcion) {
	        for (Producto producto : productos) {
	            if (producto.getNombreprod().equalsIgnoreCase(nombreProducto)) {
	                producto.setNombreprod(nuevoNombre);
	                producto.setPrecioprod(nuevoPrecio);
	                producto.setCantprod(nuevaCantidad);
	                producto.setDescripcionprod(nuevaDescripcion);
	                System.out.println("Producto editado exitosamente.");
	                return;
	            }
	        }
	        System.out.println("Producto no encontrado.");
	    }
	    // Método para mostrar blance 
	    public void mostrarBalance() {
	        System.out.println("Balance total: $" + balanceTotal);
	        for (Producto producto : productos) {
	            System.out.println("Producto: " + producto.getNombreprod() + ", Ventas: $" + producto.calcularventas());
	        }
	    }
	    // Método para registrar ventas 
	    public void registrarVenta(String nombreProducto, int cantidadVendida) {
	        for (Producto producto : productos) {
	            if (producto.getNombreprod().equalsIgnoreCase(nombreProducto)) {
	                producto.venderProductos(cantidadVendida);
	                balanceTotal += producto.getPrecioprod() * cantidadVendida;
	                return;
	            }
	        }
	        System.out.println("Producto no encontrado.");
	    }

}
