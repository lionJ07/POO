package Logica;

public class Producto {
	
	private String nombreprod;
	private double precioprod;
	private double cantprod;
	private String descripcionprod;
	private double cantvendido;
	
	Producto(String nombreprod, double precioprod, double cantprod, String descripcionprod){
	
		this.nombreprod = nombreprod;
		this.precioprod = precioprod;
		this.cantprod = cantprod;
		this.descripcionprod = descripcionprod;
		this.cantvendido = 0.0;
	}

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
	
	public boolean venderProductos(int cantidad) {
		if(cantprod >= cantidad) {
			cantprod -= cantidad;
			cantvendido += cantidad;
			return true;
		} return false;
	}
	public double calcularventas() {
		return cantvendido * precioprod;
	}
	public void calcularInv(int nuevacant) {
		this.cantprod = nuevacant;
	}
}
