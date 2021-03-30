package mjv.java.desafiofinal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import mjv.java.desafiofinal.model.Cadastro;
import mjv.java.desafiofinal.repository.CadastroRepository;

@Service
public class CadastroService {
	@Autowired
	private CadastroRepository repository;
	
	@Autowired
	private PasswordEncoder encoder;
	public void gravar(Cadastro cadastro) {
		if(cadastro==null)
			System.out.println("O cadastro não pode ser nulo");

		String senhaCriptografada =encoder.encode(cadastro.getLogin().getSenha());
		cadastro.getLogin().setSenha(senhaCriptografada);
		repository.save(cadastro);
	}
}
