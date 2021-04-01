package com.mjv.desafio.services;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mjv.desafio.dto.LocacaoDto;
import com.mjv.desafio.dto.LocacaoItemDto;
import com.mjv.desafio.exception.config.RegistroNaoLocalizaoException;
import com.mjv.desafio.model.Cadastro;
import com.mjv.desafio.model.biblioteca.Livro;
import com.mjv.desafio.model.biblioteca.Locacao;
import com.mjv.desafio.model.biblioteca.LocacaoItem;
import com.mjv.desafio.repository.CadastroRepository;
import com.mjv.desafio.repository.LivroRepository;
import com.mjv.desafio.repository.LocacaoRepository;

@Service
public class LocacaoService {
	@Autowired
	private LocacaoRepository repository;
	
	@Autowired
	private CadastroRepository cadRepository;
	
	@Autowired
	private LivroRepository livroRepository;
	
	public void gerarLocacao(LocacaoDto dto) {
		Cadastro cad = cadRepository.findById(dto.getIdCadastro()).orElse(null);
		if(cad==null)
			throw new RegistroNaoLocalizaoException("Cadastro", dto.getIdCadastro());
		
		Locacao loc = new Locacao();
		
		loc.setDataAgendamento(dto.getDataAgendamento());
		loc.setCadastro(cad);
		loc.setDataRetirada(dto.getDataRetirada());
		
		for(LocacaoItemDto i: dto.getItens()) {
			i.getDataPrevisaoEntrega();
			
			Livro livro = livroRepository.findById(i.getIdLivro()).orElse(null);

			LocacaoItem item = new LocacaoItem();
			item.setLivro(livro);
			item.setDataPrevisaoEntrega(i.getDataPrevisaoEntrega());
			item.setValorDiaria(livro.getValorDiaria());
			item.setDiarias(calcularDiarias(loc.getDataRetirada(), i.getDataPrevisaoEntrega()));
			item.setValorLocacao(item.getValorDiaria() * item.getDiarias());
			
			loc.addItem(item);
			
			livro.incrementarReservado();
			
			livroRepository.save(livro);
		}
		
		repository.save(loc);
		
		
	
	}
	private Integer calcularDiarias(LocalDate dataRetirada, LocalDate dataPrevisaoEntrega) {
		Period period = Period.between(dataPrevisaoEntrega, dataRetirada);
	    int diff = Math.abs(period.getDays());
		return diff;
	}
}
