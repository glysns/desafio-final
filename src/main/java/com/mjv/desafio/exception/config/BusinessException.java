package com.mjv.desafio.exception.config;

public class BusinessException extends RuntimeException {
	public BusinessException(String mensagem) {
		super(mensagem);
	}
	public BusinessException(String mensagem, Object ... params) {
		super(String.format(mensagem, params));
	}
	
	public static void main(String[] args) {
		//String.format
		Integer id = 123;
		String tabela = "Livro";
		
		
		BusinessException bu = new BusinessException("%s não localizado pelo Id %s ",tabela,id.toString());
		
		System.out.println(bu.getMessage());
	}
}
