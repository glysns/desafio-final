package com.mjv.desafio.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mjv.desafio.model.Cadastro;

public interface CadastroRepository extends JpaRepository<Cadastro, Integer> {
	Cadastro findByLoginUsuario(String usuario);
}
