package mjv.java.desafiofinal.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mjv.java.desafiofinal.model.Login;
import mjv.java.desafiofinal.model.Sessao;
import mjv.java.desafiofinal.service.LoginService;

@RestController
@RequestMapping(path = "/login")
public class LoginResource {
	@Autowired
	private LoginService service;
	@PostMapping
	public Sessao logar(@RequestBody Login login) {
		return service.logar(login);
	}
}
