package mjv.java.desafiofinal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mjv.java.desafiofinal.model.Cadastro;
import mjv.java.desafiofinal.repository.CadastroRepository;

@Service
public class CadastroService {
	@Autowired
	private CadastroRepository repository;
	public void gravar(Cadastro cadastro) {
		if(cadastro==null)
			System.out.println("O cadastro não pode ser nulo");
		
		String login = cadastro.getLogin();
		
		if(login == null || login.length() > 20)
			System.out.println("O login não pode ser nulo e nem ter 20 caracteres");
		
		repository.save(cadastro);
	}
}
