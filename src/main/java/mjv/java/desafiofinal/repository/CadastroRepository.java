package mjv.java.desafiofinal.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import mjv.java.desafiofinal.model.Cadastro;
//https://docs.spring.io/spring-data/jpa/docs/1.5.0.RELEASE/reference/html/jpa.repositories.html
public interface CadastroRepository extends CrudRepository<Cadastro, Integer> {
	//queryMethods
	Cadastro findByLoginUsuario(String usuario);
	
	//JPQL
	@Query(value = "SELECT c FROM Cadastro c WHERE c.login.usuario = :usuario") // ou por indice ?
	Cadastro buscarPorLogin(@Param("usuario") String usuario);
	
}
