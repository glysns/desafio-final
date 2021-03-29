package mjv.java.desafiofinal.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mjv.java.desafiofinal.model.Cadastro;
import mjv.java.desafiofinal.model.Livro;
import mjv.java.desafiofinal.repository.CadastroRepository;

@Component
public class ApplicationSample {
	@Autowired
	private CadastroRepository cadastroRepository;
	//VALIDADA
	public void cadastroSample() {
		
	}
	public Cadastro buscarCadastro() {
		Cadastro cad = cadastroRepository.findById(1).orElse(null);
		if(cad==null) {
			cadastroSample();
			cad = cadastroRepository.findById(1).orElse(null);
		}
		
		return cad;
	}
	public void fazerLocacaoLivro() {
		Livro livro = new Livro();
		
	}
}
