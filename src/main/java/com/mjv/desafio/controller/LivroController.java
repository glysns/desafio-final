package com.mjv.desafio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mjv.desafio.model.biblioteca.Livro;
import com.mjv.desafio.repository.LivroRepository;

@RestController
@RequestMapping(path = "/livros")
public class LivroController {
	@Autowired
	private LivroRepository repository;
	
	@PostMapping
	public Integer post(@RequestBody Livro body) {
		return repository.save(body).getId();
	}
	@GetMapping
	public Iterable<Livro> get() {
		return repository.findAll();
	}
}
