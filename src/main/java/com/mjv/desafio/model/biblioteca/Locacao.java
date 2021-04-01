package com.mjv.desafio.model.biblioteca;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.mjv.desafio.model.Cadastro;

@Entity
@Table(name = "locacao")
public class Locacao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private LocalDate dataAgendamento;
	private LocalDate dataRetirada;
	private LocalDate dataFinalizacao;
	@OneToMany(mappedBy = "locacao", cascade = CascadeType.PERSIST)
	private List<LocacaoItem> itens =  new ArrayList<LocacaoItem>();
	@ManyToOne
	@JoinColumn(name = "id_cadastro")
	private Cadastro cadastro;
	private Double valorTotal = 0.0;
	
	public void addItem(LocacaoItem item) {
		item.setLocacao(this);
		this.valorTotal = this.valorTotal + item.getValorLocacao();
		itens.add(item);
	}
	
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
