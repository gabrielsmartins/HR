package br.ifsp.edu.test.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.ifsp.edu.dao.PerfilDAO;
import br.ifsp.edu.model.Perfil;

class PerfilDAOTest {
	
	private static PerfilDAO perfilDAO;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		perfilDAO = new PerfilDAO();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		
	}
	
	@BeforeEach
	void setUp() throws Exception {
		perfilDAO.limparTabela();
	}
	
	

	@Test
	void salvarPerfil() {
		Perfil perfil = new Perfil("RH");
		assertNotNull(perfilDAO.salvar(perfil));
	}
	
	@Test
	void atualizarPerfil() {
		Perfil perfil = new Perfil("CONTABILIDADE");
		perfilDAO.salvar(perfil);
		perfil.setDescricao("RH");
		assertNotNull(perfilDAO.atualizar(perfil));
		
	}
	
	
	@Test
	void excluirPerfil() {
		Perfil perfil = new Perfil("CONTABILIDADE");
		perfilDAO.salvar(perfil);
		perfilDAO.excluir(perfil.getId());
	}
	
	@Test
	void listarPerfil() {
		Perfil perfil1 = new Perfil("CONTABILIDADE");
		Perfil perfil2 = new Perfil("RH");
		perfilDAO.salvar(perfil1);
		perfilDAO.salvar(perfil2);
		assertNotNull(perfilDAO.listar());
	}
	
	@Test
	void pesquisarPerfil() {
		Perfil perfil = new Perfil("CONTABILIDADE");
		perfilDAO.salvar(perfil);
		Perfil encontrado = perfilDAO.pesquisar(perfil.getId());
		assertEquals("CONTABILIDADE",encontrado.getDescricao());
		
	}

}
