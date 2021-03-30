package mjv.java.desafiofinal.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mjv.java.desafiofinal.model.Cadastro;
import mjv.java.desafiofinal.model.Login;
import mjv.java.desafiofinal.repository.CadastroRepository;
import mjv.java.desafiofinal.service.CadastroService;

@Component
public class ApplicationSample {
	@Autowired
	private CadastroRepository cadastroRepository;
	
	@Autowired
	private CadastroService service;
	//VALIDADA
	public void usuarioPadrao() {
		Cadastro c = new Cadastro();
		Login login = new Login();
		login.setUsuario("gso");
		login.setSenha("gso123");
		c.setLogin(login);
	
		service.gravar(c);
	}
	
}
