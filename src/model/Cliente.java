package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import exceptions.EmailInvalidoException;

public class Cliente {

	private String nome;
	private String cpf;
	private String email;
	private String senha;
	private int id;

	public Cliente() {
		super();

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", cpf=" + cpf + ", email=" + email + ", senha=" + senha + ", id=" + id + "]";
	}

	public Cliente(String nome, String cpf, String email, String senha, int id) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.senha = senha;
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) throws EmailInvalidoException {
		if (validaEmail(email)) {
			this.email = email;
		}else
			throw new EmailInvalidoException();

	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private boolean validaEmail(String email) {
		if (email != null && email.length() > 0) {
			String expression = "^[\\w\\.-\\_]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
			Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(email);
//	        if (matcher.matches()) {
//	            return true;
//	     }
			return matcher.matches();
		}
		return false;
	}

}
