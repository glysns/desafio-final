package com.mjv.desafio.repository;

import org.springframework.data.repository.CrudRepository;

import com.mjv.desafio.model.biblioteca.Livro;

public interface LivroRepository extends CrudRepository<Livro, Integer> {

}
