package com.mjv.desafio.model.biblioteca;

import java.time.LocalDate;
import java.util.List;

import com.mjv.desafio.model.Cadastro;

public class Locacao {
	private Integer id;
	private LocalDate dataAgendamento;
	private LocalDate dataRetirada;
	private LocalDate dataFinalizacao;
	private List<LocacaoItem> itens;
	private Cadastro cadastro;
	private Double valorTotal;
	public Double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public void setCadastro(Cadastro cadastro) {
		this.cadastro = cadastro;
	}
	public Cadastro getCadastro() {
		return cadastro;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDate getDataAgendamento() {
		return dataAgendamento;
	}
	public void setDataAgendamento(LocalDate dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}
	public LocalDate getDataRetirada() {
		return dataRetirada;
	}
	public void setDataRetirada(LocalDate dataRetirada) {
		this.dataRetirada = dataRetirada;
	}
	public LocalDate getDataFinalizacao() {
		return dataFinalizacao;
	}
	public void setDataFinalizacao(LocalDate dataFinalizacao) {
		this.dataFinalizacao = dataFinalizacao;
	}
	public List<LocacaoItem> getItens() {
		return itens;
	}
	public void setItens(List<LocacaoItem> itens) {
		this.itens = itens;
	}
	
	
}
