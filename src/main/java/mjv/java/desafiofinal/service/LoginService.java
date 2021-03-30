package mjv.java.desafiofinal.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import mjv.java.desafiofinal.config.JWTConstants;
import mjv.java.desafiofinal.config.JWTUtils;
import mjv.java.desafiofinal.model.Cadastro;
import mjv.java.desafiofinal.model.Login;
import mjv.java.desafiofinal.model.Sessao;
import mjv.java.desafiofinal.repository.CadastroRepository;

@Service
public class LoginService {
	@Autowired
	private CadastroRepository repository;
	
	@Autowired
	private PasswordEncoder encoder;
	
	public Sessao logar(Login login) {
		
		Cadastro usuario = repository.findByLoginUsuario(login.getUsuario());
		if(usuario!=null) {
			
			boolean senhaOk = encoder.matches(login.getSenha(),usuario.getLogin().getSenha());
			
			if(senhaOk) {
				Sessao sessao = new Sessao();
				sessao.setLogin(login.getUsuario());
				
				Date inicio = new Date(System.currentTimeMillis());
				Date fim = new Date(System.currentTimeMillis() + JWTConstants.TOKEN_EXPIRATION);
				
				sessao.setDataInicio(inicio);
				sessao.setDataFim(fim);
				
				String token= JWTUtils.creteToken(login.getUsuario(), inicio, fim);
				
				sessao.setToken(token);
				return sessao;
			}else {
				throw new RuntimeException("Senha inválida");
			}
			
			
		}
		
		throw new RuntimeException("Login inválido");
	}
}
