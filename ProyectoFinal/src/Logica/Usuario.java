package Logica;

public abstract class Usuario {

	private String nombre;
	private String usuario;
	private String contraseña;
	private String correo;
	
	
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getContraseña() {
		return contraseña;
	}


	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public Usuario(String nombre,String usuario, String correo,	String contraseña) {
		this.nombre= nombre;
		this.usuario = usuario;
		this.correo = correo;
		this.contraseña = contraseña;
	}

}
