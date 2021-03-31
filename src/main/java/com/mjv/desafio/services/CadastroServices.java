package com.mjv.desafio.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mjv.desafio.dto.CadastroDto;
import com.mjv.desafio.model.Cadastro;
import com.mjv.desafio.model.Endereco;
import com.mjv.desafio.repository.CadastroRepository;

@Service
//@RequiredArgsConstructor
public class CadastroServices {
	
	//@Autowired
	//private ViaCEPClient viaCepClient;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private CadastroRepository cadastroRepository;
	
	
	public List<Cadastro> listAll(){
        return cadastroRepository.findAll();
    }
	
	public Cadastro findById(Integer id){
        return cadastroRepository.findById(id).orElse(null);
    }
	public Cadastro save(CadastroDto dto) {
		//ResteTemplate
		Cadastro cadastro = new Cadastro();
		cadastro.setCpf(dto.getCpf());
		cadastro.setEmail(dto.getEmail());
		cadastro.setLogin(dto.getLogin());
		cadastro.setNome(dto.getNome());
		cadastro.setTelefone(dto.getTelefone());
		//Endereco end = viaCepClient.buscaEnderecoPor(dto.getCep());
		
		RestTemplate template = new RestTemplate();
        Endereco end= template.getForObject("https://viacep.com.br/ws/{cep}/json",Endereco.class, dto.getCep());
        
		cadastro.setEndereco(end);
		return save(cadastro);
	}
	public Cadastro save(Cadastro cadastro) {
		String senhaCriptografada =encoder.encode(cadastro.getLogin().getSenha());
		cadastro.getLogin().setSenha(senhaCriptografada);
		
		return cadastroRepository.save(cadastro);
	}
	
	public void delete(Integer id) {
        cadastroRepository.delete(findById(id));
    }

}
