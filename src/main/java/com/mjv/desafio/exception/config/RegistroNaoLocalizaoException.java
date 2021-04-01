package com.mjv.desafio.exception.config;

public class RegistroNaoLocalizaoException extends BusinessException {
	public RegistroNaoLocalizaoException(String entidade, Object id) {
		super("%s não localizado pelo Id %s ", entidade, id.toString());
	}
}
