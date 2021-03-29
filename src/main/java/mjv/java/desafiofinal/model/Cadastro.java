package mjv.java.desafiofinal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tab_cadastro")
public class Cadastro {
	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	private Integer id;
	private String login;
	public Integer getId() {
		return id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
}
