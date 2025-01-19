package Logica;

public class Vendedor implements Usuario {
	private String nombre;
	private String usuario;
	private String correo;
	private String contraseña;
	public Vendedor (String nombre, String usuario, String correo, String contraseña) {
		this.contraseña = contraseña;
		this.nombre = nombre;
		this.correo = correo;
		this.usuario = usuario;
		
	}

}
