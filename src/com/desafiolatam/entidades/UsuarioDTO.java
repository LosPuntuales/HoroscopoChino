package com.desafiolatam.entidades;

public class UsuarioDTO {
	private int idUsuario;
	private String nombre;
	private String pass;
	
	
	
	public UsuarioDTO() {
	}

	public UsuarioDTO(int idUsuario, String nombre, String pass) {
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.pass = pass;
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
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	

}
