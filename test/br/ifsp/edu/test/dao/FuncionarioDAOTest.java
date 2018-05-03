package br.ifsp.edu.test.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.ifsp.edu.dao.FuncionarioDAO;
import br.ifsp.edu.dao.PerfilDAO;
import br.ifsp.edu.model.Funcionario;
import br.ifsp.edu.model.Perfil;

class FuncionarioDAOTest {
	
	private static FuncionarioDAO funcionarioDAO;
	private static PerfilDAO perfilDAO;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		funcionarioDAO = new FuncionarioDAO();
		perfilDAO = new PerfilDAO();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		
	}
	
	@BeforeEach
	void setUp() throws Exception {
		funcionarioDAO.limparTabela();
		perfilDAO.limparTabela();
	}
	
	

	@Test
	void salvarFuncionario() {
		Perfil perfil = new Perfil("RH");
		perfilDAO.salvar(perfil);
		Funcionario funcionario = new Funcionario(12345, "JOAO", "ANL REC HUMAN", perfil, "joao", "12345");
		assertNotNull(funcionarioDAO.salvar(funcionario));
	}
	
	
	@Test
	void atualizarFuncionario() {
		Perfil perfil = new Perfil("RH");
		perfilDAO.salvar(perfil);
		Funcionario funcionario = new Funcionario(12345, "JOAO", "ANL REC HUMAN", perfil, "joao", "12345");
	funcionarioDAO.salvar(funcionario);
	funcionario.setNome("MARIA");
		assertNotNull(funcionarioDAO.atualizar(funcionario));
		
	}
	
	
	@Test
	void excluirPerfil() {
		Perfil perfil = new Perfil("RH");
		perfilDAO.salvar(perfil);
		Funcionario funcionario = new Funcionario(12345, "JOAO", "ANL REC HUMAN", perfil, "joao", "12345");
		funcionarioDAO.salvar(funcionario);
		funcionarioDAO.excluir(funcionario.getMatricula());
	}
	
	@Test
	void listarPerfil() {
		Perfil perfil = new Perfil("RH");
		perfilDAO.salvar(perfil);
		Funcionario funcionario1 = new Funcionario(12345, "JOAO", "ANL REC HUMAN", perfil, "joao", "12345");
		Funcionario funcionario2 = new Funcionario(45678, "MARIA", "ANL REC HUMAN", perfil, "maria", "12345");
		funcionarioDAO.salvar(funcionario1);
		funcionarioDAO.salvar(funcionario2);
		assertNotNull(funcionarioDAO.listar());
	}
	
	@Test
	void pesquisarPerfil() {
		Perfil perfil = new Perfil("RH");
		perfilDAO.salvar(perfil);
		Funcionario funcionario = new Funcionario(12345, "JOAO", "ANL REC HUMAN", perfil, "joao", "12345");
		funcionarioDAO.salvar(funcionario);
		Funcionario encontrado = funcionarioDAO.pesquisar(funcionario.getMatricula());
		assertEquals("JOAO",encontrado.getNome());
		
	}
	
	
	@Test
	void autenticarFuncionario() {
		Perfil perfil = new Perfil("RH");
		perfilDAO.salvar(perfil);
		Funcionario funcionario = new Funcionario(12345, "JOAO", "ANL REC HUMAN", perfil, "joao", "12345");
		funcionarioDAO.salvar(funcionario);
		Funcionario encontrado = funcionarioDAO.autenticar(funcionario.getLogin(), funcionario.getSenha());
		assertNotNull(encontrado);
		
	}

}
