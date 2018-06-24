package br.ifsp.edu.model;

import java.time.LocalDateTime;

public class Frequencia {
	
	private LocalDateTime dataHora;
	private Funcionario funcionario;
	
	
	public Frequencia(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	
	public LocalDateTime getDataHora() {
		return dataHora;
	}
	
	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	

}
