package br.ifsp.edu.model;

public class Funcionario {
	
	private long matricula;
	private String nome;
	private String cargo;
	private Perfil perfil;
	private String login;
	private String senha;
	
	
	public Funcionario(long matricula, String nome, String cargo,Perfil perfil,String login,String senha) {
		this.matricula = matricula;
		this.nome = nome;
		this.cargo = cargo;
		this.perfil = perfil;
		this.login = login;
		this.senha = senha;
	}


	public long getMatricula() {
		return matricula;
	}


	public void setMatricula(long matricula) {
		this.matricula = matricula;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCargo() {
		return cargo;
	}


	public void setCargo(String cargo) {
		this.cargo = cargo;
	}


	public Perfil getPerfil() {
		return perfil;
	}


	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	

}
