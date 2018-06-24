package br.ifsp.edu.test.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.ifsp.edu.dao.AtestadoMedicoDAO;
import br.ifsp.edu.dao.FuncionarioDAO;
import br.ifsp.edu.dao.PerfilDAO;
import br.ifsp.edu.model.AtestadoMedico;
import br.ifsp.edu.model.Funcionario;
import br.ifsp.edu.model.Perfil;

class AtestadoMedicoDAOTest {

	private static FuncionarioDAO funcionarioDAO;
	private static PerfilDAO perfilDAO;
	private static AtestadoMedicoDAO atestadoMedicoDAO;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		funcionarioDAO = new FuncionarioDAO();
		perfilDAO = new PerfilDAO();
		atestadoMedicoDAO = new AtestadoMedicoDAO();
		
	}
	
	@BeforeEach
	void setUp() throws Exception {
		funcionarioDAO.limparTabela();
		perfilDAO.limparTabela();
		atestadoMedicoDAO.limparTabela();
	}
	


	@Test
	void registrarAtestado() {
		Perfil perfil = new Perfil("RH");
		perfilDAO.salvar(perfil);
		Funcionario funcionario = new Funcionario(12345, "JOAO", "ANL REC HUMAN", perfil, "joao", "12345");
		funcionarioDAO.salvar(funcionario);
		AtestadoMedico atestadoMedico = new AtestadoMedico(funcionario, "J150", LocalDate.now(), 5, "JOAO", "500.33");
		atestadoMedicoDAO.registrar(atestadoMedico);
	}
	
	@Test
	void excluirAtestado() {
		Perfil perfil = new Perfil("RH");
		perfilDAO.salvar(perfil);
		Funcionario funcionario = new Funcionario(12345, "JOAO", "ANL REC HUMAN", perfil, "joao", "12345");
		funcionarioDAO.salvar(funcionario);
		AtestadoMedico atestadoMedico = new AtestadoMedico(funcionario, "J150", LocalDate.now(), 5, "JOAO", "500.33");
		atestadoMedicoDAO.registrar(atestadoMedico);
		atestadoMedicoDAO.excluir(atestadoMedico.getId());
	}
	
	
	@Test
	void listarAtestado() {
		Perfil perfil = new Perfil("RH");
		perfilDAO.salvar(perfil);
		Funcionario funcionario = new Funcionario(12345, "JOAO", "ANL REC HUMAN", perfil, "joao", "12345");
		funcionarioDAO.salvar(funcionario);
		AtestadoMedico atestadoMedico1 = new AtestadoMedico(funcionario, "J150", LocalDate.now(), 5, "JOAO", "500.33");
		AtestadoMedico atestadoMedico2 = new AtestadoMedico(funcionario, "F200", LocalDate.now(), 5, "JOAO", "500.33");
		atestadoMedicoDAO.registrar(atestadoMedico1);
		atestadoMedicoDAO.registrar(atestadoMedico2);
		List<AtestadoMedico> atestados = atestadoMedicoDAO.listar();
		assertEquals(2, atestados.size());
		
	}

}
