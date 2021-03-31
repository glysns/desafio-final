package com.mjv.desafio.exception.config;

public class CampoObrigatorioException extends BusinessException {

	public CampoObrigatorioException(String campo) {
		super("Campo Obrigatório: " + campo );
	}

}
