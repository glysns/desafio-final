package com.mjv.desafio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mjv.desafio.dto.Sessao;
import com.mjv.desafio.model.Login;
import com.mjv.desafio.services.LoginService;

@RestController
@RequestMapping(path = "/login")
public class LoginController {
	@Autowired
	private LoginService service;
	@PostMapping
	public Sessao logar(@RequestBody Login login) {
		return service.logar(login);
	}
}