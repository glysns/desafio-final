package com.mjv.desafio.dto;

import java.time.LocalDate;

public class LocacaoItemDto {
	private Integer idLivro;
	private LocalDate dataPrevisaoEntrega;
	public Integer getIdLivro() {
		return idLivro;
	}
	public void setIdLivro(Integer idLivro) {
		this.idLivro = idLivro;
	}
	public LocalDate getDataPrevisaoEntrega() {
		return dataPrevisaoEntrega;
	}
	public void setDataPrevisaoEntrega(LocalDate dataPrevisaoEntrega) {
		this.dataPrevisaoEntrega = dataPrevisaoEntrega;
	}
	
}
