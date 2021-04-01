package com.mjv.desafio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mjv.desafio.model.biblioteca.Locacao;
import com.mjv.desafio.repository.LocacaoRepository;

@RestController
@RequestMapping(path = "/locacoes")
public class LocacaoController {
	@Autowired
	private LocacaoRepository repository;
	
	@PostMapping
	public Integer post(@RequestBody Locacao body) {
		return repository.save(body).getId();
	}
}
