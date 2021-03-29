package mjv.java.desafiofinal.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mjv.java.desafiofinal.model.Cadastro;
import mjv.java.desafiofinal.service.CadastroService;

@RestController
@RequestMapping(path = "/cadastros")
public class CadastroResource {
	@Autowired
	private CadastroService service;
	
	@PostMapping
	public void post(@RequestBody Cadastro cadastro) {
		service.gravar(cadastro);
	}
}
