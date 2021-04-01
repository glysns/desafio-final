package com.mjv.desafio.repository;

import org.springframework.data.repository.CrudRepository;

import com.mjv.desafio.model.biblioteca.Locacao;

public interface LocacaoRepository extends CrudRepository<Locacao, Integer> {

}
