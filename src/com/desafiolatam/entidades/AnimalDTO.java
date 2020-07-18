package com.desafiolatam.entidades;

public class AnimalDTO {
	private int idAnimal;
	private String Descripcion;
	private int indice;

	public AnimalDTO(int idAnimal, String descripcion, int indice) {
		this.idAnimal = idAnimal;
		Descripcion = descripcion;
		this.indice = indice;
	}

	public AnimalDTO() {

	}

	public int getIdAnimal() {
		return idAnimal;
	}

	public void setIdAnimal(int idAnimal) {
		this.idAnimal = idAnimal;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public int getIndice() {
		return indice;
	}

	public void setIndice(int indice) {
		this.indice = indice;
	}
	
	
}
