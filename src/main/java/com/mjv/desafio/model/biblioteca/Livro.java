package com.mjv.desafio.model.biblioteca;

public class Livro {
	private String titulo;
	private Double valorDiaria;
	private Integer exemplares;
	private Integer reservados;
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Double getValorDiaria() {
		return valorDiaria;
	}
	public void setValorDiaria(Double valorDiaria) {
		this.valorDiaria = valorDiaria;
	}
	public Integer getExemplares() {
		return exemplares;
	}
	public void setExemplares(Integer exemplares) {
		this.exemplares = exemplares;
	}
	public Integer getReservados() {
		return reservados;
	}
	public void setReservados(Integer reservados) {
		this.reservados = reservados;
	}
	
}
