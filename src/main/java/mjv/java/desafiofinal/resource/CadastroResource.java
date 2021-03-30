package mjv.java.desafiofinal.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mjv.java.desafiofinal.model.Cadastro;
import mjv.java.desafiofinal.repository.CadastroRepository;
import mjv.java.desafiofinal.service.CadastroService;

@RestController
@RequestMapping(path = "/cadastros")
public class CadastroResource {
	@Autowired
	private CadastroService service;
	
	@Autowired
	private CadastroRepository repository;
	
	@PostMapping
	public void post(@RequestBody Cadastro cadastro) {
		service.gravar(cadastro);
	}
	
	@GetMapping
	public Iterable<Cadastro> list(){
		return repository.findAll();
	}
}
