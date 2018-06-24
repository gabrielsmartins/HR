package br.ifsp.edu.model;

public class Sessao{
	   private static Sessao instance = null;
	   private Funcionario funcionario;
	   private Sessao(){
	   }
	   
	   
	   public void setFuncionario(Funcionario funcionario){
	      this.funcionario = funcionario;
	   }
	   
	   
	   public Funcionario getFuncionario(){
	       return funcionario;
	   }
	   
	   public static Sessao getInstance(){
	         if(instance == null){
	               instance = new Sessao();
	         }
	        return instance;
	   }
	}