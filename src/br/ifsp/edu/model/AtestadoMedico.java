package br.ifsp.edu.model;

import java.time.LocalDate;

public class AtestadoMedico {
	
	private long id;
	private Funcionario funcionario;
	private String cid;
	private LocalDate dataInicio;
	private long quantidadeDias;
	private String medico;
	private String crm;
	
	
	
	
	public AtestadoMedico(Funcionario funcionario, String cid, LocalDate dataInicio, long quantidadeDias, String medico,String crm) {
		this.funcionario = funcionario;
		this.cid = cid;
		this.dataInicio = dataInicio;
		this.quantidadeDias = quantidadeDias;
		this.medico = medico;
		this.crm = crm;
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public LocalDate getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}
	public long getQuantidadeDias() {
		return quantidadeDias;
	}
	public void setQuantidadeDias(long quantidadeDias) {
		this.quantidadeDias = quantidadeDias;
	}
	public String getMedico() {
		return medico;
	}
	public void setMedico(String medico) {
		this.medico = medico;
	}
	public String getCrm() {
		return crm;
	}
	public void setCrm(String crm) {
		this.crm = crm;
	}
	
	
	
	

}
