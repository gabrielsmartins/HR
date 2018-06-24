package br.ifsp.edu.model;

public class Perfil {
	
	private long id;
	private String descricao;
	
	
	public Perfil(String descricao) {
		this.descricao = descricao;
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	

}
