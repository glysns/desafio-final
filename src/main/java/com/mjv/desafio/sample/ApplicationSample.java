package com.mjv.desafio.sample;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.mjv.desafio.model.Cadastro;
import com.mjv.desafio.model.biblioteca.Livro;
import com.mjv.desafio.model.biblioteca.Locacao;
import com.mjv.desafio.model.biblioteca.LocacaoItem;

@Component
public class ApplicationSample {
	public void simularLocacao() {
		Cadastro cad = new Cadastro();
		cad.setNome("GLEYSON");
		
		
		Livro livro = new Livro();
		livro.setTitulo("HARRY POTTER");
		livro.setValorDiaria(1.5);
		livro.setExemplares(3);
		livro.setReservados(0);
		
		Livro livro2 = new Livro();
		livro2.setTitulo("STAR WARS");
		livro2.setValorDiaria(5.0);
		livro2.setExemplares(3);
		livro2.setReservados(0);
		
		
		Locacao loc = new Locacao();
		loc.setDataAgendamento(LocalDate.now());
		loc.setCadastro(cad);
		
		LocacaoItem item = new LocacaoItem();
		item.setLivro(livro);
		item.setValorDiaria(livro.getValorDiaria());
		item.setDiarias(1);
		item.setValorLocacao(item.getValorDiaria() * item.getDiarias());
		
		
		LocacaoItem item2 = new LocacaoItem();
		item2.setLivro(livro2);
		item2.setValorDiaria(livro2.getValorDiaria());
		item2.setDiarias(1);
		item2.setValorLocacao(item2.getValorDiaria() * item2.getDiarias());
		
		List<LocacaoItem> itens = new ArrayList<LocacaoItem>();
		itens.add(item);
		itens.add(item2);
		
		loc.setItens(itens);
		
		
		System.out.println(loc.getDataAgendamento());
		
		Double totalLocacao = 0.0;
		for(LocacaoItem i: loc.getItens()) {
			System.out.println(i.getLivro().getTitulo() 
							+ " " + i.getDiarias()
							+ " " + i.getValorDiaria()
							+ " " + i.getValorLocacao());
			
			totalLocacao=totalLocacao+i.getValorLocacao();
		}
		loc.setValorTotal(totalLocacao);
		
		System.out.println("O Valor total:" + loc.getValorTotal());
	}
}
