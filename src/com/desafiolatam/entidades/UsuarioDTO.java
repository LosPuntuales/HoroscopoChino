package com.desafiolatam.entidades;

public class UsuarioDTO {
	private int idUsuario;
	private String nombre;
	private String contraseña;
	
	
	
	public UsuarioDTO() {
	}

	public UsuarioDTO(int idUsuario, String nombre, String contrasena) {
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.contraseña = contrasena;
	}

	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
	

}
