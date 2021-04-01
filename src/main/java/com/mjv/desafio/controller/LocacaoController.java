package com.mjv.desafio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mjv.desafio.dto.LocacaoDto;
import com.mjv.desafio.services.LocacaoService;

@RestController
@RequestMapping(path = "/locacoes")
public class LocacaoController {
	@Autowired
	private LocacaoService service;
	
	@PostMapping
	public void post(@RequestBody LocacaoDto body) {
		service.gerarLocacao(body);
	}
}
