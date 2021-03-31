package com.mjv.desafio.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Login {

	@Column(nullable = false, unique = true, length = 20)
	private String usuario;
	@Column(nullable = false)
	private String senha;

	public Login() {
	}

	public Login(String usuario, String senha) {
		this.usuario = usuario;
		this.senha = senha;
	}

	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Login usuario=" + usuario + "\nSenha=" + senha;
	}

}
