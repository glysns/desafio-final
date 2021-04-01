package com.mjv.desafio.dto;

import java.time.LocalDate;
import java.util.List;

public class LocacaoDto {
	private LocalDate dataAgendamento;
	private LocalDate dataRetirada;
	private Integer idCadastro;
	private List<LocacaoItemDto> itens;
	public LocalDate getDataRetirada() {
		return dataRetirada;
	}
	public void setDataRetirada(LocalDate dataRetirada) {
		this.dataRetirada = dataRetirada;
	}
	public LocalDate getDataAgendamento() {
		return dataAgendamento;
	}
	public void setDataAgendamento(LocalDate dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}
	public Integer getIdCadastro() {
		return idCadastro;
	}
	public void setIdCadastro(Integer idCadastro) {
		this.idCadastro = idCadastro;
	}
	public List<LocacaoItemDto> getItens() {
		return itens;
	}
	public void setItens(List<LocacaoItemDto> itens) {
		this.itens = itens;
	}
	
}
