package Logica;

public class Producto {
	// Declarar variables 
	private String nombreprod;
	private double precioprod;
	private double cantprod;
	private String descripcionprod;
	private double cantvendido;
	// Constructor
	Producto(String nombreprod, double precioprod, double cantprod, String descripcionprod){
		this.nombreprod = nombreprod;
		this.precioprod = precioprod;
		this.cantprod = cantprod;
		this.descripcionprod = descripcionprod;
		this.cantvendido = 0.0;
	}
	// Get y Set
	public String getNombreprod() {
		return nombreprod;
	}

	public void setNombreprod(String nombreprod) {
		this.nombreprod = nombreprod;
	}

	public double getPrecioprod() {
		return precioprod;
	}

	public void setPrecioprod(double precioprod) {
		this.precioprod = precioprod;
	}

	public double getCantprod() {
		return cantprod;
	}

	public void setCantprod(double cantprod) {
		this.cantprod = cantprod;
	}

	public String getDescripcionprod() {
		return descripcionprod;
	}

	public void setDescripcionprod(String descripcionprod) {
		this.descripcionprod = descripcionprod;
	}

	public double getCantvendido() {
		return cantvendido;
	}

	public void setCantvendido(double cantvendido) {
		this.cantvendido = cantvendido;
	}
	// Método para Vender productos 
	public boolean venderProductos(int cantidad) {
		if(cantprod >= cantidad) {
			cantprod -= cantidad;
			cantvendido += cantidad;
			return true;
		} return false;
	}
	// Método para calcular ventas 
	public double calcularventas() {
		return cantvendido * precioprod;
	}
	// Método para calcular inventario
	public void calcularInv(int nuevacant) {
		this.cantprod = nuevacant;
	}
}
